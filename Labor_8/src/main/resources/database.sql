-------------------------------------------------------------------------------------------------
--JAVA - Laborator 8
--@author: Carina I.M. 2A4
-------------------------------------------------------------------------------------------------
drop table Directors;
drop table Actors;
drop table Person;
drop table film;
drop table movies;
drop table genres;

create table movies
(
    id_movie      number(4)   primary key,
    title         varchar(60) not null,
    release_date  date        not null,
    duration      number(4)   not null,
    score         number(3,2) not null,
    check (duration > 0)
);

create table genres
(
    id_genre number(4)   primary key,
    name     varchar(20) not null
);

create table film
(
    id_movie number(4) references movies (id_movie),
    id_genre number(4) references genres (id_genre)
);

create table Person
(
    id_pers number(4)       primary key,
    nume    varchar(20)     not null,
    prenume varchar(20)     not null,
    gender  varchar(10)     not null,
    age     number(4)       not null
);
create table Actors
(
    id_pers  number(4) references Person(id_pers),
    id_movie number(4) references movies(id_movie)
);
create table Directors
(
    id_pers  number(4) references Person(id_pers),
    id_movie number(4) references movies(id_movie)
);

-------------------------------------------------------------------------------------------------
insert into movies values(0,'The Avengers', to_date('2008','YYYY'),165,7.9);
insert into movies values(1,'Cinderella',to_date('1959','YYYY'),142,8.2);
insert into movies values(2,'Another Day',to_date('1989','YYYY'),101,7.9);

insert into genres values(0, 'Drama');
insert into genres values(1, 'Crime');
insert into genres values(2, 'Romance');
insert into genres values(3, 'Action');
insert into genres values(4, 'Fiction');

insert into film values(0,0);
insert into film values(0,1);
insert into film values(2,0);
insert into film values(2,2);
insert into film values(2,3);
insert into film values(1,3);

insert into Person values(3,'Mara','Anghel','feminin',48);
insert into Person values(1,'Popa','Adela','feminin',37);
insert into Person values(2,'Anghel','Andrei','masculin',54);

insert into Actors values(3,1);
insert into Actors values(1,2);

insert into Directors values(2,2);




