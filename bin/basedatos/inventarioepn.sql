-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema inventarioepn
--

CREATE DATABASE IF NOT EXISTS inventarioepn;
USE inventarioepn;

--
-- Definition of table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id_categoria` int(30) NOT NULL auto_increment,
  `cat_nombre` varchar(60) default NULL,
  PRIMARY KEY  (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id_categoria`,`cat_nombre`) VALUES 
 (1,'aaa'),
 (2,'bbb'),
 (3,'ccc'),
 (4,'vvv'),
 (5,'bbb'),
 (6,'nnnn');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


--
-- Definition of table `cierre_caja`
--

DROP TABLE IF EXISTS `cierre_caja`;
CREATE TABLE `cierre_caja` (
  `id_cierre` int(30) NOT NULL auto_increment,
  `id_usuario` int(11) default NULL,
  `cie_descripcion` varchar(150) default NULL,
  `cie_fecha` date default NULL,
  `cie_valor` decimal(10,4) default NULL,
  `cie_estado` varchar(20) default NULL,
  `cie_cuadre` decimal(10,4) default NULL,
  PRIMARY KEY  (`id_cierre`),
  KEY `fk_relationship_9` (`id_usuario`),
  CONSTRAINT `fk_relationship_9` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cierre_caja`
--

/*!40000 ALTER TABLE `cierre_caja` DISABLE KEYS */;
/*!40000 ALTER TABLE `cierre_caja` ENABLE KEYS */;


--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_cliente` int(30) NOT NULL auto_increment,
  `cli_cedula` varchar(100) default NULL,
  `cli_nombre` varchar(100) default NULL,
  `cli_razon_social` varchar(150) default NULL,
  `cli_direccion` varchar(150) default NULL,
  `cli_telefono` varchar(20) default NULL,
  `cli_movil` varchar(20) default NULL,
  `cli_correo` varchar(100) default NULL,
  PRIMARY KEY  (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id_cliente`,`cli_cedula`,`cli_nombre`,`cli_razon_social`,`cli_direccion`,`cli_telefono`,`cli_movil`,`cli_correo`) VALUES 
 (1,'Marco','uuuu','uuufdghjk','uuu','09987654','09876543',',mnmbnvbcvxc'),
 (2,'Luis','Luis','Luis','Luispoiuytryuio','0987654','4567890','jhgfdsdfghjk'),
 (3,'1718276433','234567','234567','ddddddd','234567','234567','ddddddd');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
CREATE TABLE `detalle_factura` (
  `id_detalle` int(30) NOT NULL auto_increment,
  `id_factura` int(11) default NULL,
  `id_producto` int(11) default NULL,
  `det_cantidad` decimal(8,2) default NULL,
  `det_descripcion` varchar(100) default NULL,
  `det_subtotal` decimal(10,4) default NULL,
  `det_total` decimal(10,4) default NULL,
  PRIMARY KEY  (`id_detalle`),
  KEY `fk_factura_detalle` (`id_factura`),
  KEY `fk_relationship_6` (`id_producto`),
  CONSTRAINT `fk_factura_detalle` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  CONSTRAINT `fk_relationship_6` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detalle_factura`
--

/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
INSERT INTO `detalle_factura` (`id_detalle`,`id_factura`,`id_producto`,`det_cantidad`,`det_descripcion`,`det_subtotal`,`det_total`) VALUES 
 (1,1,1,'1.00','oiuytre','6.0000','7.0000'),
 (2,1,1,'3.00','ñlkjhgf','6.0000','7.0000'),
 (3,1,1,'7.00','8lkjhgfd','6.0000','5.0000');
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;


--
-- Definition of table `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `id_factura` int(30) NOT NULL auto_increment,
  `id_cliente` int(11) default NULL,
  `id_usuario` int(11) default NULL,
  `fac_numero` int(11) default NULL,
  `fac_fecha` date default NULL,
  `fac_subtotal` decimal(10,4) default NULL,
  `fac_iva` decimal(10,4) default NULL,
  `fac_total` decimal(10,4) default NULL,
  `fac_estado` varchar(20) default NULL,
  `fac_tipo` varchar(20) default NULL,
  PRIMARY KEY  (`id_factura`),
  KEY `fk_relationship_5` (`id_cliente`),
  KEY `fk_relationship_8` (`id_usuario`),
  CONSTRAINT `fk_relationship_5` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_relationship_8` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `factura`
--

/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` (`id_factura`,`id_cliente`,`id_usuario`,`fac_numero`,`fac_fecha`,`fac_subtotal`,`fac_iva`,`fac_total`,`fac_estado`,`fac_tipo`) VALUES 
 (1,1,1,98765,'2016-06-06','8.0000','8.0000','8.0000','1','N');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;


--
-- Definition of table `ingreso_producto`
--

DROP TABLE IF EXISTS `ingreso_producto`;
CREATE TABLE `ingreso_producto` (
  `id_ingreso_prod` int(30) NOT NULL auto_increment,
  `id_proveedor` int(11) default NULL,
  `id_producto` int(11) default NULL,
  `id_usuario` int(11) default NULL,
  `iprod_cantidad` decimal(15,4) default NULL,
  `iprdod_fecha` date default NULL,
  `iprod_num_factura` varchar(100) default NULL,
  `iprdo_responsable` varchar(100) default NULL,
  PRIMARY KEY  (`id_ingreso_prod`),
  KEY `fk_product_ingreso` (`id_proveedor`,`id_producto`),
  KEY `fk_relationship_10` (`id_usuario`),
  CONSTRAINT `fk_product_ingreso` FOREIGN KEY (`id_proveedor`, `id_producto`) REFERENCES `producto_proveedor` (`id_proveedor`, `id_producto`),
  CONSTRAINT `fk_relationship_10` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ingreso_producto`
--

/*!40000 ALTER TABLE `ingreso_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingreso_producto` ENABLE KEYS */;


--
-- Definition of table `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `id_producto` int(30) NOT NULL auto_increment,
  `id_categoria` int(11) default NULL,
  `prod_codigo` varchar(100) default NULL,
  `prod_nombre` varchar(100) default NULL,
  `pord_costo_venta_ref` decimal(10,4) default NULL,
  `pord_costo_venta_final` decimal(10,4) default NULL,
  `prod_estado` int(11) default NULL,
  PRIMARY KEY  (`id_producto`),
  KEY `fk_relationship_1` (`id_categoria`),
  CONSTRAINT `fk_relationship_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producto`
--

/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id_producto`,`id_categoria`,`prod_codigo`,`prod_nombre`,`pord_costo_venta_ref`,`pord_costo_venta_final`,`prod_estado`) VALUES 
 (1,1,'765','kjhgfd','7.0000','8.0000',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;


--
-- Definition of table `producto_proveedor`
--

DROP TABLE IF EXISTS `producto_proveedor`;
CREATE TABLE `producto_proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `prod_prov_costo` decimal(10,4) default NULL,
  `prod_prov_fecha_reg` date default NULL,
  PRIMARY KEY  (`id_proveedor`,`id_producto`),
  KEY `fk_relationship_3` (`id_producto`),
  CONSTRAINT `fk_relationship_3` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `fk_relationship_4` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producto_proveedor`
--

/*!40000 ALTER TABLE `producto_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_proveedor` ENABLE KEYS */;


--
-- Definition of table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `id_proveedor` int(30) NOT NULL auto_increment,
  `prov_cedula` varchar(100) default NULL,
  `prov_nombre` varchar(100) default NULL,
  `prov_direccion` varchar(150) default NULL,
  `prov_telefono` varchar(20) default NULL,
  `prov_movil` varchar(20) default NULL,
  `prov_correo` varchar(100) default NULL,
  `prov_pagina` varchar(100) default NULL,
  `prov_banco` varchar(100) default NULL,
  `prov_tipo_cuenta` varchar(100) default NULL,
  `prov_numero_cuenta` varchar(50) default NULL,
  PRIMARY KEY  (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proveedor`
--

/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` int(30) NOT NULL auto_increment,
  `usu_nombre` varchar(100) default NULL,
  `usu_login` varchar(100) default NULL,
  `usu_password` varchar(100) default NULL,
  `usu_correo` varchar(100) default NULL,
  `usu_nivel` int(11) default NULL,
  `usu_foto` longblob,
  PRIMARY KEY  (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`,`usu_nombre`,`usu_login`,`usu_password`,`usu_correo`,`usu_nivel`,`usu_foto`) VALUES 
 (1,'Darwin','yy','yy','yy',1,0x7979);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
