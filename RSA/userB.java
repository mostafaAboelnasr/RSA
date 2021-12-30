/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accidentsketch.com.rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Mostafa Aboelnasr
 */
public class userB {

    public static BigInteger N, D, E, Z, p, q;
//    public static publicKey public_key;
//    public static privateKey private_key;

    public static void main(String[] args) {

        userA userA = new userA();
        userB userB = new userB();

//        userA.E = BigInteger.valueOf(7);
//        userA.N = BigInteger.valueOf(33);
//        userA.D = BigInteger.valueOf(3);
//
//        userB.E = BigInteger.valueOf(9);
//        userB.N = BigInteger.valueOf(55);
//        userB.D = BigInteger.valueOf(9);
//        System.out.println((new BigInteger(BigInteger.valueOf(6)+"").pow(9).mod(BigInteger.valueOf(55)).intValue()));
//        System.out.println("encrypt(encrypt(\"H\") = " + encrypt(encrypt("H")));
        String c = encrypt("H");
        String p = userA.decrypt(c);
        System.out.println(c);
        System.out.println(p);
    }

    public userB() {
        generate();
    }

    static void generate() {
        Random r = new Random();
        p = new BigInteger(6, 100, r);
//        System.out.println("B p = " + p);
        r = new Random();
        q = new BigInteger(6, 100, r);
//        System.out.println("B q = " + q);
        N = p.multiply(q);
        Z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        E = new BigInteger("4");
        while (BigInteger.valueOf(findGCD(Z.intValue(), E.intValue())).intValue() > 1) {
            E = E.add(new BigInteger("1"));
        }
        D = BigInteger.valueOf(modularMultiplicativeInverse(E, Z));
        if (D.equals(E)) {
            D.add(Z);
        }
    }

    public static void generateStatic() {
//        Random r = new Random();
//        p = new BigInteger(6, 100, r);
//        System.out.println("B p = " + p);
//        r = new Random();
//        q = new BigInteger(6, 100, r);
        System.out.println("B p = " + p);
        System.out.println("B q = " + q);
        N = p.multiply(q);
        Z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        E = new BigInteger("4");
        while (BigInteger.valueOf(findGCD(Z.intValue(), E.intValue())).intValue() > 1) {
            E = E.add(new BigInteger("1"));
        }
        D = BigInteger.valueOf(modularMultiplicativeInverse(E, Z));

//        System.out.println("B N = " + N);
//        System.out.println("B Z = " + Z);
//        System.out.println("B E = " + E);
//        System.out.println("B D = " + D);
    }

    static int getGCDs(BigInteger x, BigInteger y) {
        BigInteger gcd = x.gcd(y);
        return gcd.intValue();
    }

    static int modularMultiplicativeInverse(BigInteger number, BigInteger sizeOfAlphabet) {
        int a = number.intValue() % sizeOfAlphabet.intValue();
        for (int x = 1; x < sizeOfAlphabet.intValue(); x++) {
            if ((a * x) % sizeOfAlphabet.intValue() == 1) {
                return getMod(x, sizeOfAlphabet.intValue());
            }
        }
        return -1;
    }

    static int getMod(int x, int y) {
        int result = x % y;
        if (result < 0) {
            result += y;
        }
        return result;
    }

    static String encrypt(String plainText) {
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            int index = plainText.charAt(i);
            cipherText += "" + (char) (new BigInteger(index + "").pow(userA.E.intValue()).mod(userA.N).intValue());
//            cipherText += "" + (char) (getMod(new BigInteger(index + "").pow(userA.E.intValue()).intValue(), (userA.N).intValue()));
//            System.out.println("cipherText.charAt(i) " + (int)cipherText.charAt(i));
        }
        return cipherText;
    }

    static String decrypt(String cipherText) {
//        System.out.println("D  = " +D);
//        System.out.println("N  = " +N);
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int index = cipherText.charAt(i);
            plainText += "" + (char) (new BigInteger(index + "").pow(D.intValue()).mod(N).intValue());
//            plainText += "" + (char) (getMod(new BigInteger(index + "").pow(D.intValue()).intValue(), N.intValue()));
//            System.out.println("" + (char) (new BigInteger(index + "").pow(D.intValue()).mod(N).intValue()));
//            System.out.println("" + (char) (getMod(new BigInteger(index + "").pow(D.intValue()).intValue(), N.intValue())));
//            System.out.println("plainText.charAt(i) " + (int)plainText.charAt(i));
        }
        return plainText;
    }

    private static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);

    }
}
