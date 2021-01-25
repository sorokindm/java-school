-- hashed password value is "admin"
insert into reha.user (id_user, username, password, role, email)
values (1, 'admin', '$2y$12$eo/tk5k2rC7IiDOdp5yWpOruP2/3Yy6/DCpQHMigDI.3CAUmzsV6q', 'ROLE_ADMIN', 'admin@admin.com');
insert into reha.med_staff (name, last_name, gender, specialty, id_user)
values ( 'adminName', 'adminLastName', 'MALE', 'System Administrator', 1);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (2, 'doctor', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_DOCTOR',
        'doctor@doctor.com');
insert into reha.med_staff (name, last_name, gender, specialty, id_user)
values ( 'doctorName', 'doctorLastName', 'FEMALE', 'Therapist', 2);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (3, 'nurse', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_NURSE',
        'nurse@nurse.com');
insert into reha.med_staff (name, last_name, gender, specialty, id_user)
values ( 'nurseName', 'nurseLastName', 'FEMALE', 'Senior Nurse', 3);

-- hashed password value is "password"
insert into reha.user (id_user, username, password, role, email)
values (4, 'patient', '$2y$12$UbeQr9/x/ZOJVdJo9ll1w.dyhEq/IVNLrP2Dt7wdfldBWPTPK2UJO', 'ROLE_PATIENT',
        'patient@patient.com');
insert into reha.patient (name, last_name, gender, id_insurance, id_user)
values ( 'patientName', 'patientLastName', 'MALE', 'qwerty12345', 4);