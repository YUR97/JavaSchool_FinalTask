CREATE TABLE TARIFS(
                       id SERIAL PRIMARY KEY,
                       name VARCHAR,
                       price VARCHAR
);
CREATE TABLE OPTIONS(
                              id SERIAL PRIMARY KEY,
                              name VARCHAR,
                              payment VARCHAR,
                              connection_price VARCHAR
);
CREATE TABLE TARIFS_OPTIONS(
                                     id_tarif INT,
                                     id_option INT,
                                     FOREIGN KEY (id_tarif) REFERENCES TARIFS(id),
                                     FOREIGN KEY (id_option) REFERENCES OPTIONS(id),
                                     CONSTRAINT unique_pair UNIQUE(id_tarif,id_option)
);
CREATE TABLE CONTRACTS(
                          contract_number VARCHAR PRIMARY KEY,
                          id_tarif INT,
                          FOREIGN KEY (id_tarif) REFERENCES TARIFS(id)
);
CREATE TABLE CONTRACTS_OPTIONS(
                                        contract_number VARCHAR,
                                        id_option INT,
                                        FOREIGN KEY (contract_number) REFERENCES CONTRACTS(contract_number),
                                        FOREIGN KEY (id_option) REFERENCES OPTIONS(id),
                                        CONSTRAINT unique_pair_1 UNIQUE(contract_number,id_option)
);
CREATE TABLE CLIENTS(
                        id SERIAL PRIMARY KEY,
                        name VARCHAR,
                        surname VARCHAR,
                        birthday DATE,
                        passport VARCHAR,
                        address VARCHAR,
                        email VARCHAR,
                        password VARCHAR
);

ALTER TABLE CONTRACTS
    ADD COLUMN id_client INT;

ALTER TABLE CONTRACTS
    ADD CONSTRAINT contracts_clients_fk FOREIGN KEY(id_client) REFERENCES CLIENTS(id);

CREATE TABLE ROLES(
                      id SERIAL PRIMARY KEY,
                      name VARCHAR
);

ALTER TABLE CLIENTS
    ADD COLUMN id_role INT;

ALTER TABLE CLIENTS
    ADD CONSTRAINT clients_roles_fk FOREIGN KEY (id_role) REFERENCES ROLES(id);

ALTER TABLE CONTRACTS
    ADD COLUMN status VARCHAR;