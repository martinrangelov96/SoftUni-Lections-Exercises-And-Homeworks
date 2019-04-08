#EXERCISE START

CREATE DATABASE minions;
USE minions;

CREATE TABLE minions(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    age INT(11)
);

CREATE TABLE towns(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20)
);

ALTER TABLE minions
ADD COLUMN town_id INT(11);

#creates a foreign key in minions that is connected with town's id
ALTER TABLE minions
ADD CONSTRAINT fk_minions_towns FOREIGN KEY(town_id) REFERENCES towns(id);

#insert values into the table
INSERT INTO towns(name) VALUES('Berlin');

#insert values into the table (connects the 2 tables)
INSERT INTO minions(name, age, town_id) VALUES('Stamat', 102, 3);

#query to show the whole minions table
SELECT * FROM minions;

TRUNCATE TABLE minions;

INSERT INTO towns(name) VALUES ('Sofia');
INSERT INTO towns(name) VALUES ('Plovdiv');
INSERT INTO towns(name) VALUES ('Varna');

INSERT INTO minions(name, age, town_id) VALUES ('Kevin', 22, 1);
INSERT INTO minions(name, age, town_id) VALUES ('Bob', 15, 3);
INSERT INTO minions(name, age, town_id) VALUES ('Stewerd', NULL, 2);

SELECT * FROM minions;

DROP TABLE minions;
DROP TABLE towns;

CREATE DATABASE pesho_db;
USE pesho_db;

