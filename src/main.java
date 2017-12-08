import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;


public class main {

	
	// Author: Corey
	/*
	 * Function: extendedEuclid(BigInteger a, BigInteger b)
	 * Purpose: to compute the private key based upon the user input public key
	 * a = ⱷ(n)
	 * b = e
	 * returns lastx which equals d
	 */
	public static BigInteger extendedEuclid(BigInteger a, BigInteger b) {	//a = e, b = phi(n)

		//Base Conditions
		BigInteger x = BigInteger.valueOf(0);
		BigInteger y = BigInteger.valueOf(1);
		BigInteger lastx = BigInteger.valueOf(1);
		BigInteger lasty = BigInteger.valueOf(0);
		BigInteger temp;
		
        while (!b.equals(BigInteger.ZERO))
        {
            BigInteger q = a.divide(b);
            BigInteger r = a.mod(b);
 
            a = b;
            b = r;
 
            temp = x;
            x = lastx.subtract(q.multiply(x));
            lastx = temp;
 
            temp = y;
            y = lasty.subtract(q.multiply(y));
            lasty = temp;            
        }
        return lastx;
	}

	
    public static void main (String[] args) {
    	
    	PrimalityTester primeTester = new PrimalityTester();
    	
    	Scanner scannerObj = new Scanner(System.in);
    	
		System.out.println("Please pick a value for your public key");
    	int e = scannerObj.nextInt();
		
		System.out.println("Enter the number of iterations you would like performed");
		int userCertainty = scannerObj.nextInt();
    	
    	
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
    	
    	
    	// BigInteger Test
//    	BigInteger a = new BigInteger("765248342531398642467465785432165743943253344455582794167");	// (2)
//    	BigInteger b = new BigInteger("5432165743465789432425313986424674657854321657452897663568");// (6)
//    	
//    	BigInteger product = a.multiply(b);
//    	
//    	System.out.println("a = "+a+"\nb = "+b+"\na * b = "+product);
//    	
//    	
    	BigInteger p = new BigInteger(272, new Random());
    	BigInteger q = new BigInteger(272, new Random());
    	
    	while (primeTester.millerRabinPrimeTest(p, userCertainty) == false || 
    			primeTester.millerRabinPrimeTest(q, userCertainty) == false ||
    			p.toString().length() < 80 || q.toString().length() < 80) {
    		if (primeTester.millerRabinPrimeTest(p, userCertainty) == false || p.toString().length() < 80)
    			p = new BigInteger(272, new Random());
    		else
    			q = new BigInteger(272, new Random());
    	}
    	
    	System.out.println(extendedEuclid(BigInteger.valueOf(42), BigInteger.valueOf(30)));
    	
//    	while (p.isProbablePrime(15) == false || q.isProbablePrime(15) == false) {
//    		p = randBigInt(68);
//    		q = randBigInt(68);
//    	}
    	
    	System.out.println("p:\t"+p+"\nq:\t"+q);
//    	primeTester.millerRabinPrimeTest(q);
//    	PrimalityTester pTest = new PrimalityTester(p, 10);
//    	PrimalityTester qTest = new PrimalityTester(q, 10);
//    	primeTester.printList(primeTester.millerRabinPrimeTest(p));
//    	primeTester.printList(primeTester.millerRabinPrimeTest(q));
    	

    }
}
	
	