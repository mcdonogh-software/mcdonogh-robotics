/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Developer
 */
public class Match {
    
    private Time start;
    private int event;
    private String allies;
    private String opponents;
    private String color;
    
    public Match(Time start, int event, String allies, String opponents, String color) {

        this.start = start;
        this.event = event;
        this.allies = allies;
        this.opponents = opponents;
        this.color = color;
        
    }
    
    public Time getObjTime() {
        return start;
    }
    
    public String getTime() {
        return start.toString();
    }
    
    public String getEvent() {
        return "" + event;
    }
    
    public String getAllies() {
        return allies;
    }
    
    public String getOpponents() {
        return opponents;
    }
    
    public String getColor() {
        return color;
    }
    
}
