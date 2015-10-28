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
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
/**
 *
 * @author Miisu
 */
public class TilaustenKasittelyEasymockTest {
    
    // tuote.getHinta() < 100
    @Test
    public void testaaKasittelijaWithEasyMockHinnoittelija() {
// arrange
        float alkuSaldo = 200.0f;
        float listaHinta = 90.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija = createMock(Hinnoittelija.class);
// record
        hinnoittelija.aloita();
        hinnoittelija.lopeta();
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote)).andReturn(alennus);
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote)).andReturn(alennus);
        replay(hinnoittelija);
// act
        TilaustenKasittely kasittelija = new TilaustenKasittely();
        kasittelija.setHinnoittelija(hinnoittelija);
        kasittelija.kasittele(new Tilaus(asiakas, tuote));
// assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelija);
    }

    // tuote.getHinta() >= 100
    @Test
    public void testaaKasittelijaWithEasyMockHinnoittelija2() {
// arrange
        float alkuSaldo = 200.0f;
        float listaHinta = 110.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija = createMock(Hinnoittelija.class);
// record
        hinnoittelija.aloita();
        hinnoittelija.lopeta();
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote)).andReturn(alennus);
        hinnoittelija.setAlennusProsentti(asiakas, alennus + 5);
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote)).andReturn(alennus);
        replay(hinnoittelija);
// act
        TilaustenKasittely kasittelija = new TilaustenKasittely();
        kasittelija.setHinnoittelija(hinnoittelija);
        kasittelija.kasittele(new Tilaus(asiakas, tuote));
// assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelija);
    }

    // tuote.getHinta() == 100
    @Test
    public void testaaKasittelijaWithEasyMockHinnoittelija3() {
// arrange
        float alkuSaldo = 200.0f;
        float listaHinta = 100.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija = createMock(Hinnoittelija.class);
// record
        hinnoittelija.aloita();
        hinnoittelija.lopeta();
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote)).andReturn(alennus);
        hinnoittelija.setAlennusProsentti(asiakas, alennus + 5);
        expect(hinnoittelija.getAlennusProsentti(asiakas, tuote)).andReturn(alennus);
        replay(hinnoittelija);
// act
        TilaustenKasittely kasittelija = new TilaustenKasittely();
        kasittelija.setHinnoittelija(hinnoittelija);
        kasittelija.kasittele(new Tilaus(asiakas, tuote));
// assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelija);
    }
}
