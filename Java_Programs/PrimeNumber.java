import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        int n, i;
        boolean isPrime = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        for(i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime && n > 1)
            System.out.println("Prime Number");
        else
            System.out.println("Not a Prime Number");
    }
}
