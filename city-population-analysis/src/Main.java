import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    LinkedList asia = new LinkedList();
    LinkedList europe = new LinkedList();
    LinkedList africa = new LinkedList();
    LinkedList northAmerica = new LinkedList();
    LinkedList southAmerica = new LinkedList();
    LinkedList oceania = new LinkedList();

    Stack asiaStack = new Stack();
    Stack europeStack = new Stack();
    Stack africaStack = new Stack();
    Stack northAmericaStack = new Stack();
    Stack southAmericaStack = new Stack();
    Stack oceaniaStack = new Stack();

    PopulationStack populationStack= new PopulationStack();

    public void population2024Read(String filePath) throws IOException {
        try (BufferedReader read = new BufferedReader(new FileReader(filePath))) {
            String line;
            read.readLine(); // Skip the header

            while ((line = read.readLine()) != null) {
                String[] cityData = line.split(",");
                String cityname = cityData[0];
                String continent = cityData[2];
                int population2024 = Integer.parseInt(cityData[3]);
                int population2023 = Integer.parseInt(cityData[4]);

                City city = new City(cityname, continent, population2024, population2023);

                switch (continent.toLowerCase()) {
                    case "asia" -> asia.add(city);
                    case "europe" -> europe.add(city);
                    case "africa" -> africa.add(city);
                    case "north america" -> northAmerica.add(city);
                    case "south america" -> southAmerica.add(city);
                    case "oceania" -> oceania.add(city);
                    default -> System.out.println("Unknown continent: " + continent);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createContinentStacks() {
        asiaStack.addCities(asia);
        europeStack.addCities(europe);
        africaStack.addCities(africa);
        northAmericaStack.addCities(northAmerica);
        southAmericaStack.addCities(southAmerica);
        oceaniaStack.addCities(oceania);
    }
  //Prob-1
    public void listShrinkingCities() {
        listShrinkingCitiesInContinent(asia, "Asia");
        listShrinkingCitiesInContinent(europe, "Europe");
        listShrinkingCitiesInContinent(africa, "Africa");
        listShrinkingCitiesInContinent(northAmerica, "North America");
        listShrinkingCitiesInContinent(southAmerica, "South America");
        listShrinkingCitiesInContinent(oceania, "Oceania");
    }

    private void listShrinkingCitiesInContinent(LinkedList continent, String continentName) {
        City current = continent.head;
        int count = 0;
        System.out.println("\nShrinking cities in " + continentName + ":");
        while (current != null) {
            if (current.population2024 < current.population2023) {
                System.out.println(current.name + " (2024: " + current.population2024 + ", 2023: " + current.population2023 + ")");
                count++;
            }
            current = current.next;
        }
        if (count == 0)
            System.out.println("No shrinking cities in " + continentName);
    }
   
    
    
     public void storeContinentPopStack(){
         
            LinkedList[] continents = {asia, europe, africa, northAmerica, southAmerica, oceania};
            String[] continentName = {"asia", "europe", "africa", "northAmerica", "southAmerica", "oceania"};
            int i=0;
            for(LinkedList L: continents){
                populationStack.push(continentName[i], L.sumPopulation());
                i++;
            }
             
        
    }
    //Prob-2
    public void findLowestPopulationContinent() {
     
       System.out.println(populationStack.getLowestPopulationContinent()+" is the continent with lowest population");
        
    }

    //Prob-3
    public void findGrowthRateExtremes() {
        City highestGrowth = null, lowestGrowth = null;
        double maxGrowth = Double.NEGATIVE_INFINITY, minGrowth = Double.POSITIVE_INFINITY;

        for (LinkedList continent : new LinkedList[]{asia, europe, africa, northAmerica, southAmerica, oceania}) {
            City current = continent.head;
            while (current != null) {
                double growthRate = current.growthRate();
                if (growthRate > maxGrowth) {
                    maxGrowth = growthRate;
                    highestGrowth = current;
                }
                if (growthRate < minGrowth) {
                    minGrowth = growthRate;
                    lowestGrowth = current;
                }
                current = current.next;
            }
        }

        if (highestGrowth != null) {
            System.out.println("City with highest growth rate: " + highestGrowth.name + " (" + maxGrowth + "%)");
        }
        if (lowestGrowth != null) {
            System.out.println("City with lowest growth rate: " + lowestGrowth.name + " (" + minGrowth + "%)");
        }
    }
    //Prob 4
    public void findMiddleCities() {

    System.out.println("Middle city in Asia: " + asia.findMiddleCity().name);
    System.out.println("Middle city in Europe: " + europe.findMiddleCity().name);
    System.out.println("Middle city in Africa: " + africa.findMiddleCity().name);
    System.out.println("Middle city in North America: " + northAmerica.findMiddleCity().name);
    System.out.println("Middle city in South America: " + southAmerica.findMiddleCity().name);
    System.out.println("Middle city in Oceania: " + oceania.findMiddleCity().name);
    }
    
    //prob 5
    public void showTopCities() {

    System.out.println("\nTop cities in Asia:");
    asia.printTopKCities(5);

    System.out.println("\nTop cities in Europe:");
    europe.printTopKCities(5);

    System.out.println("\nTop cities in Africa:");
    africa.printTopKCities(5);
    }
    
    public static void main(String[] args) {
        Main pbl = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        try {
            pbl.population2024Read("D:\\Github\\DSA\\city-population-analysis\\DatasetUpdated.csv");
            pbl.createContinentStacks();
            pbl.storeContinentPopStack();

            while (!exit) {
                System.out.println("\nSelect an option:");
                System.out.println("1. List shrinking cities");
                System.out.println("2. Find continent with the lowest population");
                System.out.println("3. Find middle cities in each continent stack");
                System.out.println("4. Find city with highest and lowest growth rates");
                System.out.println("5. Find Top 5 most populated Cities");
                System.out.println("6. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> pbl.listShrinkingCities();
                    case 2 -> pbl.findLowestPopulationContinent();
                    case 3 -> pbl.findMiddleCities();
                    case 4 -> pbl.findGrowthRateExtremes();
                    case 5 -> pbl.showTopCities();
                    case 6 -> exit = true;
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}