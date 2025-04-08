-- CREATE TABLE Naturschutzgebiet (
--                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
--                                    name VARCHAR(255) NOT NULL,
--                                    ort VARCHAR(255) NOT NULL,
--                                    leiter_id BIGINT
-- );
--
-- CREATE TABLE Leiter (
--                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
--                         name VARCHAR(255) NOT NULL
-- );
--
-- CREATE TABLE Tier (
--                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
--                       name VARCHAR(255) NOT NULL,
--                       art VARCHAR(255) NOT NULL,
--                       naturschutzgebiet_id BIGINT,
--                       FOREIGN KEY (naturschutzgebiet_id) REFERENCES Naturschutzgebiet(id)
-- );
--
-- CREATE TABLE Wissenschaftler (
--                                  id BIGINT PRIMARY KEY AUTO_INCREMENT,
--                                  name VARCHAR(255) NOT NULL
-- );
--
-- CREATE TABLE Forschung (
--                            tier_id BIGINT,
--                            wissenschaftler_id BIGINT,
--                            PRIMARY KEY (tier_id, wissenschaftler_id),
--                            FOREIGN KEY (tier_id) REFERENCES Tier(id),
--                            FOREIGN KEY (wissenschaftler_id) REFERENCES Wissenschaftler(id)
-- );
--
-- CREATE TABLE Trackinggeraet (
--                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
--                                 seriennummer VARCHAR(50) UNIQUE NOT NULL,
--                                 tier_id BIGINT,
--                                 FOREIGN KEY (tier_id) REFERENCES Tier(id)
-- );
--
-- CREATE TABLE Wanderung (
--                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
--                            datum DATE NOT NULL,
--                            region VARCHAR(255) NOT NULL,
--                            trackinggeraet_id BIGINT,
--                            FOREIGN KEY (trackinggeraet_id) REFERENCES Trackinggeraet(id)
-- );
--
-- CREATE TABLE Pflanze (
--                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
--                          name VARCHAR(255) NOT NULL
-- );
--
-- CREATE TABLE Tier_Pflanze (
--                               tier_id BIGINT,
--                               pflanze_id BIGINT,
--                               PRIMARY KEY (tier_id, pflanze_id),
--                               FOREIGN KEY (tier_id) REFERENCES Tier(id),
--                               FOREIGN KEY (pflanze_id) REFERENCES Pflanze(id)
-- );
--
-- -- Enum für Giftpflanzen
-- CREATE TABLE Giftpflanzen (
--                               name VARCHAR(255),
--                               CONSTRAINT name_check CHECK (name IN ('Tollkirsche', 'Eibe', 'Fingerhut', 'Herbstzeitlose', 'Riesen-Bärenklau'))
-- );
--
-- -- Tabelle mit schlechter Benennung und vielen Datentypen
-- CREATE TABLE gplnt_tbl (
--                            gid BIGINT PRIMARY KEY AUTO_INCREMENT,
--                            gnam VARCHAR(255) NOT NULL,
--                            tox_lvl BIGINT NOT NULL,
--                            fx_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--                            "desc" VARCHAR(100),
--                            is_dangr BOOLEAN,
--                            CONSTRAINT gnam_check CHECK (gnam IN ('Tollkirsche', 'Eibe', 'Fingerhut', 'Herbstzeitlose', 'Riesen-Bärenklau'))
-- );
--
-- -- Tabelle zur Ausbreitung und für wen giftig
-- CREATE TABLE expnd_spread (
--                               eid BIGINT PRIMARY KEY AUTO_INCREMENT,
--                               gref BIGINT,
--                               regn VARCHAR(255) NOT NULL,
--                               tox_for VARCHAR(255) NOT NULL,
--                               spread_rate DECIMAL(5,2),
--                               FOREIGN KEY (gref) REFERENCES gplnt_tbl(gid)
-- );

-- Einfügen von Beispieldaten
INSERT INTO Leiter (id, name) VALUES (LEITER_SEQ.nextval,'Dr. Müller'), (LEITER_SEQ.nextval,'Dr. Fischer'), (LEITER_SEQ.nextval,'Dr. Schneider');
INSERT INTO Naturschutzgebiet (id, name, ort, leiter_id) VALUES
                                                         (NATURSCHUTZGEBIET_SEQ.nextval,'Nationalpark Nordwald', 'Deutschland', 1),
                                                         (NATURSCHUTZGEBIET_SEQ.nextval,'Biosphärenreservat Spreewald', 'Deutschland', 51),
                                                         (NATURSCHUTZGEBIET_SEQ.nextval,'Wildpark Bayerischer Wald', 'Deutschland', 101);

