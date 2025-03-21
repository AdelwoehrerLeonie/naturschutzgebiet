-- Erstellen der Tabellen
CREATE TABLE Naturschutzgebiet (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    ort VARCHAR(255) NOT NULL,
    leiter_id BIGINT
);

CREATE TABLE Leiter (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Tier (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    art VARCHAR(255) NOT NULL,
    naturschutzgebiet_id BIGINT,
    FOREIGN KEY (naturschutzgebiet_id) REFERENCES Naturschutzgebiet(id)
);

CREATE TABLE Wissenschaftler (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Forschung (
    tier_id BIGINT,
    wissenschaftler_id BIGINT,
    PRIMARY KEY (tier_id, wissenschaftler_id),
    FOREIGN KEY (tier_id) REFERENCES Tier(id),
    FOREIGN KEY (wissenschaftler_id) REFERENCES Wissenschaftler(id)
);

CREATE TABLE Trackinggeraet (
    id IDENTITY PRIMARY KEY,
    seriennummer VARCHAR(50) UNIQUE NOT NULL,
    tier_id BIGINT,
    FOREIGN KEY (tier_id) REFERENCES Tier(id)
);

CREATE TABLE Wanderung (
    id IDENTITY PRIMARY KEY,
    datum DATE NOT NULL,
    region VARCHAR(255) NOT NULL,
    trackinggeraet_id BIGINT,
    FOREIGN KEY (trackinggeraet_id) REFERENCES Trackinggeraet(id)
);

CREATE TABLE Pflanze (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Tier_Pflanze (
    tier_id BIGINT,
    pflanze_id BIGINT,
    PRIMARY KEY (tier_id, pflanze_id),
    FOREIGN KEY (tier_id) REFERENCES Tier(id),
    FOREIGN KEY (pflanze_id) REFERENCES Pflanze(id)
);

-- Enum für Giftpflanzen
CREATE TYPE Giftpflanzen AS ENUM ('Tollkirsche', 'Eibe', 'Fingerhut', 'Herbstzeitlose', 'Riesen-Bärenklau');

-- Tabelle mit schlechter Benennung und vielen Datentypen
CREATE TABLE gplnt_tbl (
    gid IDENTITY PRIMARY KEY,
    gnam Giftpflanzen NOT NULL,
    tox_lvl INT NOT NULL,
    fx_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    desc TEXT,
    is_dangr BOOLEAN
);

-- Tabelle zur Ausbreitung und für wen giftig
CREATE TABLE expnd_spread (
    eid IDENTITY PRIMARY KEY,
    gref BIGINT,
    regn VARCHAR(255) NOT NULL,
    tox_for VARCHAR(255) NOT NULL,
    spread_rate DECIMAL(5,2),
    FOREIGN KEY (gref) REFERENCES gplnt_tbl(gid)
);

-- Einfügen von Beispieldaten
INSERT INTO Leiter (name) VALUES ('Dr. Müller'), ('Dr. Fischer'), ('Dr. Schneider');
INSERT INTO Naturschutzgebiet (name, ort, leiter_id) VALUES 
    ('Nationalpark Nordwald', 'Deutschland', 1), 
    ('Biosphärenreservat Spreewald', 'Deutschland', 2),
    ('Wildpark Bayerischer Wald', 'Deutschland', 3);

INSERT INTO Wissenschaftler (name) VALUES ('Dr. Schmidt'), ('Prof. Weber'), ('Dr. Lehmann'), ('Dr. Meier'), ('Prof. Schneider');

INSERT INTO Tier (name, art, naturschutzgebiet_id) VALUES 
    ('Wolf', 'Canis lupus', 1), 
    ('Adler', 'Aquila chrysaetos', 1), 
    ('Luchs', 'Lynx lynx', 2),
    ('Biber', 'Castor fiber', 2),
    ('Wildkatze', 'Felis silvestris', 3);

INSERT INTO Forschung (tier_id, wissenschaftler_id) VALUES 
    (1, 1), (1, 2), (2, 1), (2, 3), (3, 2), (4, 4), (5, 5), (3, 4);

INSERT INTO Trackinggeraet (seriennummer, tier_id) VALUES 
    ('T-001', 1), ('T-002', 2), ('T-003', 3), ('T-004', 4), ('T-005', 5);

INSERT INTO Wanderung (datum, region, trackinggeraet_id) VALUES 
    ('2024-03-15', 'Nordwald', 1), 
    ('2024-03-16', 'Alpen', 2), 
    ('2024-03-18', 'Spreewald', 3),
    ('2024-04-01', 'Donauauen', 4),
    ('2024-04-05', 'Bayerischer Wald', 5);

INSERT INTO Pflanze (name) VALUES ('Eiche'), ('Brombeere'), ('Fichte'), ('Moorbirke'), ('Löwenzahn'), ('Tanne');
INSERT INTO Tier_Pflanze (tier_id, pflanze_id) VALUES 
    (1, 2), (2, 1), (3, 3), (3, 4), (4, 5), (5, 6), (2, 6), (4, 2);

-- Einfügen von Giftpflanzen
INSERT INTO gplnt_tbl (gnam, tox_lvl, desc, is_dangr) VALUES
    ('Tollkirsche', 5, 'Extrem giftig für Menschen und Tiere.', TRUE),
    ('Eibe', 4, 'Hochgiftig, besonders die Nadeln und Samen.', TRUE),
    ('Fingerhut', 3, 'Giftig für Menschen und viele Tiere.', TRUE),
    ('Herbstzeitlose', 5, 'Besonders gefährlich für Weidetiere.', TRUE),
    ('Riesen-Bärenklau', 2, 'Kann schwere Hautreaktionen verursachen.', TRUE);

-- Einfügen von Ausbreitungen und toxischen Wirkungen
INSERT INTO expnd_spread (gref, regn, tox_for, spread_rate) VALUES
    (1, 'Mitteleuropa', 'Menschen, Hunde, Katzen', 1.5),
    (2, 'Nadelwälder', 'Pferde, Hunde', 2.0),
    (3, 'Wiesen und Gärten', 'Menschen', 1.2),
    (4, 'Feuchtgebiete', 'Rinder, Schafe', 3.1),
    (5, 'Waldränder', 'Menschen, Weidetiere', 2.5);
