package MainPackage;

public class Utility { //Clasa utilitara ce este folosita pentru a determina daca o valoare este numar
    public static boolean isNumeric(String string) {
        int intValue;
            
        
            
        if(string == null || string.equals("")) {
            
            return false;
        }
        
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            
        }
        return false;
    }
}
