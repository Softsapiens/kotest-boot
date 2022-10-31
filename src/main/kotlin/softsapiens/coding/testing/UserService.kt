package softsapiens.coding.testing

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

data class User(val Id: Int?, val Name: String)

@Component
class UserService {

    val logger = LoggerFactory.getLogger(UserService::class.java)

    fun createUser() = run {
        logger.info("user created")
        User(1, "John")
    }

}