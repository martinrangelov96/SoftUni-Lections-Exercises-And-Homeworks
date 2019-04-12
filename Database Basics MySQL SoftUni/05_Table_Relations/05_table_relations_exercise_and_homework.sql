#TASK 1. One-To-One Relationship
CREATE TABLE `persons`(
	`person_id` INT(11),
    `first_name` VARCHAR(50),
    `salary` DECIMAL(10,2),
    `passport_id` INT(11)
);

CREATE TABLE `passports`(
	`passport_id` INT(11),
	`passport_number` VARCHAR(50)
);

INSERT INTO `persons`(`person_id`, `first_name`, `salary`, `passport_id`)
VALUES
(1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103),
(3, 'Yana', 60200.00, 101);

INSERT INTO `passports`(`passport_id`, `passport_number`)
VALUES
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

ALTER TABLE `persons`
	ADD CONSTRAINT `pk_persons_id`
    PRIMARY KEY (`person_id`);

ALTER TABLE `passports`
	ADD CONSTRAINT `pk_passports_id`
    PRIMARY KEY (`passport_id`);
    
ALTER TABLE `persons`
	ADD CONSTRAINT `fk_persons_passports`
    FOREIGN KEY (`passport_id`)
    REFERENCES `passports`(`passport_id`);
    
ALTER TABLE `persons`
	ADD UNIQUE (`passport_id`);

#--END OF TASK 1

#TASK 2. One-To-Many Relationship

CREATE TABLE IF NOT EXISTS `manufacturers` (
	`manufacturer_id` INT UNIQUE,
    `name` VARCHAR(50),
    `established_on` DATE
);

CREATE TABLE IF NOT EXISTS `models` (
	`model_id` INT,
    `name` VARCHAR(50),
    `manufacturer_id` INT
);

INSERT INTO `manufacturers` (`manufacturer_id`, `name`, `established_on`)
VALUES
(1, 'BMW', STR_TO_DATE('01/03/1916', '%d/%m/%Y')),
(2, 'Tesla', STR_TO_DATE('01/01/2003', '%d/%m/%Y')),
(3, 'Lada', STR_TO_DATE('01/05/1966', '%d/%m/%Y'));

