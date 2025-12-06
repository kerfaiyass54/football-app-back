CREATE TABLE referee (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         nationality VARCHAR(255) NOT NULL,
                         organizer_id BIGINT NOT NULL
);
