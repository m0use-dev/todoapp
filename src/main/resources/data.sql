INSERT INTO users (id, username, password, enabled) VALUES (1, 'user1', 'password', 1);
INSERT INTO users (id, username, password, enabled) VALUES (2, 'user2', 'password', 1);

INSERT INTO authorities (id, username, authority) VALUES (1, 'user1', 'ADMIN');
INSERT INTO authorities (id, username, authority) VALUES (2, 'user2', 'USER');

INSERT INTO posts (id, user_id, content, status, created_at, updated_at, deadline) VALUES (1, 1, 'テスト投稿', 1, '2023-11-10', '2023-11-10', '2023-12-10');
INSERT INTO posts (id, user_id, content, status, created_at, updated_at, deadline) VALUES (2, 2, 'テスト投稿', 1, '2023-11-11', '2023-11-11', '2023-12-03');
