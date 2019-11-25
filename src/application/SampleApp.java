/**
 * First trial on creating a working interpreter
 */

package application;

import java.util.ArrayList;
import java.util.Scanner;

public class SampleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        
        System.out.println("BrainFuck code:");
        String brainFuckSyntax = scanner.nextLine();        
        
        System.out.println(brainFuckInterpreter(brainFuckSyntax));        
        
        
        System.out.println("\n----------------");
    }
    
    static boolean isValidBrainFuckCode(String snippet) {
        switch(snippet) {
            case "+":
            case "-":
            case ">":
            case "<":
            case ".":
            case "[":
            case "]":
            case ",":
                return true;
            default:
                return false;
            
        }
    }
    
    static String brainFuckInterpreter(String code) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> tape = new ArrayList<>();
        tape.add(0);
        int pointer = 0;
        
        String[] explodedCode = code.split("");
        
        for (int sym = 0; sym < explodedCode.length; sym += 1) {
            String crumb = explodedCode[sym];
            
            
            if(isValidBrainFuckCode(crumb)) {
                if("+".equals(crumb)) {
                    tape.set(pointer, tape.get(pointer) + 1);
                }
                
                if("-".equals(crumb)) {
                    if (tape.get(pointer) == 0) tape.set((pointer), 255);
                    else tape.set(pointer, tape.get(pointer) - 1);
                }
                
                if("<".equals(crumb)) {
                    pointer -= 1;
                    
                    if (pointer < 0) return "\nPointer is out of bounds, exiting....";
                }
                
                if(">".equals(crumb)) {
                    pointer += 1;
                    
                    if (pointer > tape.size() - 1) tape.add(0);
                }
                
                if(".".equals(crumb)) {
                    int c = tape.get(pointer);
                    char ch = (char) c;
                    System.out.print(ch);
                }
                
                if("[".equals(crumb)) {
                    int currentPos = sym;
                    int dataAtPointer = tape.get(pointer);
                    
                    int closingLocation = -1;
                    
                    int nest = 0;
                    
                    for (int a = currentPos; a < explodedCode.length; a += 1) {
                        
                        if ("[".equals(explodedCode[a])) {
                            if (a == currentPos) continue;
                            nest += 1;
                        } else if ("]".equals(explodedCode[a]) && nest != 0) {
                            nest -= 1;
                        } else if ("]".equals(explodedCode[a]) && nest == 0) {
                            closingLocation = a;
                            //System.out.println("]: closing found at " + closingLocation);
                            break;
                        } else if (a == explodedCode.length - 1) {
                            return "\nNo closing bracket found, exiting....";
                        }
                        /*System.out.println("[: " 
                                + explodedCode[a] 
                                + " | " + nest 
                                + " | " + closingLocation);*/
                    }
                    
                    if (dataAtPointer == 0) sym = closingLocation;
                }
                
                if("]".equals(crumb)) {
                    int currentPos = sym;
                    int dataAtPointer = tape.get(pointer);
                    int openingLocation = -1;
                    
                    int nest = 0;
                    
                    for (int a = currentPos - 1; a > -2; a -= 1) {
                        if (a == -1) return "\nMisplaced bracket, exiting...";
                        
                        if ("]".equals(explodedCode[a])) {
                            nest += 1;
                        } else if ("[".equals(explodedCode[a]) && nest > 0) {
                            nest -= 1;
                        } else if ("[".equals(explodedCode[a]) && nest == 0) {
                            openingLocation = a;
                            //System.out.println("]: opening found at " + openingLocation);
                            break;
                        } else if (a == 0) {
                            return "\nNo opening bracket found, exiting....";
                        }
                        /*System.out.println("]: " 
                                + explodedCode[a] 
                                + " | " + nest 
                                + " | " + openingLocation);*/
                    }
                    
                    if (dataAtPointer != 0) sym = openingLocation;
                }
                
                if(",".equals(crumb)) {
                    System.out.print("input: ");
                    String in = scanner.nextLine();
                    
                    char character = in.charAt(0);
                    int ascii = character;
                    
                    tape.set(pointer, ascii);
                }
            }
            
        }
        System.out.print("\n");
        
        for (int i = 0; i < tape.size(); i += 1) {
            if (i == pointer) System.out.print("{" + tape.get(i)+ "}");
            else System.out.print("[" + tape.get(i)+ "]");
        }
        
        System.out.print("\npointer at position " + (pointer + 1));
        
        return "\n\n";
    }
}
