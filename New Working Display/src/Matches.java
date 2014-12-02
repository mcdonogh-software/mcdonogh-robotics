/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Matches extends JPanel implements KeyListener, ActionListener {
    
    private static Matches instance;
    
    private Gatherer<Match> theVault;
    
    private int currMatch;
    
    private JLabel matchLabel;
    private JLabel timeLabel;
    private JLabel alliesLabel;
    private JLabel opponentsLabel;
    private JLabel colorLabel;
    private JLabel practiceLabel;
    private JTextField matchField;
    private JTextField timeField;
    private JTextField alliesField;
    private JTextField opponentsField;
    private JTextField colorField;
    private JTextField practiceField;
    private JButton addButton;
    
    private Matches(){
        theVault = new Gatherer<Match>();
        theVault.add(new Match(new Time(0,0),0,"","",""));
        currMatch = 0;
        
        matchLabel = new JLabel("Match #: ");
        timeLabel = new JLabel("Time: ");
        alliesLabel = new JLabel("Allies: ");
        opponentsLabel = new JLabel("Opponents: ");
        colorLabel = new JLabel("Bumpers: ");
        practiceLabel = new JLabel("Practice: ");
        
        matchField = new JTextField("");
        timeField = new JTextField("");
        alliesField = new JTextField("");
        opponentsField = new JTextField("");
        colorField = new JTextField("");
        practiceField = new JTextField("");
        practiceField.addKeyListener(this);
        
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        
        JButton testButton = new JButton("Next");
        testButton.addActionListener(new TestButton());
        
        JButton prevButton = new JButton("Prev");
        prevButton.addActionListener(new PrevButton());
        
        setLayout(new GridLayout(8,2));
        
        add(matchLabel);
        add(matchField);
        add(timeLabel);
        add(timeField);
        add(alliesLabel);
        add(alliesField);
        add(opponentsLabel);
        add(opponentsField);
        add(colorLabel);
        add(colorField);
        add(practiceLabel);
        add(practiceField);
        add(addButton);
        add(new JLabel(""));
        add(testButton);
        add(prevButton);
        
    }
    
    public void add(Match m){
        theVault.add(m);
    }
    
    public void updateText() {
        currMatch++;
    }
    
    public String getMatch() {
        return theVault.get(currMatch).getEvent();
    }
    public String getTime() {
        return theVault.get(currMatch).getTime();
    }
    public String getAllies() {
        return theVault.get(currMatch).getAllies();
    }
    public String getOpponents() {
        return theVault.get(currMatch).getOpponents();
    }
    public String getColor() {
        return theVault.get(currMatch).getColor();
    }
    public String getPractice(){
        return practiceField.getText();
    }
    
    public void updatePractice() {
        MyPanel.practiceLabel.setText(" Practice Match Time: " + getPractice());
    }
    
    private String dateFunc(){
        DateFormat dateFormat = new SimpleDateFormat("kk:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public void update(){
        
        String date = dateFunc();
        int hours = Integer.parseInt(date.substring(0,date.indexOf(":")));
        int minutes = Integer.parseInt(date.substring(date.indexOf(":")+1));
        Time curr = new Time(hours, minutes);
        //System.out.println(curr.toString());
        //System.out.println(theVault.get(currMatch).getObjTime().compareTo(curr));
        if(currMatch != theVault.size()-1 && theVault.get(currMatch).getObjTime().compareTo(curr) < 0){
            currMatch++;
            System.out.println("Increment Successful");
        }
        
        MyPanel.matchLabel.setText(" Match #: " + this.getMatch() + "   " + this.getColor());
        MyPanel.timeLabel.setText(" Time: " + this.getTime());
        MyPanel.alliesLabel.setText(" Allies: " + this.getAllies());
        MyPanel.opponentsLabel.setText(" Opponents: " + this.getOpponents());
    }
    
    //Singleton Method
    public static Matches getInstance() {
        if (instance == null) {
            instance = new Matches();
        }
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        updatePractice();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int hours = Integer.parseInt(timeField.getText().substring(0,timeField.getText().indexOf(":")).replaceAll("\\s+",""));
        int minutes = Integer.parseInt(timeField.getText().substring(timeField.getText().indexOf(":")+1).replaceAll("\\s+",""));
        Time start = new Time(hours, minutes);
        add(new Match(start, Integer.parseInt(matchField.getText()),alliesField.getText(), opponentsField.getText(), colorField.getText()));
        System.out.println("Add successful");
    }
    
    public void increaseCurrMatch () {
        if(currMatch != theVault.size()-1)
                updateText();
    }
    
    private class TestButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            increaseCurrMatch();
        }
        
    }
    
    private class PrevButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(currMatch != 0)
                currMatch--;
        }
        
    }
}

