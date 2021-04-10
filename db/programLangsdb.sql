-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema programLangsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `programLangsdb` ;

-- -----------------------------------------------------
-- Schema programLangsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `programLangsdb` DEFAULT CHARACTER SET utf8 ;
USE `programLangsdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  `main_location` TEXT(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `room` ;

CREATE TABLE IF NOT EXISTS `room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` TEXT(200) NULL,
  `description` TEXT(200) NULL,
  `photo` VARCHAR(45) NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_room_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_room_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item` ;

CREATE TABLE IF NOT EXISTS `item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `room_id` INT NOT NULL,
  `location` TEXT(200) NULL,
  `name` TEXT(200) NULL,
  `description` TEXT(200) NULL,
  `photo` VARCHAR(45) NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_items_room1_idx` (`room_id` ASC),
  CONSTRAINT `fk_items_room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS programLangsUser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'programLangsUser'@'localhost' IDENTIFIED BY 'programLangsUser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'programLangsUser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `programLangsdb`;
INSERT INTO `user` (`id`, `username`, `password`, `is_active`, `main_location`) VALUES (1, 'testUser', 'password', 1, 'home');

COMMIT;


-- -----------------------------------------------------
-- Data for table `room`
-- -----------------------------------------------------
START TRANSACTION;
USE `programLangsdb`;
INSERT INTO `room` (`id`, `user_id`, `name`, `description`, `photo`, `is_active`) VALUES (1, 1, 'living room', 'living room holds three items', 'relative disc image locat room', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `item`
-- -----------------------------------------------------
START TRANSACTION;
USE `programLangsdb`;
INSERT INTO `item` (`id`, `room_id`, `location`, `name`, `description`, `photo`, `is_active`) VALUES (1, 1, 'coffee table', 'car keys', 'meaning: There are 8 primary data types in java', 'relative disc image locat item', 1);

COMMIT;

