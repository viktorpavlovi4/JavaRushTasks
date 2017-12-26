package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        if (providers == null || view == null || providers.length == 0) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
        List<Vacancy> allVacancies = new ArrayList<>();

        try {
            for (Provider provider : providers) {
                allVacancies.addAll(provider.getJavaVacancies(city));
            }
        }catch (NullPointerException e){}

        view.update(allVacancies);
    }
}