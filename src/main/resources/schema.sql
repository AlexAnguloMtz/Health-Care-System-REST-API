DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS medical_office;


CREATE TABLE doctor(
    id INT NOT NULL AUTO_INCREMENT,
    paternal_surname VARCHAR(40) NOT NULL,
    maternal_surname VARCHAR(40) NOT NULL,
    speciality VARCHAR(30) NOT NULL,
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
    medical_office_id INT NOT NULL,
    doctor_id INT NOT NULL,
    date_time DATETIME NOT NULL,
    patient_name VARCHAR(80) NOT NULL,
    FOREIGN KEY (medical_office_id)
            REFERENCES medical_office(id),
    FOREIGN KEY (doctor_id)
        REFERENCES doctor(id),
    PRIMARY KEY(id)
) ENGINE=INNODB;