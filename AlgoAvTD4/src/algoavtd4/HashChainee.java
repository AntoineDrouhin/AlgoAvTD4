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
public class HashChainee<V> extends HashDico<V> {
    /////////////////////////////////////////////////////////////////////////////////
    // AJOUTER LE REDIMENSIONNAGE ET LES CONTROLE QUI VONT AVEC MA GUELLE
    ////////////////////////////////////////////////////////////////////////////

    protected Noeud[] tab;

    public HashChainee(int tailleInit) {
        this.tab = (Noeud[]) new Object[tailleInit];
    }

    @Override
    public V ajouter(String cle, V valeur) {
        int h = Math.abs(HashDico.hashString(cle));
        int i = h%tab.length;
       
        if (tab[i] == null) {
            Noeud n = new Noeud(valeur);            
        }            
        else {
            Noeud n = tab[i];
            while (n.suiv != null) {                
            }
            n.suiv = new Noeud(valeur);
        } 
            
        return valeur;
    }

    @Override
    public V rechercher(String cle) {        
        int hash = HashDico.hashString(cle);
        if(tab[hash].suiv==null && cle){
            return tab[hash].elem;
        }
        else{
            tab[hash].suiv
        }
        
        
        return null;
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

    /**
     * Encapsule les propriétés d'un noeud necessaire à la liste constituant la
     * file
     */
    private class Noeud {

        public String cle;
        
        
        /**
         * L'élement
         */
        public V elem;

        /**
         * Le noeud suivant
         */
        public Noeud suiv;

        /**
         * Constructeur
         *
         * @param elem
         * @param suiv
         */

        public Noeud(String cle,V elem) {
            this.elem = elem;

        }
    }

}
