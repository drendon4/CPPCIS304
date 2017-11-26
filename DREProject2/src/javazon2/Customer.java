package javazon2;

public class Customer extends Person {

    private String memberShipID;

    public Customer(String firstName, String lastName, String anAddress, String city, String state, String zip, String phone, String aMemberShipID) {

        super(firstName, lastName, anAddress, city, state, zip, phone);

        memberShipID = aMemberShipID;
    }

    public String getMemberShipID() {
        return memberShipID;
    }
    
    public void setMembershipID(String aMembershipID){
        this.memberShipID = aMembershipID;
    }

    public String toString() {
        String result = "";

        result += "Member ID: " + memberShipID + "\n";
        result += super.toString();

        return result;
    }
}