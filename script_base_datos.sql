-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Prototipo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Prototipo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Prototipo` DEFAULT CHARACTER SET utf8 ;
USE `Prototipo` ;

-- -----------------------------------------------------
-- Table `Prototipo`.`EstadoCivil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`EstadoCivil` (
  `estadoCivilId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`estadoCivilId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Pais` (
  `paisId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`paisId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Provincia` (
  `provinciaId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `paisId` INT NOT NULL,
  PRIMARY KEY (`provinciaId`),
  INDEX `fk_Provincia_Pais1_idx` (`paisId` ASC) VISIBLE,
  CONSTRAINT `fk_Provincia_Pais1`
    FOREIGN KEY (`paisId`)
    REFERENCES `Prototipo`.`Pais` (`paisId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Canton`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Canton` (
  `cantonId` INT NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `provinciaId` INT NOT NULL,
  PRIMARY KEY (`cantonId`),
  INDEX `fk_Canton_Provincia1_idx` (`provinciaId` ASC) VISIBLE,
  CONSTRAINT `fk_Canton_Provincia1`
    FOREIGN KEY (`provinciaId`)
    REFERENCES `Prototipo`.`Provincia` (`provinciaId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Direccion` (
  `direccionId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `cantonId` INT NOT NULL,
  PRIMARY KEY (`direccionId`),
  INDEX `fk_Direccion_Canton1_idx` (`cantonId` ASC) VISIBLE,
  CONSTRAINT `fk_Direccion_Canton1`
    FOREIGN KEY (`cantonId`)
    REFERENCES `Prototipo`.`Canton` (`cantonId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Cargo` (
  `cargoId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`cargoId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Empleado` (
  `empleadoId` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `estadoCivilId` INT NOT NULL,
  `direccionId` INT NOT NULL,
  `activo` VARCHAR(1) NOT NULL,
  `Cargo_cargoId` INT NOT NULL,
  `usuario` VARCHAR(45) NULL,
  `contrasena` VARCHAR(45) NULL,
  PRIMARY KEY (`empleadoId`),
  INDEX `fk_Persona_EstadoCivil_idx` (`estadoCivilId` ASC) VISIBLE,
  INDEX `fk_Persona_Direccion1_idx` (`direccionId` ASC) VISIBLE,
  INDEX `fk_Empleado_Cargo1_idx` (`Cargo_cargoId` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_EstadoCivil`
    FOREIGN KEY (`estadoCivilId`)
    REFERENCES `Prototipo`.`EstadoCivil` (`estadoCivilId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Persona_Direccion1`
    FOREIGN KEY (`direccionId`)
    REFERENCES `Prototipo`.`Direccion` (`direccionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Cargo1`
    FOREIGN KEY (`Cargo_cargoId`)
    REFERENCES `Prototipo`.`Cargo` (`cargoId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Empresa` (
  `empresaId` INT NOT NULL AUTO_INCREMENT,
  `ruc` VARCHAR(13) NOT NULL,
  `razonSocial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`empresaId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Cliente` (
  `clienteId` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `estadoCivilId` INT NOT NULL,
  `direccionId` INT NOT NULL,
  `activo` VARCHAR(1) NOT NULL,
  `cargoId` INT NULL,
  `identificador` VARCHAR(45) NOT NULL,
  `telefTrabajo` VARCHAR(45) NOT NULL,
  `numHijos` INT NOT NULL,
  `empresaId` INT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`clienteId`),
  INDEX `fk_Persona_EstadoCivil_idx` (`estadoCivilId` ASC) VISIBLE,
  INDEX `fk_Persona_Direccion1_idx` (`direccionId` ASC) VISIBLE,
  INDEX `fk_Empleado_Cargo1_idx` (`cargoId` ASC) VISIBLE,
  INDEX `fk_Cliente_Empresa1_idx` (`empresaId` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_EstadoCivil0`
    FOREIGN KEY (`estadoCivilId`)
    REFERENCES `Prototipo`.`EstadoCivil` (`estadoCivilId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Persona_Direccion10`
    FOREIGN KEY (`direccionId`)
    REFERENCES `Prototipo`.`Direccion` (`direccionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Cargo10`
    FOREIGN KEY (`cargoId`)
    REFERENCES `Prototipo`.`Cargo` (`cargoId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_Empresa1`
    FOREIGN KEY (`empresaId`)
    REFERENCES `Prototipo`.`Empresa` (`empresaId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`CasaBuilder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`CasaBuilder` (
  `casaBaseId` INT NOT NULL AUTO_INCREMENT,
  `metrosCuadrados` DOUBLE NOT NULL,
  `numPlantas` INT NOT NULL,
  `esquinera` VARCHAR(1) NOT NULL,
  `orientacion` VARCHAR(45) NOT NULL,
  `patio` VARCHAR(1) NOT NULL,
  `numHabitaciones` INT NOT NULL,
  `numBanios` INT NOT NULL,
  `precio` DOUBLE NOT NULL,
  `nombre` VARCHAR(100) NULL,
  PRIMARY KEY (`casaBaseId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`CasaCreada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`CasaCreada` (
  `casaAdicionalId` INT NOT NULL AUTO_INCREMENT,
  `Casa_casaId` INT NOT NULL,
  PRIMARY KEY (`casaAdicionalId`),
  INDEX `fk_Casa_has_Adicional_Casa1_idx` (`Casa_casaId` ASC) VISIBLE,
  CONSTRAINT `fk_Casa_has_Adicional_Casa1`
    FOREIGN KEY (`Casa_casaId`)
    REFERENCES `Prototipo`.`CasaBuilder` (`casaBaseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`Cotizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`Cotizacion` (
  `cotizacionId` INT NOT NULL AUTO_INCREMENT,
  `clienteId` INT NOT NULL,
  `casaCreadaId` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`cotizacionId`),
  INDEX `fk_Cliente_has_Casa_Cliente1_idx` (`clienteId` ASC) VISIBLE,
  INDEX `fk_Cotizacion_CasaCreada1_idx` (`casaCreadaId` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_has_Casa_Cliente1`
    FOREIGN KEY (`clienteId`)
    REFERENCES `Prototipo`.`Cliente` (`clienteId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cotizacion_CasaCreada1`
    FOREIGN KEY (`casaCreadaId`)
    REFERENCES `Prototipo`.`CasaCreada` (`casaAdicionalId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`EmpleadoCreaCasa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`EmpleadoCreaCasa` (
  `empleadoCasaCreadaId` INT NOT NULL AUTO_INCREMENT,
  `empleadoId` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `casaCreada` INT NOT NULL,
  PRIMARY KEY (`empleadoCasaCreadaId`),
  INDEX `fk_Empleado_has_Casa_Empleado1_idx` (`empleadoId` ASC) VISIBLE,
  INDEX `fk_EmpleadoCasaCreada_CasaAdicional1_idx` (`casaCreada` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_has_Casa_Empleado1`
    FOREIGN KEY (`empleadoId`)
    REFERENCES `Prototipo`.`Empleado` (`empleadoId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EmpleadoCasaCreada_CasaAdicional1`
    FOREIGN KEY (`casaCreada`)
    REFERENCES `Prototipo`.`CasaCreada` (`casaAdicionalId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`AdicionalBanios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`AdicionalBanios` (
  `adicionalBaniosId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`adicionalBaniosId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`AdicionalGriferia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`AdicionalGriferia` (
  `adicionalGriferiaId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`adicionalGriferiaId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`AdicionalIluminacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`AdicionalIluminacion` (
  `adicionalIluminacionId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`adicionalIluminacionId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`AdicionalTecho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`AdicionalTecho` (
  `adicionalTechoId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`adicionalTechoId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`AdicionalPiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`AdicionalPiso` (
  `adicionalPisoId` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`adicionalPisoId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Prototipo`.`CasaCreada_Adicional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prototipo`.`CasaCreada_Adicional` (
  `CasaCreada_Adicional` INT NOT NULL AUTO_INCREMENT,
  `casaCreadaId` INT NOT NULL,
  `adicionalId` INT NOT NULL,
  `adicionalBaniosId` INT NULL,
  `adicionalGriferiaId` INT NULL,
  `adicionalIluminacionId` INT NULL,
  `adicionalTechoId` INT NULL,
  `adicionalPisoId` INT NULL,
  PRIMARY KEY (`CasaCreada_Adicional`),
  INDEX `fk_CasaCreada_has_Adicional_CasaCreada1_idx` (`casaCreadaId` ASC) VISIBLE,
  INDEX `fk_CasaCreada_Adicional_AdicionalBanios1_idx` (`adicionalBaniosId` ASC) VISIBLE,
  INDEX `fk_CasaCreada_Adicional_AdicionalGriferia1_idx` (`adicionalGriferiaId` ASC) VISIBLE,
  INDEX `fk_CasaCreada_Adicional_AdicionalIluminacion1_idx` (`adicionalIluminacionId` ASC) VISIBLE,
  INDEX `fk_CasaCreada_Adicional_AdicionalTecho1_idx` (`adicionalTechoId` ASC) VISIBLE,
  INDEX `fk_CasaCreada_Adicional_AdicionalPiso1_idx` (`adicionalPisoId` ASC) VISIBLE,
  CONSTRAINT `fk_CasaCreada_has_Adicional_CasaCreada1`
    FOREIGN KEY (`casaCreadaId`)
    REFERENCES `Prototipo`.`CasaCreada` (`casaAdicionalId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CasaCreada_Adicional_AdicionalBanios1`
    FOREIGN KEY (`adicionalBaniosId`)
    REFERENCES `Prototipo`.`AdicionalBanios` (`adicionalBaniosId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CasaCreada_Adicional_AdicionalGriferia1`
    FOREIGN KEY (`adicionalGriferiaId`)
    REFERENCES `Prototipo`.`AdicionalGriferia` (`adicionalGriferiaId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CasaCreada_Adicional_AdicionalIluminacion1`
    FOREIGN KEY (`adicionalIluminacionId`)
    REFERENCES `Prototipo`.`AdicionalIluminacion` (`adicionalIluminacionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CasaCreada_Adicional_AdicionalTecho1`
    FOREIGN KEY (`adicionalTechoId`)
    REFERENCES `Prototipo`.`AdicionalTecho` (`adicionalTechoId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CasaCreada_Adicional_AdicionalPiso1`
    FOREIGN KEY (`adicionalPisoId`)
    REFERENCES `Prototipo`.`AdicionalPiso` (`adicionalPisoId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `EstadoCivil` VALUES (5,'SOLTERO/A'),(6,'DIVORCIADO/A'),(7,'VIUDO/A'),(8,'CASADO/A');

INSERT INTO `Pais` VALUES (1,'Karmaland');

INSERT INTO `Provincia` VALUES (1,'Principal',1);

INSERT INTO `Canton` VALUES (1,'Caton1',1);

INSERT INTO `Direccion` VALUES (1,'Mi Dirr1',1);

INSERT INTO `Cargo` VALUES (1,'EMPLEADO'),(2,'ADMINISTRADOR'),(3,'VENDEDOR');

INSERT INTO `Empresa` VALUES (1,'1234','Rubius Copr'),(2,'5678','Pyhonix'),(3,'9876','Valve'),(4,'6543','Activision'),(5,'2584','Bandain Namco');

INSERT INTO `AdicionalBanios` VALUES (1,'japones',120),(2,'normal',50);

INSERT INTO `AdicionalGriferia` VALUES (1,'normal',60),(2,'inoxidable',95);

INSERT INTO `AdicionalIluminacion` VALUES (1,'normal',25),(2,'led',35);

INSERT INTO `AdicionalPiso` VALUES (1,'valdoza',150),(2,'marmol',300);

INSERT INTO `AdicionalTecho` VALUES (1,'cielo razo',150),(2,'teja',10);

INSERT INTO `CasaBuilder` VALUES (1,200,1,'0','norte','0',2,1,20000,'Oasis'),(2,400,2,'0','norte','0',3,2,45000,'Paraiso'),(3,600,3,'0','norte','0',4,3,65000,'Cielo');
