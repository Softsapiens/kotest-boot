package softsapiens.coding.testing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestingBootApplication

fun main(args: Array<String>) {
	runApplication<TestingBootApplication>(*args)
}
