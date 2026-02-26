//package PatientRegistration.test;

//import PatientRegistration.main.Patient;
//import PatientRegistration.main.PatientService;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

public class PatientServiceTest {

    private PatientService service;

    @Before
    public void setUp() {
        service = new PatientService();
    }

    @After
    public void tearDown() {
        service.clearAll();
    }

    @Test
    public void testRegisterPatientSuccessfully() {
        System.out.println("Running: testRegisterPatientSuccessfully");

        Patient p = new Patient("P01", "Riya", 22, "9876543210", "pass123");

        Assert.assertTrue(service.registerPatient(p));
        Assert.assertEquals(1, service.getTotalPatients());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicatePatientId() {
        System.out.println("Running: testDuplicatePatientId");

        Patient p1 = new Patient("P02", "Amit", 25, "9999999999", "abcd");
        Patient p2 = new Patient("P02", "Neha", 30, "8888888888", "xyz1");

        service.registerPatient(p1);
        service.registerPatient(p2);  // should throw exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAge() {
        System.out.println("Running: testInvalidAge");

        new Patient("P03", "Rohan", -5, "7777777777", "pass");
    }

    @Test
    public void testLoginSuccess() {
        System.out.println("Running: testLoginSuccess");

        Patient p = new Patient("P04", "Sneha", 28, "6666666666", "mypassword");
        service.registerPatient(p);

        Assert.assertTrue(service.login("P04", "mypassword"));
    }

    @Test
    public void testLoginFailure() {
        System.out.println("Running: testLoginFailure");

        Patient p = new Patient("P05", "Kiran", 35, "5555555555", "secret");
        service.registerPatient(p);

        Assert.assertFalse(service.login("P05", "wrongpass"));
    }

    @Test
    public void testRemovePatient() {
        System.out.println("Running: testRemovePatient");

        Patient p = new Patient("P06", "Rahul", 40, "4444444444", "test");
        service.registerPatient(p);

        Assert.assertTrue(service.removePatient("P06"));
        Assert.assertEquals(0, service.getTotalPatients());
    }

    @Test
    public void testPasswordNotEqual() {
        System.out.println("Running: testPasswordNotEqual");

        Patient p = new Patient("P07", "Anjali", 23, "3333333333", "abcd");

        Assert.assertNotEquals("1234", p.getPassword());
    }

    @Test
    public void testRepeatedLogin() {
        System.out.println("Running: testRepeatedLogin (manual repeat)");

        for (int i = 0; i < 3; i++) {

            Patient p = new Patient("P08", "TestUser", 30, "2222222222", "repeat");
            service.registerPatient(p);

            Assert.assertTrue(service.login("P08", "repeat"));
            service.clearAll();
        }
    }
}