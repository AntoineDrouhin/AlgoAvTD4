/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd4;

/**
 *
 * @author aureliengarret
 */
public class AlgoAvTD4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashDico<Integer> monDicoOAT = new HashOAT<>(10);
        HashDico<Integer> monDico = new HashChainee<>(10);
        
        char c1 = 33;
        char c2 = 126;
        int fin;
        fin = c2 - c1;
        for (int i = 0; i < fin; i++) { 
            System.out.print(String.valueOf(c1)+" - ");
            System.out.print(String.valueOf(c2)+" - ");
            System.out.println(HashDico.getHashedIndex(String.valueOf(c1)+String.valueOf(c2), 512));
            c1++;
            c2--;
        }
        
    }
    
}
