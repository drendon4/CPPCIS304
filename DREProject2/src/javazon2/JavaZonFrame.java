package javazon2;

//import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//import javax.swing.ComboBoxModel;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
//import javax.swing.SwingUtilities;

public class JavaZonFrame extends javax.swing.JFrame implements ActionListener, ItemListener {

    private JPanel jPanel1;

    private JTextField txtOrderID, txtFirstName, txtLastName, txtPhone, txtMembership;
    private JTextField txtStreet, txtCity, txtState, txtZip;

    private JComboBox cboItem1, cboItem2, cboItem3;
    private JTextField txtQty1, txtQty2, txtQty3;
    private JTextField txtPrice1, txtPrice2, txtPrice3;
    private JTextField txtLineTotal1, txtLineTotal2, txtLineTotal3;

    private JTextField txtSubtotal;
    private JTextField txtTax;
    private JTextField txtTotal;

    private JLabel lblTitle;
    private JLabel lblOrderID, lblFirstName, lblLastName, lblPhone, lblMembership;
    private JLabel lblStreet, lblCity, lblState, lblZip;

    private JLabel lblProduct, lblQuantity, lblPrice, lblLineTotal;
    private JLabel lblFileOptions;

    private JLabel lblSubtotal;
    private JLabel lblTax;
    private JLabel lblTotal;

    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnFind;
    private JButton btnList;
    private JButton btnClear;
    private JButton btnReset;
    private JButton btnUpdate;
    private JButton btnImport;
    private JButton btnExport;

    private JavaZon jz;
    private Menu menu;

    public JavaZonFrame() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            GridLayout thisLayout = new GridLayout();

            jz = new JavaZon();
            menu = new Menu();

            String menuItems[] = menu.getMenuDescriptions();

            getContentPane().setLayout(thisLayout);

            jPanel1 = new JPanel();
            getContentPane().add(jPanel1);
            GridBagLayout jPanel1Layout = new GridBagLayout();

            jPanel1.setLayout(jPanel1Layout);
            jPanel1.setPreferredSize(new java.awt.Dimension(499, 426));

            //ADD THE REST OF THE CONTROLS
            //REFER TO HANDOUT FOR THE CONTROLS NEEDED
            //AND THE LOCATION OF EACH ITEM
            lblTitle = new JLabel();
            jPanel1.add(lblTitle, gc(2, 0, 1, 2));
            lblTitle.setText("Welcome to JAVAZON III");

            lblOrderID = new JLabel();
            jPanel1.add(lblOrderID, gc(1, 1, 1, 1));
            lblOrderID.setText("Order ID:");

            txtOrderID = new JTextField(10);
            jPanel1.add(txtOrderID, gc(2, 1, 1, 1));

            lblFirstName = new JLabel();
            jPanel1.add(lblFirstName, gc(1, 3, 1, 1));
            lblFirstName.setText("First Name:");

            txtFirstName = new JTextField(10);
            jPanel1.add(txtFirstName, gc(2, 3, 1, 2));

            lblLastName = new JLabel();
            jPanel1.add(lblLastName, gc(4, 3, 1, 1));
            lblLastName.setText("Last Name:");

            txtLastName = new JTextField(10);
            jPanel1.add(txtLastName, gc(5, 3, 1, 2));

            ////////////////////////////////////
            lblMembership = new JLabel();
            jPanel1.add(lblMembership, gc(1, 4, 1, 1));
            lblMembership.setText("Membership:");

            txtMembership = new JTextField(10);
            jPanel1.add(txtMembership, gc(2, 4, 1, 1));

            lblPhone = new JLabel();
            jPanel1.add(lblPhone, gc(4, 4, 1, 1));
            lblPhone.setText("Phone:");

            txtPhone = new JTextField(10);
            jPanel1.add(txtPhone, gc(5, 4, 1, 2));

            lblStreet = new JLabel();
            jPanel1.add(lblStreet, gc(1, 5, 1, 1));
            lblStreet.setText("Street:");

            txtStreet = new JTextField(10);
            jPanel1.add(txtStreet, gc(2, 5, 1, 2));

            lblCity = new JLabel();
            jPanel1.add(lblCity, gc(1, 6, 1, 1));
            lblCity.setText("City:");

            txtCity = new JTextField(10);
            jPanel1.add(txtCity, gc(2, 6, 1, 1));

