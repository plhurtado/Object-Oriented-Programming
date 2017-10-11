/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 * @author Pedro Luis Hurtado González e Isidora Reina Molina
 */
public class Monster implements Card {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster (String name, int level, BadConsequence bc, Prize price){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.prize = price;
    }
    
    public Monster (String name, int level, BadConsequence bc, Prize price, int levelCultis){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.prize = price;
        this.levelChangeAgainstCultistPlayer= levelCultis;
    }

    public int getLevelChangeAgainstCultistPlayer() {
        return levelChangeAgainstCultistPlayer;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getCombatLevel(){
        return this.combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return this.bc;
    }
    
    public Prize getPrize(){
        return this.prize;
    }
    
    public boolean kills(){
        return (bc.myBadConsequenceIsDeath());
    }
    
    public int getLevelsGained(){
        return this.prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return this.prize.getTreasures();
    }
    
    @Override
    public String toString(){
        return  name + " | nivel: " + Integer.toString(combatLevel) + " \n" 
                + prize.toString() + " \n" 
                + bc.toString();
    }
    
    @Override
    public int getBasicValue(){
        return getCombatLevel();
    }
    
    @Override
    public int getSpecialValue(){
        return (getCombatLevel()+ levelChangeAgainstCultistPlayer);
    }
    
}
