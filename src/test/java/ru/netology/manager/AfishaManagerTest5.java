package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest5 {

    AfishaManager manager = new AfishaManager(5);

    AfishaItems one = new AfishaItems(1, "Avengers");           //More than limit
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

        };
        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        //System.out.println("expected = " + expected + " and" + " actual = " + actual);
    }

}