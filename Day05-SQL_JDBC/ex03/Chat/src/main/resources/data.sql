INSERT INTO chat.user (login, passwd) VALUES ('Stella', 'stella');


INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (1, 1, 'Hi', to_timestamp('2022     Aug','YYYY MON'));


INSERT INTO chat.user_rooms (user_id, room_id) VALUES (1, 1);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (1, 2);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (1, 3);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (2, 3);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (3, 3);
