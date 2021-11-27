package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest12 {

    AfishaManager manager = new AfishaManager();

    AfishaItems one = new AfishaItems(1, "Avengers");           //less than limit
    AfishaItems two = new AfishaItems(2, "Santa Barbara");
    AfishaItems three = new AfishaItems(3, "Seven");
    AfishaItems four = new AfishaItems(4, "Konstantin");
    AfishaItems five = new AfishaItems(5, "Matrix");


    @BeforeEach
    void prepareManager() {
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
    }

    @Test
    public void addOneMoreMovie() {
        manager.addMovie(one);
        AfishaItems[] expected = new AfishaItems[]{
                one,
                five,
                four,
                three,
                two,
                one,
        };
        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastMovies() {

        AfishaItems[] expected = new AfishaItems[]{
                five,
                four,
                three,
                two,
                one,
        };
        AfishaItems[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        //System.out.println("expected = " + expected + " and" + " actual = " + actual);
    }

}