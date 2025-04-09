
-- Insert into Leiter
INSERT INTO Leiter (id, name) VALUES
                                  (1, 'Dr. Müller'),
                                  (2, 'Dr. Fischer'),
                                  (3, 'Dr. Schneider');

-- Insert into Naturschutzgebiet
INSERT INTO Naturschutzgebiet (id, name, ort, leiter_id) VALUES
                                                             (1, 'Nationalpark Nordwald', 'Deutschland', 1),
                                                             (2, 'Biosphärenreservat Spreewald', 'Deutschland', 2),
                                                             (3, 'Wildpark Bayerischer Wald', 'Deutschland', 3);

-- Insert into Wissenschaftler
INSERT INTO Wissenschaftler (id, name, forschungsgebiet) VALUES
                                                             (1, 'Dr. Schmidt', NULL),
                                                             (2, 'Prof. Weber', NULL),
                                                             (3, 'Dr. Lehmann', NULL),
                                                             (4, 'Dr. Meier', NULL),
                                                             (5, 'Prof. Schneider', NULL);

-- Insert into Tier
INSERT INTO Tier (id, name, art, naturschutzgebiet_id) VALUES
                                                           (1, 'Wolf', 'Canis lupus', 1),
                                                           (2, 'Adler', 'Aquila chrysaetos', 2),
                                                           (3, 'Luchs', 'Lynx lynx', 3),
                                                           (4, 'Biber', 'Castor fiber', 3),
                                                           (5, 'Wildkatze', 'Felis silvestris', 2);

-- Insert into Trackinggeraet (with Hersteller)
INSERT INTO Trackinggeraet (id, seriennummer, tier_id, hersteller) VALUES
                                                                       (1, 'T-001', 1, 'WildTrack Inc.'),
                                                                       (2, 'T-002', 2, 'BioTag Systems'),
                                                                       (3, 'T-003', 3, 'EcoTrace Tech'),
                                                                       (4, 'T-004', 4, 'NatureMonitor'),
                                                                       (5, 'T-005', 5, 'WildLife Sensors');

-- Insert into Wanderung (with manually assigned IDs and updated trackinggeraet_id + tier_id)
INSERT INTO Wanderung (id, datum, region, trackinggeraet_id, tier_id) VALUES
                                                                          (1, '2024-03-15', 'Nordwald', 1, 1),
                                                                          (2, '2024-03-16', 'Alpen', 2, 2),
                                                                          (3, '2024-03-18', 'Spreewald', 3, 3),
                                                                          (4, '2024-04-01', 'Donauauen', 4, 4),
                                                                          (5, '2024-04-05', 'Bayerischer Wald', 5, 5);

-- -- Insert into Pflanze
-- INSERT INTO Pflanze (id, name) VALUES
--                                    (1, 'Eiche'),
--                                    (2, 'Brombeere'),
--                                    (3, 'Fichte'),
--                                    (4, 'Moorbirke'),
--                                    (5, 'Löwenzahn'),
--                                    (6, 'Tanne');
--
-- -- Insert into Tier_Pflanze
-- INSERT INTO Tier_Pflanze (tier_id, pflanze_id) VALUES
--                                                    (1, 2),  -- Wolf frisst Brombeere
--                                                    (2, 1),  -- Adler nutzt Eiche
--                                                    (3, 3),  -- Luchs bei Fichte
--                                                    (3, 4),  -- Luchs bei Moorbirke
--                                                    (4, 5),  -- Biber bei Löwenzahn
--                                                    (5, 6),  -- Wildkatze bei Tanne
--                                                    (2, 6),  -- Adler auch bei Tanne
--                                                    (4, 2);  -- Biber auch bei Brombeere
--
--
-- -- -- Einfügen von Giftpflanzen
-- -- Insert into gplnt_tbl
-- INSERT INTO gplnt_tbl (gid, gnam, tox_lvl, fx_dt, desc_txt, is_dangr) VALUES
--                                                                           (1, 'Tollkirsche', 5, CURRENT_TIMESTAMP, 'Extrem giftig für Menschen und Tiere.', TRUE),
--                                                                           (2, 'Eibe', 4, CURRENT_TIMESTAMP, 'Hochgiftig, besonders die Nadeln und Samen.', TRUE),
--                                                                           (3, 'Fingerhut', 3, CURRENT_TIMESTAMP, 'Giftig für Menschen und viele Tiere.', TRUE),
--                                                                           (4, 'Herbstzeitlose', 5, CURRENT_TIMESTAMP, 'Besonders gefährlich für Weidetiere.', TRUE),
--                                                                           (5, 'Riesen-Bärenklau', 2, CURRENT_TIMESTAMP, 'Kann schwere Hautreaktionen verursachen.', TRUE);
--
-- -- Insert into expnd_spread
-- INSERT INTO expnd_spread (eid, gref, regn, tox_for, spread_rate) VALUES
--                                                                      (1, 1, 'Mitteleuropa', 'Menschen, Hunde, Katzen', 1.5),
--                                                                      (2, 2, 'Nadelwälder', 'Pferde, Hunde', 2.0),
--                                                                      (3, 3, 'Wiesen und Gärten', 'Menschen', 1.2),
--                                                                      (4, 4, 'Feuchtgebiete', 'Rinder, Schafe', 3.1),
--                                                                      (5, 5, 'Waldränder', 'Menschen, Weidetiere', 2.5);
--
--
-- -- Insert into Forschung
-- INSERT INTO Forschung (tier_id, wissenschaftler_id) VALUES
--                                                         (1, 1),
--                                                         (1, 2),
--                                                         (2, 1),
--                                                         (2, 3),
--                                                         (3, 2),
--                                                         (4, 4),
--                                                         (5, 5),
--                                                         (3, 4);
