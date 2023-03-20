/*
 Navicat Premium Data Transfer

 Source Server         : testmmysql
 Source Server Type    : MySQL
 Source Server Version : 100605
 Source Host           : localhost:3306
 Source Schema         : warehousemanagementsystem

 Target Server Type    : MySQL
 Target Server Version : 100605
 File Encoding         : 65001

 Date: 20/03/2023 09:20:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checktable
-- ----------------------------
DROP TABLE IF EXISTS `checktable`;
CREATE TABLE `checktable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `checkNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '盘点者员工号',
  `checkDate` datetime(0) NOT NULL COMMENT '盘点日期',
  `warehouseNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库号',
  `itemNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物号',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位',
  `warehouseManagerNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库负责人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checktable
-- ----------------------------

-- ----------------------------
-- Table structure for employeeinfosheet
-- ----------------------------
DROP TABLE IF EXISTS `employeeinfosheet`;
CREATE TABLE `employeeinfosheet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employeeNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职工号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职位，仓管员、经理',
  `inOffice` tinyint(4) NOT NULL COMMENT '是否在职，默认在职',
  `sex` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `salary` double(10, 2) NULL DEFAULT NULL COMMENT '薪资',
  `dateOfEntry` date NOT NULL COMMENT '入职日期，yyyy-MM-dd，无法默认设置当前日期',
  `dateOfDeparture` date NULL DEFAULT NULL COMMENT '离职日期，yyyy-MM-dd，无法默认设置当前日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employeeinfosheet
-- ----------------------------
INSERT INTO `employeeinfosheet` VALUES (1, 'efwe', 'admin', 'rgver', 'rhrtghyut', 0, 1, 15, '19511310121', 2504.10, '2022-03-04', '2023-02-23');
INSERT INTO `employeeinfosheet` VALUES (2, 'efwe', 'admin', 'rgver', 'rhrtghyut', 0, 1, 15, '19511310121', 2504.10, '2022-03-04', NULL);
INSERT INTO `employeeinfosheet` VALUES (3, 'efwe', 'admin', 'rgver', 'rhrtghyut', 0, 1, 15, '19511310121', 2504.10, '2022-03-04', NULL);
INSERT INTO `employeeinfosheet` VALUES (4, 'efwe', 'admin', 'rgver', 'rhrtghyut', 0, 1, 15, '19511310121', 2504.10, '2022-03-04', NULL);
INSERT INTO `employeeinfosheet` VALUES (5, 'efwe', 'admin', 'rgver', 'rhrtghyut', 0, 1, 15, '19511310121', 2504.10, '2022-03-04', NULL);
INSERT INTO `employeeinfosheet` VALUES (6, 'admin', 'admin', 'admin', 'admin', 0, NULL, NULL, NULL, NULL, '2023-02-20', NULL);

-- ----------------------------
-- Table structure for inboundtable
-- ----------------------------
DROP TABLE IF EXISTS `inboundtable`;
CREATE TABLE `inboundtable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库表的记录号，用于标识记录，具有唯一性',
  `checkId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '票据单号，多条记录的票据单号可以一致，因为会有一次性入库多种材料的情况',
  `businessType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务类型，外部入库、退出',
  `warehouseNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库号，字符类型，仓库名一般不会',
  `itemNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货号',
  `transactionNumber` int(11) NOT NULL DEFAULT 0 COMMENT '交易数量',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位',
  `averagePrice` double(10, 2) NOT NULL COMMENT '加权平均价',
  `totalInventoryPrice` double(10, 2) NOT NULL COMMENT '总价',
  `vendorNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '供应商',
  `vendorName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '供应商负责人',
  `transactionDate` timestamp(0) NOT NULL DEFAULT current_timestamp(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '交易日期',
  `done` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否已完成入库：需要仓库经理确认，默认未完成（0）',
  `warehouseKeeperNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库管理人员职工号（看守仓库的）',
  `warehouseManagerNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库经理职工号（管理仓管人员的）',
  `checkDate` timestamp(0) NULL DEFAULT NULL COMMENT '管理员确认日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inboundtable
-- ----------------------------
INSERT INTO `inboundtable` VALUES (1, 'buivbeur', 'kid', 'Bsnfho', 'thtyj', 0, '只', 25.60, 256.00, 'eirf', '', '2023-03-15 14:42:27', 0, 'rhrethh', 'rheryh', NULL);
INSERT INTO `inboundtable` VALUES (2, 'rthrt', 'kif', 'rtjty', 'kfn ', 0, 'rthrt', 15.80, 31.60, 'rter', '', '2023-03-15 14:42:30', 0, 'yku', 'kluil', NULL);
INSERT INTO `inboundtable` VALUES (3, 'rge', 'kif', 'rhtr', 'verver', 22, '只', 15.20, 16.50, 'ujyuj', '', '2023-03-15 14:42:33', 0, 'svdfv', 'u66u', NULL);

-- ----------------------------
-- Table structure for materialspecificationsheet
-- ----------------------------
DROP TABLE IF EXISTS `materialspecificationsheet`;
CREATE TABLE `materialspecificationsheet`  (
  `nameOfCargo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格型号',
  `itemNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '货号',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `numberOfInventory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '库存数',
  `averagePrice` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平均价',
  `totalInventoryPrice` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '库存总价'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of materialspecificationsheet
-- ----------------------------
INSERT INTO `materialspecificationsheet` VALUES ('材料                            ', '                              ', 'B                 ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电器材料                        ', '                              ', 'B01               ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('自动开关                        ', '                              ', 'B0101             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高分断断路器(一)                ', '                              ', 'B010101', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高分断断路器                    ', 'DZ47-6A/1P                    ', 'B01010101         ', '只    ', '0', '7.52', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高分断断路器                    ', 'DZ47-10A/1P                   ', 'B01010102         ', '只    ', '10', '5.46', '54.59');
INSERT INTO `materialspecificationsheet` VALUES ('高分断断路器                    ', 'DZ47-16A/1P                   ', 'B01010103         ', '只    ', '0', '7.52', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高分断断路器                    ', 'DZ47-20A/1P                   ', 'B01010104         ', '只    ', '0', '6.49', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高分断断路器                    ', 'DZ47-25A/1P                   ', 'B01010105         ', '只    ', '0', '6.15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器(一)                  ', '                              ', 'B010102', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'CM1-100/330(100A)             ', 'B01010201         ', '只    ', '0', '439.57', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'DZ5-20/330                    ', 'B01010202         ', '只    ', '0', '118.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'TM30-100/3300                 ', 'B01010203         ', '只    ', '0', '315', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'TM30-200/3300(200A)           ', 'B01010204         ', '只    ', '0', '630', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'TD-100/3300                   ', 'B01010205         ', '只    ', '0', '315', '0');
INSERT INTO `materialspecificationsheet` VALUES ('框架式断路器                    ', '                              ', 'B010103', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽屉式断路器                    ', 'HSW1-2000/3（800A）           ', 'B01010301         ', '只    ', '0', '11194.87', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽屉式断路器                    ', 'HSW1-3200/3（2500A）          ', 'B01010302         ', '只    ', '0', '20374.36', '0');
INSERT INTO `materialspecificationsheet` VALUES ('智能断路器                      ', 'ZW1-2000/3（1600A）           ', 'B01010303         ', '只    ', '0', '10000', '0');
INSERT INTO `materialspecificationsheet` VALUES ('框架式断路器                    ', 'DW15-400/3                    ', 'B01010304         ', '只    ', '0', '1413.7', '0');
INSERT INTO `materialspecificationsheet` VALUES ('框架式断路器                    ', 'DW15-630/3                    ', 'B01010305         ', '只    ', '2', '1188.04', '2376.07');
INSERT INTO `materialspecificationsheet` VALUES ('漏电断路器                      ', '                              ', 'B010104', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电开关                        ', 'DZ47L-16A/2P                  ', 'B01010401         ', '只    ', '0', '23.93', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电断路器                      ', 'DZ10L-150/430                 ', 'B01010402         ', '只    ', '0', '470', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电断路器                      ', 'DZ10L-250/430(200A)           ', 'B01010403         ', '只    ', '0', '239.32', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电断路器                      ', 'DZ10L-250/430(250A)           ', 'B01010404         ', '只    ', '0', '244.45', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电断路器                      ', 'DZ10L-400/430(400A)           ', 'B01010405         ', '只    ', '0', '0.02', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器(二)                  ', '                              ', 'B010105', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'SM30S-225/330(200A)           ', 'B01010500         ', '只    ', '0', '623.93', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'SM30S-400/330(400A)           ', 'B01010501         ', '只    ', '0', '2923.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('空气开关                        ', 'SM30S-630/3340(630A)          ', 'B01010502         ', '只    ', '0', '1510.26', '0');
INSERT INTO `materialspecificationsheet` VALUES ('空气开关                        ', 'F7-25/2                       ', 'B01010503         ', '只    ', '0', '194.87', '0');
INSERT INTO `materialspecificationsheet` VALUES ('空气开关                        ', 'L7-63/4                       ', 'B01010504         ', '只    ', '0', '186.32', '0');
INSERT INTO `materialspecificationsheet` VALUES ('空气开关                        ', 'DZ20G-100/3300(40A)           ', 'B01010505         ', '只    ', '0', '239.32', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器(三）                 ', '                              ', 'B010106', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'HSM8Ⅱ-63/3 15A               ', 'B01010601         ', '只    ', '0', '59.83', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'HSM1-250M/3300 200A           ', 'B01010602         ', '只    ', '0', '683.76', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'HSM1-250M/3300 250A           ', 'B01010603         ', '只    ', '0', '683.76', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'HSM1-250M/3300 160A           ', 'B01010604         ', '只    ', '0', '683.76', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'HSM1-400M/3300 315A           ', 'B01010605         ', '只    ', '0', '854.7', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电断路器（二）                ', '                              ', 'B010107', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电开关                        ', 'C65N-32A/4P+VIGIC65-32A/4PELM ', 'B01010701         ', '只    ', '0', '367.52', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电开关                        ', 'ZB30L-63/4(63A)               ', 'B01010702         ', '只    ', '0', '126.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电开关                        ', 'C65N/3P+VIGIC65N3P63AELM      ', 'B01010703         ', '只    ', '0', '495.73', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电开关                        ', 'SM30L-100/4300                ', 'B01010704         ', '只    ', '0', '752.14', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电开关                        ', 'SM30L-225/4300  200A          ', 'B01010705         ', '只    ', '0', '1179.49', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高分断断路器（二）              ', '                              ', 'B010108', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'Hum18-63/4D 40A               ', 'B01010801         ', '只    ', '0', '126.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'Hum18-63/3D 32A               ', 'B01010802         ', '只    ', '0', '96.58', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'Hum18-63/1C 16A               ', 'B01010803         ', '只    ', '0', '23.93', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'Hum18-250S/4B 100A            ', 'B01010804         ', '只    ', '0', '820.51', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'ZM30E-100/3300 100A           ', 'B01010805         ', '台    ', '0', '89.74', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'Hum18-63/4C 20A               ', 'B01010806         ', '只    ', '0', '103.42', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器TI(四)                ', '                              ', 'B010109', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'TIM1-H-250/3300(250A)         ', 'B01010901         ', '只    ', '0', '705.13', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'TIM1-H-250/3300(200A)         ', 'B01010902         ', '只    ', '0', '705.13', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'TIM1-S-160/3300(160A)         ', 'B01010903         ', '只    ', '0', '405.77', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'TIM1-S-125/3300(100A)         ', 'B01010904         ', '只    ', '0', '334.74', '0');
INSERT INTO `materialspecificationsheet` VALUES ('智能断路器                      ', 'TIW1-2000/1000/3              ', 'B01010905         ', '只    ', '0', '9735.04', '0');
INSERT INTO `materialspecificationsheet` VALUES ('智能断路器                      ', 'TIW1-2000/1000/3 (5S)         ', 'B01010906         ', '只    ', '0', '10247.86', '0');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关及转换开关                ', '                              ', 'B0102             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('单投刀开关                      ', '                              ', 'B010201', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关                          ', 'HD11B-200/38                  ', 'B01020101         ', '把    ', '6', '118.1', '708.58');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关                          ', 'HD11B-400/38                  ', 'B01020102         ', '把    ', '9', '209.87', '1888.87');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关                          ', 'HD11B-600/38                  ', 'B01020103         ', '把    ', '9', '359.58', '3236.18');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关                          ', 'HD12B-400/31                  ', 'B01020104         ', '把    ', '0', '176', '0');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关                          ', 'HD12B-600/31                  ', 'B01020105         ', '把    ', '0', '540.86', '0');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关                          ', 'HD13B-200/31                  ', 'B01020106         ', '把    ', '26', '125.04', '3251.16');
INSERT INTO `materialspecificationsheet` VALUES ('刀开关                          ', 'HD13B-400/31                  ', 'B01020107         ', '把    ', '8', '219.07', '1752.58');
INSERT INTO `materialspecificationsheet` VALUES ('双投刀开关                      ', '                              ', 'B010202', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('双投刀开关                      ', 'HS11B-200/38                  ', 'B01020201         ', '只    ', '0', '122.41', '0');
INSERT INTO `materialspecificationsheet` VALUES ('双投刀开关                      ', 'HS11B-400/48                  ', 'B01020202         ', '只    ', '0', '275.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('双投刀开关                      ', 'HS12B-200/41                  ', 'B01020203         ', '把    ', '0', '451.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('双投刀开关                      ', 'HS13B-200/31                  ', 'B01020204         ', '把    ', '0', '139.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('双投刀开关                      ', 'HS13B-400/31                  ', 'B01020205         ', '把    ', '0', '883.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('双投刀开关                      ', 'HS13B-600/31                  ', 'B01020206         ', '把    ', '0', '429.35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', '                              ', 'B010203', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', 'HR3-200/32                    ', 'B01020301         ', '把    ', '0', '242', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', 'HR3-400/32                    ', 'B01020302         ', '把    ', '0', '219.11', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', 'HR3-600/32                    ', 'B01020303         ', '把    ', '0', '455.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', 'HR3-200/31                    ', 'B01020304         ', '把    ', '0', '244.34', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', 'HR3-200/34                    ', 'B01020305         ', '把    ', '0', '240.37', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', 'HR3-400/34                    ', 'B01020306         ', '把    ', '0', '298.19', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断式刀开关                    ', 'HR3-600/34                    ', 'B01020307         ', '把    ', '0', '423.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('负荷开关                        ', '                              ', 'B010204', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('封闭式负荷开关                  ', 'HH3-100/32                    ', 'B01020401         ', '把    ', '0', '51.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('封闭式负荷开关                  ', 'HH3-200/32                    ', 'B01020402         ', '把    ', '0', '242', '0');
INSERT INTO `materialspecificationsheet` VALUES ('封闭式负荷开关                  ', 'HH3-400/32                    ', 'B01020403         ', '把    ', '0', '219.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('开启式负荷开关                  ', 'HK2-100/3                     ', 'B01020404         ', '把    ', '0', '45.93', '0');
INSERT INTO `materialspecificationsheet` VALUES ('开启式负荷开关                  ', 'HK2-60/3                      ', 'B01020405         ', '把    ', '0', '35.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('开启式负荷开关                  ', 'HK2-60/2                      ', 'B01020406         ', '把    ', '0', '9.32', '0');
INSERT INTO `materialspecificationsheet` VALUES ('转换开关                        ', '                              ', 'B010205', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('转换开关                        ', 'LW5-16YH/3                    ', 'B01020501         ', '只    ', '26', '23.93', '622.18');
INSERT INTO `materialspecificationsheet` VALUES ('转换开关                        ', 'LW5-16K6894/6#                ', 'B01020502         ', '只    ', '0', '81.61', '0');
INSERT INTO `materialspecificationsheet` VALUES ('转换开关                        ', 'LW5-16L6560/5                 ', 'B01020503         ', '只    ', '0', '80.34', '0');
INSERT INTO `materialspecificationsheet` VALUES ('转换开关                        ', 'LW5-16L7891/10                ', 'B01020504         ', '只    ', '0', '141.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('转换开关                        ', 'LW5-16D3462/12                ', 'B01020505         ', '只    ', '0', '88.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合开关                        ', '                              ', 'B010206', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合开关                        ', 'HZ10-25/3                     ', 'B01020601         ', '只    ', '0', '21.54', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合开关                        ', 'HZ10-60/3                     ', 'B01020602         ', '只    ', '0', '49.57', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电焊机开关                      ', 'KD12-125                      ', 'B01020603         ', '只    ', '0', '119.66', '0');
INSERT INTO `materialspecificationsheet` VALUES ('扭子开关                        ', '？                            ', 'B01020604         ', '只    ', '0', '2.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合开关                        ', 'HZ10-25P/3                    ', 'B01020605         ', '只    ', '0', '21.54', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合开关                        ', 'HZ10-60P/3                    ', 'B01020606         ', '只    ', '0', '49.57', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合开关                        ', 'HZ5-20/4                      ', 'B01020607         ', '只    ', '0', '65', '0');
INSERT INTO `materialspecificationsheet` VALUES ('其它闸刀                        ', '                              ', 'B010207', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('石板闸刀                        ', 'HRTO-400                      ', 'B01020701         ', '把    ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('石板闸刀                        ', 'HRTO-100A                     ', 'B01020702         ', '把    ', '0', '51.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('倒顺开关                        ', '15A                           ', 'B01020703         ', '只    ', '0', '14.53', '0');
INSERT INTO `materialspecificationsheet` VALUES ('倒顺开关                        ', '60A                           ', 'B01020704         ', '把    ', '0', '18.63', '0');
INSERT INTO `materialspecificationsheet` VALUES ('动态无触点开关                  ', '                              ', 'B010208', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('动态无触点开关                  ', '？                            ', 'B01020801', '只    ', '0', '3333.33', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器和继电器                  ', '                              ', 'B0103             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('普通接触器                      ', '                              ', 'B010301', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJ10-5A                       ', 'B01030101         ', '只    ', '0', '21.88', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJ10-10A/220V(380V)           ', 'B01030102         ', '只    ', '0', '54.53', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJ10-20A                      ', 'B01030103         ', '只    ', '0', '65.68', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJ10-40A                      ', 'B01030104         ', '只    ', '0', '29.74', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJ10-60A                      ', 'B01030105         ', '只    ', '0', '136.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJ10-100A/220V                ', 'B01030106         ', '只    ', '0', '137.35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('节能接触器                      ', '                              ', 'B010302', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('节能接触器                      ', 'CJC20-150A                    ', 'B01030201         ', '只    ', '0', '379', '0');
INSERT INTO `materialspecificationsheet` VALUES ('节能接触器                      ', 'CJC20-160A                    ', 'B01030202         ', '只    ', '0', '444.42', '0');
INSERT INTO `materialspecificationsheet` VALUES ('节能接触器                      ', 'CJC20-250A                    ', 'B01030203         ', '只    ', '0', '837.61', '0');
INSERT INTO `materialspecificationsheet` VALUES ('节能接触器                      ', 'CJC20-400A                    ', 'B01030204         ', '只    ', '0', '1132.93', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJX10-63A                     ', 'B01030205         ', '只    ', '0', '217.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器                          ', 'CJX2-163A                     ', 'B01030206         ', '只    ', '0', '35.9', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容器接触器                ', '                              ', 'B010303', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容器接触器                ', 'CJ19-32A/11(220V)             ', 'B01030301         ', '只    ', '0', '58.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容器接触器                ', 'CJ19-43A/11(220V)             ', 'B01030302         ', '只    ', '0', '58.41', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容器接触器                ', 'CJ23-40/220                   ', 'B01030303         ', '只    ', '0', '106.84', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容接触器                  ', 'CJ19-63/11(220V)              ', 'B01030304         ', '只    ', '0', '211.97', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容接触器                  ', 'CJ19C-63/21                   ', 'B01030305         ', '只    ', '0', '24.9', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容接触器                  ', 'CJ39-40-11/220V               ', 'B01030306         ', '只    ', '180', '64.1', '11538.76');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容接触器                  ', 'CJ39-63-21/220V               ', 'B01030307         ', '只    ', '3', '125.99', '377.98');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容接触器组合              ', 'HZG33A-40/11 220V             ', 'B01030308         ', '套    ', '0', '65.02', '0');
INSERT INTO `materialspecificationsheet` VALUES ('切换电容接触器组合              ', 'HZG33A-63/21 220V             ', 'B01030309         ', '套    ', '0', '217.35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热继电器                        ', '                              ', 'B010304', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热继电器                        ', 'JR16B-20/3                    ', 'B01030401         ', '只    ', '0', '19.74', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热继电器                        ', 'JR28-36A                      ', 'B01030402         ', '只    ', '0', '57.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热继电器                        ', 'JR10-10                       ', 'B01030403         ', '只    ', '0', '32', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热继电器                        ', 'JRS1-12316(5A)                ', 'B01030404         ', '只    ', '0', '18.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热继电器                        ', 'JR16B-63A                     ', 'B01030405         ', '只    ', '64', '22.22', '1422.08');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', '                              ', 'B010305', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'JST-1A                        ', 'B01030501         ', '只    ', '0', '44.23', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'JS7-14A-60秒(220V)            ', 'B01030502         ', '只    ', '0', '18.55', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间控制器                      ', 'UKD-I                         ', 'B01030503         ', '只    ', '0', '222.53', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'JS14A-Y/10s/220v              ', 'B01030504         ', '只    ', '0', '106.83', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'DS-123AC/220V                 ', 'B01030505         ', '只    ', '0', '316.24', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'DSJ-13/220V                   ', 'B01030506         ', '只    ', '0', '356.77', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'DS-122/0.25～3.5〃            ', 'B01030507         ', '只    ', '0', '292.31', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'DS-123/0.5～9〃               ', 'B01030508         ', '只    ', '0', '200', '0');
INSERT INTO `materialspecificationsheet` VALUES ('时间继电器                      ', 'DS-35/220V                    ', 'B01030509         ', '只    ', '0', '275', '0');
INSERT INTO `materialspecificationsheet` VALUES ('定时开关                        ', 'L1E1F/S                       ', 'B01030510         ', '只    ', '0', '126.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流继电器                      ', '                              ', 'B010306', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流继电器                      ', 'JL14-5A                       ', 'B01030601         ', '只    ', '0', '30.79', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流继电器                      ', 'JS14A-60秒 220V               ', 'B01030602         ', '只    ', '0', '30.79', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流继电器                      ', 'DL-11/10                      ', 'B01030603         ', '只    ', '0', '162.39', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中间继电器                      ', '                              ', 'B010307', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中间继电器                      ', 'JZ7-44/220V                   ', 'B01030701         ', '只    ', '2', '32.48', '64.96');
INSERT INTO `materialspecificationsheet` VALUES ('中间继电器                      ', 'JZC1-44/220V                  ', 'B01030702         ', '只    ', '0', '73.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中间继电器                      ', 'JZ1A-33/380V                  ', 'B01030703         ', '只    ', '0', '47.01', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中间继电器                      ', 'DZJ-207/AC220V                ', 'B01030704         ', '只    ', '0', '97', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中间继电器                      ', 'CZC4-31/220V                  ', 'B01030705         ', '只    ', '0', '73.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器式继电器                  ', 'JZC4-31                       ', 'B01030706         ', '只    ', '0', '73.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('继电器                          ', 'HH5-3P/110V                   ', 'B01030707         ', '只    ', '0', '12.82', '0');
INSERT INTO `materialspecificationsheet` VALUES ('继电器                          ', 'JQX-3Z/220V                   ', 'B01030708         ', '只    ', '0', '12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中间继电器                      ', 'JZ7-44/380V                   ', 'B01030709         ', '只    ', '0', '32.48', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号继电器                      ', '                              ', 'B010308', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号继电器                      ', 'DX-11/0.1A                    ', 'B01030801         ', '只    ', '0', '102.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('欠频率继电器                    ', 'SQP-6 110V                    ', 'B01030802         ', '只    ', '0', '3094.02', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号继电器                      ', 'DX-17/30                      ', 'B01030803         ', '只    ', '0', '275', '0');
INSERT INTO `materialspecificationsheet` VALUES ('低周率继电器                    ', 'SZH3/AC100V                   ', 'B01030804         ', '只    ', '0', '1470.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('晶体管液位继电器                ', 'TYR-714/380V                  ', 'B01030805         ', '只    ', '0', '51.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('液位继电器                      ', 'JYB-714/220V                  ', 'B01030806         ', '只    ', '0', '51.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电压继电器                      ', '                              ', 'B010309', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电压继电器                      ', 'JD-1B                         ', 'B01030901         ', '只    ', '0', '389.74', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电压继电器                      ', 'JD-2B                         ', 'B01030902         ', '只    ', '0', '393.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电压继电器                      ', 'DJ-111/400                    ', 'B01030903         ', '只    ', '0', '188.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断器                          ', '                              ', 'B0104             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', '                              ', 'B010401', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', 'RC1-5A                        ', 'B01040101         ', '只    ', '0', '1', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', 'RC1-10A                       ', 'B01040102         ', '只    ', '0', '1.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', 'RC1-15A                       ', 'B01040103         ', '只    ', '0', '1.88', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', 'RC1-30A                       ', 'B01040104         ', '只    ', '0', '3.45', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', 'RC1-60A                       ', 'B01040105         ', '只    ', '167', '5.99', '999.71');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', 'RC1-100A                      ', 'B01040106         ', '只    ', '94', '12.82', '1205.24');
INSERT INTO `materialspecificationsheet` VALUES ('插入式熔断器                    ', 'RC1-200A                      ', 'B01040107         ', '只    ', '3', '21.2', '63.6');
INSERT INTO `materialspecificationsheet` VALUES ('其它熔断器(熔芯)                ', '                              ', 'B010402', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断器(熔芯)                    ', 'JF2-(5-10)A                   ', 'B01040202         ', '只    ', '0', '1.58', '0');
INSERT INTO `materialspecificationsheet` VALUES ('管式熔断器(熔芯)                ', 'R1-5A(6×30)                  ', 'B01040204         ', '盒    ', '0', '21.37', '0');
INSERT INTO `materialspecificationsheet` VALUES ('管式熔芯                        ', 'R1-2A(5×20)                  ', 'B01040205         ', '盒    ', '0', '17.09', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断器（熔芯）                  ', 'JFS-2.5RD(20A)                ', 'B01040206         ', '只    ', '0', '1.71', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断器(熔芯)                    ', 'JFS-2.5RD(6A)                 ', 'B01040207         ', '只    ', '0', '2.44', '0');
INSERT INTO `materialspecificationsheet` VALUES ('其它熔断器(熔座)                ', '                              ', 'B010403', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('低压熔断器（熔座）              ', 'RT14-32A                      ', 'B01040302         ', '只    ', '0', '5.64', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断器端子                      ', '                              ', 'B010404', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔断器端子                      ', 'JFS-2.5RD/10A                 ', 'B01040401         ', '套    ', '1000', '7.01', '7007.09');
INSERT INTO `materialspecificationsheet` VALUES ('互感器                          ', '                              ', 'B0105             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流互感器                      ', 'LQG2-0.66-150/5               ', 'B010501           ', '只    ', '0', '65.81', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流互感器                      ', 'LM-0.5-300/5                  ', 'B010502           ', '只    ', '0', '34.19', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流互感器                      ', 'LMZ1-0.5-150/5                ', 'B010503           ', '只    ', '0', '33.33', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流互感器                      ', 'LMZ1-0.5-200/5                ', 'B010504           ', '只    ', '0', '30.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流互感器                      ', 'LMZ1-0.5-400/5                ', 'B010505           ', '只    ', '0', '47.68', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电流互感器                      ', 'LMZJ1-0.5-50/5                ', 'B010506           ', '只    ', '0', '31.11', '0');
INSERT INTO `materialspecificationsheet` VALUES ('仪器和仪表                      ', '                              ', 'B0106             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('其它类                          ', '                              ', 'B010601', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('单相调压器                      ', 'JDGCZJ-2                      ', 'B01060101         ', '只    ', '0', '182.05', '0');
INSERT INTO `materialspecificationsheet` VALUES ('全自动稳压器                    ', 'TND-1000                      ', 'B01060102         ', '只    ', '0', '182.05', '0');
INSERT INTO `materialspecificationsheet` VALUES ('数字万用表                      ', 'UJ2003                        ', 'B01060103         ', '只    ', '0', '452.99', '0');
INSERT INTO `materialspecificationsheet` VALUES ('秒表                            ', 'SJ9-2                         ', 'B01060104         ', '只    ', '0', '119.66', '0');
INSERT INTO `materialspecificationsheet` VALUES ('漏电保护器                      ', 'SDLB-6B                       ', 'B01060105         ', '只    ', '0', '188.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无功率补偿自动控制器            ', '                              ', 'B010604', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无功功率补偿自动控制器          ', 'JKG(B)-4                      ', 'B01060401         ', '只    ', '0', '633.63', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无功功率补偿自动控制器          ', 'JKG(B)-6                      ', 'B01060402         ', '只    ', '0', '698.96', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无功功率补偿自动控制器          ', 'JKG(B)-8                      ', 'B01060403         ', '只    ', '0', '750.98', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无功功率补偿自动控制器          ', 'JKG(B)-10                     ', 'B01060404         ', '只    ', '0', '785.89', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无功功率补偿自动控制器          ', 'JKGH-10                       ', 'B01060405         ', '只    ', '0', '427.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('功率因数调整器（台湾）          ', 'TS8D-T                        ', 'B01060406         ', '只    ', '0', '2034.19', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无功功率补偿自动控制器          ', 'JKGD-10/3                     ', 'B01060407         ', '只    ', '0', '346.32', '0');
INSERT INTO `materialspecificationsheet` VALUES ('交流功率表                      ', '                              ', 'B010609', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('交流功率表                      ', '42L6W-150/5                   ', 'B01060901         ', '只    ', '0', '96.76', '0');
INSERT INTO `materialspecificationsheet` VALUES ('交流功率表                      ', '42L6W-200/5                   ', 'B01060902         ', '只    ', '4', '83.76', '335.04');
INSERT INTO `materialspecificationsheet` VALUES ('交流功率表                      ', '42L6W-300/5                   ', 'B01060903         ', '只    ', '5', '83.59', '417.95');
INSERT INTO `materialspecificationsheet` VALUES ('交流功率表                      ', '42L6W-400/5                   ', 'B01060904         ', '只    ', '0', '82.73', '0');
INSERT INTO `materialspecificationsheet` VALUES ('交流功率表                      ', '42L6W-500/5                   ', 'B01060905         ', '只    ', '1', '82.48', '82.48');
INSERT INTO `materialspecificationsheet` VALUES ('交流功率表                      ', '42L6W-600/5                   ', 'B01060906         ', '只    ', '11', '89.13', '980.48');
INSERT INTO `materialspecificationsheet` VALUES ('导体                            ', '                              ', 'B0107             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', '                              ', 'B010701', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-1mm2                       ', 'B01070101         ', 'm     ', '0', '0.3', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-1.5mm2                     ', 'B01070102         ', 'm     ', '12100', '0.01', '11377.23');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-2.5mm2                     ', 'B01070103         ', 'm     ', '5000', '1.64', '7606.84');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-4mm2                       ', 'B01070104         ', '米    ', '9700', '1.27', '25310.78');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-6mm2                       ', 'B01070105         ', 'm     ', '0', '2.19', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-10mm2                      ', 'B01070106         ', 'm     ', '0', '5.96', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-16mm2                      ', 'B01070107         ', 'm     ', '600', '10.37', '6224');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-25mm2                      ', 'B01070108         ', 'm     ', '200', '15.31', '3062.37');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-35mm2                      ', 'B01070109         ', 'm     ', '300', '17.57', '5271');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-50mm2                      ', 'B01070110         ', 'm     ', '600', '15.04', '18042');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯线                          ', 'BV-70mm2                      ', 'B01070111         ', 'm     ', '0', '41.26', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯软线                        ', '                              ', 'B010702', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯软线                        ', 'BVR-1mm2                      ', 'B01070201         ', 'm     ', '0', '0.74', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯软线                        ', 'BVR-1.5mm2                    ', 'B01070202         ', 'm     ', '24800', '0.13', '25822.1');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯软线                        ', 'BVR-2.5mm2                    ', 'B01070203         ', 'm     ', '0', '1.61', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯软线                        ', 'BVR-4mm2                      ', 'B01070204         ', 'm     ', '0', '1.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯软线                        ', 'BVR-6mm2                      ', 'B01070205         ', 'm     ', '3800', '0.84', '15097.16');
INSERT INTO `materialspecificationsheet` VALUES ('铜芯软线                        ', 'BVR-16mm2                     ', 'B01070206         ', 'm     ', '600', '7.44', '4461');
INSERT INTO `materialspecificationsheet` VALUES ('橡套软线                        ', 'YZ-2×1mm2                    ', 'B01070207         ', 'm     ', '0', '0.85', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡套软线                        ', 'YZ-3*4mm2+1*2.5mm2            ', 'B01070208         ', 'm     ', '0', '7.37', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡套软线                        ', 'YZ-2×1.5                     ', 'B01070209         ', 'm     ', '0', '1.34', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡套软线                        ', 'YZ-3×1.5                     ', 'B01070210         ', 'm     ', '0', '5.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('多股胶线                        ', 'RVS-1mm2                      ', 'B01070211         ', 'm     ', '88', '0.6', '52.5');
INSERT INTO `materialspecificationsheet` VALUES ('铝排                            ', '                              ', 'B010703', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝排(0.2025kg/m)                ', 'LYM-3×25                     ', 'B01070301         ', 'm     ', '0', '1.6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝排(0.243kg/m)                 ', 'LYM-3×30                     ', 'B01070302         ', 'm     ', '84', '5.03', '422.52');
INSERT INTO `materialspecificationsheet` VALUES ('铝排(0.432kg/m)                 ', 'LYM-4×40                     ', 'B01070303         ', 'm     ', '0', '9.97', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝排(0.675kg/m)                 ', 'LYM-5×50                     ', 'B01070304         ', 'm     ', '48', '14.42', '692.16');
INSERT INTO `materialspecificationsheet` VALUES ('铝排(0.975kg/m)                 ', 'LYM-6×60                     ', 'B01070305         ', 'm     ', '0', '22.02', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝排(1.728kg/m)                 ', 'LYM-8×80                     ', 'B01070306         ', 'm     ', '0', '39.88', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝排(2.700kg/m)                 ', 'LYM-10×100                   ', 'B01070307         ', 'm     ', '16', '48.36', '773.76');
INSERT INTO `materialspecificationsheet` VALUES ('铜排                            ', '                              ', 'B010704', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(0.801kg/m)                 ', 'TYM-3×30                     ', 'B01070401         ', 'm     ', '0', '49.29', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(1.424kg/m)                 ', 'TYM-4×40                     ', 'B01070402         ', 'm     ', '32', '87.26', '2792.2');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(1.335kg/m)                 ', 'TYM-5×30                     ', 'B01070403         ', 'm     ', '21.5', '41.07', '883.01');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(2.136kg/m)                 ', 'TYM-6×40                     ', 'B01070404         ', 'm     ', '21.41', '131.47', '2814.74');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(2.225kg/m)                 ', 'TYM-5×50                     ', 'B01070405         ', 'm     ', '82', '136.43', '11187.63');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(4.45kg/m)                  ', 'TYM-10×50                    ', 'B01070406         ', 'm     ', '46', '150.62', '6928.52');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(3.204kg/m)                 ', 'TYM-6×60                     ', 'B01070407         ', 'm     ', '0', '202.65', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(8.90kg/m)                  ', 'TYM-10×100                   ', 'B01070408         ', 'm     ', '31.5', '509.66', '16054.29');
INSERT INTO `materialspecificationsheet` VALUES ('铜排(1.78kg/m)                  ', 'TYM-5×40                     ', 'B01070409         ', 'm     ', '0', '36.9', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜板                            ', '405×985×5                   ', 'B01070410         ', 'kg    ', '0', '21.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('紫铜管                          ', 'φ14                          ', 'B01070411         ', 'kg    ', '0', '42.31', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜接头                          ', '                              ', 'B010705', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜接头                          ', 'DT-16mm2                      ', 'B01070501         ', '只    ', '492', '1.97', '969.24');
INSERT INTO `materialspecificationsheet` VALUES ('铜接头                          ', 'DT-25mm2                      ', 'B01070502         ', '只    ', '88', '2.48', '218.24');
INSERT INTO `materialspecificationsheet` VALUES ('铜接头                          ', 'DT-35mm2                      ', 'B01070503         ', '只    ', '175', '3.12', '546');
INSERT INTO `materialspecificationsheet` VALUES ('铜接头                          ', 'DT-50mm2                      ', 'B01070504         ', '只    ', '70', '4.81', '336.7');
INSERT INTO `materialspecificationsheet` VALUES ('铜接头                          ', 'DT-70mm2                      ', 'B01070505         ', '只    ', '92', '7.44', '684.48');
INSERT INTO `materialspecificationsheet` VALUES ('铜接头                          ', 'DT-95mm2                      ', 'B01070506         ', '只    ', '6', '10.32', '61.92');
INSERT INTO `materialspecificationsheet` VALUES ('铝、铜接头                      ', '                              ', 'B010706', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝铜接头                        ', 'DLT-25mm2                     ', 'B01070601         ', '只    ', '0', '3.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝铜接头                        ', 'DLT-35mm2                     ', 'B01070602         ', '只    ', '0', '4.13', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝铜接头                        ', 'DLT-50mm2                     ', 'B01070603         ', '只    ', '0', '4.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜铝接头                        ', 'DTL-25 mm2                    ', 'B01070604         ', '只    ', '0', '1.25', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜铝接头                        ', 'DTL-50 mm2                    ', 'B01070605         ', '只    ', '0', '3.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜铝接头                        ', 'DTL-35mm2                     ', 'B01070606         ', '只    ', '0', '1.25', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜铝接头                        ', 'DLT-70mm2                     ', 'B01070607         ', '只    ', '0', '5.3', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜铝接头                        ', 'DLT-95mm2                     ', 'B01070608         ', '只    ', '0', '6.41', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜软连接                        ', ' 360*60*2                     ', 'B01070609         ', '条    ', '0', '74.59', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', '                              ', 'B010707', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-20A                        ', 'B01070701         ', '只    ', '0', '0.1', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-40A                        ', 'B01070702         ', '只    ', '0', '0.19', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-60A                        ', 'B01070703         ', '只    ', '3200', '0.65', '2066.43');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-80A                        ', 'B01070704         ', '只    ', '0', '0.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-100A                       ', 'B01070705         ', '只    ', '200', '0.66', '132');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-150A                       ', 'B01070706         ', '只    ', '0', '1.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-200A                       ', 'B01070707         ', '只    ', '400', '1.18', '472');
INSERT INTO `materialspecificationsheet` VALUES ('圆形裸端头                      ', 'OT-250A                       ', 'B01070708         ', '只    ', '0', '1.45', '0');
INSERT INTO `materialspecificationsheet` VALUES ('叉形裸端头                      ', '                              ', 'B010708', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('叉形裸端头                      ', 'TU-1.5×3                     ', 'B01070801         ', '只    ', '2000', '0.03', '52');
INSERT INTO `materialspecificationsheet` VALUES ('叉形裸端头                      ', 'TU-1.5×4                     ', 'B01070802         ', '只    ', '0', '0.04', '0');
INSERT INTO `materialspecificationsheet` VALUES ('叉形裸端头                      ', 'TU-1.5×5                     ', 'B01070803         ', '只    ', '2000', '0.1', '204.62');
INSERT INTO `materialspecificationsheet` VALUES ('叉形裸端头                      ', 'TU-1.5×6                     ', 'B01070804         ', '只    ', '0', '0.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('叉形裸端头                      ', 'TU-2.5×3                     ', 'B01070805         ', '只    ', '2000', '0.05', '100');
INSERT INTO `materialspecificationsheet` VALUES ('其它电器                        ', '                              ', 'B0108             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线端子                        ', '                              ', 'B010801', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线端子                        ', 'X5-2005                       ', 'B01080101         ', '只    ', '0', '2.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线端子                        ', 'JDO-60/0                      ', 'B01080102         ', '只    ', '0', '0.6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('普通接线端子                    ', 'JH10-2.5/1                    ', 'B01080103         ', '只    ', '3000', '2.14', '6420');
INSERT INTO `materialspecificationsheet` VALUES ('试验接线端子                    ', 'JH10S-2.5                     ', 'B01080104         ', '只    ', '1200', '3.29', '3948');
INSERT INTO `materialspecificationsheet` VALUES ('连接接线端子                    ', 'JH10-2.5/2L                   ', 'B01080105         ', '只    ', '0', '2.14', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线板、盒                      ', '                              ', 'B010802', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线柱                          ', '333型                         ', 'B01080201         ', '只    ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线板                          ', 'B1-4-10                       ', 'B01080202         ', '块    ', '0', '11.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合接线盒                      ', 'DFY1-3×380V/220V             ', 'B01080203         ', '只    ', '0', '46.54', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线柱                          ', 'P-100A                        ', 'B01080204         ', '只    ', '0', '15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线柱                          ', 'P10A                          ', 'B01080205         ', '只    ', '0', '5.49', '0');
INSERT INTO `materialspecificationsheet` VALUES ('补偿控制接线桩头                ', '？                            ', 'B01080206         ', '付    ', '0', '0.15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线柱                          ', '555型                         ', 'B01080207         ', '只    ', '0', '6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线板                          ', 'JF5-2.5/5                     ', 'B01080208         ', '条    ', '20', '2.22', '44.4');
INSERT INTO `materialspecificationsheet` VALUES ('接线板                          ', 'TL-100/4                      ', 'B01080209         ', '块    ', '31', '6.89', '315.27');
INSERT INTO `materialspecificationsheet` VALUES ('接线板                          ', 'TB-2503/L                     ', 'B01080210         ', '条    ', '0', '1.9', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接线板                          ', 'XJ-4/60A                      ', 'B01080211         ', '块    ', '0', '1.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', '                              ', 'B010804', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'JLXK1-111                     ', 'B01080401         ', '只    ', '0', '23.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'LX-5-11H                      ', 'B01080402         ', '只    ', '0', '13.68', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'LX-0.28                       ', 'B01080403         ', '只    ', '0', '9.83', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'LX3-11H                       ', 'B01080404         ', '只    ', '0', '10.65', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'LX19-111(5A)                  ', 'B01080405         ', '只    ', '20', '2.52', '89.72');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'LXK2-411K                     ', 'B01080406         ', '只    ', '0', '17.84', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'LXIP-K                        ', 'B01080407         ', '只    ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行程开关                        ', 'X2-N                          ', 'B01080408         ', '只    ', '0', '20.85', '0');
INSERT INTO `materialspecificationsheet` VALUES ('限位开关                        ', 'LX44-20                       ', 'B01080409         ', '只    ', '0', '73.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('微动开关                        ', 'LXW5-G                        ', 'B01080410         ', '只    ', '4', '9.2', '36.8');
INSERT INTO `materialspecificationsheet` VALUES ('控制按钮                        ', '                              ', 'B010805', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('控制按钮                        ', 'LA2-220V                      ', 'B01080501         ', '只    ', '0', '7.07', '0');
INSERT INTO `materialspecificationsheet` VALUES ('控制按钮                        ', 'LA18-380V(5A)                 ', 'B01080502         ', '只    ', '0', '7.69', '0');
INSERT INTO `materialspecificationsheet` VALUES ('旋转按钮                        ', 'LAY3-220V                     ', 'B01080503         ', '只    ', '0', '20.51', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号灯、电铃                    ', '                              ', 'B010806', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号灯                          ', 'XD11-6.3                      ', 'B01080601         ', '只    ', '0', '2.87', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号灯                          ', 'AD11-25/40                    ', 'B01080602         ', '只    ', '0', '7.66', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号灯                          ', 'XD7-8(380V)                   ', 'B01080603         ', '只    ', '0', '9.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('信号灯                          ', 'XD13-220V                     ', 'B01080604         ', '只    ', '0', '6.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电铃                            ', 'UC4-75/220V                   ', 'B01080605         ', '只    ', '0', '15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('超声波驱鼠器                    ', '？                            ', 'B01080606         ', '只    ', '0', '253', '0');
INSERT INTO `materialspecificationsheet` VALUES ('主令开关                        ', 'LS2-2                         ', 'B01080607         ', '只    ', '0', '14.7', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电话机                          ', 'HA9000（23）                  ', 'B01080608         ', '台    ', '0', '98', '0');
INSERT INTO `materialspecificationsheet` VALUES ('避雷器                          ', '                              ', 'B010808', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('低压避雷器                      ', 'FYS-0.2                       ', 'B01080801         ', '只    ', '0', '8.89', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压避雷器                      ', 'HY5Ws-12.7/50                 ', 'B01080802         ', '3只/组', '0', '14.52', '0');
INSERT INTO `materialspecificationsheet` VALUES ('避雷器                          ', 'HY1.5W-0.5/2.6                ', 'B01080803         ', '只    ', '188', '14.96', '2812.48');
INSERT INTO `materialspecificationsheet` VALUES ('避雷器                          ', 'PU65*4                        ', 'B01080804         ', '套    ', '0', '2350.43', '0');
INSERT INTO `materialspecificationsheet` VALUES ('避雷器                          ', 'PU 40×4                      ', 'B01080805         ', '套    ', '0', '1222.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('浪涌装置                        ', 'ZU30-20/40KA2P                ', 'B01080806         ', '只    ', '0', '358.97', '0');
INSERT INTO `materialspecificationsheet` VALUES ('浪涌保护器                      ', 'TIU1-65/440 4P                ', 'B01080807         ', '台    ', '0', '1997.86', '0');
INSERT INTO `materialspecificationsheet` VALUES ('浪涌保护器                      ', 'ZU1-C/4P 20-40KA/420V         ', 'B01080808         ', '台    ', '0', '871.79', '0');
INSERT INTO `materialspecificationsheet` VALUES ('浪涌保护器                      ', 'TIU1-40/440/4P                ', 'B01080809         ', '只    ', '0', '1198.72', '0');
INSERT INTO `materialspecificationsheet` VALUES ('浪涌保护器                      ', 'ZU1C-30/60/4P                 ', 'B01080810         ', '只    ', '0', '1307.69', '0');
INSERT INTO `materialspecificationsheet` VALUES ('配件                            ', '                              ', 'B0109             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('欠压脱扣器线圈                  ', 'DW15(400-630)A                ', 'B010901           ', '只    ', '0', '50', '0');
INSERT INTO `materialspecificationsheet` VALUES ('欠压脱扣器线圈                  ', 'DW15(1000-1600)A              ', 'B010902           ', '只    ', '0', '40', '0');
INSERT INTO `materialspecificationsheet` VALUES ('辅助触头                        ', 'DW15-1600/3                   ', 'B010903           ', '只    ', '0', '80', '0');
INSERT INTO `materialspecificationsheet` VALUES ('拉簧                            ', '?                             ', 'B010904           ', '根    ', '0', '0.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('分励脱扣器线圈                  ', 'DW15(400-630)A                ', 'B010905           ', '只    ', '0', '102.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('分励脱扣器线圈                  ', 'DW15(1000-1600)A              ', 'B010906           ', '只    ', '0', '35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器线圈                      ', 'CJ10-150A(220V)               ', 'B010907           ', '只    ', '0', '28.7', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器线圈                      ', 'CJ10-150A(380V)               ', 'B010908           ', '只    ', '0', '65.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器线圈                      ', 'CJ20-160A(220V)               ', 'B010909           ', '只    ', '0', '19.49', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器线圈                      ', 'CJ20-160A(380V)               ', 'B010910           ', '只    ', '0', '48', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器线圈                      ', 'CJ20-250A(220V)               ', 'B010911           ', '只    ', '0', '76.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器线圈                      ', 'CJ20-250A(380V)               ', 'B010912           ', '只    ', '0', '74.47', '0');
INSERT INTO `materialspecificationsheet` VALUES ('接触器线圈                      ', 'CJ20-400A(220V)               ', 'B010913           ', '只    ', '0', '66.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('绝缘材料                        ', '                              ', 'B0110             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('固定母线架                      ', 'GGD-6×60                     ', 'B011001           ', '付    ', '97', '12.82', '1243.54');
INSERT INTO `materialspecificationsheet` VALUES ('固定母线架                      ', 'GGD-8×80                     ', 'B011002           ', '付    ', '70', '12.82', '897.4');
INSERT INTO `materialspecificationsheet` VALUES ('固定母线架                      ', 'GGD-10×100                   ', 'B011003           ', '付    ', '0', '1.92', '0');
INSERT INTO `materialspecificationsheet` VALUES ('零线母线架                      ', 'LM1-4×40                     ', 'B011004           ', '付    ', '0', '6.83', '0');
INSERT INTO `materialspecificationsheet` VALUES ('零线母线架                      ', 'LM1-5×50                     ', 'B011005           ', '付    ', '0', '6.83', '0');
INSERT INTO `materialspecificationsheet` VALUES ('零线母线架                      ', 'LM1-6×60                     ', 'B011006           ', '付    ', '70', '6.83', '478.1');
INSERT INTO `materialspecificationsheet` VALUES ('零线母线架                      ', 'LM1-8×80                     ', 'B011007           ', '付    ', '9', '6.83', '61.47');
INSERT INTO `materialspecificationsheet` VALUES ('零线母线架                      ', 'LM1-10×100                   ', 'B011008           ', '付    ', '0', '22.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合母线架                      ', 'ZMJ1-4×40                    ', 'B011009           ', '付    ', '0', '49.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('组合母线架                      ', 'ZMJ1-5×50                    ', 'B011010           ', '付    ', '0', '49.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电力电容器                      ', '                              ', 'B0111             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电容器                          ', 'CB-60                         ', 'B011101           ', '只    ', '0', '11.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电容器                          ', '±50/450V                     ', 'B011102           ', '只    ', '0', '15.23', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电容器                          ', 'BSMJ-0.4-12Kvar               ', 'B011103           ', '只    ', '0', '121.18', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电容器                          ', 'BSMJ-0.4-14Kvar               ', 'B011104           ', '只    ', '2', '141.21', '282.41');
INSERT INTO `materialspecificationsheet` VALUES ('电容器                          ', 'BSMJ-0.4-16Kvar               ', 'B011105           ', '只    ', '0', '159.31', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电容器                          ', 'BSMJ-0.4-20Kvar               ', 'B011106           ', '只    ', '1', '202.41', '202.41');
INSERT INTO `materialspecificationsheet` VALUES ('电容器                          ', 'BSMJ-0.4-10Kvar               ', 'B011107           ', '只    ', '0', '188.04', '0');
INSERT INTO `materialspecificationsheet` VALUES ('其它材料                        ', '                              ', 'B0112             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行线槽                          ', '                              ', 'B011201', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行线槽                          ', '3×30                         ', 'B01120101         ', 'm     ', '200', '2.56', '512');
INSERT INTO `materialspecificationsheet` VALUES ('行线槽                          ', '5×45                         ', 'B01120102         ', '条    ', '0', '11.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('行线槽                          ', '4×40                         ', 'B01120103         ', '条    ', '100', '3.29', '329');
INSERT INTO `materialspecificationsheet` VALUES ('绕线管                          ', '                              ', 'B011202', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('无边绕线管                      ', 'φ8-6                         ', 'B01120201         ', 'Kg    ', '0', '15.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('有边绕线管                      ', 'φ8-6                         ', 'B01120202         ', 'Kg    ', '0', '29.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', '                              ', 'B011203', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', 'Φ2.5-Φ4                     ', 'B01120301         ', '卷    ', '0', '18', '0');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', 'Φ6                           ', 'B01120302         ', '卷    ', '0', '18', '0');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', 'LP-1.50                       ', 'B01120303         ', '圈    ', '12', '32.76', '2074.07');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', 'LP-4                          ', 'B01120304         ', '卷    ', '3', '168.1', '504.29');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', 'LP-6                          ', 'B01120305         ', '卷    ', '1', '34.19', '34.19');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', 'LP-1.0mm2                     ', 'B01120306         ', '卷    ', '5', '34.19', '170.93');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', '10mm2                         ', 'B01120307         ', '圈    ', '10', '18', '180');
INSERT INTO `materialspecificationsheet` VALUES ('记号管                          ', 'LP-15                         ', 'B01120308         ', '卷    ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('线扣                            ', '                              ', 'B011204', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('线扣                            ', 'CZ-100                        ', 'B01120401         ', '袋    ', '160', '4.31', '1840');
INSERT INTO `materialspecificationsheet` VALUES ('线扣                            ', 'CZ-200                        ', 'B01120402         ', '袋    ', '100', '24.8', '2480');
INSERT INTO `materialspecificationsheet` VALUES ('线卡                            ', 'Φ6                           ', 'B01120403         ', '袋    ', '96', '2.54', '244.28');
INSERT INTO `materialspecificationsheet` VALUES ('钢精轧头                        ', '?                             ', 'B01120404         ', '包    ', '0', '1.71', '0');
INSERT INTO `materialspecificationsheet` VALUES ('管卡                            ', '4分                           ', 'B01120405         ', '只    ', '0', '0.09', '0');
INSERT INTO `materialspecificationsheet` VALUES ('线卡                            ', '10#                           ', 'B01120406         ', '盒    ', '2', '2.56', '4');
INSERT INTO `materialspecificationsheet` VALUES ('线卡                            ', '16#                           ', 'B01120407         ', '包    ', '0', '6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('线卡                            ', '8#                            ', 'B01120408         ', '盒    ', '0', '1.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('元线夹                          ', '                              ', 'B011205', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('元线夹                          ', '大                            ', 'B01120501         ', '只    ', '300', '0.16', '144');
INSERT INTO `materialspecificationsheet` VALUES ('元线夹                          ', '中                            ', 'B01120502         ', '只    ', '0', '0.35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('元线夹                          ', '小                            ', 'B01120503         ', '只    ', '400', '0.14', '112');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', '                              ', 'B011206', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'Φ25                          ', 'B01120601         ', '只    ', '0', '0.3', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'Φ28                          ', 'B01120602         ', '只    ', '0', '0.3', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'Φ30                          ', 'B01120603         ', '只    ', '6820', '0.33', '2252.45');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'Φ60                          ', 'B01120604         ', '只    ', '18580', '0.25', '8770.31');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'φ70                          ', 'B01120605         ', '只    ', '0', '0.92', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'ф80                          ', 'B01120606         ', '只    ', '0', '0.43', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'φ75                          ', 'B01120607         ', '只    ', '4950', '0.62', '3502.36');
INSERT INTO `materialspecificationsheet` VALUES ('橡胶O型圈                       ', '12×30                        ', 'B01120608         ', '只    ', '0', '0.15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮圈                          ', 'φ90                          ', 'B01120609         ', '只    ', '7985', '0.33', '9039.63');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮嵌条                        ', '                              ', 'B011207', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('橡皮嵌条                        ', '？                            ', 'B01120701         ', '米    ', '100', '7.5', '750');
INSERT INTO `materialspecificationsheet` VALUES ('矩形橡皮嵌条                    ', '155×275                      ', 'B01120702         ', '只    ', '970', '5.19', '5031.23');
INSERT INTO `materialspecificationsheet` VALUES ('密封条                          ', '?                             ', 'B01120703         ', 'm     ', '0', '3.3', '0');
INSERT INTO `materialspecificationsheet` VALUES ('矩形橡皮嵌条                    ', '130×200                      ', 'B01120704         ', '只    ', '0', '5.45', '0');
INSERT INTO `materialspecificationsheet` VALUES ('标签框                          ', '                              ', 'B011208', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('标签框                          ', '15×50                        ', 'B01120801         ', '只    ', '0', '0.1', '0');
INSERT INTO `materialspecificationsheet` VALUES ('标签框                          ', '30×80                        ', 'B01120802         ', '只    ', '0', '0.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('标鉴框                          ', '18×60                        ', 'B01120803         ', '只    ', '0', '0.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑料框                          ', '                              ', 'B011209', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑料框                          ', '90×90                        ', 'B01120901         ', '只    ', '0', '0.61', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑料框                          ', '100×200                      ', 'B01120902         ', '只    ', '0', '2.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑料框                          ', '230×130                      ', 'B01120903         ', '只    ', '0', '2.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑料框                          ', '80×90                        ', 'B01120904         ', '只    ', '0', '1.36', '0');
INSERT INTO `materialspecificationsheet` VALUES ('透明塑料框                      ', '80×90                        ', 'B01120905         ', '只    ', '0', '1.37', '0');
INSERT INTO `materialspecificationsheet` VALUES ('动力表箱框                      ', '500×802                      ', 'B01120906         ', '只    ', '0', '0.85', '0');
INSERT INTO `materialspecificationsheet` VALUES ('表框                            ', '360×90                       ', 'B01120907         ', '片    ', '222', '5.06', '1124.35');
INSERT INTO `materialspecificationsheet` VALUES ('表框                            ', '200×90                       ', 'B01120908         ', '片    ', '2100', '3.31', '6941.21');
INSERT INTO `materialspecificationsheet` VALUES ('照明灯具                        ', '                              ', 'B0113             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('灯架类                          ', '                              ', 'B011301', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('日光灯架                        ', '40W                           ', 'B01130101         ', '只    ', '0', '47.86', '0');
INSERT INTO `materialspecificationsheet` VALUES ('碘钨灯座                        ', '1000W                         ', 'B01130102         ', '只    ', '2', '6.84', '13.68');
INSERT INTO `materialspecificationsheet` VALUES ('日光灯座                        ', '30W                           ', 'B01130103         ', '付    ', '0', '25', '0');
INSERT INTO `materialspecificationsheet` VALUES ('仿比利时灯罩                    ', '？                            ', 'B01130104         ', '只    ', '0', '158.98', '0');
INSERT INTO `materialspecificationsheet` VALUES ('桶灯灯罩                        ', '？                            ', 'B01130105         ', '只    ', '0', '12.82', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆球罩                          ', 'φ350                         ', 'B01130106         ', '只    ', '0', '41.06', '0');
INSERT INTO `materialspecificationsheet` VALUES ('琵琶式路灯罩                    ', '110W                          ', 'B01130107         ', '只    ', '0', '80', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中波纹罩                        ', '？                            ', 'B01130108         ', '只    ', '0', '53.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('白塔松灯罩                      ', '？                            ', 'B01130109         ', '只    ', '0', '53.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('元球玻璃罩                      ', 'φ350　                       ', 'B01130110         ', '只    ', '0', '35.71', '0');
INSERT INTO `materialspecificationsheet` VALUES ('灯泡类                          ', '                              ', 'B011302', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('日光灯管                        ', '40W                           ', 'B01130201         ', '支    ', '14', '5.56', '77.84');
INSERT INTO `materialspecificationsheet` VALUES ('碘钨灯管                        ', '500W                          ', 'B01130202         ', '支    ', '0', '5.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('碘钨灯管                        ', '1000W                         ', 'B01130203         ', '支    ', '32', '0.75', '215.44');
INSERT INTO `materialspecificationsheet` VALUES ('罗口灯泡                        ', '100W                          ', 'B01130204         ', '只    ', '2', '1', '2');
INSERT INTO `materialspecificationsheet` VALUES ('罗口灯泡                        ', 'JZ36V-100W                    ', 'B01130205         ', '只    ', '6', '1.03', '6.18');
INSERT INTO `materialspecificationsheet` VALUES ('插口灯泡                        ', '60-100W                       ', 'B01130206         ', '只    ', '3', '0.85', '2.55');
INSERT INTO `materialspecificationsheet` VALUES ('自镇流高压汞泡                  ', '125W                          ', 'B01130207         ', '只    ', '0', '14.86', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压汞灯                        ', '125W                          ', 'B01130208         ', '只    ', '0', '14.23', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压汞灯                        ', '250W                          ', 'B01130209         ', '只    ', '0', '58.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压钠灯                        ', '150W                          ', 'B01130210         ', '只    ', '0', '45.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镇流器类                        ', '                              ', 'B011303', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('日光灯镇流器                    ', '40W                           ', 'B01130301         ', '只    ', '2', '6', '12');
INSERT INTO `materialspecificationsheet` VALUES ('高压汞灯镇流器                  ', '125W                          ', 'B01130302         ', '只    ', '0', '58.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压汞灯镇流器                  ', '250W                          ', 'B01130303         ', '只    ', '0', '58.11', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压钠灯镇流器                  ', '150W                          ', 'B01130304         ', '只    ', '0', '87.58', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压钠灯镇流器                  ', '250W                          ', 'B01130305         ', '只    ', '0', '83.76', '0');
INSERT INTO `materialspecificationsheet` VALUES ('触发器                          ', 'CD-2                          ', 'B01130306         ', '只    ', '0', '13.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电子式镇流器                    ', '一拖二                        ', 'B01130307         ', '只    ', '0', '28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电子式镇流器                    ', '一拖一                        ', 'B01130308         ', '只    ', '0', '15.39', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钠镇流器触发器                  ', '250W                          ', 'B01130309         ', '只    ', '0', '504.27', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压钠灯镇流器                  ', '400W                          ', 'B01130310         ', '只    ', '0', '143.59', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钠镇流器触发器                  ', '400W                          ', 'B01130311         ', '只    ', '0', '15.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插座、插头类                    ', '                              ', 'B011304', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('单相插座                        ', '10A                           ', 'B01130401         ', '只    ', '1', '3', '3');
INSERT INTO `materialspecificationsheet` VALUES ('三相插座                        ', 'AC30-25A                      ', 'B01130402         ', '只    ', '0', '10', '0');
INSERT INTO `materialspecificationsheet` VALUES ('三相四线插座                    ', '15A                           ', 'B01130403         ', '只    ', '4', '3.68', '14.71');
INSERT INTO `materialspecificationsheet` VALUES ('三相四线插座                    ', '30A                           ', 'B01130404         ', '只    ', '0', '8.55', '0');
INSERT INTO `materialspecificationsheet` VALUES ('三相四线插头                    ', '15A                           ', 'B01130405         ', '只    ', '0', '3.7', '0');
INSERT INTO `materialspecificationsheet` VALUES ('三相四线插头                    ', '30A                           ', 'B01130406         ', '只    ', '10', '5.81', '45');
INSERT INTO `materialspecificationsheet` VALUES ('单相插头                        ', '10A                           ', 'B01130407         ', '只    ', '0', '0.64', '0');
INSERT INTO `materialspecificationsheet` VALUES ('三相插头                        ', '16A                           ', 'B01130408         ', '只    ', '6', '2.8', '16.8');
INSERT INTO `materialspecificationsheet` VALUES ('普通多用插座                    ', '?                             ', 'B01130409         ', '只    ', '0', '6.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('多功能插座                      ', '?                             ', 'B01130410         ', '只    ', '4', '7.15', '28.59');
INSERT INTO `materialspecificationsheet` VALUES ('空调插座                        ', '16A                           ', 'B01130411         ', '套    ', '0', '7.69', '0');
INSERT INTO `materialspecificationsheet` VALUES ('其它类                          ', '                              ', 'B011305', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('启辉器                          ', '?                             ', 'B01130501         ', '只    ', '8', '1.71', '13.68');
INSERT INTO `materialspecificationsheet` VALUES ('吊扇                            ', '？                            ', 'B01130502         ', '把    ', '0', '120', '0');
INSERT INTO `materialspecificationsheet` VALUES ('小电珠                          ', '3.8V                          ', 'B01130503         ', '只    ', '2', '0.4', '0.8');
INSERT INTO `materialspecificationsheet` VALUES ('拉线开关                        ', '250V                          ', 'B01130504         ', '只    ', '0', '1.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('灯头                            ', '250V                          ', 'B01130505         ', '只    ', '2', '-5.54', '-10.58');
INSERT INTO `materialspecificationsheet` VALUES ('吊扇吊钩                        ', '？                            ', 'B01130506         ', '只    ', '0', '1.71', '0');
INSERT INTO `materialspecificationsheet` VALUES ('自镇流汞灯头                    ', '250A                          ', 'B01130507         ', '只    ', '0', '5.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('吊扇电容器                      ', '？                            ', 'B01130508         ', '只    ', '0', '2.75', '0');
INSERT INTO `materialspecificationsheet` VALUES ('吊扇调速器                      ', '？                            ', 'B01130509         ', '只    ', '0', '10', '0');
INSERT INTO `materialspecificationsheet` VALUES ('线令                            ', '？                            ', 'B01130510         ', '只    ', '0', '0.43', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电子元件                        ', '                              ', 'B0114             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('发光二极管                      ', 'R05133S                       ', 'B011401           ', '只    ', '0', '0.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('发光二极管                      ', 'R03143S                       ', 'B011402           ', '只    ', '0', '0.07', '0');
INSERT INTO `materialspecificationsheet` VALUES ('发光二极管                      ', 'YG05133S                      ', 'B011403           ', '只    ', '0', '0.07', '0');
INSERT INTO `materialspecificationsheet` VALUES ('熔丝夹座                        ', '？                            ', 'B011404           ', '只    ', '0', '0.54', '0');
INSERT INTO `materialspecificationsheet` VALUES ('可控硅                          ', '0409                          ', 'B011405           ', '块    ', '0', '1.57', '0');
INSERT INTO `materialspecificationsheet` VALUES ('数码管（红）                    ', 'A0361SR-11                    ', 'B011406           ', '只    ', '0', '0.89', '0');
INSERT INTO `materialspecificationsheet` VALUES ('可控硅                          ', 'MFC（A）25-16                 ', 'B011407           ', '只    ', '0', '110', '0');
INSERT INTO `materialspecificationsheet` VALUES ('散热片                          ', '90×40×300                   ', 'B011408           ', '片    ', '0', '1.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('可控硅                          ', 'MFC（A）40-16                 ', 'B011409           ', '只    ', '0', '145', '0');
INSERT INTO `materialspecificationsheet` VALUES ('可控硅                          ', 'MFC（A）55-16                 ', 'B011410           ', '只    ', '0', '155', '0');
INSERT INTO `materialspecificationsheet` VALUES ('10KV高压电器                    ', '                              ', 'B0115             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('带电显示器                      ', 'GSN1-10Q                      ', 'B011501           ', '只    ', '0', '641.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('传感器                          ', 'CGS-10KV                      ', 'B011502           ', '只    ', '0', '153.85', '0');
INSERT INTO `materialspecificationsheet` VALUES ('户内电磁锁                      ', 'DSN2-ЩAC220V                 ', 'B011503           ', '只    ', '0', '333.33', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压熔断器                      ', 'SFLAJ-10/50                   ', 'B011504           ', '只    ', '0', '410.26', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压互感器                      ', 'LZJC-10-50/5                  ', 'B011505           ', '只    ', '0', '606.84', '0');
INSERT INTO `materialspecificationsheet` VALUES ('高压互感器                      ', 'LZJC-10-75/5                  ', 'B011506           ', '只    ', '0', '606.84', '0');
INSERT INTO `materialspecificationsheet` VALUES ('自动开关（二）                  ', '                              ', 'B0116             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器RM（五）              ', '                              ', 'B011601', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-63H/3200 63A             ', 'B01160101         ', '只    ', '0', '224.36', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-100H/4300 63A            ', 'B01160102         ', '只    ', '0', '416.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-100H/3200 100A           ', 'B01160103         ', '只    ', '0', '288.46', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-100H/4300 100A           ', 'B01160104         ', '只    ', '0', '416.67', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-250H/4300 100A           ', 'B01160105         ', '只    ', '0', '673.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-250H/4300 125A           ', 'B01160106         ', '只    ', '0', '673.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-250H/4300 160A           ', 'B01160107         ', '只    ', '0', '673.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-250H/4310 160A(AC220V)   ', 'B01160108         ', '只    ', '0', '741.45', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-250H/4300 250A           ', 'B01160109         ', '只    ', '0', '673.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑壳断路器                      ', 'RMM1-400H/4310 250A(AC220V)   ', 'B01160110         ', '只    ', '0', '1489.32', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器CKB（六）                 ', '                              ', 'B011602', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKB60-C.1P.25A                ', 'B01160201         ', '只    ', '0', '6.58', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKB60-C.1P.40A                ', 'B01160202         ', '只    ', '0', '6.58', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKB60-C.3P.16A                ', 'B01160203         ', '只    ', '0', '22.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKB60-C.3P.20A                ', 'B01160204         ', '只    ', '0', '22.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKB60-C.3P.32A                ', 'B01160205         ', '只    ', '0', '22.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKB60-C.3P.40A                ', 'B01160206         ', '只    ', '0', '22.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKB60-100.C.3P.80A            ', 'B01160207         ', '只    ', '0', '68.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKM33-100S/3300 80A           ', 'B01160208         ', '只    ', '0', '276.93', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKM33-160S/4300 160A          ', 'B01160209         ', '只    ', '0', '430.77', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKM33-400H/3340 400A          ', 'B01160210         ', '只    ', '3', '802.05', '2406.15');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKM33-630H/3340 630A          ', 'B01160211         ', '只    ', '0', '1.44', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKM33-100S/3300 40A           ', 'B01160212         ', '只    ', '8', '276.92', '2215.38');
INSERT INTO `materialspecificationsheet` VALUES ('断路器（七）                    ', '                              ', 'B011603', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'DZ20J-400/3300 250A           ', 'B01160301         ', '只    ', '0', '338.46', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'DZ20J-630/3300 630A           ', 'B01160302         ', '只    ', '0', '385.47', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'YSM1-225S/3300 225A           ', 'B01160303         ', '只    ', '0', '384.62', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'YSM1-225S/3300 100A           ', 'B01160304         ', '只    ', '0', '384.62', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'CKM33-400H/3310 400A          ', 'B01160305         ', '只    ', '0', '880.34', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'ZM30E-225/3300 100A           ', 'B01160306         ', '只    ', '2', '191.45', '382.9');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'ZM30E-225/3300 150A           ', 'B01160307         ', '只    ', '0', '38.29', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器NLM1（八）                ', '                              ', 'B011604', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-630M/3300 630A           ', 'B01160401         ', '只    ', '2', '949.57', '1899.14');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-400M/3300 400A           ', 'B01160402         ', '只    ', '3', '694.88', '2084.63');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-225L/3300 160A           ', 'B01160403         ', '只    ', '3', '321.37', '964.1');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-630L/3300 500A           ', 'B01160404         ', '只    ', '0', '272.37', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-630H/3300 630A           ', 'B01160405         ', '只    ', '0', '1081.54', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-630M/3340 630A           ', 'B01160406         ', '只    ', '0', '2517.1', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-225C/3300 200A           ', 'B01160407         ', '只    ', '0', '258.21', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-225C/3300 160A           ', 'B01160408         ', '只    ', '0', '64.55', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-400C/3300 315A           ', 'B01160409         ', '只    ', '0', '0.01', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-400C/3300 250A           ', 'B01160410         ', '只    ', '0', '414.11', '0');
INSERT INTO `materialspecificationsheet` VALUES ('断路器                          ', 'NLM1-400C/3300 400A           ', 'B01160411         ', '只    ', '0', '523.51', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钢材料                          ', '                              ', 'B02               ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('角钢                            ', '                              ', 'B0201             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('角钢(大钢厂）                   ', '∠30×3                       ', 'B020101           ', 'kg    ', '41', '3.29', '134.89');
INSERT INTO `materialspecificationsheet` VALUES ('角钢                            ', '∠40×4                       ', 'B020102           ', 'kg    ', '406.9', '3.06', '1245.11');
INSERT INTO `materialspecificationsheet` VALUES ('角钢                            ', '∠50×5                       ', 'B020103           ', 'kg    ', '0', '3.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('角钢                            ', '∠60×6                       ', 'B020104           ', 'kg    ', '0', '1.81', '0');
INSERT INTO `materialspecificationsheet` VALUES ('角钢                            ', '∠70×7                       ', 'B020105           ', 'kg    ', '0', '0.06', '0');
INSERT INTO `materialspecificationsheet` VALUES ('角钢                            ', '∠80×8                       ', 'B020106           ', 'kg    ', '0', '3.04', '0');
INSERT INTO `materialspecificationsheet` VALUES ('角钢                            ', '∠40×3                       ', 'B020107           ', 'kg    ', '0', '2.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '                              ', 'B0202             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-3×30                        ', 'B020201           ', 'kg    ', '213', '3.92', '834.55');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-4×40                        ', 'B020202           ', 'kg    ', '302.4', '3.65', '1102.41');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-5×50                        ', 'B020203           ', 'kg    ', '1352.4', '2.32', '5600.74');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-6×60                        ', 'B020204           ', 'kg    ', '2037.6', '2', '8150.4');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-8×80                        ', 'B020205           ', 'kg    ', '1054.2', '3.83', '4036.17');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-8×100                       ', 'B020206           ', 'kg    ', '376.8', '3.15', '1185.19');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-4×20                        ', 'B020207           ', 'kg    ', '0', '2.55', '0');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-40×20                       ', 'B020208           ', 'kg    ', '0', '2.69', '0');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢                            ', '-6×40                        ', 'B020209           ', 'kg    ', '0', '2.39', '0');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢（小厂）                    ', '-3*30                         ', 'B020210           ', 'kg    ', '0', '2.17', '0');
INSERT INTO `materialspecificationsheet` VALUES ('扁钢(小钢厂)                    ', '-4*40                         ', 'B020211           ', 'kg    ', '0', '3.75', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆钢                            ', '                              ', 'B0203             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆钢                            ', 'Φ6.5                         ', 'B020301           ', 'kg    ', '50', '3.57', '178.62');
INSERT INTO `materialspecificationsheet` VALUES ('圆钢                            ', 'Φ8                           ', 'B020302           ', 'kg    ', '100', '3.64', '363.78');
INSERT INTO `materialspecificationsheet` VALUES ('圆钢                            ', 'Φ10                          ', 'B020303           ', 'kg    ', '510.58', '3.85', '1963.6');
INSERT INTO `materialspecificationsheet` VALUES ('圆钢                            ', 'Φ12                          ', 'B020304           ', 'kg    ', '0', '3.6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆钢                            ', 'Φ14                          ', 'B020305           ', 'kg    ', '21.78', '3.4', '74.05');
INSERT INTO `materialspecificationsheet` VALUES ('圆钢                            ', 'Φ16                          ', 'B020306           ', 'kg    ', '0', '3.48', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钢管                            ', '                              ', 'B0204             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ20                          ', 'B020401           ', 'kg    ', '0', '3.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ27                          ', 'B020402           ', 'kg    ', '0', '3.6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ34                          ', 'B020403           ', 'kg    ', '43.56', '3.84', '167.43');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ42                          ', 'B020404           ', 'kg    ', '0', '3.73', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ48                          ', 'B020405           ', 'kg    ', '45.64', '3.83', '174.95');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ60                          ', 'B020406           ', 'kg    ', '0', '1.92', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ89                          ', 'B020407           ', 'kg    ', '0', '3.48', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ114(65.0kg/支)              ', 'B020408           ', 'kg    ', '0', '3.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊管                            ', 'Φ165                         ', 'B020409           ', 'kg    ', '0', '3.97', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌管                          ', 'Φ21                          ', 'B020410           ', 'kg    ', '0', '2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钢钣                            ', '                              ', 'B0205             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热板                            ', '                              ', 'B020501', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热板                            ', '0.80                          ', 'B02050102         ', 'kg    ', '0', '3.23', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热板                            ', '1.00                          ', 'B02050103         ', 'kg    ', '1444.6', '4.04', '5843.03');
INSERT INTO `materialspecificationsheet` VALUES ('热板                            ', '1.20                          ', 'B02050104         ', 'kg    ', '0', '3.76', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热板                            ', '1.50m/m                       ', 'B02050105         ', 'kg    ', '4710', '4.04', '21738.46');
INSERT INTO `materialspecificationsheet` VALUES ('热板                            ', '2.00m/m                       ', 'B02050106         ', 'kg    ', '2637.6', '4.1', '10826.22');
INSERT INTO `materialspecificationsheet` VALUES ('热板                            ', '2.50m/m                       ', 'B02050107         ', 'kg    ', '0', '2.94', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热板（钢板网）                  ', '?                             ', 'B02050108         ', 'm2    ', '0', '10.26', '0');
INSERT INTO `materialspecificationsheet` VALUES ('冷板                            ', '                              ', 'B020502', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('冷板                            ', '1.20                          ', 'B02050201         ', 'kg    ', '0', '3.64', '0');
INSERT INTO `materialspecificationsheet` VALUES ('冷板                            ', '1.50                          ', 'B02050202         ', 'kg    ', '5077.8', '4.77', '24206.77');
INSERT INTO `materialspecificationsheet` VALUES ('冷板                            ', '1.00                          ', 'B02050203         ', 'kg    ', '0', '4.07', '0');
INSERT INTO `materialspecificationsheet` VALUES ('冷板                            ', '2.5                           ', 'B02050204         ', 'kg    ', '0', '3.64', '0');
INSERT INTO `materialspecificationsheet` VALUES ('冷板                            ', '0.5m/m                        ', 'B02050205         ', 'kg    ', '0', '4.15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('冷板                            ', '2.0mm                         ', 'B02050206         ', 'kg    ', '0', '21.81', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中板                            ', '                              ', 'B020503', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中板                            ', '-3                            ', 'B02050301         ', 'kg    ', '0', '3.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中板                            ', '-4                            ', 'B02050302         ', 'kg    ', '302.48', '4.01', '1212.67');
INSERT INTO `materialspecificationsheet` VALUES ('中板                            ', '-5                            ', 'B02050303         ', 'kg    ', '0', '2.7', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中板                            ', '-6                            ', 'B02050304         ', 'kg    ', '678.24', '3.76', '2548.27');
INSERT INTO `materialspecificationsheet` VALUES ('中板                            ', '8                             ', 'B02050305         ', 'kg    ', '0', '4.1', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝板                            ', '                              ', 'B020504', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝钣                            ', '2                             ', 'B02050401         ', 'kg    ', '0', '20.82', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢板                        ', '                              ', 'B020505', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢板                        ', '1.5mm                         ', 'B02050501         ', 'kg    ', '3529.2', '28.25', '99684.79');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢板                        ', '1mm                           ', 'B02050502         ', 'kg    ', '2549.76', '20', '50995.2');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢板                        ', '4.00mm                        ', 'B02050503         ', 'kg    ', '0', '27', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢板                        ', '2m/m                          ', 'B02050504         ', 'kg    ', '424.89', '22.48', '9551.53');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢板                        ', '0.5m/m                        ', 'B02050505         ', 'kg    ', '0', '19.45', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢板                        ', '0.8m/m                        ', 'B02050506         ', 'kg    ', '0', '23.08', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌板                          ', '                              ', 'B020506', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌板                          ', '0.5                           ', 'B02050601         ', 'kg    ', '0', '5.01', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌板                          ', '1mm                           ', 'B02050602         ', 'kg    ', '0', '4.53', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌板                          ', '0.8mm                         ', 'B02050603         ', 'kg    ', '0', '4.79', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢球                        ', '                              ', 'B020507', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢球                        ', 'φ80                          ', 'B02050701         ', 'kg    ', '0', '3.33', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢球                        ', 'φ90                          ', 'B02050702         ', '只    ', '0', '6.09', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢球                        ', ' φ32                         ', 'B02050703         ', '只    ', '0', '0.68', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢座                        ', 'φ25                          ', 'B02050704         ', '只    ', '0', '2.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢座                        ', 'φ76                          ', 'B02050705         ', '只    ', '0', '1.97', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢球                        ', 'φ114                         ', 'B02050706         ', '只    ', '0', '6.17', '0');
INSERT INTO `materialspecificationsheet` VALUES ('废料                            ', '                              ', 'B020508           ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('薄板                            ', '多规格                        ', 'B0205080          ', 'kg    ', '0', '2.72', '0');
INSERT INTO `materialspecificationsheet` VALUES ('槽钢                            ', '                              ', 'B0206             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('槽钢                            ', '[63                           ', 'B020601           ', 'kg    ', '411.31', '3.4', '1398.45');
INSERT INTO `materialspecificationsheet` VALUES ('槽钢                            ', '[80                           ', 'B020602           ', 'kg    ', '0', '3.29', '0');
INSERT INTO `materialspecificationsheet` VALUES ('槽钢                            ', '[100                          ', 'B020603           ', 'kg    ', '0', '3.25', '0');
INSERT INTO `materialspecificationsheet` VALUES ('槽钢                            ', '[120                          ', 'B020604           ', 'kg    ', '0', '2.35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('槽钢                            ', '[140                          ', 'B020605           ', 'kg    ', '0', '2.29', '0');
INSERT INTO `materialspecificationsheet` VALUES ('模具钢                          ', '                              ', 'B0207             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('模具钢                          ', '？                            ', 'B020701           ', 'kg    ', '0', '8.68', '0');
INSERT INTO `materialspecificationsheet` VALUES ('45#碳板                         ', '30m/m                         ', 'B020702           ', 'kg    ', '0', '1.28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('五金材料                        ', '                              ', 'B03               ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('紧固件                          ', '                              ', 'B0301             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', '                              ', 'B030101', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M3×16                        ', 'B03010101         ', '只    ', '0', '0.01', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M4×30                        ', 'B03010102         ', '只    ', '0', '0.01', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M4×40                        ', 'B03010103         ', '只    ', '0', '0.02', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M4.5×60                      ', 'B03010104         ', '只    ', '0', '0.15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('胶木螺丝                        ', '?                             ', 'B03010105         ', '只    ', '0', '0.18', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M4×50                        ', 'B03010106         ', '只    ', '0', '0.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M5×50                        ', 'B03010107         ', '只    ', '0', '0.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M5×40                        ', 'B03010108         ', '只    ', '0', '0.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木螺丝                          ', 'M3.5×25                      ', 'B03010109         ', '      ', '0', '0.02', '0');
INSERT INTO `materialspecificationsheet` VALUES ('其它                            ', '                              ', 'B030102', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铜鼻螺丝                        ', '?                             ', 'B03010201         ', '只    ', '0', '27.35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('自攻螺丝                        ', 'M4×20                        ', 'B03010202         ', '只    ', '0', '0.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌元头脚钉                  ', 'M16×160                      ', 'B03010203         ', '只    ', '0', '2.52', '0');
INSERT INTO `materialspecificationsheet` VALUES ('自攻螺丝                        ', 'M4×30                        ', 'B03010204         ', '百只  ', '0', '13', '0');
INSERT INTO `materialspecificationsheet` VALUES ('三角螺丝                        ', 'M8                            ', 'B03010205         ', '只    ', '0', '1.71', '0');
INSERT INTO `materialspecificationsheet` VALUES ('三角螺丝                        ', 'M10×25                       ', 'B03010206         ', '只    ', '0', '2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆头自攻螺丝                    ', 'M3×6                         ', 'B03010207         ', '千只  ', '0', '2.24', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆头自攻螺丝                    ', 'M3×10                        ', 'B03010208         ', '千只  ', '0', '8.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('圆头自攻螺丝                    ', 'M4×14                        ', 'B03010209         ', '只    ', '0', '0.06', '0');
INSERT INTO `materialspecificationsheet` VALUES ('沉头螺丝                        ', 'M2×5                         ', 'B03010210         ', '千只  ', '0', '15.71', '0');
INSERT INTO `materialspecificationsheet` VALUES ('平机螺丝                        ', '                              ', 'B030103', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('平机螺丝                        ', 'M4×20                        ', 'B03010301         ', '只    ', '0', '0.01', '0');
INSERT INTO `materialspecificationsheet` VALUES ('平机螺丝                        ', 'M6×25                        ', 'B03010302         ', '只    ', '0', '0.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('平机螺丝                        ', 'M10×35                       ', 'B03010303         ', '只    ', '0', '0.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('平机螺丝                        ', 'M5×15                        ', 'B03010304         ', '只    ', '0', '0.01', '0');
INSERT INTO `materialspecificationsheet` VALUES ('平机螺丝                        ', 'M8×10                        ', 'B03010305         ', '只    ', '0', '0.12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('平机螺丝                        ', 'M8×25                        ', 'B03010306         ', '只    ', '1400', '0.07', '100.5');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', '                              ', 'B030104', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'M10×80                       ', 'B03010401         ', '只    ', '10', '0.9', '9');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'M10×100                      ', 'B03010402         ', '只    ', '0', '0.51', '0');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'M16×150                      ', 'B03010403         ', '只    ', '0', '2.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'M12×70                       ', 'B03010404         ', '只    ', '4', '0.94', '3.76');
INSERT INTO `materialspecificationsheet` VALUES ('塑料膨胀螺丝                    ', 'φ6                           ', 'B03010405         ', '只    ', '0', '0.09', '0');
INSERT INTO `materialspecificationsheet` VALUES ('塑料膨胀螺丝                    ', 'φ8                           ', 'B03010406         ', '只    ', '0', '0.04', '0');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'φ8                           ', 'B03010407         ', '只    ', '0', '0.69', '0');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'φ6×60                       ', 'B03010408         ', '只    ', '0', '0.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'M12×150                      ', 'B03010409         ', '只    ', '0', '1.6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('膨胀螺丝                        ', 'M8×60                        ', 'B03010410         ', '只    ', '0', '0.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽芯铝铆钉                      ', '                              ', 'B030105', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽芯铝铆钉                      ', 'M4×13                        ', 'B03010501         ', '只    ', '8000', '0.04', '355');
INSERT INTO `materialspecificationsheet` VALUES ('抽芯铝铆钉                      ', 'Φ2.2×0.1                    ', 'B03010502         ', '只    ', '0', '0.03', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽芯铝铆钉                      ', '3*5                           ', 'B03010503         ', 'kg    ', '0', '47.26', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽芯铝铆钉                      ', '5*13                          ', 'B03010504         ', '千只  ', '0', '40', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽芯铝铆钉                      ', '4*16                          ', 'B03010505         ', '盒    ', '0', '18', '0');
INSERT INTO `materialspecificationsheet` VALUES ('抽芯铝铆钉                      ', '5×20                         ', 'B03010506         ', '盒    ', '0', '28', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', '                              ', 'B030106', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M5×25                        ', 'B03010601         ', '百只  ', '0', '3', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M5×35                        ', 'B03010602         ', '百只  ', '0', '5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M5×40                        ', 'B03010603         ', '百只  ', '0', '5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M6×20                        ', 'B03010604         ', '百只  ', '88', '3.08', '290.4');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M6×25                        ', 'B03010605         ', '百只  ', '0', '9.06', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M6×30                        ', 'B03010606         ', '百只  ', '0', '5.05', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M6×35                        ', 'B03010607         ', '百只  ', '0', '5.05', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M8×16                        ', 'B03010608         ', '百只  ', '50', '7.97', '398.5');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M8×20                        ', 'B03010609         ', '百只  ', '60', '8.25', '495');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M8×25                        ', 'B03010610         ', '百只  ', '0', '8.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('六角螺丝                        ', 'M8×30                        ', 'B03010611         ', '百只  ', '44', '9', '396');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', '                              ', 'B030107', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', 'M16×300                      ', 'B03010701         ', '只    ', '0', '3.81', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', 'M12×35                       ', 'B03010702         ', '只    ', '0', '0.09', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', 'M12×60                       ', 'B03010703         ', '只    ', '0', '0.83', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', 'M14×65                       ', 'B03010704         ', '只    ', '0', '0.88', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', 'M16×220                      ', 'B03010705         ', '只    ', '0', '2.6', '0');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', 'M16×35                       ', 'B03010706         ', '只    ', '250', '1.1', '275');
INSERT INTO `materialspecificationsheet` VALUES ('热镀锌螺丝                      ', 'M16×45                       ', 'B03010707         ', '只    ', '250', '0.92', '310');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', '                              ', 'B030109', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', 'M6×25                        ', 'B03010901         ', '只    ', '0', '0.22', '0');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', 'M8×25                        ', 'B03010902         ', '只    ', '10', '0.11', '1.08');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', 'M10×80                       ', 'B03010903         ', '只    ', '0', '0.87', '0');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', 'M12×30                       ', 'B03010904         ', '只    ', '134', '0.6', '80.4');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', 'M12×55                       ', 'B03010905         ', '只    ', '0', '0.84', '0');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', 'M8×16                        ', 'B03010906         ', '只    ', '500', '0.12', '60');
INSERT INTO `materialspecificationsheet` VALUES ('内六角螺丝                      ', 'M10×40                       ', 'B03010907         ', '只    ', '20', '0.24', '9.6');
INSERT INTO `materialspecificationsheet` VALUES ('焊接材料                        ', '                              ', 'B0302             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊接材料                        ', '                              ', 'B030201', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电焊条                          ', 'φ1.4                         ', 'B03020101         ', 'kg    ', '0', '5.8', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电焊条                          ', 'φ2.5                         ', 'B03020102         ', 'kg    ', '60', '4.27', '256.45');
INSERT INTO `materialspecificationsheet` VALUES ('电焊条                          ', 'φ3.2                         ', 'B03020103         ', 'kg    ', '200', '3.93', '786');
INSERT INTO `materialspecificationsheet` VALUES ('电焊条                          ', 'φ4                           ', 'B03020104         ', 'kg    ', '40', '4.27', '170.8');
INSERT INTO `materialspecificationsheet` VALUES ('铜焊条                          ', 'φ3                           ', 'B03020105         ', 'kg    ', '0', '28.26', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢焊丝                      ', '2.5                           ', 'B03020106         ', 'kg    ', '0', '23.33', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌铁丝                        ', '14#                           ', 'B03020107         ', 'kg    ', '0', '4.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌铁丝                        ', '8#                            ', 'B03020108         ', 'kg    ', '0', '3.42', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢焊条                      ', 'AB2-2.5                       ', 'B03020109         ', 'kg    ', '0', '46.15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钨极棒                          ', '?                             ', 'B03020110         ', '支    ', '40', '5', '200');
INSERT INTO `materialspecificationsheet` VALUES ('铜焊粉                          ', '?                             ', 'B03020111         ', '瓶    ', '0', '13.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢焊丝                      ', '1.00m/m                       ', 'B03020112         ', 'kg    ', '2.44', '16.92', '41.28');
INSERT INTO `materialspecificationsheet` VALUES ('焊接器具                        ', '                              ', 'B030202', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电焊钳                          ', '500A                          ', 'B03020201         ', '把    ', '0', '12.82', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电焊钳                          ', '300A                          ', 'B03020202         ', '把    ', '0', '11.54', '0');
INSERT INTO `materialspecificationsheet` VALUES ('焊枪                            ', 'H01-6                         ', 'B03020203         ', '把    ', '0', '34.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('等离子割嘴瓷套                  ', '?                             ', 'B03020204         ', '只    ', '20', '4.13', '82.68');
INSERT INTO `materialspecificationsheet` VALUES ('焊嘴                            ', 'H01-6  2号                    ', 'B03020205         ', '只    ', '2', '4.47', '8.93');
INSERT INTO `materialspecificationsheet` VALUES ('割嘴                            ', 'G01-30                        ', 'B03020206         ', '只    ', '3', '3.04', '9.12');
INSERT INTO `materialspecificationsheet` VALUES ('机床附件                        ', '                              ', 'B0303             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钻头套                          ', '2-3                           ', 'B030301           ', '只    ', '1', '17.6', '17.6');
INSERT INTO `materialspecificationsheet` VALUES ('钻头夹                          ', 'HOTS3-16                      ', 'B030302           ', '只    ', '2', '24', '48');
INSERT INTO `materialspecificationsheet` VALUES ('钻轧头                          ', 'JS13m/m                       ', 'B030303           ', '只    ', '0', '40.43', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钻轧头钥匙                      ', '?                             ', 'B030304           ', '只    ', '10', '8', '38.5');
INSERT INTO `materialspecificationsheet` VALUES ('螺纹钻夹头                      ', '10m/m                         ', 'B030305           ', '只    ', '2', '24.06', '48.11');
INSERT INTO `materialspecificationsheet` VALUES ('钻轧头                          ', '6m/m                          ', 'B030306           ', '只    ', '0', '24', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钻夹头连接杆                    ', '4＃                           ', 'B030307           ', '支    ', '0', '21.37', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钻夹头连接杆                    ', '2〃                           ', 'B030308           ', '只    ', '0', '15.4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钻夹头                          ', '1.5-13m/m                     ', 'B030309           ', '只    ', '1', '45', '45');
INSERT INTO `materialspecificationsheet` VALUES ('钻夹头连杆                      ', '3#                            ', 'B030310           ', '支    ', '0', '17', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钻夹头                          ', 'JS10                          ', 'B030311           ', '只    ', '0', '15', '0');
INSERT INTO `materialspecificationsheet` VALUES ('起重器材及液压机具              ', '                              ', 'B0304             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钢丝绳                          ', '?                             ', 'B030401           ', '米    ', '0', '14', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钢丝夹头                        ', 'Φ6                           ', 'B030402           ', '只    ', '0', '0.65', '0');
INSERT INTO `materialspecificationsheet` VALUES ('液压搬运车                      ', '2T                            ', 'B030403           ', '台    ', '0', '1008.55', '0');
INSERT INTO `materialspecificationsheet` VALUES ('千斤顶                          ', '20T                           ', 'B030404           ', '台    ', '0', '162', '0');
INSERT INTO `materialspecificationsheet` VALUES ('液压开孔器                      ', 'SYK-8型                       ', 'B030405           ', '把    ', '0', '555.56', '0');
INSERT INTO `materialspecificationsheet` VALUES ('翻斗车                          ', '？                            ', 'B030406           ', '      ', '0', '210', '0');
INSERT INTO `materialspecificationsheet` VALUES ('手动葫芦                        ', '1.5T                          ', 'B030407           ', '台    ', '0', '0.44', '0');
INSERT INTO `materialspecificationsheet` VALUES ('常用手工具                      ', '                              ', 'B0305             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('木榔头                          ', '？                            ', 'B030501           ', '只    ', '3', '4.64', '13.92');
INSERT INTO `materialspecificationsheet` VALUES ('扁榔头(小铁锤)                  ', '？                            ', 'B030502           ', '只    ', '9', '3.84', '92.34');
INSERT INTO `materialspecificationsheet` VALUES ('电工刀                          ', '？                            ', 'B030503           ', '把    ', '6', '8.46', '70.74');
INSERT INTO `materialspecificationsheet` VALUES ('压线钳                          ', '？                            ', 'B030504           ', '把    ', '0', '34.19', '0');
INSERT INTO `materialspecificationsheet` VALUES ('斜口钳                          ', '？                            ', 'B030505           ', '把    ', '10', '1.78', '120.4');
INSERT INTO `materialspecificationsheet` VALUES ('钢丝钳                          ', '？                            ', 'B030506           ', '把    ', '6', '25.43', '101.72');
INSERT INTO `materialspecificationsheet` VALUES ('尖嘴钳                          ', '？                            ', 'B030507           ', '把    ', '10', '10.1', '136.04');
INSERT INTO `materialspecificationsheet` VALUES ('钳工工具                        ', '                              ', 'B0306             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铝板锉                          ', '10号                          ', 'B030601           ', '把    ', '0', '13', '0');
INSERT INTO `materialspecificationsheet` VALUES ('半元锉                          ', '12号                          ', 'B030602           ', '把    ', '0', '10.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('中扁锉                          ', '12号                          ', 'B030603           ', '把    ', '0', '6.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('元锉                            ', '3号                           ', 'B030604           ', '把    ', '0', '4', '0');
INSERT INTO `materialspecificationsheet` VALUES ('台板锉                          ', '？                            ', 'B030605           ', '把    ', '0', '23.27', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钢锯架                          ', '？                            ', 'B030606           ', '把    ', '0', '8.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('测量工具                        ', '                              ', 'B0308             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('钢直尺                          ', '500mm                         ', 'B030801           ', '把    ', '0', '7.69', '0');
INSERT INTO `materialspecificationsheet` VALUES ('角尺                            ', '300mm                         ', 'B030802           ', '把    ', '0', '0.17', '0');
INSERT INTO `materialspecificationsheet` VALUES ('卷尺                            ', '20m                           ', 'B030803           ', '把    ', '0', '26.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('卷尺                            ', '5m                            ', 'B030804           ', '把    ', '0', '12', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电笔                            ', '？                            ', 'B030805           ', '支    ', '1', '91.78', '91.78');
INSERT INTO `materialspecificationsheet` VALUES ('钢直尺                          ', '1000mm                        ', 'B030806           ', '把    ', '1', '0.02', '25.66');
INSERT INTO `materialspecificationsheet` VALUES ('电动工具                        ', '                              ', 'B0309             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('冲击电锤                        ', 'DH-25                         ', 'B030901           ', '只    ', '0', '2863.25', '0');
INSERT INTO `materialspecificationsheet` VALUES ('磨光机                          ', '100型                         ', 'B030902           ', '只    ', '0', '358.97', '0');
INSERT INTO `materialspecificationsheet` VALUES ('磨光机                          ', '125型                         ', 'B030903           ', '只    ', '0', '729.76', '0');
INSERT INTO `materialspecificationsheet` VALUES ('电钻                            ', 'JLZ-10                        ', 'B030904           ', '只    ', '0', '405.98', '0');
INSERT INTO `materialspecificationsheet` VALUES ('日立调速手电钻                  ', 'FD10BA                        ', 'B030905           ', '台    ', '0', '405.98', '0');
INSERT INTO `materialspecificationsheet` VALUES ('门窗附件                        ', '                              ', 'B0310             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('开关锁(无柄)                    ', '401                           ', 'B031001           ', '把    ', '0', '4.92', '0');
INSERT INTO `materialspecificationsheet` VALUES ('开关锁(短柄)                    ', '303                           ', 'B031002           ', '把    ', '49', '6.39', '313.11');
INSERT INTO `materialspecificationsheet` VALUES ('开关锁(长柄)                    ', '301                           ', 'B031003           ', '把    ', '0', '5.88', '0');
INSERT INTO `materialspecificationsheet` VALUES ('开关锁(按钮无钥)                ', '504                           ', 'B031004           ', '把    ', '0', '8.92', '0');
INSERT INTO `materialspecificationsheet` VALUES ('开关锁(按钮)                    ', '506                           ', 'B031005           ', '把    ', '0', '7.9', '0');
INSERT INTO `materialspecificationsheet` VALUES ('插肖                            ', '4\"                            ', 'B031006           ', '只    ', '100', '0.52', '52');
INSERT INTO `materialspecificationsheet` VALUES ('箱扣                            ', '3号                           ', 'B031007           ', '只    ', '0', '1', '0');
INSERT INTO `materialspecificationsheet` VALUES ('合页                            ', '2\"                            ', 'B031008           ', '付    ', '180', '0.41', '73.8');
INSERT INTO `materialspecificationsheet` VALUES ('合页                            ', '3\"                            ', 'B031009           ', '付    ', '0', '1.71', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铰链                            ', 'Ф8                           ', 'B031010           ', '付    ', '0', '0.16', '0');
INSERT INTO `materialspecificationsheet` VALUES ('管路附件                        ', '                              ', 'B0311             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌弯头                        ', 'φ48                          ', 'B031101           ', '只    ', '0', '3', '0');
INSERT INTO `materialspecificationsheet` VALUES ('镀锌弯头                        ', 'φ42                          ', 'B031102           ', '只    ', '0', '1.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('水笼头                          ', '1.5寸                         ', 'B031103           ', '只    ', '3', '6.66', '19.99');
INSERT INTO `materialspecificationsheet` VALUES ('堵头                            ', 'φ15                          ', 'B031104           ', '只    ', '0', '2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('闸阀                            ', 'φ1.5                         ', 'B031105           ', '只    ', '0', '10', '0');
INSERT INTO `materialspecificationsheet` VALUES ('生料带                          ', '?                             ', 'B031106           ', '只    ', '0', '1.5', '0');
INSERT INTO `materialspecificationsheet` VALUES ('其它器材                        ', '                              ', 'B0312             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('控制保护板                      ', '360×40                       ', 'B031201           ', '块    ', '0', '8.62', '0');
INSERT INTO `materialspecificationsheet` VALUES ('GGD柜体                         ', '800×600×2200                ', 'B031202           ', '只    ', '0', '1263.98', '0');
INSERT INTO `materialspecificationsheet` VALUES ('GGD柜体                         ', '1000×600×2200               ', 'B031203           ', '只    ', '0', '1215.35', '0');
INSERT INTO `materialspecificationsheet` VALUES ('下母线夹安装梁                  ', '430                           ', 'B031204           ', '根    ', '0', '8.55', '0');
INSERT INTO `materialspecificationsheet` VALUES ('安装梁                          ', '940                           ', 'B031205           ', '根    ', '0', '16.24', '0');
INSERT INTO `materialspecificationsheet` VALUES ('安装梁                          ', '740                           ', 'B031206           ', '根    ', '0', '13.68', '0');
INSERT INTO `materialspecificationsheet` VALUES ('门窗附件（二）                  ', '                              ', 'B0313             ', '      ', '0', '0', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铅封螺丝                        ', '8×25                         ', 'B031301           ', '只    ', '0', '0.38', '0');
INSERT INTO `materialspecificationsheet` VALUES ('不锈钢合页                      ', '?                             ', 'B031302           ', '付    ', '0', '3.42', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铁铅封罗丝                      ', '10×148                       ', 'B031303           ', '只    ', '0', '1.2', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铁铅封罗丝                      ', '10×145                       ', 'B031304           ', '只    ', '0', '2.74', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铁罗丝杆                        ', '10×165                       ', 'B031305           ', '支    ', '0', '3.16', '0');
INSERT INTO `materialspecificationsheet` VALUES ('铁罗丝杆                        ', '10×148                       ', 'B031306           ', '支    ', '0', '3.16', '0');

-- ----------------------------
-- Table structure for outboundtable
-- ----------------------------
DROP TABLE IF EXISTS `outboundtable`;
CREATE TABLE `outboundtable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库表的记录号，用于标识记录，具有唯一性',
  `checkId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '票据单号，多条记录的票据单号可以一致，因为会有一次性出库多种材料的情况',
  `businessType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务类型，外部出库、退回',
  `warehouseNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库号，字符类型，仓库名一般不会',
  `itemNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货号',
  `transactionNumber` int(11) NOT NULL DEFAULT 0 COMMENT '交易数量',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位',
  `averagePrice` double(10, 2) NOT NULL COMMENT '加权平均价',
  `totalInventoryPrice` double(10, 2) NOT NULL COMMENT '总价',
  `buyersNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '采购商号',
  `buyersName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '采购负责人',
  `transactionDate` timestamp(0) NOT NULL DEFAULT current_timestamp(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '交易日期',
  `done` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否已完成出库：需要仓库经理确认，默认未完成（0）',
  `warehouseKeeperNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库管理人员职工号（看守仓库的）',
  `warehouseManagerNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库经理职工号（管理仓管人员的）',
  `checkDate` timestamp(0) NULL DEFAULT NULL COMMENT '管理员确认日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of outboundtable
-- ----------------------------
INSERT INTO `outboundtable` VALUES (4, 'er', 'uyk', 'uil,', 'rtfb', 0, 'tyj', 456.00, 456.00, '678', '24', '2023-03-15 14:43:47', 12, '523', '45', '2023-03-15 14:43:44');

-- ----------------------------
-- Table structure for partnerinfosheet
-- ----------------------------
DROP TABLE IF EXISTS `partnerinfosheet`;
CREATE TABLE `partnerinfosheet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `companyName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公司名',
  `companyNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司号',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `latestCooperateDay` datetime(0) NULL DEFAULT NULL COMMENT '最近一次的合作日期',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主营业务',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `responsiblePerson` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公司负责人',
  `warehouseManagerNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '我方对外负责人员工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of partnerinfosheet
-- ----------------------------

-- ----------------------------
-- Table structure for pickingtable
-- ----------------------------
DROP TABLE IF EXISTS `pickingtable`;
CREATE TABLE `pickingtable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '领料调入的记录号，用于标识记录，具有唯一性',
  `checkId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '票据单号，多条记录的票据单号可以一致，因为会有一次性入库多种材料的情况，与',
  `businessType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务类型，内部领料调入，若为负数则表示被退回',
  `warehouseNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库号，字符类型，仓库名一般不会',
  `itemNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货号',
  `transactionNumber` int(11) NOT NULL DEFAULT 0 COMMENT '交易数量',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '单位',
  `averagePrice` double(10, 2) NOT NULL COMMENT '加权平均价',
  `totalInventoryPrice` double(10, 2) NOT NULL COMMENT '总价',
  `vendorNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '供应部门',
  `vendorName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '供应部门负责人',
  `transactionDate` timestamp(0) NOT NULL DEFAULT current_timestamp(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '交易日期',
  `done` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否已完成调入：需要仓库经理确认，默认未完成（0）',
  `warehouseKeeperNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库管理人员职工号（看守仓库的）',
  `warehouseManagerNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库经理职工号（管理仓管人员的）',
  `checkDate` timestamp(0) NULL DEFAULT NULL COMMENT '管理员确认日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pickingtable
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cargoId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货号',
  `cargoName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货物名',
  `cargoNumber` int(11) NOT NULL DEFAULT 0 COMMENT '货物数量',
  `cargoAvePrice` decimal(10, 2) NOT NULL COMMENT '单价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, 'A12', '扳手', 8, 15.00);
INSERT INTO `test` VALUES (2, 'B13', '螺丝刀', 6, 9.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wmc', 'wmc123', '2023-02-19');
INSERT INTO `user` VALUES (2, 'wmc', 'wmc123', '2023-02-19');

-- ----------------------------
-- Table structure for warehouseinfotable
-- ----------------------------
DROP TABLE IF EXISTS `warehouseinfotable`;
CREATE TABLE `warehouseinfotable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '4',
  `warehouseManagerNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库负责人员工号',
  `warehouseNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库号',
  `warehouseName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库名',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouseinfotable
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
