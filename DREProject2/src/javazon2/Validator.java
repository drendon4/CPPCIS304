package javazon2;

public class Validator {
    //add the method that will validate all the input collected from the form

    //static variable to hold any error that occurs
    private static String errorMessage = "";

    public static String getOrderID(String anID) {
        //run the validation
        //add any errors to the error message
        if (anID.length() == 0) {
            errorMessage += "Order ID cannot be blank\n";
        }
        return anID;
    }

    public static String getFirstName(String aFirstName) {
        if (aFirstName.length() == 0) {
            errorMessage += "First Name cannot be blank\n";
        }
        return aFirstName;
    }

    public static String getLastName(String aLastName) {
        if (aLastName.length() == 0) {
            errorMessage += "Last Name cannot be blank\n";
        }
        return aLastName;
    }

    public static String getPhone(String aPhone) {
        if (aPhone.length() != 10) {
            errorMessage += "Phone format is not valid\n";
        } else {
            if (aPhone.matches("[0-9]+")) {
            } else {
                errorMessage += "Phone must be a number\n";
            }
        }

        return aPhone;
    }

    public static String getMembership(String aMembership) {
        if (aMembership.length() == 0) {
            errorMessage += "Membership cannot be blank\n";
        } else {
            if (aMembership.length() == 6 && aMembership.substring(0, 1).matches("[A-Za-z]+") && aMembership.substring(2, 6).matches("[0-9]+")) {

            } else {
                errorMessage += "Membership format is not valid\n";
            }
        }
        return aMembership;
    }

    public static String getStreet(String aStreet) {
        if (aStreet.length() == 0) {
            errorMessage += "Street cannot be blank\n";
        }
        return aStreet;
    }

    public static String getCity(String aCity) {
        if (aCity.length() == 0) {
            errorMessage += "City cannot be blank\n";
        }
        return aCity;
    }

    public static String getState(String aState) {
        if (aState.length() == 0) {
            errorMessage += "State cannot be blank\n";
        } else {
            if (aState.length() != 2) {
                errorMessage += "State format is not valid\n";
            }
        }
        return aState;
    }

    public static String getZip(String aZip) {
        if (aZip.length() == 0) {
            errorMessage += "Zip cannot be blank\n";
        } else {
            if (aZip.length() != 5) {
                errorMessage += "Zip format is not valid\n";
            } else {
                try {
                    if (Integer.parseInt(aZip) == 1) {
                    }
                } catch (NumberFormatException e) {
                    errorMessage += "Zip must be a number\n";
                }
            }
        }
        return aZip;
    }

    public static String getQuantity(String aQuantity) {
        if (aQuantity.length() != 0) {
            try {
                if (Integer.parseInt(aQuantity) == 1) {
                }
            } catch (NumberFormatException e) {
                errorMessage += "Quantity must be a number\n";
            }
        } else {
            errorMessage += "Quantity cannot be blank\n";
        }
        return aQuantity;
    }

    public static void emptyCombo() {
        errorMessage += "One product must be selected\n";
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
