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

    MovieManager testManager;
    MovieManager testManagerWithLimit;

    @BeforeEach
    public void addData() {
        item1 = new MovieItem("Бладшот", "боевик", 2025, "16+");
        item2 = new MovieItem("Вперёд", "мультфильм", 2021, "6+");
        item3 = new MovieItem("Отель Белград", "комедия", 2023, "6+");
        item4 = new MovieItem("Джентельмены", "боевик", 2024, "18+");
        item5 = new MovieItem("Человек-невидимка", "ужасы", 2025, "18+");

        testManager = new MovieManager();
        testManagerWithLimit = new MovieManager(3);
    }

    @Test
    public void shouldAddNewItemWhenNotEmpty() {
        MovieItem[] items = {item1, item2, item3, item4, item5};
        testManager.setItems(items);

        MovieItem item6 = new MovieItem(
                "Номер один",
                "комедия",
                2024,
                "12+");

        testManager.addItem(item6);
        MovieItem[] expected = {item1, item2, item3, item4, item5, item6};
        MovieItem[] actual = testManager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewItemWhenEmpty() {
        MovieItem[] expected = {item1};
        testManager.addItem(item1);
        MovieItem[] actual = testManager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedDefaultLimit() {
        MovieItem[] items = {item1, item2, item3, item4, item5};
        testManager.setItems(items);

        MovieItem[] expected = {item5, item4, item3, item2, item1};
        MovieItem[] actual = testManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedSetLimit() {
        MovieItem[] items = {item1, item2, item3, item4, item5};
        testManagerWithLimit.setItems(items);

        MovieItem[] expected = {item5, item4, item3};
        MovieItem[] actual = testManagerWithLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMovies() {

        MovieItem[] items = {item1, item2, item3, item4, item5};
        testManager.setItems(items);

        MovieItem[] expected = {item1, item2, item3, item4, item5};
        MovieItem[] actual = testManager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
