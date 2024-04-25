package md.utm.cloudapp.entity

import jakarta.persistence.*

@Entity
@Table(name = "numbers")
data class Numbers(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val number: Int = 0
)