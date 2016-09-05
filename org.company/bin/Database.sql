-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema springbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springbd` DEFAULT CHARACTER SET utf8 ;
USE `springbd` ;

-- -----------------------------------------------------
-- Table `springbd`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springbd`.`person` ;

CREATE TABLE IF NOT EXISTS `springbd`.`person` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Age` INT(11) NULL DEFAULT NULL,
  `Status` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springbd`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springbd`.`address` ;

CREATE TABLE IF NOT EXISTS `springbd`.`address` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) NULL DEFAULT NULL,
  `Number` VARCHAR(45) NULL DEFAULT NULL,
  `PersonId` INT(11) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_address_person_idx` (`PersonId` ASC),
  CONSTRAINT `fk_address_person`
    FOREIGN KEY (`PersonId`)
    REFERENCES `springbd`.`person` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springbd`.`persistent_logins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springbd`.`persistent_logins` ;

CREATE TABLE IF NOT EXISTS `springbd`.`persistent_logins` (
  `username` VARCHAR(64) NOT NULL,
  `series` VARCHAR(64) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `last_used` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springbd`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springbd`.`role` ;

CREATE TABLE IF NOT EXISTS `springbd`.`role` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Status` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springbd`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springbd`.`user` ;

CREATE TABLE IF NOT EXISTS `springbd`.`user` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springbd`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springbd`.`user_role` ;

CREATE TABLE IF NOT EXISTS `springbd`.`user_role` (
  `UserId` INT(11) NOT NULL,
  `RoleId` INT(11) NOT NULL,
  INDEX `fk_role_user1_idx` (`UserId` ASC),
  INDEX `fk_user_role_role1_idx` (`RoleId` ASC),
  CONSTRAINT `fk_role_user1`
    FOREIGN KEY (`UserId`)
    REFERENCES `springbd`.`user` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`RoleId`)
    REFERENCES `springbd`.`role` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `springbd` ;

-- -----------------------------------------------------
-- procedure spuDeletePerson
-- -----------------------------------------------------

USE `springbd`;
DROP procedure IF EXISTS `springbd`.`spuDeletePerson`;

DELIMITER $$
USE `springbd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spuDeletePerson`(Id INT)
DELETE FROM person
WHERE person.Id = Id$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuInsertPerson
-- -----------------------------------------------------

USE `springbd`;
DROP procedure IF EXISTS `springbd`.`spuInsertPerson`;

DELIMITER $$
USE `springbd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spuInsertPerson`(
Name VARCHAR(45),
Age INTEGER,
Status BIT
)
INSERT INTO person
(`Name`,
`Age`,
`AddressId`,
`Status`)
VALUES
(
Name,
Age,
NULL,
Status)$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuSelectPerson
-- -----------------------------------------------------

USE `springbd`;
DROP procedure IF EXISTS `springbd`.`spuSelectPerson`;

DELIMITER $$
USE `springbd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spuSelectPerson`()
BEGIN

SELECT `person`.`Id`,
    `person`.`Name`,
    `person`.`Age`,
    `person`.`AddressId`,
    `person`.`Status`
FROM `springbd`.`person`;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuSelectPersonById
-- -----------------------------------------------------

USE `springbd`;
DROP procedure IF EXISTS `springbd`.`spuSelectPersonById`;

DELIMITER $$
USE `springbd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spuSelectPersonById`(
personId INT
)
SELECT `person`.`Id`,
    `person`.`Name`,
    `person`.`Age`,
    `person`.`AddressId`,
    `person`.`Status`
FROM `springbd`.`person`
WHERE `person`.`Id` = personId$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuSelectPersonByName
-- -----------------------------------------------------

USE `springbd`;
DROP procedure IF EXISTS `springbd`.`spuSelectPersonByName`;

DELIMITER $$
USE `springbd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spuSelectPersonByName`(
personName VARCHAR(45)
)
SELECT `person`.`Id`,
    `person`.`Name`,
    `person`.`Age`,
    `person`.`AddressId`,
    `person`.`Status`
FROM `springbd`.`person`
WHERE `person`.`Name` like CONCAT('%' ,personName, '%')$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuUpdatePerson
-- -----------------------------------------------------

USE `springbd`;
DROP procedure IF EXISTS `springbd`.`spuUpdatePerson`;

DELIMITER $$
USE `springbd`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spuUpdatePerson`(
Id INT,
Name VARCHAR(45),
Age INT,
Status BIT
)
UPDATE person
SET
person.Name = Name,
person.Age = Age,
person.Status = Status
WHERE person.Id = Id$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
