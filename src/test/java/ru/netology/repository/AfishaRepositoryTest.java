package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItems;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    AfishaRepository repository = new AfishaRepository();
    AfishaManager manager = new AfishaManager(repository);

    AfishaItems one = new AfishaItems(1, "Avengers");
    AfishaItems two = new AfishaItems(2, "Santa Barbara");
    AfishaItems three = new AfishaItems(3, "Seven");
    AfishaItems four = new AfishaItems(4, "Konstantin");
    AfishaItems five = new AfishaItems(5, "Matrix");
    AfishaItems six = new AfishaItems(6, "Tom & Jerry");
    AfishaItems seven = new AfishaItems(7, "Titanic");
    AfishaItems eight = new AfishaItems(8, "Spider Man");
    AfishaItems nine = new AfishaItems(9, "Batman");
    AfishaItems ten = new AfishaItems(10, "Trolls");
    AfishaItems eleven = new AfishaItems(11, "Maleficent");
    AfishaItems twelve = new AfishaItems(12, "Doctor Who");

    @BeforeEach
    void prepareManager() {
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);
        manager.addMovie(eleven);
        manager.addMovie(twelve);
    }

    @Test
    void findAll() {
        AfishaItems[] expected = new AfishaItems[]{one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        AfishaItems[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addMovie() {
        manager.addMovie(one);
        AfishaItems[] expected = new AfishaItems[]{one, twelve, eleven, ten, nine, eight, seven, six, five, four};
        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        AfishaItems actual = repository.findById(2);
        assertEquals(two,actual);
    }

    @Test
    void removeById() {
        AfishaItems[] expected = new AfishaItems[]{one, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        AfishaItems[] actual = repository.removeById(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        AfishaItems[] expected = new AfishaItems[]{};
        AfishaItems[] actual = repository.removeAll();
        assertArrayEquals(expected, actual);
    }
}