CREATE TABLE people(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture TINYBLOB,
    height DOUBLE(3,2),
    weight DOUBLE(5,2),
    gender ENUM('m', 'f') NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people(id, name, picture, height, weight, gender, birthdate, biography)
VALUES
(1, 'pesho', NULL, 1.80, 45.0, 'm', '1889-01-28', 'az sum pesho'),
(2, 'gosho', NULL, 1.65, 65.0, 'm', '1889-02-18', 'az sum gosho'),
(3, 'gosho', NULL, 1.65, 65.0, 'm', '1889-02-18', 'az sum gosho'),
(4, 'gosho', NULL, 1.65, 65.0, 'm', '1889-02-18', 'az sum gosho'),
(5, 'gosho', NULL, 1.65, 65.0, 'm', '1889-02-18', 'az sum gosho');

SELECT * FROM PEOPLE;

CREATE TABLE users(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB(900),
    last_login_time DATETIME,
    is_deleted BIT
);

INSERT INTO users(id, username, password, profile_picture, last_login_time, is_deleted)
VALUES
(1, 'ivan', 'asd123', NULL, date(now()), 1),
(2, 'pesho', 'das215', NULL, date(now()), 0),
(3, 'dragan', '431asf', NULL, date(now()), 1),
(4, 'kaloqn', 's154sa', NULL, date(now()), 0),
(5, 'asen', 'yf545s', NULL, date(now()), 1);

SELECT * from users;

#EXERCISE ENDS

#HOMEWORK TASKS

#TASK 9. Change Primary Key
ALTER TABLE users
MODIFY id INT NOT NULL;

ALTER TABLE users
DROP PRIMARY KEY;

ALTER TABLE users
ADD PRIMARY KEY(id, username);

#---END TASK 9

#TASK 10. Set Default Value of a Field
ALTER TABLE users
MODIFY last_login_time DATETIME DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE users
MODIFY id INT NOT NULL;

ALTER TABLE users
DROP PRIMARY KEY;

ALTER TABLE users
ADD PRIMARY KEY(id);

#------- END OF TASK 10

#11. Set Unique Field
ALTER TABLE users
MODIFY username VARCHAR(26) NOT NULL UNIQUE;
#-------

#TASK 12. Movies Database
CREATE DATABASE movies;
USE movies;

CREATE TABLE directors(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO directors(director_name)
VALUES
('kubrick'),
('scorsese'),
('nolan'),
('refn'),
('spielberg');

CREATE TABLE genres(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO genres(genre_name)
VALUES
('horror'),
('comedy'),
('action'),
('sci-fi'),
('drama');

CREATE TABLE categories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO categories(category_name)
VALUES
('category1'),
('category2'),
('category3'),
('category4'),
('category5');

CREATE TABLE movies(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    director_id INT,
    copyright_year YEAR,
    length INT,
    genre_id INT,
    category_id INT,
    rating INT,
    notes TEXT
);

INSERT INTO movies(title)
VALUES
('Inception'),
('The Shining'),
('Drive'),
('2001'),
('Joker');

#-------END OF TASK 12

#TASK 13. Car Rental Database
CREATE DATABASE car_rental;
USE car_rental;

CREATE TABLE categories(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(50) NOT NULL,
    daily_rate DOUBLE,
    weekly_rate DOUBLE,
    monthly_rate DOUBLE,
    weekend_rate DOUBLE
);

INSERT INTO categories(category)
VALUES
('4x4'),
('sedan'),
('van');

CREATE TABLE cars(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(50),
    make VARCHAR(50),
    model VARCHAR(50),
    car_year INT(4),
    category_id INT,
    doors INT(1),
    picture BLOB,
    car_condition VARCHAR(50),
    available BIT
);

INSERT INTO cars(model)
VALUES
('Golf'),
('Mazda'),
('Porsche');

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    title VARCHAR(50),
    notes TEXT
);

INSERT INTO employees(first_name)
VALUES
('Ivan'),
('Pesho'),
('Stamat');

CREATE TABLE customers(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    driver_license_number VARCHAR(50),
    full_name VARCHAR(50) NOT NULL,
    address VARCHAR(50),
    city VARCHAR(50),
    zip_code INT(11),
    notes TEXT
);

INSERT INTO customers(full_name)
VALUES
('Ivan Ivanov'),
('Pesho Peshov'),
('Stamat Stamatov');

CREATE TABLE rental_orders(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    employee_id INT(11),
    customer_id INT(11),
    car_id INT(11),
    car_condition VARCHAR(50),
    tank_level INT(11),
    kilometrage_start INT(11),
    kilometrage_end INT(11),
    total_kilometrage INT(11),
    start_date DATE,
    end_date DATE,
    total_days INT(11),
    rate_applied DOUBLE,
    tax_rate DOUBLE,
    order_status VARCHAR(50),
    notes TEXT
);

INSERT INTO rental_orders(employee_id, customer_id, car_id)
VALUES
(1,1,1),
(2,2,2),
(3,3,3);

SELECT * FROM rental_orders;

#--------END OF TASK 13

#TASK 14. Hotel Database
CREATE DATABASE hotel;
USE hotel;

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    title VARCHAR(50),
    notes TEXT
);

INSERT INTO employees(first_name)
VALUES
('Petkan'),
('Dragan'),
('Sisan');

CREATE TABLE customers(
    account_number INT(11),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number INT(11),
    emergency_name VARCHAR(50),
    emergency_number INT(11),
    notes TEXT
);

INSERT INTO customers(account_number)
VALUES
(123),
(234),
(345);

CREATE TABLE room_status(
    room_status VARCHAR(50) PRIMARY KEY NOT NULL,
    notes TEXT
);

INSERT INTO room_status(room_status)
VALUES
('okay'),
('awesome'),
('bad');

CREATE TABLE room_types(
    room_type VARCHAR(50) PRIMARY KEY NOT NULL,
    notes TEXT
);

INSERT INTO room_types(room_type)
VALUES
('big'),
('small'),
('medium');


CREATE TABLE bed_types(
    bed_type VARCHAR(50) PRIMARY KEY NOT NULL,
    notes TEXT
);

INSERT INTO bed_types(bed_type)
VALUES
('okayish'),
('small'),
('comfy');

CREATE TABLE rooms(
    room_number INT(11) PRIMARY KEY NOT NULL,
    room_type VARCHAR(50) NOT NULL,
    bed_type VARCHAR(50) NOT NULL,
    rate INT(11),
    room_status VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO rooms(room_number, room_type, bed_type, room_status)
VALUES
(1, 'big', 'comfy', 'awesome'),
(2, 'small', 'uncomfy', 'awful'),
(3, 'okaish', 'comfyish', 'awesomeish');

CREATE TABLE payments(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    employee_id INT(11),
    payment_date DATE,
    account_number INT(11),
    first_date_occupied DATE,
    last_date_occupied DATE,
    total_days INT(11),
    amount_charged DECIMAL,
    tax_rate DECIMAL,
    tax_amount DECIMAL,
    payment_total DOUBLE NOT NULL,
    notes TEXT
);

INSERT INTO payments(payment_total)
VALUES
(123.50),
(150.80),
(105.54);

CREATE TABLE occupancies(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    employee_id INT(11) NOT NULL,
    date_occupied DATE,
    account_number INT(11),
    room_number INT(11) NOT NULL,
    rate_applied DOUBLE,
    phone_charge DOUBLE NOT NULL,
    notes TEXT
);

INSERT INTO occupancies(employee_id, room_number, phone_charge)
VALUES
(1, 2, 12.50),
(2, 3, 5.80),
(3, 1, 8.20);

#---------END OF TASK 14

#TASK 15. Create SoftUni Database
CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);


CREATE TABLE addresses(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    address_text TEXT,
    town_id INT(11)
);

ALTER TABLE addresses
ADD CONSTRAINT fk_towns_addresses FOREIGN KEY (town_id) REFERENCES towns(id);

CREATE TABLE departments(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE employees(
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    job_title VARCHAR(50),
    department_id INT(11),
    hire_date DATE,
    salary DOUBLE,
    address_id INT(11)
);

#add foreign key
ALTER TABLE employees
ADD CONSTRAINT fk_employees_departments FOREIGN KEY(department_id) REFERENCES departments(id),
ADD CONSTRAINT fk_employees_addresses FOREIGN KEY (address_id) REFERENCES addresses(id);

#-----------END OF TASK 15

#TASK 17. Basic Insert
INSERT INTO towns(name)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO departments(name)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees(first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, STR_TO_DATE('01/02/2013', '%d/%m/%Y'), 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, STR_TO_DATE('02/03/2004', '%d/%m/%Y'), 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, STR_TO_DATE('28/08/2016', '%d/%m/%Y'), 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, STR_TO_DATE('09/12/2007','%d/%m/%Y'), 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, STR_TO_DATE('28/08/2016', '%d/%m/%Y'), 599.88);

#--------END OF TASK 17

#TASK 18. Basic Select All Fields
SELECT * FROM towns;

SELECT * FROM departments;

SELECT * from employees;

#--------END OF TASK 18

#TASK 19. Basic Select All Fields and Order Them
SELECT * FROM towns
ORDER BY name;

SELECT * FROM departments
ORDER BY name;

SELECT * FROM employees
ORDER BY salary DESC;

#----------------END OF TASK 19

#TASK 20. Basic Select Some Fields
SELECT name FROM towns
ORDER by name;

SELECT name FROM departments
ORDER by name;

SELECT first_name, last_name, job_title, salary FROM employees
ORDER BY salary DESC;

#------------------END OF TASK 20

#TASK 21. Increase Employees Salary
UPDATE employees
SET salary = salary * 1.1;

SELECT salary FROM employees;

#------------END OF TASK 21

#TASK 22. Decrease Tax Rate
UPDATE payments
SET tax_rate = tax_rate * 0.97;

SELECT tax_rate FROM payments;

#--------------END OF TASK 22

#TASK 23. Delete All Records
TRUNCATE TABLE occupancies;

#-------END OF TASK 23