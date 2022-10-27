DROP TABLE COMPANY;

CREATE TABLE COMPANY (
                        COMPANYNAME VARCHAR(255),                  -- 이름
                        URL VARCHAR(255),               -- 나이
                        PRIMARY KEY (COMPANYNAME)
);


INSERT INTO COMPANY VALUES ('기아','https://finance.naver.com/item/main.naver?code=000270');
INSERT INTO COMPANY VALUES ('삼성전자','https://finance.naver.com/item/main.nhn?code=005930');
INSERT INTO COMPANY VALUES ('카카오','https://finance.naver.com/item/main.naver?code=035720');