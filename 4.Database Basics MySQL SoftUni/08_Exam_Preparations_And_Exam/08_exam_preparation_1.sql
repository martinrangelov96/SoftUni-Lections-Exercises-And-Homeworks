#TASK 01. Table Design 
CREATE TABLE `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL UNIQUE,
    `password` VARCHAR(30) NOT NULL,
    `email` VARCHAR(50) NOT NULL
);

CREATE TABLE `repositories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `repositories_contributors` (
	`repository_id` INT,
    `contributor_id` INT
);

CREATE TABLE `issues` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `issue_status` VARCHAR(6) NOT NULL,
    `repository_id` INT NOT NULL,
    `assignee_id` INT NOT NULL
);

CREATE TABLE `commits` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `message` VARCHAR(255) NOT NULL,
    `issue_id` INT,
    `repository_id` INT NOT NULL,
    `contributor_id` INT NOT NULL
);

CREATE TABLE `files` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `size` DECIMAL(10,2) NOT NULL,
    `parent_id` INT,
    `commit_id` INT NOT NULL
);

ALTER TABLE `repositories_contributors`
	ADD CONSTRAINT `fk_repositories_contributors_repositories`
		FOREIGN KEY `repositories_contributors`(`repository_id`)
			REFERENCES `repositories`(`id`);
        
ALTER TABLE `repositories_contributors`
	ADD CONSTRAINT `fk_repositories_contributors_contributors`
		FOREIGN KEY `repositories_contributors`(`contributor_id`)
			REFERENCES `users`(`id`);
        
ALTER TABLE `issues`
	ADD CONSTRAINT `fk_issues_repositories`
		FOREIGN KEY `issues`(`repository_id`)
			REFERENCES `repositories`(`id`);
        
ALTER TABLE `issues`
	ADD CONSTRAINT `fk_issues_users`
		FOREIGN KEY `issues`(`assignee_id`)
			REFERENCES `users`(`id`);

ALTER TABLE `commits`
	ADD CONSTRAINT `fk_commits_issues`
		FOREIGN KEY `commits`(`issue_id`)
			REFERENCES `issues`(`id`);
            
ALTER TABLE `commits`
	ADD CONSTRAINT `fk_commits_repositories`
		FOREIGN KEY `commits`(`repository_id`)
			REFERENCES `repositories`(`id`);
            
ALTER TABLE `commits`
	ADD CONSTRAINT `fk_commits_contributors`
		FOREIGN KEY `commits`(`contributor_id`)
			REFERENCES `users`(`id`);
            
ALTER TABLE `files` 
	ADD CONSTRAINT `fk_files_files`
		FOREIGN KEY `files`(`parent_id`)
			REFERENCES `files`(`id`);
            
ALTER TABLE `files`
	ADD CONSTRAINT `fk_files_commits`
		FOREIGN KEY `files`(`commit_id`)
			REFERENCES `commits`(`id`);
            
#--END OF TASK 1

#TASK 02. Insert

INSERT INTO `issues`(`title`, `issue_status`, `repository_id`, `assignee_id`)
SELECT
	CONCAT('Critical Problem With ', f.`name`, '!'),
    'open',
    CEILING((f.`id` * 2) / 3),
    c.`contributor_id`
FROM `files` f

INNER JOIN `commits` c
	ON f.`commit_id` = c.`id`
		WHERE f.`id` BETWEEN 46 AND 50;

#--END OF TASK 2

#TASK 03. Data Update
INSERT INTO `repositories_contributors`(`contributor_id`, `repository_id`)
SELECT *
FROM 
	(
	SELECT `contributor_id`
	FROM `repositories_contributors`
		WHERE `repository_id` = `contributor_id`
) AS `t1`
CROSS JOIN (
	SELECT MIN(r.`id`) AS `repository_id`
	FROM `repositories` r
		LEFT JOIN `repositories_contributors` rc
			ON r.`id` = rc.`repository_id`
				WHERE rc.`repository_id` IS NULL
) AS `t2`
WHERE t2.`repository_id` IS NOT NULL;

#--END OF TASK 3

#TASK 04.Data Deletion
DELETE FROM `repositories`
	WHERE `id` NOT IN (
		SELECT `repository_id`
        FROM `issues`
);

#--END OF TASK 4

#TASK 05.Users
	
SELECT
	u.`id`,
    u.`username`
FROM `users` u
ORDER BY u.`id` ASC;

#--END OF TASK 5

#TASK 06.Lucky Numbers

SELECT
	rc.`repository_id`,
    rc.`contributor_id`
FROM `repositories_contributors` rc
	WHERE rc.`repository_id` = rc.`contributor_id`
ORDER BY rc.`repository_id` ASC;

#--END OF TASK 6

#TASK 07. Heavy HTML

SELECT
	f.`id`,
    f.`name`,
    f.`size`
FROM `files` f
	WHERE f.`size` > 1000 AND f.`name` LIKE '%html%'
ORDER BY f.`size` DESC;

#--END OF TASK 7

#TASK 08.Issues and Users

SELECT
	i.`id`,
    CONCAT(u.`username`, ' : ', i.`title`) AS `issue_assignee`
FROM `issues` i
INNER JOIN `users` u
	ON i.`assignee_id` = u.`id`
ORDER BY i.`id` DESC;

#--END OF TASK 8

#TASK 09.Non-Directory Files

