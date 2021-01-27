CREATE DATABASE student;
Use student;
CREATE TABLE Student (StudentID int,Name varchar(25),BatchID int,Phone int,Email varchar(25),PaymentStatus varchar(10),primary key(StudentID));
CREATE TABLE Batch (BatchID int,BatchName varchar(25),Courses varchar(25),FacultyID int,FeeDetails int,primary key(BatchID));
CREATE TABLE FeeStructure(PaymentID int,StudentID int,FeeDetails int,PaymentStatus varchar(10),primary key(PaymentID));
CREATE TABLE Faculty (FacultyID INT,FacultyName varchar(25),Designation varchar(20),ContactNo int,Email varchar(25),primary key(FacultyID));
CREATE TABLE EmergencyContact(EmployeeID int,EmployeeName varchar(25),Designation varchar(20),Contact int,Email varchar(20),primary key(EmployeeID));
INSERT INTO Student 
VALUES(101,'A',1001,1234,'A@123','Paid'),
(102,'B',1001,9234,'B@123','NotPaid'),
(201,'C',1002,8234,'C@123','Paid'),
(202,'D',1002,7234,'D@123','Paid'),
(301,'E',1003,6234,'E@123','NotPaid'),
(302,'F',1003,5234,'F@123','Paid');
INSERT INTO Batch
Values(1001,'Science','Regular',01,55000),
(1002,'Commerce','Regular',02,50000),
(1003,'Arts','Regular',03,45000);
INSERT INTO FeeStructure
Values(10011,101,55000,'Paid'),
(10012,102,55000,'NotPaid'),
(10021,201,50000,'Paid'),
(10022,202,50000,'Paid'),
(10031,301,45000,'NotPaid'),
(10032,302,45000,'Paid');
Insert into faculty
VALUES(01,'AA','Associate Professor',98765433,'AA@987'),
(02,'BB','Assistant Professor',98765453,'BB@987'),
(03,'CC','Associate Professor',98765473,'CC@987');
insert into emergencycontact
values(11,'ABC','OfficeStaff',76543,'abc@pqr'),
(12,'BCD','Clerk',76043,'bcd@pqr'),
(13,'CDE','Accountant',78543,'cde@pqr'),
(14,'DEF','Warden',76343,'def@pqr');