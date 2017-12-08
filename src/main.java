import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;


public class main {


    public static void main (String[] args) {
    	
    	PrimalityTester primeTester = new PrimalityTester();
    	BigInteger C, M;
    	Scanner scannerObj = new Scanner(System.in);
    	
		System.out.println("Please pick a value for your public key");
    	BigInteger e = scannerObj.nextBigInteger();
		
    	System.out.println("Please enter a 2 digit number to encrypt");
    	M = scannerObj.nextBigInteger();
    	scannerObj.close();
    	
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

    	while (primeTester.millerRabinPrimeTest(p) == false || 
    			primeTester.millerRabinPrimeTest(q) == false ||
    			p.toString().length() < 80 || q.toString().length() < 80) {
    		if (primeTester.millerRabinPrimeTest(p) == false || p.toString().length() < 80)
    			p = new BigInteger(272, new Random());
    		else
    			q = new BigInteger(272, new Random());
    	}
    	
    	BigInteger n = p.multiply(q);
//    	BigInteger d = extendedEuclid(n, BigInteger.valueOf(e));
    	System.out.println("p:\t"+p+"\nq:\t"+q);

    	
    	RSA rsaObj = new RSA();

    	BigInteger[][] keys = rsaObj.keyGeneration(n, e);
    	
    	for (int i=0; i<keys.length; i++) {
    		System.out.println("{"+keys[i][0]+", "+keys[i][1]+"}");
    	}
    	
    	C = rsaObj.encryptRSA(M, e, n);
    	System.out.println("enrypted input = "+C);
    	System.out.println("decrypted input = "+rsaObj.decryptRSA(C, keys[0][0], n));
    	
//    	while (p.isProbablePrime(15) == false || q.isProbablePrime(15) == false) {
//    		p = randBigInt(68);
//    		q = randBigInt(68);
//    	}
    	

//    	primeTester.millerRabinPrimeTest(q);
//    	PrimalityTester pTest = new PrimalityTester(p, 10);
//    	PrimalityTester qTest = new PrimalityTester(q, 10);
//    	primeTester.printList(primeTester.millerRabinPrimeTest(p));
//    	primeTester.printList(primeTester.millerRabinPrimeTest(q));
    	

    }
}
	
	