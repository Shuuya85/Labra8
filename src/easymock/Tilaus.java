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
public class Tilaus {
    
private Asiakas asiakas;
    private Tuote tuote;

    public Tilaus(Asiakas asiakas, Tuote tuote) {
        this.asiakas = asiakas;
        this.tuote = tuote;
    }

    public Tuote getTuote() {
        return tuote;
    }

    public Asiakas getAsiakas() {
        return asiakas;
    }
}
