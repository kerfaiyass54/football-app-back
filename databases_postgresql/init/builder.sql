CREATE TABLE builder (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         nationality VARCHAR(255) NOT NULL,
                         expertise VARCHAR(50),
                         year_established INT,
                         price INT NOT NULL
);

