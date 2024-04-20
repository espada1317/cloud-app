package md.utm.cloudapp.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Random
import mu.KotlinLogging

@RestController
class MainController {

    private val logger = KotlinLogging.logger {}

    @GetMapping("/")
    fun main(): String {
        val random = Random()
        val randomNumber = random.nextInt()

        logger.info { "Generated random number: $randomNumber" }

        return "Hello World! seed: $randomNumber"
    }
}
