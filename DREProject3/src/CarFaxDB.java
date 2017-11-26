
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CarFaxDB {

    private static final String URL = "jdbc:derby://localhost:1527/CarFaxDB";
    private static final String USER = "CarFaxDB";
    private static final String PW = "CarFaxDB";
    public static String errors = "";    
   
    public static ArrayList<Car> loadCars() {
        //Loads records from database into ArrayList for HashMap
        ArrayList<Car> Cars = new ArrayList<>();

        try {
            Connection cn = DriverManager.getConnection(URL, USER, PW);
            ResultSet rs = cn.createStatement().executeQuery("SELECT CarVin, CarMake, CarModel, CarYear FROM CarFaxDB.Cars");

            while (rs.next()) {
                Car aCar = new Car(rs.getString("CarVin"), rs.getString("CarMake"), rs.getString("CarModel"), rs.getInt("CarYear"));
                Cars.add(aCar);
            }
            cn.close();
        } catch (SQLException e) {
            errors += e + "\n";
            JOptionPane.showMessageDialog(null, e);
        }
        return Cars;
    }

    public static void deleteAllCars() {
        //Deletes all records from database to avoid duplicates
        try {
            Connection cn = DriverManager.getConnection(URL, USER, PW);
            cn.createStatement().executeUpdate("DELETE FROM CarFaxDB.Cars");
            cn.close();
        } catch (SQLException e) {
            errors += e + "\n";
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void insertCars(String aVIN, String aMake, String aModel, int aYear) {
        //Insert each Car into database
        try {
            Connection cn = DriverManager.getConnection(URL, USER, PW);
            cn.createStatement().executeUpdate("INSERT INTO CarFaxDB.Cars (CarVin, CarMake, CarModel, CarYear) VALUES ('" + aVIN + "', '" + aMake + "', '" + aModel + "', " + aYear + ")");
            cn.close();
        } catch (SQLException e) {
            errors += e + "\n";
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
