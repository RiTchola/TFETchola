MERGE INTO TETABLISSEMENT(NOM,EMAIL1,EMAIL2,TEL1,TEL2,ADRESSE,DATECREATION,FKUSER) values
('RESIDENCE NAZARETTE','nazarette@yahoo.com','nazarette@skynet.be','071124368','071165894','rue de lacombe 7,1000 Bruxelles','24-04-1990','');


MERGE INTO TPERSONNECONTACT(NOM,PRENOM,DATENAISSANCE,EMAIL,TEL1,TEL2,ADRESSE,STATUTM,TYPEC,FKUSER) values
('TCHOLA','Rina','21-04-1998','rina237@gmail.com','0465335698','0498576973','rue de mons 12,1070 Anderlecht','celibataire','ENFANT',''),
('LUBBERT','Christiano','29-08-1989','elysee229@yahoo.com','0495237854','0665129854','rue de la louviere,7000 Mons ','marié','AUTREFAMILLE’,''),
('BAYANGAM','Ulrich','17-06-1990','bayangam237@gmail.com','0475287619','0460117632','rue neuve 10,1010 Schaerbeek','marié', ‘AUTREFAMILLE',''),
('SIMC','Thierry','21-10-1988','sim229@yahoo.com','0496543219','0451389078','rue de merode 62,5000 Namur','divorcé','AUTRE',''),
('NDJIKE','Cyril','13-03-1991','loveur@yahoo.com','0498765431','0476421329','chausée de bruxelles 19,7000 Mons','celibataire','AMI',''),
('SKYS','Shamir','24-12-1996','skysdaniel@gmail.com','0765432189','0465387241','chausée de gilly 79, 6040 Jumet','marié','FILS',''),
('SCORIER','Antoine','16-08-1980','exantoine@yahoo.com','071135496','0495237864',' chausée de mons 79,1000 Bruxelles','marié','AVOCAT',''),
('TASSE','Maristo','24-01-1995','pinemarius@gmail.com','0474321789','O432199087','Rue de constantinoble 10,4000 Liege','marié','PETITFILS','');

 
MERGE INTO TRESIDENT(NOM,PRENOM,DATENAISSANCE,EMAIL,TEL,ADRESSE,DATEENTREE,MOTIFENTREE,ETATSANTE,ANTMEDICAL,ANTCHIRUGICAL,NBENFANT,CHAMBRE,FKUSER) values
('DUPUIT','Marie','1-01-1950','dupuitmarie@gmail.com','0460001188','rue de joujoute 7,1000 Bruxelles','10-01-2020','Répifamiliale','dégradation de l’état générale’,’ Hypertension Artérielle, AVC','Hermie discale',3,253,''),
('DUPONT','Louis','10-08-1933','louisdup@yahoo.com','0465112233','rue du prince 7,1000 Bruxelles','12-08-2019','Perte d’autonomie','normal','Chute, Hypercholestérolémie’,’Canal lombaire étroit', 0, 473,''),
('VANDERKER','Vincent','10-04-1940','vincent23@gmail.com','0496764533','rue de comber 7,1020 Laeken','23-03-2022','Solitude','confusion','Maladie d'Alzheimer, Diabète de type 2','Appendice cectomie, Prothèse totale de hanche',2,302,''),
('VANDERGE','Josephine','30-04-1923','josevan@gmail.com','0474332266','rue de lacombe 213,1000 Bruxelles','19-01-2013','Décès du conjoint','Grabataire','Confusion, Insuffisance renale','Cramiectomie',1,101,''),
('DESCAETES','Julien','10-07-1945','descartes@gmail.com','0495231645','rue auguste snieders 3,1030 Schaerbeek','23-04-2020','Dégradation de l'état générale','Grabataire','Cholecystique, Colite ischémique','Prothèse totale de genou',1,240,''),
('LAFONTAINE','Jean','04-05-1930','jean232@gmail.com','0457654433','rue de barchon 15,1000 Bruxelles','23-09-2012','Repifamiliale','Grabataire','Infection urinaire, arrêt cardiaque’,’ Hernie hiatale,Amputation',4,234,'');


MERGE INTO TPERSONNEEXTERNE(NOM,PRENOM,DATENAISSANCE,EMAIL,TEL1,TEL2,ADRESSE,TYPEE,FKUSER) values
('MOUTON','Aristide','12-03-1989','moutonast@gmail.com','0475467213','0457112244','rue de la lumiere 34,1070 Anderlecht','ENFANT',''),
('VANDERBEURK','Marthe','21-09-1999','sexymat@gmail.com','098342176','0465904560','Chausée de mars 45,6000 Charleroi','PETITFILS',''),
('SEUKAM','Elysée','31-08-1975','LBByve@yahoo.com','0456778899','0499665533','Rue d'elouges,7370 Dour','AMI',''),
('TURNS','Steve','23-09-1980','pineaple@gmail.com','071238945','0497124578','Chaussé de mons, 1000 Bruxelles’,’ KINESITHERAPEUTE',''),
('LACHEVRE','Akim','28-02-1990','akimla@yahoo.com','0498123456','0475119933','rue neuve 10,1010 schaarbecK','ENFANT',''),
('RASTAMAN','Julio','23-07-1986','exman@gmail.com','0985432365','0465778890','rue neuve 19,6001 Marcinelle','AMI','');

 
MERGE INTO TRAPPORT(NOM,PRENOM,TYPEE,DATEVISITE,DESCRIPTION) values
('BOUCHE','Marine','AMI','14-06-2023','il était très content de me voir'),
('MOHAMMED','Salir','KINESITHERAPEUTE','19-07-2023','il n’a pas voulu suivre son traitement ; après plusieurs négociations nous avons fait quelques exercices. Il semble troublé, mais je n’ai pas pu déterminer pourquoi'),
('RASTINE','Omar','ENFANT','23-07-2023','je ne suis pas vraiment rassuré de sa prise ne charge , mais il n’a pas l’air de se plaindre');

 
MERGE INTO TMEDECINTRAITANT(NOM,PRENOM,DATENAISSANCE,EMAIL,TEL1,TEL2,ADRESSE,NUMINAMI,FKUSER) values
('VANDERKAM','Anne','31-12-1978','anne@skynet.be','071419856','0497234512','rue dourlet 13,6000 Charleroi','00012354879',''),
('GIWA','Myriam','23-09-1980','giwamyr@yahoo.com','0475119933','071952390','rue lodelinsart 23,6040 Jumet','11987634221',''),
('LEJEUNE','Anasthasie','23-09-1989','lejeune@skynet.be','0475119933','071238949','Chausée de lion 67,4000 Liege','99001253675',''),
('LAVENS','Cathy','31-12-1976','cathy@skynet.be','071238945','0712382390','chausée de gilly 18,6030 Marchienne','00097685143',''),
('BOHY','Richard','16-04-1970','maisonmedical@yahoo.com','071238945','07123O198','Rue de constantinoble 10,4000 Liege','00087694562','');
