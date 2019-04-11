#finds SUM of salary for every department_id
SELECT `department_id`, SUM(`salary`)
FROM soft_uni.employees
GROUP BY `department_id`
ORDER BY `department_id`;

#finds the min salary for every department_id
SELECT `department_id`, MIN(`salary`)
FROM soft_uni.employees
GROUP BY `department_id`
ORDER BY MIN(`salary`);

SELECT `department_id`, MAX(`salary`)
FROM soft_uni.employees
GROUP BY `department_id`
ORDER BY MAX(`salary`);

#finds the count of salaries for every department_id
SELECT `department_id`, COUNT(`salary`)
FROM soft_uni.employees
GROUP BY `department_id`
ORDER BY COUNT(`salary`);

#COUNT IGNORES WHEN VALUE IS NULL, CARE
SELECT COUNT(`employee_id`), COUNT(`middle_name`)
FROM soft_uni.employees
GROUP BY `department_id`;

#GROUP BY MORE THAN 1 COLUMN
SELECT `department_id`,
		`job_title`,
		AVG(`salary`)
FROM `employees`
GROUP BY `job_title`, `department_id`
ORDER BY `department_id`, `job_title`;
#GROUP BY `job_title`, `department_id`; -> same job_title in different department_id

#HAVING -> filter data based on aggregate values
SELECT `department_id`, SUM(`salary`) AS `salaries_sum`
FROM `employees`
GROUP BY `department_id`
HAVING `salaries_sum` >= 150000;

#LAB TASKS

#TASK 1
SELECT `department_id`, COUNT(`employee_id`) AS `Number of Employees`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`, COUNT(`employee_id`);

#TASK 2
SELECT `department_id`, ROUND(AVG(`salary`),2) AS `Average Salary`
FROM `employees`
GROUP BY `department_id`;

#TASK 3
SELECT `department_id`, MIN(`salary`) `min_salary`
FROM `employees`
GROUP BY `department_id`
HAVING `min_salary` > 800;

#TASK 4
SELECT COUNT(*)
FROM `products`
WHERE `price` >= 8
GROUP BY `category_id`
HAVING `category_id` = 2;

#TASK 5
SELECT `category_id`,
		ROUND(AVG(`price`), 2) AS `average_price`,
        ROUND(MIN(`price`), 2) AS `lowest_price`,
        ROUND(MAX(`price`), 2) AS `highest_price`
FROM `products`
GROUP BY `category_id`;