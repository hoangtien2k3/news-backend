create database newsservice;
use newsservice;

create table categories (
     category_id integer not null auto_increment,
     name varchar(255),
     primary key (category_id)
) engine=InnoDB

create table news (
     category_id integer,
     news_id integer not null auto_increment,
     img varchar(255),
     link varchar(255),
     pub_date varchar(255),
     title varchar(255),
     primary key (news_id)
) engine=InnoDB

alter table news
add constraint FK6itmfjj4ma8lfpj10jx24mhvx
foreign key (category_id)
references categories (category_id)

