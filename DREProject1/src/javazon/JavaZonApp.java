package javazon;

import javax.swing.JOptionPane;

public class JavaZonApp {

    public static void main(String[] args) {

        //COLLECT INFORMATION USING JOPTIONPANE
        //PASS INPUT FROM DIALOG AND VALIDATE
        String firstName = Validator.getValidFirstName(JOptionPane.showInputDialog("Enter First Name"));
        String lastName = Validator.getValidLastName(JOptionPane.showInputDialog("Enter Last Name"));
        String street = Validator.getValidStreet(JOptionPane.showInputDialog("Enter Street"));
        String city = Validator.getValidCity(JOptionPane.showInputDialog("Enter City"));
        String state = Validator.getValidState(JOptionPane.showInputDialog("Enter State"));
        String zip = Validator.getValidZip(JOptionPane.showInputDialog("Enter Zip"));
        String phone = Validator.getValidPhone(JOptionPane.showInputDialog("Enter Phone Number"));
        String membership = Validator.getValidMembership(JOptionPane.showInputDialog("Enter Membership Number"));

        //CREATE A NEW CUSTOMER OBJECT (uncomment line below)
        Customer customer = new Customer(firstName, lastName, street, city, state, zip, phone, membership);

        //CREATE NEW ORDER OBJECT
        Order order = new Order();

        //SET ORDER CUSTOMER
        order.setOrderCustomer(customer);

        //LOOP TO COLLECT PRODUCTS SELECTED BY USER AND THEIR QUANTITIES
        do {
            //CREATE MENU OBJECT
            Menu menu = new Menu();

            //Get the items from the menu class, and load them into the
            //JOptionPane menu
            String menuItems[] = menu.getMenuDescriptions();

            int intCode = 0;
            do {
                intCode = JOptionPane.showOptionDialog(null, "Select an Option",
                        "Menu Items", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, menuItems, menuItems[0]);

            } while (intCode == -1);
            
            //RETURN PRODUCT FROM MENU
            Product product = menu.getMenu()[intCode];

            //PROMPT USER TO ENTER QUANTITY
            String qty = Validator.getValidProductQuantity(JOptionPane.showInputDialog("Enter Quantity"));

            //ADD PRODUCT AND QUANTITY TO ORDER
            order.setOrderProduct(product, Integer.parseInt(qty));

        } while (JOptionPane.showConfirmDialog(null,
                "Enter More Products?",
                "User Selection",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null) != JOptionPane.NO_OPTION);

        //CREATE A NEW JAVAZON STORE
        JavaZon jz = new JavaZon();

        //ADD THE ORDER TO THE STORE
        jz.setOrder(order);

        //ASSIGN A CLERK TO THE ORDER
        jz.setClerk();

        //PROCESS ORDER
        jz.processOrder();

        //DISPLAY THE RESULT
        JOptionPane.showMessageDialog(null, jz.getReceipt());
    }

}
