CREATE TABLE `pic` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` varchar(100) NOT NULL DEFAULT '',
  `url` varchar(100) NOT NULL DEFAULT '',
  `remarks` varchar(200) NOT NULL DEFAULT '',
  `category` int(10) NOT NULL DEFAULT '0' COMMENT '0-其他，1-恐怖，2-搞笑，3-美女..',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '该条信息插入的时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `source` varchar(20) NOT NULL DEFAULT ' ' COMMENT '爬虫来源',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0-无效，1-有效',
  `my_url` varchar(100) NOT NULL DEFAULT '' COMMENT '后期使用',
  `origin` varchar(500) NOT NULL DEFAULT '' COMMENT '来源',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_url` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `gid` int(10) NOT NULL DEFAULT '0' COMMENT 'gif id',
  `comment` varchar(500) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '评论内容',
  `user` varchar(20) NOT NULL DEFAULT '0' COMMENT '评论发布人标示',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论发布时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '显示状态0删除1显示',
  `is_cream` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是精华',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;