            lblState = new JLabel();
            jPanel1.add(lblState, gc(3, 6, 1, 1));
            lblState.setText("State:");

            txtState = new JTextField(10);
            jPanel1.add(txtState, gc(4, 6, 1, 1));

            lblZip = new JLabel();
            jPanel1.add(lblZip, gc(5, 6, 1, 1));
            lblZip.setText("Zip:");

            txtZip = new JTextField(10);
            jPanel1.add(txtZip, gc(6, 6, 1, 1));

            //////////////////////////////////// 
            lblProduct = new JLabel();
            jPanel1.add(lblProduct, gc(2, 7, 1, 1));
            lblProduct.setText("Product:");

            lblQuantity = new JLabel();
            jPanel1.add(lblQuantity, gc(3, 7, 1, 1));
            lblQuantity.setText("Quantity:");

            lblPrice = new JLabel();
            jPanel1.add(lblPrice, gc(4, 7, 1, 1));
            lblPrice.setText("Price:");

            lblLineTotal = new JLabel();
            jPanel1.add(lblLineTotal, gc(5, 7, 1, 1));
            lblLineTotal.setText("LineTotal:");

            //////////////////////////////////// 
            cboItem1 = new JComboBox();
            for (String menuItem : menuItems) {
                cboItem1.addItem(menuItem);
            }
            cboItem1.setSelectedIndex(-1);
            cboItem1.addItemListener(JavaZonFrame.this);
            jPanel1.add(cboItem1, gc(2, 8, 1, 1));

            cboItem2 = new JComboBox();
            for (String menuItem : menuItems) {
                cboItem2.addItem(menuItem);
            }
            cboItem2.setSelectedIndex(-1);
            cboItem2.addItemListener(JavaZonFrame.this);
            jPanel1.add(cboItem2, gc(2, 9, 1, 1));

            cboItem3 = new JComboBox();
            for (String menuItem : menuItems) {
                cboItem3.addItem(menuItem);
            }
            cboItem3.setSelectedIndex(-1);
            cboItem3.addItemListener(JavaZonFrame.this);
            jPanel1.add(cboItem3, gc(2, 10, 1, 1));

            txtQty1 = new JTextField(10);
            jPanel1.add(txtQty1, gc(3, 8, 1, 1));

            txtQty2 = new JTextField(10);
            jPanel1.add(txtQty2, gc(3, 9, 1, 1));

            txtQty3 = new JTextField(10);
            jPanel1.add(txtQty3, gc(3, 10, 1, 1));

            txtPrice1 = new JTextField(10);
            jPanel1.add(txtPrice1, gc(4, 8, 1, 1));

            txtPrice2 = new JTextField(10);
            jPanel1.add(txtPrice2, gc(4, 9, 1, 1));

            txtPrice3 = new JTextField(10);
            jPanel1.add(txtPrice3, gc(4, 10, 1, 1));

            txtLineTotal1 = new JTextField(10);
            jPanel1.add(txtLineTotal1, gc(5, 8, 1, 1));

            txtLineTotal2 = new JTextField(10);
            jPanel1.add(txtLineTotal2, gc(5, 9, 1, 1));

            txtLineTotal3 = new JTextField(10);
            jPanel1.add(txtLineTotal3, gc(5, 10, 1, 1));

            ////////////////////////////////////  
            lblSubtotal = new JLabel();
            jPanel1.add(lblSubtotal, gc(4, 11, 1, 1));
            lblSubtotal.setText("Subtotal:");

            txtSubtotal = new JTextField(10);
            jPanel1.add(txtSubtotal, gc(5, 11, 1, 1));

            lblTax = new JLabel();
            jPanel1.add(lblTax, gc(4, 12, 1, 1));
            lblTax.setText("Tax:");

            txtTax = new JTextField(10);
            jPanel1.add(txtTax, gc(5, 12, 1, 1));

            lblTotal = new JLabel();
            jPanel1.add(lblTotal, gc(4, 13, 1, 1));
            lblTotal.setText("Total:");

            txtTotal = new JTextField(10);
            jPanel1.add(txtTotal, gc(5, 13, 1, 1));

            ////////////////////////////////////  
            btnAdd = new JButton();
            jPanel1.add(btnAdd, gc(1, 14, 1, 1));
            btnAdd.setText("Add");
            btnAdd.addActionListener(JavaZonFrame.this);

