package javazon2;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.File;

import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.BufferedWriter;

import javax.swing.JOptionPane;

public class JavaZon {

    private ArrayList<Clerk> clerksList;        //Arraylist to hold all the clerks
    private HashMap<String, Order> jvzOrder;    //Hashmap to hold orders the key pair value consists of (OrderID, Order Object)

    private Menu menu;

    public JavaZon() {
        //initialize the Clerk
        clerksList = new ArrayList<Clerk>();
        //initialize the orders
        jvzOrder = new HashMap<String, Order>();
        //load clerks
        loadClerkList();
    }

    public void addOrder(Order anOrder) {
        //Code to add an order to the HashMap
        //USE THE jvzOrder object and add a new order to the hashmap
        //you need to use the orderid and the order object (anOrder)
        //The order id value is located in the order object
        jvzOrder.put(anOrder.getOrderID(), anOrder);
    }

    public void processOrder(String anID) {
        Order selectedOrder = jvzOrder.get(anID);
        selectedOrder.calcSubtotal();
        selectedOrder.calcTax();
        selectedOrder.calcTotal();
    }

    public void loadClerkList() {
        Clerk musicClerk = new Clerk("EMP100", 1, "Homer", "Simpson", "243 North Main", "Spingfield", "CA", "98765", "909-987-6666");
        Clerk bookClerk = new Clerk("EMP200", 2, "Bart", "Simpson", "454 North Euclid", "Spingfield", "CA", "98765", "909-987-4444");
        Clerk gameClerk = new Clerk("EMP300", 3, "Lisa", "Simpson", "767 North Holt", "Spingfield", "CA", "98765", "909-987-3333");

        clerksList.add(musicClerk);
        clerksList.add(bookClerk);
        clerksList.add(gameClerk);
    }

    public void setClerk(String anID) {
        Random rand = new Random();
        int i = rand.nextInt(3);

        Order selectedOrder = jvzOrder.get(anID);
        selectedOrder.setOrderClerk(clerksList.get(i));
    }

    public String getReceipt(String anID) {
        String result;

        Order selectedOrder = jvzOrder.get(anID);

        result = "JAVAZON WHOLESALE STORE\n\n";
        result += "90404 CENTRAL AVE\n";
        result += "MONTCLAIR, CA, 91763\n";
        result += "  (909)345-9876\n\n";
        result += selectedOrder.toString();

        return result;
    }

    public String getOrdersSummary() {
        String result = "";
        Order selectedOrder;
        Customer selectedCustomer;

        //For Loop through the orders in the HashMap
        //Retrieve each order and store it in the selectedOrder object
        //retrieve the customer using the getCustomer method of the selectedOrder
        //Store the customer in the selectedCustomer object
        //retrieve the customer first/last name from the selectCustomer Object
        //retrieve the order total from the selectedOrder object
        //return a String result that has all the orders in the HashMap
        //See screen printout for an example of what the result should look like
        for (Map.Entry<String, Order> o : jvzOrder.entrySet()) {
            selectedOrder = o.getValue();
            selectedCustomer = selectedOrder.getCustomer();

            result += "Order ID: " + selectedOrder.getOrderID() + ", Customer: " + selectedCustomer.getFirstName() + ' ' + selectedCustomer.getLastName() + ", Total: " + selectedOrder.getTotal() + '\n';
        }
        return result;
    }

    public String deleteOrder(String anID) {
        String result = "Order ID " + anID + " was not found.\n";

        //check if the HashMap contains the order
        //If it does then remove that order from the hashMap
        //Return a message that displays the OrderID has been Deleted Or not found
        //put the result from the delete into the string result
        for (Map.Entry<String, Order> o : jvzOrder.entrySet()) {
            if (o.getValue().getOrderID().equals(anID)) {
                jvzOrder.remove(o.getKey());
                result = "Order ID " + anID + " has been deleted.\n";
                break;
            }
        }
        return result;
    }

    public Order findOrder(String anID) {
        Order selectedOrder = null;

        //check if the HashMap contains the order
        //If it does then store the order in selectedOrder and return selectedOrder
        //If the order is not found then return a null
        for (Map.Entry<String, Order> o : jvzOrder.entrySet()) {
            if (o.getValue().getOrderID().equals(anID)) {
                selectedOrder = o.getValue();
            }
        }
        return selectedOrder;
    }

    public void clearOrders() {
        //Clear the hashmap of all orders
        jvzOrder.clear();
    }

    public int updateOrder(String aOrderID) {
        int found = 0;
        Order selectedOrder = findOrder(aOrderID);

        if (selectedOrder == null) {
            JOptionPane.showMessageDialog(null, "Order ID " + aOrderID + " was not found.\n");
        } else {
            deleteOrder(aOrderID);
            found = 1;
            JOptionPane.showMessageDialog(null, "Order ID " + aOrderID + " was updated.\n");
        }
        return found;
    }

