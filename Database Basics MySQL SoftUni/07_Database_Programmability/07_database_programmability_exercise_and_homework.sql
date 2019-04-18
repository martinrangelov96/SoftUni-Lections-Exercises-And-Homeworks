#TASK 1 Employees with Salary Above 35000
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above_35000`()
BEGIN
	SELECT
		e.`first_name`,
        e.`last_name`
	FROM `employees` e
		WHERE e.`salary` > 35000
	ORDER BY 
		e.`first_name` ASC,
        e.`last_name` ASC,
        e.`employee_id` ASC;
END $$

DELIMITER ;

CALL `usp_get_employees_salary_above_35000`;

#--END OF TASK 1

#TASK 2. Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above`(`salary_above` DOUBLE)
BEGIN
	SELECT
		e.`first_name`,
        e.`last_name`
	FROM `employees` e
		WHERE e.`salary` >= salary_above
	ORDER BY
		e.`first_name` ASC,
        e.`last_name` ASC,
        e.`employee_id` ASC;
END $$

DELIMITER ;

CALL `usp_get_employees_salary_above`(48100);

#--END OF TASK 2

#TASK 03. Town Names Starting With
DELIMITER $$
CREATE PROCEDURE `usp_get_towns_starting_with`(`letter` VARCHAR(50))
BEGIN
	SELECT
		t.`name` AS `town_name`
	FROM `towns` t
		WHERE t.`name` LIKE (CONCAT(`letter`, '%'))
	ORDER BY t.`name` ASC;
END $$

DELIMITER ;

CALL `usp_get_towns_starting_with`('b');

#--END OF TASK 3

