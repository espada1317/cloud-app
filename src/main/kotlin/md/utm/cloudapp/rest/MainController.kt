package md.utm.cloudapp.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Random
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

@RestController
class MainController {

    private val logger = KotlinLogging.logger {}

    @Autowired
    private lateinit var env: Environment

    @GetMapping("/")
    fun main(): String {

        val containerName = env.getProperty("HOSTNAME")

        logger.info { "Container Name: $containerName" }

        val random = Random()
        val randomNumber = random.nextInt()

        logger.info { "Generated random number: $randomNumber" }

        return "Hello World! From container: $containerName with random generated number: $randomNumber\n"
    }
}
