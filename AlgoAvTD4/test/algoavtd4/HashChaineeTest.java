/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geoffrey
 */
public class HashChaineeTest {

    public HashChaineeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class HashChainee.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        
        HashDico<String> monDico = new HashChainee<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertEquals(monDico.rechercher("RM"), "R - M");
        assertEquals(monDico.rechercher("RRRR"), null);
        
        assertEquals(monDico.ajouter("RM", "toto"), "R - M");
        assertEquals(monDico.rechercher("RM"), "toto");
        
        
    }

    /**
     * Test of rechercher method, of class HashChainee.
     */
    @Test
    public void testRechercher() {
        System.out.println("rechercher");        
        HashDico<String> monDico = new HashChainee<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        String tabString[] = new String[93];
        for (int i = 0; i < fin; i++) {
            s= String.valueOf(c1) + String.valueOf(c2);
//            System.out.print(String.valueOf(c1) + " - ");
 //           System.out.print(String.valueOf(c2) + " - ");
 //           System.out.println(HashDico.getHashedIndex(String.valueOf(c1) + String.valueOf(c2), 512));
            tabString[i]= s;
            monDico.ajouter(s, s);
            c1++;
            c2--;
        }
        for (int i = 0; i < tabString.length; i++) {
            assertEquals(tabString[i], monDico.rechercher(tabString[i]));
        }
        assertEquals(null, monDico.rechercher("RRRRRR"));
        assertEquals(null, monDico.rechercher("RIib"));
        
        
    }

    /**
     * Test of exist method, of class HashChainee.
     */
    @Test
    public void testExist() {
        System.out.println("exist");
        
        HashDico<String> monDico = new HashChainee<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertTrue(monDico.exist("RM"));
        assertFalse(monDico.exist("RRRR"));
    }

    /**
     * Test of supprimer method, of class HashChainee.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        
        HashDico<String> monDico = new HashChainee<>(512);
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertTrue(monDico.exist("RM"));        
        monDico.supprimer("RM");
        assertFalse(monDico.exist("RM"));
    }

    /**
     * Test of nbElem method, of class HashChainee.
     */
    @Test
    public void testNbElem() {
        System.out.println("nbElem");
        
        HashDico<String> monDico = new HashChainee<>(512);
        
        assertEquals(monDico.nbElem(), 0);
        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertEquals(monDico.nbElem(), 93);
        
        monDico.ajouter("RM", "R-M");
        assertEquals(monDico.nbElem(), 93);
        
        monDico.supprimer("RM");
        assertEquals(monDico.nbElem(), 92);
        
        monDico.supprimer("RMEE");
        assertEquals(monDico.nbElem(), 92);
        
    }

    /**
     * Test of vider method, of class HashChainee.
     */
    @Test
    public void testVider() {
        System.out.println("vider");
        HashChainee instance = null;
        instance.vider();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estVide method, of class HashChainee.
     */
    @Test
    public void testEstVide() {
        System.out.println("estVide");
        
        HashDico<String> monDico = new HashChainee<>(512);
        
        assertTrue(monDico.estVide());
        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        String s = "";
        for (int i = 0; i < fin; i++) {
            s = String.valueOf(c1) + " - " + String.valueOf(c2);
            monDico.ajouter(String.valueOf(c1) + String.valueOf(c2), s);
            c1++;
            c2--;
        }
        
        assertFalse(monDico.estVide());
        
        monDico.vider();
        
        assertTrue(monDico.estVide());
    }

    /**
     * Test of estOrganise method, of class HashChainee.
     */
    @Test
    public void testEstOrganise() {
        System.out.println("estOrganise");
        HashChainee instance = null;
        boolean expResult = false;
        boolean result = instance.estOrganise();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of organiser method, of class HashChainee.
     */
    @Test
    public void testOrganiser() {
        System.out.println("organiser");
        HashChainee instance = null;
        instance.organiser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toSTring method, of class HashChainee.
     */
    @Test
    public void testToSTring() {
        System.out.println("toSTring");
        HashChainee instance = null;
        String expResult = "";
        String result = instance.toSTring();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
