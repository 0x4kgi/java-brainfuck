/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.Color;
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
    private int memorySize = 1; //this is going to be dyamic
    private int pointer = 0;
    private int codePointer = 0;
    private String stringOutput = "";
    
    private List<Integer> openBracket = new ArrayList<>();;
    private List<Integer> closeBracket = new ArrayList<>();;

    public InterpreterInterface() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMemoryTape = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        textOutput = new javax.swing.JTextArea();
        buttonExceute = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textInput = new javax.swing.JTextArea();
        labelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listMemoryTape.setEnabled(false);
        listMemoryTape.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N

        textOutput.setColumns(20);
        textOutput.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        textOutput.setRows(5);
        jScrollPane1.setViewportView(textOutput);

        buttonExceute.setText("Execute");
        buttonExceute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExceuteActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        textInput.setColumns(20);
        textInput.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        textInput.setRows(5);
        jScrollPane2.setViewportView(textInput);

        labelStatus.setText(":)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExceute))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMemoryTape, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonExceute, buttonReset});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listMemoryTape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonExceute)
                            .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelStatus)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonExceute, buttonReset});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExceuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExceuteActionPerformed
        reset(false);
        
        String input = textInput.getText();
        
        scanForLoops(input);
        
        while (codePointer < input.length() && !hasError) {
            char s = input.charAt(codePointer); //while loop
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
            
            //Thread.sleep(20);
        }
    }//GEN-LAST:event_buttonExceuteActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        reset(true);
    }//GEN-LAST:event_buttonResetActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterpreterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterpreterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterpreterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterpreterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterpreterInterface().setVisible(true);
        });
    }

    //BrainFuck Instructions
    void inc() {       
        int value;
        try {
           value = Integer.parseInt(listMemoryTape.getItem(pointer));
           
           value += 1;
           
           if (value == 256) value = 0;
           
           listMemoryTape.replaceItem("" + value, pointer);
        } catch (Exception e) {
            listMemoryTape.add(String.valueOf(1));
        }  
        
        //listMemoryTape.select(pointer);
    }
    
    void dec() {
        int value;
        try {
           value = Integer.parseInt(listMemoryTape.getItem(pointer));
           
           value -= 1;
           
           if (value == -1) value = 255;
           
           listMemoryTape.replaceItem("" + value, pointer);
        } catch (Exception e) {
            listMemoryTape.add(String.valueOf(255));
        }  
        
        //listMemoryTape.select(pointer);        
    }
    
    void mov(boolean ins) {
        int length = listMemoryTape.getItemCount();
        if(ins) { // >
            pointer += 1;
            
            if (pointer == memorySize) {
                listMemoryTape.add(0 + "");
                memorySize += 1;
            }
        } else { // <
            pointer -= 1;
            
            if (pointer < 0) {
                errorMessage("pointer out of bounds");
            }
        }
        
        if(!hasError) listMemoryTape.select(pointer);
    }
    
    void output() {
        int value = Integer.parseInt(listMemoryTape.getItem(pointer));
        char ascii = (char) value;
        
        textOutput.append(String.valueOf(ascii));
        sysLog(String.valueOf(ascii));
    }
    
    void input() {}
    
    void jmp() {
        int value = Integer.parseInt(listMemoryTape.getItem(pointer));
        
        if (value == 0) {
            codePointer = closeBracket.get(openBracket.indexOf(codePointer));
        }
    }
    
    void jmpBck() {
        int value = Integer.parseInt(listMemoryTape.getItem(pointer));
        
        if (value != 0) {
            codePointer = openBracket.get(closeBracket.indexOf(codePointer));
        }
    }
    //End of BrainFuck instructions
    
    //misc functions
    void reset(boolean resetAll) {
        codePointer = 0;
        listMemoryTape.removeAll();
        listMemoryTape.add(0 + "");
        listMemoryTape.select(0);
        memorySize = 1;
        pointer = 0;
        hasError = false;
        
        textOutput.setText("");
        labelStatus.setText(":)");
        
        openBracket = null;
        closeBracket = null;
        
        if(resetAll) {
            textInput.setText("");
        }
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
        Highlighter highlighter = textInput.getHighlighter();
        highlighter.removeAllHighlights();
        HighlightPainter painter = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        highlighter.addHighlight(pos, pos + 1, painter);
    }
    
    void sysLog(String msg) {
        System.out.println(msg);
    }
    //end of misc functions
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExceute;
    private javax.swing.JButton buttonReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelStatus;
    private java.awt.List listMemoryTape;
    private javax.swing.JTextArea textInput;
    private javax.swing.JTextArea textOutput;
    // End of variables declaration//GEN-END:variables

}
