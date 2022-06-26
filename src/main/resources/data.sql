INSERT INTO doctor(paternal_surname, maternal_surname, first_name, middle_name, speciality)
    VALUES("Jimenez", "Pinos", "Luis", "Abraham", "Internal Medicine"),
          ("Suarez", "Rodriguez", "Daniel", "Ariel", "Otorhinolaryngology"),
          ("Mendez", "Vasquez", "Rodrigo", "Daniel", "Neumology"),
          ("Daniels", "Rivera", "Luis", "Miguel", "Dermatology"),
          ("Melendez", "Avila", "Laura",  "Lizbeth", "Pediatrics");

INSERT INTO patient(paternal_surname, maternal_surname, first_name, middle_name, social_security_number)
    VALUES("Arce", "Pinos", "Daniel", "Manuel", "423-53-6346"),
          ("Hernandez", "Garcia", "Lucas", "Leonardo", "634-57-4857"),
          ("Martinez", "Lopez", "Alejandro", "Manuel", "243-13-2547"),
          ("Gonzalez", "Perez", "Arturo", "Mateo", "356-24-4657"),
          ("Rodriguez", "Sanchez", "Daniela", "Luz", "232-53-3656"),
          ("Torres", "Reyes", "Carolina", "Andrea", "536-68-4645"),
          ("Bajonero", "Zepeda", "Ailyn", "Ximena", "576-35-2412"),
          ("Zuniga", "Hernandez", "Claudia", "Laura", "354-13-5346"),
          ("Romo", "Arce", "Lizeth", "Diana", "423-57-6864"),
          ("Corral", "Verdugo", "Luisa", "Fernanda", "534-57-2446");


INSERT INTO medical_office(office_number, floor)
    VALUES(100,1),
          (101,1),
          (200,2),
          (201,2),
          (300,3),
          (301,3);

INSERT INTO appointment(doctor_id, patient_id, medical_office_id, date_time)
    VALUES(1, 1,  1,  '2022-10-05 09:00:00'),
          (1, 2,  1,  '2022-11-17 11:00:00'),
          (2, 3,  2,  '2022-10-02 13:00:00'),
          (2, 4,  2,  '2022-09-05 14:00:00'),
          (3, 5,  3,  '2022-10-05 08:00:00'),
          (3, 6,  3,  '2022-10-05 09:00:00'),
          (4, 7,  4,  '2022-10-05 07:00:00'),
          (4, 8,  4,  '2022-10-05 08:00:00'),
          (5, 9,  5,  '2022-10-05 12:00:00'),
          (5, 10, 5,  '2022-10-05 13:00:00');

