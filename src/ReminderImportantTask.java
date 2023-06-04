public class ReminderImportantTask implements Runnable{
    private Reminder reminder;

    public ReminderImportantTask(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000*60);
            System.out.println("trrr.... "+ reminder.getText());
            Thread.sleep(1000*60);
            System.out.println("trrr.... "+ reminder.getText());
            Thread.sleep(1000*60);
            System.out.println("trrr.... "+ reminder.getText());
        } catch (InterruptedException e) {
        }
    }
}
