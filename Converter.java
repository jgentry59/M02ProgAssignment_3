import java.util.Scanner;
public class Converter {
    public static int bin2Dec(String binaryString) throws NumberFormatException {

        for (int i = 0; i < binaryString.length(); i++) {  //Check for valid binary string
            char ch = binaryString.charAt(i);
            if (ch != '0' && ch != '1') { //throws exception if non-binary digit is found
                throw new NumberFormatException("Not a binary number");
            }
        }
        int decimal = 0;
        int binaryLength = binaryString.length();  //Converts binary string to a decimal number
        for (int i = 0; i < binaryLength; i++) {
            char ch = binaryString.charAt(i);
            int digit = ch - '0';                  //Converts char '0' or '1' to int 0 or 1
            decimal += digit * Math.pow(2, binaryLength - 1 - i);
        }
        return decimal;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();

        try {
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal equivalent: " + decimalValue);
        } catch (NumberFormatException e) {
            System.out.println("Not a binary number"); //outputs error message if exception is thrown
        } finally {
            scanner.close();
        }
    }
}
