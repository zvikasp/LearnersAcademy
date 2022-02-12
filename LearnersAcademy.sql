create database learnersacademy;
use learnersacademy;

insert into user(username, password)
values('admin','admin');
insert into user(username, password)
values('vikas','welcome1');

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

-- class 1
insert into subject(name, classId)
values('Core Java', 1);
insert into subject(name, classId)
values('J2EE', 1);
insert into subject(name, classId)
values('Hibernate', 1);
insert into subject(name, classId)
values('Spring', 1);
insert into subject(name, classId)
values('Spring MVC', 1);

-- class 2
insert into subject(name, classId)
values('Windows 8', 2);
insert into subject(name, classId)
values('Windows 10', 2);
insert into subject(name, classId)
values('Linux', 2);
insert into subject(name, classId)
values('Unix', 2);
insert into subject(name, classId)
values('Android', 2);

-- class 3
insert into subject(name, classId)
values('Artificial Intelligence', 3);
insert into subject(name, classId)
values('Data Science', 3);
insert into subject(name, classId)
values('Computer Science', 3);
insert into subject(name, classId)
values('Statistics', 3);
insert into subject(name, classId)
values('Mathematics', 3);

-- class 4
insert into subject(name, classId)
values('Problem Solving', 4);
insert into subject(name, classId)
values('Reasoning', 4);
insert into subject(name, classId)
values('Planning', 4);
insert into subject(name, classId)
values('Computer Vision', 4);
insert into subject(name, classId)
values('Mathematics', 4);

-- class 5
insert into subject(name, classId)
values('Continuous development', 5);
insert into subject(name, classId)
values('Continuous delivery', 5);
insert into subject(name, classId)
values('Continuous integration', 5);
insert into subject(name, classId)
values('Continuous deployment', 5);
insert into subject(name, classId)
values('Continuous monitoring', 5);

-- Teachers
INSERT INTO teacher (id, name, classId) VALUES (1, 'Washington', 1);
INSERT INTO teacher (id, name, classId) VALUES (2, 'Adams', 1);
INSERT INTO teacher (id, name, classId) VALUES (3, 'Jefferson', 2);
INSERT INTO teacher (id, name, classId) VALUES (4, 'Lincoln', 2);
INSERT INTO teacher (id, name, classId) VALUES (5, 'Albert', 3);
INSERT INTO teacher (id, name, classId) VALUES (6, 'Jack', 4);
INSERT INTO teacher (id, name, classId) VALUES (7, 'Mohan', 5);

-- Students
INSERT INTO student (id, name, classId) VALUES (1, 'Simon', 1);
INSERT INTO student (id, name, classId) VALUES (2, 'Alvin', 1);
INSERT INTO student (id, name, classId) VALUES (3, 'Theo', 2);
INSERT INTO student (id, name, classId) VALUES (4, 'Brittany', 2);
INSERT INTO student (id, name, classId) VALUES (5, 'Jenette', 3);
INSERT INTO student (id, name, classId) VALUES (6, 'Elenor', 3);
INSERT INTO student (id, name, classId) VALUES (7, 'Stu', 4);
INSERT INTO student (id, name, classId) VALUES (8, 'John', 4);
INSERT INTO student (id, name, classId) VALUES (9, 'Robert', 5);
INSERT INTO student (id, name, classId) VALUES (10, 'Robin', 5);