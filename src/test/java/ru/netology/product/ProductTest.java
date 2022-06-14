package ru.netology.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void shouldUseEquals() {
        Product first = new Product(1,"Название продукта",2000);
        Product second = new Product(1, "Название продукта", 2000);
        assertEquals(first,second);
    }

}