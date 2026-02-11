package com.hospital.patient;

import java.util.Optional;
import java.util.Scanner;

public class PatientApp {

    public static void main(String[] args) {

        PatientService service = new PatientService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Patient Registration Menu ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patient");
            System.out.println("3. Remove Patient");
            System.out.println("4. Total Patients");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();

                    try {
                        service.registerPatient(new Patient(id, name, age, contact));
                        System.out.println("Patient registered successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    String searchId = scanner.nextLine();
                    Optional<Patient> patient = service.getPatientById(searchId);

                    if (patient.isPresent()) {
                        System.out.println(patient.get());
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String removeId = scanner.nextLine();

                    if (service.removePatient(removeId)) {
                        System.out.println("Patient removed successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 4:
                    System.out.println("Total patients: " + service.getTotalPatients());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
