<?xml version="1.0" encoding="UTF-8"?>

--<dataset>
--  <テーブル名 カラム1="カラム1の内容" カラム2="カラム2の内容" />
--  データセット用のXMLでは数値データも""で囲む
--  DATEやTIMESTAMP型の日付は「-」つなぎで指定する
--</dataset>

<dataset>
--  <users id="idの内容" username="usernameの内容" password="passwordの内容" enabled="enabledの内容" />
    <users id="1" username="user1" password="$2a$10$Gmt4ietyMOa2IdFLBUguj.myt.5D9h1ObqSSbbkQOkF/Efc9h8/US" enabled="1" />
    <users id="2" username="user2" password="$2a$10$0vW2T/l3yCZoCPB4e/cYbOlEzSvs9WurjAVvo/VDbHp7J/MoFojdW" enabled="1" />
    <users id="3" username="user3" password="$2a$10$nFnTYkT6KMX5bwC25ms26.2wXEvNXHcp.FSpXbJ3YJ6J5DpYl5Rau" enabled="1" />
    <users id="4" username="user4" password="$2a$10$5d7coWQnitQXMTaM/Nppn.UmrJhnKbBsURQh8juuthcwpVFlqRMQm" enabled="1" />

--  <authorities id="idの内容" username="usernameの内容" authority="authorityの内容" />
    <authorities id="1" username="user1" authority="ROLE_ADMIN" />
    <authorities id="2" username="user2" authority="ROLE_USER" />
    <authorities id="3" username="user3" authority="ROLE_USER" />
    <authorities id="4" username="user4" authority="ROLE_USER" />

--  <posts username="usernameの内容" content="contentの内容" status="statusの内容" created_at="created_atの内容" updated_at="updated_atの内容" deadline="deadlineの内容" />
    <posts username="user1" content="テスト投稿1" status="未完了" created_at="2023-11-10" updated_at="2023-11-10" deadline="2023-11-12" />
    <posts username="user2" content="テスト投稿2" status="未完了" created_at="2023-11-11" updated_at="2023-11-11" deadline="2023-11-20" />
    <posts username="user1" content="テスト投稿3" status="完了" created_at="2023-11-12" updated_at="2023-11-12" deadline="NULL" />
    <posts username="user1" content="テスト投稿4" status="未完了" created_at="2023-11-15" updated_at="2023-11-19" deadline="2023-11-25" />
    <posts username="user2" content="テスト投稿5" status="未完了" created_at="2023-11-17" updated_at="2023-11-19" deadline="NULL" />
    <posts username="user1" content="テスト投稿6" status="完了" created_at="2023-11-20" updated_at="2023-11-25" deadline="2023-12-25" />
    <posts username="user1" content="テスト投稿7" status="未完了" created_at="2023-12-02" updated_at="2023-12-02" deadline="NULL" />
    <posts username="user1" content="テスト投稿8" status="完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user2" content="テスト投稿9" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user1" content="テスト投稿10" status="完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user2" content="テスト投稿11" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user1" content="テスト投稿12" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="NULL" />
    <posts username="user1" content="テスト投稿13" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user4" content="テスト投稿14" status="完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user1" content="テスト投稿15" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user3" content="テスト投稿16" status="完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user2" content="テスト投稿17" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="NULL" />
    <posts username="user1" content="テスト投稿18" status="完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user4" content="テスト投稿19" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
    <posts username="user2" content="テスト投稿20" status="未完了" created_at="2023-12-10" updated_at="2023-12-10" deadline="2023-12-25" />
</dataset>