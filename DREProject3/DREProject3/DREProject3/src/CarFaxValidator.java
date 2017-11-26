
public class CarFaxValidator {

    //static variable to hold any error that occurs
    private static String errorMessage = "";

    public static String getVIN(String aVIN) {
        //verify length == 5, alphanumberic
        if (aVIN.length() == 0) {
            errorMessage += "VIN Number cannot be blank\n";
        } else {
            if (!aVIN.matches("[0-9A-Za-z]+") || aVIN.length() != 5) {
                errorMessage += "VIN Number should be 5 alphanumberic characters\n";
            }
        }
        return aVIN;
    }

    public static String getMake(String aMake) {
        //can not be blank
        if (aMake.length() == 0) {
            errorMessage += "Car Make cannot be blank\n";
        }
        return aMake;
    }

    public static String getModel(String aModel) {
        //can not be blank
        if (aModel.length() == 0) {
            errorMessage += "Car Model cannot be blank\n";
        }
        return aModel;
    }

    public static String getYear(String aYear) {
        //greater than 0
        if (aYear.length() == 0) {
            errorMessage += "Year cannot be blank\n";
        } else {
            if (!aYear.matches("[0-9]+") || aYear.length() != 4) {
                errorMessage += "Year is invalid\n";
            }
        }
        return aYear;
    }

    //method to return the error message	
    public static String getError() {
        return errorMessage;
    }

    //method to clear the error message
    public static void clearError() {
        errorMessage = "";
    }
}
