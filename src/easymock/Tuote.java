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
public class Tuote {
    
private float hinta;
    private String nimi;

    public Tuote(String nimi, float hinta) {
        this.nimi = nimi;
        this.hinta = hinta;
    }

    public String getNimi() {
        return nimi;
    }

    public float getHinta() {
        return hinta;
    }
}