DROP TABLE IF EXISTS CUSTOMERS; 
CREATE TABLE CUSTOMERS (ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 0)NOT NULL PRIMARY KEY,
                        DATA varchar(255) NOT NULL);
                        
INSERT INTO CUSTOMERS (DATA) VALUES ('data0');

INSERT INTO CUSTOMERS(DATA) VALUES ('data1');

INSERT INTO CUSTOMERS(DATA) VALUES ('data2');

INSERT INTO CUSTOMERS(DATA) VALUES ('data3');