-- MySQL Script generated by MySQL Workbench
-- Sun Jun 10 21:38:11 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BD_PROYECTO
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BD_PROYECTO
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BD_PROYECTO` DEFAULT CHARACTER SET utf8 ;
USE `BD_PROYECTO` ;

-- -----------------------------------------------------
-- Table `BD_PROYECTO`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_PROYECTO`.`cargo` (
  `idCargo` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `BD_PROYECTO`.`entidad_estatal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_PROYECTO`.`entidad_estatal` (
  `idEntidad` INT NOT NULL AUTO_INCREMENT,
  `poder_est` VARCHAR(45) NULL,
  `sector` VARCHAR(45) NULL,
  `ruc` VARCHAR(11) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(100) NULL,
  PRIMARY KEY (`idEntidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `BD_PROYECTO`.`expediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_PROYECTO`.`expediente` (
  `NroExpediente` INT NOT NULL AUTO_INCREMENT,
  `idTrabajador` INT NOT NULL,
  `idEntidad` INT NOT NULL,
  `Estado` VARCHAR(45) NULL,
  `fchApertura` DATE NULL,
  PRIMARY KEY (`NroExpediente`),
  CONSTRAINT `fk_expediente_trabajador`
    FOREIGN KEY (`idTrabajador`)
    REFERENCES `BD_PROYECTO`.`trabajador_estatal` (`idTrabajador`),
  CONSTRAINT `fk_expediente_entidad`
    FOREIGN KEY (`idEntidad`)
    REFERENCES `BD_PROYECTO`.`entidad_estatal` (`idEntidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `BD_PROYECTO`.`documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_PROYECTO`.`documento` (
  `idDoc` INT NOT NULL AUTO_INCREMENT,
  `NroExpediente` INT NOT NULL,
  `descripcion` varchar(255) not null,
  `link` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idDoc`),
  CONSTRAINT `fk_documento_expediente1`
    FOREIGN KEY (`NroExpediente`)
    REFERENCES `BD_PROYECTO`.`expediente` (`NroExpediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `BD_PROYECTO`.`empleado_servir`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_PROYECTO`.`empleado_servir` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `apePat` VARCHAR(100) NOT NULL,
  `apeMat` VARCHAR(100) NOT NULL,
  `Dni` CHAR(8) NOT NULL,
  `Sueldo` DOUBLE NULL DEFAULT NULL,
  `cargo_idCargo` INT(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`, `cargo_idCargo`),
  CONSTRAINT `fk_empleado_cargo1`
    FOREIGN KEY (`cargo_idCargo`)
    REFERENCES `BD_PROYECTO`.`cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `BD_PROYECTO`.`trabajador_estatal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_PROYECTO`.`trabajador_estatal` (
  `idTrabajador` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(100) NOT NULL,
  `apePat` VARCHAR(100) NOT NULL,
  `apeMat` VARCHAR(100) NOT NULL,
  `DNI` CHAR(8) NOT NULL,
  `entidad_estatal_idEntidad` INT(10) NOT NULL,
  PRIMARY KEY (`idTrabajador`, `entidad_estatal_idEntidad`),
  CONSTRAINT `fk_trabajador_estatal_entidad_estatal1`
    FOREIGN KEY (`entidad_estatal_idEntidad`)
    REFERENCES `BD_PROYECTO`.`entidad_estatal` (`idEntidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `BD_PROYECTO`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_PROYECTO`.`usuario` (
  `usuario` VARCHAR(20) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `empleado_idEmpleado` INT NOT NULL,
  PRIMARY KEY (`empleado_idEmpleado`),
  CONSTRAINT `fk_usuario_empleado1`
    FOREIGN KEY (`empleado_idEmpleado`)
    REFERENCES `BD_PROYECTO`.`empleado_servir` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



CREATE TABLE IF NOT EXISTS `bd_proyecto`.`ampliaciones` (
  `idampliaciones` INT NOT NULL AUTO_INCREMENT,
  `idEmpleado` INT NULL,
  `fchVenc` DATE NULL,
  `estado` VARCHAR(45) NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idampliaciones`),
  CONSTRAINT `fk_ampliacines_empleado1`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `BD_PROYECTO`.`empleado_servir` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

create table if not exists `bd_proyecto`.`detalleAmplVSDoc` (
  `idampliaciones` INT NOT NULL,
  `idDoc` INT NOT NULL,
  CONSTRAINT `fk_ampliacines_doc`
    FOREIGN KEY (`idampliaciones`)
    REFERENCES `BD_PROYECTO`.`ampliaciones` (`idampliaciones`),
  CONSTRAINT `fk_doc_ampl`
	FOREIGN KEY (`idDoc`)
	REFERENCES `BD_PROYECTO`.`documento` (`idDoc`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `bd_proyecto`.`cargo` (`Nombre`) VALUES ('Administrador');
INSERT INTO `bd_proyecto`.`cargo` (`Nombre`) VALUES ('Trabajador');

INSERT INTO `bd_proyecto`.`empleado_servir` (`Nombre`, `apePat`, `apeMat`, `Dni`, `Sueldo`, `cargo_idCargo`) VALUES ('Panchito', 'Sanchez', 'Sanchez', '99999999', '1500', '1');
INSERT INTO `bd_proyecto`.`empleado_servir` (`Nombre`, `apePat`, `apeMat`, `Dni`, `Sueldo`, `cargo_idCargo`) VALUES ('Nachito', 'Velazquez', 'Velazques', '99999998', '1700', '2');

INSERT INTO `bd_proyecto`.`entidad_estatal` (`poder_est`, `sector`, `ruc`, `nombre`, `direccion`) VALUES ('ASD', '194', '123456', 'Sunat', 'ZXC');
INSERT INTO `bd_proyecto`.`entidad_estatal` (`poder_est`, `sector`, `ruc`, `nombre`, `direccion`) VALUES ('QWE', '179', '456798', 'Onpe', 'IOP');

INSERT INTO `bd_proyecto`.`trabajador_estatal` (`Nombre`, `apePat`, `apeMat`, `DNI`, `entidad_estatal_idEntidad`) VALUES ('Juanchito', 'Quispe', 'Quispe', '99999997', '1');
INSERT INTO `bd_proyecto`.`trabajador_estatal` (`Nombre`, `apePat`, `apeMat`, `DNI`, `entidad_estatal_idEntidad`) VALUES ('Brandon', 'Reategui', 'Reategui', '99999996', '2');
INSERT INTO `bd_proyecto`.`trabajador_estatal` (`Nombre`, `apePat`, `apeMat`, `DNI`, `entidad_estatal_idEntidad`) VALUES ('Emerita', 'Sanchez', 'Sanchez', '99999995', '1');
INSERT INTO `bd_proyecto`.`trabajador_estatal` (`Nombre`, `apePat`, `apeMat`, `DNI`, `entidad_estatal_idEntidad`) VALUES ('Alexnder', 'Galvez', 'Galvez', '9999994', '2');

INSERT INTO `bd_proyecto`.`expediente` (`idTrabajador`, `idEntidad`, `Estado`, `fchApertura`) VALUES ('1', '1', 'Pendiente', '2018-05-05');
INSERT INTO `bd_proyecto`.`expediente` (`idTrabajador`, `idEntidad`, `Estado`, `fchApertura`) VALUES ('2', '2', 'En Espera', '2018-04-04');
INSERT INTO `bd_proyecto`.`expediente` (`idTrabajador`, `idEntidad`, `Estado`, `fchApertura`) VALUES ('3', '1', 'Pendiente', '2018-06-06');
INSERT INTO `bd_proyecto`.`expediente` (`idTrabajador`, `idEntidad`, `Estado`, `fchApertura`) VALUES ('4', '1', 'En Espera', '2018-07-07');

INSERT INTO `bd_proyecto`.`documento` (`NroExpediente`, `descripcion`, `link`) VALUES ('1', 'DNI', 'Test');
INSERT INTO `bd_proyecto`.`documento` (`NroExpediente`, `descripcion`, `link`) VALUES ('1', 'Razon', 'Test');
INSERT INTO `bd_proyecto`.`documento` (`NroExpediente`, `descripcion`, `link`) VALUES ('2', 'DNI', 'Test');
INSERT INTO `bd_proyecto`.`documento` (`NroExpediente`, `descripcion`, `link`) VALUES ('2', 'DNI Afectado', 'Test');

INSERT INTO `bd_proyecto`.`ampliaciones` (`idEmpleado`, `fchVenc`, `estado`, `tipo`) VALUES ('1', '2018-10-10', 'Pendiente', 'A');
INSERT INTO `bd_proyecto`.`ampliaciones` (`idEmpleado`, `fchVenc`, `estado`, `tipo`) VALUES ('2', '2018-09-09', 'Pendiente', 'B');
INSERT INTO `bd_proyecto`.`ampliaciones` (`idEmpleado`, `fchVenc`, `estado`, `tipo`) VALUES ('1', '2018-06-10', 'Pendiente', 'A');
INSERT INTO `bd_proyecto`.`ampliaciones` (`idEmpleado`, `fchVenc`, `estado`, `tipo`) VALUES ('1', '2018-04-04', 'Vencido', 'A');

INSERT INTO `bd_proyecto`.`detalleamplvsdoc` (`idampliaciones`, `idDoc`) VALUES ('1', '1');
INSERT INTO `bd_proyecto`.`detalleamplvsdoc` (`idampliaciones`, `idDoc`) VALUES ('1', '2');
INSERT INTO `bd_proyecto`.`detalleamplvsdoc` (`idampliaciones`, `idDoc`) VALUES ('2', '3');
INSERT INTO `bd_proyecto`.`detalleamplvsdoc` (`idampliaciones`, `idDoc`) VALUES ('2', '4');