SELECT
	d.`id`,
    d.`name`,
    CONCAT(d.`size`, 'KB') AS `size`
FROM `files` f
RIGHT JOIN `files` d
	ON f.`parent_id` = d.`id`
		WHERE f.`id` IS NULL
ORDER BY d.`id` ASC;

#--END OF TASK 9

#TASK 10.Active Repositories

SELECT
	r.`id`,
    r.`name`,
    COUNT(i.`id`) AS `issues_count`
FROM `repositories` r
INNER JOIN `issues` i
	ON r.`id` = i.`repository_id`
GROUP BY r.`id`
ORDER BY 
	`issues_count` DESC,
	r.`id` ASC
LIMIT 5;

#--END OF TASK 10

#TASK 11. Most Contributed Repository

SELECT
	r.`id`,
    r.`name`,
    (
		SELECT COUNT(*) 
		FROM `commits` c
		WHERE c.`repository_id` = r.`id`
    ) AS `commits_count`,
	COUNT(u.`id`) AS `contributors_count`
FROM `users` u
INNER JOIN `repositories_contributors` rc
	ON rc.`contributor_id` = u.`id`
INNER JOIN `repositories` r
	ON rc.`repository_id` = r.`id`
GROUP BY r.`id`
ORDER BY 
	`contributors_count` DESC, 
    r.`id` ASC
LIMIT 1;

#--END OF TASK 11

#TASK 12. FixingMyOwnProblems 

SELECT
	u.`id`,
    u.`username`,
    COUNT(c.`id`) AS `count_of_commits`
FROM `users` u
LEFT JOIN `issues` i
	ON u.`id` = i.`assignee_id`
LEFT JOIN `commits` c
	ON c.`issue_id` = i.`id` AND c.`contributor_id` = u.`id`
GROUP BY u.`id`
ORDER BY 
	`count_of_commits` DESC,
    u.`id` ASC;

#--END OF TASK 12

#TASK 13. RecursiveCommits

SELECT
	LEFT(f1.`name`, POSITION('.' IN f1.`name`) - 1) AS `file`,
    COUNT(c.`id`) AS `recursive_count`
FROM `files` f1
INNER JOIN `files` f2
	ON f1.`id` = f2.`parent_id` AND f1.`parent_id` = f2.`id` AND f1.`id` != f2.`id`
LEFT JOIN `commits` c
	ON c.`message` LIKE CONCAT('%', f1.`name`, '%')
GROUP BY f1.`id`;

#--END OF TASK 13

#TASK 14 RepositoriesAndCommits 

SELECT
	r.`id`,
    r.`name`,
    COUNT(DISTINCT c.`contributor_id`) AS `count_of_contributors`
FROM `repositories` r
LEFT JOIN `commits` c
	ON c.`repository_id` = r.`id`
GROUP BY r.`id`
ORDER BY 
	`count_of_contributors` DESC,
    r.`id` ASC;

#--END OF TASK 14

#TASK 15.Commit
DROP PROCEDURE `udp_commit`;
DELIMITER $$
CREATE PROCEDURE `udp_commit` (
	`username` VARCHAR(30), 
    `password` VARCHAR(30), 
    `message` VARCHAR(255), 
    `issue_id` INT
)
BEGIN

	DECLARE `user_id` INT;
    DECLARE `repository_id` INT;
	
	IF 1 <> (SELECT COUNT(*) FROM `users` WHERE users.`username` = `username`)
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No such user!';
    END IF;
    
    IF 1 <> (SELECT COUNT(*) FROM `users` WHERE users.`username` = `username` AND  users.`password` = `password`)
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = '‘Password is incorrect!';
    END IF;
    
    IF 1 <> (SELECT COUNT(*) FROM `issues` WHERE issues.`id` = `issue_id`)
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = '‘The issue does not exist!';
    END IF;

    
    SET `user_id` := (
		SELECT u.`id`
        FROM `users` u
        WHERE u.`username` = username
    );
    
    SET `repository_id` := (
		SELECT i.`repository_id`
        FROM `issues` i
        WHERE i.`id` = `issue_id`
    );
    
    INSERT INTO `commits` (`repository_id`, `contributor_id`, `issue_id`, `message`)
    VALUES (`repository_id`, `user_id`, `issue_id`, `message`);
    
    #update issues status to closed
    UPDATE `issues` i
		SET i.`issue_status` = 'closed'
	WHERE i.`id` = `issue_id`;
    
    #SELECT `user_id`;
    #SELECT `repository_id`;
END $$

DELIMITER ;

CALL `udp_commit`('WhoDenoteBel', 'ajmISQi*', 'Message 2', 2);

#Incorrrect data
CALL `udp_commit`('incorrectUsername123', 'ajmISQi*', 'Message 2', 2);

#--END OF TASK 15

#TASK 16 Filter Extensions
DROP PROCEDURE `udp_findbyextension`;
DELIMITER $$
CREATE PROCEDURE `udp_findbyextension`(`extension` VARCHAR(100))
BEGIN
	SELECT
		f.`id`,
        f.`name`,
        CONCAT(f.`size`,'KB')
	FROM `files` f
		WHERE f.`name` LIKE CONCAT('%.',`extension`)
	ORDER BY f.`id` ASC;
END$$

CALL `udp_findbyextension`('html');

#--END OF TASK 16