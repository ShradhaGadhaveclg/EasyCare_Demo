//package PatientRegistration.main;

import java.util.Optional;
import java.util.Scanner;

public class PatientApp {

    public static void main(String[] args) {

        PatientService service = new PatientService();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Patient System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Profile");
            System.out.println("4. Remove Account");
            System.out.println("5. Total Patients");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: // REGISTER
                    try {
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Contact (10 digits): ");
                        String contact = scanner.nextLine();

                        System.out.print("Create Password: ");
                        String password = scanner.nextLine();

                        service.registerPatient(
                                new Patient(id, name, age, contact, password));

                        System.out.println("Registration Successful!");

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // LOGIN
                    System.out.print("Enter ID: ");
                    String loginId = scanner.nextLine();

                    System.out.print("Enter Password: ");
                    String loginPass = scanner.nextLine();

                    if (service.login(loginId, loginPass))
                        System.out.println("Login Successful!");
                    else
                        System.out.println("Invalid Credentials!");
                    break;

                case 3: // VIEW PROFILE
                    System.out.print("Enter ID: ");
                    String searchId = scanner.nextLine();

                    Optional<Patient> patient = service.getPatientById(searchId);

                    if (patient.isPresent())
                        System.out.println(patient.get());
                    else
                        System.out.println("Patient not found.");
                    break;

                case 4: // REMOVE
                    System.out.print("Enter ID: ");
                    String removeId = scanner.nextLine();

                    if (service.removePatient(removeId))
                        System.out.println("Account removed.");
                    else
                        System.out.println("Patient not found.");
                    break;

                case 5:
                    System.out.println("Total patients: "
                            + service.getTotalPatients());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
