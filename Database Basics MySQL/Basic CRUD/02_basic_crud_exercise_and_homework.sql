#TASK 1. Find All Information About Departments
SELECT *
FROM `departments`
ORDER BY `department_id`;

#-- END OF TASK 1

#TASK 2. Find all Department Names

SELECT `name`
FROM `departments`
ORDER BY `department_id`;

#-- END OF TASK 2

#TASK 3. Find salary of Each Employee

SELECT `first_name`, `last_name`, `salary`
FROM `employees`
ORDER BY `employee_id`;

#--END OF TASK 3

#TASK 4. Find Full Name of Each Employee

SELECT `first_name`, `middle_name`, `last_name`
FROM `employees`
ORDER BY `employee_id`;

#--END OF TASK 4

#TASK 5. Find Email Address of Each Employee

SELECT concat(`first_name`, '.', `last_name`, '@softuni.bg')
AS `full_email_address`
FROM `employees`;

#--END OF TASK 5

#TASK 6. Find All Different Employee’s Salaries

SELECT DISTINCT `salary`
FROM `employees`
ORDER BY `employee_id`;

#--END OF TASK 6

#TASK 7. Find all Information About Employees

SELECT * 
FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

#--END OF TASK 7

#TASK 8. Find Names of All Employees by salary in Range

SELECT `first_name`, `last_name`, `job_title`
FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;

#--END OF TASK 8

#TASK 9. Find Names of All Employees

SELECT concat_ws(' ', `first_name`, `middle_name`, `last_name`)
AS 'Full Name'
FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);

#--END OF TASK 9

#TASK 10. Find All Employees Without Manager

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `manager_id` IS NULL;

#--END OF TASK 10

#TASK 11. Find All Employees with salary More Than 50000

SELECT `first_name`, `last_name`, `salary`
FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

#--END OF TASK 11

#TASK 12. Find 5 Best Paid Employees

SELECT `first_name`, `last_name`
FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

#--END OF TASK 12

#TASK 13. Find All Employees Except Marketing

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `department_id` != 4;

#--END OF TASK 13

#TASK 14. Sort Employees Table

SELECT *
FROM `employees`
ORDER BY 
`salary` DESC,
`first_name` ASC,
`last_name` DESC,
`middle_name` ASC,
`employee_id` ASC;

#--END OF TASK 14

#TASK 15. Create View Employees with Salaries

CREATE VIEW `v_employees_salaries` AS
SELECT `first_name`, `last_name`, `salary`
FROM `employees`;

SELECT * FROM `v_employees_salaries`;

#--END OF TASK 15

#TASK 16. Create View Employees with Job Titles

CREATE VIEW `v_employees_job_titles` AS 
SELECT concat_ws(' ', `first_name`, (CASE WHEN `middle_name` IS NULL THEN '' ELSE `middle_name` END), `last_name`) AS 'full_name', `job_title`
FROM `employees`;

SELECT *
FROM `v_employees_job_titles`;

#--END OF TASK 16

#TASK 17. Distinct Job Titles

SELECT 
DISTINCT `job_title`
FROM `employees`
ORDER BY `job_title` ASC;

#--END OF TASK 17

#TASK 18. Find First 10 Started Projects

SELECT * 
FROM `projects`
ORDER BY
`start_date` ASC,
`name` ASC,
`project_id` ASC
LIMIT 10;

#--END OF TASK 18

#TASK 19. Last 7 Hired Employees

SELECT `first_name`, `last_name`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

#--END OF TASK 19

#TASK 20. Increase Salaries

UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1,2,4,11);

SELECT `salary`
FROM `employees`;

#--END OF TASK 20

#TASK 21 All Mountain Peaks

SELECT `peak_name`
FROM `peaks`
ORDER BY `peak_name`;

#--END OF TASK 21

#TASK 22. Biggest Countries by Population

SELECT `country_name`, `population`
FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY
`population` DESC,
`country_name` ASC
LIMIT 30;

#--END OF TASK 22

#TASK 23. Countries and Currency (Euro / Not Euro)

SELECT `country_name`,
`country_code`,
(CASE 
	WHEN `currency_code` = 'EUR' THEN 'Euro'
	ELSE 'Not Euro' 
END) 
AS 'currency'
FROM `countries`
ORDER BY country_name ASC;

#--END OF TASK 23

#TASK 24. All Diablo Characters

SELECT `name`
FROM `characters`
ORDER BY `name` ASC;
