drop table if exists `users`;
drop table if exists `product`;
drop table if exists `orders`;
drop table if exists `order_items`;

-- # 用户表:用户id、名称、密码、手机号、身份证号、账户余额
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(16) NOT NULL COMMENT '用户名称',
  `password` varchar(16) NOT NULL COMMENT '用户密码',
  `phoneNumber` varchar(15) NOT NULL COMMENT '用户手机号',
  `identify_card` varchar(16) NOT NULL COMMENT '用户身份证号码',
  `balance` decimal(18,2) NOT NULL COMMENT '用户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 comment '用户表';

-- # 商品表：id、名称、描述、价格、重量、商品状态
CREATE TABLE IF NOT EXISTS `product` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '商品唯一标识符',
    `name` varchar(16) NOT NULL COMMENT '商品名称',
    `description` varchar(1024) NOT NULL COMMENT '商品描述',
    `price` decimal(18,2) NOT NULL COMMENT '商品价格',
    `weight` int NOT NULL  COMMENT '商品重量',
    `status` int NOT NULL COMMENT '商品状态',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 comment '用户表';

-- # 订单表:id、用户id、商品列表、订单状态、物流状态、总价、生成时间、更新时间
CREATE TABLE IF NOT EXISTS `orders` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '订单编号',
    `user_id` int NOT NULL COMMENT '下订单的用户标识',
    `status` int NOT NULL COMMENT '订单状态',
    `deliver_status` varchar(20) NOT NULL COMMENT '物流状态',
    `total_price` decimal(18,2) NOT NULL COMMENT '订单总额',
	`total_quantity` int NOT NULL COMMENT '商品总数',
    `create_time` datetime NOT NULL COMMENT '下单时间',
    `update_time` datetime NOT NULL COMMENT '订单最后变更时间',
    PRIMARY KEY (`id`),
	KEY `orders_user_id_index` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 comment '订单表';


CREATE TABLE IF NOT EXISTS `order_items` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '订单明细ID',
    `order_id` int NOT NULL COMMENT '订单ID',
    `product_id` int NOT NULL COMMENT '商品ID',
	`product_num` int NOT NULL COMMENT '商品数量',
    `create_time` datetime NOT NULL COMMENT '订单明细创建时间',
    `update_time` datetime NOT NULL COMMENT '订单明细最后变更时间',
    PRIMARY KEY (`id`),
	KEY `order_items_product_id_index` (`product_id`),
	KEY `order_items_order_id_index` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 comment '订单明细表';