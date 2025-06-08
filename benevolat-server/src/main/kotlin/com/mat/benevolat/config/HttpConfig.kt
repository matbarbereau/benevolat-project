package com.mat.benevolat.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource(value = ["classpath:server.yml"], factory = YamlPropertySourceFactory::class)
class HttpConfig {
}