    public String importOrder() {
        String[] fileArray = new String[15];
        String result = "";
        menu = new Menu();

        try {
            JFileChooser fileChooser = new JFileChooser("C:\\");
            fileChooser.setDialogTitle("Specify a location to save");

            int fileSelection = fileChooser.showOpenDialog(null);

            if (fileSelection == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile().getAbsoluteFile();

                FileReader fr = new FileReader(selectedFile);
                BufferedReader br = new BufferedReader(fr);

                String line = br.readLine();

                while (line != null) {
                    String parts[] = line.split("\t", -1);

                    for (int i = 0; i < parts.length; i++) {
                        fileArray[i] = parts[i];
                    }

                    if (fileArray[9] != null) {
                        for (int i = 0; i < menu.getMenu().length; i++) {
                            if (fileArray[9].equals(menu.getMenu()[i].getDescription())) {
                                fileArray[9] = String.valueOf(i);
                            }
                        }
                    }

                    if (fileArray[11] != null) {
                        for (int i = 0; i < menu.getMenu().length; i++) {
                            if (fileArray[11].equals(menu.getMenu()[i].getDescription())) {
                                fileArray[11] = String.valueOf(i);
                            }
                        }
                    }
                    if (fileArray[13] != null) {
                        for (int i = 0; i < menu.getMenu().length; i++) {
                            if (fileArray[13].equals(menu.getMenu()[i].getDescription())) {
                                fileArray[13] = String.valueOf(i);
                            }
                        }
                    }

                    if (fileArray[9] == null) {
                        fileArray[9] = "-1";
                        fileArray[10] = "";
                        fileArray[11] = "-1";
                        fileArray[12] = "";
                        fileArray[13] = "-1";
                        fileArray[14] = "";
                    }
                    if (fileArray[11] == null) {
                        fileArray[11] = "-1";
                        fileArray[12] = "";
                        fileArray[13] = "-1";
                        fileArray[14] = "";
                    }
                    if (fileArray[13] == null) {
                        fileArray[13] = "-1";
                        fileArray[14] = "";
                    }

                    Customer customer = new Customer(fileArray[1], fileArray[2], fileArray[3], fileArray[4], fileArray[5], fileArray[6], fileArray[7], fileArray[8]);

                    Order order = new Order(fileArray[0]);
                    order.setOrderCustomer(customer);

                    if (!fileArray[9].equals("-1")) {
                        Product product1 = menu.getMenu()[Integer.parseInt(fileArray[9])];
                        order.setOrderProduct(product1, Integer.parseInt(fileArray[10]));
                    }

                    if (!fileArray[11].equals("-1")) {
                        Product product2 = menu.getMenu()[Integer.parseInt(fileArray[11])];
                        order.setOrderProduct(product2, Integer.parseInt(fileArray[12]));
                    }

                    if (!fileArray[13].equals("-1")) {
                        Product product3 = menu.getMenu()[Integer.parseInt(fileArray[13])];
                        order.setOrderProduct(product3, Integer.parseInt(fileArray[14]));
                    }

                    addOrder(order);
                    setClerk(fileArray[0]);
                    processOrder(fileArray[0]);

                    result += "Order " + fileArray[0] + " was created\n";

                    line = br.readLine();
                }

                br.close();
                fr.close();
            } else {
                result = "File not selected\n";
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "There was an error saving to the system\n\n" + ioe.getMessage());
        }
        return result;
    }

    public String exportOrder() {
        String result = "";
        String orders = "";

        Order selectedOrder;
        Customer selectedCustomer;

        try {
            JFileChooser fileChooser = new JFileChooser("C:\\");
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File path = fileChooser.getSelectedFile();

                FileWriter fw = new FileWriter(path);
                BufferedWriter bw = new BufferedWriter(fw);

                for (Map.Entry<String, Order> o : jvzOrder.entrySet()) {
                    selectedOrder = o.getValue();
                    selectedCustomer = selectedOrder.getCustomer();

                    orders += selectedOrder.getOrderID() + "\t" + selectedCustomer.getFirstName() + "\t" + selectedCustomer.getLastName() + "\t" + selectedCustomer.getAddress() + "\t" + selectedCustomer.getCity() + "\t" + selectedCustomer.getState() + "\t" + selectedCustomer.getZip() + "\t" + selectedCustomer.getPhone() + "\t" + selectedCustomer.getMemberShipID() + "\t";
                    for (LineItem li : selectedOrder.getLineItems()) {
                        orders += li.getJvzProduct().getDescription() + "\t" + li.getJvzQuantity() + "\t";
                    }
                    orders = orders.substring(0, orders.length() - 1);
                    orders += "\r\n";
                    result += "Order " + selectedOrder.getOrderID() + " was exported\n";
                }
                bw.write(orders);
                bw.close();
                fw.close();
            } else {
                result = "File not selected\n";
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "There was an error writing to the file\n\n" + ioe.getMessage());
        }
        return result;
    }
}
