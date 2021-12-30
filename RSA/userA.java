/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accidentsketch.com.rsa;

import java.math.BigInteger;
import java.util.Random;
//import javax.swing.JOptionPane;

/**
 *
 * @author Mostafa Aboelnasr
 */
public class userA {

    public static BigInteger N, D, E, Z, p, q;
//    public static publicKey public_key;
//    public static privateKey private_key;
    static char spaceAndCapitalAndsmall[] = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

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
//        String p = userB.decrypt(c);
        System.out.println(c);
//        System.out.println(p);
    }

    userA() {
        generate();
    }

    static void generate() {
        Random r = new Random();
        p = new BigInteger(6, 100, r);
//        System.out.println("A p = " + p);
        r = new Random();
        q = new BigInteger(6, 100, r);
//        System.out.println("A q = " + q);
        N = p.multiply(q);
        Z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        E = new BigInteger("4");
        while (BigInteger.valueOf(findGCD(Z.intValue(), E.intValue())).intValue() > 1) {
            E = E.add(new BigInteger("1"));
        }
        D = BigInteger.valueOf(modularMultiplicativeInverse(E, Z));
//        D=new BigInteger("1");
//        E=new BigInteger("1");

        if (D.equals(E)) {
            D.add(Z);
        }
//        p = new BigInteger("12131072439211271897323671531612440428472427633701410925634549312301964373042085619324197365322416866541017057361365214171711713797974299334871062829803541");
//        q = new BigInteger("12027524255478748885956220793734512128733387803682075433653899983955179850988797899869146900809131611153346817050832096022160146366346391812470987105415233");
//        E = new BigInteger("65537");
//        D = new BigInteger("89489425009274444368228545921773093919669586065884257445497854456487674839629818390934941973262879616797970608917283679875499331574161113854088813275488110588247193077582527278437906504015680623423550067240042466665654232383502922215493623289472138866445818789127946123407807725702626644091036502372545139713");
    }

    public static void generateStatic() {
//        Random r = new Random();
//        p = new BigInteger(6, 100, r);
////        System.out.println("A p = " + p);
//        r = new Random();
//        q = new BigInteger(6, 100, r);
//        System.out.println("A q = " + q);

        System.out.println("A p = " + p);
        System.out.println("A q = " + q);
        N = p.multiply(q);
        Z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        E = new BigInteger("4");
        while (BigInteger.valueOf(findGCD(Z.intValue(), E.intValue())).intValue() > 1) {
            E = E.add(new BigInteger("1"));
        }
        D = BigInteger.valueOf(modularMultiplicativeInverse(E, Z));
//        System.out.println("A N = " + N);
//        System.out.println("A Z = " + Z);
//        System.out.println("A E = " + E);
//        System.out.println("A D = " + D);
    }

    static int getGCD(BigInteger x, BigInteger y) {
        BigInteger gcd = x.gcd(y);
        return gcd.intValue();
    }

    private static int modularMultiplicativeInverse(BigInteger number, BigInteger sizeOfAlphabet) {
        int a = number.intValue() % sizeOfAlphabet.intValue();
        for (int x = 1; x < sizeOfAlphabet.intValue(); x++) {
            if ((a * x) % sizeOfAlphabet.intValue() == 1) {
                return getMod(x, sizeOfAlphabet.intValue());
            }
        }
        return -1;
    }

    private static int getMod(int x, int y) {
        int result = x % y;
        if (result < 0) {
            result += y;
        }
        return result;
    }

    private static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);

    }

    static String encrypt(String plainText) {
        StringBuilder cipherText = new StringBuilder();
//        System.out.println("userB.E  = " + userB.E);
//        System.out.println("userB.N  = " + userB.N);
//        System.out.println("userA.p  = " + userA.p);
//        System.out.println("userA.q  = " + userA.q);
        for (int i = 0; i < plainText.length(); i++) {
            int index = plainText.charAt(i);
//            index = 6;
            cipherText.append("").append((char) (new BigInteger(index + "").pow(userB.E.intValue()).mod(userB.N).intValue()));
            char c1 = (char) (new BigInteger(index + "").intValue());
//            char c2 = (char) (new BigInteger(index + "").pow(userB.E.intValue()).intValue());
//            String c2 = "" + (char) (getMod(new BigInteger(index + "").pow(userB.E.intValue()).intValue(), (userB.N).intValue()));
//            System.out.println("" + (char) (getMod(new BigInteger(index + "").pow(userB.E.intValue()).intValue(), (userB.N).intValue())));
//            System.out.println("" + (char) (new BigInteger(index + "").pow(userB.E.intValue()).mod(userB.N).intValue()));
//            System.out.println("c1 = " + (int) c1);
//            System.out.println("c2 = " + (int) c2);
//            System.out.println("c2 = " + c2);
        }
        return cipherText.toString();
    }

    static String decrypt(String cipherText) {

//        System.out.println("userA.D  = " + userA.D);
//        System.out.println("userA.N  = " + userA.N);
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int index = cipherText.charAt(i);
            plainText += "" + (char) (new BigInteger(index + "").pow(D.intValue()).mod(N).intValue());
//            plainText += "" + (char) (getMod(new BigInteger(index + "").pow(D.intValue()).intValue(), N.intValue()));
//            System.out.println("" + (char) (new BigInteger(index + "").pow(D.intValue()).mod(N).intValue()));
//            System.out.println("" + (char) (getMod(new BigInteger(index + "").pow(D.intValue()).intValue(),N.intValue())));
//            System.out.println("plainText.charAt(i) " + plainText.charAt(i));
        }
        return plainText;
    }

}
