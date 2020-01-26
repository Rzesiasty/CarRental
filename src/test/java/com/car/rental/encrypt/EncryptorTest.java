package com.car.rental.encrypt;


import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class EncryptorTest {

    @Test
    public void encryptPasswordTest() throws NoSuchAlgorithmException, NoSuchProviderException {
        //Given
        System.out.println(Encrypt.hashPassword("HelloAgain"));
    }
}
