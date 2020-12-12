import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private LocalDate date;
    private LocalTime time;
    private final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    // default: the current time
    public Time() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Time(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return date.toString() + "  " + time.format(TIME_FORMATTER);
    }

    /*public static void main(String[] args) {
        Time t1 = new Time();
        System.out.println(t1);
    }*/
}
