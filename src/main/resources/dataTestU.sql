MERGE INTO TUSER VALUES
('admin','$2a$10$vMHCWTbHzfWVzMVudrij8.g2wbnVeDBQL6VEWlGtyyIlfvnens/P2',0),
('naza','$2a$10$aIqPp4EUUgmsW9BobL8NJe9jcOXCrResdkyI12LbjGSCWXJsw3Zaa',1),
('r1','$2a$10$wT67larHgm9xkBqIO4cljucEvdwdWDrrAZ2SSvz9w/R02SzgpD7cy',2),
('r2','$2a$10$wT67larHgm9xkBqIO4cljucEvdwdWDrrAZ2SSvz9w/R02SzgpD7cy',2),
('r3','$2a$10$wT67larHgm9xkBqIO4cljucEvdwdWDrrAZ2SSvz9w/R02SzgpD7cy',2),
('r4','$2a$10$wT67larHgm9xkBqIO4cljucEvdwdWDrrAZ2SSvz9w/R02SzgpD7cy',2),
('r5','$2a$10$wT67larHgm9xkBqIO4cljucEvdwdWDrrAZ2SSvz9w/R02SzgpD7cy',2),
('r6','$2a$10$wT67larHgm9xkBqIO4cljucEvdwdWDrrAZ2SSvz9w/R02SzgpD7cy',2),
('pc1','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3),
('pc2','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3),
('pc3','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3),
('pc4','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3),
('pc5','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3),
('pc6','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3),
('pc7','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3),
('pc8','$2a$10$7VvE7KiNkBLmoicdElinf.MlkV6Ki3siYURnhaf5DKtD2jNjGxm7S',3);

MERGE INTO TETABLISSEMENT(NOM,EMAIL1,EMAIL2,TEL1,TEL2,ADRESSE,DATE_CREATION,FKUSER) values
('RESIDENCE NAZARETTE','nazarette@yahoo.com','nazarette@skynet.be','071124368','071165894','rue de lacombe 7,1000 Bruxelles','1990-04-24','naza');


MERGE INTO TPERSONNECONTACT(ID,NOM,PRENOM,DATE_NAISSANCE,EMAIL,TEL1,TEL2,ADRESSE,STATUT,CHOIX,FKUSER) values
(1,'TCHOLA','Rina','1998-04-20','rina237@gmail.com','0465335698','0498576973','rue de mons 12,1070 Anderlecht',0,1,'pc1'),
(2,'LUBBERT','Christiano','1989-08-29','elysee229@yahoo.com','0495237854','0665129854','rue de la louviere,7000 Mons ',1,3,'pc2'),
(3,'BAYANGAM','Ulrich','1990-06-17','bayangam237@gmail.com','0475287619','0460117632','rue neuve 10,1010 Schaerbeek',1,0,'pc3'),
(4,'SIMC','Thierry','1988-10-21','sim229@yahoo.com','0496543219','0451389078','rue de merode 62,5000 Namur',2,6,'pc4'),
(5,'NDJIKE','Cyril','1991-03-13','loveur@yahoo.com','0498765431','0476421329','chausée de bruxelles 19,7000 Mons',0,4,'pc5'),
(6,'SKYS','Shamir','1996-12-24','skysdaniel@gmail.com','0765432189','0465387241','chausée de gilly 79, 6040 Jumet',1,2,'pc6'),
(7,'SCORIER','Antoine','1980-08-16','exantoine@yahoo.com','071135496','0495237864',' chausée de mons 79,1000 Bruxelles',1,5,'pc7'),
(8,'TASSE','Maristo','1995-01-24','pinemarius@gmail.com','0474321789','O432199087','Rue de constantinoble 10,4000 Liege',3,2,'pc8');
--Réinitialise le compteur identity 
alter table TPERSONNECONTACT ALTER COLUMN ID RESTART WITH (select max(id)+1 from tpersonnecontact);

MERGE INTO TMEDECINTRAITANT(NUM_INAMI,NOM,PRENOM,EMAIL,TEL1,TEL2,ADRESSE) values
('00012354879','VANDERKAM','Anne','anne@skynet.be','071419856','0497234512','rue dourlet 13,6000 Charleroi'),
('11987634221','GIWA','Myriam','giwamyr@yahoo.com','0475119933','071952390','rue lodelinsart 23,6040 Jumet'),
('99001253675','LEJEUNE','Anasthasie','lejeune@skynet.be','0475119933','071238949','Chausée de lion 67,4000 Liege'),
('00097685143','LAVENS','Cathy','cathy@skynet.be','071238945','0712382390','chausée de gilly 18,6030 Marchienne');

 
MERGE INTO TRESIDENT(ID,NOM,PRENOM,DATE_NAISSANCE,EMAIL,TEL,ADRESSE,STATUT,DATE_ENTREE,MOTIF_ENTREE,ETAT_SANTE,ANT_MEDICAL,ANT_CHIRUGICAL,NB_ENFANT,CHAMBRE,FKUSER,FKMEDECIN_TRAITANT,FKETABLISSEMENT) values
(1,'DUPUIT','Marie','1960-01-1','dupuitmarie@gmail.com','0460001188','rue de joujoute 7,1000 Bruxelles',0,'2020-01-10','Répifamiliale','dégradation de l état générale','Hypertension Artérielle, AVC','Hermie discale',3,253,'r1','00012354879','RESIDENCE NAZARETTE'),
(2,'DUPONT','Louis','1943-08-10','louisdup@yahoo.com','0465112233','rue du prince 7,1000 Bruxelles',2,'2019-08-12','Perte autonomie','normal','Chute, Hypercholestérolémie','Canal lombaire étroit',0, 473,'r2','11987634221','RESIDENCE NAZARETTE'),
(3,'VANDERKER','Vincent','1940-04-10','vincent23@gmail.com','0496764533','rue de comber 7,1020 Laeken',1,'2022-03-23','Solitude','confusion','Maladie Alzheimer, Diabète de type 2','Appendice cectomie, Prothèse totale de hanche',2,302,'r3','99001253675','RESIDENCE NAZARETTE'),
(4,'VANDERGE','Josephine','1933-04-30','josevan@gmail.com','0474332266','rue de lacombe 213,1000 Bruxelles',3,'2013-01-19','Décès du conjoint','Grabataire','Confusion, Insuffisance renale','Cramiectomie',1,101,'r4','00012354879','RESIDENCE NAZARETTE'),
(5,'DESCAETES','Julien','1955-07-10','descartes@gmail.com','0495231645','rue auguste snieders 3,1030 Schaerbeek',1,'2020-04-23','Dégradation de l état générale','Grabataire','Cholecystique, Colite ischémique','Prothèse totale de genou',1,240,'r5','00097685143','RESIDENCE NAZARETTE'),
(6,'LAFONTAINE','Jean','1930-05-04','jean232@gmail.com','0457654433','rue de barchon 15,1000 Bruxelles',3,'2012-09-23','Repifamiliale','Grabataire','Infection urinaire, arrêt cardiaque',' Hernie hiatale,Amputation',4,234,'r6','99001253675','RESIDENCE NAZARETTE');
--Réinitialise le compteur identity 
alter table TRESIDENT ALTER COLUMN ID RESTART WITH (select max(id)+1 from tresident);

MERGE INTO TPERSONNEEXTERNE(ID,NOM,PRENOM,EMAIL,TEL,CHOIX) values
(1,'MOUTON','Aristide','moutonast@gmail.com','0475467213',3),
(2,'VANDERBEURK','Marthe','sexymat@gmail.com','098342176',8),
(3,'SEUKAM','Elysée','LBByve@yahoo.com','0456778899',4),
(4,'TURNS','Steve','pineaple@gmail.com','071238945',7),
(5,'LACHEVRE','Akim','akimla@yahoo.com','0498123456',5),
(6,'RASTAMAN','Julio','exman@gmail.com','0985432365',0);
--Réinitialise le compteur identity 
alter table TPERSONNEEXTERNE ALTER COLUMN ID RESTART WITH (select max(id)+1 from tpersonneexterne);
 
MERGE INTO TRAPPORTVISITE(ID,DATE_VISITE,COMMENTAIRE,FKETABLISSEMENT,FKPERSONNE_EXTERNE,FKRESIDENT) values
(1,'2022-12-03','il était très content de me voir','RESIDENCE NAZARETTE',3,4),
(2,'2023-02-19','il ne voulais pas suivre son traitement ; après plusieurs négociations nous avons fait quelques exercices. Il semble troublé, mais je sais pour quel raison','RESIDENCE NAZARETTE',5,1),
(3,'2023-04-23','je ne suis pas vraiment rassuré de sa prise ne charge , mais il ne se plaint pas','RESIDENCE NAZARETTE',2,6);
--Réinitialise le compteur identity 
alter table TRAPPORTVISITE ALTER COLUMN ID RESTART WITH (select max(id)+1 from trapportVisite);
 
MERGE INTO TLIAISON(FKRESIDENT,FKPERSONNECONTACT) VALUES
(1,1),
(1,2),
(1,3),
(3,4),
(4,5),
(4,3),
(5,6),
(6,7),
(6,3),
(6,8);

MERGE INTO TVISITE(FKRESIDENT,FKPERSONNEEXTERNE) VALUES
(1,1),
(1,5),
(2,2),
(3,3),
(3,4),
(4,5),
(5,1),
(5,6);