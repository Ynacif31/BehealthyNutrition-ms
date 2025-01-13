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
CREATE TABLE IF NOT EXISTS `consultation_history` (
                                                     `id` INT AUTO_INCREMENT PRIMARY KEY,
                                                      `patient_id` INT NOT NULL,
                                                      `consultation_date` DATETIME NOT NULL,
                                                      `notes` TEXT,
                                                      `next_consultation_date` DATETIME,
                                                      FOREIGN KEY (`patient_id`) REFERENCES `patient`(`patient_id`)
    );

CREATE TABLE IF NOT EXISTS `progress` (
                                          `id` INT AUTO_INCREMENT PRIMARY KEY,
                                          `patient_id` INT NOT NULL,
                                          `progress_date` DATETIME NOT NULL,
                                          `details` TEXT,
                                          FOREIGN KEY (`patient_id`) REFERENCES `patient`(`patient_id`)
    );

CREATE TABLE IF NOT EXISTS `diet_plan` (
                                           `id` INT AUTO_INCREMENT PRIMARY KEY,
                                           `patient_id` INT NOT NULL,
                                           `plan_details` TEXT,
                                           FOREIGN KEY (`patient_id`) REFERENCES `patient`(`patient_id`)
    );
