package com.mat.benevolat

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@SpringBootTest(classes = [IntegrationTestConfiguration::class])
@ActiveProfiles("test")
@ContextConfiguration(classes = [IntegrationTestConfiguration::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
abstract class AbstractIntegrationTest {
}
