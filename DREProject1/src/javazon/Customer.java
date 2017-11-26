package javazon;

public class Customer extends Person {
	private String memberShipID; 

	//OBJECT CONSTRUCTOR
	public Customer(String firstName, String lastName, String anAddress, String city, String state, String zip, String phone, String aMemberShipID) 
        {
            super(firstName, lastName, anAddress, city, state, zip, phone);
            memberShipID = aMemberShipID;
	}
	
	//METHOD TO RETURN SUMMARY ABOUT OBJECT
	public String toString(){
		String result="";
		
		result += "Member ID: " + memberShipID + "\n";
		result += super.toString();
		
		
		return result;
	}

}
