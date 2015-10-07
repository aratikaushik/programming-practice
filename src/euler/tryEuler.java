package euler;
import java.util.HashSet;
import java.util.ArrayList;
import java.math.BigInteger;

public class tryEuler{
	
	public static ArrayList<Integer> Primes = new ArrayList<Integer>();
	
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
		
		if(pos < Primes.size())
			return Primes.get(pos);
		
		int i = Primes.get(Primes.size() - 1) + 1;
		int num = Primes.size() - 1;
		for(;;i++){
			if(isPrime(i)){
				num++;
				Primes.add(i);
				if(num == pos)
					break;
			}
		}
		return i;
	}
	
	public static BigInteger greatestProduct(BigInteger num){
		BigInteger thirteenDigits[] = new BigInteger[13];
		BigInteger product = BigInteger.ONE;
		int i=0;
		for(i=0;i<13;i++){
			BigInteger divAndRem[] = num.divideAndRemainder(BigInteger.TEN);
			thirteenDigits[i] = divAndRem[1];
			product = product.multiply(thirteenDigits[i]);
			num = divAndRem[0];
		}
		BigInteger newProduct = product;
		for(i=0; num.compareTo(BigInteger.ZERO) != 0; i=(i+1)%13){
			BigInteger divAndRem[] = num.divideAndRemainder(BigInteger.TEN);
			if(thirteenDigits[i].compareTo(BigInteger.ZERO) != 0){
				newProduct = newProduct.divide(thirteenDigits[i]);
			}
			else {
				newProduct = BigInteger.ONE;
				for(int j=0;j<13;j++){
					if(j!=i)
						newProduct = newProduct.multiply(thirteenDigits[j]);
				}
			}
			thirteenDigits[i] = divAndRem[1];
			newProduct = newProduct.multiply(divAndRem[1]);
			num = divAndRem[0];
			if(newProduct.compareTo(product) > 0)
				product = newProduct;
		}
		return product;
	}
	
	public static int findProduct(){
		int product = 1;
		boolean stopSearch = false;
		for(int a = 1;!stopSearch; a++){
			for(int b = a+1; (1000 - (a+b)) > a && (1000 - (a+b)) > b; b++){
				int c = 1000 - (a+b);
				if((a*a) + (b*b) == (c*c)){
					product = a*b*c;
					stopSearch = true;
					break;
				}
			}
		}
		return product;
	}
	
	public static String sumOfPrimes(int limit){
		boolean limitExceeded = false;
		BigInteger sum = BigInteger.ZERO;
		for(int i=1; i<limit && !limitExceeded; i++){
			int ithPrime = primeNumberAt(i);
			if(ithPrime < limit){
				BigInteger thisNum = new BigInteger(String.valueOf(ithPrime));
				sum = sum.add(thisNum);
			}
			else
				limitExceeded = true;
		}
		return sum.toString();
	}
	
	public static void main(String[] args){
		
		System.out.println("Required sum = " + sumAllMultiples(1000));
		
		System.out.println("Sum of Fibonacci terms is " + fibonacci());
		
		long num = 600851475143L;
		
		System.out.println("Largest factor of " + num + " is "+ largestPrimeFactor(num));
		
		System.out.println("is 10201 a palindrome? " + isPalindrome(10201));
		
		System.out.println("Largest palindrome number that is the multiple of two 3-digit numbers is: "+longestPalindrome());
		
		System.out.println("smallest LCM of all numbers till 20 is " + smallestLCM(20));
		
		System.out.println("Sum Square difference for first 100 natural numbers is: " + Math.abs(sumSquareDifference(100)));
		
		Primes.add(1);
		Primes.add(2);
		
		System.out.println("10001st prime number is " + primeNumberAt(10001));
		
		System.out.println("5th prime number is " + primeNumberAt(5));
		
		String MyNum = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		
		String[] parts = MyNum.split("0");
		
		BigInteger myProduct = BigInteger.ZERO;
		for(int i=0; i<parts.length; i++){
			
			if(parts[i].length()>=13){
				
				BigInteger myBigInteger = new BigInteger(parts[i]);
			
				BigInteger newProduct = greatestProduct(myBigInteger);
				
				if(newProduct.compareTo(myProduct) > 0){
					myProduct = newProduct;
				}
			}	
		}
		System.out.println("greatest product of 13 numbers is " + myProduct.toString());
		
		System.out.println("required product of pythagorean triplet of sum 1000 = "+findProduct());
		
		System.out.println("Sum of primes below 2000000 is " + sumOfPrimes(2000000));
		
	}
}
