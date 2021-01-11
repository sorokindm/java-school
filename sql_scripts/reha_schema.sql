CREATE SCHEMA IF NOT EXISTS reha DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE reha;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS person;
CREATE TABLE person (
                        idperson INT AUTO_INCREMENT NOT NULL,
                        name VARCHAR(45) NOT NULL,
                        last_name VARCHAR(45) NOT NULL,
                        gender ENUM('MALE', 'FEMALE') NOT NULL,
                        role ENUM('ROLE_PATIENT', 'ROLE_NURSE', 'ROLE_DOCTOR', 'ROLE_ADMIN') NOT NULL DEFAULT 'ROLE_PATIENT',
                        username VARCHAR(50) NULL DEFAULT NULL,
                        email VARCHAR(50) NULL DEFAULT NULL,
                        password VARCHAR(100) NULL DEFAULT NULL,
                        enabled TINYINT(1) NOT NULL DEFAULT 1,
                        idinsurance VARCHAR(45) NULL DEFAULT NULL,
                        PRIMARY KEY (idperson));

DROP TABLE IF EXISTS treatment;
CREATE TABLE treatment (
                           idtreatment INT NOT NULL AUTO_INCREMENT,
                           idcurator INT NOT NULL,
                           idperson INT NOT NULL,
                           diagnosis VARCHAR(200) NULL DEFAULT NULL,
                           started DATE NOT NULL,
                           ended DATE NULL DEFAULT NULL,
                           PRIMARY KEY (idtreatment),
                           FOREIGN KEY (idcurator) REFERENCES person (idperson),
                           FOREIGN KEY (idperson) REFERENCES person (idperson));

DROP TABLE IF EXISTS assignment;
CREATE TABLE assignment (
                            idassignment INT NOT NULL AUTO_INCREMENT,
                            idtreatment INT NOT NULL,
                            type ENUM('MEDICATION', 'PROCEDURE') NOT NULL,
                            name VARCHAR(45) NOT NULL,
                            pattern_quantity INT NULL DEFAULT NULL,
                            pattern_howlong INT NULL DEFAULT NULL,
                            pattern_timeframe ENUM('HOUR', 'DAY', 'WEEK', 'MONTH') NOT NULL DEFAULT 'DAY',
                            started DATE NOT NULL,
                            expired DATE NULL DEFAULT NULL,
                            comments VARCHAR(200) NULL DEFAULT NULL,
                            PRIMARY KEY (idassignment),
                            FOREIGN KEY (idtreatment) REFERENCES treatment (idtreatment));


DROP TABLE IF EXISTS medevent;
CREATE TABLE medevent (
                          idmedevent INT AUTO_INCREMENT NOT NULL,
                          idassignment INT NOT NULL,
                          starts DATETIME NOT NULL,
                          status ENUM('PENDING', 'SCHEDULED', 'DONE', 'CANCELED') NOT NULL,
                          idexecutor INT NOT NULL,
                          PRIMARY KEY (idmedevent),
                          FOREIGN KEY (idassignment) REFERENCES assignment (idassignment),
                          FOREIGN KEY (idexecutor) REFERENCES person(idperson));

/*
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY(username)
  );

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY(username) REFERENCES users(username)
  );
  */
SET foreign_key_checks = 1;
