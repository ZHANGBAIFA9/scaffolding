-- 主库 表示例
CREATE TABLE `test`.`stu` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(10) DEFAULT NULL,
    `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 未删除 默认，1已删除',
    `created_by` varchar(100) NOT NULL COMMENT '创建人：负责人',
    `created_at` datetime(6) DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
    `updated_by` varchar(100) DEFAULT NULL COMMENT '修改人',
    `updated_at` datetime(6) DEFAULT NULL COMMENT '修改时间',
    `last_updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)  COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='demo表';
-- dim 表示例
CREATE TABLE `test`.`stuu` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT,
     `name` varchar(10) DEFAULT NULL,
     `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 未删除 默认，1已删除',
     `created_by` varchar(100) NOT NULL COMMENT '创建人：负责人',
     `created_at` datetime(6) DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
     `updated_by` varchar(100) DEFAULT NULL COMMENT '修改人',
     `updated_at` datetime(6) DEFAULT NULL COMMENT '修改时间',
     `last_updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)  COMMENT '最后修改时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='demo表';