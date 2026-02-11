package com.hospital.patient;
import org.junit.*;


import java.util.Optional;

public class PatientServiceTest {

    private PatientService service;

    @Before
    public void setUp() {
        service = new PatientService();
    }

    @Test
    public void testRegisterPatientSuccessfully() {
        Patient patient = new Patient("P01", "Riya", 22, "9876543210");
        boolean result = service.registerPatient(patient);

        Assert.assertTrue(result);
        Assert.assertEquals(1, service.getTotalPatients());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRegisterNullPatient() {
        service.registerPatient(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAge() {
        Patient patient = new Patient("P02", "Amit", -5, "9999999999");
        service.registerPatient(patient);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicatePatientId() {
        Patient p1 = new Patient("P03", "Neha", 25, "8888888888");
        Patient p2 = new Patient("P03", "Rahul", 30, "7777777777");

        service.registerPatient(p1);
        service.registerPatient(p2);
    }

    @Test
    public void testGetPatientById() {
        Patient p = new Patient("P04", "Sneha", 28, "6666666666");
        service.registerPatient(p);

        Optional<Patient> result = service.getPatientById("P04");

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals("Sneha", result.get().getName());
    }

    @Test
    public void testRemovePatient() {
        Patient p = new Patient("P05", "Rohan", 40, "5555555555");
        service.registerPatient(p);

        boolean removed = service.removePatient("P05");

        Assert.assertTrue(removed);
        Assert.assertEquals(0, service.getTotalPatients());
    }

    @After
    public void tearDown() {
        service = null;
    }
}
