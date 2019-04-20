#TASK 00. Table Design 

CREATE TABLE `planets` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `spaceports` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
	`planet_id` INT(11),
		FOREIGN KEY (`planet_id`)
			REFERENCES `planets`(`id`)
);

CREATE TABLE `spaceships` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
	`manufacturer` VARCHAR(30) NOT NULL,
    `light_speed_rate` INT(11) DEFAULT 0
);

CREATE TABLE `colonists` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(20) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
    `ucn` CHAR(10) NOT NULL UNIQUE,
    `birth_date` DATE NOT NULL
);

CREATE TABLE `journeys` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `journey_start` DATETIME NOT NULL,
    `journey_end` DATETIME NOT NULL,
    `purpose` ENUM('Medical','Technical','Educational','Military'),
    `destination_spaceport_id` INT (11),
		FOREIGN KEY (`destination_spaceport_id`)
			REFERENCES `spaceports`(`id`),
	`spaceship_id` INT(11),
		FOREIGN KEY (`spaceship_id`)
			REFERENCES `spaceships`(`id`)
);

CREATE TABLE `travel_cards` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `card_number` CHAR(10) NOT NULL UNIQUE,
    `job_during_journey` ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
    `colonist_id` INT (11),
		FOREIGN KEY (`colonist_id`)
			REFERENCES `colonists`(`id`),
	`journey_id` INT(11),
		FOREIGN KEY (`journey_id`)
			REFERENCES `journeys`(`id`)
);

#--END OF TASK 00

#TASK 01. Insert 

INSERT INTO `travel_cards`(`card_number`,`job_during_journey`, `colonist_id` ,`journey_id`)
SELECT

	(CASE
		WHEN c.`birth_date` > '1980-01-01' THEN CONCAT(YEAR(c.`birth_date`),DAY(c.`birth_date`),LEFT(c.`ucn`, 4))
        ELSE CONCAT(YEAR(c.`birth_date`), MONTH(c.`birth_date`), RIGHT(c.`ucn`, 4))
    END) `card_number`,
    (CASE 
		WHEN c.`id` % 2 = 0 THEN "Pilot"
        WHEN c.`id` % 3 = 0 THEN "Cook"
        ELSE "Engineer"
    END) `job_during_journey`,
    c.`id`,
    LEFT(`ucn`, 1) `journey_id`

FROM `colonists` c
	WHERE c.`id` BETWEEN 96 AND 100;
    
#--END OF TASK 1

#TASK 02.	Data Update

UPDATE `journeys`
	SET `purpose` = 
		CASE
			WHEN `id` % 2 = 0 THEN "Medical"
            WHEN `id` % 3 = 0 THEN "Technical"
            WHEN `id` % 5 = 0 THEN "Educational"
            WHEN `id` % 7 = 0 THEN "Military"
            ELSE `purpose`
        END;
        
#--END OF TASK 2

#TASK 03.Data Deletion

DELETE FROM `colonists`
	WHERE `id` NOT IN (
		SELECT tc.`colonist_id` FROM `travel_cards` tc
    );

#--END OF TASK 3

#TASK 4

SELECT
	tc.`card_number`,
    tc.`job_during_journey`
FROM `travel_cards` tc
ORDER BY tc.`card_number` ASC;

#--END OF TASK 4

#TASK Extract all colonists

SELECT
	c.`id`,
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS `full_name`,
    c.`ucn`
FROM `colonists` c
ORDER BY 
	c.`first_name` ASC,
    c.`last_name` ASC,
    c.`id` ASC;

#--END OF TASK 5

#TASK 06.	Extract all military journeys

SELECT
	j.`id`,
    j.`journey_start`,
    j.`journey_end`
FROM `journeys` j
	WHERE j.`purpose` = 'Military'
ORDER BY j.`journey_start` ASC;

#--END OF TASK 6

#TASK 07.Extract all pilots

SELECT
	c.`id`,
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS `full_name`
FROM `colonists` c
JOIN `travel_cards` tc
	ON tc.`colonist_id` = c.`id`
		WHERE tc.`job_during_journey` = 'Pilot'
ORDER BY c.`id` ASC;

#--END OF TASK 7

#TASK 08.	Count all colonists that are on technical journey

SELECT
	COUNT(c.`id`)
FROM `colonists` c
JOIN `travel_cards` tc
	ON tc.`colonist_id` = c.`id`
JOIN `journeys` j
	ON tc.`journey_id` = j.`id`
		WHERE j.`purpose` = 'Technical';
        
#--END OF TASK 8

#TASK 9 Extract the fastest spaceship

SELECT
	ss.`name` AS `spaceship_name`,
    sp.`name` AS` spaceport_name`