            btnDelete = new JButton();
            jPanel1.add(btnDelete, gc(2, 14, 1, 1));
            btnDelete.setText("Delete");
            btnDelete.addActionListener(JavaZonFrame.this);

            btnFind = new JButton();
            jPanel1.add(btnFind, gc(3, 14, 1, 1));
            btnFind.setText("Find");
            btnFind.addActionListener(JavaZonFrame.this);

            btnList = new JButton();
            jPanel1.add(btnList, gc(4, 14, 1, 1));
            btnList.setText("List");
            btnList.addActionListener(JavaZonFrame.this);

            btnClear = new JButton();
            jPanel1.add(btnClear, gc(5, 14, 1, 1));
            btnClear.setText("Clear");
            btnClear.addActionListener(JavaZonFrame.this);

            btnReset = new JButton();
            jPanel1.add(btnReset, gc(6, 14, 1, 1));
            btnReset.setText("Reset");
            btnReset.addActionListener(JavaZonFrame.this);

            btnUpdate = new JButton();
            jPanel1.add(btnUpdate, gc(7, 14, 1, 1));
            btnUpdate.setText("Update");
            btnUpdate.addActionListener(JavaZonFrame.this);
            ////////////////////////////////////

            lblFileOptions = new JLabel();
            jPanel1.add(lblFileOptions, gc(3, 15, 1, 1));
            lblFileOptions.setText("File Options:");

            btnImport = new JButton();
            jPanel1.add(btnImport, gc(4, 15, 1, 1));
            btnImport.setText("Import");
            btnImport.addActionListener(JavaZonFrame.this);

            btnExport = new JButton();
            jPanel1.add(btnExport, gc(5, 15, 1, 1));
            btnExport.setText("Export");
            btnExport.addActionListener(JavaZonFrame.this);

