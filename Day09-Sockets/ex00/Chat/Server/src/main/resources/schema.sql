drop table if exists users;

create table users (
    id SERIAL primary key,
    email varchar(100),
    password text
)