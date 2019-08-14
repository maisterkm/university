package ua.com.foxminded.university.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private int personId;
    private String firstName;
    private String lastName;
    Calendar dateOfBirth = new GregorianCalendar();
    Calendar enrollmentDate = new GregorianCalendar();
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyy");

    public Person() {}
    
    public Person(int id, String firstName, String lastName, int birthDay, int birthMonth, int birthYear,
            int enrollmentDay, int enrollmentMonth, int enrollmentYear) {
        this.personId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        dateOfBirth.set(Calendar.YEAR, birthYear);
        dateOfBirth.set(Calendar.MONTH, birthMonth - 1);
        dateOfBirth.set(Calendar.DAY_OF_MONTH, birthDay);
        enrollmentDate.set(Calendar.YEAR, enrollmentYear);
        enrollmentDate.set(Calendar.MONTH, enrollmentMonth - 1);
        enrollmentDate.set(Calendar.DAY_OF_MONTH, enrollmentDay);
    }
    
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int id) {
        this.personId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public Calendar getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Calendar enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", id: " + personId + ", first name: " + firstName
                + ", last name: " + lastName + ", date of birth: " + sdf.format(dateOfBirth.getTime())
                + ", enrollment date: " + sdf.format(enrollmentDate.getTime());
        return output;
    }
}
