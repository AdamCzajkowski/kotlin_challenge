package com.project.kotlin_challenge.lesson_3

import java.util.Date

/**
 * ## Zadanie 1: Klasy, obiekty, data class
 *
 * Wyobraź sobie, że tworzysz aplikację do zarządzania biblioteką. Zaimplementuj następujące klasy i obiekty:
 *
 * 1. Stwórz`data class``Book`z polami`title`,`author`i`publishDate`.
 * 2. Stwórz klasę`Library`z następującymi elementami:
 *     - Właściwość`books`przechowująca listę książek.
 *     - Metodę`addBook`umożliwiającą dodawanie nowej książki do biblioteki.
 *     - Metodę`listBooks`wypisującą wszystkie książki w bibliotece.
 * 3. Stwórz`object``Config`z właściwością`maxBooks`określającą maksymalną liczbę książek, jakie mogą być przechowywane w bibliotece.
 * 4. W klasie`Library`dodaj logikę, która nie pozwoli na dodanie nowej książki, jeśli liczba książek osiągnie`maxBooks`.
 * 5. Stwórz kilka instancji`Book`i dodaj je do `Library`. Następnie wywołaj metodę `listBooks`.
 */

data class Book(val title: String, val author: String, val publishDate: String)

class Library(private var books: List<Book>) {
    fun addBook(book: Book) {
        if (books.size < Config.MAX_BOOKS) {
            val newListOfBooks = books.toMutableList()

            newListOfBooks.add(book)
            books = newListOfBooks
            println("Dodano książkę o tytule \"${book.title}\" do biblioteki")
        } else {
            println("Brak możliwości dodania książki, osiągnieto limit książek")
        }
    }

    fun listBooks() {
        println(books)
    }
}

object Config {
    const val MAX_BOOKS = 4
}

val listOfBooks = listOf(
    Book("Pan Tadeusz", "Adam Mickiewicz", "28.06.1834"),
    Book("Latarnik", "Henryk Sienkiewicz", "01.06.1881"),
    Book("Dziady", "Adam Mickiewicz", "01.01,1822"),
    Book("Syzyfowe prace", "Stefan Żeromski", "24.09.1897"),
    Book("Kamienie na szaniec", "Aleksander Kamiński", "01.01.1943")
)

fun main() {
    val library = Library(emptyList())
    listOfBooks.forEach {
        library.addBook(it)
    }
    library.listBooks()
}
