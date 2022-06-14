package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Название книги1", 2000, "Фамилия автора1");
    Product second = new Book(2, "Название книги2", 3000, "Фамилия автора1");
    Product third = new Book(3, "Название книги3", 4000, "Фамилия автора3");
    Product fourth = new Smartphone(4, "Название смартфона1", 20000, "Наименование производителя1");
    Product fifth = new Smartphone(5, "Название смартфона2", 30000, "Наименование производителя2");


    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }
    @Test
    public void addProduct() {
        manager.add(first);
        assertArrayEquals(new Product[]{first}, repository.getAll());
    }

    @Test
    void searchByName() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Название книги3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameBook() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Название книги2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesAuthor() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Фамилия автора3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesManufacture() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Наименование производителя2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameSmartphone() {
        setUp();

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Название смартфона1");
        assertArrayEquals(expected, actual);
    }

    //    поиск всех книг одного автора
    @Test
    void searchAllByAuthor() {
        setUp();

        Product[] expected = new Product[]{second, first};
        Product[] actual = manager.searchBy("Фамилия автора1");
        assertArrayEquals(expected, actual);
    }
    //    Запрос, на который нет ответа
    @Test
    void searchAll() {
        setUp();

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

}