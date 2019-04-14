#TASK 1 Employee Address
SELECT
	e.`employee_id`,
	e.`job_title`,
    e.`address_id`,
    a.`address_text`
FROM
	`employees` e
INNER JOIN
	`addresses` a
	ON e.`address_id` = a.`address_id`
ORDER BY e.`address_id` ASC
LIMIT 5;

#--END OF TASK 1

#TASK 2. Addresses with Towns
SELECT 
	e.`first_name`,
    e.`last_name`,
    t.`name` AS `town`,
    a.`address_text`
FROM `employees` e
INNER JOIN `addresses` a
	ON e.`address_id` = a.`address_id`
INNER JOIN `towns` t
	ON a.`town_id` = t.`town_id`
ORDER BY 
	e.`first_name` ASC,
    e.`last_name`
LIMIT 5;

#--END OF TASK 2

#TASK 3. Sales Employee
SELECT 
	e.`employee_id`,
    e.`first_name`,
    e.`last_name`,
    d.`name` AS `department_name`
FROM `employees` e
	INNER JOIN `departments` d
		ON e.`department_id` = d.`department_id`
			WHERE d.`name` = 'Sales'
ORDER BY `employee_id` DESC;

#--END OF TASK 3

#TASK 04.Employee Departments

SELECT
	e.`employee_id`,
	e.`first_name`,
    e.`salary`,
    d.`name`
FROM `employees` e
	INNER JOIN `departments` d
		ON e.`department_id` = d.`department_id`
			WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;

#--END OF TASK 4

#TASK 5. Employees Without Project

SELECT
	e.`employee_id`,
    e.`first_name`
FROM `employees` e
	LEFT JOIN `employees_projects` ep
		ON e.`employee_id` = ep.`employee_id`
			WHERE ep.`employee_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

#--END OF TASK 5

#TASK 6. Employees Hired After
SELECT 
	e.`first_name`,
    e.`last_name`,
    e.`hire_date`,
    d.`name` AS `dept_name`
FROM `employees` e
	INNER JOIN `departments` d
		ON e.`department_id` = d.`department_id`
			WHERE DATE(e.`hire_date`) > '1999-01-01'
				AND d.`name` IN ('Sales', 'Finance')
ORDER BY e.`hire_date` ASC;

#--END OF TASK 6

#TASK 7. Employees with Project
SELECT 
	e.`employee_id`,
    e.`first_name`,
    p.`name` AS `project_name`
FROM `employees` e
	INNER JOIN `employees_projects` ep
		ON e.`employee_id` = ep.`employee_id`
	INNER JOIN `projects` p
		ON ep.`project_id` = p.`project_id`
			WHERE DATE(p.`start_date`) > '2002-08-13' AND p.`end_date` IS NULL
ORDER BY 
	e.`first_name` ASC,
    p.`name` ASC
LIMIT 5;

#--END OF TASK 7

#TASK 08.Employee 24
SELECT
	e.`employee_id`,
    e.`first_name`,
    (CASE 
		WHEN YEAR(p.`start_date`) >= 2005 THEN NULL
        ELSE p.`name`
    END)
    AS `project_name`
FROM `employees` e
	INNER JOIN `employees_projects` ep
		ON e.`employee_id` = ep.`employee_id`
	INNER JOIN `projects` p
		ON ep.`project_id` = p.`project_id`
			WHERE e.`employee_id` = 24
ORDER BY p.`name` ASC;

#--END OF TASK 8

#TASK 9. Employee Manager
SELECT
	e.`employee_id`,
    e.`first_name`,
    e.`manager_id`,
    m.`first_name` AS `manager_name`
FROM `employees` e
		INNER JOIN `employees` m
			ON e.`manager_id` = m.`employee_id`
				WHERE e.`manager_id` IN (3,7)
ORDER BY e.`first_name` ASC;

#--END OF TASK 9

#TASK 10. Employee Summary
SELECT
	e.`employee_id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS `employee_name`,
    CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager_name`,
    d.`name` AS `department_name`
FROM `employees` e
	INNER JOIN `employees` m
		ON e.`manager_id` = m.`employee_id`
	INNER JOIN `departments` d
		ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id` ASC
LIMIT 5;

#--END OF TASK 10

#TASK 11.Min Average Salary
SELECT
	AVG(e.`salary`) AS `min_average_salary`
FROM `employees` e
GROUP BY e.`department_id`
ORDER BY `min_average_salary` ASC
LIMIT 1;

#--END OF TASK 11

#TASK 12.Highest Peaks in Bulgaria
SELECT
	c.`country_code`,
    m.`mountain_range`,
    p.`peak_name`,
    p.`elevation`
FROM `countries` c
	INNER JOIN `mountains_countries` mc
		ON c.`country_code` = mc.`country_code`
	INNER JOIN `mountains` m
		ON mc.`mountain_id` = m.`id`
	INNER JOIN `peaks` p
		ON m.`id` = p.`mountain_id`
			WHERE c.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

#--END OF TASK 12

#TASK 13. Count Mountain Ranges
SELECT
	c.`country_code`,
    COUNT(m.`mountain_range`) AS `mountain_range`
FROM `countries` c
	INNER JOIN `mountains_countries` mc
		ON c.`country_code` = mc.`country_code`
	INNER JOIN `mountains` m
		ON m.`id` = mc.`mountain_id`
			WHERE c.`country_name` IN ('United States', 'Russia', 'Bulgaria')
	GROUP BY c.`country_name`
ORDER BY `mountain_range` DESC;

#--END OF TASK 13

#TASK 14.	Countries with Rivers 
SELECT
	c.`country_name`,
	r.`river_name`
FROM `countries` c
	LEFT JOIN `countries_rivers` cr
		ON cr.`country_code` = c.`country_code`
	LEFT JOIN `rivers` r
		ON r.`id` = cr.`river_id`
			WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name` ASC
LIMIT 5;

#--END OF TASK 14

#TASK 16. Countries without any Mountains
SELECT
	COUNT(c.`country_name`) AS 'country_count'
FROM `countries` c
	LEFT JOIN `mountains_countries` mc
		ON mc.`country_code` = c.`country_code`
			WHERE mc.`country_code` IS NULL;
        
#--END OF TASK 16

#TASK 17. Highest Peak and Longest River by Country
SELECT
	c.`country_name`,
    p.`elevation` AS `highest_peak_elevation`,
    r.`length` AS `longest_river_length`
FROM `countries` c
	INNER JOIN `mountains_countries` mc
		ON mc.`country_code` = c.`country_code`
	INNER JOIN `peaks` p
		ON p.`mountain_id` = mc.`mountain_id`
	INNER JOIN `countries_rivers` cr
		ON cr.`country_code` = c.`country_code`
	INNER JOIN `rivers` r
		ON r.`id` = cr.`river_id`
GROUP BY c.`country_name`
ORDER BY
	`highest_peak_elevation` DESC,
    `longest_river_length` DESC,
    `country_name` ASC
LIMIT 5;

#--END OF TASK 17