
CREATE TABLE departement (
  id_Departement   INTEGER PRIMARY KEY,
  libelle VARCHAR(30),
  capacité         INTEGER
);

CREATE TABLE etudiant (
  id_etudiant      INTEGER PRIMARY KEY,
  nom VARCHAR(30),
  prenom VARCHAR(30),
  age integer,
  id_Departement integer foreign key references departement(id_Departement)
);

CREATE TABLE prof (
  id_prof     INTEGER PRIMARY KEY,
  nom VARCHAR(30),
  prenom VARCHAR(30),
 );


 CREATE TABLE module (
  id_module      INTEGER PRIMARY KEY,
  libelle VARCHAR(30),
  id_prof  integer foreign key references prof(id_prof)
);

CREATE TABLE note (
  id_module    integer foreign key references module(id_module),
  id_etudiant  integer foreign key references etudiant(id_etudiant),
  note real
);


