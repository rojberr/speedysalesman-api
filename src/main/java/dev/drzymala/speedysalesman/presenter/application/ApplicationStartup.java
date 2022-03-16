package dev.drzymala.speedysalesman.presenter.application;

import dev.drzymala.speedysalesman.algorithm.application.port.Generator;
import dev.drzymala.speedysalesman.algorithm.application.port.Traveller;
import dev.drzymala.speedysalesman.algorithm.domain.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplicationStartup implements CommandLineRunner {

    private final Generator generator;
    private final Traveller traveller;
    private final CityRepository cityList;

    @Override
    public void run(String... args) {

        cityList.save(generator.generate(25L));
        System.out.println(cityList);

//        traveller.findPathByFindingShortest(generator.ge);
    }
}
