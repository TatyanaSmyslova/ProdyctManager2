package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(1, "Название книги1", 1000, "Фамилия автора1");
    private Book secondBook = new Book(2, "Название книги2", 2000, "Фамилия автора1");

    @Test
    public void shouldRemoveByID() {
        repository.save(firstBook);
        repository.save(secondBook);
        Product[] expected = new Product[]{secondBook};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}