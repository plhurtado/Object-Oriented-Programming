/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author isi
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard= c;
        totalCultistPlayers++;
    }

    public Cultist getMyCultistCard() {
        return myCultistCard;
    }
    
    @Override
    public int getCombatLevel(){
        return (super.getCombatLevel()+myCultistCard.getSpecialValue());
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    
    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        int oro = 0;
        float levels;

        for (int i = 0; i < t.size(); i++) {
            oro += t.get(i).getGoldCoins();
        }

        levels = (oro*2) / 1000; //Duplicamos el oro por cada pieza
        return levels;
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}
