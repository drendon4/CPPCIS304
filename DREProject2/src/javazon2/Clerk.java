package javazon2;

public class Clerk extends Person {

    private String employeeID;
    private int registerNbr;

    public Clerk(String anID, int aRegister, String firstName, String lastName, String anAddress, String city, String state, String zip, String phone) {
        super(firstName, lastName, anAddress, city, state, zip, phone);
        employeeID = anID;
        registerNbr = aRegister;
    }

    public String toString() {
        String result = "";
        result += super.getFirstName();
        result += "EmployeeID:\t" + employeeID + "\n";
        return result;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public int getRegisterNbr() {
        return registerNbr;
    }
}
