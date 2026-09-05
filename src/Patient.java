public class Patient {
    private final int patientId;
    private final String name;
    private final int age;
    private final String contactNumber;
    private final String medicalCondition;
    private final VisitLinkedList visitHistory;

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public VisitLinkedList getVisitHistory() {
        return visitHistory;
    }

    @Override
    public String toString() {
        return "PatientID: " + patientId +
               " | Name: " + name +
               " | Age: " + age +
               " | Contact: " + contactNumber +
               " | Condition: " + medicalCondition;
    }
}
