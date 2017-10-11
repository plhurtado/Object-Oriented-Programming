/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author isi y pedro
 */
public class Cultist implements Card{
    
    private String name;
    private int gainedLevels;
    
    public Cultist (String name, int levels){
        this.name= name;
        this.gainedLevels= levels;
    }

    public String getName() {
        return name;
    }

    public int getGainedLevels() {
        return gainedLevels;
    }

    @Override
    public int getBasicValue() {
        return gainedLevels;
    }

    @Override
    public int getSpecialValue() {
        return (getBasicValue()*CultistPlayer.getTotalCultistPlayers());
    }
}
