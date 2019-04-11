#TASK 01. Records’ Count 

SELECT COUNT(`id`) AS `count`
FROM `wizzard_deposits`;

#--END OF TASK 1

#TASK 02. Longest Magic Wand 

SELECT MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits`;

#--END OF TASK 2

#TASK 3. Longest Magic Wand per Deposit Groups

SELECT `deposit_group`, MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY 
	MAX(`magic_wand_size`) ASC,
    `deposit_group` ASC;
    
#--END OF TASK 3

#TASK 04. Smallest Deposit Group per Magic Wand Size 

SELECT `deposit_group`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
HAVING (SELECT
	AVG(`magic_wand_size`) AS `smallest`
    FROM `wizzard_deposits`
    GROUP BY `deposit_group`
    ORDER BY `smallest`
    LIMIT 1) = AVG(`magic_wand_size`);

#--NOT SOLVED YET

#TASK 5. Deposits Sum

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`	
GROUP BY `deposit_group`
ORDER BY `total_sum` ASC;

#--END OF TASK 5

#TASK 06. Deposits Sum for Ollivander Family 

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;

#--END OF TASK 6

#TASK 7. Deposits Filter

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

#--END OF TASK 7

#TASK 8. Deposit charge

SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`) AS `mind_deposit_charge`
FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator`, `deposit_group` ASC;

#--END OF TASK 8

#TASK 9. Age Groups

SELECT
(CASE 
	WHEN wd.`age` BETWEEN 0 AND 10 THEN '[0-10]'
    WHEN wd.`age` BETWEEN 11 AND 20 THEN '[11-20]'
    WHEN wd.`age` BETWEEN 21 AND 30 THEN '[21-30]'
    WHEN wd.`age` BETWEEN 31 AND 40 THEN '[31-40]'
    WHEN wd.`age` BETWEEN 41 AND 50 THEN '[41-50]'
    WHEN wd.`age` BETWEEN 51 AND 60 THEN '[51-60]'
    WHEN wd.`age` >= 61 THEN '[61+]'
END)
AS `age_group`,
COUNT(`id`) AS `wizard_count`
FROM `wizzard_deposits` wd
GROUP BY `age_group`
ORDER BY `age_group` ASC;

#--END OF TASK 9

#TASK 10. First Letter 

SELECT DISTINCT LEFT(`first_name`, 1) AS `first_letter`
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
ORDER BY `first_name` ASC;

#--END OF TASK 10

#TASK 11. Average Interest

SELECT `deposit_group`, `is_deposit_expired`, AVG(`deposit_interest`) AS `average_interest`
	FROM `wizzard_deposits`
WHERE 
	`deposit_start_date` > '1985-01-01'
GROUP BY `deposit_group`, `is_deposit_expired`
ORDER BY 
`deposit_group` DESC,
`is_deposit_expired` ASC;

#--END OF TASK 11

#TASK 12. Rich Wizard, Poor Wizard*

SELECT SUM(`diff_between_current_next`) AS `sum_difference`
FROM
(
SELECT
	(wd1.`deposit_amount` - 
		(
			SELECT wd2.`deposit_amount`
			FROM `wizzard_deposits` wd2
			WHERE wd2.`id` = wd1.`id` + 1
		)
    ) AS `diff_between_current_next`
FROM `wizzard_deposits` wd1
) AS cq;

#--END OF TASK 12

#TASK 13. Employees Minimum Salaries

SELECT e.`department_id`, MIN(e.`salary`) AS `minimum_salary`
FROM `employees` e
WHERE e.`hire_date` > '2000-01-01'
GROUP BY e.`department_id`
HAVING e.`department_id` IN (2,5,7)
ORDER BY `department_id` ASC;

#--END OF TASK 13

#TASK 14. Employees Average Salaries

CREATE TABLE IF NOT EXISTS `new_table` AS ( SELECT *
	FROM `employees`
	WHERE `salary` > 30000
);

DELETE
FROM `new_table`
WHERE `manager_id` = 42;

UPDATE `new_table`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`, AVG(`salary`) as `avg_salary`
FROM `new_table`
GROUP BY `department_id`
ORDER BY `department_id` ASC;

#--END OF TASK 14


#TASK 15 Employees Maximum Salaries

SELECT e.`department_id`, MAX(e.`salary`) AS `max_salary`
	FROM `employees` e
GROUP BY e.`department_id`
	HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY `department_id`;

#--END OF TASK 15

#TASK 16. Employees Count Salaries

SELECT COUNT(e.`salary`) AS `count_of_salaries_without_manager`
FROM `employees` e
WHERE e.`manager_id` IS NULL;

#--END OF TASK 16

#TASK 17. 3rd Highest Salary*

SELECT e1.`department_id`,
(
	SELECT DISTINCT e2.`salary`
    FROM `employees` e2
    WHERE e2.`department_id` = e1.`department_id`
    ORDER BY e2.`salary` DESC
    LIMIT 2, 1
)
AS `third_highest_salary`
FROM `employees` e1
GROUP BY e1.`department_id`
HAVING `third_highest_salary` IS NOT NULL
ORDER BY e1.`department_id`;

#--END OF TASK 17

#TASK 18 Salary Challenge**

SELECT e1.`first_name`, e1.`last_name`, e1.`department_id`
FROM 
	`employees` AS e1
WHERE 
	e1.`salary` > (SELECT 
		AVG(e2.`salary`) 
    FROM 
		`employees` AS e2
	WHERE
		e2.`department_id` = e1.`department_id`)
GROUP BY e1.`department_id`, e1.`employee_id`
LIMIT 10;

#--END OF TASK 18

#TASK 19. Departments Total Salaries

SELECT e.`department_id`, SUM(e.`salary`) AS `total_salary`
FROM `employees` e
GROUP BY e.`department_id`
ORDER BY e.`department_id` ASC;

#--END OF TASK 19