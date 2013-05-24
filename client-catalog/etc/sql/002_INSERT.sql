-- Apache Derby schema init:
-- CONNECT 'jdbc:derby://localhost:1527/client-catalog;create=true';

VALUES (NEXT VALUE FOR client_sequence);
insert into client(client_type, description, first_name, last_name, company_name) values (2,'pierwszy klient','','','BlueServices');
insert into client(client_type, description, first_name, last_name, company_name) values (1,'zleceniobiorca','Tomasz','Chrul','tch@76-200.dev');
-- insert into client_private_person(first_name, last_name, client_id) values ('TOmasz','Chrul', CURRENT VALUE FOR client_sequence);
-- insert into client(client_type, description) values(2,'pierwsza firma');
--insert into client_company(company_name, client_id) values ('BLUE SERVICES', CURRENT VALUE FOR client_sequence);

