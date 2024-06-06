package com.project.kotlin_challenge.lesson_4

/**
 * Implementacja funkcji bezpiecznego dostępu do listy
 *
 * Celem zadania jest napisanie extension function dla `List<T>`,
 * która umożliwi bezpieczny dostęp do elementów listy, obsługując przypadki,
 * gdy indeks jest poza zakresem lub gdy element jest null.
 *
 * lvl 3 - (jeśli znasz już typy funkcyjne) Utwórz funkcję rozszerzającą List<T>
 *     o nazwie safeGetOrElse(index: Int, defaultProvider: () -> T): T, która zwróci element
 *     listy o podanym indeksie, jeśli indeks jest prawidłowy i element nie jest null.
 *     W przeciwnym razie powinna wywołać podaną funkcję defaultProvider i zwrócić jej wynik.
 */

fun <T> List<T>.safeGetOrElse(index: Int, defaultProvider: () -> T): T? {
    return try {
        this[index] ?: defaultProvider.invoke()
    } catch (e: Exception) {
        defaultProvider.invoke()
    }
}

fun <T> List<T>.safeGetOrElseSimpler(index: Int, defaultProvider: () -> T): T? {
    return this.getOrElse(index) {
        defaultProvider.invoke()
    }
}

fun main() {
    println(list.safeGetOrElse(-10) { "else" } + " " + list.safeGetOrElseSimpler(-10) { "else" })
    println(list.safeGetOrElse(1) { null } + " " + list.safeGetOrElseSimpler(1) { null })
    println(list.safeGetOrElse(2) { null } + " " + list.safeGetOrElseSimpler(2) { null })
    println(list.safeGetOrElse(10) { "else" } + " " + list.safeGetOrElseSimpler(-10) { "else" })
}