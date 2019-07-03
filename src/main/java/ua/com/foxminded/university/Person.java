package ua.com.foxminded.university;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String enrollmentDate;
    
    public Person(int id, String firstName, String lastName, String dateOfBirth, String enrollmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
        
        
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dateBirth = sdf.parse(dateOfBirth);
            Date enrollDate = sdf.parse(enrollmentDate);
//            System.out.println("dateOfBirth : " + sdf.format(dateBirth));
//            System.out.println("dateOfBirth : " + sdf.format(enrollDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() +  ", id: " + id + ", first name: " + firstName + ", last name: " + lastName + 
                ", date of birth: " + dateOfBirth + ", enrollment date:" + enrollmentDate;
        
        return output;
    }
    
}
