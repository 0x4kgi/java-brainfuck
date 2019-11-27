
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interpreter {
    //Code and Input strings
    private String code;
    private String input;
    
    //Interpreter pointers
    private int memorySize = 1;
    private int memoryPointer = 0;
    private int codePointer = 0;
    private int inputPointer = 0;
    
    //Interpreter Loop management
    private LoopIndex loopIndex;
    
    //Interpreter Settings, non-realtime
    private boolean usingNegatives = false;
    private boolean usingWrapping = true;
    private int maxCellSize = 256;
    
    //Interpreter settings, realtime
    private int delay = 0;
    
    //Check if the code is running
    private boolean isRunning = false;
    
    //Set logging in console
    boolean doLogs = true;
    
    //Components to use
    private java.awt.List memoryTape;
    private JTextArea textInput;
    private JTextArea textOutput;
    private JTextField textUserInput;
    
    public Interpreter(boolean doLogs) {
        this.doLogs = doLogs;
        
        log("Intrepreter initialized (logging " 
                + (this.doLogs?"enabled":"disabled") 
                +")"
            , true
        );
    }

    public void setCode(String code) {
        if(!isRunning)
            this.code = code;
    }
    
    public void setInput(String input) {
        if(!isRunning)
            this.input = input;
    }
    
    public void start() {
        if(scanForLoops(code)) {
            doInterpretation();
        } else {
            log("Mismatched loop brackets", true);
        }
    }
    
    public void stop() {
        isRunning = false;
        memorySize = 1;
        memoryPointer = 0;
        codePointer = 0;
        inputPointer = 0;
        loopIndex = null;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Interpreter Initialization">
    private void doInterpretation() {
        log("\nExecuting instructions...", true);        
        isRunning = true;
        
        while(codePointer < code.length() && isRunning) {            
            char c = code.charAt(codePointer);
            switch(c) {
                case '+': 
                    inc(); 
                    break;
                case '-': 
                    dec(); 
                    break;
                case '>': 
                    movfwd(); 
                    break;
                case '<': 
                    movbck(); 
                    break;
                case '[': 
                    jmpfwd(); 
                    break;
                case ']': 
                    jmpbck(); 
                    break;
                case '.': 
                    output(); 
                    break;
                case ',': 
                    input(); 
                    break;
                default: 
                    codePointer += 1; 
                    continue;
            } 
            codePointer += 1;
            
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        isRunning = false;
        log("\nFinished Excecution", true);
    }    
    private boolean scanForLoops(String code) {
        log("\nScanning for loops...", true);
        List<Integer> open = new ArrayList<>();
        List<Integer> close = new ArrayList<>();
        
        for (int i = 0; i < code.length(); i += 1) {
            if(code.charAt(i) == '['){
                log("[ @ " + i, false);
                open.add(i);
            } //if
        } //for
        
        try {
            log("=Finding pairs=", false);
            open.forEach((openIndex) -> {
                int openBrackets = 0;
                
                log(addChars("Ff: [ @ " + openIndex, openBrackets + 1, "-", true), false);
                
                for (int i = openIndex + 1; i < code.length(); i += 1) {
                    if(code.charAt(i) == '[') {
                        openBrackets += 1;
                        log(addChars("[ @ " + i, openBrackets + 1, "-", true), false);
                    } else if(code.charAt(i) == ']') {
                        if(openBrackets > 0) {
                            log(addChars("] @ " + i, openBrackets + 1, "-", true), false);
                            openBrackets -= 1;
                        } else {
                            close.add(i);
                            log(addChars("[] @ " + i, openBrackets + 1, "-", true), false);
                            break;
                        }
                    }
                }
            });
        } catch (Exception e) {
            log("Empty opening loop", false);
        }//try catch       
        
        log("O:" + open, false);
        log("C:" + close, false);
        
        if(open.size() != close.size()) {
            log("Mismatched loop brackets", true);
            return false;
        } else {
            loopIndex = new LoopIndex(open, close);        
            return true;
        }
    } //scanForLoops
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Brainfuck instructions">
    private void inc() {
        log("+: Incrementing cell " + memoryPointer, false);
        int value;
        try {
           value = Integer.parseInt(memoryTape.getItem(memoryPointer));

           value += 1;

           if(usingNegatives) {
               if(usingWrapping && value == (maxCellSize / 2)) {
                   value = -(maxCellSize / 2);
               }
           } else {
               if(usingWrapping && value == maxCellSize) {
                   value = 0;
               }
           }

           memoryTape.replaceItem("" + value, memoryPointer);
        } catch (Exception e) {
            memoryTape.add(String.valueOf(1));
        }

        memoryTape.select(memoryPointer);
    }
    private void dec() {
        log("-: Decrementing cell " + memoryPointer, false);
        int value;
        try {
           value = Integer.parseInt(memoryTape.getItem(memoryPointer));

           value -= 1;

           if(usingNegatives) {
               if(usingWrapping && value == -((maxCellSize / 2) + 1)) {
                   value = (maxCellSize / 2) - 1;
               }
           } else {
               if(usingWrapping && value == -1) {
                   value = maxCellSize - 1;
               }
           }

           memoryTape.replaceItem("" + value, memoryPointer);
        } catch (Exception e) {
            memoryTape.add(String.valueOf(maxCellSize - 1));
        }

        memoryTape.select(memoryPointer);
    }
    private void movfwd() {
        log(">: Moving forward to cell " + (memoryPointer + 1), false);
        memoryPointer += 1;

        if (memoryPointer == memorySize) {
            memoryTape.add(0 + "");
            memorySize += 1;
        }
    }
    private void movbck() {
        log("<: Moving backward to cell " + (memoryPointer - 1), false);
        memoryPointer -= 1;

        if (memoryPointer < 0) {
            memoryTape.add(0 + "", 0);
            memoryPointer = 0;
            memorySize += 1;
        }
    }
    private void jmpfwd() {
        int value = Integer.parseInt(memoryTape.getItem(memoryPointer)); 
        
        if(value == 0) {
            codePointer = loopIndex.getClosingPair(codePointer);
            log("[: Jumping forward to " + codePointer, false);
        }
    }
    private void jmpbck() {
        int value = Integer.parseInt(memoryTape.getItem(memoryPointer)); 
        
        if(value != 0) {
            codePointer = loopIndex.getOpeningPair(codePointer);
            log("]: Jumping back to " + codePointer, false);
        }
    }
    private void output() {
        int value = Integer.parseInt(memoryTape.getItem(memoryPointer));         
        char ascii = (char) value;
        log(".: Outputting \"" + ascii + "\"", false);
        
        textOutput.append(String.valueOf(ascii));
        textOutput.setCaretPosition(textOutput.getText().length());
    }
    private void input() {
        if(inputPointer > input.length() - 1) {
            memoryTape.replaceItem(String.valueOf(0), memoryPointer);
        } else {
            int i = input.charAt(inputPointer);

            if(i >= maxCellSize) i %= maxCellSize;

            memoryTape.replaceItem(String.valueOf(i), memoryPointer);
            log(",: Adding \"" + i + "\" to memory", false);
        }

        inputPointer += 1;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interpreter Settings setting."> 
    public void setComponents(java.awt.List memoryTape, JTextArea codeInput, JTextArea output, JTextField userInput) {
        log("Setting components...", false);
        log("\nComponents found:"
                + "\nmemoryTape:" + memoryTape
                + "\ncodeInput: " + codeInput
                + "\noutput: " + output
                + "\nuserInput: " + userInput
            , false
        );
        this.memoryTape = memoryTape;
        this.textInput = codeInput;
        this.textOutput = output;
        this.textUserInput = userInput;
        log("\nComponents saved:"
                + "\nmemoryTape:" + this.memoryTape
                + "\ncodeInput: " + this.textInput
                + "\noutput: " + this.textOutput
                + "\nuserInput: " + this.textUserInput
            , false
        );
    }    
    public void setSettings(boolean usingNegatives, boolean usingWrapping, int maxCellSize) {
        log("\nSetiing options...", false);
        this.usingNegatives = usingNegatives;
        this.usingWrapping = usingWrapping;
        this.maxCellSize = maxCellSize;
    }    
    public void setDelay(int delay) {
        log("\nSetting delay to " + delay, false);
        this.delay = delay;
    }
    // // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Classes">
    private class LoopIndex {
        private final List<Integer> openBracket;
        private final List<Integer> closeBracket;
        
        public LoopIndex(List<Integer> openList, List<Integer> closeList) {
            log("Saving loop locations", false);
            openBracket = openList;
            closeBracket = closeList;
            log("O:" + openList + "\nC:" + closeList, false);
        }
        
        public int getOpeningPair(int position) {
            return openBracket.get(closeBracket.indexOf(position));
        }
        
        public int getClosingPair(int position) {
            return closeBracket.get(openBracket.indexOf(position));            
        }
    }    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Misc functions">
    private void log(Object msg, boolean isImportant) {
        if(doLogs)
            System.out.println(String.valueOf(msg));
        else
            if(isImportant)
                System.out.println(String.valueOf(msg));
    }    
    private String addChars(String str, int pad, String ins, boolean atLeft) {
        String offset = "";
        
        for (int i = 0; i < pad; i += 1) {
            offset += ins;
        }
        
        if(atLeft) {
            return offset + str;
        }
        
        return str + offset;
    }
    // </editor-fold>    
}
