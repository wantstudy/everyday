package encryptionAnddecryption;


import java.security.Security;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Arithmetic {

    public static String str = "wangweiwei base64";
    
    public static void main(String[] args) {
        JDKBase64Arithmetic();
        commonCodecArithmetic();
        bouncyCastleArithmetic();
    }
    
    static{
        
    }
    
    public static void JDKBase64Arithmetic(){
        try {
           BASE64Encoder base64Encoder = new BASE64Encoder();
           String encode = base64Encoder.encode(str.getBytes());
           System.out.println("jdk base64 encryption: " + encode);
           
           BASE64Decoder base64Decoder = new BASE64Decoder();
           byte[] decodeBuffer = base64Decoder.decodeBuffer(encode);
           System.out.println("jdk base64 decryption: " + new String(decodeBuffer));
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void commonCodecArithmetic(){
        Base64 base64 = new Base64();
        byte[] encode = base64.encode(str.getBytes());
        System.out.println("cc base64 encryption: " + new String(encode));
        
        byte[] decode = base64.decode(encode);
        System.out.println("jdk base64 encryption: " + new String(decode));
    }
    
    public static void bouncyCastleArithmetic(){
        Security.addProvider(new BouncyCastleProvider());
        @SuppressWarnings("unused")
        org.bouncycastle.util.encoders.Base64 bc64 = new org.bouncycastle.util.encoders.Base64();
        byte[] endoe = org.bouncycastle.util.encoders.Base64.encode(str.getBytes());
        System.out.println("bc base64 encryption: " + new String(endoe));

        byte[] decdoe = org.bouncycastle.util.encoders.Base64.decode(endoe);
        System.out.println("bc base64 encryption: " + new String(decdoe));
        
    }
    
}
