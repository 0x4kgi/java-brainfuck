
package application;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;

public class InterpreterGui extends javax.swing.JFrame {
    private final Interpreter i = new Interpreter(5);
    private InterpreterThread interp;

    public InterpreterGui() {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width/2)-(this.getSize().width/2), (dim.height/2)-(this.getSize().height/2));
        
        i.setComponents(listMemoryTape, textInput, textOutput, textUserInput);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBitSize = new javax.swing.ButtonGroup();
        groupWrapCheckboxes = new javax.swing.ButtonGroup();
        listMemoryTape = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        textOutput = new javax.swing.JTextArea();
        buttonExceute = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textInput = new javax.swing.JTextArea();
        labelStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textUserInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        panelWrapping = new javax.swing.JPanel();
        checkUseNegatives = new javax.swing.JCheckBox();
        checkDoWrapping = new javax.swing.JCheckBox();
        panelCellSize = new javax.swing.JPanel();
        radio_8bit = new javax.swing.JRadioButton();
        radio_16bit = new javax.swing.JRadioButton();
        radio_32bit = new javax.swing.JRadioButton();
        radio_4bit = new javax.swing.JRadioButton();
        panelDelay = new javax.swing.JPanel();
        sliderDelay = new javax.swing.JSlider();
        labelDelayDisplay = new javax.swing.JLabel();
        checkNoDelay = new javax.swing.JCheckBox();
        buttonStop = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interpreter");
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(920, 570));

        listMemoryTape.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listMemoryTape.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        listMemoryTape.setName(""); // NOI18N

        textOutput.setColumns(20);
        textOutput.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        textOutput.setRows(5);
        textOutput.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        textOutput.setSelectionColor(new java.awt.Color(153, 255, 255));
        jScrollPane1.setViewportView(textOutput);

        buttonExceute.setText("Execute");
        buttonExceute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExceuteActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.setEnabled(false);
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        textInput.setColumns(20);
        textInput.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textInput.setLineWrap(true);
        textInput.setRows(5);
        textInput.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        textInput.setSelectionColor(new java.awt.Color(153, 255, 255));
        jScrollPane2.setViewportView(textInput);

        labelStatus.setText("...");

        jLabel1.setText("Code:");

        jLabel2.setText("Output:");

        jLabel3.setText("Input: [one character = one input]");

        textUserInput.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jLabel4.setText("Memory:");

        panelWrapping.setBorder(javax.swing.BorderFactory.createTitledBorder("Wrapping"));

        groupWrapCheckboxes.add(checkUseNegatives);
        checkUseNegatives.setText("Use negatives");

        groupWrapCheckboxes.add(checkDoWrapping);
        checkDoWrapping.setText("No wrapping");

        javax.swing.GroupLayout panelWrappingLayout = new javax.swing.GroupLayout(panelWrapping);
        panelWrapping.setLayout(panelWrappingLayout);
        panelWrappingLayout.setHorizontalGroup(
            panelWrappingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrappingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWrappingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkUseNegatives)
                    .addComponent(checkDoWrapping))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        panelWrappingLayout.setVerticalGroup(
            panelWrappingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrappingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkUseNegatives)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkDoWrapping)
                .addContainerGap())
        );

        panelCellSize.setBorder(javax.swing.BorderFactory.createTitledBorder("Cell size"));

        groupBitSize.add(radio_8bit);
        radio_8bit.setSelected(true);
        radio_8bit.setText("8 bits");

        groupBitSize.add(radio_16bit);
        radio_16bit.setText("16 bits");

        groupBitSize.add(radio_32bit);
        radio_32bit.setText("32 bits");

        groupBitSize.add(radio_4bit);
        radio_4bit.setText("4 bits");

        javax.swing.GroupLayout panelCellSizeLayout = new javax.swing.GroupLayout(panelCellSize);
        panelCellSize.setLayout(panelCellSizeLayout);
        panelCellSizeLayout.setHorizontalGroup(
            panelCellSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCellSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCellSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCellSizeLayout.createSequentialGroup()
                        .addGroup(panelCellSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio_16bit)
                            .addComponent(radio_8bit))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCellSizeLayout.createSequentialGroup()
                        .addGroup(panelCellSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio_4bit)
                            .addComponent(radio_32bit))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelCellSizeLayout.setVerticalGroup(
            panelCellSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCellSizeLayout.createSequentialGroup()
                .addComponent(radio_4bit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radio_8bit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_16bit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_32bit)
                .addGap(10, 10, 10))
        );

        panelDelay.setBorder(javax.swing.BorderFactory.createTitledBorder("Delay"));

        sliderDelay.setMajorTickSpacing(100);
        sliderDelay.setMaximum(1000);
        sliderDelay.setMinorTickSpacing(50);
        sliderDelay.setValue(0);
        sliderDelay.setEnabled(false);
        sliderDelay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderDelayStateChanged(evt);
            }
        });

        labelDelayDisplay.setText("0ms");

        checkNoDelay.setSelected(true);
        checkNoDelay.setText("No Delay");
        checkNoDelay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNoDelayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDelayLayout = new javax.swing.GroupLayout(panelDelay);
        panelDelay.setLayout(panelDelayLayout);
        panelDelayLayout.setHorizontalGroup(
            panelDelayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDelayLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(labelDelayDisplay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelDelayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDelayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDelayLayout.createSequentialGroup()
                        .addComponent(checkNoDelay)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sliderDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDelayLayout.setVerticalGroup(
            panelDelayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDelayLayout.createSequentialGroup()
                .addComponent(labelDelayDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkNoDelay)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        buttonStop.setText("Stop");
        buttonStop.setEnabled(false);
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                                .addComponent(buttonReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonExceute))
                            .addComponent(textUserInput)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listMemoryTape, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelDelay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelCellSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelWrapping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonExceute, buttonReset, buttonStop});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelWrapping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCellSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonExceute)
                                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listMemoryTape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addGap(4, 4, 4))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonExceute, buttonReset, buttonStop});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExceuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExceuteActionPerformed
        reset();

        setSettings();       
        
        i.setCode(textInput.getText());
        i.setInput(textUserInput.getText());        
        
        buttonExceute.setEnabled(false);
        buttonStop.setEnabled(true);
        
        labelStatus.setText("Running...");
        interp = new InterpreterThread();        
        interp.start();           
    }//GEN-LAST:event_buttonExceuteActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        reset();
        interp = null;
        buttonExceute.setEnabled(true);
        buttonReset.setEnabled(false);
        buttonStop.setEnabled(false);
    }//GEN-LAST:event_buttonResetActionPerformed

    private void sliderDelayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderDelayStateChanged
        labelDelayDisplay.setText(String.valueOf(sliderDelay.getValue()) + "ms");
        i.setDelay(sliderDelay.getValue());      
    }//GEN-LAST:event_sliderDelayStateChanged

    private void checkNoDelayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNoDelayActionPerformed
        if(checkNoDelay.isSelected()) {
            sliderDelay.setEnabled(false);
            sliderDelay.setValue(0);
        } else {
            sliderDelay.setEnabled(true);
            sliderDelay.setValue(100);
        }
    }//GEN-LAST:event_checkNoDelayActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        i.stop();
        interp = null;
        labelStatus.setText("Stopped.");
        
        buttonExceute.setEnabled(true);
        buttonReset.setEnabled(true);
        buttonStop.setEnabled(false);
    }//GEN-LAST:event_buttonStopActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(InterpreterGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterpreterGui().setVisible(true);
        });
    }
    
    public class InterpreterThread extends Thread {
        @Override
        public void run() {
            try {
                i.start();
            } catch (BadLocationException ex) {
                Logger.getLogger(InterpreterGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //misc functions
    private void reset() {        
        listMemoryTape.removeAll();
        listMemoryTape.add(0 + "");
        listMemoryTape.select(0);


        textOutput.setText("");
        labelStatus.setText("...");
    }

//    private void gatherStatistics() {
//        labelStatus.setText(String.format(""));
//        
//        buttonExceute.setEnabled(true);
//        buttonStop.setEnabled(false);
//    }

    private void setSettings() {
        int power = 1;
        int delay = sliderDelay.getValue();
        boolean usingNegatives = checkUseNegatives.isSelected();
        boolean usingWrapping = !checkDoWrapping.isSelected();

        if(radio_4bit.isSelected()) power = 4;
        else if(radio_8bit.isSelected()) power = 8;
        else if(radio_16bit.isSelected()) power = 16;
        else if(radio_32bit.isSelected()) power = 32;

        int maxCellSize = (int) Math.pow(2, power);        
        
        i.setSettings(usingNegatives, usingWrapping, maxCellSize);
        i.setDelay(delay);
    }
    //end of misc functions

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExceute;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonStop;
    private javax.swing.JCheckBox checkDoWrapping;
    private javax.swing.JCheckBox checkNoDelay;
    private javax.swing.JCheckBox checkUseNegatives;
    private javax.swing.ButtonGroup groupBitSize;
    private javax.swing.ButtonGroup groupWrapCheckboxes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDelayDisplay;
    private javax.swing.JLabel labelStatus;
    private java.awt.List listMemoryTape;
    private javax.swing.JPanel panelCellSize;
    private javax.swing.JPanel panelDelay;
    private javax.swing.JPanel panelWrapping;
    private javax.swing.JRadioButton radio_16bit;
    private javax.swing.JRadioButton radio_32bit;
    private javax.swing.JRadioButton radio_4bit;
    private javax.swing.JRadioButton radio_8bit;
    private javax.swing.JSlider sliderDelay;
    private javax.swing.JTextArea textInput;
    private javax.swing.JTextArea textOutput;
    private javax.swing.JTextField textUserInput;
    // End of variables declaration//GEN-END:variables

}