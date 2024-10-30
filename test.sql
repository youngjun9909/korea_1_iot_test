CREATE DATABASE test;
USE test;
CREATE TABLE books (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR(100) NOT NULL,
    book_author VARCHAR(100) NOT NULL,
    book_category ENUM("인문", "사회", "과학기술", "기타") NOT NULL DEFAULT "기타"
);