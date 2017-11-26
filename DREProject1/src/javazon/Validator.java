package javazon;

import javax.swing.JOptionPane;

public class Validator {

    //TODO - CODE THE VALIDATOR
    public static String getValidFirstName(String anInput) {
        //TODO add your code here
        //IF INFORMATION IS NOT VALID, REPEAT QUESTION
        while (isValidFirstName(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a valid First Name");
        }
        return anInput;
    }

    private static boolean isValidFirstName(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() > 0 && anInput.matches("[A-Za-z]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidLastName(String anInput) {
        //TODO add your code here	
        while (isValidLastName(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a Valid Last Name");
        }
        return anInput;
    }

    private static boolean isValidLastName(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() > 0 && anInput.matches("[A-Za-z]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidStreet(String anInput) {
        //TODO add your code here	
        while (isValidStreet(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a Valid Street Name");
        }
        return anInput;
    }

    private static boolean isValidStreet(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() > 0 && anInput.matches("[0-9 A-Za-z]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidCity(String anInput) {
        //TODO add your code here	
        while (isValidCity(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a Valid City Name");
        }
        return anInput;
    }

    private static boolean isValidCity(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() > 0 && anInput.matches("[A-Za-z]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidState(String anInput) {
        //TODO add your code here	
        while (isValidState(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a Valid State Name");
        }
        return anInput;
    }

    private static boolean isValidState(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() == 2 && anInput.matches("[A-Za-z]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidZip(String anInput) {
        //TODO add your code here	
        while (isValidZip(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a 5 Digit Zip");
        }
        return anInput;
    }

    private static boolean isValidZip(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() == 5 && anInput.matches("[0-9]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidPhone(String anInput) {
        //TODO add your code here	
        while (isValidPhone(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a 10 Digit Phone Without Format");
        }
        return anInput;
    }

    private static boolean isValidPhone(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() == 10 && anInput.matches("[0-9]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidMembership(String anInput) {
        //TODO add your code here	
        while (isValidMembership(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a Valid Membership Number");
        }
        return anInput;
    }

    private static boolean isValidMembership(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() == 6 && anInput.substring(0, 1).matches("[A-Za-z]+") && anInput.substring(2, 6).matches("[0-9]+")) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    public static String getValidProductQuantity(String anInput) {
        //TODO add your code here	
        while (isValidProductQuantity(anInput) == false) {
            anInput = JOptionPane.showInputDialog("Enter a Valid Product Quantity");
        }
        return anInput;
    }

    private static boolean isValidProductQuantity(String anInput) {
        boolean result = false;
        //TODO add your code here
        try {
            if (anInput.length() > 0 && anInput.matches("[0-9]+") && Integer.parseInt(anInput) >= 1 && Integer.parseInt(anInput) <= 10) {
                result = true;
            }
        } catch (NullPointerException n) {
            exitProgram();
        }
        return result;
    }

    private static void exitProgram() {
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Program", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (i == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "This order has been canceled");
            System.exit(0);
        }
    }
}
