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
public class publicKey {

    private BigInteger E, N;

    public publicKey(BigInteger E, BigInteger N) {
        this.E = E;
        this.N = N;
    }

    public BigInteger getE() {
        return E;
    }

    public void setE(BigInteger E) {
        this.E = E;
    }

    public BigInteger getN() {
        return N;
    }

    public void setN(BigInteger N) {
        this.N = N;
    }

}
