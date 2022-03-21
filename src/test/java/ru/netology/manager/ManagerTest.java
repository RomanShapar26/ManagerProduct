package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {private Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    Book firstBook = new Book(1, "Book1", 100, "Authore");
    Book secondBook = new Book(2, "Book2", 150, "Authore2");
    Book thirdBook = new Book(3, "Book3", 200, "Authore3");
    Smartphone firstPhone = new Smartphone(4, "Smart1", 150_000, "Cantry1");
    Smartphone secondPhone = new Smartphone(5, "Smart2", 200_000, "Cantry2");
    Smartphone thirdPhone = new Smartphone(6, "Book3", 150065, "Cantry3");

    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);

    }

    @Test
    public void shouldFindAuthorBook() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Authore2");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNamePhone() {
        Product[] expected = new Product[]{firstPhone};
        Product[] actual = manager.searchBy("Smart1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Book1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneCreator() {
        Product[] expected = new Product[]{secondPhone};
        Product[] actual = manager.searchBy("Smart2");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneBookName() {
        Product[] expected = new Product[]{thirdBook, thirdPhone};
        Product[] actual = manager.searchBy("Book3");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindPhoneName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Книга");

        assertArrayEquals(expected, actual);
    }
}