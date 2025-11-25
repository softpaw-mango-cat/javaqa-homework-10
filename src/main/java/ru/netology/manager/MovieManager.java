package ru.netology.manager;

public class MovieManager {
    private MovieItem[] items;
    private int movieLimit;

    public MovieManager() {
        this.items = new MovieItem[0];
        this.movieLimit = 5;
    }

    public MovieManager(int limit) {
        this.items = new MovieItem[0];
        this.movieLimit = limit;
    }

    public MovieItem[] getItems() {
        return items;
    }


    public void setItems(MovieItem[] items) {
        this.items = items;
    }

    public void addItem(MovieItem item) {
        MovieItem[] tmp = new MovieItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public MovieItem[] findAll() {
        return items;
    }

    public MovieItem[] findLast() {
        int resultLength;
        if (items.length <= movieLimit) {
            resultLength = items.length;
        } else {
            resultLength = movieLimit;
        }

        MovieItem[] reversed = new MovieItem[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = items[items.length - 1 - i];
        }
        return reversed;
    }
}
