-- MySQL Script generated by MySQL Workbench
-- Thu Apr 28 02:05:30 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MobileStore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MobileStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MobileStore` DEFAULT CHARACTER SET utf8 ;
USE `MobileStore` ;

-- -----------------------------------------------------
-- Table `MobileStore`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surename` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Mobile_Stores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Mobile_Stores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Workers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Workers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NULL,
  `experience` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  `mobile_stores_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_workers_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_workers_mobileStores1_idx` (`mobile_stores_id` ASC) VISIBLE,
  CONSTRAINT `fk_workers_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `MobileStore`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_workers_mobileStores1`
    FOREIGN KEY (`mobile_stores_id`)
    REFERENCES `MobileStore`.`Mobile_Stores` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Clients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `creditCardNumber` INT UNSIGNED NOT NULL,
  `user_id` INT NOT NULL,
  `workers_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `creditCardNumber_UNIQUE` (`creditCardNumber` ASC) VISIBLE,
  INDEX `fk_client_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_Clients_Workers1_idx` (`workers_id` ASC) VISIBLE,
  CONSTRAINT `fk_client_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `MobileStore`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Clients_Workers1`
    FOREIGN KEY (`workers_id`)
    REFERENCES `MobileStore`.`Workers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Processors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Processors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `frequency` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Displays`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Displays` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipes` VARCHAR(45) NULL,
  `inch` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Batteries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Batteries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `capacity` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Memories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Memories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `capacity` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Specifications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Specifications` (
  `id` INT NOT NULL,
  `cpu_id` INT NOT NULL,
  `display_id` INT NOT NULL,
  `battery_id` INT NOT NULL,
  `memory_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_specifications_cpu1_idx` (`cpu_id` ASC) VISIBLE,
  INDEX `fk_specifications_display1_idx` (`display_id` ASC) VISIBLE,
  INDEX `fk_specifications_battery1_idx` (`battery_id` ASC) VISIBLE,
  INDEX `fk_specifications_memory1_idx` (`memory_id` ASC) VISIBLE,
  CONSTRAINT `fk_specifications_cpu1`
    FOREIGN KEY (`cpu_id`)
    REFERENCES `MobileStore`.`Processors` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_specifications_display1`
    FOREIGN KEY (`display_id`)
    REFERENCES `MobileStore`.`Displays` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_specifications_battery1`
    FOREIGN KEY (`battery_id`)
    REFERENCES `MobileStore`.`Batteries` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_specifications_memory1`
    FOREIGN KEY (`memory_id`)
    REFERENCES `MobileStore`.`Memories` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Mobile_Phones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Mobile_Phones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mobileStores_id` INT NOT NULL,
  `imei` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `specifications_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mobilePhone_mobileStores1_idx` (`mobileStores_id` ASC) VISIBLE,
  INDEX `fk_mobilePhone_specifications1_idx` (`specifications_id` ASC) VISIBLE,
  CONSTRAINT `fk_mobilePhone_mobileStores1`
    FOREIGN KEY (`mobileStores_id`)
    REFERENCES `MobileStore`.`Mobile_Stores` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_mobilePhone_specifications1`
    FOREIGN KEY (`specifications_id`)
    REFERENCES `MobileStore`.`Specifications` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Orders` (
  `id` INT NOT NULL,
  `clients_id` INT NOT NULL,
  `mobile_stores_id` INT NOT NULL,
  `mobile_phones_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clients_has_mobileStores_mobileStores1_idx` (`mobile_stores_id` ASC) VISIBLE,
  INDEX `fk_clients_has_mobileStores_clients1_idx` (`clients_id` ASC) VISIBLE,
  INDEX `fk_Orders_Mobile_Phones1_idx` (`mobile_phones_id` ASC) VISIBLE,
  CONSTRAINT `fk_clients_has_mobileStores_clients1`
    FOREIGN KEY (`clients_id`)
    REFERENCES `MobileStore`.`Clients` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_clients_has_mobileStores_mobileStores1`
    FOREIGN KEY (`mobile_stores_id`)
    REFERENCES `MobileStore`.`Mobile_Stores` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Orders_Mobile_Phones1`
    FOREIGN KEY (`mobile_phones_id`)
    REFERENCES `MobileStore`.`Mobile_Phones` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Service_Centers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Service_Centers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Warranties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Warranties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clients_id` INT NULL,
  `name_breakdown` VARCHAR(45) NULL,
  `mobile_stores_id` INT NULL,
  `mobile_phones_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Clients_has_ServiceCenters_Clients1_idx` (`clients_id` ASC) VISIBLE,
  INDEX `fk_Warranties_Mobile_Stores1_idx` (`mobile_stores_id` ASC) VISIBLE,
  INDEX `fk_Warranties_Mobile_Phones1_idx` (`mobile_phones_id` ASC) VISIBLE,
  CONSTRAINT `fk_Clients_has_ServiceCenters_Clients1`
    FOREIGN KEY (`clients_id`)
    REFERENCES `MobileStore`.`Clients` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Warranties_Mobile_Stores1`
    FOREIGN KEY (`mobile_stores_id`)
    REFERENCES `MobileStore`.`Mobile_Stores` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Warranties_Mobile_Phones1`
    FOREIGN KEY (`mobile_phones_id`)
    REFERENCES `MobileStore`.`Mobile_Phones` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Service_Centers_has_Warranties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Service_Centers_has_Warranties` (
  `service_centers_id` INT NOT NULL,
  `warranties_id` INT NOT NULL,
  PRIMARY KEY (`service_centers_id`, `warranties_id`),
  INDEX `fk_Service_Centers_has_Warranties_Warranties1_idx` (`warranties_id` ASC) VISIBLE,
  INDEX `fk_Service_Centers_has_Warranties_Service_Centers1_idx` (`service_centers_id` ASC) VISIBLE,
  CONSTRAINT `fk_Service_Centers_has_Warranties_Service_Centers1`
    FOREIGN KEY (`service_centers_id`)
    REFERENCES `MobileStore`.`Service_Centers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Service_Centers_has_Warranties_Warranties1`
    FOREIGN KEY (`warranties_id`)
    REFERENCES `MobileStore`.`Warranties` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MobileStore`.`Service_Centers_has_Mobile_Stores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MobileStore`.`Service_Centers_has_Mobile_Stores` (
  `Service_Centers_id` INT NOT NULL,
  `Mobile_Stores_id` INT NOT NULL,
  PRIMARY KEY (`Service_Centers_id`, `Mobile_Stores_id`),
  INDEX `fk_Service_Centers_has_Mobile_Stores_Mobile_Stores1_idx` (`Mobile_Stores_id` ASC) VISIBLE,
  INDEX `fk_Service_Centers_has_Mobile_Stores_Service_Centers1_idx` (`Service_Centers_id` ASC) VISIBLE,
  CONSTRAINT `fk_Service_Centers_has_Mobile_Stores_Service_Centers1`
    FOREIGN KEY (`Service_Centers_id`)
    REFERENCES `MobileStore`.`Service_Centers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Service_Centers_has_Mobile_Stores_Mobile_Stores1`
    FOREIGN KEY (`Mobile_Stores_id`)
    REFERENCES `MobileStore`.`Mobile_Stores` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
