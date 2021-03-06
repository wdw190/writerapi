CREATE TABLE `tb_systtem_config` (
  `id` varchar(64) NOT NULL,
  `axcs` int(11) DEFAULT NULL COMMENT 'A箱串数',
  `bxcs` int(11) DEFAULT NULL COMMENT 'B箱串数',
  `bcdl` float DEFAULT NULL COMMENT '标称电量/KWH',
  `dypt` float DEFAULT NULL COMMENT '电压平台/V',
  `bcrl` float DEFAULT NULL COMMENT '标称容量/Ah',
  `dxzhfs1` int(11) DEFAULT NULL COMMENT '电箱组合方式1',
  `dxzhfs2` varchar(8) DEFAULT NULL COMMENT '电箱组合方式2',
  `dxzhfs3` int(11) DEFAULT NULL COMMENT '电箱组合方式3',
  `dxzhfs4` varchar(8) DEFAULT NULL COMMENT '电箱组合方式4',
  `xtzc` int(11) DEFAULT NULL COMMENT '系统总串',
  `xtzb` int(11) DEFAULT NULL COMMENT '系统总并',
  `xtxs` int(11) DEFAULT NULL COMMENT '系统箱数',
  `sycxcode` varchar(8) DEFAULT NULL COMMENT '适用车型代码',
  `sycxdesc` varchar(32) DEFAULT NULL COMMENT '适用车型描述',
  `dxnlmd` float DEFAULT NULL COMMENT '典型能量密度wh/kg',
  `axzl` float DEFAULT NULL COMMENT 'A箱质量(不含PTC)Kg',
  `bxzl` float DEFAULT NULL COMMENT 'B箱质量(不含PTC)Kg',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

