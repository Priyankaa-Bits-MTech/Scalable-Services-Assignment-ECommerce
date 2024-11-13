package com.ecommerce.order.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable


@Entity
class Cart: Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val cartId: Int? = null

    private val userId: Int? = null

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    private val orders: Set<OrderData>? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}