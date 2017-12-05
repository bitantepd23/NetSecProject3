import java.awt.List;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class PrimalityTester {
	
	long testNumber;
	int iterator;
	boolean primeCheck;
	
	public PrimalityTester() {
//		Scanner userInput = new Scanner(System.in);
//		System.out.println("Please enter a number");
//		this.testNumber = userInput.nextLong();
//		
//		System.out.println("Enter the number of iterations you would like performed");
//		this.iterator = userInput.nextInt();
//		
//		while (this.iterator < 10) {
//			System.out.println("Please enter a value of at least 10 iterations");
//			this.iterator = userInput.nextInt();
//		}
//		userInput.close();
//		primeCheck = this.checkPrimality(this.testNumber, this.iterator);
//		this.returnAnswer(testNumber, primeCheck);
	}
	
	public PrimalityTester(BigInteger testNumber, int iterator) {
		Scanner userInput = new Scanner(System.in);
		
		if (iterator < 10) {
			System.out.println("Please enter a value of at least 10 iterations");
			iterator = userInput.nextInt();
		}
		userInput.close();
		
		
	}
	
	public void millerRabinPrimeTest(BigInteger n) {
		
		BigInteger k = BigInteger.ZERO;
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);
		BigInteger q = nMinusOne;

		System.out.println("\nn:\t\t"+n+"\n(n-1):\t\t"+nMinusOne);
		
		while (q.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			System.out.println("\nq:\t\t"+q+"\nk:\t\t"+k);
			k = k.add(BigInteger.ONE);
			q = q.divide(BigInteger.valueOf(2));
		}
		
		List conclusive = new List();
		List inconclusive = new List();
		
		for (int i=0; i<10; i++) {
			
			Random randGen = new Random();
			BigInteger a = new BigInteger(nMinusOne.bitLength()-1, randGen);
			
			while (a.equals(BigInteger.ONE) || a.equals(BigInteger.ZERO))
					a = new BigInteger(nMinusOne.bitLength(), randGen);
			// Variables k, q, and a are setup now
			System.out.println("\nq:\t\t"+q+"\nk:\t\t"+k+"\na:\t\t"+a);
			
			
			// if (a^q) % n = 1 return "inconclusive"
			if (a.pow(q.intValue()).mod(n).equals(BigInteger.ONE)) {
				inconclusive.add(a.toString());
			}
			
			for (int j=0; j<k.intValue(); j++) {
				if ((a.pow(2^j).multiply(q).mod(n)).equals(nMinusOne))
					inconclusive.add(a.toString(), j);
			}
			
		}
		
		for (int i=0; i<inconclusive.getItemCount(); i++) {
			conclusive.add(inconclusive.getItem(i));
		}
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
	
	public boolean checkPrimality(long testNumber, int iter) {
		
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
	
	public void returnAnswer(long testNumber, boolean primeCheck) {
		if (primeCheck == true) {
			System.out.println(testNumber+" is a prime number.");
		}
		else {
			System.out.println(testNumber+" is a compostite number.");
		}
	}
	
	public void printList(List list) {
		
		for (int i=0; i<list.getItemCount(); i++) {
			System.out.println(list.getItem(i));
		}
	}
	
}
