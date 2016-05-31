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
        this.nbElem = 0;
    }

    @Override
    public V ajouter(String cle, V valeur) {
        
        int i = this.getHash(cle);

        Noeud cour = tab[i], prec = null;
        int cmp = -1;
        while (cour != null && (cmp = cle.compareTo(cour.cle)) > 0) {
            prec = cour;
            cour = cour.suiv;
        }
        // test existe deja 
        if (cmp == 0) {
            V ancienneValeur = cour.elem;
            cour.cle = cle;
            cour.elem = valeur;
            return ancienneValeur;
        }
        ++nbElem;
        Noeud nouv = new Noeud(cle, valeur, cour);
        if (prec == null) {
            tab[i] = nouv;
        } else {
            prec.suiv = nouv;
        }

        // didou a dit c'est l'utilisateur qui le fait le organiser
        //if (estOrganise()) {
        //    organiser();
        //}
        return valeur;
    }

    @Override
    public V rechercher(String cle) {
        int hash = this.getHash(cle);
  
        return rechercherWrapperRecur(tab[hash], cle).elem;
        
        
    }

    private Noeud rechercherWrapperRecur(Noeud n, String cle) {
        if (n == null) {
            return null;
        }
        if (cle.equals(n.cle)) {
            return n;
        } else if (cle.compareTo(n.cle) < 0) {
            return null;
        }
        return rechercherWrapperRecur(n.suiv, cle);

    }

    @Override
    public boolean exist(String cle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V supprimer(String cle) {
        
        V valeur = null;
        
        int i = this.getHash(cle);
        
        Noeud cour = tab[i];
        Noeud prec = null;
        
        int cmp = -1;
        while (cour != null && (cmp = cle.compareTo(cour.cle)) > 0) {
            prec = cour;
            cour = cour.suiv;
        }
        
        // valeur trouvée
        if (cmp == 0) {
            valeur = cour.elem;             
            if (prec == null) {
                tab[i] = cour.suiv;
            } else {
                prec.suiv = cour.suiv;
            }            
            --nbElem;            
        }
        
        return valeur;
    }

    @Override
    public int nbElem() {
        return nbElem;
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

    protected int getHash(String cle) {        
        return HashDico.hashString(cle) % tab.length;
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
        public Noeud(String cle, V elem, Noeud suiv) {
            this.cle = cle;
            this.elem = elem;
            this.suiv = suiv;
        }
    }

}
