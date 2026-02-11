package com.hospital.patient;

public class Patient {

    private String id;
    private String name;
    private int age;
    private String contactNumber;

    public Patient(String id, String name, int age, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

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
