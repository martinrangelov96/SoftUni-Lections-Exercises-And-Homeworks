#TASK 01. Table Design 
CREATE TABLE `pictures` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `path` VARCHAR(255) NOT NULL,
    `size` DECIMAL (10,2) NOT NULL
);

CREATE TABLE `users` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL UNIQUE,
    `password` VARCHAR(30) NOT NULL,
    `profile_picture_id` INT(11),
		FOREIGN KEY (`profile_picture_id`)
			REFERENCES `pictures`(`id`)
);

CREATE TABLE `posts` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `caption` VARCHAR(255) NOT NULL,
    `user_id` INT(11) NOT NULL,
		FOREIGN KEY (`user_id`)
			REFERENCES `users`(`id`),
	`picture_id` INT(11) NOT NULL,
		FOREIGN KEY (`picture_id`)
			REFERENCES `pictures`(`id`)
);

CREATE TABLE `comments` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `content` VARCHAR(255) NOT NULL,
    `user_id` INT(11) NOT NULL,
		FOREIGN KEY (`user_id`)
			REFERENCES `users`(`id`),
	`post_id` INT(11) NOT NULL,
		FOREIGN KEY (`post_id`)
			REFERENCES `posts`(`id`)
);

CREATE TABLE `users_followers` (
	`user_id` INT(11),
		FOREIGN KEY (`user_id`)
			REFERENCES `users`(`id`),
	`follower_id` INT(11),
		FOREIGN KEY (`follower_id`)
			REFERENCES `users`(`id`)
);

#--END OF TASK 1

#TASk 2 Insert

INSERT INTO `comments` (`content`,`user_id`, `post_id`)
SELECT 
		CONCAT('Omg!',u.`username`,'!This is so cool!') `content`,
		CEILING((p.`id` * 3) / 2) `user_id`,
		p.`id` `post_id`
FROM `users` u
INNER JOIN `posts` p
	ON p.`user_id` = u.`id`
		WHERE p.`id` BETWEEN 1 AND 10;
        
#TASK 03. Update

#TASK 04.Data Deletion

DELETE `users`
FROM `users`
	INNER JOIN `users_followers`
		ON `id` = `user_id`
			WHERE `id` NOT IN (SELECT `user_id` FROM `users_followers`) AND `id` NOT IN (SELECT `follower_id` FROM `users_followers`);
            

DELETE FROM `users`
	WHERE `id` NOT IN (SELECT `user_id` FROM `users_followers`) AND 
			`id` NOT IN (SELECT `follower_id` FROM `users_followers`);
		
#--END OF TASK 4

#TASK 05.Users

SELECT
	u.`id`,
    u.`username`
FROM `users` u
ORDER BY u.`id` ASC;

#--END OF TASK 5

#TASK 06.Cheaters

SELECT
	u.`id`,
    u.`username`
FROM `users` u 
INNER JOIN `users_followers` uf
	ON u.`id` = uf.`user_id`
		WHERE u.`id` = uf.`follower_id`
ORDER BY u.`id` ASC;

#--END OF TASK 6

#TASK 07.High Quality Pictures

SELECT
	p.`id`,
    p.`path`,
    p.`size`
FROM `pictures` p
	WHERE p.`size` > 50000 AND (p.`path` LIKE '%jpeg%' OR p.`path` LIKE '%png%')
ORDER BY p.`size` DESC;

#--END OF TASK 7

#TASK 08.	Comments and Users

SELECT
	c.`id`,
    CONCAT(u.`username`, ' : ', c.`content`) AS `full_comment`
FROM `comments` c
INNER JOIN `users` u
	ON u.`id` = c.`user_id`
ORDER BY c.`id` DESC;

#--END OF TASK 8

#TASK 09.	Profile Pictures

SELECT
	DISTINCT u.`id`,
    u.`username`,
    CONCAT(p.`size`, 'KB') AS `size`
FROM `users` u
INNER JOIN `pictures` p
	ON u.`profile_picture_id` = p.`id`
INNER JOIN `users` u2
	ON u.`profile_picture_id` = u2.`profile_picture_id`  AND u.`id` != u2.`id`
ORDER BY u.`id` ASC;

#--END OF TASK 9

#TASK 10.	Spam Posts

SELECT
	p.`id`,
    p.`caption`,
    COUNT(c.`id`) AS `count_of_comments`
