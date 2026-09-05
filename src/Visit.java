public class Visit {
    private final String visitId;
    private final String visitDate;
    private final String doctorName;
    private final String diagnosis;
    private final String treatment;
    Visit next;

    public Visit(String visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }

    public String getVisitId() {
        return visitId;
    }

    @Override
    public String toString() {
        return "VisitID: " + visitId +
               " | Date: " + visitDate +
               " | Doctor: " + doctorName +
               " | Diagnosis: " + diagnosis +
               " | Treatment: " + treatment;
    }
}
