package ru.netology.manager;

import ru.netology.domain.AfishaItems;
import static java.lang.System.arraycopy;

public class AfishaManager {

    private int movieCount = 10;
    private AfishaItems[] items = new AfishaItems[movieCount];

    public AfishaManager(int movieCount) {
        this.movieCount = movieCount;
    }

    public AfishaManager() {

    }

    public void addMovie(AfishaItems item) {
        AfishaItems[] tmp = new AfishaItems[items.length+1];
        arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
        return;
    }

    public AfishaItems[] getLastMovies() {

        AfishaItems[] result = new AfishaItems[movieCount];
        int counter = 0;
        for (int i = 0; i < movieCount; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        arraycopy(result, 0, result, 0, counter);
        return result;
    }
}
