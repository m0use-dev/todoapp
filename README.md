# TODOアプリ

## テスト用ユーザー情報
| ユーザー名 | パスワード | 権限 |
| ---- | ---- | ---- |
| user1 | password | ADMIN |
| user2 | password | USER |
| user3 | password | USER |
| user4 | password | USER |

## データベース
### usersテーブル
| フィールド | タイプ | Null | 備考 |
| ---- | ---- | ---- | ---- |
| id | VARCHAR(255) | NO |  |
| username | VARCHAR(255) | NO |  |
| password | TINYINT | NO |  |

### authoritiesテーブル
| フィールド | タイプ | Null | 備考 |
| ---- | ---- | ---- | ---- |
| id | INT | NO |  |
| username | VARCHAR(255) | NO |  |
| authority | TEXT | NO |  |

### postsテーブル
| フィールド | タイプ | Null | 備考 |
| ---- | ---- | ---- | ---- |
| id | INT | NO | 投稿ID |
| user_id | INT | NO | 投稿者ID |
| content | VARCHAR(255) | NO | 内容 |
| status | VARCHAR(10) | NO | 状態 |
| created_at | DATE | NO | 登録日 |
| updated_at | DATE | NO | 更新日 |
| deadline | DATE |  | 期限 |