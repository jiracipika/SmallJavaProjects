import java.util.Scanner;

public class SequenceN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a positive number: ");
        int N = scanner.nextInt();
        
        while(N <= 0) {
            System.out.println("Error! Please enter a positive number: ");
            N = scanner.nextInt();
        }
        
        int counter = 0;
        System.out.print(N + ", "); 
        
        while(N != 1) {
            if(N % 2 == 0) {
                N /= 2;
            } else {
                N = 3 * N + 1;
            }
            System.out.print(N);
            
            if(N != 1) {  
                System.out.print(", ");
            }
            
            counter++;
        }
        System.out.println();  
        System.out.println("Total numbers in sequence: " + counter);
        
        scanner.close();
    }
}
