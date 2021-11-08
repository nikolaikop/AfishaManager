package ru.netology.repository;

import ru.netology.domain.AfishaItems;

import static java.lang.System.arraycopy;

public class AfishaRepository {

    private AfishaItems[] items = new AfishaItems[0];

    public AfishaItems[] findAll() {
        return items;
    }

    public void addMovie(AfishaItems item) {
        AfishaItems[] tmp = new AfishaItems[items.length+1];
        arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
        return;
    }

    public AfishaItems findById(int id) {
        AfishaItems itemById = new AfishaItems();
        for (AfishaItems item : items) {
            if (item.getId() == id) {
                itemById = item;
            }
        }
        return itemById;

    }
    public AfishaItems[] removeById(int id) {
        int length = items.length - 1;
        AfishaItems[] tmp = new AfishaItems[length];
        int index = 0;
        for (AfishaItems item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public AfishaItems[] removeAll() {
        return items = new AfishaItems[0];
    }
}
