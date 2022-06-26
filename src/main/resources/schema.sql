DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS medical_office;


CREATE TABLE patient(
    id INT NOT NULL AUTO_INCREMENT,
    social_security_number VARCHAR(11) NOT NULL,
    paternal_surname VARCHAR(40) NOT NULL,
    maternal_surname VARCHAR(40) NOT NULL,
    first_name VARCHAR(40) NOT NULL,
    middle_name VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
)  ENGINE=INNODB;

CREATE TABLE doctor(
    id INT NOT NULL AUTO_INCREMENT,
    speciality VARCHAR(30) NOT NULL,
    paternal_surname VARCHAR(40) NOT NULL,
    maternal_surname VARCHAR(40) NOT NULL,
    first_name VARCHAR(40) NOT NULL,
    middle_name VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
)  ENGINE=INNODB;

CREATE TABLE medical_office(
    id INT NOT NULL AUTO_INCREMENT,
    office_number INT NOT NULL,
    floor INT NOT NULL,
    PRIMARY KEY(id)
) ENGINE=INNODB;

CREATE TABLE appointment(
    id INT NOT NULL AUTO_INCREMENT,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    medical_office_id INT NOT NULL,
    date_time DATETIME NOT NULL,
    FOREIGN KEY (doctor_id)
        REFERENCES doctor(id),
    FOREIGN KEY (patient_id)
        REFERENCES patient(id),
    FOREIGN KEY (medical_office_id)
        REFERENCES medical_office(id),
    PRIMARY KEY(id)
) ENGINE=INNODB;