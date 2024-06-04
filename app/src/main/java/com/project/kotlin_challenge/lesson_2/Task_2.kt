package com.project.kotlin_challenge.lesson_2

/**
 * Zadanie 2
 *
 * Mamy listę studentów z ich imionami i ocenami. Każdy student jest reprezentowany przez
 * klasę `Student` z polami `imie` i `ocena`.
 *
 * Zadanie:
 * Pogrupuj studentów według ich ocen,
 * tworząc mapę, gdzie kluczem jest ocena, a
 * wartością lista studentów z tą oceną.
 */

data class Student(val name: String, val grade: Int)

val students = listOf(
    Student("Jan", 4),
    Student("Anna", 5),
    Student("Piotr", 3),
    Student("Ewa", 5),
    Student("Tomasz", 4),
    Student("Kasia", 3)
)

fun main() {
    val groupedStudents = students.groupBy { it.grade }.toSortedMap()
    println(groupedStudents)
}

