DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA IF NOT EXISTS chat;

CREATE  TABLE if not exists chat.Users(
    user_id serial PRIMARY KEY,
    login text UNIQUE NOt NULL,
    password text NOT NULL
);

CREATE  TABLE if not exists chat.Chatrooms(
    room_id serial PRIMARY KEY,
    name text NOT NULL,
    owner integer REFERENCES chat.Users(user_id)
);

CREATE TABLE if not exists chat.Massages(
    id serial PRIMARY KEY,
    text_msg text NOT NULL,
    datetime timestamp NOT NULL,
    author integer REFERENCES chat.Users(user_id),
    room_id integer REFERENCES chat.Chatrooms(room_id)
);