/**
 *
 * @author sjaudia
 */
/*
public class Matches extends JPanel implements KeyListener {
    //Instance
    private static Matches instance;
    //Components
    private JLabel matchLabel;
    private JLabel timeLabel;
    private JLabel alliesLabel;
    private JLabel opponentsLabel;
    private JLabel practiceLabel;
    private JTextField matchField;
    private JTextField timeField;
    private JTextField alliesField;
    private JTextField opponentsField;
    private JTextField practiceField;

    private Matches() {
        matchLabel = new JLabel(" Next Match #: ");
        matchLabel.setFont(new Font("Arial", Font.BOLD, 12));
        matchLabel.setBorder(BorderFactory.createLineBorder(Color.gray));

        timeLabel = new JLabel(" Time: ");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.gray));

        alliesLabel = new JLabel(" Allies: ");
        alliesLabel.setFont(new Font("Arial", Font.BOLD, 12));
        alliesLabel.setBorder(BorderFactory.createLineBorder(Color.gray));

        opponentsLabel = new JLabel(" Opponents: ");
        opponentsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        opponentsLabel.setBorder(BorderFactory.createLineBorder(Color.gray));

        practiceLabel = new JLabel(" Practice: ");
        practiceLabel.setFont(new Font("Arial", Font.BOLD, 12));
        practiceLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        matchField = new JTextField("");
        matchField.setFont(new Font("Arial", Font.BOLD, 24));
        matchField.setBorder(BorderFactory.createLineBorder(Color.gray));
        matchField.addKeyListener(this);

        timeField = new JTextField("");
        timeField.setFont(new Font("Arial", Font.BOLD, 24));
        timeField.setBorder(BorderFactory.createLineBorder(Color.gray));
        timeField.addKeyListener(this);

        alliesField = new JTextField("");
        alliesField.setFont(new Font("Arial", Font.BOLD, 24));
        alliesField.setBorder(BorderFactory.createLineBorder(Color.gray));
        alliesField.addKeyListener(this);

        opponentsField = new JTextField("");
        opponentsField.setFont(new Font("Arial", Font.BOLD, 24));
        opponentsField.setBorder(BorderFactory.createLineBorder(Color.gray));
        opponentsField.addKeyListener(this);
        
        practiceField = new JTextField("");
        practiceField.setFont(new Font("Arial", Font.BOLD, 24));
        practiceField.setBorder(BorderFactory.createLineBorder(Color.gray));
        practiceField.addKeyListener(this);

        setLayout(new GridLayout(6, 2));

        add(matchLabel);
        add(matchField);
        add(timeLabel);
        add(timeField);
        add(alliesLabel);
        add(alliesField);
        add(opponentsLabel);
        add(opponentsField);
        add(practiceLabel);
        add(practiceField);
    }
    
    //Singleton Method
    public static Matches getInstance() {
        if (instance == null) {
            instance = new Matches();
        }
        return instance;
    }
    
    //Get Methods
    public String getMatch() {
        return matchField.getText();
    }
    public String getTime() {
        return timeField.getText();
    }
    public String getAllies() {
        return alliesField.getText();
    }
    public String getOpponents() {
        return opponentsField.getText();
    }
    public String getPractice(){
        return practiceField.getText();
    }
    
    
    //Key Listeners
    @Override
    public void keyTyped(KeyEvent ke) {}
    @Override
    public void keyPressed(KeyEvent ke) {}
    @Override
    public void keyReleased(KeyEvent ke) {
        updateText();
    }
    
    //Action Methods
    private void updateText() {
        MyPanel.matchLabel.setText(" Next Match #: " + getMatch());
        MyPanel.timeLabel.setText(" Time: " + getTime());
        MyPanel.alliesLabel.setText(" Allies: " + getAllies());
        MyPanel.opponentsLabel.setText(" Opponents: " + getOpponents());
        MyPanel.practiceLabel.setText(" Practice Match Time: " + getPractice());
    }
}
*/