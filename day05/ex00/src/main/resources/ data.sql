INSERT INTO chat.Users(login, password) VALUES
    ('Ben', '12345678'),
    ('Sem', '12345678'),
    ('Roma', '12345678'),
    ('Kate', '12345678'),
    ('Ivan', '11111111');


INSERT INTO chat.Chatrooms(name, owner) VALUES
    ('001', 1),
    ('002', 1),
    ('002', 1),
    ('004', 2),
    ('005', 3),
    ('006', 4),
    ('007', 5);


INSERT INTO chat.Massages(author, room_id, text_msg, datetime) VALUES
    (1, 1, 'Hi my name is BEN', now()),
    (2, 2, 'Hi my name is SEM', now()),
    (3, 3, 'Hi my name is ROMA', now()),
    (4, 4, 'Hi my name is KATE', now()),
    (5, 5, 'Hi my name is IVAN', now());

