package Common;

import EventTheme.EventRegisterImpl;

import static Common.Utils.testIterations;

public class Main {
    public static void main(String[] args) {
        EventRegisterImpl eventCounterImplMap = new EventRegisterImpl();
        for (int i = 0; i < testIterations; i++) {
            eventCounterImplMap.totalEvents++;
            eventCounterImplMap.registerEvent(false);
        }
        System.out.println("\t");
        System.out.println("Total events generated: " + eventCounterImplMap.totalEvents);
        System.out.println("\t");
        System.out.println("Case when time of events is sequentially generated..");
        System.out.println("Total events founded for first period: -->" + eventCounterImplMap.getCountOfEventsForFirstPeriod());
        System.out.println("Total events founded for second period: ->" + eventCounterImplMap.getCountOfEventsForSecondPeriod());
        System.out.println("Total events founded for third period: -->" + eventCounterImplMap.getCountOfEventsForThirdPeriod());

        eventCounterImplMap = new EventRegisterImpl();

        for (int i = 0; i < testIterations; i++) {
            eventCounterImplMap.registerEvent(true);
        }
        System.out.println("\t");
        System.out.println("Case when time of event is random generated..");
        System.out.println("Total events founded for first period (for now): -->" + eventCounterImplMap.getCountOfEventsForFirstPeriod());
        System.out.println("Total events founded for second period (for now): ->" + eventCounterImplMap.getCountOfEventsForSecondPeriod());
        System.out.println("Total events founded for third period (for now): -->" + eventCounterImplMap.getCountOfEventsForThirdPeriod());
    }
}
