INSERT INTO chat.user (login, passwd) VALUES ('Stella', 'stella');
INSERT INTO chat.user (login, passwd) VALUES ('Flora', 'flora');
INSERT INTO chat.user (login, passwd) VALUES ('Bloom', 'bloom');
INSERT INTO chat.user (login, passwd) VALUES ('Leila', 'leila');
INSERT INTO chat.user (login, passwd) VALUES ('Muse', 'muse');

INSERT INTO chat.room (chat_owner, chat_name) VALUES (1, 'chat1');
INSERT INTO chat.room (chat_owner, chat_name) VALUES (2, 'chat2');
INSERT INTO chat.room (chat_owner, chat_name) VALUES (3, 'chat3');
INSERT INTO chat.room (chat_owner, chat_name) VALUES (4, 'chat4');
INSERT INTO chat.room (chat_owner, chat_name) VALUES (5, 'chat5');

INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (1, 1, 'Hi', to_timestamp('2022     Aug','YYYY MON'));
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (2, 2, 'Hi', to_timestamp('2022     Aug','YYYY MON'));
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (3, 2, 'Hi', to_timestamp('2022     Aug','YYYY MON'));
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (4, 4, 'Hi', to_timestamp('2022     Aug','YYYY MON'));
INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (5, 4, 'Hi', to_timestamp('2022     Aug','YYYY MON'));

INSERT INTO chat.user_rooms (user_id, room_id) VALUES (1, 1);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (1, 2);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (1, 3);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (2, 3);
INSERT INTO chat.user_rooms (user_id, room_id) VALUES (3, 3);
