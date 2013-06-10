-- Apache Derby schema init:
-- CONNECT 'jdbc:derby://localhost:1527/client-catalog;create=true';

drop table client_company;
drop table client_private_person;
drop table client;


create table client (client_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
                        client_type INT NOT NULL,
                        description VARCHAR(200),
                        company_name VARCHAR(200),
                        first_name VARCHAR(200),
                        last_name VARCHAR(200),
                        CONSTRAINT CLIENT_PK PRIMARY KEY(client_id));

-- COMMENTED VERSION FOR USE IN FUTURE
-- create table client (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT CLIENT_PK PRIMARY KEY,
--                         client_type INT NOT NULL,
--                         description VARCHAR(200));
create table client_company (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT CLIENT_COMPANY_PK PRIMARY KEY,                        
                        company_name VARCHAR(200),
                         client_id INT NOT NULL,
                         FOREIGN KEY (client_id) REFERENCES client (client_id) ON DELETE CASCADE ON UPDATE RESTRICT);
 
 create table client_private_person (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT CLIENT_PRIVATE_PERSON_PK PRIMARY KEY,                        
                         first_name VARCHAR(100),
                         last_name VARCHAR(100),
                         client_id INT NOT NULL,
                         FOREIGN KEY (client_id) REFERENCES client (client_id) ON DELETE CASCADE ON UPDATE RESTRICT);

CREATE SEQUENCE client_sequence AS BIGINT START WITH 3000000000;