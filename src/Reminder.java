import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class Reminder implements Comparable<Reminder> {
    private Calendar expiration;
    private String text;
    private boolean important;
    private boolean popped=false;

    public Reminder(Calendar expiration, String text, boolean important) {
        this.expiration = expiration;
        this.text = text;
        this.important = important;
        this.popped=popped;


    }

    public Calendar getExpiration() {
        return expiration;
    }

    public String getText() {
        return text;
    }

    public boolean isImportant() {
        return important;
    }

    public boolean isPopped() {
        return popped;
    }

    public void setPopped(boolean popped) {
        this.popped = popped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return Objects.equals(expiration, reminder.expiration) && Objects.equals(text, reminder.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expiration, text);
    }

    @Override
    public int compareTo(Reminder o) {
       return this.expiration.compareTo(o.expiration);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Reminder{" +
                "expiration=" + sdf.format(expiration.getTime()) +
                ", text='" + text + '\'' +
                ", important=" + important +
                ", popped=" + popped +
                '}';
    }
}
