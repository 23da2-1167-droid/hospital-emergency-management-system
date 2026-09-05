public class TreatmentStack {

    private class StackNode {
        TreatmentRecord record;
        StackNode next;

        StackNode(TreatmentRecord record) {
            this.record = record;
        }
    }

    private StackNode top;
    private int size;

    public TreatmentStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            return null;
        }
        TreatmentRecord record = top.record;
        top = top.next;
        size--;
        return record;
    }

    public TreatmentRecord peek() {
        if (isEmpty()) {
            return null;
        }
        return top.record;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.println("  " + current.record);
            current = current.next;
        }
    }
}
