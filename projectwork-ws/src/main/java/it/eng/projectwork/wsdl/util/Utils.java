package it.eng.projectwork.wsdl.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.activation.DataHandler;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.IOUtils;

public class Utils {
	
	
	
	public static byte[] toByteArray(DataHandler dataHandler){
		try {
			return IOUtils.toByteArray(dataHandler.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param tt date value to converter
	 * @return javax.xml.datatype.XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar getXMLGregorianCalendar(Date tt) {
	    if(tt!=null){
	    try{
	        XMLGregorianCalendar value = null;           
	        GregorianCalendar gc = new GregorianCalendar();
	        gc.setTimeInMillis(tt.getTime());
	        value = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	        value.setTimezone(0);
	        return value;
	    }catch(Exception e){
	        throw new RuntimeException(e);
	    }
	    }
	    return null;
	}
	
	/**
	 * @param tt date value to converter
	 * @return javax.xml.datatype.XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar getXMLGregorianCalendar(Timestamp tt) {
	    if(tt!=null){
	    try{
	        XMLGregorianCalendar value = null;           
	        GregorianCalendar gc = new GregorianCalendar();
	        gc.setTimeInMillis(tt.getTime());
	        value = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	        value.setTimezone(0);
	        return value;
	    }catch(Exception e){
	        throw new RuntimeException(e);
	    }
	    }
	    return null;
	}

	/**
	 *
	 * @param tt gregorian value to converter
	 * @return java.util.Date
	 */
	public static Date getDate(XMLGregorianCalendar tt) {
	    if(tt!=null){
	        try{
	            return tt.toGregorianCalendar().getTime();
	        }catch(Exception e){
	            throw new RuntimeException(e);
	        }
	    }
	    return null;
	}
	
	/**
	 *
	 * @param tt gregorian value to converter
	 * @return java.sql.Timestamp
	 */
	public static Timestamp getTimestamp(XMLGregorianCalendar tt) {
	    if(tt!=null){
	        try{
	            return new Timestamp(tt.toGregorianCalendar().getTimeInMillis());
	        }catch(Exception e){
	            throw new RuntimeException(e);
	        }
	    }
	    return null;
	}

}
