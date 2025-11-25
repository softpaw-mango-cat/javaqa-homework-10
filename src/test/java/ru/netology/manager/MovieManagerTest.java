package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieItem item1;
    MovieItem item2;
    MovieItem item3;
    MovieItem item4;
    MovieItem item5;
    MovieItem item6;

    @BeforeEach
    public void addData() {
        item1 = new MovieItem("Бладшот", "боевик", 2025, "16+");
        item2 = new MovieItem("Вперёд", "мультфильм", 2021, "6+");
        item3 = new MovieItem("Отель Белград", "комедия", 2023, "6+");
        item4 = new MovieItem("Джентельмены", "боевик", 2024, "18+");
        item5 = new MovieItem("Человек-невидимка", "ужасы", 2025, "18+");
        item6 = new MovieItem("Номер один", "комедия", 2024, "12+");
    }

    // проверки для addItem
    @Test
    public void shouldAddNewItemWhenEmpty() {
        MovieManager manager = new MovieManager();
        manager.addItem(item1);

        MovieItem[] expected = {item1};
        MovieItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewItemWhenNotEmpty() {
        MovieItem[] items = {item1, item2, item3, item4, item5};
        MovieManager manager = new MovieManager();
        manager.setItems(items);

        manager.addItem(item6);

        MovieItem[] expected = {item1, item2, item3, item4, item5, item6};
        MovieItem[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    // проверки для findAll
    @Test
    public void shouldFindAllMoviesWhenEmpty() {
        MovieManager manager = new MovieManager();
        MovieItem[] expected = {};
        MovieItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMoviesWhenNotEmpty() {
        MovieManager manager = new MovieManager();
        MovieItem[] items = {item1, item2, item3, item4, item5};
        manager.setItems(items);

        MovieItem[] expected = {item1, item2, item3, item4, item5};
        MovieItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // проверки для findLast
    @Test
    public void shouldFindLastDefaultLimitEquals() {
        // когда кол-во фильмов и лимит равны при дефолтном лимите
        MovieManager manager = new MovieManager();
        MovieItem[] items = {item1, item2, item3, item4, item5};
        manager.setItems(items);

        MovieItem[] expected = {item5, item4, item3, item2, item1};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastDefaultLimitLow() {
        // когда кол-во фильмов меньше лимита при дефолтном лимите
        MovieManager manager = new MovieManager();
        MovieItem[] items = {item1, item2};
        manager.setItems(items);

        MovieItem[] expected = {item2, item1};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastDefaultLimitHigh() {
        // когда кол-во фильмов больше лимита при дефолтном лимите
        MovieManager manager = new MovieManager();
        MovieItem[] items = {item1, item2, item3, item4, item5, item6};
        manager.setItems(items);

        MovieItem[] expected = {item6, item5, item4, item3, item2};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLowerLimitEquals() {
        // когда кол-во фильмов и лимит равны при лимите меньше дефолтного
        MovieManager manager = new MovieManager(3);
        MovieItem[] items = {item1, item2, item3};
        manager.setItems(items);

        MovieItem[] expected = {item3, item2, item1};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLowerLimitLow() {
        // когда кол-во фильмов меньше лимита при лимите меньше дефолтного
        MovieManager manager = new MovieManager(3);
        MovieItem[] items = {item1, item2};
        manager.setItems(items);

        MovieItem[] expected = {item2, item1};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLowerLimitHigh() {
        // когда кол-во фильмов больше лимита при лимите меньше дефолтного
        MovieManager manager = new MovieManager(3);
        MovieItem[] items = {item1, item2, item3, item4, item5, item6};
        manager.setItems(items);

        MovieItem[] expected = {item6, item5, item4};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastHigherLimitEquals() {
        // когда кол-во фильмов и лимит равны при лимите больше дефолтного
        MovieManager manager = new MovieManager(6);
        MovieItem[] items = {item1, item2, item3, item4, item5, item6};
        manager.setItems(items);

        MovieItem[] expected = {item6, item5, item4, item3, item2, item1};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastHigherLimitLow() {
        // когда кол-во фильмов меньше лимита при лимите больше дефолтного
        MovieManager manager = new MovieManager(6);
        MovieItem[] items = {item1, item2};
        manager.setItems(items);

        MovieItem[] expected = {item2, item1};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastHigherLimitHigh() {
        // когда кол-во фильмов больше лимита при лимите больше дефолтного
        MovieManager manager = new MovieManager(6);
        MovieItem item7 = new MovieItem(
                "Тролли",
                "мультфильм",
                2020,
                "6+");
        MovieItem[] items = {item1, item2, item3, item4, item5, item6, item7};
        manager.setItems(items);

        MovieItem[] expected = {item7, item6, item5, item4, item3, item2};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
