package com.mat.benevolat

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.mat.benevolat"])
@EnableAutoConfiguration
class IntegrationTestConfiguration {
}
