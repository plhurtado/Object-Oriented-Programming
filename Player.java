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
public class Player {

    private boolean death;
    private String name;
    private int level;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence = new BadConsequence("", false);

    public String getName() {
        return name;
    }

    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }
    
    public Player(String name1) {
        name = name1;
        death = true;
        level = 1;
    }
    
    public Player(Player p){
        this.name = p.name;
        this.death= p.death;
        this.level= p.level;
        this.hiddenTreasures= p.hiddenTreasures;
        this.visibleTreasures= p.visibleTreasures;
        this.pendingBadConsequence= p.pendingBadConsequence;
    }

    private void bringToLive() {
        death = false;
    }


    public int getCombatLevel() {
        boolean collar = false;
        int bonus = 0;
        for (int i = 0; i < visibleTreasures.size() && !collar; i++) {
            TreasureKind tipo;
            tipo = visibleTreasures.get(i).getType();
            if (tipo == TreasureKind.NECKLACE) {
                collar = true;
            }
        }
        if (collar) {
            for (int j = 0; j < visibleTreasures.size(); j++) {
                bonus = bonus + visibleTreasures.get(j).getMaxBonus();
            }
        } else {
            for (int k = 0; k < visibleTreasures.size(); k++) {
                bonus = bonus + visibleTreasures.get(k).getMinBonus();
            }
        }
        bonus = bonus + level;

        return bonus;
    }

    public void setName(String name1) {
        name = name1;
    }

    private void incrementLevels(int l) {
        if (level + l >= 10) {
            level = 10;
        } else {
            level += l;
        }
    }

    private void decrementLevels(int l) {
        if (level - l <= 0) {
            level = 1;
        } else {
            level -= l;
        }
    }

    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = new BadConsequence (b);
    }

    private void dieIfNoTreasures() {
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()) {
            death = true;
        }
    }

    private void discardNecklaceIfVisible() {
        for (int i = 0; i < visibleTreasures.size(); i++) {
            if (visibleTreasures.get(i).getType() == TreasureKind.NECKLACE) {
                CardDealer c = CardDealer.getInstance();
                c.giveTreasureBack(visibleTreasures.get(i));
                visibleTreasures.remove(i);
            }
        }
    }

    private void die() {
        level = 1;
        CardDealer dealer = CardDealer.getInstance();

        for (int i = 0; i < visibleTreasures.size(); i++) {
            dealer.giveTreasureBack(visibleTreasures.get(i));
        }

        visibleTreasures.clear();

        for (int i = 0; i < hiddenTreasures.size(); i++) {
            dealer.giveTreasureBack(hiddenTreasures.get(i));
        }

        hiddenTreasures.clear();

        dieIfNoTreasures();
    }

    protected float computeGoldCoinsValue(ArrayList<Treasure> t) {
        int oro = 0;
        float levels;

        for (int i = 0; i < t.size(); i++) {
            oro += t.get(i).getGoldCoins();
        }

        levels = oro / 1000;
        return levels;
    }

    private boolean canIBuyLevels(int l) {
        return (level + l < 10);
    }

    private void applyPrize(Monster currentMonster) {
        int nLevels = currentMonster.getLevelsGained();
        incrementLevels(nLevels);
        CardDealer dealer = null;
        int nTreasures = currentMonster.getTreasuresGained();

        if (nTreasures > 0) {
            dealer = CardDealer.getInstance();
        }
        for (int i = 0; i < nTreasures; i++) {
            hiddenTreasures.add(dealer.nextTreasure());
        }
    }

    private void applyBadConsequence(BadConsequence bad) {
        decrementLevels(bad.getLevels());
        BadConsequence pending= bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pending);
    }

  
    private boolean canMakeTreasureVisible(Treasure t) {
        int one= howManyVisibleTreasures(TreasureKind.ONEHAND);
        int both= howManyVisibleTreasures(TreasureKind.BOTHHAND);
        
        if (visibleTreasures.isEmpty())
            return true;
        else if (t.getType() == TreasureKind.ONEHAND){
             if (one>1 || both!=0)
                return false;
            else
                return true;
        }
        else  if (t.getType() == TreasureKind.BOTHHAND && ( one!=0 || both!=0) ) {
            return false;
        }
        else{
            for (int i = 0; i < visibleTreasures.size(); i++) {
                if (visibleTreasures.get(i).getType() == t.getType()) {
                    return false;
                }
            }
        }
        return true;
    }

    private int howManyVisibleTreasures(TreasureKind tKind) {
        int cont = 0;
        for (int i = 0; i < visibleTreasures.size(); i++) {
            if (visibleTreasures.get(i).getType() == tKind) {
                cont++;
            }
        }
        return cont;
    }

    public boolean isDead() {
        return death;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    public CombatResult combat(Monster m) {
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        CombatResult salida;

        if (myLevel > monsterLevel) {
            applyPrize(m);
            if (this.level >= 10) {
                salida = CombatResult.WinAndWinGame;
            } else {
                salida = CombatResult.Win;
            }
        } else {
            Dice dice = Dice.getInstance();
            int escape = dice.nextNumber();

            if (escape < 5) {
                boolean amIDead = m.kills();

                if (amIDead) {
                    die();
                    salida = CombatResult.LoseAndDie;
                } else {
                    if(shouldConvert())
                        salida= CombatResult.LoseAndConvert;
                    else
                        salida = CombatResult.Lose;
                    
                    applyBadConsequence(m.getBadConsequence());
                }
            } else {
                salida = CombatResult.LoseAndEscape;
            }
        }

        discardNecklaceIfVisible();

        return salida;
    }

    public void makeTreasureVisible(Treasure t) {
        boolean canI;
        canI = this.canMakeTreasureVisible(t);
        if (canI) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);

        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }

        dieIfNoTreasures();
    }

    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);

        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractHiddenTreasure(t);
        }

        dieIfNoTreasures();
    }

    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        float levelsMayBought = this.computeGoldCoinsValue(visible);
        levelsMayBought += this.computeGoldCoinsValue(hidden);
        int levels = (int) levelsMayBought;
        boolean canI = this.canIBuyLevels(levels);
        if (canI) {
            this.incrementLevels(levels);
        }
        else
            level = 9;
        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        CardDealer dealer = CardDealer.getInstance();
        visible.stream().forEach((v) -> {
            dealer.giveTreasureBack(v);
        });
        hidden.stream().forEach((h) -> {
            dealer.giveTreasureBack(h);
        });
        return canI;
    }

    public boolean validState() {
        return (pendingBadConsequence.isEmpty() && hiddenTreasures.size() < 5);
    }

    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLive();
        hiddenTreasures.add(dealer.nextTreasure());
        int number = dice.nextNumber();

        if (number > 1) {
            hiddenTreasures.add(dealer.nextTreasure());
        }
        if (number == 6) {
            hiddenTreasures.add(dealer.nextTreasure());
        }
    }

    public boolean hasVisibleTreasures() {
        return (visibleTreasures.size() > 0);
    }

    public int getLevels() {
        return level;
    }

    @Override
    public String toString() {
        return name;
    }

    protected int getOponentLevel(Monster m){
        return m.getBasicValue();
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        int dado = dice.nextNumber();
        if(dado == 6) return  true;
        else return false;
    }

}
