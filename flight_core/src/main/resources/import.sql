INSERT INTO Adresse(id, numero, nom, codePostal, ville, pays) VALUES (1, 5, 'Picasso', '93370', 'Montfermeil', 'France')
INSERT INTO Adresse(id, numero, nom, codePostal, ville, pays) VALUES (2, 21, 'de la Résistance', '75010', 'Paris', 'France')
INSERT INTO Adresse(id, numero, nom, codePostal, ville, pays) VALUES (3, 33, 'Endurance', '88', 'Nairobi', 'Kenya')

INSERT INTO Login(id, username, password) VALUES (1, 'brahms', 'toto')
INSERT INTO Login(id, username, password) VALUES (2, 'bibi', 'titi')
INSERT INTO Login(id, username, password) VALUES (3, 'Selassie', 'tata')

INSERT INTO Personne(id, nom, prenom, email, telephone, typePersonne, adresse, login) VALUES (1, 'Gassama', 'Ibrahim', 'igassama@gmail.com', '0627233333', 'Client', 1, 1)
INSERT INTO Personne(id, nom, prenom, email, telephone, typePersonne, adresse, login) VALUES (2, 'Boutier', 'Pierre', 'pboutier@gmail.com', '0627255555', 'Client', 2, 2)
INSERT INTO Personne(id, nom, prenom, email, telephone, typePersonne, adresse, login) VALUES (3, 'De Soufle', 'Abou', 'ads@gmail.com', '0627222222', 'Client', 3, 3)

INSERT INTO Localite(id, ville, aeroport) VALUES (id, 'Paris', 'CDG')
INSERT INTO Localite(id, ville, aeroport) VALUES (id, 'Los Angeles', 'LAX')
INSERT INTO Localite(id, ville, aeroport) VALUES (id, 'Dakar', 'DKR')
                               
INSERT INTO Vol(num, prix, dateTimeDepart, refLocDepart, dateTimeArrivee, refLocArrivee) VALUES (1, 100.0, '2018-06-01 00:00:00', 1, '2018-06-02 00:00:00', 2)
INSERT INTO Vol(num, prix, dateTimeDepart, refLocDepart, dateTimeArrivee, refLocArrivee) VALUES (2, 200.0, '2018-06-02 00:00:00', 2, '2018-06-03 00:00:00', 1)
INSERT INTO Vol(num, prix, dateTimeDepart, refLocDepart, dateTimeArrivee, refLocArrivee) VALUES (3, 300.0, '2018-06-03 00:00:00', 1, '2018-06-04 00:00:00', 3)
INSERT INTO Vol(num, prix, dateTimeDepart, refLocDepart, dateTimeArrivee, refLocArrivee) VALUES (4, 400.0, '2018-06-04 00:00:00', 3, '2018-06-05 00:00:00', 1)
INSERT INTO Vol(num, prix, dateTimeDepart, refLocDepart, dateTimeArrivee, refLocArrivee) VALUES (5, 500.0, '2018-06-05 00:00:00', 2, '2018-06-06 00:00:00', 3)
INSERT INTO Vol(num, prix, dateTimeDepart, refLocDepart, dateTimeArrivee, refLocArrivee) VALUES (6, 600.0, '2018-06-06 00:00:00', 3, '2018-06-07 00:00:00', 2)
INSERT INTO Vol(num, prix, dateTimeDepart, refLocDepart, dateTimeArrivee, refLocArrivee) VALUES (7, 700.0, '2018-06-06 00:00:00', 1, '2018-06-07 00:00:00', 2)
                               
INSERT INTO Reservation(idResa, comment, dateResa, idClient, idVol) VALUES (1, 'RESA1', '2018-06-03', 1, 1)
INSERT INTO Reservation(idResa, comment, dateResa, idClient, idVol) VALUES (2, 'RESA2', '2018-06-03', 1, 2)
INSERT INTO Reservation(idResa, comment, dateResa, idClient, idVol) VALUES (3, 'RESA3', '2018-06-03', 2, 4)

INSERT INTO Resa_Personne(idResa, idPers) VALUES (1, 1)
INSERT INTO Resa_Personne(idResa, idPers) VALUES (1, 2)
INSERT INTO Resa_Personne(idResa, idPers) VALUES (2, 2)
INSERT INTO Resa_Personne(idResa, idPers) VALUES (2, 3)
INSERT INTO Resa_Personne(idResa, idPers) VALUES (3, 2)