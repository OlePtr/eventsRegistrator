package EventTheme;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static Common.Utils.*;

public class EventRegisterImpl implements EventRegister {
    private final Random random;
    private int key;
    private MapItem root;
    public ConcurrentHashMap treeMap;
    public int totalEvents;

    public EventRegisterImpl() {
        random = new Random();
        root = null;
        treeMap = new ConcurrentHashMap();
    }

    private long getCurrentTimeInMillis() {
        final Calendar data = Calendar.getInstance();
        return data.getTimeInMillis();
    }

    @Override
    public void registerEvent(boolean rand) {
        long timeInMillis = 0;
        synchronized (random) {
            if (rand == false) {
                timeInMillis = getCurrentTimeInMillis();
            } else {
                timeInMillis = RandomTimeGenerator.timegen();
            }
            removeFromPast(timeInMillis);
            final MapItem mapItem = new MapItem(timeInMillis, "String data container");
            for (int i = 0; i >= 0; ) {
                key = random.nextInt();
                if (treeMap.containsKey(key)) {
                    key = random.nextInt();
                    continue;
                } else {
                    treeMap.put(key, mapItem);
                    break;
                }
            }
        }
    }

    private void removeFromPast(long timeInMillis) {
        Set<Map.Entry<Long, MapItem>> entrySet = treeMap.entrySet();
        synchronized (entrySet) {
            for (Map.Entry<Long, MapItem> entry : entrySet) {
                long delta = (timeInMillis - timeReportPeriod3) - entry.getValue().eventDate;
                if (delta > 0) {
                    treeMap.remove(entry.getKey());
                } else {
                }
            }
        }
    }

    @Override
    public long getCountOfEventsForFirstPeriod() {
        int ret = 0;
        final long timeInMillis = getCurrentTimeInMillis();
        Set<Map.Entry<Long, MapItem>> entrySet = treeMap.entrySet();
        for (Map.Entry<Long, MapItem> entry : entrySet) {
            long timeDelta = entry.getValue().eventDate - (timeInMillis - timeReportPeriod1);
            if (timeDelta > 0) {
                ret++;
            } else {
            }
        }
        return ret;
    }

    @Override
    public long getCountOfEventsForSecondPeriod() {
        int ret = 0;
        final long timeInMillis = getCurrentTimeInMillis();
        Set<Map.Entry<Long, MapItem>> entrySet = treeMap.entrySet();
        for (Map.Entry<Long, MapItem> entry : entrySet) {
            long timeDelta = entry.getValue().eventDate - (timeInMillis - timeReportPeriod2);
            if (timeDelta > 0) {
                ret++;
            } else {
            }
        }
        return ret;
    }

    @Override
    public long getCountOfEventsForThirdPeriod() {
        int ret = 0;
        final long timeInMillis = getCurrentTimeInMillis();
        Set<Map.Entry<Long, MapItem>> entrySet = treeMap.entrySet();
        for (Map.Entry<Long, MapItem> entry : entrySet) {
            if (entry.getValue().eventDate > (timeInMillis - timeReportPeriod3)) {
                ret++;
            } else {
            }
        }
        return ret;
    }
}
