package softsapiens.coding.testing

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.WordSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.logcapture.assertion.ExpectedLoggingMessage.aLog
import org.logcapture.kotest.LogCaptureListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
class TestingBootApplicationTests {

	@Test
	fun contextLoads() {
	}

}
class MyTestSpec : FunSpec() {
	override fun extensions() = listOf(SpringExtension)


}

@ContextConfiguration(classes = [(UserService::class)])
class SpringAutowiredConstructorTest(service: UserService) : WordSpec({
}) {

	val logCaptureListener = LogCaptureListener()

	override fun extensions() = listOf(SpringExtension)

	init {
		listener(logCaptureListener)  // Add LogCaptureListener

		"SpringExtension" should {
			"have autowired the service" {
				service.createUser() shouldBe User(1, "John")
				logCaptureListener.logged(aLog().info().withMessage("user created"))
			}
		}
	}
}

class TestSpec : WordSpec({
	beforeTest {
		println("Starting a test $it")
	}
	afterTest { (test, result) ->
		println("Finished spec with result $result")
	}
	"this test" should {
		"be alive" {
			println("Johnny5 is alive!")
		}
	}
})

class LogCaptureListenerSpec : StringSpec({
	val logCaptureListener = LogCaptureListener()
	listener(logCaptureListener)  // Add LogCaptureListener

	val log: Logger = LoggerFactory.getLogger(LogCaptureListenerSpec::class.java)

	"verify log messages" {
		log.info("a message")

		logCaptureListener.logged(aLog().info().withMessage("a message"))
	}
})