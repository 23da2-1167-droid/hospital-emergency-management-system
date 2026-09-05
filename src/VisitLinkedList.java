public class VisitLinkedList {
    private Visit head;

    public VisitLinkedList() {
        this.head = null;
    }

    public void addVisit(Visit newVisit) {
        if (head == null) {
            head = newVisit;
            return;
        }
        Visit current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newVisit;
    }

    public boolean removeVisit(String visitId) {
        if (head == null) {
            return false;
        }
        if (head.getVisitId().equals(visitId)) {
            head = head.next;
            return true;
        }
        Visit current = head;
        while (current.next != null) {
            if (current.next.getVisitId().equals(visitId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Visit searchVisit(String visitId) {
        Visit current = head;
        while (current != null) {
            if (current.getVisitId().equals(visitId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            return;
        }
        Visit current = head;
        while (current != null) {
            System.out.println("  " + current);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
