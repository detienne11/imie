-- relation 1:n (role: utilisateur) + relatoin n:n (groupes + utlisateur)
CREATE TABLE groupes (
id		serial NOT NULL PRIMARY KEY,	
nom		varchar(50)
);

CREATE TABLE roles (
id		serial NOT NULL PRIMARY KEY,	
nom		varchar(50)
);

insert into roles (nom) values('Invité'),('Utilisateur'),('Conseiller'),('Administrateur'),('Directeur');

CREATE TABLE utilisateurGroupes (
groupe_id	integer NOT NULL,	
user_id	integer NOT NULL,
FOREIGN KEY (groupe_id) REFERENCES groupes(id),
FOREIGN KEY (user_id) REFERENCES utilisateur(id),
CONSTRAINT pk_groupes PRIMARY KEY (groupe_id,user_id)
);

ALTER TABLE utilisateur ADD role_id integer;
ALTER TABLE utilisateur ADD FOREIGN KEY (role_id) REFERENCES roles(id);

-- non-disjonction : Totalité + relation 1:1 avec adresse
CREATE TABLE personnes (
id			serial NOT NULL PRIMARY KEY,
personType	integer,	
nom			varchar(50),
prenom		varchar(50),
email		varchar(50),
nomClasse	varchar(50),
rue			varchar(50),
codePostal	char(5),
ville		varchar(50)
);

-- disjonction : + Partition
CREATE TABLE eleves (
id			serial NOT NULL PRIMARY KEY,
nom			varchar(50),
prenom		varchar(50),
nomClasse	varchar(50)
);

CREATE TABLE parents (
id			serial NOT NULL PRIMARY KEY,
nom			varchar(50),
prenom		varchar(50),
email		varchar(50)
);

-- disjonction : x Exclusion
CREATE TABLE personnes3 (
id			serial NOT NULL PRIMARY KEY,
personType	integer,
nom			varchar(50),
prenom		varchar(50)
);

CREATE TABLE eleves3 (
id			serial NOT NULL PRIMARY KEY,
nomClasse	varchar(50),
person_id	integer,
FOREIGN KEY (person_id) REFERENCES personnes2(id)
);

CREATE TABLE parents3 (
id			serial NOT NULL PRIMARY KEY,
email		varchar(50),
person_id	integer,
FOREIGN KEY (person_id) REFERENCES personnes2(id)
);
