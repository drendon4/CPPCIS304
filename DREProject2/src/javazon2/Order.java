package javazon2;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Order {

    //class variables
    private String orderID;
    private Customer orderCustomer;
    private Clerk orderClerk;
    private ArrayList<LineItem> lineItems;

    //store totals
    private double subtotal;
    private double tax;
    private double total;

    //constant defining tax
    private static double TAX_RATE = 0.0825;

    private int productCount;

    NumberFormat nf = NumberFormat.getCurrencyInstance();

    public Order(String anID) {
        lineItems = new ArrayList<LineItem>();
        orderID = anID;
        subtotal = 0;
        tax = 0;
        total = 0;
    }

    public void setOrderID(String anID) {
        orderID = anID;
    }

    public void setOrderCustomer(Customer aCustomer) {
        orderCustomer = aCustomer;
    }

    public void setOrderClerk(Clerk aClerk) {
        orderClerk = aClerk;
    }

    public void setOrderProduct(Product aProduct, int aQty) {

        productCount++;
        //Write the code to create a new line item
        //based on the variables aProduct and aQty that are passed
        //add that line item to the LineItems arraylist
        LineItem aLineItem = new LineItem(aProduct, aQty);
        lineItems.add(aLineItem);
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public String getOrderID() {
        return orderID;
    }

    public void calcSubtotal() {
        //Write the code to calculate the subtotal for all items
        //Loop through the lineItems arraylist
        //add up the total from each line to the subtotal variable
        for (LineItem li : lineItems) {
            subtotal += li.getJvzLineTotal();
        }
    }

    public void calcTax() {
        //calculate the tax by multiplying subtotal by tax rate
        tax = subtotal * TAX_RATE;
    }

    public void calcTotal() {
        //caltulates the total by adding subtotal and tax
        total = subtotal + tax;
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        String result = "";
        result += "CASHIER @ REGISTER\n " + orderClerk.getFirstName() + " " + orderClerk.getLastName() + " @ " + orderClerk.getRegisterNbr() + "\n\n";
        result += "Order # " + orderID + "\n\n";
        result += "CUSTOMER INFO\n" + orderCustomer.toString() + "";
        result += "\nNUMBER OF ITEMS SOLD = " + getNumberItemsSold() + "\n\n";

        for (LineItem li : lineItems) {
            result += li.getJvzQuantity() + "  @  " + nf.format(li.getJvzProduct().getPrice()) + " = " + nf.format(li.getJvzQuantity() * li.getJvzProduct().getPrice()) + "\n";
            result += "    " + li.getJvzProduct().getDescription() + "\n\n";
        }

        result += "TOTALS\n";
        result += "Subtotal: " + nf.format(subtotal) + "\n";
        result += "Tax: " + nf.format(tax) + "\n";
        result += "Total: " + nf.format(total);

        return result;
    }

    //Returns the number of items sold
    public int getNumberItemsSold() {
        int totalQty = 0;
        for (LineItem li : lineItems) {
            totalQty += li.getJvzQuantity();
        }
        return totalQty;
    }

    //CREATED THIS METHOD TO GET SUBTOTAL
    public String getSubtotal() {
        return nf.format(subtotal);
    }

    //CREATED THIS METHOD TO GET TAX
    public String getTax() {
        return nf.format(tax);
    }

    //CHANGED DATA TYPE FROM DOUBLE TO STRING
    public String getTotal() {
        return nf.format(total);
    }

    public Customer getCustomer() {
        return orderCustomer;
    }

    public double getLineTotal(int iLine) {
        //Select the LineItem from the ArrayList
        LineItem selectedItem = lineItems.get(iLine);

        //Get the total for that item
        return selectedItem.getJvzLineTotal();
    }
}
