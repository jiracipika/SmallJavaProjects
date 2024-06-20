/**
 * A Java application to show the usage of local variables
 * of Strings and primitive data types.
 *
 * @author Rajin Gajadhar
 * @version 1.0
 */
class VariableExample {

    /**
     * The entry point of the Java application.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        displayVariableValues();
    }

    /**
     * A method to declare, initialize, and display local variables
     * of String and each of the primitive data types.
     *
     * @return Nothing.
     */
    public static void displayVariableValues() {
        // Single-line comment: Declare and initialize a String variable
        String myString = "Hello, world!";

        /* 
         * Multi-line comment:
         * Declare and initialize variables of primitive data types 
         */
        byte myByte = 123;
        short myShort = 12345;
        int myInt = 1234567899;
        long myLong = 1234567891234567897L;
        float myFloat = 3.14F;
        double myDouble = 3.141592653589793;
        char myChar = 'A';
        boolean myBoolean = true;

        // Display the values of each variable
        System.out.println("String: " + myString);
        System.out.println("Byte: " + myByte);
        System.out.println("Short: " + myShort);
        System.out.println("Int: " + myInt);
        System.out.println("Long: " + myLong);
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        System.out.println("Char: " + myChar);
        System.out.println("Boolean: " + myBoolean);
    }
}
