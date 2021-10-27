DROP DATABASE Amv;
CREATE DATABASE Amv;
USE Amv;

-- Tabellstruktur for ansatte

CREATE TABLE ansatt
(
    ansatt_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    password VARCHAR(60) NOT NULL,
    fornavn VARCHAR(30) NOT NULL,
    etternavn VARCHAR(60) NOT NULL,
    email VARCHAR(40) NOT NULL,
    adresse VARCHAR(40) NOT NULL,
    mobil VARCHAR(30) NOT NULL,
    administrator TINYINT(1),
    unionn TINYINT(1)
);

INSERT INTO ansatt (ansatt_id, password, fornavn, etternavn, email, adresse, mobil, administrator, unionn)
values (1, '12345', 'Haakon', 'Kristiansen', 'haakon@mail.no', 'Universitetet 1', '47346424', 1, 1),
       (2, '1234', 'Aleksander', 'Kolsrud', 'aleksander@mail.no', 'Universitetet 3', '99887766', 0, 1),
       (3, '123', 'Mahmoud', 'Kasem', 'mahmoud@mail.no', 'Stavangerveien 2', '99778866', 0, 1),
       (4, '123', 'Dlir', 'Sharo', 'dlir@mail.no', 'Kristiansandgata 12', '88997766', 0, 1),
       (5, '123', 'Dana', 'D. Omar', 'dana@mail.no', 'Kristiansandgata 8', '77886699', 0, 1),
       (6, '123', 'Magnus', 'Erga', 'magnus@mail.no', 'Oslovika 7', '88667799', 0, 1),
       (7, '123', 'Ole', 'Bjørnar', 'ole@mail.no', 'Lærergata 6', '77556644', 1, 1),
       (8, '123', 'Terje', 'Lærer', 'terjer@mail.no', 'Lærergata 3', '77559944', 0, 1),
       (9, '123', 'Svein', 'Nilsen', 'svein@mail.no', 'Gateveien 1', '55664477', 0, 1),
       (10, '123', 'Kari', 'Karlsen', 'kari@mail.no', 'Veiengata 2', '66774499', 0, 1);

-- Tabellstruktur for utstyr type

CREATE TABLE utstyr_type
(
    utstyr_type_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    utstyr_navn VARCHAR(40) NOT NULL
);
INSERT INTO utstyr_type (utstyr_navn)
values
    ('Lastebil'),
    ('Spikerpistol Milwuakee'),
    ('Strømaggregat'),
    ('Personløfter'),
    ('Skruautomat'),
    ('Fein Multimaskin'),
    ('Eksentersliper 230 VAC'),
    ('9" Vinkelsliper, stein'),
    ('Flisekutter'),
    ('Vinkelsliper'),
    ('Båndsliper 230 VAC');

-- Tabellstruktur for utstyr

CREATE TABLE utstyr
(
    utstyr_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
    utstyr_type_id INT NOT NULL,
    utstyr_navn VARCHAR(40) NOT NULL ,
    leie_kostnad DECIMAL(5,2),
    status BOOLEAN NOT NULL ,
    bruk_info VARCHAR(100),
    CONSTRAINT FK_utstyr_utstyr_type
        FOREIGN KEY (utstyr_type_id) REFERENCES utstyr_type(utstyr_type_id)
);
INSERT INTO utstyr (utstyr_type_id, utstyr_navn, leie_kostnad, status, bruk_info)
VALUES (2, 'Spikerpistol Milwaukee liten', 20, true, ''),
       (2, 'Spikerpistol Milwaukee mellom', 20, true, ''),
       (2, 'Spikerpistol Milwaukee stor', 20, false, ''),
       (3, 'Strømaggregat 3,7 kW', 50, true, ''),
       (4, 'Personløfter 230 VAC (12m)', 100, true, 'Krever sikkerhetsopplæring'),
       (5,'Skruautomat',20,true,'ingen opplæring'),
       (6,'Fein Multimaskin',20,true,'ingen opplæring'),
       (7,'Eksentersliper 230 VAC',20,true,''),
       (8,' Flisekutter, keramiske fliser, stein',20,true,''),
       (9,' Vinkelsliper, stein',20,true,''),
       (10,'Båndsliper 230 VAC',20,true,'');

-- Tabellstruktur for leiekontrakt

CREATE TABLE leie_kontrakt
(
    leie_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ansatt_id INT NOT NULL ,
    utstyr_id INT NOT NULL ,
    start_leie_dato DATE NOT NULL ,
    tilbake_dato DATE NOT NULL,
    betalt TINYINT (1),
    total_kostnad DECIMAL(5,2),
    tilstandsvurdering VARCHAR(60),
    CONSTRAINT FK_ansatt_leie_kontrakt
        FOREIGN KEY (ansatt_id) REFERENCES ansatt(ansatt_id),

    CONSTRAINT FK_utstyr_leie_kontrakt
        FOREIGN KEY (utstyr_id) REFERENCES utstyr(utstyr_id)
);
INSERT INTO leie_kontrakt (ansatt_id, utstyr_id, start_leie_dato, tilbake_dato, betalt, total_kostnad, tilstandsvurdering)
VALUES
    (1,1,'2021,10,22','2021,10,23',false,0,'bra tilstand '),
    (2,5,'2021,10,15','2021,10,22',false,254.50,'bra tilstand '),
    (3,4,'2021,10,21','2021,10,22',false,40,'bra tilstand '),
    (4,10,'2021,10,18','2021,10,22',false,70,'bra tilstand '),
    (5,1,'2021,10,15','2021,10,28',false,254.50,'bra tilstand '),
    (6,2,'2021,11,15','2021,12,22',false,254.50,'bra tilstand '),
    (7,7,'2021,10,15','2021,10,22',false,254.50,'bra tilstand '),
    (8,8,'2021,10,15','2021,10,22',false,254.50,'bra tilstand '),
    (9,6,'2021,10,15','2021,10,22',false,254.50,'bra tilstand '),
    (10,9,'2021,10,15','2021,10,22',false,254.50,'bra tilstand ');


SELECT * FROM ansatt;
SELECT * FROM utstyr_type;
SELECT * FROM utstyr;
SELECT * FROM leie_kontrakt;
SELECT tilbake_dato - start_leie_dato as total_dager FROM leie_kontrakt,utstyr ;
