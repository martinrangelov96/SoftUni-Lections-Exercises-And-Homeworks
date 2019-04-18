#Make a Function
DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town_name(town_name VARCHAR(20))
RETURNS INT
BEGIN
	DECLARE employees_count INT;
	SET employees_count := 
		(
			SELECT COUNT(e.`employee_id`)
			FROM `employees` e
				JOIN `addresses` a
					ON e.`address_id` = a.`address_id`
				JOIN `towns` t
					ON t.`town_id` = a.`town_id`
						WHERE t.`name` = town_name
		);
	RETURN employees_count;
END
$$
DELIMITER ;

#Using the Function
SELECT ufn_count_employees_by_town_name('Sofia')

#Create a Procedure
DELIMITER $$
CREATE PROCEDURE usp_employees_by_town_name ()
BEGIN
		SELECT e.`first_name`, t.`name`
			FROM `employees` e
				JOIN `addresses` a
					ON e.`address_id` = a.`address_id`
				JOIN `towns` t
					ON t.`town_id` = a.`town_id`
						WHERE t.`name` = 'Seattle';
END
$$
DELIMITER ;

#Using the Procedure
CALL usp_employees_by_town_name

#Create a Procedure with parameter
DELIMITER $$
CREATE PROCEDURE usp_employees_by_town_name2 ( town_name VARCHAR(20))
BEGIN
		SELECT e.`first_name`, t.`name`
			FROM `employees` e
				JOIN `addresses` a
					ON e.`address_id` = a.`address_id`
				JOIN `towns` t
					ON t.`town_id` = a.`town_id`
						WHERE t.`name` = town_name;
END
$$
DELIMITER ;

#Using the Procedure with Parameter
CALL usp_employees_by_town_name2 ('Sofia');


DELIMITER //
CREATE PROCEDURE usp_raise_salary_by_department_name 
	(department_name VARCHAR(100))
BEGIN
	UPDATE `employees` e
			JOIN `departments` d
				ON e.`department_id` = d.`department_id`
					SET `salary` = `salary` * 1.05
						WHERE d.`name` = department_name;
END
//
DELIMITER ;

CALL usp_raise_salary_by_department_name('Engineering');

#Transactions

#Triggers