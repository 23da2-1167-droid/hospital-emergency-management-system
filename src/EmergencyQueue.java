public class EmergencyQueue {

    private class QueueNode {
        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
        }
    }

    private QueueNode front;
    private QueueNode rear;
    private int size;

    public EmergencyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Patient dequeue() {
        if (isEmpty()) {
            return null;
        }
        Patient treated = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return treated;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            return;
        }
        QueueNode current = front;
        int position = 1;
        while (current != null) {
            System.out.println("  " + position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }
}
