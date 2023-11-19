INSERT INTO users (id, username, password, enabled) VALUES ( 1, 'user1', 'password', 1) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO users (id, username, password, enabled) VALUES ( 2, 'user2', 'password', 1) ON DUPLICATE KEY UPDATE id=id;

INSERT INTO authorities (id, username, authority) VALUES ( 1, 'user1', 'ADMIN') ON DUPLICATE KEY UPDATE id=id;
INSERT INTO authorities (id, username, authority) VALUES ( 2, 'user2', 'USER') ON DUPLICATE KEY UPDATE id=id;

INSERT INTO posts (id, user_id, content, status,created_at ,updated_at,deadline) VALUES ( 1 , 1 , 'テスト投稿' , 1, '2023-11-10 01:01:01', '2023-11-10 01:01:01', '2023-12-01 01:01:01') ON DUPLICATE KEY UPDATE id=id;
INSERT INTO posts (id, user_id, content, status,created_at ,updated_at,deadline) VALUES ( 2 , 2 , 'テスト投稿' , 1, '2023-11-11 01:01:01', '2023-11-21 01:01:01', '2023-12-01 01:01:01') ON DUPLICATE KEY UPDATE id=id;