            pack();
            JavaZonFrame.this.setSize(700, 500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GridBagConstraints gc(int x, int y, int h, int w) {

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridheight = h;
        c.gridwidth = w;

        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.insets = new Insets(5, 5, 5, 5);

        return c;
    }

    public void actionPerformed(ActionEvent e) {
        //based on the object that trigerred the event
        //call the appropriate method

        switch (e.getActionCommand()) {
            case "Add":
                addOrder();
                break;
            case "Delete":
                deleteOrder();
                break;
            case "Find":
                findOrder();
                break;
            case "List":
                printOrders();
                break;
            case "Clear":
                clearOrders();
                break;
            case "Reset":
                resetForm();
                break;
            case "Update":
                updateOrder();
                break;
            case "Import":
                importOrder();
                break;
            case "Export":
                exportOrder();
                break;
            default:
                System.out.print("Error with button selected.");
                break;
        }
    }

    public void itemStateChanged(ItemEvent e) {
        //example of method to display the price of the product based on what item was selected
        Object o = e.getSource();

        if (o == cboItem1) {
            if (cboItem1.getSelectedIndex() != -1) {
                txtPrice1.setText(menu.getPrice(cboItem1.getSelectedIndex()));
            }
        }

        //add code to display the price for the other comboboxes and textfields for the line item price
        if (o == cboItem2) {
            if (cboItem2.getSelectedIndex() != -1) {
                txtPrice2.setText(menu.getPrice(cboItem2.getSelectedIndex()));
            }
        }

        if (o == cboItem3) {
            if (cboItem3.getSelectedIndex() != -1) {
                txtPrice3.setText(menu.getPrice(cboItem3.getSelectedIndex()));
            }
        }
    }

    private void addOrder() {
        //CREATE VARIABLES TO HOLD INPUT 
        //PASS THE INPUT TO THE VALIDATOR
        //THE ONLY VALIDATION IN THIS PROJECT
        //IS THAT STRING VALUES ARE NOT BLANK
        //AND NUMERICAL VALUES ARE THE CORRECT TYPE
        //FOR EXAMPLE QUANTITY SHOULD BE INTEGER
        //PRICE SHOULD BE DOUBLE
        //EVERYTHING ELSE IS OK
        Validator.clearError(); //before we start processing we clear any errors

        String orderID = Validator.getOrderID(txtOrderID.getText());
        String firstName = Validator.getFirstName(txtFirstName.getText());

        //add the other variables to hold your values from the validator in here
        //see below what variables you will need to create a customer object and an order object
        String lastName = Validator.getLastName(txtLastName.getText());
        String street = Validator.getStreet(txtStreet.getText());
        String city = Validator.getCity(txtCity.getText());
        String zip = Validator.getZip(txtZip.getText());
        String state = Validator.getState(txtState.getText());
        String phone = Validator.getPhone(txtPhone.getText());
        String membership = Validator.getMembership(txtMembership.getText());

        //Example of how to validate the combobox from the validator
        //After you create the validation method called getQuantity in the validator
        //uncomment the Validator.getQuantity... line
        if (this.cboItem1.getSelectedIndex() != -1) {
            Validator.getQuantity(txtQty1.getText());
        }

        //do the same thing for the other 2 comboboxes
        if (this.cboItem2.getSelectedIndex() != -1) {
            Validator.getQuantity(txtQty2.getText());
        }

        if (this.cboItem3.getSelectedIndex() != -1) {
            Validator.getQuantity(txtQty3.getText());
        }

        //IF NO ITEM IS SELECTED
        if (this.cboItem1.getSelectedIndex() == -1) {
            Validator.emptyCombo();
        }

        //if there are errors then display them to the user
        //otherwise start creating the objects for the order
        if (Validator.getError().length() != 0) {
            JOptionPane.showMessageDialog(null, "An Error Occured:\n\n" + Validator.getError());

        } else {
            Customer customer = new Customer(firstName, lastName, street, city, state, zip, phone, membership);

            Order order = new Order(orderID);
            order.setOrderCustomer(customer);

            if (this.cboItem1.getSelectedIndex() != -1) {
                Product product = menu.getMenu()[this.cboItem1.getSelectedIndex()];
                order.setOrderProduct(product, Integer.parseInt(txtQty1.getText()));
                this.txtLineTotal1.setText(String.valueOf(order.getLineTotal(0)));
            }

            //do the same for the other 2 comboboxes
            if (this.cboItem2.getSelectedIndex() != -1) {
                Product product = menu.getMenu()[this.cboItem2.getSelectedIndex()];
                order.setOrderProduct(product, Integer.parseInt(txtQty2.getText()));
                this.txtLineTotal2.setText(String.valueOf(order.getLineTotal(1)));
            }

            if (this.cboItem3.getSelectedIndex() != -1) {
                Product product = menu.getMenu()[this.cboItem3.getSelectedIndex()];
                order.setOrderProduct(product, Integer.parseInt(txtQty3.getText()));
                this.txtLineTotal3.setText(String.valueOf(order.getLineTotal(2)));
            }

            jz.addOrder(order);
            jz.setClerk(orderID);
            jz.processOrder(orderID);

            //INSTEAD OF GET RECEIPT YOU NEED TO CREATE METHODS THAT WILL RETURN INDIVIDUAL VALUES FOR EACH LINE ITEM RETRIEVE THE TOTALS
            //FOR THE WHOLE ORDER RETRIEVE THE SUBTOTAL, TAX, TOTAL DISPLAY THESE RESULTS IN THE APPROPRIATE BOXES INSTEAD OF THE JOPTIONPANE BOX
//            JOptionPane.showMessageDialog(null, jz.getReceipt(orderID));
//            JOptionPane.showMessageDialog(null, "Order " + orderID + " was Saved");
            txtSubtotal.setText(order.getSubtotal());
            txtTax.setText(order.getTax());
            txtTotal.setText(order.getTotal());
        }
    }

    private void deleteOrder() {
        String orderID = JOptionPane.showInputDialog("Enter Order ID to Delete");
        String result = jz.deleteOrder(orderID);

        JOptionPane.showMessageDialog(null, result);
    }

    private void findOrder() {
        //find a particular order
        //Fill the screen with the order that was retrieved
        //All the fields should be blanked out and filled with the values from the new order
        String input = txtOrderID.getText();
        Order foundOrder = jz.findOrder(input);
        if (foundOrder != null) {

            resetForm();

            txtOrderID.setText(String.valueOf(foundOrder.getOrderID()));

            Customer foundCustomer = foundOrder.getCustomer();

            txtFirstName.setText(foundCustomer.getFirstName());
            txtLastName.setText(foundCustomer.getLastName());
            txtStreet.setText(foundCustomer.getAddress());
            txtCity.setText(foundCustomer.getCity());
            txtState.setText(foundCustomer.getState());
            txtZip.setText(foundCustomer.getZip());
            txtPhone.setText(foundCustomer.getPhone());
            txtMembership.setText(foundCustomer.getMemberShipID());

            //Example how to set the value of a combobox
            for (int i = 0; i < foundOrder.getLineItems().size(); i++) {
                if (i == 0) {
                    cboItem1.setSelectedItem(String.valueOf(foundOrder.getLineItems().get(i).getJvzProduct().getDescription()));
                    txtQty1.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzQuantity()));
                    txtPrice1.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzProduct().getPrice()));
                    txtLineTotal1.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzLineTotal()));
                } else if (i == 1) {
                    cboItem2.setSelectedItem(String.valueOf(foundOrder.getLineItems().get(i).getJvzProduct().getDescription()));
                    txtQty2.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzQuantity()));
                    txtPrice2.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzProduct().getPrice()));
                    txtLineTotal2.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzLineTotal()));
                }
                if (i == 2) {
                    cboItem3.setSelectedItem(String.valueOf(foundOrder.getLineItems().get(i).getJvzProduct().getDescription()));
                    txtQty3.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzQuantity()));
                    txtPrice3.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzProduct().getPrice()));
                    txtLineTotal3.setText(String.valueOf(foundOrder.getLineItems().get(i).getJvzLineTotal()));
                }
            }

            txtSubtotal.setText(String.valueOf(foundOrder.getSubtotal()));
            txtTax.setText(String.valueOf(foundOrder.getTax()));
            txtTotal.setText(String.valueOf(foundOrder.getTotal()));

        } else {
            JOptionPane.showMessageDialog(null, "Order Not Found");
        }
    }

    private void clearOrders() {
        //clear orders
        resetForm();
        jz.clearOrders();
        JOptionPane.showMessageDialog(null, "Orders Cleared!");
    }

    private void printOrders() {
        //print summary of orders
        String result = jz.getOrdersSummary();
        if (result.length() == 0) {
            JOptionPane.showMessageDialog(null, "No Orders Available!");
        } else {
            JOptionPane.showMessageDialog(null, jz.getOrdersSummary());
        }
    }

    public void resetForm() {
        //ADD code here to reset the form to a blank state
        txtOrderID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtStreet.setText("");
        txtCity.setText("");
        txtState.setText("");
        txtZip.setText("");
        txtPhone.setText("");
        txtMembership.setText("");

        try {
            this.cboItem1.setSelectedIndex(-1);
            this.cboItem2.setSelectedIndex(-1);
            this.cboItem3.setSelectedIndex(-1);
        } catch (Exception ex) {
            //ignore error
        }
        txtQty1.setText("");
        txtQty2.setText("");
        txtQty3.setText("");

        txtPrice1.setText("");
        txtPrice2.setText("");
        txtPrice3.setText("");

        txtLineTotal1.setText("");
        txtLineTotal2.setText("");
        txtLineTotal3.setText("");

        txtTax.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
    }

    private void importOrder() {
        String result = jz.importOrder();

        JOptionPane.showMessageDialog(null, result);
    }

    private void exportOrder() {
        String result = jz.exportOrder();

        JOptionPane.showMessageDialog(null, result);
    }

    private void updateOrder() {
        int found = 0;

        Validator.clearError(); //before we start processing we clear any errors
        Validator.getOrderID(txtOrderID.getText());
        Validator.getFirstName(txtFirstName.getText());
        Validator.getLastName(txtLastName.getText());
        Validator.getStreet(txtStreet.getText());
        Validator.getCity(txtCity.getText());
        Validator.getZip(txtZip.getText());
        Validator.getState(txtState.getText());
        Validator.getPhone(txtPhone.getText());
        Validator.getMembership(txtMembership.getText());

        if (this.cboItem1.getSelectedIndex() != -1) {
            Validator.getQuantity(txtQty1.getText());
        }

        if (this.cboItem2.getSelectedIndex() != -1) {
            Validator.getQuantity(txtQty2.getText());
        }

        if (this.cboItem3.getSelectedIndex() != -1) {
            Validator.getQuantity(txtQty3.getText());
        }

        if (this.cboItem1.getSelectedIndex() == -1) {
            Validator.emptyCombo();
        }

        if (Validator.getError().length() != 0) {
            JOptionPane.showMessageDialog(null, "An Error Occured:\n\n" + Validator.getError());

        } else {
            found = jz.updateOrder(String.valueOf(txtOrderID.getText()));
            if (found == 1) {
                addOrder();
            }
        }
    }
}
