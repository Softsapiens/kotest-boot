package softsapiens.coding.testing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

data class User(val Id: Int?, val Name: String)

@Component
class UserService {
    fun createUser() = run { User(1, "John") }

}