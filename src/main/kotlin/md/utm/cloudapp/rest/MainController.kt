package md.utm.cloudapp.rest

import md.utm.cloudapp.entity.Numbers
import md.utm.cloudapp.service.NumbersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Random
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

@RestController
class MainController(private val numbersService: NumbersService) {

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

        val numbers = Numbers(null, randomNumber)
        numbersService.addNumbers(numbers)
        val allNumbers: List<Numbers> = numbersService.getNumbers()

        return "Hello World!<br>From container: $containerName<br>With random generated number: $randomNumber<br><br>All generated numbers from DB: $allNumbers"
    }
}
