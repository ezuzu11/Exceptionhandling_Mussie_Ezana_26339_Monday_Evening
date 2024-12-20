import java.io.*;
import java.sql.*;
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        // Checked Exceptions
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();

        // Unchecked Exceptions
        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();
    }

    // Checked Exception 1: IOException
    private static void handleIOException() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent_file.txt"));
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // Checked Exception 2: FileNotFoundException
    private static void handleFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("missing_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // Checked Exception 3: EOFException
    private static void handleEOFException() {
        try (DataInputStream input = new DataInputStream(new FileInputStream("test.dat"))) {
            while (true) {
                input.readInt();
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: Reached end of file.");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // Checked Exception 4: SQLException
    private static void handleSQLException() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:invalid:url", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // Checked Exception 5: ClassNotFoundException
    private static void handleClassNotFoundException() {
        try {
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // Unchecked Exception 6: ArithmeticException
    private static void handleArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    // Unchecked Exception 7: NullPointerException
    private static void handleNullPointerException() {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    // Unchecked Exception 8: ArrayIndexOutOfBoundsException
    private static void handleArrayIndexOutOfBoundsException() {
        try {
            int[] numbers = {1, 2, 3};
            int invalid = numbers[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    // Unchecked Exception 9: ClassCastException
    private static void handleClassCastException() {
        try {
            Object obj = Integer.valueOf(42);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

    // Unchecked Exception 10: IllegalArgumentException
    private static void handleIllegalArgumentException() {
        try {
            Thread thread = new Thread();
            thread.setPriority(11); // Invalid priority (must be 1-10)
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    // Unchecked Exception 11: NumberFormatException
    private static void handleNumberFormatException() {
        try {
            int number = Integer.parseInt("InvalidNumber");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
