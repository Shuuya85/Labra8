/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import easymock.Asiakas;
import easymock.Hinnoittelija;
import easymock.Tilaus;
import easymock.TilaustenKasittely;
import easymock.Tuote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miisu
 */
public class TilaustenKasittelyFakeTest {
    
    @Test
    public void testaaKasittelijaWithFakeHinnoittelija() {
// arrange
        float alkuSaldo = 100.0f;
        float listaHinta = 30.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija = new FakeHinnoittelija(alennus);
// act
        TilaustenKasittely kasittelija = new TilaustenKasittely();
        kasittelija.setHinnoittelija(hinnoittelija);
        kasittelija.kasittele(new Tilaus(asiakas, tuote));
// assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
    }
}
