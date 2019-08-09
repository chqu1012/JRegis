CREATE TABLE IF NOT EXISTS Email(ID BIGINT AUTO_INCREMENT, CONTACT_ID BIGINT, NAME VARCHAR, ADDRESS VARCHAR);
INSERT INTO Email(ID, CONTACT_ID, NAME, ADDRESS) VALUES(1, 1, 'Private', 'pparker@mail.com');
INSERT INTO Email(ID, CONTACT_ID, NAME, ADDRESS) VALUES(2, 1, 'Work', 'ppark@work.com');
INSERT INTO Email(ID, CONTACT_ID, NAME, ADDRESS) VALUES(3, 1, 'Others', 'peter.parker@privatemail.com');
INSERT INTO Email(ID, CONTACT_ID, NAME, ADDRESS) VALUES(4, 2, 'Private', 'abell@mail.com');
INSERT INTO Email(ID, CONTACT_ID, NAME, ADDRESS) VALUES(5, 2, 'Work', 'abella@work.com');
INSERT INTO Email(ID, CONTACT_ID, NAME, ADDRESS) VALUES(6, 2, 'Others', 'anna.bell@privatemail.com');