INSERT INTO `models` (`model_id`, `name`, `manufacturer_id`)
VALUES
(101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

ALTER TABLE `manufacturers`
	ADD CONSTRAINT `pk_manufacturers_id`
    PRIMARY KEY (`manufacturer_id`);
    
ALTER TABLE `models`
	ADD CONSTRAINT `pk_model_id`
		PRIMARY KEY (`model_id`),
    ADD CONSTRAINT `pk_models_manufacturers`
		FOREIGN KEY (`manufacturer_id`)
			REFERENCES `manufacturers`(`manufacturer_id`);
            
#--END OF TASK 2

#TASK 3. Many-To-Many Relationship

CREATE TABLE IF NOT EXISTS `students` (
	`student_id` INT,
    `name` VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS `exams` (
	`exam_id` INT,
    `name` VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS `students_exams` (
	`student_id` INT,
    `exam_id` INT
);

INSERT INTO `students` (`student_id`, `name`)
VALUES
(1, 'Mila'),
(2, 'Toni'),
(3, 'Ron');

INSERT INTO `exams` (`exam_id`, `name`)
VALUES
(101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

INSERT INTO `students_exams` (`student_id`, `exam_id`)
VALUES
(1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);

ALTER TABLE `students`
	ADD CONSTRAINT `pk_student_id`
		PRIMARY KEY (`student_id`);
    
ALTER TABLE `exams`
	ADD CONSTRAINT `pk_exam_id`
		PRIMARY KEY (`exam_id`);
    
ALTER TABLE `students_exams`
	ADD CONSTRAINT `pk_students_exams`
		PRIMARY KEY (`student_id`, `exam_id`),
	ADD CONSTRAINT `fk_students_exams_students`
		FOREIGN KEY (`student_id`)
			REFERENCES `students`(`student_id`),
	ADD CONSTRAINT `fk_exams_students_students`
		FOREIGN KEY (`exam_id`)
			REFERENCES `exams`(`exam_id`);
            
#--END OF TASK 3

#TASK 4. Self-Referencing

CREATE TABLE IF NOT EXISTS `teachers` (
	`teacher_id` INT UNIQUE,
    `name` VARCHAR(50),
    `manager_id` INT
);

INSERT INTO `teachers` (`teacher_id`, `name`, `manager_id`)
VALUES
(101, 'John', NULL),
(102, 'Maya', 106),
(103, 'Silvia', 106),
(104, 'Ted', 105),
(105, 'Mark', 101),
(106, 'Greta', 101);

ALTER TABLE `teachers` 
	ADD CONSTRAINT `pk_teachers_id`
		PRIMARY KEY (`teacher_id`),
	ADD CONSTRAINT `fk_teachers_managers_id_manager_id`
		FOREIGN KEY (`manager_id`)
			REFERENCES `teachers`(`teacher_id`);
            
#--END OF TASK 4

#TASK 5. Online Store Database

CREATE DATABASE `online_store_db`;
USE `online_store_db`;

CREATE TABLE `cities` (
	`city_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `customers` (
	`customer_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `birthday` DATE,
    `city_id` INT(11),
    CONSTRAINT `fk_customers_cities`
		FOREIGN KEY (`city_id`)
			REFERENCES `cities`(`city_id`)
);

CREATE TABLE `orders` (
	`order_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `customer_id` INT(11),
    CONSTRAINT `fk_orders_customers`
		FOREIGN KEY (`customer_id`)
			REFERENCES `customers`(`customer_id`)
);

CREATE TABLE `item_types` (
	`item_type_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `items` (
	`item_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `item_type_id` INT(11),
    CONSTRAINT `fk_items_item_types`
		FOREIGN KEY (`item_type_id`)
			REFERENCES `item_types`(`item_type_id`)
);

CREATE TABLE `order_items` (
	`order_id` INT(11),
	`item_id` INT(11),
    CONSTRAINT `pk_orders_items`
		PRIMARY KEY (`order_id`, `item_id`),
	CONSTRAINT `fk_orders_items_orders`
		FOREIGN KEY (`order_id`)
			REFERENCES `orders`(`order_id`),
	CONSTRAINT `fk_orders_items_items`
		FOREIGN KEY (`item_id`)
			REFERENCES `items`(`item_id`)
);

#--END OF TASK 5

#TASK 6. University Database

CREATE DATABASE `university_database`;
USE `university_database`;

CREATE TABLE `majors` (
	`major_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `students` (
	`student_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `student_number` VARCHAR(12),
    `student_name` VARCHAR(50),
    `major_id` INT(11),
    CONSTRAINT `fk_students_majors`
		FOREIGN KEY (`major_id`)
			REFERENCES `majors`(`major_id`)
);

CREATE TABLE `payments` (
	`payment_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `payment_date` DATE,
    `payment_amount` DECIMAL(8,2),
    `student_id` INT(11),
    CONSTRAINT `fk_payments_students`
		FOREIGN KEY (`student_id`)
			REFERENCES `students`(`student_id`)
);

CREATE TABLE `subjects` (
	`subject_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
	`subject_name` VARCHAR(50)
);

CREATE TABLE `agenda` (
	`student_id` INT(11),
    `subject_id` INT(11),
    CONSTRAINT `pk_student_subject`
		PRIMARY KEY(`student_id`, `subject_id`),
	CONSTRAINT `fk_student_subject_student`
		FOREIGN KEY (`student_id`)
			REFERENCES `students`(`student_id`),
	CONSTRAINT `fk_student_subject_subject`
		FOREIGN KEY(`subject_id`)
			REFERENCES `subjects`(`subject_id`)
);


#TASK 9 Peaks in Rila

SELECT m.`mountain_range`, p.`peak_name`, p.`elevation` AS `peak_elevation`
	FROM
		`mountains` AS m
	JOIN `peaks` AS p
		ON m.`id` = p.`mountain_id`
	WHERE m.`mountain_range` = 'Rila'
	ORDER BY `peak_elevation` DESC;
    
#--END OF TASK 9