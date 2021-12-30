/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accidentsketch.com.rsa;

import java.math.BigInteger;

/**
 *
 * @author Mostafa Aboelnasr
 */
public class privateKey {

    private static BigInteger D, N;

    public privateKey(BigInteger D, BigInteger N) {
        this.D = D;
        this.N = N;
    }

    public BigInteger getD() {
        return D;
    }

    public void setD(BigInteger D) {
        this.D = D;
    }

    public BigInteger getN() {
        return N;
    }

    public void setN(BigInteger N) {
        this.N = N;
    }

}
