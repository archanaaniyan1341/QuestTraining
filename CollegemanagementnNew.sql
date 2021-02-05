CREATE DATABASE management;
Use management;
Create table batch_details(batch_id int primary key,batch_name varchar(25),fee int);
INSERT INTO batch_details
values(1001,'BSc',50000),
(1002,'BCom',45000),
(1003,'BA',40000);
SELECT * FROM batch_details;
CREATE TABLE student(student_id int primary key ,FIRST_NAME VARCHAR(20),LAST_NAME VARCHAR(20),batch_id int,GENDER CHAR,foreign key(batch_id) references batch_details(batch_id));
INSERT INTO student
VALUES(101,'Amar','S',1001,'M'),
(102,'Annit','Stanly',1002,'F'),
(103,'Ance','Tom',1001,'F'),
(104,'Albino','Gomaz',1003,'M'),
(105,'Liston','Colaco',1002,'M'),
(106,'Jorden','Morrey',1003,'M');
SELECT * FROM student;
Create table teacher(teacher_id varchar(10) primary key,name varchar(20),designation varchar(20),batch_id int,foreign key(batch_id) references batch_details(batch_id));
insert INTO teacher
values('BS101','Anu George','Professor',1001),
('BC101','Umesh AC','Professor',1002),
('BA101','Riyas KS','Associate Professor',1003),
('BS102','Annie George','Assistant Professor',1001),
('BC102','Ben Thomas','Assistant Professor',1002),
('BA102','George Sam','Assistant Professor',1003);
Create table emergency_contact(unique_id varchar(10) primary key,Name varchar(20),Phone int);
insert into emergency_contact
values('EC11','Alex',678954321),
('EC12','Amal',987654321),
('EC13','Anupama',765432109);
Select* from emergency_contact;
Create table fee_details(payment_id int primary key,student_id int,Payment_Amount int,Payment_status varchar(20),foreign key(student_id) references student(student_id));
INSERT INTO Fee_details
Values(10011,101,55000,'Partial'),
(10012,102,55000,'NotPaid'),
(10021,103,50000,'Completed'),
(10022,104,50000,'Completed'),
(10031,105,45000,'NotPaid'),
(10032,106,45000,'Partial');
select * from fee_details