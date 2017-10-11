/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.swing.JOptionPane;
import napakalaki.CombatResult;
import napakalaki.Napakalaki;
/**
 *
 * @author plhurtado
 */
public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;
    //TENEMOS DUDAS*********************************
    public void setNapakalaki(Napakalaki p){
        napakalakiModel=p;
        player.setNapakalaki(p);
        player.setPlayer(napakalakiModel.getCurrentPlayer());
        repaint();
    }
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combatResultText = new javax.swing.JLabel();
        combatResult = new javax.swing.JTextField();
        showmonster = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();
        player = new GUI.PlayerView();
        monster = new GUI.MonsterView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(237, 237, 237));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        combatResultText.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        combatResultText.setForeground(new java.awt.Color(1, 1, 1));
        combatResultText.setText("Resultado Combate:");

        combatResult.setEditable(false);
        combatResult.setBackground(new java.awt.Color(237, 237, 237));
        combatResult.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        combatResult.setForeground(java.awt.Color.red);

        showmonster.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        showmonster.setText("Mostrar Monstruo");
        showmonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showmonsterActionPerformed(evt);
            }
        });

        combat.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        combat.setText("Combatir");
        combat.setEnabled(false);
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        nextTurn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nextTurn.setText("Siguiente Turno");
        nextTurn.setEnabled(false);
        nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combatResultText)
                    .addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(combatResult, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(showmonster)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combat)
                                .addGap(68, 68, 68)))
                        .addComponent(nextTurn))
                    .addComponent(monster, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showmonster)
                            .addComponent(combat)
                            .addComponent(nextTurn))
                        .addGap(31, 31, 31)
                        .addComponent(monster, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combatResultText)
                    .addComponent(combatResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        // TODO add your handling code here:
        if(player.valido() == false)
            JOptionPane.showMessageDialog(null, napakalakiModel.getCurrentPlayer().getName() + ": Debes cumplir el mal royo");
        else{
            nextTurn.setEnabled(false);
            player.setPendingBD("");
            napakalakiModel.nextTurn();
            monster.setVisible(false);
            combatResult.setText("");
            combat.setEnabled(false);
            player.habilitarcompra();
            showmonster.setEnabled(true);
            setNapakalaki(napakalakiModel);
        }
    }//GEN-LAST:event_nextTurnActionPerformed

    private void showmonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showmonsterActionPerformed
        combat.setEnabled(true);
        showmonster.setEnabled(false);
        nextTurn.setEnabled(false);
        monster.setVisible(true);
        monster.setMonster(napakalakiModel.getCurrentMonster());
        player.deshabilitar();
        combat.setEnabled(true);
        setNapakalaki(napakalakiModel);
    }//GEN-LAST:event_showmonsterActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        combat.setEnabled(false);
        CombatResult result = napakalakiModel.developCombat();
        combatResult.setText(result.toString());
        nextTurn.setEnabled(true);
        player.habilitarvisible();
        if (result == CombatResult.Lose){
            player.setPendingBD(monster.getMalRollo());    
        }
        else if (result == CombatResult.WinAndWinGame) {
            JOptionPane.showMessageDialog(null, napakalakiModel.getCurrentPlayer().getName() + " HA GANADO");
            System.exit(0);
        }
        setNapakalaki(napakalakiModel);
    }//GEN-LAST:event_combatActionPerformed

    /**
     * @param args the command line arguments
     */
    public void showView(){
       setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private javax.swing.JTextField combatResult;
    private javax.swing.JLabel combatResultText;
    private GUI.MonsterView monster;
    private javax.swing.JButton nextTurn;
    private GUI.PlayerView player;
    private javax.swing.JButton showmonster;
    // End of variables declaration//GEN-END:variables
}