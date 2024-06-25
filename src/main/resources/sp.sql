CREATE  DATABASE SP
CREATE  TABLE CLIENT
    (
        ID integer primary key not null AUTO_INCREMENT,
        EMAIL varchar(50) UNIQUE

);
CREATE TABLE  SENTIMENT
(
    ID integer primary key not null AUTO_INCREMENT,
    TEXTE varchar(50),
    TYPE varchar(10),
    Client_ID integer,
    CONSTRAINT  client_fk FOREIGN KEY (Client_ID) REFERENCES CLIENT(ID)


)
