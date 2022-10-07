package com.yedam.quiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.yedam.quiz.**.mapper")
public class MybatisConfig {

}
