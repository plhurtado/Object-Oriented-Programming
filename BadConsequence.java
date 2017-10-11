/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 * @author Pedro Luis Hurtado González e Isidora Reina Molina
 */
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence (BadConsequence b){
        this.text = b.getText();
        this.levels = b.getLevels();
        this.nVisibleTreasures = b.getNVisibleTreasures();
        this.nHiddenTreasures = b.getNHiddenTreasures();
        this.death = b.getDeath();
        this.specificVisibleTreasures = new ArrayList <TreasureKind> (b.getSpecificVisibleTreasures());
        this.specificHiddenTreasures = new ArrayList <TreasureKind> (b.getSpecificHiddenTreasures());     
    }
    
    public BadConsequence (String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public BadConsequence (String text, boolean death){
        this.text = text;
        this.death = death;
    }
    
    public BadConsequence (String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    
    public String getText(){
        return this.text;
    }
    
    public int getLevels(){
        return this.levels;
    }
    
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return this.death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public boolean emptyVisible(){
        return this.specificVisibleTreasures.isEmpty();
    }
    
    public boolean emptyHidden(){
        return this.specificHiddenTreasures.isEmpty();
    }
    
    public boolean isEmpty(){
        return (emptyHidden() && emptyVisible() && nHiddenTreasures == 0 && nVisibleTreasures == 0);            
    }
    
    public boolean myBadConsequenceIsDeath(){
        if (this.death)
            return true;
        else
            return false;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence ajustado;
        int nvisible = 0;
        int nhidden = 0;
        
        if (nHiddenTreasures>0 || nVisibleTreasures>0){
            if (nVisibleTreasures>0){
                if (nVisibleTreasures > v.size())
                    nvisible = v.size();
                else
                    nvisible = nVisibleTreasures;
            }
            if (nHiddenTreasures>0){
                if (this.nHiddenTreasures > h.size())
                    nhidden = h.size();
                else
                    nhidden = nHiddenTreasures;
            }
            ajustado = new BadConsequence (text, levels, nvisible, nhidden);
            
        }
        else if (death){
            ajustado = new BadConsequence (text, death);
        }
        else{  
            ArrayList<TreasureKind> visibles = new ArrayList();
            ArrayList<TreasureKind> ocultos = new ArrayList();

            for (int i = 0; i < specificVisibleTreasures.size(); i++) {
                if (specificVisibleTreasures.get(i) == TreasureKind.ONEHAND && specificVisibleTreasures.size() > 1 && i == 0 && specificVisibleTreasures.get(i) == specificVisibleTreasures.get(i+1)){
                    for (int j = 0; j < v.size(); j++) {
                        if (specificVisibleTreasures.get(i) == v.get(j).getType()){
                            visibles.add(specificVisibleTreasures.get(i));
                        }
                    } 
                    i++;
                }
                else{
                    for (int j = 0; j < v.size(); j++) {
                        if (specificVisibleTreasures.get(i) == v.get(j).getType()){
                            visibles.add(specificVisibleTreasures.get(i));
                            j= v.size();
                        }
                    } 
                }
            }

            for (int i = 0; i < specificHiddenTreasures.size(); i++) {
                if (specificHiddenTreasures.get(i) == TreasureKind.ONEHAND && specificHiddenTreasures.size() > 1 && i == 0 && specificHiddenTreasures.get(i) == specificHiddenTreasures.get(i+1)){
                    for (int j = 0; j < v.size(); j++) {
                        if (specificHiddenTreasures.get(i) == v.get(j).getType()){
                            visibles.add(specificHiddenTreasures.get(i));
                        }
                    } 
                    i++;
                }
                else{
                    for (int j = 0; j < h.size(); j++) {
                        if (specificHiddenTreasures.get(i) == h.get(j).getType()){
                            ocultos.add(specificHiddenTreasures.get(i));
                            j= h.size();
                        }
                    }
                }
            }
            ajustado = new BadConsequence(text, levels, visibles, ocultos);
        }
        return ajustado;
    }
    
   
    public void substractVisibleTreasure(Treasure t){
        if (nVisibleTreasures!=0)
            nVisibleTreasures--;
        specificVisibleTreasures.remove(t.getType());
    }
    
    public void substractHiddenTreasure(Treasure t){
        if (nHiddenTreasures!=0)
            nHiddenTreasures--;
        specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public String toString(){
        return "Mal royo a cumplir: " + this.text 
                + " pierdes:  " + Integer.toString(this.levels) 
                + " niveles, nº tesoros visibles: " + Integer.toString(nVisibleTreasures) 
                + " = " + specificVisibleTreasures 
                + " nº tesoros invisibles: " + Integer.toString(nHiddenTreasures) 
                + " = " + specificHiddenTreasures
                + " estas muerto?: " + death;
    }
    

}