#TASK 4. Employees from Town
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_from_town`(`town_name` VARCHAR(50))
BEGIN
	SELECT
		e.`first_name`,
        e.`last_name`
	FROM `employees` e
	INNER JOIN `addresses` a
		ON e.`address_id` = a.`address_id`
	INNER JOIN `towns` t
		ON a.`town_id` = t.`town_id`
			WHERE t.`name` = `town_name`
	ORDER BY
		e.`first_name` ASC,
        e.`last_name` ASC,
        e.`employee_id` ASC;
END $$

DELIMITER ;

CALL `usp_get_employees_from_town`('Sofia');

#--END OF TASK 4

#TASK 05. Salary Level Function
DELIMITER $$
CREATE FUNCTION `ufn_get_salary_level`(`employee_salary` DOUBLE)
RETURNS VARCHAR(10)
BEGIN
	DECLARE `salary_level` VARCHAR(10);
    IF `employee_salary` < 30000
		THEN SET `salary_level` := 'Low';
	ELSEIF `employee_salary` > 50000
		THEN SET `salary_level` := 'High';
	ELSE
		SET `salary_level` := "Average";
	END IF;
    RETURN `salary_level`;
END $$

DELIMITER ;

SELECT `ufn_get_salary_level`(30000);

#--END OF TASK 5

#TASK 06.	Employees by Salary Level
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`employee_salary` VARCHAR(10))
BEGIN
	DECLARE `salary_min` DECIMAL (13,4);
    DECLARE `salary_max` DECIMAL (13,4);
    IF `employee_salary` = 'Low' THEN
		SET `salary_min` = 0;
		SET `salary_max` = 30000;
    ELSEIF `employee_salary` = 'Average' THEN
		SET `salary_min` = 29999.9999;
        SET `salary_max` = 50000.0001;
	ELSEIF `employee_salary` = 'High' THEN
		SET `salary_min` = 50000;
        SET `salary_max` = 999999999;
	END IF;
    
    SELECT
		e.`first_name`,
        e.`last_name`
	FROM `employees` e
		WHERE e.`salary` > `salary_min` AND e.`salary` < `salary_max`
	ORDER BY 
		e.`first_name` DESC,
        e.`last_name` DESC;
END $$

DELIMITER ;

CALL `usp_get_employees_by_salary_level`('High');

#--END OF TASK 6

#TASK 7. Define Function
DELIMITER $$
CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS BIT
BEGIN
	DECLARE `result` BIT;
	DECLARE `word_length` INT(11);
    DECLARE `current_index` INT(11);
    
    SET `result` := 1;
    SET `word_length` := CHAR_LENGTH(`word`);
    SET `current_index` := 1;
    
    WHILE (`current_index` <= `word_length`) DO
		IF(`set_of_letters` NOT LIKE (CONCAT('%', SUBSTR(`word`, `current_index`, 1), '%'))) THEN
			SET `result` := 0;
		END IF;
        
        SET `current_index` := `current_index` + 1;
    END WHILE;
    
    RETURN `result`;
END $$

DELIMITER ;

SELECT `ufn_is_word_comprised`('oistmiahf', 'Sofia');

#--END OF TASK 7

#TASK 8 Find Full Name
DELIMITER $$
CREATE PROCEDURE `usp_get_holders_full_name`()
BEGIN
	SELECT 
		CONCAT(ah.`first_name`, ' ', ah.`last_name`) AS `full_name`
	FROM `account_holders` ah
    ORDER BY 
		`full_name` ASC,
		ah.`id` ASC;
END $$

DELIMITER ;

CALL `usp_get_holders_full_name`;

#--END OF TASK 8

#TASK 9 People with Balance Higher Than (order is different with judge result)
DELIMITER $$
CREATE PROCEDURE `usp_get_holders_with_balance_higher_than`(`balance_number` DOUBLE)
BEGIN
	SELECT
		ah.`first_name`,
        ah.`last_name`
	FROM `account_holders` ah
	INNER JOIN `accounts` a
		ON ah.`id` = a.`account_holder_id`
	GROUP BY ah.`id`
		HAVING SUM(a.`balance`) > `balance_number`
	ORDER BY
		a.`id`,
        ah.`first_name` DESC,
        ah.`last_name`;
END $$

DELIMITER ;

CALL `usp_get_holders_with_balance_higher_than`(7000);

#--END OF TASk 9

#TASK 10. Future Value Function
DELIMITER $$
CREATE FUNCTION `ufn_calculate_future_value`(`initial_sum` DECIMAL (13,4), `yearly_interest_rate` DECIMAL (13,4), `number_of_years` DECIMAL (13,4))
RETURNS DOUBLE
BEGIN
	DECLARE `future_value` DECIMAL (13,4);
    SET `future_value` := `initial_sum` * POW(1+`yearly_interest_rate`, `number_of_years`) *100/100;
    RETURN `future_value`;
END $$

DELIMITER ;

SELECT `ufn_calculate_future_value`(1000, 0.1, 5);

#--END OF TASK 10

#TASK 11. Calculating Interest
DROP FUNCTION IF EXISTS `ufn_calculate_future_value`;
DROP PROCEDURE IF EXISTS `usp_calculate_future_value_for_account`;

DELIMITER $$
CREATE FUNCTION `ufn_calculate_future_value`(`initial_sum` DECIMAL (13,4), `yearly_interest_rate` DECIMAL (13,4), `number_of_years` DECIMAL (13,4))
RETURNS DECIMAL (13,4)
BEGIN
	DECLARE `future_value` DECIMAL (13,4);
    SET `future_value` := `initial_sum` * POW(1+`yearly_interest_rate`, `number_of_years`) *100/100;
    RETURN `future_value`;
END $$

CREATE PROCEDURE `usp_calculate_future_value_for_account`(`account_id` INT, `yearly_interest_rate` DECIMAL (13,4))
BEGIN
	SELECT 
		a.`account_holder_id`,
		ah.`first_name`,
        ah.`last_name` AS `current_balance`,
        a.`balance`,
        `ufn_calculate_future_value`(a.`balance`, `yearly_interest_rate`, 5) AS `balance_in_5_years`
	FROM `accounts` a
	INNER JOIN `account_holders` ah
		ON a.`account_holder_id` = ah.`id`;
END $$

DELIMITER ;

CALL `usp_calculate_future_value_for_account`(1, 0.1);

#--END OF TASK 11

#TASK 12. Deposit Money
DELIMITER $$
CREATE PROCEDURE `usp_deposit_money`(`account_id` INT, `money_amount` DECIMAL (13,4))
BEGIN
	START TRANSACTION;
	IF (`money_amount` < 0) 
		THEN ROLLBACK; 
	ELSE
		UPDATE `accounts` a 
	SET a.`balance`  = a.`balance` + `money_amount`
    WHERE a.`id` = `account_id`;
END IF;
END $$

DELIMITER ;

CALL `usp_deposit_money`(1, 10);

#--END OF TASK 12

#TASK 13
DELIMITER $$
CREATE PROCEDURE `usp_withdraw_money`(`account_id` INT, `money_amount` DECIMAL(13,4))
BEGIN
	START TRANSACTION;
    IF ((SELECT `balance` 
			FROM `accounts`
				WHERE `id` = `account_id`) - `money_amount` < 0
					OR `money_amount` < 0)
		THEN ROLLBACK;
	ELSE UPDATE `accounts`
		SET `balance` = `balance` - `money_amount`
    WHERE `id` = `account_id`;
END IF;
END $$

DELIMITER ;

CALL `usp_withdraw_money`(1,10);

#--END OF TASK 13

#TASK 14. Money Transfer
DELIMITER $$
CREATE PROCEDURE `usp_transfer_money`(`from_account_id` INT, `to_account_id` INT, `amount` DECIMAL (13,4))
BEGIN
	START TRANSACTION;
    IF (`amount` < 0)
		OR `from_account_id` = `to_account_id`
        OR (SELECT `id` FROM `accounts` WHERE `id` = `from_account_id`) IS NULL
        OR (SELECT `id` FROM `accounts` WHERE `id` = `to_account_id`) IS NULL
        OR (SELECT `balance` FROM `accounts` WHERE `id` = `from_account_id`) < `amount`
			THEN ROLLBACK;
	ELSE 
    UPDATE `accounts`
		SET `balance` = `balance` - `amount`
			WHERE `id` = `from_account_id`;
	UPDATE `accounts` 
		SET `balance` = `balance` + `amount`
			WHERE `id` = `to_account_id`;
END IF;
END $$

DELIMITER ;

CALL `usp_transfer_money`(1,2,10);

#--END OF TASK 14

#TASK  15. Log Accounts Trigger
CREATE TABLE IF NOT EXISTS logs(
	`log_id` INT PRIMARY KEY AUTO_INCREMENT,
    `account_id` INT(11),
    `old_sum` DECIMAL (19,4),
    `new_sum` DECIMAL (19,4)
);

DELIMITER $$

CREATE TRIGGER `tr_update_balance`
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
	INSERT INTO `logs`
		(`account_id`, `old_sum`, `new_sum`)
	VALUES
		(OLD.`id`, OLD.`balance`, NEW.`balance`);
END $$

DELIMITER ;

UPDATE `accounts`
SET `balance` = `balance` + 10
WHERE `id` = 1;

#--END OF TASK 15

#TASK 16
CREATE TABLE IF NOT EXISTS `notification_emails` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `recipient` INT, 
    `subject` TEXT, 
    `body` TEXT
);

DELIMITER $$

CREATE TRIGGER `tr_create_new_email`
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO `notification_emails`
		(`recipient`, `subject`, `body`)
	VALUES
		(NEW.`account_id`, CONCAT_WS(' ', 'Balance change for account:', NEW.`account_id`),
        CONCAT_WS(' ', 'On', DATE_FORMAT(NOW(), '%b %d %Y at %r'), 'your balance was changed from',
        NEW.`old_sum`, 'to', NEW.`new_sum`,'.'));
END $$

DELIMITER ;

#--END OF TASK 16