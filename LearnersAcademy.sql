create database learnersacademy;
use learnersacademy;

insert into grade(name)
values('FullStack Java');
insert into grade(name)
values('Operating System');
insert into grade(name)
values('Machine Learning');
insert into grade(name)
values('Artificial Intelligence');
insert into grade(name)
values('Dev Ops');
SELECT * FROM grade;

-- class 1
insert into subject(name, clsId)
values('Core Java', 1);
insert into subject(name, clsId)
values('J2EE', 1);
insert into subject(name, clsId)
values('Hibernate', 1);
insert into subject(name, clsId)
values('Spring', 1);
insert into subject(name, clsId)
values('Spring MVC', 1);

-- class 2
insert into subject(name, clsId)
values('Windows 8', 2);
insert into subject(name, clsId)
values('Windows 10', 2);
insert into subject(name, clsId)
values('Linux', 2);
insert into subject(name, clsId)
values('Unix', 2);
insert into subject(name, clsId)
values('Android', 2);

-- class 3
insert into subject(name, clsId)
values('Artificial Intelligence', 3);
insert into subject(name, clsId)
values('Data Science', 3);
insert into subject(name, clsId)
values('Computer Science', 3);
insert into subject(name, clsId)
values('Statistics', 3);
insert into subject(name, clsId)
values('Mathematics', 3);

-- class 4
insert into subject(name, clsId)
values('Problem Solving', 4);
insert into subject(name, clsId)
values('Reasoning', 4);
insert into subject(name, clsId)
values('Planning', 4);
insert into subject(name, clsId)
values('Computer Vision', 4);
insert into subject(name, clsId)
values('Mathematics', 4);

-- class 5
insert into subject(name, clsId)
values('Continuous development', 5);
insert into subject(name, clsId)
values('Continuous delivery', 5);
insert into subject(name, clsId)
values('Continuous integration', 5);
insert into subject(name, clsId)
values('Continuous deployment', 5);
insert into subject(name, clsId)
values('Continuous monitoring', 5);

-- Teachers
INSERT INTO teacher (tid, name, clsId) VALUES (1, 'Washington', 1);
INSERT INTO teacher (tid, name, clsId) VALUES (2, 'Adams', 1);
INSERT INTO teacher (tid, name, clsId) VALUES (3, 'Jefferson', 2);
INSERT INTO teacher (tid, name, clsId) VALUES (4, 'Lincoln', 2);
INSERT INTO teacher (tid, name, clsId) VALUES (5, 'Albert', 3);
INSERT INTO teacher (tid, name, clsId) VALUES (6, 'Jack', 4);
INSERT INTO teacher (tid, name, clsId) VALUES (7, 'Mohan', 5);

-- Students
INSERT INTO student (stuid, name, clsId) VALUES (1, 'Simon', 1);
INSERT INTO student (stuid, name, clsId) VALUES (2, 'Alvin', 1);
INSERT INTO student (stuid, name, clsId) VALUES (3, 'Theo', 2);
INSERT INTO student (stuid, name, clsId) VALUES (4, 'Brittany', 2);
INSERT INTO student (stuid, name, clsId) VALUES (5, 'Jenette', 3);
INSERT INTO student (stuid, name, clsId) VALUES (6, 'Elenor', 3);
INSERT INTO student (stuid, name, clsId) VALUES (7, 'Stu', 4);
INSERT INTO student (stuid, name, clsId) VALUES (8, 'John', 4);
INSERT INTO student (stuid, name, clsId) VALUES (9, 'Robert', 5);
INSERT INTO student (stuid, name, clsId) VALUES (10, 'Robin', 5);