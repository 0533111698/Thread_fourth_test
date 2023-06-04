import java.util.*;

public class Program {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        List<Reminder>reminders = new ArrayList<>();
        Thread thread1=new Thread(new ReminderTask(reminders));
        thread1.setDaemon(true);
        thread1.start();

        int choice;
        do {
            System.out.println("1> add reminder\n2> print the reminders\n3>exit\nenter your choice");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    reminders.add(createReminder(reminders));
                    break;
                case 2:
                    Collections.sort(reminders);
                    System.out.println(reminders);
                    break;
                case 3:
                    System.out.println("Have a nice day! good bye");
                    break;
                default:
                    System.out.println("Invalid choice! please try again...");
            }

        }while (choice!=3);
    }


    private static Reminder createReminder(List<Reminder> reminders) {
        Calendar expiration=scannerExpiration();
        while (expiration.before(Calendar.getInstance())){
            System.out.println(" the expiration is already passed, choose another expiration");
            expiration=scannerExpiration();}
        String text=createText();
        boolean important=createIsImportant();
        Reminder newR = new Reminder(expiration,text,important);
        for (Reminder r:reminders) {
            if (r.equals(newR)){
                System.out.println("There is already the same reminder in the system,please enter new reminder");
                expiration=scannerExpiration();
                while (expiration.before(Calendar.getInstance())){
                    System.out.println(" the expiration is already passed, choose another expiration");
                    expiration=scannerExpiration();}
                text=createText();
                important=createIsImportant();
            }

        }
        return new Reminder(expiration,text,important);
    }

    private static boolean createIsImportant() {
        Boolean important = true;
        System.out.println("If the reminder is important enter 'yes', if not enter 'no' ");
        String choice=scanner.next();
        if (choice.equals("yes"))
            important=true;
        else if (choice.equals("no")) {
            important=false;
        }else System.out.println("invalid choice! trt again");
        return important;
    }

    private static String createText() {
        System.out.println("please enter description of the reminder");
        String text=scanner.next();
        return text;
    }

    private static Calendar scannerExpiration() {
        System.out.println("please enter expiration\nThe year is:");
        int year = scanner.nextInt();
        System.out.println("The month is:");
        int month=scanner.nextInt();
        System.out.println("The day is:");
        int day=scanner.nextInt();
        System.out.println("The hour is:");
        int hour=scanner.nextInt();
        System.out.println("The minutes is:");
        int minutes=scanner.nextInt();
        Calendar calendar=Calendar.getInstance();
        calendar.set(year,month-1,day,hour,minutes,0);
        System.out.println(calendar.getTime());
        return calendar;

    }
}
