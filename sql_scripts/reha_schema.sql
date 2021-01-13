CREATE SCHEMA IF NOT EXISTS reha DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE reha;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS person;
CREATE TABLE person (
                        id_person INT AUTO_INCREMENT NOT NULL,
                        name VARCHAR(45) NOT NULL,
                        last_name VARCHAR(45) NOT NULL,
                        gender ENUM('MALE', 'FEMALE') NOT NULL,
                        role ENUM('ROLE_PATIENT', 'ROLE_NURSE', 'ROLE_DOCTOR', 'ROLE_ADMIN') NOT NULL DEFAULT 'ROLE_PATIENT',
                        username VARCHAR(50) NULL DEFAULT NULL,
                        email VARCHAR(50) NULL DEFAULT NULL,
                        password VARCHAR(100) NULL DEFAULT NULL,
                        enabled TINYINT(1) NOT NULL DEFAULT 1,
                        id_insurance VARCHAR(45) NULL DEFAULT NULL,
                        PRIMARY KEY (id_person));

DROP TABLE IF EXISTS treatment;
CREATE TABLE treatment (
                           id_treatment INT NOT NULL AUTO_INCREMENT,
                           id_doctor INT NOT NULL,
                           id_person INT NOT NULL,
                           diagnosis VARCHAR(200) NULL DEFAULT NULL,
                           started DATE NOT NULL,
                           ended DATE NULL DEFAULT NULL,
                           PRIMARY KEY (id_treatment),
                           FOREIGN KEY (id_doctor) REFERENCES person (id_person),
                           FOREIGN KEY (id_person) REFERENCES person (id_person));

DROP TABLE IF EXISTS assignment;
CREATE TABLE assignment (
                            id_assignment INT NOT NULL AUTO_INCREMENT,
                            id_treatment INT NOT NULL,
                            type ENUM('MEDICATION', 'PROCEDURE') NOT NULL,
                            name VARCHAR(45) NOT NULL,
                            pattern_quantity INT NOT NULL,
                            pattern_howlong INT NOT NULL,
                            pattern_timeframe ENUM('HOUR', 'DAY', 'WEEK', 'MONTH') NOT NULL DEFAULT 'DAY',
                            started DATE NOT NULL,
                            expired DATE NULL DEFAULT NULL,
                            comments VARCHAR(200) NULL DEFAULT NULL,
                            PRIMARY KEY (id_assignment),
                            FOREIGN KEY (id_treatment) REFERENCES treatment (id_treatment));


DROP TABLE IF EXISTS medevent;
CREATE TABLE med_event (
                          id_med_event INT AUTO_INCREMENT NOT NULL,
                          id_assignment INT NOT NULL,
                          starts DATETIME NOT NULL,
                          status ENUM('PENDING', 'SCHEDULED', 'DONE', 'CANCELED') NOT NULL,
                          id_nurse INT NOT NULL,
                          PRIMARY KEY (id_med_event),
                          FOREIGN KEY (id_assignment) REFERENCES assignment (id_assignment),
                          FOREIGN KEY (id_nurse) REFERENCES person(id_person));

SET foreign_key_checks = 1;
