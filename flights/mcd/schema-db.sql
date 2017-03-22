#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: airports
#------------------------------------------------------------

CREATE TABLE airports(
        id   int (11) Auto_increment  NOT NULL ,
        name Varchar (250) ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: flights
#------------------------------------------------------------

CREATE TABLE flights(
        id            int (11) Auto_increment  NOT NULL ,
        number        Varchar (50) ,
        departure     Date ,
        arrival       Date ,
        airport_departure   Int ,
        airport_arrival Int ,
        PRIMARY KEY (id ) ,
        UNIQUE (number )
)ENGINE=InnoDB;

ALTER TABLE flights ADD CONSTRAINT FK_flights_airport_departure FOREIGN KEY (airport_departure) REFERENCES airports(id);
ALTER TABLE flights ADD CONSTRAINT FK_flights_airport_arrival FOREIGN KEY (airport_arrival) REFERENCES airports(id);
