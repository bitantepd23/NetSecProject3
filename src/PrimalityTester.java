import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class PrimalityTester {
	
	long testNumber;
	int iterator;
	boolean primeCheck;
	
	public PrimalityTester() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter a number");
		this.testNumber = userInput.nextLong();
		
		System.out.println("Enter the number of iterations you would like performed");
		this.iterator = userInput.nextInt();
		
		while (this.iterator < 10) {
			System.out.println("Please enter a value of at least 10 iterations");
			this.iterator = userInput.nextInt();
		}
		userInput.close();
		primeCheck = this.checkPrimality(this.testNumber, this.iterator);
		this.returnAnswer(testNumber, primeCheck);
	}
	
	public PrimalityTester(BigInteger testNumber, int iterator) {
		Scanner userInput = new Scanner(System.in);
		
		long longTest = testNumber.longValue();
		
		if (iterator < 10) {
			System.out.println("Please enter a value of at least 10 iterations");
			iterator = userInput.nextInt();
		}
		userInput.close();
		primeCheck = checkPrimality(longTest, iterator);
		returnAnswer(longTest, primeCheck);
	}
	
	public void testBigInt(BigInteger p, BigInteger q, int iterations) {
		
		System.out.println("Test Number = "+testNumber+"\n\tIterations: "+iterations);
		
		// tests for user input of 0 or 1
		if (testNumber == 0 || testNumber == 1) {
			return false;
		}
		
		// tests for 2, which is prime
		if (testNumber == 2) {
			return true;
		}
		
		// tests for any other even numbers
		if (testNumber % 2 == 0) {
			return false;
		}
		
		long testMinusOne = testNumber -1;
		
		// converts testMinusOne to smallest long
		System.out.println("\nConverting "+testMinusOne+" to smallest long");
		while (testMinusOne % 2 == 0) {
			testMinusOne /= 2;
		}
		
		System.out.println("\tConverted value = "+testMinusOne);
		
		Random randGenerator = new Random();
		System.out.println("\nBeginning loop process\n");
			long randLong = Math.abs(randGenerator.nextLong());
			long a = randLong % (testNumber-1) +1; 
			long temp = testMinusOne;
			long aPowbModc = aPowbModc(a, temp, testNumber);
			while (temp != testMinusOne && aPowbModc != 1 && aPowbModc != testMinusOne) {

				aPowbModc = aMulbModc(aPowbModc, aPowbModc, testNumber);
				temp *= 2;
			if (aPowbModc != testMinusOne && temp % 2 == 0) {
				return false;
			}
		}
		
		return true;
		
		
	}
	
	// (a^b) % c
	public long aPowbModc(long a, long b, long c) {
//		System.out.println("b="+b);									// debugging
		long temp = 1;
		
		for (int i=0; i<b; i++) {
//			System.out.println("**Loop "+i+"\tTemp = "+temp);		// debugging 

			temp *= a;	// (a * ai-1)
			temp %= c;	// (a * ai-1) % c
		}
		return temp;
	}
	
	// returns the BigInteger value of (a*b) % c
	public long aMulbModc(long a, long b, long mod) {
		return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue(); 
	}
	
	private boolean checkPrimality(long testNumber, int iter) {
		
		System.out.println("Test Number = "+testNumber+"\n\tIterations: "+iter);
		
		// tests for user input of 0 or 1
		if (testNumber == 0 || testNumber == 1) {
			return false;
		}
		
		// tests for 2, which is prime
		if (testNumber == 2) {
			return true;
		}
		
		// tests for any other even numbers
		if (testNumber % 2 == 0) {
			return false;
		}
		
		long testMinusOne = testNumber -1;
		
		// converts testMinusOne to smallest long
		System.out.println("\nConverting "+testMinusOne+" to smallest long");
		while (testMinusOne % 2 == 0) {
			testMinusOne /= 2;
		}
		
		System.out.println("\tConverted value = "+testMinusOne);
		
		Random randGenerator = new Random();
		System.out.println("\nBeginning loop process\n");
			long randLong = Math.abs(randGenerator.nextLong());
			long a = randLong % (testNumber-1) +1; 
			long temp = testMinusOne;
			long aPowbModc = aPowbModc(a, temp, testNumber);
			while (temp != testMinusOne && aPowbModc != 1 && aPowbModc != testMinusOne) {

				aPowbModc = aMulbModc(aPowbModc, aPowbModc, testNumber);
				temp *= 2;
			if (aPowbModc != testMinusOne && temp % 2 == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private void returnAnswer(long testNumber, boolean primeCheck) {
		if (primeCheck == true) {
			System.out.println(testNumber+" is a prime number.");
		}
		else {
			System.out.println(testNumber+" is a compostite number.");
		}
	}
	
}
