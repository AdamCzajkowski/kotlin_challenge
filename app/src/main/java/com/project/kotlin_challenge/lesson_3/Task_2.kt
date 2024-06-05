package com.project.kotlin_challenge.lesson_3

/**
 * ## Zadanie 2: Sealed class i sealed interface
 *
 * Wyobraź sobie, że tworzysz aplikację do zarządzania zamówieniami w sklepie internetowym. Zaimplementuj następujące struktury:
 *
 * 1. Stwórz`sealed class``Order`z następującymi klasami potomnymi:
 *     - `Confirmed`z polem`orderNumber`
 *     - `Cancelled`z polem`reason`
 * 2. Stwórz`sealed interface``Payment`z następującymi implementacjami:
 *     - `Cash`(bez dodatkowych pól)
 *     - `Card`z polem`cardNumber`
 * 3. Dodaj pole`payment`typudo klasy`Order`.
 * 4. Stwórz funkcję`processOrder`, która przyjmuje instancję`Order`i wykonuje odpowiednie działania w zależności od typu zamówienia i płatności. Na przykład, dla`Order.Confirmed`z płatnością`Cash`, wypisz "Zamówienie potwierdzone, płatność gotówką".
 * 5. Stwórz kilka instancji`Order`z różnymi typami i płatnościami, a następnie wywołaj funkcję`processOrder`dla każdego z nich.
 */

sealed class Order(val payment: Payment) {
    class Confirmed(val orderNumber: String, payment: Payment) : Order(payment)
    class Cancelled(val reason: String, payment: Payment) : Order(payment)
}

sealed interface Payment {
    object Cash : Payment
    data class Card(val cardNumber: String) : Payment
}

fun processOrder(order: Order) =
    when (order) {
        is Order.Confirmed -> {
            val paymentDetails = when (order.payment) {
                is Payment.Cash -> "gotówka"
                is Payment.Card -> "karta o numerze ${order.payment.cardNumber}"
            }
            println("Zamówienie potwierdzone, sposób płatności: $paymentDetails")
        }

        is Order.Cancelled -> {
            val paymentDetails = when (order.payment) {
                is Payment.Cash -> "gotówka"
                is Payment.Card -> "karta o numerze ${order.payment.cardNumber}"
            }
            println("Zamówienie anulowane, sposób płatności: $paymentDetails, powód anulacji: ${order.reason}")
        }
    }

val listOfOrders = listOf(
    Order.Confirmed("0000001", Payment.Cash),
    Order.Confirmed("0000002", Payment.Card("5678 **** **** 4132")),
    Order.Cancelled("rezygnacja z zakupu", Payment.Cash),
    Order.Cancelled("brak środków na koncie", Payment.Card("2315 **** **** 1311"))
)


fun main() {
    listOfOrders.forEach {
        processOrder(it)
    }
}