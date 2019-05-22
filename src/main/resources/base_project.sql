SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role_id` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `admin_role_menu` VALUES ('', NULL, NULL);
INSERT INTO `admin_role_menu` VALUES ('22131231231231231', '0822fae8-cd7e-4837-9461-ef125ff01e01', '1');
COMMIT;

-- ----------------------------
-- Table structure for admin_roles
-- ----------------------------
DROP TABLE IF EXISTS `admin_roles`;
CREATE TABLE `admin_roles` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色id',
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `display_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roles_name_unique` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin_roles
-- ----------------------------
BEGIN;
INSERT INTO `admin_roles` VALUES ('0822fae8-cd7e-4837-9461-ef125ff01e01', 'vipAdmin', '超级管理员', '拥有除权限管理外的一切权限', '2019-04-26 15:33:39', '2019-04-26 15:33:39');
INSERT INTO `admin_roles` VALUES ('79f2144c-bd01-4193-8905-376d0df0b671', 'develop', '开发者', '开发人员账号', '2019-04-26 18:07:52', '2019-04-26 18:07:52');
INSERT INTO `admin_roles` VALUES ('bb85953a-ad51-4e75-adb4-9699f5e7eb84', 'SuperAdmin', '系统管理员', '拥有一切权限', '2019-04-26 15:35:04', '2019-04-26 15:35:04');
COMMIT;

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
  `admin_user_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员id',
  `role_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色id',
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `admin_user_roles_role_id_foreign` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
BEGIN;
INSERT INTO `admin_user_role` VALUES ('e6eeb35f-1b98-44e6-918a-a52fdcbe8a02', '0822fae8-cd7e-4837-9461-ef125ff01e01', '80566724-695c-11e9-bfa9-fa163e5fe0b6');
COMMIT;

-- ----------------------------
-- Table structure for admin_users
-- ----------------------------
DROP TABLE IF EXISTS `admin_users`;
CREATE TABLE `admin_users` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员id',
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mobile` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `is_super` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否超级管理员',
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `status` int(11) DEFAULT '0' COMMENT '管理员状态',
  `city` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '城市，用于城市管理员',
  `parking_id` int(11) DEFAULT NULL COMMENT '停车场id，用于停车场管理员',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `admin_users_email_unique` (`mobile`),
  UNIQUE KEY `admin_users_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin_users
-- ----------------------------
BEGIN;
INSERT INTO `admin_users` VALUES ('e6eeb35f-1b98-44e6-918a-a52fdcbe8a02', 'admin', '111', 'acb45fb80df31a6de8ee138f71bd51b5', 0, NULL, '2019-04-28 10:22:42', '2019-05-22 09:28:30', '2019-04-16 16:11:25', 0, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for common_file
-- ----------------------------
DROP TABLE IF EXISTS `common_file`;
CREATE TABLE `common_file` (
  `id` varchar(50) NOT NULL,
  `data_id` varchar(50) NOT NULL,
  `file_name` varchar(50) NOT NULL DEFAULT '',
  `file_url` varchar(255) DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件 如 图片-文档';

-- ----------------------------
-- Records of common_file
-- ----------------------------
BEGIN;
INSERT INTO `common_file` VALUES ('2112', '3123', '111111', NULL, '2019-05-20 18:04:59', '2019-05-22 09:28:51', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sort_no` int(10) DEFAULT NULL COMMENT '排序序号',
  `menu_cn` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单中文名称',
  `menu_en` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单英文名称',
  `icon` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单图标',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级菜单id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0:未删除；1：已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('1', '/admin/adminManage', NULL, '管理员管理', NULL, NULL, 0, '2019-05-22 09:29:36', '2019-05-22 09:31:16', 0);
INSERT INTO `sys_menu` VALUES ('2', '/admin/adminList', NULL, '管理员列表', NULL, NULL, 1, '2019-05-22 09:29:39', '2019-05-22 09:30:38', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
