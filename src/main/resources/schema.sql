CREATE TABLE users (
    id INT PRIMARY KEY NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled TINYINT NOT NULL
);

CREATE TABLE authorities (
    id INT PRIMARY KEY NOT NULL,
    username VARCHAR(255) NOT NULL,
    authority TEXT NOT NULL
);

CREATE TABLE posts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    content VARCHAR(255) NOT NULL,
    status VARCHAR(10) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    deadline DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);