import java.math.BigInteger;


public class RSA {

	public BigInteger[][] keyGeneration(BigInteger n, BigInteger e){
		PrimalityTester primeTester = new PrimalityTester();
		// keys[0] = public keys, keys[1] = private keys
		// keys format = {e/d, n}
    	BigInteger d = primeTester.extendedEuclid(n, e);
		
    	BigInteger[][] keys ={ {e, n}, {d, n} };
		return keys;
	}
	
	// Written by Corey
    public static BigInteger encryptRSA(BigInteger M, BigInteger e, BigInteger n) {    //M = pText, e = e, n = pq -> C = M^(e)%n
        
        BigInteger C = BigInteger.ZERO;
        
        C = M.modPow(e, n);
        
        return C;
    }
    
    public static BigInteger decryptRSA(BigInteger C, BigInteger d, BigInteger n) {    //C = cText, d = y from euclid, n = pq -> M = C^(d)%n
        
        BigInteger M = BigInteger.ZERO;
        
        M = C.modPow(d, n);
        
        return M;
    }
}