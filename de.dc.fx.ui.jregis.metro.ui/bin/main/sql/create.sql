CREATE TABLE DOCUMENT(
    ID BIGINT AUTO_INCREMENT,
    CATEGORY_ID BIGINT NOT NULL,
    DESCRIPTION CLOB NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    URL VARCHAR(255),
    CREATED_ON TIMESTAMP NOT NULL,
    UPDATED_ON TIMESTAMP,
    STATUS_ID BIGINT NOT NULL
);

CREATE TABLE DOCUMENT_HISTORY(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DOCUMENT_ID BIGINT NOT NULL,
    NAME CLOB NOT NULL,
    CREATED_ON TIMESTAMP NOT NULL,
    UPDATED_ON TIMESTAMP,
    STATUS_ID BIGINT NOT NULL
);

CREATE TABLE DOCUMENT_CATEGORY(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    PARENT_ID BIGINT,
    CREATED_ON TIMESTAMP NOT NULL,
    UPDATED_ON TIMESTAMP
);

CREATE TABLE DOCUMENT_ATTACHMENT(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    HISTORY_ID BIGINT NOT NULL,
    CREATED_ON TIMESTAMP NOT NULL,
    UPDATED_ON TIMESTAMP,
    STATUS_ID BIGINT NOT NULL
);

CREATE TABLE STATUS(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    CREATED_ON TIMESTAMP NOT NULL,
    UPDATED_ON TIMESTAMP,
);

CREATE TABLE DOCUMENT_NAME_SUGGESTION(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

CREATE TABLE CLIPBOARD_NAME_SUGGESTION(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

CREATE TABLE REFERENCE(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	REFERENCE_TYPE_ID BIGINT NOT NULL,
	FIRST_ID BIGINT NOT NULL,
	SECOND_ID BIGINT NOT NULL,
	CREATED_ON TIMESTAMP NOT NULL,
    UPDATED_ON TIMESTAMP
);

CREATE TABLE REFERENCE_TYPE(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL,
	DESCRIPTION VARCHAR(255),
	CREATED_ON TIMESTAMP NOT NULL,
    UPDATED_ON TIMESTAMP
);