/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd4;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author aureliengarret
 * @param <V>
 */
public class HashChainee<V> extends HashDico<V> {


    protected Noeud[] tab;

    public HashChainee(int tailleInit) {        
        this.tab = (Noeud[]) Array.newInstance(Noeud.class, tailleInit);
        this.nbElem = 0;
    }

    @Override
    public V ajouter(String cle, V valeur) {

        int i = HashDico.getHashedIndex(cle, tab.length);

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
        int hash = HashDico.getHashedIndex(cle, tab.length);
        Noeud n = tab[hash];
        while (n != null) {
            if (cle.equals(n.cle)) {
                return n.elem;
            } else if (cle.compareTo(n.cle) < 0) {
                return null;
            }
            n = n.suiv;
        }
        return null;
    }

    @Override
    public boolean exist(String cle) {
        int hash = HashDico.getHashedIndex(cle, tab.length);
        Noeud n = tab[hash];
        while (n != null) {
            if (cle.equals(n.cle)) {
                return true;
            } else if (cle.compareTo(n.cle) < 0) {
                return false;
            }
            n = n.suiv;
        }
        return false;
    }

    @Override
    public V supprimer(String cle) {

        V valeur = null;

        int i = HashDico.getHashedIndex(cle, tab.length);

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
        // note aurélien : a tester cetter version !!
        Arrays.fill(tab, null);
        nbElem = 0;
    }

    @Override
    public boolean estVide() {
        return nbElem == 0;
    }

    @Override
    public boolean estOrganise() {
        return (nbElem / tab.length) <= 0.75;
    }

    @Override
    public void organiser() {
        if (!this.estOrganise()) {            
            Noeud[] oldTab = tab;
            Noeud[] tab = (Noeud[]) Array.newInstance(Noeud.class, oldTab.length*2);
            for (Noeud n : oldTab) {
                while (n != null) {
                    this.ajouter(n.cle, n.elem);
                    n = n.suiv;
                }
            }            
        }
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
        public Noeud(String cle, V elem, Noeud suiv) {
            this.cle = cle;
            this.elem = elem;
            this.suiv = suiv;
        }
    }

}
