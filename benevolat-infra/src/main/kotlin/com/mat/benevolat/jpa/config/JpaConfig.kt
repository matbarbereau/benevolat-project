package com.mat.benevolat.jpa.config

import com.mat.benevolat.config.YamlPropertySourceFactory
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories("com.mat.benevolat.jpa.adapters")
@PropertySource(value = ["classpath:jpa.yml"], factory = YamlPropertySourceFactory::class)
class JpaConfig {
}
