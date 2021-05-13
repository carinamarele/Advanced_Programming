--Laborator 10 OPTIONAL Baza de date
--Marele Carina-Ioana
--grupa 2A4
-------------------------------------------------------------------------
DROP TABLE messages;
DROP TABLE relation;
DROP TABLE user_network;

CREATE TABLE user_network(
  id_user NUMBER(5) NOT NULL PRIMARY KEY ,
  name VARCHAR2(30) NOT NULL,
  logged NUMBER(2)
);


CREATE TABLE relation(
id_user NUMBER(5),
id_friend NUMBER(5),
FOREIGN KEY (id_user) REFERENCES user_network(id_user)
);

CREATE TABLE messages(
 id_user NUMBER(5),
 messages VARCHAR2(400)
 );

INSERT INTO user_network(id_user,name,logged) VALUES(1,'carina',0);
INSERT INTO user_network(id_user,name,logged) VALUES(2,'cosmin',0);
INSERT INTO user_network(id_user,name,logged) VALUES(3,'ilie',0);

INSERT INTO relation(id_user, id_friend) values(1,2);
INSERT INTO relation(id_user, id_friend) values(2,1);
INSERT INTO messages(id_user, messages) values (1,'hello');
INSERT INTO messages(id_user, messages) values (1,'goodbye');
