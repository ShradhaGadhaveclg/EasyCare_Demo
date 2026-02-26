//package PatientRegistration.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientService {

    private List<Patient> patients = new ArrayList<>();

    // REGISTER
    public boolean registerPatient(Patient patient) {

        if (patient == null)
            throw new IllegalArgumentException("Patient cannot be null");

        for (Patient p : patients) {
            if (p.getId().equals(patient.getId())) {
                throw new IllegalArgumentException("Patient ID already exists");
            }
        }

        patients.add(patient);
        return true;
    }

    // LOGIN
    public boolean login(String id, String password) {

        Optional<Patient> patient = patients.stream()
                .filter(p -> p.getId().equals(id)
                        && p.getPassword().equals(password))
                .findFirst();

        return patient.isPresent();
    }

    // VIEW
    public Optional<Patient> getPatientById(String id) {
        return patients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // REMOVE
    public boolean removePatient(String id) {
        return patients.removeIf(p -> p.getId().equals(id));
    }

    public int getTotalPatients() {
        return patients.size();
    }

    public void clearAll() {
        patients.clear();
    }
}
