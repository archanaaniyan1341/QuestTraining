SHOW DATABASES;
CREATE DATABASE demo1;
USE demo1;
SHOW TABLES;
CREATE TABLE customer (ID int, Name varchar(20),Gender char(1),Stream varchar(20),Marks int);
SHOW TABLES;
DESCRIBE customer;
INSERT INTO customer 
VALUES(1,'Archana','F','Science',90),
(2,'Aswathy','F','Commerce',100),
(3,'Aswin','M','Commerce',80),
(4,'Anna','F','Science',100),
(5,'Aswanth','M','Commerce',60)
;
INSERT INTO customer
VALUES(1,'Archana','F','Science','100');
SELECT * FROM customer;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM customer WHERE ID=1 AND Marks=100;
UPDATE customer SET Marks=95 WHERE ID=1;
SELECT * FROM customer WHERE (ID=5 AND Gender='M') OR (ID=4 AND Gender='F');
SELECT Name FROM customer;
SELECT Name,Marks FROM customer;
SELECT Name,Marks FROM customer WHERE Gender='F';
SELECT * FROM customer ORDER BY Marks;
SELECT * FROM customer ORDER BY Marks desc;
SELECT * FROM customer ORDER BY  Marks desc,Name;
SELECT * FROM customer ORDER BY  Name, Marks desc;
use demo1;
CREATE TABLE report (ID int,English int,Maths int,Social int,Term int);
INSERT INTO report
 VALUES 
 (1,100,80,90,1),
(1,78,80,60,2),
(2,90,81,91,1),(2,89,88,89,2),(3,67,78,80,1),(3,100,80,90,2),(4,67,89,74,1),(4,56,78,90,2);
DESCRIBE report;
SELECT * FROM report;
 -- Solutions
 -- 1)english marks of Archana
 SELECT customer.ID,Name,English,Term
 From customer INNER JOIN report
 ON customer.ID=report.ID
 WHERE Name='Archana';
 -- 2)Find max marks
SELECT  max(Marks)
FROM customer;

 -- 3)Who got max mark
SELECT Name,Marks
FROM customer
WHERE Marks= (SELECT max(Marks)
from customer);
 -- 4) View as in question
CREATE VIEW disp1 AS
SELECT customer.ID,Name,Gender,Stream,Marks,
CASE when English is null then '-' else report.English end as English ,
CASE when Maths is null then '-' else report.Maths end as Maths,
CASE when Social is null then '-' else report.Social end as Social
FROM customer LEFT JOIN report
ON customer.ID=report.ID;

-- 5) Show all detail of stream science batch in names ascending order
Use demo1;
SELECT *
 FROM customer LEFT JOIN report
 ON customer.id=report.id
 WHERE Stream='Science'
 ORDER BY NAME;
 
-- 6) Show all detail of stream science batch in names ascending order having marks>=100
 SELECT customer.ID,Name,Gender,Stream,Marks,English,Maths,Social
FROM customer INNER JOIN report
ON customer.ID=report.ID
WHERE customer.Stream='Science' AND Marks>=100;
-- 7)Find total of subjectwise marks for each term
SELECT id,English,Maths,Social,Term,English+Maths+Social as Total
FROM  report;
-- 8)sum of marks for each subject for two terms
USE demo1;
SELECT CUSTOMER.ID,Name,sum(English),sum(Maths),sum(Social) 
FROM customer LEFT JOIN report
ON customer.ID=report.ID
GROUP BY Name;
-- 9)sum of marks for each subject for Archana
SELECT CUSTOMER.ID,Name,sum(English),sum(Maths),sum(Social) 
FROM customer LEFT JOIN report
ON customer.ID=report.ID
WHERE Name='Archana';
-- 10)Find average mark of science batch
SELECT Avg((English+Maths+Social)/3) as Average
FROM customer LEFT JOIN report
ON customer.ID=report.ID
WHERE Stream='Science';




