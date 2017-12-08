import java.math.BigInteger;
import java.util.Random;

public class PrimalityTester {
	
	public PrimalityTester() {

	}
	
	private BigInteger randBigInt(int wordLength) {
		wordLength *= 4;	// takes word length and multiplies by 4 to get the number of bits required
		BigInteger randBig = new BigInteger(wordLength, new Random());	
		return randBig;
	}
	
	/*
	 * Function: millerRabinPrimeTest(BigInteger n, int roundCheck)
	 * Purpose: to test if BigInteger n is prime over a number of iterations >= 10
	 * a = ⱷ(n)
	 * b = e
	 * returns lastx which equals d
	 */
	 
	public boolean millerRabinPrimeTest(BigInteger n, int roundCheck) {
		
		int k = 0;					// k>0
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);
		BigInteger qOdd = nMinusOne;	
		boolean isPrime = false; 	// flag for main function to determine if n is prime or not
//		System.out.println("\nn:\t\t"+n+"\n(n-1):\t\t"+nMinusOne);
		
		while (qOdd.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
//			System.out.println("\nqOdd:\t\t"+qOdd+"\nk:\t\t"+k);		// debugging
			k=k+1;
			qOdd = qOdd.divide(BigInteger.valueOf(2));
		}
//		System.out.println("qOdd cannot be divided anymore");
		
		// if a^qOdd % n = 1, return inconclusive
		BigInteger a = BigInteger.ONE.add(randBigInt((nMinusOne.bitLength()-1)/4));
		if (a.modPow(qOdd, n).equals(BigInteger.valueOf(1))) {
//			System.out.println("aPowbModc is inconclusive");
			isPrime = true;
			return isPrime;
		}
		
//		System.out.println(verify(n, k, qOdd));			// debugging function to verify that n-1 = 2^k*q
		
		for (int i=0; i<roundCheck; i++) {
//			System.out.println("Round check "+i);
			for (int j=0; j<k; j++) {
				
//				System.out.println("Generating a");					// debugging
				a = BigInteger.ONE.add(randBigInt((nMinusOne.bitLength()-1)/4));
				
//				boolean test = a.compareTo(qOdd) > 0;
//				System.out.println("a.compareTo(qOdd) > 0 = "+test);	// comparing a and qOdd to verify a < qOdd
				
				while (a.equals(BigInteger.ONE) || a.equals(BigInteger.ZERO) || a.longValue() >= nMinusOne.longValue())
					a = BigInteger.ONE.add(randBigInt((nMinusOne.bitLength()-1)/4));
//				System.out.println("\nqOdd:\t\t"+qOdd+"\nk:\t\t"+k+"\na:\t\t"+a);

				// if (a^qOdd) % n = 1 return "inconclusive"
				if (a.modPow(qOdd, n).equals(BigInteger.ONE)) {
//					System.out.println("aPowbModc is inconclusive");
					isPrime = true;
					return isPrime;
				}
			}
		}
		return isPrime;
	}
	

	
	private static boolean verify(BigInteger n, int k, BigInteger qOdd) {
		// if ( n-1 = 2^k * q
		if (n.subtract(BigInteger.valueOf(1)).equals(BigInteger.valueOf(2).pow(k).multiply(qOdd)))
			return true;
		else 
			return false;
	}

	
}
