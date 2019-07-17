#JOIN tables
SELECT c.`id` AS camper_id,
		v.`id` AS vehicle_id,
	CONCAT(c.`first_name`, ' ', c.`last_name`) AS `full_name`,
	c.`age`,
    v.`vehicle_type`,
    r.`beds_count`
FROM `campers` c
JOIN `vehicles` v
ON c.`id` = v.`driver_id`
JOIN rooms r
ON r.`id` = c.`room`;