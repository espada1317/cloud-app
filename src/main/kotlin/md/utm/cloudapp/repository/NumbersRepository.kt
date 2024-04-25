package md.utm.cloudapp.repository

import md.utm.cloudapp.entity.Numbers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NumbersRepository: JpaRepository<Numbers, Long> {
}