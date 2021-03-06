package com.github.sunnybat.paxchecker.setup;

import com.github.sunnybat.commoncode.email.smtp.EmailAddress;

/**
 *
 * @author Sunnybat
 */
public class ExtraPhonePanel extends javax.swing.JPanel {

  private final SetupGUI mainSetupPanel;

  /**
   * Creates new form ExtraPhonePanel
   *
   * @param mSP
   */
  public ExtraPhonePanel(SetupGUI mSP) {
    initComponents();
    mainSetupPanel = mSP;
  }

  public ExtraPhonePanel(SetupGUI mSP, String numberCarrier) {
    initComponents();
    mainSetupPanel = mSP;
  }

  /**
   *
   * @param mSP The Setup window this panel is on
   * @param number The cell number to be texted
   * @param carrier The carrier to be texted, or null for AT&T
   */
  public ExtraPhonePanel(SetupGUI mSP, String number, String carrier) {
    initComponents();
    mainSetupPanel = mSP;
    if (carrier != null) {
      jComboBox1.setSelectedIndex(SetupGUI.getIndexOfProvider(EmailAddress.getProvider(carrier)));
      if (EmailAddress.getProvider(carrier).equals("[Other]")) {
        jTextField2.setText(number + "@" + carrier);
      } else {
        jTextField2.setText(number);
      }
      jTextField2.setCaretPosition(0);
    }
  }

  public String getNumber() {
    return jTextField2.getText();
  }

  public String getProvider() {
    return jComboBox1.getSelectedItem().toString();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jComboBox1 = new javax.swing.JComboBox();
    jButton1 = new javax.swing.JButton();

    setPreferredSize(new java.awt.Dimension(391, 26));

    jLabel1.setText("Cell Num");

    jTextField2.setToolTipText("<html>\nSpecify the number you want to receive texts at.<br>\nOnly put your number - no spaces, no leading 1.<br>\nYou may use dashes -- or perentheses ().<br>\nIf you use a different carrier, you may find their<br>\ntexting email address extension at<br>\nwww.emailtextmessages.com and put it onto the<br>\nend of your number.<br>\nExamples:<br>\n(123)-456-7890 [Verizon selected in dropdown box]<br>\n1234567890@car.rier.net<br>\n123-4567890@car.rier.net<br>\n</html>");

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AT&T (MMS)", "AT&T (SMS)", "Verizon", "Sprint", "T-Mobile", "U.S. Cellular", "Bell", "Rogers", "Fido", "Koodo", "Telus", "Virgin (CAN)", "Wind", "Sasktel", "[Other]" }));

    jButton1.setText("X");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButton1))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel1)
        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jButton1))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    mainSetupPanel.removePhonePanel(this);
  }//GEN-LAST:event_jButton1ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JTextField jTextField2;
  // End of variables declaration//GEN-END:variables
}
