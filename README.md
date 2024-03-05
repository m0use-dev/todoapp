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
| id | INT | NO |  |
| username | VARCHAR(255) | NO |  |
| password | VARCHAR(255) | NO |  |
| enabled | TINYINT | NO |  |

### authoritiesテーブル
| フィールド | タイプ | Null | 備考 |
| ---- | ---- | ---- | ---- |
| id | INT | NO |  |
| username | VARCHAR(255) | NO |  |
| authority | TEXT | NO |  |

### postsテーブル
| フィールド      | タイプ | Null | 備考 |
|------------| ---- | ---- | ---- |
| id         | INT | NO | 投稿ID |
| username   | INT | NO | 投稿者ID |
| content    | VARCHAR(255) | NO | 内容 |
| status     | VARCHAR(10) | NO | 状態 |
| created_at | DATE | NO | 登録日 |
| updated_at | DATE | NO | 更新日 |
| deadline   | DATE |  | 期限 |

## テスト仕様書兼実績書
| 番号 | テスト対象 | テストの概要 | 前提条件 | 実施事項 | 確認内容 | 実行日 | 結果 |
|----| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1  |  |  |  |  |  |  |  |
| 2  |  |  |  |  |  |  |  |
| 3  |  |  |  |  |  |  |  |
| 4  |  |  |  |  |  |  |  |
| 5  |  |  |  |  |  |  |  |
| 6  |  |  |  |  |  |  |  |
| 7  |  |  |  |  |  |  |  |
| 8  |  |  |  |  |  |  |  |
| 9  |  |  |  |  |  |  |  |
| 10 |  |  |  |  |  |  |  |
| 11 |  |  |  |  |  |  |  |
| 12 |  |  |  |  |  |  |  |
| 13 |  |  |  |  |  |  |  |
| 14 |  |  |  |  |  |  |  |
| 15 |  |  |  |  |  |  |  |
| 16 |  |  |  |  |  |  |  |
| 17 |  |  |  |  |  |  |  |
| 18 |  |  |  |  |  |  |  |
| 19 |  |  |  |  |  |  |  |
| 20 |  |  |  |  |  |  |  |
