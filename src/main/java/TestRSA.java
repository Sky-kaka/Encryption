import org.apache.commons.codec.binary.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

public class TestRSA {

    public static void main(String[] args) {
        // 要加密的文本
        String PLAIN_TEXT = "北京市昌平区西北旺10号院，Beijing address ******";

        // 生成秘钥对
        Map<String, byte[]> keyMap = RSA.generateKeyBytes();

        // 获取公钥加密
        PublicKey publicKey = RSA.restorePublicKey(keyMap.get(RSA.PUBLIC_KEY));
        byte[] encodedText = RSA.RSAEncode(publicKey, PLAIN_TEXT.getBytes());
        System.out.println("RSA encoded: " + Base64.encodeBase64String(encodedText));

        // 获取私钥解密
        PrivateKey privateKey = RSA.restorePrivateKey(keyMap.get(RSA.PRIVATE_KEY));
        System.out.println("RSA decoded: " + RSA.RSADecode(privateKey, encodedText));
    }



}
