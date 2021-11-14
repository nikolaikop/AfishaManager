package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItems;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {

    AfishaManager manager = new AfishaManager();

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
    public void addOneMoreMovie() {
        manager.addMovie(one);
        AfishaItems[] expected = new AfishaItems[]{
                one,
                twelve,
                eleven,
                ten,
                nine,
                eight,
                seven,
                six,
                five,
                four,
        };
        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastMovies() {

        AfishaItems[] expected = new AfishaItems[]{
                twelve,
                eleven,
                ten,
                nine,
                eight,
                seven,
                six,
                five,
                four,
                three,
        };
        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        //System.out.println("expected = " + expected + " and" + " actual = " + actual);
    }

    @Test
    void getLastMoviesWhen5() {
        AfishaManager manager = new AfishaManager(5);
        AfishaItems[] expected = new AfishaItems[]{
                eight,
                nine,
                ten,
                eleven,
                twelve,
        };
        manager.addMovie(twelve);
        manager.addMovie(eleven);
        manager.addMovie(ten);
        manager.addMovie(nine);
        manager.addMovie(eight);

        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        //System.out.println("expected = " + expected + " and" + " actual = " + actual);
    }

    @Test
    void getLastMoviesWhen10() {
        AfishaManager manager = new AfishaManager(10);
        AfishaItems[] expected = new AfishaItems[]{
                three,
                four,
                five,
                six,
                seven,
                eight,
                nine,
                ten,
                eleven,
                twelve,
        };
        manager.addMovie(twelve);
        manager.addMovie(eleven);
        manager.addMovie(ten);
        manager.addMovie(nine);
        manager.addMovie(eight);
        manager.addMovie(seven);
        manager.addMovie(six);
        manager.addMovie(five);
        manager.addMovie(four);
        manager.addMovie(three);

        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        //System.out.println("expected = " + expected + " and" + " actual = " + actual);
    }

    @Test
    void getLastMoviesWhen12() {
        AfishaManager manager = new AfishaManager(12);
        AfishaItems[] expected = new AfishaItems[]{
                one,
                two,
                three,
                four,
                five,
                six,
                seven,
                eight,
                nine,
                ten,
                eleven,
                twelve,
        };
        manager.addMovie(twelve);
        manager.addMovie(eleven);
        manager.addMovie(ten);
        manager.addMovie(nine);
        manager.addMovie(eight);
        manager.addMovie(seven);
        manager.addMovie(six);
        manager.addMovie(five);
        manager.addMovie(four);
        manager.addMovie(three);
        manager.addMovie(two);
        manager.addMovie(one);

        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        //System.out.println("expected = " + expected + " and" + " actual = " + actual);
    }
}