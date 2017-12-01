import java.math.BigInteger;
import java.util.Random;

public class main {

	
	// Added by Corey
	public static BigInteger[] extendedEuclid(BigInteger a, BigInteger b) {	//ax + by = 1
		
		//Base Conditions
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("1");
		BigInteger xNext = new BigInteger("1");
		BigInteger yNext = new BigInteger("0");
			
			//Finds the GCD, X, and Y
		    while( a.longValue() != 0) {
		        BigInteger q = b.divide(a);
		        BigInteger r = b.mod(a);						//Saves b%a
		        BigInteger m = x.subtract(xNext.multiply(q));	//m = x(i-2) - x(i-1)*q
		        BigInteger n = y.subtract(yNext.multiply(q));	//n = y(i-2) - y(i-1)*q
			        
		        b = a;											//b = a
		        a = r;											//a = b%a
		        x = xNext;										//x(i) = x(i-1)
		        y = yNext;										//y(i) = y(i-1)
		        xNext = m;										//x(i) = x(i-2) - x(i-1)*q
		        yNext = n;										//y(i) = y(i-2) - y(i-1)*q
		    }
			    
		    BigInteger gcd = b;
			    
		    if(gcd.longValue() != 1) {
		    	return null;
		    }else {
		    	BigInteger[] array = new BigInteger[3];
			    
		    	array[0] = gcd;
		    	array[1] = x;
		    	array[2] = y;
			    
		    	return array;
		    }
		}
	
	public static BigInteger randBigInt(int wordLength) {
		wordLength *= 4;	// takes word length and multiplies by 4 to get the number of bits required
		BigInteger randBig = new BigInteger(wordLength, new Random());	
		return randBig;
	}
	
    public static void main (String[] args) {
//    	PrimalityTester primeTester = new PrimalityTester();
    	
    	BigInteger a = new BigInteger("765248342531398642467465785432165743943253344455582794167");	// (2)
    	BigInteger b = new BigInteger("5432165743465789432425313986424674657854321657452897663568");// (6)
    	
    	BigInteger product = a.multiply(b);
    	
    	System.out.println("a = "+a+"\nb = "+b+"\na * b = "+product);
    	
    	
    	BigInteger p = randBigInt(68);
    	BigInteger q = randBigInt(68);
    	
    	boolean convertedP = p.isProbablePrime(10);
    	boolean convertedQ = q.isProbablePrime(10);

    	if (convertedP == false || convertedQ == false) {
	    	while (convertedP != true) {
	    		System.out.println("P is composite.\n\tp = "+p);
	    		p = randBigInt(68);
	    		convertedP = p.isProbablePrime(10);
	    	}
	    	
	    	while (convertedQ != true) {
	    		System.out.println("Q is composite.\n\tq = "+q);
	    		q = randBigInt(68);
	    		convertedQ = q.isProbablePrime(10);
	    	}
    	}
    	
    	System.out.println("p:\t"+p+"\nq:\t"+q);
//    	PrimalityTester pTest = new PrimalityTester(p, 10);
//    	PrimalityTester qTest = new PrimalityTester(q, 10);

    }
}
	
	