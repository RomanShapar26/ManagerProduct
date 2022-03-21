package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    private Repository repository = new Repository();
    private Book book1 = new Book(1, "Book1", 100, "Authore1");
    private Smartphone phone1 = new Smartphone(21, "Smart1", 10754, "Smartt");

    @BeforeEach
    public void addProducts() {
        repository.save(book1);
        repository.save(phone1);
    }

    @Test
    public void shouldRemovedById() {
        repository.removeById(21);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}