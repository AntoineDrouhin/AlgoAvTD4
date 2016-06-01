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
public class HashOAT<V> extends HashDico<V> {

    private Element[] tab;
    private int nbElemInit;
    
    public HashOAT(int tailleInit) {
        this.tab = (Element[]) new Object[tailleInit];
        nbElem = 0;
        nbElemInit = tailleInit;
    }

    public HashOAT() {
        this(32);
    }

    @Override
    public V ajouter(String cle, V valeur) {

        int i = Math.abs(hashString(cle))%tab.length;
        V retour = null;
        
        if (tab[i] == null) {
            tab[i] = new Element(cle, valeur);
        }
        else {
            while (true) {
                if (tab[++i%tab.length] == null) {
                    tab[i] = new Element(cle, valeur);
                    break;
                }
                if (tab[i].libre) {
                    tab[i].cle = cle;
                    tab[i].valeur = valeur;
                    tab[i].libre = false;
                    break;
                }
                if (tab[i].cle.equals(cle)){
                    retour = tab[i].valeur;
                    tab[i].valeur = valeur;
                    break;
                }
            }
        }
        
        nbElem++;
        
        if(!estOrganise())
            organiser();
        
        return retour;
        
    }

    @Override
    public V rechercher(String cle) {
        
        int i = Math.abs(hashString(cle))%tab.length;
        
        
        while(tab[i++%tab.length] != null) {
            if(tab[i].cle.equals(cle)){
                if(tab[i].libre == true){
                    break;
                }
                return tab[i].valeur;
            }
        }
        
        return null;        
    }

    @Override
    public boolean exist(String cle) {
        
        return this.rechercher(cle) != null;
        
    }

    @Override
    public V supprimer(String cle) {
        
        int i = Math.abs(hashString(cle))%tab.length;
        
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
    public int nbElem() {
        return nbElem;
    }

    @Override
    public void vider() {
        this.tab = (Element[]) new Object[nbElemInit];
        nbElem = 0;
    }

    @Override
    public boolean estVide() {
        return nbElem == 0;
    }

    @Override
    public boolean estOrganise() {
        return nbElem < (0.75 * tab.length);
    }

    @Override
    public void organiser() {
        Element[] oldTab = tab;
        this.tab = (Element[]) new Object[tab.length * 2];
        
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
