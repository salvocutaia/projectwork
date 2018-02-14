INSERT INTO role(code, description)VALUES ('USER','simple user');
INSERT INTO role(code, description)VALUES ('ADMIN','admin user');

INSERT INTO userrole(username,role_code)VALUES ('giacompa','USER');
INSERT INTO userrole(username,role_code)VALUES ('giacompa','ADMIN');
INSERT INTO userrole(username,role_code)VALUES ('lugraci','USER');

INSERT INTO security(username,password)values('giacompa','giacompa');
INSERT INTO security(username,password)values('lugraci','lugraci');

INSERT INTO userx(username, address, city, postcode, email, timebirth) VALUES ('giacompa','via tommaso marcellini 5','Palermo','90135','giancarlo.compagno@eng.it','1976-09-08');
INSERT INTO userx(username, address, city, postcode, email, timebirth) VALUES ('lugraci' ,'via tommaso marcellini 5','Palermo','90135','luigi.graci@eng.it','1982-09-08');

INSERT INTO supplier(username,info)values('giacompa','Info fatturazione');

INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 1');
INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 2');
INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 3');
INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 4');
INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 5');
INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 6');
INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 7');
INSERT INTO product(oid,descrition)VALUES (nextval('PRODUCT_ID_SEQ'), 'Product 8');