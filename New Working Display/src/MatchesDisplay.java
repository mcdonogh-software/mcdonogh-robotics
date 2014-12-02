/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;


/**
 *
 * @author sjaudia
 */
public class MatchesDisplay extends JFrame{
    
    public MatchesDisplay(){
        //Set Frame Options
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(0,0);
        
        //Add Panel
        getContentPane().add(Matches.getInstance());
        addKeyListener(Matches.getInstance());
        
        //Set to Visible and Run
        setVisible(true);
    } 
}