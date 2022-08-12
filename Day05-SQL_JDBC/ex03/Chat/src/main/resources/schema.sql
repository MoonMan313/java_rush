CREATE SCHEMA if NOT EXISTS chat;

DROP TABLE if EXISTS chat.user_rooms, chat.msgs, chat.room, chat.user;

CREATE TABLE chat.user (
    id          serial NOT NULL primary key,
    login       text NOT NULL,
    passwd      text NOT NULL
);

CREATE TABLE chat.room (
    id          serial NOT NULL primary key ,
    chat_owner  int NOT NULL REFERENCES chat.user(id) ,
    chat_name   text NOT NULL
    );

CREATE TABLE chat.msgs (
    id          serial NOT NULL primary key,
    room_id     int NOT NULL REFERENCES chat.room(id),
    sender      int NOT NULL REFERENCES chat.user(id),
    message     text NOT NULL,
    time        timestamp
    );

CREATE TABLE chat.user_rooms (
    user_id    int NOT NULL REFERENCES chat.user(id),
    room_id    int NOT NULL REFERENCES chat.room(id)
);