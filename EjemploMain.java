
package napakalaki;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

public class EjemploMain {

    public static void main(String[] args) {
      ArrayList <String> names = new ArrayList();
        
      Napakalaki napakalakiModel = Napakalaki.getInstance();
      NapakalakiView napakalakiView = new NapakalakiView();
      Dice.createInstance(napakalakiView);

      PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
      
      names=namesCapture.getNames();
      napakalakiModel.initGame(names);
      napakalakiView.setNapakalaki(napakalakiModel);

      napakalakiView.showView();
      
      // Poner el numero de jugadores con el que se quiera probar
              
    }
}