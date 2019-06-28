
drop database if exists libraryManagement;
create database libraryManagement;
use libraryManagement;


create table books  ( 
		  bookId int auto_increment primary key
		, isbn varchar(50)
        , tittle varchar(255) not null
        , author varchar(255) not null
        , publisher varchar(255)
        , category varchar(100)
        , type varchar(100)
        , shelf varchar(100)
        , insertDate timestamp
        , number int
        );
        
create table patrons (
		  patronID int auto_increment primary key
        , name varchar(100) not null
        , dob date
        , address varchar(255)
        , registerDate timestamp
        );

create table user (
		  username varchar(100) primary key
		, patronId int
        , password varchar(255)
        , role varchar(100)
        );
        
create table charts (
		  bookId int 
		, patronId int
        , issusId int
        , expectedReturn date
        );
        
create table issuses (
		  issusId int auto_increment primary key
        , patronId int
        , bookId int
		, issusDate timestamp
        , expectedReturn date
        );

create table reserves (
	  patronID int primary key
    , bookID int not null
);
        
insert into books (isbn,tittle,author,category,type,shelf,insertDate,number) value ("24242636336","Database4","Phalin4","IT-004","Information Technology4","S004",now(),8);
insert into patrons (name,dob,address,registerDate) value ("Doeurn Phalin6",'1997-8-6',"Phnom Penh",now());
insert into user (username,password,patronId,role) value ("DoeurnPhalin6","ppp",6,"patron");

