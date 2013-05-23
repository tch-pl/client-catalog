-- Apache Derby schema init:
-- CONNECT 'jdbc:derby://localhost:1527/client-catalog;create=true';

create table client (id INT NOT NULL PRIMARY KEY,
                        client_type INT NOT NULL,
                        description VARCHAR(200));

create table client_company (id INT NOT NULL PRIMARY KEY,                        
                        company_name VARCHAR(200),
                        client_id INT NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES client (id));

create table client_private_person (id INT NOT NULL PRIMARY KEY,                        
                        first_name VARCHAR(100),
                        last_name VARCHAR(100),
                        client_id INT NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES client (id));