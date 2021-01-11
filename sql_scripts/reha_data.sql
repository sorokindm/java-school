
-- hashed password value is "admin"
insert into person (name,last_name,gender,role,username,email,password) values
('testname1','testlastname1','MALE','ROLE_ADMIN','admin','admin@admin.com','$2y$12$eo/tk5k2rC7IiDOdp5yWpOruP2/3Yy6/DCpQHMigDI.3CAUmzsV6q');

/*
insert into users (username,password,enabled) values ('admin','admin','1');
insert into authorities(username,authority) values ('admin','ROLE_ADMIN');
*/