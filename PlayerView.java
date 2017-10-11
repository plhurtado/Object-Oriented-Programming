/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import napakalaki.Napakalaki;
import napakalaki.Player;
import napakalaki.Treasure;

/**
 *
 * @author plhurtado
 */
public class PlayerView extends javax.swing.JPanel {

    /**
     * Creates new form PlayerView
     */
    private Player playerModel;
    private Napakalaki napakalakiModel;
    
    void setNapakalaki(Napakalaki pasado){
        napakalakiModel = pasado;
    }
    
    public PlayerView() {
        initComponents();
    }
    public void setPlayer(Player p){
        playerModel = p;
        cultist.setCultist(playerModel);
        name.setText(playerModel.getName());
        level.setText(Integer.toString(playerModel.getLevels()));
        combat_level.setText(Integer.toString(playerModel.getCombatLevel()));
        death.setText(Boolean.toString(playerModel.isDead()));
        fillTreasurePanel(visible, playerModel.getVisibleTreasures());
        fillTreasurePanel(hidden, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }
    
    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList){
        aPanel.removeAll();
        for (Treasure t : aList){
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
        aPanel.repaint();
        aPanel.revalidate();
    }
    
public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
    // Se recorren los tesoros que contiene el panel,
    // almacenando en un vector aquellos que están seleccionados.
    // Finalmente se devuelve dicho vector.
    TreasureView tv;
    ArrayList<Treasure> output = new ArrayList();
    for (Component c : aPanel.getComponents()) {
        tv = (TreasureView) c;
        if ( tv.isSelected() )
        output.add ( tv.getTreasure() );
    }
    return output;
}

public void setPendingBD(String malRollo){
    pendingBD.setText(malRollo);
}

public void deshabilitar(){
    makeVisible.setEnabled(false);
    buyLevel.setEnabled(false);
}

public void habilitarvisible(){
    makeVisible.setEnabled(true);
}
public void habilitarcompra(){
    buyLevel.setEnabled(true);
}

public boolean valido(){
    return playerModel.validState();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        level = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        death = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pendingBD = new javax.swing.JTextField();
        buyLevel = new javax.swing.JButton();
        makeVisible = new javax.swing.JButton();
        discard = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        visible = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hidden = new javax.swing.JPanel();
        cultist = new GUI.CultistView();
        jLabel7 = new javax.swing.JLabel();
        combat_level = new javax.swing.JTextField();

        setBackground(new java.awt.Color(237, 237, 237));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador"));
        setForeground(java.awt.Color.red);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Nombre");

        name.setEditable(false);
        name.setBackground(new java.awt.Color(237, 237, 237));
        name.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        name.setForeground(java.awt.Color.red);
        name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Nivel:");

        level.setEditable(false);
        level.setBackground(new java.awt.Color(237, 237, 237));
        level.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        level.setForeground(java.awt.Color.red);
        level.setText("1");
        level.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Muerte:");

        death.setEditable(false);
        death.setBackground(new java.awt.Color(237, 237, 237));
        death.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        death.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("T.Visibles");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("T.Ocultos");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Mal Rollo");

        pendingBD.setEditable(false);
        pendingBD.setBackground(new java.awt.Color(237, 237, 237));
        pendingBD.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        pendingBD.setBorder(null);

        buyLevel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        buyLevel.setText("Comprar nivel");
        buyLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyLevelActionPerformed(evt);
            }
        });

        makeVisible.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        makeVisible.setText("Hacer Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discard.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        discard.setText("Descartar");
        discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardActionPerformed(evt);
            }
        });

        visible.setBackground(new java.awt.Color(237, 237, 237));
        jScrollPane1.setViewportView(visible);

        hidden.setBackground(new java.awt.Color(237, 237, 237));
        jScrollPane2.setViewportView(hidden);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("Nivel Combate:");

        combat_level.setEditable(false);
        combat_level.setBackground(new java.awt.Color(237, 237, 237));
        combat_level.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        combat_level.setForeground(java.awt.Color.red);
        combat_level.setText("1");
        combat_level.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buyLevel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(makeVisible)
                                    .addGap(18, 18, 18)
                                    .addComponent(discard))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(19, 19, 19)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cultist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pendingBD, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combat_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(death, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(death, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(combat_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pendingBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyLevel)
                            .addComponent(makeVisible)
                            .addComponent(discard)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel4)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cultist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hidden);
        if(!selHidden.isEmpty()){
            napakalakiModel.makeTreasuresVisible (selHidden);
            setPlayer (napakalakiModel.getCurrentPlayer());
        }
        repaint();
    }//GEN-LAST:event_makeVisibleActionPerformed
    
    private void buyLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyLevelActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hidden);
        ArrayList<Treasure> selVisible = getSelectedTreasures (visible);
        
        napakalakiModel.buyLevels(selVisible, selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());
        repaint();
        
    }//GEN-LAST:event_buyLevelActionPerformed

    private void discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hidden);
        ArrayList<Treasure> selVisible = getSelectedTreasures (visible);
        
        if(!selHidden.isEmpty())
            napakalakiModel.discardHiddenTreasures(selHidden);
        if(!selVisible.isEmpty())
            napakalakiModel.discardVisibleTreasures(selVisible);

        setPlayer (napakalakiModel.getCurrentPlayer());
        repaint();        
    }//GEN-LAST:event_discardActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyLevel;
    private javax.swing.JTextField combat_level;
    private GUI.CultistView cultist;
    private javax.swing.JTextField death;
    private javax.swing.JButton discard;
    private javax.swing.JPanel hidden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField level;
    private javax.swing.JButton makeVisible;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pendingBD;
    private javax.swing.JPanel visible;
    // End of variables declaration//GEN-END:variables
}