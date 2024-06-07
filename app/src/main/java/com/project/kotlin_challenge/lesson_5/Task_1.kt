package com.project.kotlin_challenge.lesson_5

import com.project.kotlin_challenge.lesson_4.list

/**
 * Modelujemy odpowiedź z API.
 *
 * 1. Stwórz klasę generyczną`ApiResponse<`, która będzie reprezentować odpowiedź z API. Klasa ta powinna mieć następujące pola:
 *     - `totalCount: Int`- całkowita liczba elementów
 *     - `list: List`- generyczna lista obiektów
 * 2. Stwórz klasę`User`reprezentującą użytkownika z następującymi polami:
 *     - `id: Int`
 *     - `name: String`
 *     - `email: String`
 * 3. Stwórz klasę`Product`reprezentującą produkt z następującymi polami:
 *     - `id: Int`
 *     - `name: String`
 *     - `price: Double`
 * 4. Stwórz funkcję`getUsersFromApi()`, która symuluje pobieranie danych użytkowników z API i zwraca instancję`ApiResponse<User>`.
 * 5. Stwórz funkcję`getProductsFromApi()`, która symuluje pobieranie danych produktów z API i zwraca instancję`ApiResponse<Product>`.
 * 6. W funkcji`main()`:
 *     - Wywołaj`getUsersFromApi()`i wyświetl całkowitą liczbę użytkowników oraz listę użytkowników.
 *     - Wywołaj`getProductsFromApi()`i wyświetl całkowitą liczbę produktów oraz listę produktów.
 */

val users = listOf(
    User(1, "John", "john@o2.pl"),
    User(2, "Alex", "alex@o2.pl"),
    User(3, "Eve", "eve@o2.pl"),
    User(4, "Mark", "mark@o2.pl"),
    User(5, "Dan", "dan@o2.pl")
)

val products = listOf(
    Product(1, "french fries", 32.1),
    Product(2, "fish burger", 53.9),
    Product(3, "milkshake", 15.2),
    Product(4, "soda", 10.4),
)

class ApiResponse<out T>(val totalCount: Int, val list: List<T>)

data class User(val id: Int, val name: String, val email: String)
data class Product(val id: Int, val name: String, val price: Double)

fun getUsersFromApi(): ApiResponse<User> =
    ApiResponse(list = users, totalCount = users.size)

fun getProductsFromApi(): ApiResponse<Product> =
    ApiResponse(list = products, totalCount = products.size)

fun main() {
    val usersResponse = getUsersFromApi()
    val productsResponse = getProductsFromApi()
    println("${usersResponse.totalCount} users: ${usersResponse.list} ")
    println("${productsResponse.totalCount} products: ${productsResponse.list} ")
}