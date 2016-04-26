CREATE TABLE pings (
    id integer AUTO_INCREMENT PRIMARY KEY,
    title varchar(128) NOT NULL DEFAULT '',
    description varchar(256) NOT NULL DEFAULT '',
    create_time timestamp
);
