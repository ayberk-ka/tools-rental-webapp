DROP DATABASE Amv;
CREATE DATABASE Amv;
USE Amv;


     CREATE TABLE ansatt
     (
        ansatt_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        password VARCHAR(60) NOT NULL,
        navn VARCHAR(30) NOT NULL,
        email VARCHAR(40) NOT NULL,
        adress VARCHAR(40) NOT NULL,
        mobil VARCHAR(30) NOT NULL,
        adminn TINYINT(1),
        unionn TINYINT(1)
     );
     INSERT INTO ansatt (password,navn,email,adress,mobil,adminn,unionn)
     values
                       ('fgdr','mahmoud','Ayberk.mh@gmail.com','Stavanger','45000746',true,false),
                       ('vdsds','dlir','dlir.sharo@gmail.com','Sandnes','450054848',false,true)
                       ;

CREATE TABLE utstyr_type
(
utstyr_type_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
utstyr_navn VARCHAR(40) NOT NULL
);
INSERT INTO utstyr_type (utstyr_navn)
values
('truck maskin');

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
VALUES (1,'TRUCK',200.30,true,'du trenger opplæring for å bruke truck ta kontakt med admin');

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
(1,1,'2021,10,15','2021,10,22',false,254.50,'bra tilstand ');

SELECT * FROM ansatt;
SELECT * FROM utstyr_type;
SELECT * FROM utstyr;
SELECT * FROM leie_kontrakt;
SELECT tilbake_dato - start_leie_dato as total_dager   FROM leie_kontrakt,utstyr ;


