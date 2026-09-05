import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            scanner = s;
            boolean running = true;
            while (running) {
                printMainMenu();
                int choice = readInt();
                switch (choice) {
                    case 1 -> patientRecordsMenu();
                    case 2 -> emergencyQueueMenu();
                    case 3 -> treatmentHistoryMenu();
                    case 4 -> visitHistoryMenu();
                    case 0 -> {
                        running = false;
                        System.out.println("Exiting Hospital Emergency Management System. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n===== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM =====");
        System.out.println("1. Patient Records (Binary Search Tree)");
        System.out.println("2. Emergency Patient Queue");
        System.out.println("3. Treatment History (Stack)");
        System.out.println("4. Patient Visit History (Linked List)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void patientRecordsMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Patient Records (BST) ---");
            System.out.println("1. Insert new patient");
            System.out.println("2. Search patient by ID");
            System.out.println("3. Delete patient by ID");
            System.out.println("4. Display all patients (in-order, ascending ID)");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");

            switch (readInt()) {
                case 1 -> {
                    int id = readIntWithPrompt("Enter Patient ID: ");
                    String name = readLine("Enter Name: ");
                    int age = readIntWithPrompt("Enter Age: ");
                    String contact = readLine("Enter Contact Number: ");
                    String condition = readLine("Enter Medical Condition: ");

                    Patient patient = new Patient(id, name, age, contact, condition);
                    if (patientBST.insert(patient)) {
                        System.out.println("Patient added successfully.");
                    } else {
                        System.out.println("A patient with ID " + id + " already exists.");
                    }
                }
                case 2 -> {
                    int id = readIntWithPrompt("Enter Patient ID to search: ");
                    Patient found = patientBST.search(id);
                    if (found != null) {
                        System.out.println("Patient found: " + found);
                    } else {
                        System.out.println("No patient found with ID " + id);
                    }
                }
                case 3 -> {
                    int id = readIntWithPrompt("Enter Patient ID to delete: ");
                    patientBST.delete(id);
                    System.out.println("Delete operation completed.");
                }
                case 4 -> {
                    System.out.println("Patients in ascending order of ID:");
                    patientBST.displayInOrder();
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void emergencyQueueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Emergency Patient Queue ---");
            System.out.println("1. Enqueue patient (by existing Patient ID)");
            System.out.println("2. Dequeue next patient for treatment");
            System.out.println("3. Display waiting queue");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");

            switch (readInt()) {
                case 1 -> {
                    int id = readIntWithPrompt("Enter Patient ID (must already exist in Patient Records): ");
                    Patient patient = patientBST.search(id);
                    if (patient == null) {
                        System.out.println("No such patient exists. Please add them under Patient Records first.");
                    } else {
                        emergencyQueue.enqueue(patient);
                    }
                }
                case 2 -> {
                    Patient treated = emergencyQueue.dequeue();
                    if (treated != null) {
                        System.out.println("Now treating: " + treated);
                    }
                }
                case 3 -> {
                    System.out.println("Patients currently waiting:");
                    emergencyQueue.display();
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void treatmentHistoryMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Treatment History (Stack) ---");
            System.out.println("1. Push completed treatment record");
            System.out.println("2. Pop most recent treatment record");
            System.out.println("3. Display all treatment records");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");

            switch (readInt()) {
                case 1 -> {
                    int id = readIntWithPrompt("Enter Patient ID: ");
                    Patient patient = patientBST.search(id);
                    String patientName = (patient != null) ? patient.getName() : "Unknown";
                    String details = readLine("Enter Treatment Details: ");
                    String date = readLine("Enter Completion Date (e.g. 2026-09-05): ");

                    TreatmentRecord record = new TreatmentRecord(id, patientName, details, date);
                    treatmentStack.push(record);
                    System.out.println("Treatment record pushed to history.");
                }
                case 2 -> {
                    TreatmentRecord popped = treatmentStack.pop();
                    if (popped != null) {
                        System.out.println("Removed most recent record: " + popped);
                    }
                }
                case 3 -> {
                    System.out.println("Treatment records (most recent first):");
                    treatmentStack.display();
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void visitHistoryMenu() {
        int id = readIntWithPrompt("\nEnter Patient ID to manage visit history: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("No patient found with ID " + id + ". Please add them under Patient Records first.");
            return;
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- Visit History for " + patient.getName() + " (ID: " + id + ") ---");
            System.out.println("1. Add new visit");
            System.out.println("2. Remove visit by Visit ID");
            System.out.println("3. Search visit by Visit ID");
            System.out.println("4. Display all visits");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");

            switch (readInt()) {
                case 1 -> {
                    String visitId = readLine("Enter Visit ID: ");
                    String date = readLine("Enter Visit Date: ");
                    String doctor = readLine("Enter Doctor Name: ");
                    String diagnosis = readLine("Enter Diagnosis: ");
                    String treatment = readLine("Enter Treatment: ");

                    Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
                    patient.getVisitHistory().addVisit(visit);
                    System.out.println("Visit added to history.");
                }
                case 2 -> {
                    String visitId = readLine("Enter Visit ID to remove: ");
                    boolean removed = patient.getVisitHistory().removeVisit(visitId);
                    System.out.println(removed ? "Visit removed." : "Visit ID not found.");
                }
                case 3 -> {
                    String visitId = readLine("Enter Visit ID to search: ");
                    Visit found = patient.getVisitHistory().searchVisit(visitId);
                    System.out.println(found != null ? "Found: " + found : "Visit ID not found.");
                }
                case 4 -> {
                    System.out.println("Visit history:");
                    patient.getVisitHistory().display();
                }
                case 0 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static int readInt() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static int readIntWithPrompt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
