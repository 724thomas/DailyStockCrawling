DROP TABLE COMPANY;

CREATE TABLE COMPANY (
                        COMPANYNAMEANDDATE VARCHAR(255),
                        COMPANYNAME VARCHAR(255),
                        URL VARCHAR(255),
                        JUGA FLOAT,
                        DUNGRAKRATE FLOAT,
                        SIGA FLOAT,
                        GOGA FLOAT,
                        ZEOGA FLOAT,
                        GEORAERYANG FLOAT,
                        STYPE VARCHAR(255),
                        VSYESTERDAY FLOAT,
                        STOCKDATE VARCHAR(255),
                        PRIMARY KEY (COMPANYNAMEANDDATE)
);

INSERT INTO COMPANY VALUES ('Kia','https://finance.naver.com/item/main.naver?code=000270',0,0,0,0,0,0,'',0,'');
INSERT INTO COMPANY VALUES ('삼성전자','https://finance.naver.com/item/main.nhn?code=005930');
INSERT INTO COMPANY VALUES ('카카오','https://finance.naver.com/item/main.naver?code=035720');