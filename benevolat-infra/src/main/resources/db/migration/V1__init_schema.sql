CREATE TABLE IF NOT EXISTS membre (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v7(),
    matricule VARCHAR(50) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS benevole(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v7(),
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL
);
