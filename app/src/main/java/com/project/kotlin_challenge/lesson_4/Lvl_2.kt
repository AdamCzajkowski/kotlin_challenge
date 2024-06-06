package com.project.kotlin_challenge.lesson_4

/**
 * Implementacja funkcji bezpiecznego dostępu do listy
 *
 * Celem zadania jest napisanie extension function dla `List<T>`,
 * która umożliwi bezpieczny dostęp do elementów listy, obsługując przypadki,
 * gdy indeks jest poza zakresem lub gdy element jest null.
 *
 * lvl 2 - Utwórz funkcję rozszerzającą `List<T>` o nazwie `safeGetOrDefault(index: Int, default: T): T`,
 * która zwróci element listy o podanym indeksie, jeśli indeks jest prawidłowy
 * i element nie jest null. W przeciwnym razie powinna zwrócić podaną wartość domyślną.
 */


fun <T> List<T>.safeGetOrDefault(index: Int, default: T): T? {
    return try {
        this[index] ?: default
    } catch (e: Exception) {
        default
    }
}

fun <T> List<T>.safeGetOrDefaultSimpler(index: Int, default: T): T? {
    return this.getOrNull(index) ?: default
}

fun main() {
    println(list.safeGetOrDefault(-10, "domyślna") + " " + list.safeGetOrDefaultSimpler(-10, "domyślna"))
    println(list.safeGetOrDefault(1, "domyślna") + " " + list.safeGetOrDefaultSimpler(1, "domyślna"))
    println(list.safeGetOrDefault(2, "domyślna") + " " + list.safeGetOrDefaultSimpler(2, "domyślna"))
    println(list.safeGetOrDefault(10, "domyślna") + " " + list.safeGetOrDefaultSimpler(10, "domyślna"))
}
