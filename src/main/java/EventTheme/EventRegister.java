package EventTheme;

public interface EventRegister {
    void registerEvent(boolean rand);
    long getCountOfEventsForFirstPeriod();
    long getCountOfEventsForSecondPeriod();
    long getCountOfEventsForThirdPeriod();

}
