INSERT INTO oluet
(olutNimi, maa, olutTyyppi, olutProsentit, olutArvosana)
VALUES
("Sandels", "Suomi", "Lager", 4.7, 2.5),
("Karhu", "Suomi", "Lager", 4.5, 3.0),
("Fat Lizard Ankle Slapper", "Suomi", "American Pale Ale", 4.5, 3.0),
("Lapin Kulta", "Suomi", "Lager", 0.0, 0.25),
("A. Le Coq", "Viro", "Lager", 5.2, 2.25),
("Asahi Super Dry", "Japani", "Lager", 5.2, 2.75),
("Salama Neo-Elektro", "Suomi", "NEIPA", 6.5, 3.25),
("Krombacher Weizen", "Saksa", "Vehnä", 5.3, 3.25),
("Brooklyn Bel Air Sour", "Ruotsi", "Sour", 4.5, 3.25),
("Budejovický Budvar", "Tsekki", "Lager", 5, 3.25),
("Sol", "Meksiko", "Lager", 4.5, 3),
("BrewDog Punk IPA", "Skotlanti", "IPA", 5.4, 3.25),
("Leffe Blonde", "Belgia", "Ale", 6.6, 3.75),
("Thornbridge Chaipur Chai IPA", "Englanti", "IPA", 5.9, 3.25),
("Fat Lizard Vigilante Mission", "Suomi", "IPA", 6.5, 3.25);

select olut_id, olutNimi, maa, olutTyyppi, olutProsentit, olutArvosana from oluet order by olutNimi ASC;
//Järjestä
