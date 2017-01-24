------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: etablissement
------------------------------------------------------------
CREATE TABLE public.etablissement(
	id          SERIAL NOT NULL ,
	nom         VARCHAR (200)  ,
	num_rue     INT   ,
	nom_rue     VARCHAR (200)  ,
	code_postal VARCHAR (5)  ,
	ville       VARCHAR (200)  ,
	CONSTRAINT prk_constraint_etablissement PRIMARY KEY (id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: administrateur
------------------------------------------------------------
CREATE TABLE public.administrateur(
	id         SERIAL NOT NULL ,
	nom        VARCHAR (200)  ,
	prenom     VARCHAR (200)  ,
	email      VARCHAR (100)  ,
	is_general BOOL   ,
	is_activ   BOOL   ,
	date_naiss DATE   ,
	CONSTRAINT prk_constraint_administrateur PRIMARY KEY (id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: administrateur_etablissement
------------------------------------------------------------
CREATE TABLE public.administrateur_etablissement(
	id                INT  NOT NULL ,
	id_administrateur INT  NOT NULL ,
	CONSTRAINT prk_constraint_administrateur_etablissement PRIMARY KEY (id,id_administrateur)
)WITHOUT OIDS;



ALTER TABLE public.administrateur_etablissement ADD CONSTRAINT FK_administrateur_etablissement_id FOREIGN KEY (id) REFERENCES public.etablissement(id);
ALTER TABLE public.administrateur_etablissement ADD CONSTRAINT FK_administrateur_etablissement_id_administrateur FOREIGN KEY (id_administrateur) REFERENCES public.administrateur(id);
