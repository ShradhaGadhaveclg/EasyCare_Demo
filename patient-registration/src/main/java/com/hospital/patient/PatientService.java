package com.hospital.patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientService {

    private List<Patient> patients = new ArrayList<>();

    // Register patient
    public boolean registerPatient(Patient patient) {

        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }

        if (patient.getAge() <= 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        // Check duplicate ID
        for (Patient p : patients) {
            if (p.getId().equals(patient.getId())) {
                throw new IllegalArgumentException("Patient ID already exists");
            }
        }

        patients.add(patient);
        return true;
    }

    // Get patient by ID
    public Optional<Patient> getPatientById(String id) {
        return patients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Get total patient count
    public int getTotalPatients() {
        return patients.size();
    }

    // Remove patient
    public boolean removePatient(String id) {
        return patients.removeIf(p -> p.getId().equals(id));
    }
}
