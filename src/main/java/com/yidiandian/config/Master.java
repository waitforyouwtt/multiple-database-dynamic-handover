package com.yidiandian.config;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/18 9:58
 * @Email: 15290810931@163.com
 */

/**
 * 特殊情况是某些情况下我们需要强制读主库，针对这种情况，
 * 我们定义一个主键，用该注解标注的就读主库。
 */
public @interface Master {
}
