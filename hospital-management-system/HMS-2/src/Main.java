public class Main{
    public static void main(String[] args) {
     
        Hospital hospital= new Hospital();

        hospital.addPatient("Ali", 20, "Hypertension");
        hospital.addPatient("Husnaak", 23, "Healthy");
        hospital.addPatient("Kareem", 60, "Diabetes");
        hospital.addPatient("Aslam", 40, "Healthy");

        hospital.displayAppointments();

        System.out.println();
        hospital.scheduleAppointment();
        
        System.out.println("\nDisplay Remaining appointments");
        hospital.displayAppointments();

        System.out.println();
        hospital.scheduleAppointment();

        System.out.println("\nDisplay Remaining appointments");
        hospital.displayAppointments();

        System.out.println();

        hospital.findPatientHistory("Kareem");
        hospital.findPatientHistory("Husnaak");
        hospital.findPatientHistory("Ahsan");
    }
}
