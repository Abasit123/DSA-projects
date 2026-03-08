public class LinkedList {
    City head;
    LinkedList() {
        head = null;
    }

    void add(City newCity) {
        if (head == null || head.population2024 < newCity.population2024) {
            newCity.next = head;
            head = newCity;
            return;
        }
        
        City current = head;
        while (current.next != null && current.next.population2024 >= newCity.population2024) {
            current = current.next;
        }
        newCity.next = current.next;
        current.next = newCity;
    }

    int sumPopulation() {
        int sum = 0;
        City current = head;
        while (current != null) {
            sum = sum+ current.population2024 + current.population2023;
            current = current.next;
        }
        return sum;
    }
    public void printTopKCities(int k) {

    City current = head;
    int count = 0;

    while (current != null && count < k) {
        System.out.println(current.name + " - " + current.population2024);
        current = current.next;
        count++;
    }
   }
   public City findMiddleCity() {

    City slow = head;
    City fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
    }
}