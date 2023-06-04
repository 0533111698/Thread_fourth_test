import java.util.Calendar;
import java.util.List;

public class ReminderTask implements Runnable {
    private List<Reminder>reminders;

    public ReminderTask(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public void run() {
        while (true){
            Calendar now=Calendar.getInstance();
            for (Reminder r:reminders) {
                if (r.getExpiration().before(now) && !r.isPopped()) {
                    if (r.isImportant() == true) {
                        System.out.println("trrr... "+ r.getText());
                        r.setPopped(true);
                        Thread thread=new Thread(new ReminderImportantTask(r));
                        thread.start();
                    } else {
                        System.out.println("trrr... "+ r.getText());
                        r.setPopped(true);
                    }
                }

            }
            try {
                Thread.sleep(1000*60);
            } catch (InterruptedException e) {
            }
        }
    }
}
