#TASK 1. Find Names of All Employees by First Name

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `first_name` LIKE 'Sa%';

#--END OF TASK 1

#TASK 02. Find Names of All Employees by Last Name 

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `last_name` LIKE '%ei%';

#--END OF TASK 2

#TASK 3. Find First Names of All Employees

SELECT `first_name`
FROM `employees`
WHERE `department_id` IN (3, 10) AND YEAR(`hire_date`) BETWEEN 1995 AND 2005 
ORDER BY `employee_id` ASC;

#--END OF TASK 3

#TASK 04. Find All Employees Except Engineers 

SELECT `first_name`, `last_name`
FROM `employees`
WHERE !(`job_title` LIKE '%engineer%')
ORDER BY `employee_id`;

#--END OF TASK 4

#TASK 05. Find Towns with Name Length 

SELECT `name`
FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5,6)
ORDER BY `name`;

#--END OF TASK 5

#6. Find Towns Starting With

SELECT `town_id`, `name`
FROM `towns`
WHERE SUBSTRING(`name`, 1, 1) IN ('M', 'K', 'B', 'E')
ORDER BY `name` ASC;

#--END OF TASK 6

#TASK 7. Find Towns Not Starting With

SELECT `town_id`, `name`
FROM `towns`
WHERE LEFT(`name`,1) NOT IN ('R', 'B', 'D')
ORDER BY `name` ASC;

#--END OF TASK 7

#8. Create View Employees Hired After 2000 Year

CREATE VIEW `v_employees_hired_after_2000` AS
	SELECT `first_name`, `last_name`
	FROM `employees` WHERE YEAR(`hire_date`) > 2000;
    
#--END OF TASK 8

#TASK 09. Length of Last Name 

SELECT `first_name`, `last_name`
FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;

#--END OF TASK 9

#TASK 10. Countries Holding 'A' 

SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;

#--END OF TASK 10

#TASK 11. Mix of Peak and River Names

SELECT
	p.`peak_name`,
	r.`river_name`,
	LOWER(CONCAT(p.`peak_name`, SUBSTR(r.`river_name`,2))) AS `mix`
FROM `peaks` p, `rivers` r
WHERE RIGHT(p.`peak_name`, 1) = LEFT(r.`river_name`, 1)
ORDER BY `mix`;

#--NOT SOLVED

#12. Games from 2011 and 2012 year

SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS `start`
FROM `games`
WHERE YEAR(`start`) IN (2011,2012)
ORDER BY
`start` ASC,
`name` ASC
LIMIT 50;

#--END OF TASK 12

#TASK 13 User Email Providers

SELECT `user_name`, SUBSTRING(`email`, LOCATE('@', `email`) +1 ) AS `Email Provider`
FROM `users`
ORDER BY
`Email Provider` ASC,
`user_name` ASC;

#--END OF TASK 13

#14. Get Users with IP Address Like Pattern

SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name` ASC;

#--END OF TASK 14

#15. Show All Games with Duration and Part of the Day

SELECT `name` AS `game`,
(CASE 
	WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN "Morning"
    WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN "Afternoon"
    ELSE "Evening"
END)
AS `Part of the Day`,
(CASE 
	WHEN `duration` <= 3 THEN "Extra Short"
    WHEN `duration` > 3 AND `duration` <= 6 THEN "Short"
    WHEN `duration` > 6 AND `duration` <= 10 THEN "Long"
    ELSE "Extra Long"
END)
AS `Duration`
FROM `games`;

#--END OF TASK 15

#TASK 16. Orders Table

SELECT 
	o.`product_name`, 
	o.`order_date`, 
DATE_ADD(o.`order_date`, INTERVAL 3 DAY) AS `pay_due`,
DATE_ADD(o.`order_date`, INTERVAL 1 MONTH) AS `deliver_due`
FROM `orders` o;