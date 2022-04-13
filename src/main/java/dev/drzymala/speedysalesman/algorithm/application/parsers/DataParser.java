package dev.drzymala.speedysalesman.algorithm.application.parsers;

import dev.drzymala.speedysalesman.whatever.city.City;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DataParser {

    public List<City> readCities(String data) {

        int[] numbers = Arrays.stream(data.split("\\W+")).mapToInt(Integer::parseInt).toArray();

        List<City> cities = new ArrayList<>();
        for (int i = 1; i < numbers.length; i = i + 3) {
            cities.add(new City(numbers[i + 1], numbers[i + 2]));
        }
        return cities;
    }
}