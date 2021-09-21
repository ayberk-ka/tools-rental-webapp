DROP DATABASE web_shop;
CREATE DATABASE web_shop;
	use web_shop;

-- Tabellstruktur for tabell Kunde

CREATE TABLE kunde(
   kunde_id INT PRIMARY KEY NOT NULL ,
   fornavn VARCHAR (20) NOT NULL,
   etternavn VARCHAR (20) NOT NULL,
   fodsels_dato DATE NOT NULL,
   mobil VARCHAR (30),
   email VARCHAR (30) NOT NULL,
   adress VARCHAR (40) NOT NULL
		);

INSERT INTO kunde (kunde_id,fornavn,etternavn,fodsels_dato,mobil,email,adress )
VALUES
( 1,'Mahmoud','Kasem','1999-08-20','45787706','Ayberk.mh@gmail.com','OSlo'),
( 2,'Dana ','Omar','2000-01-01','45585974','Dana24februar@gmail.com','Sndnes'),
( 3,'Dler',' Sharo','2000-01-02','96487555','dlir.sharo@gmail.com','Kristiansand'),
( 4,'Håkon','Kristiansen','2000-01-08','47585887','haakon128@gmail.com','Oslo'),
( 5,'Magnus',' Erga','2000-02-09','96741568','magnus.ser@live.no','Bergen'),
( 6,'Aleksander',' Kolsrud','2000-03-15','93658746','Kols203@gmail.com','Haugesund');


SELECT * FROM kunde;

-- Tabellstruktur for tabell Produkt


CREATE TABLE produkt(
   produkt_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   Produkt_navn VARCHAR(40),
	 pris INT
		);
		INSERT INTO produkt(Produkt_navn,pris)
		VALUES
		( 'DELL GAMING LAPTOP',22000),
		( ' AUSU GAMING LAPTOP',20000),
		( 'MSI GL65 GAMING LAPTOP',25000),
		( 'HP GAMING LAPTOP',18000);
		SELECT * FROM produkt;

-- Tabellstruktur for tabell Ordre


CREATE TABLE ordre(
   ordre_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
   kunde_id INT NOT NULL,
	 produkt_id INT NOT NULL,
   kjops_dato DATE NOT NULL,
	 CONSTRAINT FK_kunde_ordre
	 FOREIGN KEY (kunde_id) REFERENCES kunde(kunde_id) ON DELETE CASCADE,
	 CONSTRAINT FK_produkt_ordre
	 FOREIGN KEY (produkt_id) REFERENCES produkt(produkt_id)
		);

		INSERT INTO ordre(kunde_id,produkt_id,kjops_dato)
		VALUES
		(1,3,'2021-09-12'),
		(3,2,'2021-09-17'),
		(4,1,'2021-07-15'),
		(5,4,'2021-08-12'),
		(6,3,'2021-06-19'),
		(2,2,'2021-09-14'),
		(1,4,'2020-01-18');
ALTER TABLE ordre
    ADD status varchar(20) DEFAULT('Sendt');


DELETE FROM kunde
WHERE kunde_id=2;


SELECT * FROM kunde;
