public class DateTime extends Date {
    
    private final int hour;
    private final int minute;
    private final int second;

    public DateTime(int year, int month, int day, int hour, int minute, int second) throws DateException {
        super(year, month, day);
        
        
            if (!DateTime.isLegalTime(hour, minute, second)) {
                throw new DateException(String.format("Illegal time %02d:%02d:%02d",
                hour, minute, second));
            }
        
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
    
    @Override
    public String toString() {
        
        return String.format(super.toString() + " %02d:%02d:%02d",
                this.hour, this.minute, this.second);
    }
    
    static private boolean isLegalTime(int hour, int minute, int second) {
        if (hour > 23 || hour < 0) {return false;}
        if (minute > 59 || minute < 0) {return false;}
        if (second > 59 || second < 0) {return false;}
        return true;
    }
}