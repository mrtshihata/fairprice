package com.minute.rest.webservices.restfullwebservices.keys;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;




/**
 * @author gtshihata
 *
 */
public class Encryptor {
    public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string: "
                    + Base64.encodeBase64String(encrypted));

            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    /**
     * @param bites can be 128 or 64
     * @return
     */
    public static long keyGen(int bites) {
     
    	UUID uuid = UUID.randomUUID() ;
    	
    	if (bites==128) {
    long mostSignificant = uuid.getMostSignificantBits() ;
	return mostSignificant;
    	}else if (bites==64) {
    		long leastSignificant = uuid.getLeastSignificantBits() ;
    		return leastSignificant;
    	}else {
    		System.out.println("bitesNotInScope");
    	}
		return bites;

    }
    
    public static IvParameterSpec iVectorGen() {
    	 // build the initialization vector (randomly).
        SecureRandom random = new SecureRandom();
        byte iv[] = new byte[16];//generate random 16 byte IV AES is always 16bytes
        random.nextBytes(iv);
        IvParameterSpec ivspec = new IvParameterSpec(iv);
		return ivspec;
    }
    public static Integer rdn() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<99999; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<1; i++) {
            System.out.println(list.get(i));
            return list.get(i);
        }
		return null;
		
    }
	private static final String ALPHA_NUMERIC_STRING = rdn()+"8rdn()"+rdn()+"A"+rdn()+"$(BCrdn()+7DE/`{QRS)3TF}GMN9O>.Y%^&*Z01@2]4"+System.currentTimeMillis()+"6?~_+=-HI:;JKL'<,?PUV!5WX[";

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	// Step 1. Generate 16 digit wich is not duplicated
    // Step 2. divide by 4 digit

    private static List<Integer> pickRandomIndex (String original, int count) {
        List<Integer> randIndices = new ArrayList<Integer>();
        Set<Integer> noDuplicateIndices = new HashSet<Integer>();
        System.out.println(noDuplicateIndices.size() + "    " + count);
        while (noDuplicateIndices.size() < count){
            System.out.println(noDuplicateIndices.size() + "    " + count);
            int randNumber = (int)(Math.random() * original.length());
            noDuplicateIndices.add(randNumber);
        }
        randIndices.addAll(noDuplicateIndices);
        return randIndices;
    }

    // FROM 97 - 122
    private static char convertDigit2Char(char digit) {
        return (char)(17 + digit);
    }

    private static String generateCode(int digit, int charCnt) {
        long nano = System.nanoTime();
        StringBuilder util = new StringBuilder(String.valueOf(nano));
        util = util.reverse();
        List<Integer> convertIndices = pickRandomIndex(util.toString(), charCnt);
        System.out.println("Below indices will be casting to Alphabet " + convertIndices);

        for(Integer i : convertIndices){
            char target = util.charAt(i);
            util.setCharAt(i, convertDigit2Char(target));
        }
        return util.toString();
    }

    private static String beautifyDigits(String original, int term){
        System.out.println("original " + original);
        return original.substring(0, term) + "-" + original.substring(term, 2*term)
                + "-" + original.substring(2*term, 3*term) + "-" + original.substring(3*term, 4*term);
    }


    public static void test() throws Exception {
        int digit = 16;
        System.out.println(digit + " digits random code > " + beautifyDigits(generateCode(16, 4), 4));
    }
    
    public static String digitSecretPhrase() {
		return beautifyDigits(generateCode(16, 4), 4);
    }

    public static void main(String[] args) {
        String key = randomAlphaNumeric(16); // 128 bit key
        System.out.println(key);
        String initVector = randomAlphaNumeric(16); // 16 bytes IV
        System.out.println(initVector);

        System.out.println(decrypt(key, initVector, encrypt(key, initVector, secretPhrase)));
        System.out.println(secretPhrase);
      //  System.out.println(encrypt(key, initVector, secretPhrase));
    
    }
    
    private static String secretPhrase = ALPHA_NUMERIC_STRING;
   
    
    
    
}