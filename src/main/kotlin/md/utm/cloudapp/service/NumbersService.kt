package md.utm.cloudapp.service

import md.utm.cloudapp.entity.Numbers
import md.utm.cloudapp.repository.NumbersRepository
import org.springframework.stereotype.Service

@Service
class NumbersService(private val numbersRepository: NumbersRepository) {

    fun getNumbers(): List<Numbers> =
        numbersRepository.findAll()

    fun addNumbers(task: Numbers) {
        numbersRepository.save(task)
    }
}