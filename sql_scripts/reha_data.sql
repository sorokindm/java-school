
-- hashed password value is "admin"
insert into reha.user (id_user,username,password,role,email) values
(1,'admin','$2y$12$eo/tk5k2rC7IiDOdp5yWpOruP2/3Yy6/DCpQHMigDI.3CAUmzsV6q','ROLE_ADMIN','admin@admin.com');
insert into reha.med_staff (name,last_name,gender,specialty,id_user) values ('adminName','adminLastName','MALE'
,'System Administrator',1);