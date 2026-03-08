public class PopulationStack {
    private static class ContinentNode {
        String continentName;
        long sumPopulation;
        ContinentNode next;

        public ContinentNode(String continentName, long sumPopulation) {
            this.continentName = continentName;
            this.sumPopulation = sumPopulation;
        }
    }

    private ContinentNode top;

    public void push(String continentName, long sumPopulation) {
        ContinentNode newNode = new ContinentNode(continentName, sumPopulation);
        if (top == null || newNode.sumPopulation < top.sumPopulation) {
            newNode.next = top;
            top = newNode;
        } else {
            ContinentNode current = top;
            while (current.next != null && current.next.sumPopulation < newNode.sumPopulation) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public String getLowestPopulationContinent() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        ContinentNode current = top;
        ContinentNode lowest = top;
        while (current != null) {
            if (current.sumPopulation < lowest.sumPopulation) {
                lowest = current;
            }
            current = current.next;
        }
        return lowest.continentName;
    }
 
}