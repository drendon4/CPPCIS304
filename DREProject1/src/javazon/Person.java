package javazon;

public class Person {

    private String address;
    private String city;
    private String firstName;
    private String lastName;
    private String phone;
    private String state;
    private String zip;

    public Person(String aFirstName, String aLastName, String anAddress, String aCity, String aState, String aZip, String aPhone) {
        //TODO
        //COPY VARIABLES INTO LOCAL CLASS VARIABLES
        firstName = aFirstName;
        lastName = aLastName;
        address = anAddress;
        city = aCity;
        state = aState;
        zip = aZip;
        phone = aPhone;
    }

    public String toString() {
        String result = "";

        result += "Name: " + firstName + " " + lastName + "\n";
        result += "Phone: " + phone + "\n\n";
        result += "Address\n";
        result += address + "\n";
        result += city + ", " + state + " " + zip + "\n";

        return result;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
