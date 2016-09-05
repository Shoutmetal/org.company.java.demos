
USE `java-eight-tutorial` ;

-- -----------------------------------------------------
-- Table `java-eight-tutorial`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java-eight-tutorial`.`person` ;

CREATE TABLE IF NOT EXISTS `java-eight-tutorial`.`person` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Age` INT(11) NULL DEFAULT NULL,
  `Status` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java-eight-tutorial`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java-eight-tutorial`.`address` ;

CREATE TABLE IF NOT EXISTS `java-eight-tutorial`.`address` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) NULL DEFAULT NULL,
  `Number` VARCHAR(45) NULL DEFAULT NULL,
  `PersonId` INT(11) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_address_person_idx` (`PersonId` ASC),
  CONSTRAINT `fk_address_person`
    FOREIGN KEY (`PersonId`)
    REFERENCES `java-eight-tutorial`.`person` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java-eight-tutorial`.`persistent_logins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java-eight-tutorial`.`persistent_logins` ;

CREATE TABLE IF NOT EXISTS `java-eight-tutorial`.`persistent_logins` (
  `username` VARCHAR(64) NOT NULL,
  `series` VARCHAR(64) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `last_used` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java-eight-tutorial`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java-eight-tutorial`.`role` ;

CREATE TABLE IF NOT EXISTS `java-eight-tutorial`.`role` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Status` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java-eight-tutorial`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java-eight-tutorial`.`user` ;

CREATE TABLE IF NOT EXISTS `java-eight-tutorial`.`user` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `java-eight-tutorial`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java-eight-tutorial`.`user_role` ;

CREATE TABLE IF NOT EXISTS `java-eight-tutorial`.`user_role` (
  `UserId` INT(11) NOT NULL,
  `RoleId` INT(11) NOT NULL,
  INDEX `fk_role_user1_idx` (`UserId` ASC),
  INDEX `fk_user_role_role1_idx` (`RoleId` ASC),
  CONSTRAINT `fk_role_user1`
    FOREIGN KEY (`UserId`)
    REFERENCES `java-eight-tutorial`.`user` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`RoleId`)
    REFERENCES `java-eight-tutorial`.`role` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `java-eight-tutorial` ;

-- -----------------------------------------------------
-- procedure spuDeletePerson
-- -----------------------------------------------------

USE `java-eight-tutorial`;
DROP procedure IF EXISTS `java-eight-tutorial`.`spuDeletePerson`;

DELIMITER $$
USE `java-eight-tutorial`$$
CREATE  PROCEDURE `spuDeletePerson`(Id INT)
DELETE FROM person
WHERE person.Id = Id$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuInsertPerson
-- -----------------------------------------------------

USE `java-eight-tutorial`;
DROP procedure IF EXISTS `java-eight-tutorial`.`spuInsertPerson`;

DELIMITER $$
USE `java-eight-tutorial`$$
CREATE  PROCEDURE `spuInsertPerson`(
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

USE `java-eight-tutorial`;
DROP procedure IF EXISTS `java-eight-tutorial`.`spuSelectPerson`;

DELIMITER $$
USE `java-eight-tutorial`$$
CREATE PROCEDURE `spuSelectPerson`()
BEGIN

SELECT `person`.`Id`,
    `person`.`Name`,
    `person`.`Age`,
    `person`.`AddressId`,
    `person`.`Status`
FROM `java-eight-tutorial`.`person`;


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuSelectPersonById
-- -----------------------------------------------------

USE `java-eight-tutorial`;
DROP procedure IF EXISTS `java-eight-tutorial`.`spuSelectPersonById`;

DELIMITER $$
USE `java-eight-tutorial`$$
CREATE PROCEDURE `spuSelectPersonById`(
personId INT
)
SELECT `person`.`Id`,
    `person`.`Name`,
    `person`.`Age`,
    `person`.`AddressId`,
    `person`.`Status`
FROM `java-eight-tutorial`.`person`
WHERE `person`.`Id` = personId$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuSelectPersonByName
-- -----------------------------------------------------

USE `java-eight-tutorial`;
DROP procedure IF EXISTS `java-eight-tutorial`.`spuSelectPersonByName`;

DELIMITER $$
USE `java-eight-tutorial`$$
CREATE PROCEDURE `spuSelectPersonByName`(
personName VARCHAR(45)
)
SELECT `person`.`Id`,
    `person`.`Name`,
    `person`.`Age`,
    `person`.`AddressId`,
    `person`.`Status`
FROM `java-eight-tutorial`.`person`
WHERE `person`.`Name` like CONCAT('%' ,personName, '%')$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spuUpdatePerson
-- -----------------------------------------------------

USE `java-eight-tutorial`;
DROP procedure IF EXISTS `java-eight-tutorial`.`spuUpdatePerson`;

DELIMITER $$
USE `java-eight-tutorial`$$
CREATE  PROCEDURE `spuUpdatePerson`(
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
