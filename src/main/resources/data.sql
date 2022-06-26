INSERT INTO doctor(paternal_surname, maternal_surname, speciality)
    VALUES("Jimenez", "Pinos", "Internal Medicine"),
          ("Suarez", "Rodriguez", "Otorhinolaryngology"),
          ("Mendez", "Vasquez", "Neumology"),
          ("Daniels", "Rivera", "Dermatology"),
          ("Melendez", "Avila", "Pediatrics");

INSERT INTO medical_office(office_number, floor)
    VALUES(100,1),
          (101,1),
          (200,2),
          (201,2),
          (300,3),
          (301,3);

INSERT INTO appointment(doctor_id, medical_office_id, date_time, patient_name)
    VALUES(1, 1, '2022-10-05 09:00:00', "Jose Jimenez"),
          (1, 1, '2022-11-17 11:00:00', "Daniel Alvarez"),
          (2, 2, '2022-10-02 13:00:00', "Alberto Dominguez"),
          (2, 2, '2022-09-05 14:00:00', "Linda Arce"),
          (3, 3, '2022-10-05 08:00:00', "Manuel Andres"),
          (3, 3, '2022-10-05 09:00:00', "Josue Juarez"),
          (4, 4, '2022-10-05 07:00:00', "Daniela Aviles"),
          (4, 4, '2022-10-05 08:00:00', "Laura Ibarra"),
          (5, 5, '2022-10-05 12:00:00', "Juan Leonidas"),
          (5, 5, '2022-10-05 13:00:00', "Karen Palomares");

