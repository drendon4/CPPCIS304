package javazon;

import java.util.Random;

public class JavaZon {

    private Clerk[] arrClerks;
    private Order jvzOrder;

    //CLASS CONSTRUCTOR
    public JavaZon() {
        loadClerkList();
    }

    //ASSIGN AN ORDER THROUGH SETTER
    public void setOrder(Order anOrder) {
        jvzOrder = anOrder;
    }

    //PROCESS ORDER
    public void processOrder() {
        //TODO CALL JVZ ORDER METHODS TO PERFORM CALCULATIONS
        //SUBTOTAL
        //TAX
        //TOTAL
        jvzOrder.calcSubtotal();
        jvzOrder.calcTax();
        jvzOrder.calcTotal();
    }

    //METHOD TO LOAD CLERKS
    public void loadClerkList() {
        arrClerks = new Clerk[3];
        Clerk musicClerk = new Clerk("EMP100", 1, "Homer", "Simpson", "243 North Main", "Spingfield", "CA", "98765", "909-987-6666");
        Clerk bookClerk = new Clerk("EMP200", 2, "Bart", "Simpson", "454 North Euclid", "Spingfield", "CA", "98765", "909-987-4444");
        Clerk gameClerk = new Clerk("EMP300", 3, "Lisa", "Simpson", "767 North Holt", "Spingfield", "CA", "98765", "909-987-3333");

        //TODO 
        //ADD THESE CLERKS TO THE CLERK ARRAY
        arrClerks[0] = musicClerk;
        arrClerks[1] = bookClerk;
        arrClerks[2] = gameClerk;

    }

    //METHOD TO SET A CLERK TO THE ORDER
    public void setClerk() {
        //TODO
        //Randomly assign a clerk to order using .setOrderClerk 
        //(see your textbook to see how to use the Random class to generate random numbers)
        //GenErate a random number between 0 and 2
        //use the number as the index of the clerk array 
        //add your code below

        Random rand = new Random();
        int ranNum = rand.nextInt(2);

        //pass the clerk object to the setOrderClerk method OF THE JVZORDER 
        //add your code below
        jvzOrder.setOrderClerk(arrClerks[ranNum]);

    }

    //RETURN RECEIPT
    public String getReceipt() {
        String result;

        result = "JAVAZON WHOLESALE STORE\n\n";

        result += "90404 CENTRAL AVE\n";
        result += "MONTCLAIR, CA 91763\n";
        result += "  (909)345-9876\n\n";

        result += jvzOrder.toString();

        return result;

    }
}
