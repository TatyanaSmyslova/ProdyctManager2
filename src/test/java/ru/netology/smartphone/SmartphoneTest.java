package ru.netology.smartphone;

import org.junit.jupiter.api.Test;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartphoneTest {
    @Test
    public void shouldHaveAllMethodsFromSuper() {
        Smartphone smartphone = new Smartphone();

    }
    @Test
    public void shouldEUseEquals() {
        Smartphone smartphone1 =new Smartphone(1,"Название смартфона",20000,"Наименование производителя");
        Smartphone smartphone2 =new Smartphone(1,"Название смартфона",20000,"Наименование производителя");

        assertEquals(smartphone1,smartphone2);

    }
}