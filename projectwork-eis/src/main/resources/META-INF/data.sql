INSERT INTO role(code, description, dateinsertion, usernameinsertion)VALUES ('USER','simple user','2018-02-13 00:00:00','giacompa');
INSERT INTO role(code, description, dateinsertion, usernameinsertion)VALUES ('ADMIN','admin user','2018-02-13 00:00:00','giacompa');
INSERT INTO userrole(username,role_code,dateinsertion, usernameinsertion)VALUES ('giacompa','USER','2018-02-13 00:00:00','giacompa');
INSERT INTO security(username,password,dateinsertion,usernameinsertion)values('giacompa','giacompa','2018-02-13 00:00:00','giacompa');
INSERT INTO userx(username, usernamemodification, address, city, postcode, email, timebirth,dateinsertion, usernameinsertion) VALUES ('giacompa','2018-02-13 00:00:00','via tommaso marcellini 5','Palermo','90135','giancarlo.compagno@eng.it','1976-09-08','2018-02-13 00:00:00','giacompa');

INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 1', '2018-02-13 00:00:00','giacompa');
INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 2', '2018-02-13 00:00:00','giacompa');
INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 3', '2018-02-13 00:00:00','giacompa');
INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 4', '2018-02-13 00:00:00','giacompa');
INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 5', '2018-02-13 00:00:00','giacompa');
INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 6', '2018-02-13 00:00:00','giacompa');
INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 7', '2018-02-13 00:00:00','giacompa');
INSERT INTO product(oid,descrition,dateinsertion, usernameinsertion)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 8', '2018-02-13 00:00:00','giacompa');
            


INSERT INTO supplier(oid, info, dateinsertion, usernameinsertion)VALUES (nextval('SUPPLIER_ID_SEQ'), 'SUPPLIER 1','2018-02-13 00:00:00','giacompa');
INSERT INTO supplier(oid, info, dateinsertion, usernameinsertion)VALUES (nextval('SUPPLIER_ID_SEQ'), 'SUPPLIER 2','2018-02-13 00:00:00','giacompa');
INSERT INTO supplier(oid, info, dateinsertion, usernameinsertion)VALUES (nextval('SUPPLIER_ID_SEQ'), 'SUPPLIER 3','2018-02-13 00:00:00','giacompa');
INSERT INTO supplier(oid, info, dateinsertion, usernameinsertion)VALUES (nextval('SUPPLIER_ID_SEQ'), 'SUPPLIER 4','2018-02-13 00:00:00','giacompa');
INSERT INTO supplier(oid, info, dateinsertion, usernameinsertion)VALUES (nextval('SUPPLIER_ID_SEQ'), 'SUPPLIER 5','2018-02-13 00:00:00','giacompa');
INSERT INTO supplier(oid, info, dateinsertion, usernameinsertion)VALUES (nextval('SUPPLIER_ID_SEQ'), 'SUPPLIER 6','2018-02-13 00:00:00','giacompa');
INSERT INTO supplier(oid, info, dateinsertion, usernameinsertion)VALUES (nextval('SUPPLIER_ID_SEQ'), 'SUPPLIER 7','2018-02-13 00:00:00','giacompa');
