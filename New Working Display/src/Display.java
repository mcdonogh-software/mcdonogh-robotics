/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;


/**
 *
 * @author sjaudia
 */
public class Display extends JFrame{
    
    public Display(){
        //Set Frame Options
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        setLocationRelativeTo(null);
        
        //Add Panel
        getContentPane().add(new MyPanel());
        
        //Set to Visible and Run
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Display();
        new MatchesDisplay();
    }
}

