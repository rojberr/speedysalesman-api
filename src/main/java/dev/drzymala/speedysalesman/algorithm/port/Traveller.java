package dev.drzymala.speedysalesman.algorithm.port;

import dev.drzymala.speedysalesman.algorithm.domain.City;

import java.util.List;

public interface Traveller {

    List<City> getGreedyPath(List<City> cityList);
}