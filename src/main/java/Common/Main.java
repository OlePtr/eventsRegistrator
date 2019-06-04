package Common;

import EventTheme.EventRegisterImpl;

import static Common.Utils.testIterations;

public class Main {
    public static void main(String[] args) {
        EventRegisterImpl eventRegister = new EventRegisterImpl();
        for (int i = 0; i < testIterations; i++) {
            eventRegister.totalEvents++;
            eventRegister.registerEvent(false);
        }
        System.out.println("\t");
        System.out.println("Total events generated: " + eventRegister.totalEvents);
        System.out.println("\t");
        System.out.println("Case when time of events is sequentially generated..");
        System.out.println("Total events founded for first period: -->" + eventRegister.getCountOfEventsForFirstPeriod());
        System.out.println("Total events founded for second period: ->" + eventRegister.getCountOfEventsForSecondPeriod());
        System.out.println("Total events founded for third period: -->" + eventRegister.getCountOfEventsForThirdPeriod());

        eventRegister = new EventRegisterImpl();

        for (int i = 0; i < testIterations; i++) {
            eventRegister.registerEvent(true);
        }
        System.out.println("\t");
        System.out.println("Case when time of event is random generated..");
        System.out.println("Total events founded for first period (for now): -->" + eventRegister.getCountOfEventsForFirstPeriod());
        System.out.println("Total events founded for second period (for now): ->" + eventRegister.getCountOfEventsForSecondPeriod());
        System.out.println("Total events founded for third period (for now): -->" + eventRegister.getCountOfEventsForThirdPeriod());
    }
}
