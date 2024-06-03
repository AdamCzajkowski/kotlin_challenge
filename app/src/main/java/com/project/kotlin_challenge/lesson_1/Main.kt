package com.project.kotlin_challenge.lesson_1

/**
 * FizzBuzz
 *
 * Napisz program, który wypisuje liczby od 1 do 100.
 * Jednak dla liczb podzielnych przez 3 zamiast liczby wypisz słowo "Kajko",
 * dla liczb podzielnych przez 5 wypisz "Kokosz",
 * a dla liczb podzielnych zarówno przez 3 jak i 5 wypisz "Kajko i Kokosz".
 */

fun main() {
    for(i in 1..100) {
        when {
            i % 3 == 0 && i % 5 != 0 -> println("Kajko")
            i % 5 == 0 && i % 3 != 0 -> println("Kokosz")
            i % 5 == 0 && i % 3 == 0 -> println("Kajko i Kokosz")
            else -> println(i)
        }
    }
}
