package edu.pku.springbootseed.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisConfig
 *
 * @author wangyc
 * @since 2019/11/10
 */
@Configuration
@MapperScan(value = {"edu.pku.springbootseed.**.dao*"})
public class MyBatisConfig {
}

