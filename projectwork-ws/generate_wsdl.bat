cd /d %~dp0
cd 
wsimport -d ../projectwork-ws-signature/src/main/java -keep ./src/main/resources/META-INF/wsdl/auction_services_01.01.wsdl
pause 