INSERT INTO users (id, username, password, enabled) VALUES (1, 'user1', 'password', 1);
INSERT INTO users (id, username, password, enabled) VALUES (2, 'user2', 'password', 1);

INSERT INTO authorities (id, username, authority) VALUES (1, 'user1', 'ROLE_ADMIN');
INSERT INTO authorities (id, username, authority) VALUES (2, 'user2', 'ROLE_USER');

INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿1', '未対応', '2023-11-10', '2023-11-10', '2023-11-12');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿2', '未対応', '2023-11-11', '2023-11-11', '2023-11-20');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿3', '完了', '2023-11-12', '2023-11-12', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿4', '未対応', '2023-11-15', '2023-11-19', '2023-11-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿5', '未対応', '2023-11-17', '2023-11-19', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿6', '完了', '2023-11-20', '2023-11-25', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿7', '未対応', '2023-12-02', '2023-12-02', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿8', '完了', '2023-12-10', '2023-12-10', '2023-12-25');
