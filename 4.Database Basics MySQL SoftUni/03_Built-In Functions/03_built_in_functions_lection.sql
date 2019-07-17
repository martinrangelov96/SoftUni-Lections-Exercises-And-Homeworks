SELECT CONCAT(SUBSTRING(`first_name`,1,1), '. ', `last_name`) AS 'full_name'
FROM book_library.authors;

SELECT `title`
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The';

SELECT REPLACE('PeshoPe', 'Pe', 'Go');

SELECT REPLACE(`title`, 'The', '***')
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The';

SELECT CONCAT (TRIM('    Ala Bala      '));

SELECT `first_name`
FROM authors
WHERE CHAR_LENGTH(`first_name`) > 4;

SELECT LENGTH('Пешо'), CHAR_LENGTH('Пешо');

SELECT REVERSE(`first_name`)
FROM `authors`;

SELECT REPEAT('*', 5);

SELECT `first_name`, REPEAT('*', CHAR_LENGTH(`first_name`))
FROM `authors`;

SELECT `first_name`, LOCATE('g', `first_name`)
FROM `authors`;

SELECT `first_name`
FROM `authors`
WHERE LOCATE('n', `first_name`) > 0;

SELECT `first_name`
FROM `authors`
WHERE LOCATE('e', `first_name`, 3) > 0;

SELECT INSERT(`first_name`, 2 , 2, '----')
FROM `authors`;

SELECT
	5 DIV 4,
    5 / 4,
    5 + 4,
    5 - 4,
    5 * 4,
    5 % 4;
    
SELECT PI() + 0.0000000000000000000;

SELECT 	RAND(),
		ROUND(RAND() * 24),
		ABS(-1),
		ABS(2),
        SQRT(9),
        SQRT(7),
        POW(2, 10),
        POW(2, -1),
        POW(2.3, 2.2),
        POW(PI(), 10),
        CONV(15, 10, 2),
		PI(),
        ROUND(PI(), 3),
        ROUND(PI(), -3);
        
USE book_library;

SELECT `first_name`, `last_name`, TIMESTAMPDIFF(DAY, `born`, `died`)
FROM authors;

SELECT `title`
FROM books
WHERE `title` LIKE 'the%';

SELECT *
FROM `authors`
WHERE `first_name` LIKE 'a%';

SELECT *
FROM `books`
WHERE `title` LIKE '%Harry Potter%';

SELECT REPLACE(`title`, 'The', '***') AS title
FROM `books`
WHERE `title` LIKE 'The%';