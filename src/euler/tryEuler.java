package euler;
import java.util.HashSet;

public class tryEuler{
	
	public static int sumAllMultiples(int n){
		int sum = 0;
		for(int i=1; i < n; i++)
			if(i%3 == 0 || i%5 == 0) 
				sum += i;
		return sum;
	}
	
	public static long fibonacci(){
		long sum = 2;
		int num1 = 1;
		int num2 = 2;
		int this_num = 0;
		int bitMask = 0x0001;
		while(true){
			this_num = num1 + num2;
			if(this_num > 4000000)
				break;
			int LastBit = this_num & bitMask;
			if(LastBit == 0){
				System.out.printf("%d ",this_num);
				sum += this_num;
			}
				
			num1 = num2;
			num2 = this_num;
		}
		return sum;
	}
	
	public static long largestPrimeFactor(long num){
		long i = 2;
		for(i = 2; i <= num; i++){
			while(num%i == 0){
				num /= i;
			}
		}
		return --i;
	}
	
	public static boolean isPalindrome(int num){
		int numcopy = num;
		int num2 = 0;
		while(num > 0){
			num2 = (num2 * 10) + (num % 10);
			num /= 10;
		}
		//System.out.println("number in opposite direction is " + num2);
		if(numcopy == num2)
			return true;
		else
			return false;
	}
	
	public static int longestPalindrome(){
		int num = 10201;
		boolean found = false;
		for(int i = 999; i>=100 && !found; i--){
			int num2 = i*i;
			while(num2/i >= 100 && !found && num2 > num){
				if(isPalindrome(num2)){
					/*System.out.println("Largest palindrome number that is the multiple of two 3-digit numbers is: "
					 + num2 + ", the multiple of " + i + " and " + num2/i);
					num = num2;
					found = true;*/
					num = num2;
				}
				num2 -= i;
			}
		}
		
		return num;
	}
	
	public static int smallestLCM(int n){
		int res = 0;
		int start = n*(n-1);
		for(int i=3;;i++){
			int j = 0;
			for(j=n-2; j>2; j--){
				if((start*i)%j != 0)
					break;
			}
			if(j==2){
				res = start*i;
				break;
			}
		}
		return res;
	}
	
	public static int sumSquareDifference(int n){
		int sumSquares = (n*(n + 1)*(2*n + 1))/6;
		int sum = (n*(n+1))/2;
		return sumSquares - (sum*sum);
	}
	
	public static boolean isPrime(int n){
		for(int i = 2; i<=n/i; i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
	
	public static int primeNumberAt(int pos){
		int i = 2;
		int num = 0;
		for(;;i++){
			if(isPrime(i)){
				num++;
				if(num == pos)
					break;
			}
		}
		return i;
	}
	
	public static void main(String[] args){
		//System.out.println("Required sum = " + sumAllMultiples(1000));
		
		//System.out.println("Sum of Fibonacci terms is " + fibonacci());
		
		/*long num = 600851475143L;
		
		System.out.println("Largest factor of " + num + " is "+ largestPrimeFactor(num));*/
		
		/*System.out.println("is 10201 a palindrome? " + isPalindrome(10201));
		
		System.out.println("Largest palindrome number that is the multiple of two 3-digit numbers is: "+longestPalindrome());*/
		
		//System.out.println("smallest LCM of all numbers till 20 is " + smallestLCM(20));
		
		//System.out.println("Sum Square difference for first 100 natural numbers is: " + Math.abs(sumSquareDifference(100)));
		
		System.out.println("10001st prime number is " + primeNumberAt(10001));
	}
}
