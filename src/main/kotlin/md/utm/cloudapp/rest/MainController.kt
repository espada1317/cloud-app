package md.utm.cloudapp.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Random

@RestController
class MainController {

    @GetMapping("/")
    fun main(): String {
        val random = Random()
        val randomNumber = random.nextInt()
        return "Hello World! seed: $randomNumber"
    }
}
