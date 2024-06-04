package com.project.kotlin_challenge.lesson_2

/**
 * Zadanie 1
 *
 * Mamy listę produktów w sklepie internetowym. Każdy produkt jest reprezentowany przez
 * klasę `Product` z polami `nazwa`,`cena` i `kategoria`.
 *
 * 1. Stwórz nową listę zawierającą nazwy wszystkich produktów z kategorii "Odzież".
 * 2. Stwórz nową listę zawierającą produkty, których cena jest wyższa niż 100 zł.
 * 3. Oblicz sumę cen wszystkich produktów z kategorii "Elektronika".
 *
 */

data class Product(val name: String, val price: Double, val category: String)

val products = listOf(
    Product("Koszulka", 49.99, "Odzież"),
    Product("Smartfon", 999.99, "Elektronika"),
    Product("Książka", 29.99, "Książki"),
    Product("Buty", 89.99, "Odzież"),
    Product("Laptop", 1499.99, "Elektronika"),
    Product("Kurtka", 149.99, "Odzież")
)

fun main() {
    first()
    second()
    third()
    thirdAlternative()
}

fun first() {
    val listOfClothes = products.filter { it.category == "Odzież" }
    println("Zad1. $listOfClothes")
}

fun second() {
    val listOfExpensiveProducts = products.filter { it.price > 100 }
    println("Zad2. $listOfExpensiveProducts")
}

fun third() {
    val listOfElectronics = products.filter { it.category == "Elektronika" }
    var priceSummary = 0.0
    listOfElectronics.map { it.price }.forEach {
        priceSummary += it
    }
    println("Zad3. $priceSummary")
}

/**
 * zad 3. bez użycia .forEach
 */
fun thirdAlternative() {
    val listOfElectronics = products.filter { it.category == "Elektronika" }
    val priceSummary = listOfElectronics.sumOf { it.price }
    println("Zad3. $priceSummary")
}

