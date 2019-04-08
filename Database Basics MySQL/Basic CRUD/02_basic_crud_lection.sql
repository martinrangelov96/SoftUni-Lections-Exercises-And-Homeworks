SELECT id,
	concat_ws(' ', `first_name`, `last_name`) AS 'full name', 
	job_title,
    salary
FROM employees
WHERE salary > 1000
ORDER BY id;

SELECT DISTINCT first_name
FROM employees;

SELECT last_name, department_id
FROM employees
WHERE department_id = 1;

SELECT *
 FROM (
		SELECT *
		FROM employees
		WHERE department_id = 4
		AND salary >= 1600
		ORDER BY id
	) AS e
    WHERE e.job_title = 'Epidemiologist';
    
CREATE VIEW `v_hr_resukt_set` AS 
	SELECT id,
    concat(`first_name`, ' ', `last_name`) AS 'full_name',
    salary
FROM employees;

SELECT * 
FROM v_hr_resukt_set
WHERE salary > 1000;

DROP VIEW v_hr_resukt_set;

CREATE VIEW v_top_paid_employee AS 
	SELECT * 
    FROM employees
    ORDER BY salary DESC
    LIMIT 1;
    
SELECT *
FROM v_top_paid_employee;

ALTER VIEW v_top_paid_employee AS 
	SELECT * 
    FROM employees
    ORDER BY salary DESC
    LIMIT 3;
    
SELECT
	e.first_name, 
    e.last_name, 
    e.salary, 
    d.name
    FROM employees AS e
    JOIN departments AS d
    ON d.id = e.department_id
    ORDER BY salary DESC
    LIMIT 1;
    
INSERT INTO employees(first_name, last_name, job_title, department_id, salary)
VALUES
('Pesho', 'Peshov', 'Director', 3, 4000),
('Gosho', 'Peshov', 'Director', 3, 4000);

SELECT *
FROM v_hr_result_set;

DELETE FROM employees
WHERE department_id IN (1,2);

SELECT * 
FROM employees;

UPDATE employees
	SET salary = salary * 1.10,
		job_title = CONCAT('SENIOR ', job_title)
	WHERE department_id = 3;
    
SELECT * FROM employees;

UPDATE employees
	SET salary = salary * 1.10
    WHERE job_title = 'Therapist';
    
SELECT salary
FROM employees
ORDER BY salary;