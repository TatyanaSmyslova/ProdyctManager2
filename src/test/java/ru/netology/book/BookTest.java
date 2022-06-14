package ru.netology.book;

import org.junit.jupiter.api.Test;
import ru.netology.product.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    public void shouldHaveAllMethodsFromSuper() {
        Book book = new Book();

    }
    @Test
    public void shouldUseEquals() {
        Book book1 =new Book(1,"Название книги",2000,"Автор книги");
        Book book2 =new Book(1,"Название книги",2000,"Автор книги");


        assertEquals(book1,book2);

    }

}