public class Hospital {
    private Queue appointment;
    private HashMap patientHistory;
    private BST agePriorityTree;

    public Hospital() {
        appointment = new Queue();
        patientHistory = new HashMap();
        agePriorityTree = BST.nill;
    }

    public void addPatient(String name, int age, String history) {
        Patient newPatient = new Patient(name, age, history);
        appointment.add(newPatient);
        patientHistory.put(name, history);
        agePriorityTree = agePriorityTree.add(newPatient);
    }

    public void findPatientHistory(String name) {
        if (patientHistory.containsKey(name)) {
            System.out.println("History of " + name + ": " + patientHistory.get(name));
        } else {
            System.out.println("No history found for " + name + ".");
        }
    }

    public void scheduleAppointment() {
        if (appointment.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        Patient nextPatient = appointment.poll();
        System.out.println("Scheduled appointment for: " + nextPatient.name + ", Age: " + nextPatient.age);
    }

    public void displayAppointments() {
        if (appointment.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        System.out.println("Scheduled Appointments:");
        appointment.display();
    }
}