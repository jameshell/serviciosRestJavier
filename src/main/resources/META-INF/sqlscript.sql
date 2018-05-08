CREATE TABLE Student(
student_id SERIAL PRIMARY KEY NOT NULL,
student_name VARCHAR(50) NOT NULL,
student_lastname VARCHAR(50) NOT NULL,
student_age INT NOT NULL,
student_email VARCHAR(50) NOT NULL,
);

CREATE TABLE Test(
test_id INT PRIMARY KEY NOT NULL,
test_description VARCHAR(300)
);

CREATE TABLE Exam(
exam_id INT NOT NULL,
exam_grade DECIMAL NOT NULL,
student_id SERIAL NOT NULL REFERENCES Student(student_id),
test_id INT NOT NULL REFERENCES Test(test_id)
);

INSERT INTO Student (student_name, student_lastname, student_age, student_email) VALUES ('Jaime', 'Alonso', 24, 'jaime.alonso@ieee.org');
INSERT INTO Test(test_id, test_description) VALUES (4353, 'Este es el test numero 1');
INSERT INTO Exam(exam_id, exam_grade, student_id, test_id) VALUES ('111', 46.7, 1, 4353);