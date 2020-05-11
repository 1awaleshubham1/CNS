import java.util.*;
class MultiPlicativeInverse {
    static int Inverse(int m, int n) 
    { 
        m = m % n; 
        for (int x = 1; x < n; x++) 
           if ((m * x) % n == 1) 
              return x; 
        return 1; 
    } 
       
    // Driver Program 
    public static void main(String args[]) 
    { 
        int m;
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nThis Program Calculates Multiplicative Inverse of M % N\n");
        
        System.out.println("Enter the Value of M");
        m = sc.nextInt();
        
        System.out.println("\nEnter the Value of M");
        n = sc.nextInt();

        System.out.println("Multiplicative Inverse of " +m +" % " +n + " is " +Inverse(m, n)); 
    } 
}