FROM `posts` p
INNER JOIN `comments` c
	ON p.`id` = c.`post_id`
GROUP BY p.`id`
ORDER BY 
	`count_of_comments` DESC,
    p.`id` ASC
LIMIT 5;

#--END OF TASK 10

#TASK 11.Most Popular User

SELECT
	u.`id`,
    u.`username`,
    (
		SELECT COUNT(*)
        FROM `posts` p
        WHERE p.`user_id` = u.`id`
	) AS `posts`,
    COUNT(uf.`user_id`) AS `followers`
FROM `users` u
INNER JOIN `users_followers` uf
	ON u.`id` = uf.`user_id`
		GROUP BY uf.`user_id`
ORDER BY `followers` DESC
LIMIT 1;

#--END OF TASK 11

#TASK 12.	Commenting Myself

#TASK 13.	User Top Posts

SELECT u.`id`, u.`username`, cq1.`caption`
FROM `users` u
JOIN
(
	SELECT cq.`id`, cq.`user_id`, cq.`caption`, MAX(cq.`comments_count`)
	FROM
	(
		SELECT p.`id`, p.`user_id`, p.`caption`, COUNT(c.`id`) AS `comments_count`
		FROM `posts` p
		LEFT JOIN `comments` c
		ON c.`post_id` = p.`id`
		GROUP BY p.`id`
		ORDER BY `comments_count` DESC, p.`id` ASC
	) AS `cq`
	GROUP BY cq.`user_id`
	ORDER BY cq.`user_id`
) AS `cq1`
ON u.`id` = cq1.`user_id`;

#TASK 14.	Posts and Commentators

SELECT
	p.`id`,
    p.`caption`,
	(
		SELECT COUNT(c.`user_id`)
		FROM `comments` c
		WHERE c.`post_id` = p.`id`
    ) AS `count_of_users`
FROM `posts` p 
GROUP BY p.`id`
ORDER BY
	`count_of_users` DESC,
    p.`id` ASC;

#--END OF TASK 14

#TASK 15.	Post
DROP PROCEDURE `udp_post`;
DELIMITER $$
CREATE PROCEDURE `udp_post` (
	`username` VARCHAR(30),
    `password` VARCHAR(30),
    `caption` VARCHAR(255),
    `path` VARCHAR(255)
)
BEGIN
	DECLARE `user_id` INT(11);
    DECLARE `picture_id` INT(11);
    
    IF 1 <> (SELECT COUNT(*) FROM `pictures` WHERE pictures.`path` = `path`)
    THEN 
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The picture does not exist!';
    END IF;
    
    IF 1 <> (SELECT COUNT(*) FROM `users` WHERE users.`username` = `username` AND users.`password` = `password`)
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Password is incorrect';
    END IF;
    
	SET `user_id` := (
		SELECT u.`id`
        FROM `users` u
        WHERE u.`username` = `username`
    );
    
    SET `picture_id` := (
		SELECT p.`id`
        FROM `pictures` p
        WHERE p.`path` = `path`
    );
    
    INSERT INTO `posts`(`caption`, `user_id`, `picture_id`)
    VALUES (`caption`, `user_id`, `picture_id`);
    
    #SELECT
	#	`id`,
    #    `caption`,
    #    `user_id`,
    #    `picture_id`
	#FROM `pictures` p;

    #SELECT `user_id`;
    #SELECT `picture_id`;
END $$

DELIMITER ;

CALL `udp_post`(
	'UnderSinduxrein',
    '4l8nYGTKMW',
    '#new #procedure', 
	'src/folders/resources/images/story/reformatted/img/hRI3TW31rC.img'
);

CALL `udp_post`(
	'UnderSinduxrein',
    'sad2asd',
    '#new #procedure', 
	'src/folders/resources/images/story/reformatted/img/hRI3TW31rC.img'
);

#--END OF TASK 15

#TASK 16.	Filter
DROP PROCEDURE `udp_filter`;
DELIMITER $$
CREATE PROCEDURE `udp_filter` (`hashtag` VARCHAR(255))
BEGIN
	SELECT
	p.`id`,
	p.`caption`,
    u.`username`
FROM `posts` p
INNER JOIN `users` u
	ON u.`id` = p.`user_id`
		WHERE p.`caption` LIKE CONCAT('%#', `hashtag`, '%')
ORDER BY p.`id` ASC;
END $$

DELIMITER ;

CALL `udp_filter`('cool');