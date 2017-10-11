/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Pedro Luis Hurtado González e Isidora Reina Molina
 */
public class CardDealer {
    
    private CardDealer() {
    }
    
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
           
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 800, 1, 1, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de shushi arcano", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr.Tesla", 900, 4, 8, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de tres cañones", 700, 4, 6, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("La fuerta de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE));
        unusedTreasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Necro-playboycón", 300, 3, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Linterna a dos manos", 400, 3, 6, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega", 200, 0, 1, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));  
    }
    
    private void initMonsterCardDeck(){
        BadConsequence badConsequence0 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer "
                + "en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize0 = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence0, prize0));
    
        BadConsequence badConsequence1 = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize1 = new Prize(2,1);
        unusedMonsters.add(new Monster("Byakhees de bonanza", 8, badConsequence1, prize1));
        
        BadConsequence badConsequence2 = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList(Arrays.asList()));
        Prize prize2 = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence2, prize2));
        
        BadConsequence badConsequence3 = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.SHOE)),
                new ArrayList(Arrays.asList()));
        Prize prize3 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence3, prize3));
        
        BadConsequence badConsequence4 = new BadConsequence("Pierdes todos tus tesoros visibles",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ARMOR, TreasureKind.BOTHHAND, TreasureKind.HELMET,
                        TreasureKind.NECKLACE, TreasureKind.SHOE)),
                new ArrayList(Arrays.asList()));
        Prize prize4 = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence4, prize4));
        
        BadConsequence badConsequence5 = new BadConsequence("Pierdes la armadura visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList()));
        Prize prize5 = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence5, prize5));
        
        BadConsequence badConsequence6 = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence6, prize6));
        
        BadConsequence badConsequence7 = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 
                5,
                3,
                0);
        Prize prize7 = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence7, prize7));
        
        BadConsequence badConsequence8 = new BadConsequence("Toses los pulmones y pierdes 2 niveles.",
                2,
                0,
                0);
        Prize prize8 = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence8, prize8));
        
        BadConsequence badConsequence9 = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",
                true);
        Prize prize9 = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence9, prize9));
        
        BadConsequence badConsequence10 = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",
                2,
                0,
                2);
        Prize prize10 = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence10, prize10));
        
        BadConsequence badConsequence11 = new BadConsequence("Te intentas escaquear. Pierdes una mano visible",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize11 = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence11, prize11));
        
        BadConsequence badConsequence12 = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.",
                3,
                0,
                0);
        Prize prize12 = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, badConsequence12, prize12));
        
        BadConsequence badConsequence13 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto",
                true);
        Prize prize13 = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg- Goth", 12, badConsequence13, prize13));
        
        BadConsequence badConsequence14 = new BadConsequence("La familia te atrapa. Estás muerto.",
                true);
        Prize prize14 = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence14, prize14));
        
        BadConsequence badConsequence15 = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
                2,
                new ArrayList(Arrays.asList(TreasureKind.BOTHHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize15 = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence15, prize15));
        
        BadConsequence badConsequence16 = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.",
                0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence16, prize16));
        
        BadConsequence badConsequence17 = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",
                2,
                5,
                0);
        Prize prize17 = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence17, prize17));
        
        BadConsequence badConsequence18 = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
                3,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize18 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence18, prize18));
        
        //Nuevos Monstruos:
        BadConsequence badConsequence19 = new BadConsequence("Pierdes 1 mano visible.",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList()));
        Prize prize19 = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence19, prize19, -2));
        
        BadConsequence badConsequence20 = new BadConsequence("Pierdes tus tesoros visibles. jajaja",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ARMOR, TreasureKind.BOTHHAND, TreasureKind.HELMET,
                        TreasureKind.NECKLACE, TreasureKind.SHOE)),
                new ArrayList(Arrays.asList()));
        Prize prize20 = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence20, prize20, +2));
        
        BadConsequence badConsequence21 = new BadConsequence("Hoy no es tu dia de suerte. Mueres",
                true);
        Prize prize21 = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran Cthulhu", 20, badConsequence21, prize21, +4));
        
        BadConsequence badConsequence22 = new BadConsequence("Tu gobierno te recorta dos niveles",
                2,
                0,
                0);
        Prize prize22 = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, badConsequence22, prize22, -2));
        
        BadConsequence badConsequence23 = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",
                0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR, TreasureKind.HELMET)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHAND)));
        Prize prize23 = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence23, prize23, +5));
        
        
        BadConsequence badConsequence24 = new BadConsequence("Pierdes 2 niveles",
                2,
                0,
                0);
        Prize prize24 = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence24, prize24, -4));
        
        BadConsequence badConsequence25= new BadConsequence("Pintalabios negro. Pierdes dos niveles.",
                2,
                0,
                0);
        Prize prize25 = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence25, prize25, -3));
        
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
       Collections.shuffle(unusedMonsters);
    }
        
    public static CardDealer getInstance() {
        return CardDealer.instance;
    }
    
    public Treasure nextTreasure(){
        Treasure siguienteTesoro;
        int siguiente;
        
        if (!unusedTreasures.isEmpty()){
            siguiente = unusedTreasures.size()-1;
            siguienteTesoro = unusedTreasures.get(siguiente);
            unusedTreasures.remove(siguiente);
            usedTreasures.add(siguienteTesoro);
        }
        else{
            unusedTreasures = new ArrayList (usedTreasures);
            usedTreasures.clear();
            shuffleTreasures();
            siguiente = unusedTreasures.size()-1;
            siguienteTesoro = unusedTreasures.get(siguiente);
            unusedTreasures.remove(siguiente);
            usedTreasures.add(siguienteTesoro);
        }
        
        return siguienteTesoro;    
    }
    
    public Monster nextMonster(){
        Monster siguienteMonstruo;
        int siguiente;
        
        if (!unusedMonsters.isEmpty()){
            siguiente = unusedMonsters.size()-1;
            siguienteMonstruo = unusedMonsters.get(siguiente);
            unusedMonsters.remove(siguiente);
            usedMonsters.add(siguienteMonstruo);
        }
        else{
            unusedMonsters = new ArrayList (usedMonsters);
            usedMonsters.clear();
            shuffleMonsters();
            siguiente = unusedMonsters.size()-1;
            siguienteMonstruo = unusedMonsters.get(siguiente);
            unusedMonsters.remove(siguiente);
            usedMonsters.add(siguienteMonstruo);
        }
        
        return siguienteMonstruo;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        shuffleTreasures();
        initMonsterCardDeck();
        shuffleMonsters();
        initCultistCardDeck();
        shuffleCultists();
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add( new Cultist("Sectario",1));
        unusedCultists.add( new Cultist("Sectario",2));
        unusedCultists.add( new Cultist("Sectario",1));
        unusedCultists.add( new Cultist("Sectario",2));
        unusedCultists.add( new Cultist("Sectario",1));
        unusedCultists.add( new Cultist("Sectario",1));
    }
    
    public Cultist nextCultist(){
        Cultist siguienteCultist;
        int siguiente= unusedCultists.size()-1;
        siguienteCultist = unusedCultists.get(siguiente);
        unusedCultists.remove(siguiente);
        
        return siguienteCultist;
    }
}
