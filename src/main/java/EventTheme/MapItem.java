package EventTheme;

public class MapItem {
    public long eventDate = 0;
    public String eventName = null;
    public Character eventType = null;

    public MapItem (long timeInMillis, String eventName) {
        this.eventDate = timeInMillis;
        this.eventName = eventName;
        this.eventType = 'A';
    }
}