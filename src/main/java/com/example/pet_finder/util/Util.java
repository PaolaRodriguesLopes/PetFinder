package com.example.pet_finder.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
    public static String md5(String pass) throws NoSuchAlgorithmException{
        MessageDigest messagedig = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, messagedig.digest(pass.getBytes()));
        return hash.toString(16);
    }
}