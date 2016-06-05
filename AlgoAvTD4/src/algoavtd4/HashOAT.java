/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoavtd4;

import java.lang.reflect.Array;

/**
 *
 * @author aureliengarret
 */
public class HashOAT<V> extends HashDico<V> {

    private Element[] tab;
    private int nbElemInit;
    
    public HashOAT(int tailleInit) {
        this.tab = (Element[]) Array.newInstance(Element.class, tailleInit);
        nbElem = 0;
        nbElemInit = tailleInit;
    }

    public HashOAT() {
        this(32);
    }

    @Override
    public V ajouter(String cle, V valeur) {

        int i = HashDico.getHashedIndex(cle, tab.length);
        V retour = null;
        
        if (tab[i] == null) {
            tab[i] = new Element(cle, valeur);
            nbElem++;
        }
        else {
            int l =  0;
            while (l < tab.length) {
                i = (i+1)%tab.length;
                if (tab[i] == null) {
                    tab[i] = new Element(cle, valeur);
                    nbElem++;
                    break;
                }
                if (tab[i].libre) {
                    tab[i].cle = cle;
                    tab[i].valeur = valeur;
                    tab[i].libre = false;
                     nbElem++;
                    break;
                }
                if (tab[i].cle.equals(cle)){
                    retour = tab[i].valeur;
                    tab[i].valeur = valeur;
                    break;
                }
                l++;
            }
        }               
        
        // Daniel Diaz préfère que l'utilisateur reoorganise lui même le tableau
        //if(!estOrganise())
        //    organiser();
        
        return retour;
        
    }

    @Override
    public V rechercher(String cle) {
        
        int i = HashDico.getHashedIndex(cle, tab.length);
        
        
        while(tab[i%tab.length] != null) {
            if(tab[i%tab.length].cle.equals(cle)){
                if(tab[i%tab.length].libre == true){
                    break;
                }
                return tab[i%tab.length].valeur;
            }
            i++;
        }
        
        return null;        
    }

    @Override
    public boolean exist(String cle) {
        
        return this.rechercher(cle) != null;
        
    }

    @Override
    public V supprimer(String cle) {
        
        int i = HashDico.getHashedIndex(cle, tab.length);
        
        while(tab[i++%tab.length] != null) {
            if(tab[i].cle.equals(cle)){
                if(tab[i].libre == true){
                    break;
                }
                tab[i].libre = true;
                nbElem--;
                return tab[i].valeur;
            }
        }
        
        return null;
        
    }

    @Override
    public void vider() {
        this.tab = (Element[]) Array.newInstance(Element.class, nbElemInit);
        nbElem = 0;
    }


    @Override
    public boolean estOrganise() {
        return (nbElem / tab.length) <= 0.75;
    }

    @Override
    public void organiser() {
        Element[] oldTab = tab;
        this.tab = (Element[]) Array.newInstance(Element.class, tab.length * 2);
        
        for (Element oldElem : oldTab) {
            if (oldElem != null && oldElem.libre == false) {
                ajouter(oldElem.cle, oldElem.valeur);
            }
        }
    }

    @Override
    public String toSTring() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < tab.length; i++){
            if (tab[i] != null && tab[i].libre == false) {
                sb.append("[ ");
                sb.append(i);
                sb.append(" ; ");
                sb.append(tab[i].cle);
                sb.append(" ; ");
                sb.append(tab[i].valeur);
                sb.append(" ]\n");
            }
        }
        return sb.toString();
    }

    private class Element {

    String cle;
    V valeur;
    boolean libre;

    Element(String cle, V valeur) {
        this.cle = cle;
        this.valeur = valeur;
        libre = false;
    }

    }
}
