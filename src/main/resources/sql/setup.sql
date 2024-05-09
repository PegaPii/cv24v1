CREATE TABLE identite (
    id SERIAL PRIMARY KEY,
    genre VARCHAR(5),
    nom VARCHAR(255),
    prenom VARCHAR(255),
    tel VARCHAR(15),
    mel VARCHAR(255)
);

CREATE TABLE Objectif (
    id SERIAL PRIMARY KEY,
    id_identite INT REFERENCES Identite(id),
    intitule VARCHAR(255),
    statut VARCHAR(50)
);

CREATE TABLE Professionnel (
    id SERIAL PRIMARY KEY,
    id_identite INT REFERENCES Identite(id),
    titre VARCHAR(255),
    datedeb DATE,
    datefin DATE
);

CREATE TABLE CompetencesDiplome (
    id SERIAL PRIMARY KEY,
    id_identite INT REFERENCES Identite(id),
    titre VARCHAR(255),
    niveau INT,
    date DATE,
    institut VARCHAR(255)
);

CREATE TABLE CompetencesCertif (
    id SERIAL PRIMARY KEY,
    id_identite INT REFERENCES Identite(id),
    titre VARCHAR(255),
    datedeb DATE,
    datefin DATE
);

CREATE TABLE Langues (
    id SERIAL PRIMARY KEY,
    id_identite INT REFERENCES Identite(id),
    cert VARCHAR(50),
    lang VARCHAR(50),
    niveau VARCHAR(10)
);

CREATE TABLE AutresInfos (
    id SERIAL PRIMARY KEY,
    id_identite INT REFERENCES Identite(id),
    titre VARCHAR(255),
    commentaire TEXT
);