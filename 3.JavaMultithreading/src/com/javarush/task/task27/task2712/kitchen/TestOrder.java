package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        dishes = new ArrayList<>();
        List<Dish> dishList = new ArrayList<>(Arrays.asList(Dish.values()));
        Collections.shuffle(dishList);
        int random = threadLocalRandom.nextInt(dishList.size());
        for (int i = 0; i < random; i++) {
            dishes.add(dishList.get(i));
        }
    }
}
