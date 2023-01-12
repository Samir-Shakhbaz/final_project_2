//package final_project_2.controllers;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//
//public class ButtonController extends JPanel implements ActionListener {
//
//    static String oneString = "one";
//    static String twoString = "two";
//    static String threeString = "three";
//    static String fourString = "four";
//
//    public ButtonController() {
//        super(new BorderLayout());
//
//        //Create the radio buttons.
//        JRadioButton oneButton = new JRadioButton(oneString);
//        oneButton.setMnemonic(KeyEvent.VK_1);
//        oneButton.setActionCommand(oneString);
//        oneButton.setSelected(true);
//
//        JRadioButton twoButton = new JRadioButton(twoString);
//        twoButton.setMnemonic(KeyEvent.VK_2);
//        twoButton.setActionCommand(twoString);
//
//        JRadioButton threeButton = new JRadioButton(threeString);
//        threeButton.setMnemonic(KeyEvent.VK_3);
//        threeButton.setActionCommand(fourString);
//
//        JRadioButton fourButton = new JRadioButton(fourString);
//        fourButton.setMnemonic(KeyEvent.VK_4);
//        fourButton.setActionCommand(fourString);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}