INSERT INTO users (id, username, password, enabled) VALUES (1, 'user1', '$2a$10$Gmt4ietyMOa2IdFLBUguj.myt.5D9h1ObqSSbbkQOkF/Efc9h8/US', 1);
INSERT INTO users (id, username, password, enabled) VALUES (2, 'user2', '$2a$10$0vW2T/l3yCZoCPB4e/cYbOlEzSvs9WurjAVvo/VDbHp7J/MoFojdW', 1);
INSERT INTO users (id, username, password, enabled) VALUES (3, 'user3', '$2a$10$nFnTYkT6KMX5bwC25ms26.2wXEvNXHcp.FSpXbJ3YJ6J5DpYl5Rau', 1);
INSERT INTO users (id, username, password, enabled) VALUES (4, 'user4', '$2a$10$5d7coWQnitQXMTaM/Nppn.UmrJhnKbBsURQh8juuthcwpVFlqRMQm', 1);

INSERT INTO authorities (id, username, authority) VALUES (1, 'user1', 'ROLE_ADMIN');
INSERT INTO authorities (id, username, authority) VALUES (2, 'user2', 'ROLE_USER');
INSERT INTO authorities (id, username, authority) VALUES (3, 'user3', 'ROLE_USER');
INSERT INTO authorities (id, username, authority) VALUES (4, 'user4', 'ROLE_USER');

INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿1', '未対応', '2023-11-10', '2023-11-10', '2023-11-12');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿2', '未対応', '2023-11-11', '2023-11-11', '2023-11-20');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿3', '完了', '2023-11-12', '2023-11-12', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿4', '未対応', '2023-11-15', '2023-11-19', '2023-11-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿5', '未対応', '2023-11-17', '2023-11-19', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿6', '完了', '2023-11-20', '2023-11-25', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿7', '未対応', '2023-12-02', '2023-12-02', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿8', '完了', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿9', '未対応', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿10', '完了', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿11', '未対応', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿12', '未対応', '2023-12-10', '2023-12-10', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿13', '未対応', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (4, 'テスト投稿14', '完了', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿15', '未対応', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (3, 'テスト投稿16', '完了', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿17', '未対応', '2023-12-10', '2023-12-10', NULL);
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (1, 'テスト投稿18', '完了', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (4, 'テスト投稿19', '未対応', '2023-12-10', '2023-12-10', '2023-12-25');
INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline) VALUES (2, 'テスト投稿20', '未対応', '2023-12-10', '2023-12-10', '2023-12-25');
