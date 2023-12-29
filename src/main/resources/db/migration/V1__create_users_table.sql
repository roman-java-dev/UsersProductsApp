CREATE TABLE users (
                           id bigint AUTO_INCREMENT PRIMARY KEY,
                           username VARCHAR(255) NOT NULL,
                           password VARCHAR(255) UNIQUE NOT NULL
);