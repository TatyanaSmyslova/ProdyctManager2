package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    Product first = new Book(1, "Название книги1", 2000, "Фамилия автора1");
    Product second = new Book(2, "Название книги2", 3000, "Фамилия автора2");

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);

        int idToRemove=1;
        repository.removeById(idToRemove);

        Product[] expected = new Product[] {};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);

    }
}