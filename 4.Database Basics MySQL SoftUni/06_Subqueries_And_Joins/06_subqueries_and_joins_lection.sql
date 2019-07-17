#INNER JOIN -> doesn't show NULL foreign keys
SELECT 
	CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full name`,
	e.`job_title`,
    CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager name`,
	e.`job_title`, 
    d.`name`
FROM `employees` AS e
	INNER JOIN `departments` AS d
		ON e.`department_id` = d.`department_id`
	INNER JOIN `employees` m
		ON e.`manager_id` = m.`employee_id`;

#LEFT INNER JOIN -> Shows even NULL foreign keys
SELECT 
	CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full name`,
	e.`job_title`,
    CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager name`
FROM `employees` AS e
	LEFT JOIN `employees` m
		ON e.`manager_id` = m.`employee_id`;
        
#RIGHT INNER JOIN
SELECT 
	CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full name`,
	e.`job_title`,
    m.`employee_id`,
    CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager name`
FROM `employees` AS e
	RIGHT JOIN `employees` m
		ON e.`manager_id` = m.`employee_id`;
        
#OUTER (FULL JOIN) -> use UNION

SELECT 
	CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full name`,
	e.`job_title`,
    m.`employee_id`,
    CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager name`
FROM `employees` AS e
	LEFT JOIN `employees` m
		ON e.`manager_id` = m.`employee_id`
        
UNION

SELECT 
	CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full name`,
	e.`job_title`,
    m.`employee_id`,
    CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager name`
FROM `employees` AS e
	RIGHT JOIN `employees` m
		ON e.`manager_id` = m.`employee_id`;
        
#CROSS JOIN -> SLOW AF
SELECT e.`employee_id`, m.`employee_id`
FROM `employees` e
CROSS JOIN `employees` m
ORDER BY e.`employee_id`, m.`employee_id`;

#FASTER THAN CROSS JOIN
SELECT e.`employee_id`, m.`employee_id`
FROM `employees` e, `employees` m;

#TASK 1 Managers
SELECT 
	e.`employee_id`,
	CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full_name`,
	d.`department_id`,
    d.`name` AS `department_name`
FROM `employees` e
	JOIN `departments` d
		ON d.`manager_id` = e.`employee_id`
ORDER BY e.`employee_id`
LIMIT 5;

#TASK 4. Higher Salary (than average)
SELECT 
    COUNT(*)
FROM `employees`
WHERE 
	`salary` > (SELECT 
            AVG(`salary`)
        FROM
            `employees`);