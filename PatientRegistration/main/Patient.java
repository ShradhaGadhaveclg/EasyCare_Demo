//package PatientRegistration.main;

public class Patient {

    private String id;
    private String name;
    private int age;
    private String contactNumber;
    private String password;   // NEW

    public Patient(String id, String name, int age,
                   String contactNumber, String password) {

        if (id == null || id.isBlank())
            throw new IllegalArgumentException("ID cannot be empty");

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty");

        if (age <= 0)
            throw new IllegalArgumentException("Invalid age");

        if (contactNumber == null || contactNumber.length() != 10)
            throw new IllegalArgumentException("Contact number must be 10 digits");

        if (password == null || password.length() < 4)
            throw new IllegalArgumentException("Password must be at least 4 characters");

        this.id = id;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
