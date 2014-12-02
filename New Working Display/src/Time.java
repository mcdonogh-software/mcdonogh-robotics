public class Time implements Comparable<Time>{
    
    private final int hours;
    private final int minutes;
    
    public Time (int hours, int minutes) {
       int carry = minutes / 60;
       this.hours = hours + carry;
       this.minutes = minutes % 60;
    }
    
    public Time (int minutes) {
        hours = minutes / 60;
        this.minutes = minutes % 60;
    }
    
    public Time (Time begins, int hours, int minutes) {
        int carry = (begins.getMinute() + minutes) / 60;
        this.hours = begins.getHour() + hours + carry;
        this.minutes = (begins.getMinute() + minutes) % 60;
    }
    
    @Override
    public String toString() {
        String report = String.format("%d : %02d", hours, minutes);
        return report;
    }
    
    public int getHour() {
        return hours;
    }
    
    public int getMinute() {
        return minutes;
    }
    
    //Compare time to time in parens
    @Override
    public int compareTo (Time when) {
        return convertToMin(hours, minutes) - convertToMin(when);
    }
    
    //Compare time in parens to time
    public int timeUntil (Time stop) {
        return convertToMin(stop) - convertToMin(hours, minutes);
    }
    
    private int convertToMin (Time when) {
        return when.getHour() * 60 + when.getMinute();
    }
    
    private int convertToMin (int hours, int minutes) {
        return hours * 60 + minutes;
    }

}
