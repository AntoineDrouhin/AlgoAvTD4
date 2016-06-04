/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd4;

/**
 *
 * @author aureliengarret
 * @param <V>
 */
public abstract class HashDico<V>  implements Dico<String, V> {
    
    protected int nbElem;
    static int hashString(String s) {
        
        int h = 0;
        
        for(int i = 0; i < s.length(); ++i) {
            h = 97 * h + s.charAt(i) - ' ';
        }
        
        return Math.abs(h);
    }
    
    static int getHashedIndex(String cle, int index) {        
        return hashString(cle) % index;
    }
   
}
