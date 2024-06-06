package com.project.kotlin_challenge.lesson_4

/**
 * Implementacja funkcji bezpiecznego dostępu do listy
 *
 * Celem zadania jest napisanie extension function dla `List<T>`,
 * która umożliwi bezpieczny dostęp do elementów listy, obsługując przypadki,
 * gdy indeks jest poza zakresem lub gdy element jest null.
 *
 * lvl 1 - Utwórz funkcję rozszerzającą List<T> o nazwie safeGet(index: Int): T?,
 * która zwróci element listy o podanym indeksie, jeśli indeks jest prawidłowy i element nie jest null.
 * W przeciwnym razie powinna zwrócić null.
 */

val list = listOf("Antylopa", "Baran", null, "Dziobak", null, "Foka")

fun <T> List<T>.safeGet(index: Int): T? {
    return try {
        this[index]
    } catch (e: Exception) {
        null
    }
}

fun <T> List<T>.safeGetSimpler(index: Int): T? {
    return getOrNull(index)
}

fun main() {
    println(list.safeGet(-10) + " " + list.safeGetSimpler(-10))
    println(list.safeGet(1) + " " + list.safeGetSimpler(1))
    println(list.safeGet(2) + " " + list.safeGetSimpler(2))
    println(list.safeGet(10) + " " + list.safeGetSimpler(10))
}


