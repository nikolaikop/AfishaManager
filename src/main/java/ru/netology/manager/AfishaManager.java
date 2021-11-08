package ru.netology.manager;

import ru.netology.domain.AfishaItems;
import ru.netology.repository.AfishaRepository;
import static java.lang.System.arraycopy;

public class AfishaManager {

    private AfishaRepository repository;
    private int movieCount = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }
    public AfishaManager(AfishaRepository repository, int movieCount) {
        this.repository = repository;
        this.movieCount = movieCount;
    }

    public AfishaManager() {
    }

    public void addMovie(AfishaItems item) {
        repository.addMovie(item);
    }

    public AfishaItems[] getLastMovies() {
        AfishaItems[] items = repository.findAll();
        AfishaItems[] result = new AfishaItems[movieCount];
        int counter = 0;
        for (int i = 0; i < movieCount; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        arraycopy(result, 0, result, 0, counter);
        return result;
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
