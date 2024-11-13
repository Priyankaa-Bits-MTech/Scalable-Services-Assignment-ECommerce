package com.ecommerce.order.entity

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime


@Entity
class OrderData: Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val orderId: Int? = null

    @JsonSerialize(using = LocalDateTimeSerializer::class)
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    private val orderDate: LocalDateTime? = null

    private val orderDesc: String? = null

    private val orderFee: Double? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private val cart: Cart? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}