INSERT INTO Wissenschaftler (id, name) VALUES (WISSENSCHAFTLER_SEQ.nextval,'Dr. Schmidt'), (WISSENSCHAFTLER_SEQ.nextval,'Prof. Weber'), (WISSENSCHAFTLER_SEQ.nextval,'Dr. Lehmann'), (WISSENSCHAFTLER_SEQ.nextval,'Dr. Meier'), (WISSENSCHAFTLER_SEQ.nextval,'Prof. Schneider');

INSERT INTO Tier (id, name, art, naturschutzgebiet_id) VALUES
                                                       (TIER_SEQ.nextval,'Wolf', 'Canis lupus', 1),
                                                       (TIER_SEQ.nextval,'Adler', 'Aquila chrysaetos', 51),
                                                       (TIER_SEQ.nextval,'Luchs', 'Lynx lynx', 101),
                                                       (TIER_SEQ.nextval,'Biber', 'Castor fiber', 151),
                                                       (TIER_SEQ.nextval,'Wildkatze', 'Felis silvestris', 201);

-- INSERT INTO Forschung (tier_id, wissenschaftler_id) VALUES
--                                                         (1, 1), (1, 2), (2, 1), (2, 3), (3, 2), (4, 4), (5, 5), (3, 4);

INSERT INTO Trackinggeraet (id,seriennummer, tier_id) VALUES
                                                       (TRACKINGGERAET_SEQ.nextval,'T-001', 1),
                                                       (TRACKINGGERAET_SEQ.nextval,'T-002', 51),
                                                       (TRACKINGGERAET_SEQ.nextval,'T-003', 101),
                                                       (TRACKINGGERAET_SEQ.nextval,'T-004', 151),
                                                       (TRACKINGGERAET_SEQ.nextval,'T-005', 201);

INSERT INTO Wanderung (id ,datum, region, tier_id, trackinggeraet_id) VALUES
                                                             (WANDERUNG_SEQ.nextval,'2024-03-15', 'Nordwald',1, 1),
                                                             (WANDERUNG_SEQ.nextval,'2024-03-16', 'Alpen',51,  51),
                                                             (WANDERUNG_SEQ.nextval,'2024-03-18', 'Spreewald',101, 101),
                                                             (WANDERUNG_SEQ.nextval,'2024-04-01', 'Donauauen',151, 151),
                                                             (WANDERUNG_SEQ.nextval,'2024-04-05', 'Bayerischer Wald',201,  201);
--
-- INSERT INTO Pflanze (name) VALUES ('Eiche'), ('Brombeere'), ('Fichte'), ('Moorbirke'), ('Löwenzahn'), ('Tanne');
-- INSERT INTO Tier_Pflanze (tier_id, pflanze_id) VALUES
--                                                    (1, 2), (2, 1), (3, 3), (3, 4), (4, 5), (5, 6), (2, 6), (4, 2);
--
-- -- Einfügen von Giftpflanzen
-- INSERT INTO gplnt_tbl (gnam, tox_lvl, "desc", is_dangr) VALUES
--                                                             ('Tollkirsche', 5, 'Extrem giftig für Menschen und Tiere.', TRUE),
--                                                             ('Eibe', 4, 'Hochgiftig, besonders die Nadeln und Samen.', TRUE),
--                                                             ('Fingerhut', 3, 'Giftig für Menschen und viele Tiere.', TRUE),
--                                                             ('Herbstzeitlose', 5, 'Besonders gefährlich für Weidetiere.', TRUE),
--                                                             ('Riesen-Bärenklau', 2, 'Kann schwere Hautreaktionen verursachen.', TRUE);

-- Einfügen von Ausbreitungen und toxischen Wirkungen
-- INSERT INTO expnd_spread (gref, regn, tox_for, spread_rate) VALUES
--                                                                 (1, 'Mitteleuropa', 'Menschen, Hunde, Katzen', 1.5),
--                                                                 (2, 'Nadelwälder', 'Pferde, Hunde', 2.0),
--                                                                 (3, 'Wiesen und Gärten', 'Menschen', 1.2),
--                                                                 (4, 'Feuchtgebiete', 'Rinder, Schafe', 3.1),
--                                                                 (5, 'Waldränder', 'Menschen, Weidetiere', 2.5);


-- create table Giftpflanze (id bigint generated by default as identity, beschreibung varchar(255), name varchar(255), toxizitaetsstufe integer not null, primary key (id));
-- alter table if exists Trackinggeraet add column hersteller varchar(255);
-- alter table if exists Trackinggeraet alter column seriennummer set data type varchar(255);
-- alter table if exists Wanderung alter column datum set data type varchar(255);
-- alter table if exists Wanderung add column tier_id bigint;
-- alter table if exists Wissenschaftler add column forschungsgebiet varchar(255);
-- alter table if exists Wanderung add constraint FK5smatyrqv0oo2plv7fswvtco7 foreign key (tier_id) references Tier;
