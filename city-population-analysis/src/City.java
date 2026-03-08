public class City {
    String name;
    String continent;
    int population2024;
    int population2023;
    City next;

    public City(City city) {
        this.name = city.name;
        this.continent = city.continent;
        this.population2024 = city.population2024;
        this.population2023 = city.population2023;
    }

    public City(String name, String continent, int population2024, int population2023) {
        this.name = name;
        this.continent = continent;
        this.population2024 = population2024;
        this.population2023 = population2023;
    }

    public double growthRate() {
        return (population2024 - population2023) / (double) population2023 * 100;
    }
}