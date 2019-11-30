# Java brainfuck Interpreter (not a compiler)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5b3a7616a2054651a686c3254e7a7754)](https://www.codacy.com/manual/0x4kgi/java-brainfuck?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=0x4kgi/java-brainfuck&amp;utm_campaign=Badge_Grade)

![image](https://i.imgur.com/tTip51r.png)

## Features

 * Interpret brainfuck code
 * Accept inputs
 * Change cell size (8 bit to 32 bit)
 * Have delay
 * Show what command is being executed
 * Enable or disable wrapping
 * Enable or disable negative numbers

## Issues

 * Java console always shows a ArrayOutOfBounds exception when highlighting and textbox.append() is used.
 * Execution is really slow since this is using java.awt.List as the main memory tape.
 * Code is really messy in my opinion.
 * Some commit titles have typos lol
 
## Planned to do

 - [ ] Make execution a lot faster
 - [ ] Save/Load brainfuck codes to/from a file
 - [ ] Support other brainfuck variants (or probably a converter to those)

## References

[Brainfuck definitions](https://esolangs.org/wiki/Brainfuck)

[Shortest Hello world brainfuck code](https://codegolf.stackexchange.com/a/163590/59487)

[Java Threads (jenkov.com)](http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html)

[How to determine of a thread is running](https://stackoverflow.com/questions/861346/in-java-how-do-you-determine-if-a-thread-is-running)

[Java Docs: Using List Components](https://docs.oracle.com/javase/tutorial/uiswing/components/list.html)

[Java Docs: Using JCheckbox](https://docs.oracle.com/javase/7/docs/api/javax/swing/JCheckBox.html)

[Java Docs: JList](https://docs.oracle.com/javase/8/docs/api/javax/swing/JList.html#setSelectedValue-java.lang.Object-boolean-)

[Java Multithreading](https://www.guru99.com/multithreading-java.html)

[JRadioButton](https://www.geeksforgeeks.org/jradiobutton-java-swing/)

[char to int](https://www.javatpoint.com/java-char-to-int)
