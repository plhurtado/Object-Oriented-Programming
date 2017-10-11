/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Pedro Luis Hurtado González e Isidora Reina Molina
 */
public class Napakalaki {
    
    private Napakalaki() {
    }

    private static final Napakalaki instance = new Napakalaki();
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList();
    private CardDealer dealer = CardDealer.getInstance();
    private Monster currentMonster;
    
    private void initPlayers(ArrayList<String> names){
        for (int i=0; i<names.size(); i++){
            Player insertar = new Player (names.get(i));
            players.add(insertar);
        }
    }
    
    private Player nextPlayer(){
        if (currentPlayer==null){
            Random posicion = new Random();
            int valor = posicion.nextInt(players.size());
            currentPlayer = players.get(valor);
        }
        else{
            if (currentPlayer == players.get(players.size()-1)){
                currentPlayer = players.get(0);
            }
            else{
                int posicion= players.indexOf(currentPlayer)+1;
                currentPlayer = players.get(posicion);
            }   
        }
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        if (currentPlayer==null){
            nextPlayer();
        }
            return currentPlayer.validState();
    }
        
    public static Napakalaki getInstance() {
        return Napakalaki.instance;
    }
    
    public CombatResult developCombat(){
        CombatResult combate;
        combate = currentPlayer.combat(currentMonster);
        if(combate == CombatResult.LoseAndConvert){
            CultistPlayer cplayer= new CultistPlayer(currentPlayer,dealer.nextCultist());
            players.set(players.indexOf(currentPlayer), cplayer);
            currentPlayer= cplayer;
        }
        dealer.giveMonsterBack(currentMonster);
        return combate;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for (Treasure t: treasures){
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void discardHiddenTreasures (ArrayList<Treasure> treasures){
        for (Treasure t: treasures){
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void makeTreasuresVisible (ArrayList<Treasure> treasures){
         for (Treasure t : treasures) {
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public boolean buyLevels (ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        boolean canI;
        canI= currentPlayer.buyLevels(visible, hidden);
        return canI;
    }
    
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        if (stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            if (currentPlayer.isDead())
                currentPlayer.initTreasures();

        }
        return stateOK;
    }
    
    public boolean endOfGame (CombatResult result){
        return (result == CombatResult.WinAndWinGame);                   
    }
   
}
