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

public class HashOAT<V> extends HashDico<V>{
    
    private Element[] tab;
    
    public HashOAT(int tailleInit) {
        this.tab = (Element[]) new Object[tailleInit];
    }
    
    public HashOAT() {
        this(32);
    }
    
    @Override
    public V ajouter(String cle, V valeur) {
        
        int hash = hashString(cle);
        
    }

    @Override
    public V rechercher(String cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exist(String cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V supprimer(String cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbElem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vider() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estVide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estOrganise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void organiser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSTring() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Element{
        String cle;
        V valeur;
        boolean libre;
        
        Element(String cle, V valeur){
            this.cle = cle;
            this.valeur = valeur;
            libre = false;
        }
    }
}
