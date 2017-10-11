/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 * @author Pedro Luis Hurtado González e Isidora Reina Molina
 */
public class Treasure implements Card {
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    public Treasure (String n, int g, int min, int max, TreasureKind t){
        this.name = n;
        this.goldCoins = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
    }
    
    
    public String getName(){
        return this.name;
    }
    
    public int getGoldCoins(){
        return this.goldCoins;
    }
    
    public int getMinBonus(){
        return this.minBonus;
    }
    
    public int getMaxBonus(){
        return this.maxBonus;
    }
    
    public TreasureKind getType(){
        return this.type;
    }
    
    public String toString(){
        return this.name;
    }

    @Override
    public int getBasicValue() {
        return this.getMinBonus();
    }

    @Override
    public int getSpecialValue() {
        return this.getMaxBonus();
    }

}