FROM `spaceships` ss
JOIN `journeys` j
	ON j.`spaceship_id` = ss.`id`
JOIN `spaceports` sp
	ON j.`destination_spaceport_id` = sp.`id`
ORDER BY ss.`light_speed_rate` DESC
LIMIT 1;

#--END OF TASK 9

#TASK 10 Extract spaceships with pilots younger than 30 years

SELECT
	ss.`name`,
    ss.`manufacturer`
FROM `spaceships` ss
JOIN `journeys` j
	ON j.`spaceship_id` = ss.`id`
JOIN `travel_cards` tc
	ON tc.`journey_id` = j.`id`
JOIN `colonists` c
	ON tc.`colonist_id` = c.`id`
		WHERE tc.`job_during_journey` = 'Pilot' AND 2019 - YEAR(c.`birth_date`) < 30
ORDER BY ss.`name` ASC;

#--END OF TASK 10

#TASK 11 Extract all educational mission planets and spaceports

SELECT
	p.`name`,
    sp.`name`
FROM `planets` p
JOIN `spaceports` sp
	ON sp.`planet_id` = p.`id`
JOIN `journeys` j
	ON j.`destination_spaceport_id` = sp.`id`
		WHERE j.`purpose` = 'Educational'
ORDER BY sp.`name` DESC;

#--END OF TASK 11

#TASK 12 Extract all planets and their journey count

SELECT
	p.`name`,
    COUNT(j.`id`) AS `journeys_count`
FROM `planets` p
JOIN `spaceports` sp
	ON sp.`planet_id` = p.`id`
JOIN `journeys` j
	ON j.`destination_spaceport_id` = sp.`id`
GROUP BY p.`id`
ORDER BY
	`journeys_count` DESC,
	p.`name` ASC;

#--END OF TASK 12

#TASK 13.Extract the shortest journey

SELECT
	j.`id`,
    p.`name`,
    sp.`name`,
    j.`purpose`
FROM `journeys` j
JOIN `spaceports` sp
	ON sp.`id` = j.`destination_spaceport_id`
JOIN `planets` p
	ON p.`id` = sp.`planet_id`
ORDER BY (j.`journey_end` - j.`journey_start`) ASC
LIMIT 1;

#--END OF TASK 13

#TASK 14 Extract the less popular job

SELECT
	tc.`job_during_journey` AS `job_name`
FROM `travel_cards` tc
JOIN `journeys` j
	ON j.`id` = tc.`journey_id`
ORDER BY (j.`journey_end` - j.`journey_start`) DESC
LIMIT 1;

#SELECT
#	tc.`job_during_journey`,
#	 COUNT(c.`id`)
#FROM `colonists` c
#JOIN `travel_cards` tc
#	ON tc.`colonist_id` = c.`id`
#		GROUP BY tc.`job_during_journey`;
			
#--END OF TASK 14

#TASK 15 Get colonists count
DELIMITER $$
CREATE FUNCTION `udf_count_colonists_by_destination_planet`(`planet_name` VARCHAR(30))
RETURNS INT
BEGIN
	DECLARE `e_count` INT;
    SET `e_count` := (
		SELECT 		
			COUNT(c.`id`)
        FROM `colonists` c
        JOIN `travel_cards` tc
			ON tc.`colonist_id` = c.`id`
		JOIN `journeys` j
			ON j.`id` = tc.`journey_id`
		JOIN `spaceports` sp
			ON sp.`id` = j.`destination_spaceport_id`
		JOIN `planets` p
			ON p.`id` = sp.`planet_id`
				WHERE p.`name` = `planet_name`
    );
    RETURN `e_count`;
END $$

DELIMITER ;

SELECT p.name, udf_count_colonists_by_destination_planet('WR8') AS count
FROM planets AS p	
WHERE p.name = 'WR8';

#--END OF TASK 15

#TASk 16 Modify spaceship
DELIMITER $$
CREATE PROCEDURE `udp_modify_spaceship_light_speed_rate`(
	spaceship_name VARCHAR(50), 
    light_speed_rate_increse INT(11)
)
BEGIN
		IF (SELECT COUNT(ss.`name`) FROM `spaceships` ss WHERE ss.`name` = `spaceship_name` > 0)
        THEN UPDATE `spaceships`
			SET `light_speed_rate` = `light_speed_rate` + `light_speed_rate_increse`
				WHERE `name` = `spaceship_name`;
		ELSE
			SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
		ROLLBACK;
		END IF;
END $$

DELIMITER ;

CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
CALL udp_modify_spaceship_light_speed_rate ('USS Templar', 5);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'USS Templar';
