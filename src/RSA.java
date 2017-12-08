import java.math.BigInteger;

// Written by Corey
public class RSA {

    
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