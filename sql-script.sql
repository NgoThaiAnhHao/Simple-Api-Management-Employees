DROP DATABASE IF EXISTS `Management_Employee_Skills`;
CREATE DATABASE `Management_Employee_Skills`;
USE `Management_Employee_Skills`;

CREATE TABLE `employees` (
	`emp_id` INT AUTO_INCREMENT,
    `emp_name` VARCHAR(50) NOT NULL,
    `emp_email` VARCHAR(50) NOT NULL UNIQUE,
    `emp_status` ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT ('ACTIVE'),
    `emp_create_at` DATETIME,
    `emp_deleted` TINYINT NOT NULL DEFAULT 0,
    PRIMARY KEY (`emp_id`)
);

CREATE TABLE `skills` (
	`skill_id` INT AUTO_INCREMENT,
	`skill_name` VARCHAR(50) NOT NULL UNIQUE,
    `skill_category` ENUM('BACKEND', 'FRONTEND', 'DEVOPS') NOT NULL DEFAULT 'DEVOPS',
    PRIMARY KEY (`skill_id`)
);

CREATE TABLE `projects`(
	`project_id` INT AUTO_INCREMENT,
	`project_name` VARCHAR(50) NOT NULL UNIQUE,
    `project_start_date` DATETIME,
    `project_end_date` DATETIME,
    `project_status` VARCHAR(255),
    PRIMARY KEY (`project_id`)
);

CREATE TABLE `employee_skill` (
	`emp_id` INT,
    `skill_id` INT,
    `level` VARCHAR(50),
    `years_experience` INT,
    PRIMARY KEY (`emp_id`, `skill_id`),
    FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`),
    FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`)
);

CREATE TABLE `employee_project` (
	`emp_id` INT,
    `project_id` INT,
	`role` VARCHAR(255),
	`join_date` DATETIME,
	FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`),
    FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
);

CREATE TABLE `users` (
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
	`enabled` BOOLEAN NOT NULL,
    PRIMARY KEY (`username`)
);

CREATE TABLE `authorities` (
	`username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    FOREIGN KEY (`username`) REFERENCES `users`(`username`) ON DELETE CASCADE,
    UNIQUE KEY (`username`, `authority`)
);

-- Information for test case
INSERT INTO `employees` (`emp_name`, `emp_email`, `emp_create_at`) VALUES 
    ('Andy', 'andy@gmail.com', '2020-05-12'),
    ('Bob', 'bob@gmail.com', '2021-12-30'),
    ('Carol', 'carol@gmail.com', '2019-10-12'),
    ('Fred', 'fred@gmail.com', '2015-10-01');
    
INSERT INTO `skills` (`skill_name`, `skill_category`) VALUES 
	('Spring Boot', 'BACKEND'),
    ('React', 'FRONTEND'),
    ('Docker', 'DEVOPS'),
    ('Java', 'BACKEND'),
    ('Html', 'FRONTEND');

INSERT INTO `employee_skill` (`emp_id`, `skill_id`, `level`, `years_experience`) VALUES
	(1, 2, 'ADVANCED', 5),
    (1, 5, 'ADVANCED', 5),
    (2, 3, 'BEGINNER', 2),
    (3, 1, 'BEGINNER', 1),
    (4, 4, 'MID TERM', 7);
    
INSERT INTO `projects` (`project_name`, `project_start_date`, `project_end_date`) VALUES
 ('Order App Demo', '2025-10-01', '2025-10-25'),
 ('Book Management', '2025-10-01', '2025-12-01'),
 ('Banking App', '2025-12-05', '2025-12-30'),
 ('Ticket Shop', '2025-09-10', '2025-12-10');
 
INSERT INTO `employee_project` (`emp_id`, `project_id`, `role`) VALUES
	(1, 2, 'LEADER'),
    (2, 2, 'MEMBER'),
    (3, 2, 'MEMBER');
    
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
	('mary', '{bcrypt}$2a$12$FbLGOlF5pieUYrY1Ndi3xOuqxYuAFCBn/qdDOMo1mPeoPpt7hyjem', true),
    ('john', '{bcrypt}$2a$12$khh4qdNCc9irTKL5w6yWtuxojAaHHhhXkcrvUn1HRuqLA/CxlkzU2', true);

INSERT INTO `authorities` (`username`, `authority`) VALUES 
	('john', 'ROLE_USER'),
    ('mary', 'ROLE_USER'),
    ('mary', 'ROLE_ADMIN');

			











