CREATE TABLE IF NOT EXISTS `patient` (
                                         `patient_id` INT AUTO_INCREMENT PRIMARY KEY,
                                         `name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `mobile_number` VARCHAR(20) NOT NULL,
    `birth_date` DATE NOT NULL,
    `weight` DOUBLE NOT NULL,
    `height` DOUBLE NOT NULL,
    `imc` DOUBLE NOT NULL,
    `gender` VARCHAR(10) NOT NULL
    );