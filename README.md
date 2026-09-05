# Mini Hospital Emergency Management System

**Course:** CIT300 - Data Structures and Algorithms
**Assignment:** Individual Mid Assignment

## Overview
A console-based Java application that simulates patient registration, emergency
treatment queuing, treatment history logging, and per-patient visit history for a
mini hospital emergency unit.

## Data Structures Used

| Requirement | Data Structure | File(s) |
|---|---|---|
| Patient Records | Binary Search Tree (keyed on Patient ID) | `PatientBST.java`, `Patient.java` |
| Emergency Patient Queue | Custom FIFO Queue (linked nodes) | `EmergencyQueue.java` |
| Treatment History | Custom LIFO Stack (linked nodes) | `TreatmentStack.java`, `TreatmentRecord.java` |
| Patient Visit History | Singly Linked List (one per patient) | `VisitLinkedList.java`, `Visit.java` |

All four structures are implemented manually (no `java.util.Stack`,
`java.util.Queue`, or `java.util.LinkedList`) to demonstrate understanding of the
underlying mechanics, as required by the course.

## Project Structure
```
HospitalEMS/
├── src/
│   ├── Main.java               # Console menu, ties everything together
│   ├── Patient.java            # Patient record (holds a VisitLinkedList)
│   ├── PatientBST.java         # BST: insert, search, delete, in-order traversal
│   ├── EmergencyQueue.java     # Queue: enqueue, dequeue, display
│   ├── TreatmentRecord.java    # Data held in the treatment stack
│   ├── TreatmentStack.java     # Stack: push, pop, display
│   ├── Visit.java              # Node for the visit history linked list
│   └── VisitLinkedList.java    # Linked list: add, remove, search, display
└── README.md
```

## How to Run
```bash
cd HospitalEMS
javac -d bin src/*.java
java -cp bin Main
```

## Sample Usage Flow
1. **Patient Records** → Insert a few patients (unique Patient IDs).
2. **Emergency Queue** → Enqueue an existing patient by ID; display the queue;
   dequeue to simulate calling the next patient in for treatment.
3. **Treatment History** → After treating a patient, push a treatment record;
   display the stack to see the most recent treatment on top.
4. **Visit History** → Pick a patient by ID and add/search/remove/display their
   past visits.

## Design Notes
- The BST delete handles all three standard cases: leaf node, single child, and
  two children (replaced with the in-order successor).
- The Queue and Stack are implemented with their own lightweight linked node
  classes so no capacity limit applies and operations stay O(1).
- Each `Patient` owns its own `VisitLinkedList` instance, so visit history is
  naturally scoped per patient rather than stored in one shared list.

## Author
ABF.SARAFA
Email: 23DA2-1167@sltc.ac.lk
