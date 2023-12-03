MERGE INTO users KEY(id) VALUES (1, 'user1', 'password', 1);
MERGE INTO users KEY(id) VALUES (2, 'user2', 'password', 1);

MERGE INTO authorities KEY(id) VALUES (1, 'user1', 'ADMIN');
MERGE INTO authorities KEY(id) VALUES (2, 'user2', 'USER');

MERGE INTO posts KEY(id) VALUES (1, 1, 'テスト投稿', 1, '2023-11-10 01:01:01', '2023-11-10 01:01:01', '2023-12-01 01:01:01');
MERGE INTO posts KEY(id) VALUES (2, 2, 'テスト投稿', 1, '2023-11-11 01:01:01', '2023-11-21 01:01:01', '2023-12-01 01:01:01');
