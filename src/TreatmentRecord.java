public class TreatmentRecord {
    private final int patientId;
    private final String patientName;
    private final String treatmentDetails;
    private final String completionDate;

    public TreatmentRecord(int patientId, String patientName, String treatmentDetails, String completionDate) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "PatientID: " + patientId +
               " | Name: " + patientName +
               " | Treatment: " + treatmentDetails +
               " | Completed: " + completionDate;
    }
}
