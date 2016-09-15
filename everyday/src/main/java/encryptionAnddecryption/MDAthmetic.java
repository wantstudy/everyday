package encryptionAnddecryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;

public class MDAthmetic {
    
    public static String str = "wangweiwei base64";
    
    public static void main(String[] args) {
        JDKMDArithmetic();
        commonCodecMDArithmetic();
        bouncyCastleMDArithmetic();
    }

    private static void bouncyCastleMDArithmetic() {
        
    }

    private static void commonCodecMDArithmetic() {
        
    }

    private static void JDKMDArithmetic() {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] digest2 = digest.digest(str.getBytes());
            System.out.println(Hex.encodeHexString(digest2));
            System.out.println(digest2.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
