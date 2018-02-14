cd /d %~dp0
cd 
wsimport -d ../projectwork-ws-signature/src/main/java -keep ./src/main/webapp/WEB-INF/wsdl/auction_services_01.01.wsdl
pause 