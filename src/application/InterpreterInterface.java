
package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class InterpreterInterface extends javax.swing.JFrame {

    //global variables
    private boolean hasError = false;
    private int memorySize = 1;
    private int pointer = 0;
    private int codePointer = 0;
    private int steps = 0;
    private int inputPointer = 0;

    private String code = "";
    private String input = "";

    private boolean usingNegatives = false;
    private boolean usingWrapping = true;

    private int maxCellSize = 256;
    private int delay = 50;

    private List<Integer> openBracket = new ArrayList<>();
    private List<Integer> closeBracket = new ArrayList<>();
    
    private InterpreterThread interp;
    
    private Highlighter highlighter;

    public InterpreterInterface() {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width/2)-(this.getSize().width/2), (dim.height/2)-(this.getSize().height/2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBitSize = new javax.swing.ButtonGroup();
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
        jPanel1 = new javax.swing.JPanel();
        checkUseNegatives = new javax.swing.JCheckBox();
        checkDoWrapping = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        radio_8bit = new javax.swing.JRadioButton();
        radio_16bit = new javax.swing.JRadioButton();
        radio_32bit = new javax.swing.JRadioButton();
        radio_4bit = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        sliderDelay = new javax.swing.JSlider();
        labelDelayDisplay = new javax.swing.JLabel();
        checkNoDelay = new javax.swing.JCheckBox();
        buttonStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interpreter");
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(725, 434));

        listMemoryTape.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listMemoryTape.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        listMemoryTape.setName(""); // NOI18N

        textOutput.setColumns(20);
        textOutput.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        textOutput.setRows(5);
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
        jScrollPane2.setViewportView(textInput);

        labelStatus.setText("...");

        jLabel1.setText("Code:");

        jLabel2.setText("Output:");

        jLabel3.setText("Input: [one character = one input]");

        textUserInput.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jLabel4.setText("Memory:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Wrapping"));

        checkUseNegatives.setText("Use negatives");

        checkDoWrapping.setText("No wrapping");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkUseNegatives)
                    .addComponent(checkDoWrapping))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkUseNegatives)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addComponent(checkDoWrapping)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cell size"));

        groupBitSize.add(radio_8bit);
        radio_8bit.setSelected(true);
        radio_8bit.setText("8 bits");

        groupBitSize.add(radio_16bit);
        radio_16bit.setText("16 bits");

        groupBitSize.add(radio_32bit);
        radio_32bit.setText("32 bits");

        groupBitSize.add(radio_4bit);
        radio_4bit.setText("4 bits");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio_16bit)
                            .addComponent(radio_8bit))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio_4bit)
                            .addComponent(radio_32bit))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(radio_4bit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radio_8bit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_16bit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_32bit)
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Delay"));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(labelDelayDisplay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(checkNoDelay)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sliderDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
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
                            .addComponent(listMemoryTape, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonExceute)
                                    .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(listMemoryTape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addGap(4, 4, 4))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonExceute, buttonReset, buttonStop});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExceuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExceuteActionPerformed
        reset();

        setSettings();
        
        highlighter = textInput.getHighlighter();
        
        buttonExceute.setEnabled(false);
        buttonStop.setEnabled(true);
        
        labelStatus.setText("Running...");
        interp = new InterpreterThread();        
        interp.start();      
        
        if(!interp.isAlive()) {
            buttonExceute.setEnabled(true);
        }      
    }//GEN-LAST:event_buttonExceuteActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        reset();
        
        buttonExceute.setEnabled(true);
        buttonReset.setEnabled(false);
        buttonStop.setEnabled(false);
    }//GEN-LAST:event_buttonResetActionPerformed

    private void sliderDelayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderDelayStateChanged
        labelDelayDisplay.setText(String.valueOf(sliderDelay.getValue()) + "ms");
        delay = sliderDelay.getValue();
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
        code = "";
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
            java.util.logging.Logger.getLogger(InterpreterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterpreterInterface().setVisible(true);
        });
    }

    //BrainFuck Instructions
    void doInterpret() throws BadLocationException {
        code = textInput.getText();
        input = textUserInput.getText();

        scanForLoops(code);

        while (codePointer < code.length() && !hasError) {
            highlightText(codePointer);
            char s = code.charAt(codePointer);

            switch(s) {
                case '+':
                    inc();
                    break;
                case '-':
                    dec();
                    break;
                case '>':
                    mov(true);
                    break;
                case '<':
                    mov(false);
                    break;
                case '.':
                    output();
                    break;
                case ',':
                    input();
                    break;
                case '[':
                    jmp();
                    break;
                case ']':
                    jmpBck();
                    break;
                default:
                    codePointer += 1;
                    continue;
            } //switch
            codePointer += 1;

            if(delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    sysLog("thread interrupted");
                }
            }

            steps += 1;

            if(Math.abs(Integer.parseInt(listMemoryTape.getItem(pointer))) > maxCellSize) {
                errorMessage("Values too large for current bit size. Limit of " + maxCellSize);
                break;
            }

            if(memorySize > 8192) {
                errorMessage("Consumed too much memory / too much cells. Limit of 8192 cells. Stopped at " + s);
                break;
            }   
            
        }
        
        gatherStatistics();
    }

    void inc() {
        int value;
        try {
           value = Integer.parseInt(listMemoryTape.getItem(pointer));

           value += 1;

           if(usingNegatives) {
               if(usingWrapping) {
                   if(value == (maxCellSize / 2)) value = -(maxCellSize / 2);
               }
           } else {
               if(usingWrapping) {
                   if(value == maxCellSize) value = 0;
               }
           }

           listMemoryTape.replaceItem("" + value, pointer);
        } catch (Exception e) {
            listMemoryTape.add(String.valueOf(1));
        }

        listMemoryTape.select(pointer);
    }

    void dec() {
        int value;
        try {
           value = Integer.parseInt(listMemoryTape.getItem(pointer));

           value -= 1;

           if(usingNegatives) {
               if(usingWrapping) {
                   if(value == -((maxCellSize / 2) + 1)) value = (maxCellSize / 2) - 1;
               }
           } else {
               if(usingWrapping) {
                   if(value == -1) value = maxCellSize - 1;
               }
           }

           listMemoryTape.replaceItem("" + value, pointer);
        } catch (Exception e) {
            listMemoryTape.add(String.valueOf(maxCellSize - 1));
        }

        listMemoryTape.select(pointer);
    }

    void mov(boolean ins) {
        if(ins) { // >
            pointer += 1;

            if (pointer == memorySize) {
                listMemoryTape.add(0 + "");
                memorySize += 1;
            }
        } else { // <
            pointer -= 1;

            if (pointer < 0) {
                listMemoryTape.add(0 + "", 0);
                pointer = 0;
                memorySize += 1;
            }
        }
        if(!hasError) listMemoryTape.select(pointer);
    }

    void output() {
        int value = Integer.parseInt(listMemoryTape.getItem(pointer));
        char ascii = (char) value;

        textOutput.append(String.valueOf(ascii));
    }

    void input() {

        if(inputPointer >= input.length()) {
            listMemoryTape.replaceItem(String.valueOf(0), pointer);
        } else {
            int i = input.charAt(inputPointer);

            if(i >= maxCellSize) i %= maxCellSize;

            listMemoryTape.replaceItem(String.valueOf(i), pointer);
        }

        inputPointer += 1;
    }

    void jmp() {
        int value = Integer.parseInt(listMemoryTape.getItem(pointer));

        if (value == 0) {
            codePointer = closeBracket.get(openBracket.indexOf(codePointer));
        }
    }

    void jmpBck() {
        int value = Integer.parseInt(listMemoryTape.getItem(pointer));
        int toWhere;

        try {
            toWhere = openBracket.get(closeBracket.indexOf(codePointer));

            if(value != 0) codePointer = toWhere;
        } catch (Exception e) {
            errorMessage("Unmatched loop brackets found.");
        }
    }
    //End of BrainFuck instructions

    //misc functions
    void reset() {
        //interp.stop();
        
        listMemoryTape.removeAll();
        listMemoryTape.add(0 + "");
        listMemoryTape.select(0);

        codePointer = 0;
        memorySize = 1;
        pointer = 0;
        inputPointer = 0;

        hasError = false;

        steps = 0;

        textOutput.setText("");
        labelStatus.setText("...");
        code = "";

        openBracket = null;
        closeBracket = null;
    }

    void errorMessage(String msg) {
        hasError = true;
        labelStatus.setText("ERROR: " + msg);
    }

    void scanForLoops(String code) {
        openBracket = new ArrayList<>();
        closeBracket = new ArrayList<>();

        for(int o = 0; o < code.length(); o += 1) {
            if(code.charAt(o) == '[') {
                System.out.println("Found [ at " + o);
                openBracket.add(o);
            }
        }

        try {
            System.out.println("finding pairs.....");
            openBracket.forEach((open) -> {
                System.out.println("Finding pair of [ " + open);
                int nest = 0;
                for (int i = open + 1; i < code.length(); i += 1) {
                    if(code.charAt(i) == '[') {
                        System.out.println("..Found [ nested at " + i);
                        nest += 1;
                    } else if (code.charAt(i) == ']' && nest != 0) {
                        System.out.println("..Found ] nested at " + i);
                        nest -= 1;
                    } else if (code.charAt(i) == ']' && nest == 0) {
                        System.out.println("..Found [ ] pair at " + open + ":" + i);
                        closeBracket.add(i);
                        break;
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Empty opening loop");
        }


        System.out.println("open: " + openBracket);
        System.out.println("clos: " + closeBracket);

        if(openBracket.size() != closeBracket.size()) {
            errorMessage("Mismatched loop brackets");
        }
    }

    void highlightText(int pos) throws BadLocationException {        
        highlighter.removeAllHighlights();
        HighlightPainter painter =
             new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        highlighter.addHighlight(pos, pos + 1, painter);
    }

    void sysLog(Object msg) {
        System.out.println("Log: " + String.valueOf(msg));
    }

    void gatherStatistics() {
        labelStatus.setText(String.format("Finished. Ran through %d instructions, used %d cells", steps, memorySize));
        
        buttonExceute.setEnabled(true);
        buttonStop.setEnabled(false);
    }

    void setSettings() {
        int power = 1;

        usingNegatives = checkUseNegatives.isSelected();
        usingWrapping = !checkDoWrapping.isSelected();

        if(radio_4bit.isSelected()) power = 4;
        else if(radio_8bit.isSelected()) power = 8;
        else if(radio_16bit.isSelected()) power = 16;
        else if(radio_32bit.isSelected()) power = 32;

        maxCellSize = (int) Math.pow(2, power);

        delay = sliderDelay.getValue();

        System.out.println(memorySize);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDelayDisplay;
    private javax.swing.JLabel labelStatus;
    private java.awt.List listMemoryTape;
    private javax.swing.JRadioButton radio_16bit;
    private javax.swing.JRadioButton radio_32bit;
    private javax.swing.JRadioButton radio_4bit;
    private javax.swing.JRadioButton radio_8bit;
    private javax.swing.JSlider sliderDelay;
    private javax.swing.JTextArea textInput;
    private javax.swing.JTextArea textOutput;
    private javax.swing.JTextField textUserInput;
    // End of variables declaration//GEN-END:variables

    public class InterpreterThread extends Thread {
        @Override
        public void run() {
            try {
                doInterpret();
            } catch (BadLocationException ex) {
                sysLog("highlight kinda out of bounds, but nothing broke");
            }
        }
    }
}