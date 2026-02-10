package com.hospital.patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private List<Patient> patients = new ArrayList<>();

    public boolean registerPatient(Patient patient) {
        if (patient == null) {
            return false;
        }
        patients.add(patient);
        return true;
    }

    public int getPatientCount() {
        return patients.size();
    }
}
package com.hospital.patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private List<Patient> patients = new ArrayList<>();

    public boolean registerPatient(Patient patient) {
        if (patient == null) {
            return false;
        }
        patients.add(patient);
        return true;
    }

    public int getPatientCount() {
        return patients.size();
    }
}
