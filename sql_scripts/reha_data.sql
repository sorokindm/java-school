-- hashed password value is "admin"
insert into reha.user (id_user, username, password, role, email)
values (1, 'admin', '$2y$12$eo/tk5k2rC7IiDOdp5yWpOruP2/3Yy6/DCpQHMigDI.3CAUmzsV6q', 'ROLE_ADMIN', 'admin@admin.com');
insert into reha.med_staff (name, last_name, gender, specialty, id_user)
values ( 'Петр', 'Петров', 'MALE', 'System Administrator', 1);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (2, 'doctor', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_DOCTOR',
        'doctor@doctor.com');
insert into reha.med_staff (name, last_name, gender, specialty, id_user)
values ( 'Иван', 'Иванов', 'FEMALE', 'Therapist', 2);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (3, 'nurse', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_NURSE',
        'nurse@nurse.com');
insert into reha.med_staff (name, last_name, gender, specialty, id_user)
values ( 'Александра', 'Александрова', 'FEMALE', 'Senior Nurse', 3);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (4, 'nurse2', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_NURSE',
        'nurse2@nurse.com');
insert into reha.med_staff (name, last_name, gender, specialty, id_user)
values ( 'Елена', 'Ленина', 'FEMALE', 'Senior Nurse', 4);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (5, 'patient', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_PATIENT',
        'patient@patient.com');
insert into reha.patient (name, last_name, gender, id_insurance, id_user)
values ( 'Федор', 'Федоров', 'MALE', 'qwerty12345', 5);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (6, 'patient2', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_PATIENT',
        'patient2@patient.com');
insert into reha.patient (name, last_name, gender, id_insurance, id_user)
values ( 'Мария', 'Машина', 'MALE', 'qwerty54321', 6);