create sequence hibernate_sequence start 1 increment 1;

create table user_model(
    id int8 not null,
    avatar varchar(255),
    email varchar(255),
    name varchar(255),
    status boolean,
    timestamp timestamp,
    primary key (id));