package dev.drzymala.speedysalesman.algorithm.domain.city;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@RequiredArgsConstructor
public class City {

    private static final AtomicInteger sequence = new AtomicInteger();
    private final int id;
    private final int x;
    private final int y;

    public City() {
        this.id = sequence.incrementAndGet();
        this.x = ThreadLocalRandom.current().nextInt(100000);
        this.y = ThreadLocalRandom.current().nextInt(100000);
    }

    @Override
    public String toString() {

        return "Id: " + id + " X: " + x + " Y: " + y;
    }
}
