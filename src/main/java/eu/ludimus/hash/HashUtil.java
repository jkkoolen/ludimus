package eu.ludimus.hash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class HashUtil {
    private static Logger LOG  = LoggerFactory.getLogger(HashUtil.class);
    private HashUtil() {

    }

    public static byte[] md5(final String password) {
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            return md5.digest();
        } catch(Exception e) {
            LOG.error("Error digesting password ", e);
            return new byte[0];
        }
    }

    public static String toHex(final byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
