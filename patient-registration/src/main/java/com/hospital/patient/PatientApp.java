package com.hospital.patient;

public class PatientApp {

    public static void main(String[] args) {
        PatientService service = new PatientService();
        service.registerPatient(new Patient("P01", "Riya", 22));
        System.out.println("Total patients: " + service.getPatientCount());
    }
}
