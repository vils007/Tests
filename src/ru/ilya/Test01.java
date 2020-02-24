package ru.ilya;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {

        List<Country> couList = Arrays.asList(
                new Country("Japan", Country.Continent.ASIA),
                new Country("Italy", Country.Continent.EUROPE),
                new Country("Germany", Country.Continent.EUROPE));
        Map<Country.Continent, List<String>> regionNames = couList.stream()
                .collect(Collectors.groupingBy(Country::getRegion,
                        Collectors.mapping(Country::getName, Collectors.toList())));
        System.out.println(regionNames);

    }
}

class Country {
    public Country(String n, Continent r) {
        name = n;
        region = r;
    }

    public enum Continent {ASIA, EUROPE}

    String name;
    Continent region;

    public String getName() {
        return name;
    }

    public Continent getRegion() {
        return region;
    }
}
