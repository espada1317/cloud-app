package md.utm.cloudapp.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MainController() {

    @Autowired
    private lateinit var env: Environment

    @GetMapping("/hello")
    fun main(): String {

        val containerName = env.getProperty("HOSTNAME")

        val random = Random()
        val randomNumber = random.nextInt()

        return "Hello World!<br>From container: $containerName" +
                "<br>With random generated number: $randomNumber"
    }
}
