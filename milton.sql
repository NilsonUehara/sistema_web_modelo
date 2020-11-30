-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- CREATE TABLE "usuario" --------------------------------------
CREATE TABLE `usuario`( 
	`id` Int( 11 ) AUTO_INCREMENT NOT NULL,
	`login` VarChar( 100 ) NOT NULL,
	`senha` VarChar( 50 ) NOT NULL,
	`nome` VarChar( 100 ) NOT NULL,
	PRIMARY KEY ( `id` ) )
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "cliente" --------------------------------------
CREATE TABLE `cliente`( 
	`id` Int( 11 ) AUTO_INCREMENT NOT NULL,
	`nome` VarChar( 100 ) NOT NULL,
	`endereco` VarChar( 200 ) NOT NULL,
	PRIMARY KEY ( `id` ) )
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "pedido" ---------------------------------------
CREATE TABLE `pedido`( 
	`id` Int( 11 ) AUTO_INCREMENT NOT NULL,
	`idcliente` Int( 11 ) NOT NULL,
	`data` Date NOT NULL,
	PRIMARY KEY ( `id` ) )
ENGINE = InnoDB;
-- -------------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


