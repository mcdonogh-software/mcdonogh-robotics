 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author sjaudia
 */
public class MyPanel extends JPanel{
    //Components
    public static JLabel matchLabel;
    public static JLabel timeLabel;
    public static JLabel alliesLabel;
    public static JLabel opponentsLabel;
    public static JLabel currBatteryLabel;
    public static JLabel nextBatteryLabel;
    public static JLabel batteryTimeLabel;
    public static JLabel currentTime;
    public static JLabel practiceLabel;
    private JButton prevBatteryButton;
    private JButton nextBatteryButton;
    //Time Tracker
    private Thread updateTimeThread;
    private long lastUpdateTime;
    private long currBatteryTime;
    //Attributes
    private int batteryNumber;
    
    public MyPanel(){
        //Initialize Components
        matchLabel = new JLabel(" Next Match #: " + Matches.getInstance().getMatch());
        matchLabel.setFont(new Font("Arial", Font.BOLD, 24));
        matchLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        currentTime = new JLabel(" Current Time: " + dateFunc());
        currentTime.setFont(new Font("Arial", Font.BOLD, 24));
        currentTime.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        practiceLabel = new JLabel(" Practice Match Time:" + Matches.getInstance().getPractice());
        practiceLabel.setFont(new Font("Arial", Font.BOLD,24));
        practiceLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        timeLabel = new JLabel(" Time: " + Matches.getInstance().getTime());
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        alliesLabel = new JLabel(" Allies: " + Matches.getInstance().getAllies());
        alliesLabel.setFont(new Font("Arial", Font.BOLD, 24));
        alliesLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        opponentsLabel = new JLabel(" Opponents: " + Matches.getInstance().getOpponents());
        opponentsLabel.setFont(new Font("Arial", Font.BOLD, 24));
        opponentsLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        currBatteryLabel = new JLabel(" Current Battery: 1");
        currBatteryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        currBatteryLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        nextBatteryLabel = new JLabel(" Next Battery: 2");
        nextBatteryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nextBatteryLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        batteryTimeLabel = new JLabel(" Current Battery Usage Time: ");
        batteryTimeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        batteryTimeLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        prevBatteryButton = new JButton(" Prev Battery");
        prevBatteryButton.setFont(new Font("Arial", Font.BOLD, 24));
        prevBatteryButton.setBorder(BorderFactory.createLineBorder(Color.gray));
        prevBatteryButton.addActionListener(new PrevButtonListener());
        
        nextBatteryButton = new JButton(" Next Battery");
        nextBatteryButton.setFont(new Font("Arial", Font.BOLD, 24));
        nextBatteryButton.setBorder(BorderFactory.createLineBorder(Color.gray));
        nextBatteryButton.addActionListener(new NextButtonListener());
        
        //Initialize Layout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        //Init MatchLabel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        matchLabel.setBackground(new Color(255,150,25));
        matchLabel.setOpaque(true);
        add(matchLabel, constraints);
        
        //Init TimeLabel
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        timeLabel.setBackground(new Color(0,0,0));
        timeLabel.setForeground(new Color(255,150,25));
        timeLabel.setOpaque(true);
        add(timeLabel, constraints);
        //Init practice Label
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        practiceLabel.setBackground(new Color(0,0,0));
        practiceLabel.setForeground(new Color(255,150,25));
        practiceLabel.setOpaque(true);
        add(practiceLabel, constraints);
        
        //Init currentTime
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        currentTime.setBackground(new Color(255,150,25));
        currentTime.setOpaque(true);
        add(currentTime, constraints);
        
        //Init AlliesLabel
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.gridwidth = 2;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        alliesLabel.setBackground(new Color(0,0,0));
        alliesLabel.setForeground(new Color(255,150,25));
        alliesLabel.setOpaque(true);
        add(alliesLabel, constraints);
        
        //Init OpponentsLabel
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.gridwidth = 2;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        opponentsLabel.setBackground(new Color(255,150,25));
        opponentsLabel.setOpaque(true);
        add(opponentsLabel, constraints);
        
        //Init CurrentBatteryLabel
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.weightx = 0;
        constraints.gridwidth = 1;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        currBatteryLabel.setBackground(new Color(0,0,0));
        currBatteryLabel.setForeground(new Color(255,150,25));
        currBatteryLabel.setOpaque(true);
        add(currBatteryLabel, constraints);
        
        //Init NextBatteryLabel
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.weightx = .5;
        constraints.gridwidth = 1;
        constraints.weighty = .2;
        constraints.ipady = 640/5;
        nextBatteryLabel.setBackground(new Color(255,150,25));
        nextBatteryLabel.setOpaque(true);
        add(nextBatteryLabel, constraints);
        
        //Init BatteryTimeLabel
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.weightx = 1;
        constraints.weighty = .2;
        constraints.gridwidth = 2;
        constraints.ipady = 640/5;
        batteryTimeLabel.setBackground(new Color(255,150,25));
        batteryTimeLabel.setOpaque(true);
        add(batteryTimeLabel, constraints);
        
        //Init Prev Battery Button
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.weightx = 0.5;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        constraints.ipady = 100;
        add(prevBatteryButton, constraints);
        
        //Init Next Battery Button
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.weightx = 0.5;
        constraints.weighty = 0;
        constraints.gridwidth = 1;
        constraints.ipady = 100;
        add(nextBatteryButton, constraints);
        
        //Initialize Time Trackers
        lastUpdateTime = System.currentTimeMillis();
        currBatteryTime = 0l;
        updateTimeThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    currBatteryTime += System.currentTimeMillis() - lastUpdateTime;
                    lastUpdateTime = System.currentTimeMillis();
                    batteryTimeLabel.setText(" Current Battery Usage Time: " + 
                    convertMillisToTime(currBatteryTime));
                    currentTime.setText(" Current Time: " + dateFunc());
                    Matches.getInstance().update();
                }
            }
        };
        updateTimeThread.start();
        
        //Init Attributes
        batteryNumber = 1;
    }
    
    //Time Converter Methods
    private String convertMillisToTime(long millis) {
        int seconds = (int)(millis / 1000);
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        String hoursString = "00";
        if (hours < 10) hoursString = "0" + hours;
        else hoursString = "" + hours;
        String minutesString = "00";
        if (minutes < 10) minutesString = "0" + minutes;
        else minutesString = "" + minutes;
        String secondsString = "00";
        if (seconds < 10) secondsString = "0" + seconds;
        else secondsString = "" + seconds;
        return "" + hoursString + ":" + minutesString + ":" + secondsString;
    }
    
    //Inc and Dec Methods
    private void incBatteryNumber() {
        batteryNumber++;
        batteryNumber = loopBatteryNumber(batteryNumber);
    }
    private void decBatteryNumber() {
        batteryNumber--;
        batteryNumber = loopBatteryNumber(batteryNumber);
    }
    private int loopBatteryNumber(int rawNumber) {
        if (rawNumber > 6) return 1;
        if (rawNumber < 1) return 6;
        return rawNumber;
    }
    
    private String dateFunc(){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss:a");
        Date date = new Date();
        return dateFormat.format(date);
    }
    //Button Listeners
    private class PrevButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            decBatteryNumber();
            currBatteryLabel.setText("Current Battery: " + batteryNumber);
            nextBatteryLabel.setText("Next Battery: " + loopBatteryNumber(batteryNumber + 1));
            currBatteryTime = 0;
        }
    }
    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            incBatteryNumber();
            currBatteryLabel.setText("Current Battery: " + batteryNumber);
            nextBatteryLabel.setText("Next Battery: " + loopBatteryNumber(batteryNumber + 1));
            currBatteryTime = 0;
        }
    }
}
