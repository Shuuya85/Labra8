/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymock;

/**
 *
 * @author Miisu
 */
public class Asiakas {
private float saldo;

    public Asiakas(float alkuSaldo) {
        this.saldo = alkuSaldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float uusiSaldo) {
        this.saldo = uusiSaldo;
    }
}