
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.WindowConstants;

public class CarFaxFrame extends javax.swing.JFrame implements ActionListener {

    private JPanel jPanel1;
    private JLabel lblTitle, lblVIN, lblMake, lblModel, lblYear;
    private JTextField txtVIN, txtMake, txtModel, txtYear, txtFind;
    private JButton btnAdd, btnUpdate, btnDelete, btnClear, btnFind;

    public HashMap<String, Car> carInfo;
    public int carCount;

    public CarFaxFrame() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            GridLayout thisLayout = new GridLayout();

            carInfo = new HashMap<>();

            // read the records from the database and load them into the HashMap of the program
            loadCars();
            carCount = carInfo.size();
            
            //Display a welcome message
            JOptionPane.showMessageDialog(null, "Welcome to Carfax App. " + carCount + " cars have been loaded from the database");

            // save the data that the user has entered in the form from the HashMap car objects to the database
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    deleteCars();
                    insertCars();

                    //Display a closing message
                    JOptionPane.showMessageDialog(null, "Thank you for using CarFax App. " + (carInfo.size() - carCount) + " new cars have been saved to the database");
                }
            });

            getContentPane().setLayout(thisLayout);

            jPanel1 = new JPanel();
            getContentPane().add(jPanel1);
            GridBagLayout jPanel1Layout = new GridBagLayout();

            jPanel1.setLayout(jPanel1Layout);
            jPanel1.setPreferredSize(new java.awt.Dimension(500, 425));

            lblTitle = new JLabel();
            jPanel1.add(lblTitle, gc(3, 0, 2, 5));
            lblTitle.setText("Welcome to Java DB CarFax");

            lblVIN = new JLabel("VIN:");
            jPanel1.add(lblVIN, gc(1, 2, 1, 1));

            txtVIN = new JTextField(10);
            jPanel1.add(txtVIN, gc(2, 2, 1, 4));

            lblMake = new JLabel("Car Make:");
            jPanel1.add(lblMake, gc(1, 4, 1, 1));

            txtMake = new JTextField(10);
            jPanel1.add(txtMake, gc(2, 4, 1, 4));

            lblModel = new JLabel("Car Model:");
            jPanel1.add(lblModel, gc(1, 6, 1, 1));

            txtModel = new JTextField(10);
            jPanel1.add(txtModel, gc(2, 6, 1, 4));

            lblYear = new JLabel("Car Year:");
            jPanel1.add(lblYear, gc(1, 8, 1, 1));

            txtYear = new JTextField(10);
            jPanel1.add(txtYear, gc(2, 8, 1, 4));

            btnAdd = new JButton("Add");
            jPanel1.add(btnAdd, gc(2, 10, 1, 1));
            btnAdd.addActionListener(this);

            btnUpdate = new JButton("Update");
            jPanel1.add(btnUpdate, gc(3, 10, 1, 1));

            btnUpdate.addActionListener(this);

            btnDelete = new JButton("Delete");
            jPanel1.add(btnDelete, gc(4, 10, 1, 1));

            btnDelete.addActionListener(this);

            btnClear = new JButton("Clear");
            jPanel1.add(btnClear, gc(5, 10, 1, 1));

            btnClear.addActionListener(this);

            btnFind = new JButton("Find");
            jPanel1.add(btnFind, gc(2, 12, 1, 1));

            btnFind.addActionListener(this);

            txtFind = new JTextField(10);
            jPanel1.add(txtFind, gc(3, 12, 1, 3));

            pack();
            CarFaxFrame.this.setSize(500, 400);
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
        c.insets = new Insets(12, 12, 12, 12);

        return c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //based on the object that trigerred the event call the appropriate method
        switch (e.getActionCommand()) {
            case "Add":
                addCar();
                break;
            case "Update":
                updateCar();
                break;
            case "Delete":
                deleteCar();
                break;
            case "Clear":
                clearCar();
                break;
            case "Find":
                findCar();
                break;
            default:
                System.out.print("Error with button selected.");
                break;
        }
    }

    private void addCar() {
        //ADD BUTTON: Adds the car object to the HashMap 
        //(DISPLAY SUCCESS OR FAILURE MESSAGE)
        CarFaxValidator.clearError();

        String vin = CarFaxValidator.getVIN(txtVIN.getText());
        String make = CarFaxValidator.getMake(txtMake.getText());
        String model = CarFaxValidator.getModel(txtModel.getText());
        String year = CarFaxValidator.getYear(txtYear.getText());

        if (CarFaxValidator.getError().length() != 0) {
            JOptionPane.showMessageDialog(null, "An Error Occured:\n\n" + CarFaxValidator.getError());

        } else {
            Car foundCar = checkCar(txtVIN.getText());

            if (foundCar != null) {
                JOptionPane.showMessageDialog(null, "Car with VIN " + txtVIN.getText() + " already exisits.\n");
            } else {
                Car car = new Car(vin, make, model, Integer.parseInt(year));
                carInfo.put(car.getVIN(), car);
                JOptionPane.showMessageDialog(null, "Car was added to CarFax Database\n\n" + car.toString());
                clearCar();
            }
        }
    }

    private void updateCar() {
        //UPDATE BUTTON: Update the car object in the HashMap 
        //(DISPLAY SUCCESS OR FAILURE MESSAGE)
        String result = "Car with VIN " + txtVIN.getText() + " has not been updated.";
        CarFaxValidator.clearError();
        CarFaxValidator.getVIN(txtVIN.getText());
        CarFaxValidator.getMake(txtMake.getText());
        CarFaxValidator.getModel(txtModel.getText());
        CarFaxValidator.getYear(txtYear.getText());

        if (CarFaxValidator.getError().length() != 0) {
            JOptionPane.showMessageDialog(null, "An Error Occured:\n\n" + CarFaxValidator.getError());
        } else {
            Car foundCar = checkCar(txtVIN.getText());

            if (foundCar != null) {
                Car car = new Car(txtVIN.getText(), txtMake.getText(), txtModel.getText(), Integer.parseInt(txtYear.getText()));
                carInfo.remove(foundCar.getVIN());
                carInfo.put(car.getVIN(), car);
                result = "Car with VIN " + foundCar.getVIN() + " has been updated.";
            } 
        }
        JOptionPane.showMessageDialog(null, result);
    }

    private void deleteCar() {
        //DELETE BUTTON: Delete the car object that the user selected from the HashMap 
        //(DISPLAY SUCCESS OR FAILURE MESSAGE)
        clearCar();
        String aVIN = JOptionPane.showInputDialog("Enter VIN Number to Delete");
        String result = "Car with VIN " + aVIN + " was not found.\n";
        Car foundCar = checkCar(aVIN);

        if (foundCar != null) {
            carInfo.remove(foundCar.getVIN());
            result = "Car with VIN " + aVIN + " was deleted";
        }
        JOptionPane.showMessageDialog(null, result);
    }

    public void clearCar() {
        // clear the fields on the GUI but not from the database
        txtVIN.setText("");
        txtMake.setText("");
        txtModel.setText("");
        txtYear.setText("");
        txtFind.setText("");
    }

    private void findCar() {
        //The user enters the VIN number of the car to find. The program retrieve the car object matching the VIN number from the HashMap and displays it on the screen 
        //(DISPLAY SUCCESS OR FAILURE MESSAGE)
        Car foundCar = checkCar(txtFind.getText());

        if (foundCar != null) {
            clearCar();

            txtVIN.setText(foundCar.getVIN());
            txtMake.setText(foundCar.getMake());
            txtModel.setText(foundCar.getModel());
            txtYear.setText(String.valueOf(foundCar.getYear()));
        } else {
            JOptionPane.showMessageDialog(null, "Car Not Found");
            clearCar();
        }
    }

    private Car checkCar(String aVIN) {
        Car foundCar = null;

        for (Map.Entry<String, Car> o : carInfo.entrySet()) {
            if (o.getValue().getVIN().equals(aVIN)) {
                foundCar = o.getValue();
                break;
            }
        }
        return foundCar;
    }

    public void loadCars() {
        ArrayList<Car> Cars = CarFaxDB.loadCars();

        for (int i = 0; i < Cars.size(); i++) {
            Car aCar = new Car(Cars.get(i).getVIN(), Cars.get(i).getMake(), Cars.get(i).getModel(), Cars.get(i).getYear());
            carInfo.put(aCar.getVIN(), aCar);
        }
    }

    public void deleteCars() {
        CarFaxDB.deleteAllCars();
    }

    public void insertCars() {
        Car aCar;

        for (Map.Entry<String, Car> o : carInfo.entrySet()) {
            aCar = o.getValue();
            CarFaxDB.insertCars(aCar.getVIN(), aCar.getMake(), aCar.getModel(), aCar.getYear());
        }
    }
}
