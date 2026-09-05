public class PatientBST {

    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    public boolean insert(Patient patient) {
        boolean[] inserted = {false};
        root = insertRec(root, patient, inserted);
        return inserted[0];
    }

    private Node insertRec(Node node, Patient patient, boolean[] inserted) {
        if (node == null) {
            inserted[0] = true;
            return new Node(patient);
        }
        if (patient.getPatientId() < node.patient.getPatientId()) {
            node.left = insertRec(node.left, patient, inserted);
        } else if (patient.getPatientId() > node.patient.getPatientId()) {
            node.right = insertRec(node.right, patient, inserted);
        } else {
        }
        return node;
    }

    public Patient search(int patientId) {
        Node result = searchRec(root, patientId);
        return (result == null) ? null : result.patient;
    }

    private Node searchRec(Node node, int patientId) {
        if (node == null || node.patient.getPatientId() == patientId) {
            return node;
        }
        if (patientId < node.patient.getPatientId()) {
            return searchRec(node.left, patientId);
        }
        return searchRec(node.right, patientId);
    }

    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node node, int patientId) {
        if (node == null) {
            return null;
        }

        if (patientId < node.patient.getPatientId()) {
            node.left = deleteRec(node.left, patientId);
        } else if (patientId > node.patient.getPatientId()) {
            node.right = deleteRec(node.right, patientId);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node successor = findMin(node.right);
            node.patient = successor.patient;
            node.right = deleteRec(node.right, successor.patient.getPatientId());
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void displayInOrder() {
        if (root == null) {
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println("  " + node.patient);
            inOrderRec(node.right);
        }
    }
}
