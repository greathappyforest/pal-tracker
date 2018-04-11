package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long,TimeEntry> db = new HashMap();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id = (long)this.db.size()+1;
        TimeEntry entry = timeEntry.update(id);
        db.put(id,entry);
        return entry;
    }

    @Override
    public TimeEntry find(long id) {

        System.out.println(id + " " + db.get(id));
        this.printDb();
        return db.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> list = new ArrayList();
        for(long id:db.keySet()){
            list.add(db.get(id));
        }
        return list;
    }

    @Override
    public TimeEntry update(long id, TimeEntry entry) {
        db.put(id,entry.update(id));
        return db.get(id);
    }

    @Override
    public TimeEntry delete(long id) {
        TimeEntry entry = db.get(id);
        db.remove(id);
        return entry;
    }

    public void printDb(){
        System.out.println("***********PRINT DB *************");
        for(long id:db.keySet()){
            System.out.println(db.get(id).toString());
        }
    }
}
