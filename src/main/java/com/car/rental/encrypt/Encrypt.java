package com.car.rental.encrypt;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class Encrypt {

    public static String hashPassword(String password) throws NoSuchProviderException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(createSalt());
        byte[] hash = digest.digest(password.getBytes());
        return bytesToStingHex(hash);
    }

    private static byte[] createSalt(){
        byte[] bytes = new byte[20];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }

    private final static char[] hexArray = "0123456789ABCDEFGHIJKLMNOPRSTUWXYZ".toCharArray();

    private static String bytesToStingHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] =hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}