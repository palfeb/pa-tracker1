package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.*;


public class InMemoryTimeEntryRepository implements  TimeEntryRepository {
    private Map<Long,TimeEntry> savedTimeEntires = new HashMap<Long,TimeEntry>();
    private Long defaultTimeEntryId = 1L;
    public TimeEntry create(TimeEntry timeEntry) {
        if(timeEntry.getId() == null){
            timeEntry.id = defaultTimeEntryId;
            savedTimeEntires.put(defaultTimeEntryId,timeEntry);
            defaultTimeEntryId ++;
            return timeEntry;
        }else {
            savedTimeEntires.put(timeEntry.getId(), timeEntry);
            return timeEntry;
        }

    }


    public TimeEntry find(long timeEntryId) {
        return savedTimeEntires.get(timeEntryId);
    }

   /* public TimeEntry find(Long id) {

        return savedTimeEntires.get(id);
    }*/

    public List<TimeEntry> list() {
        List returnList = new LinkedList();
         returnList.addAll(savedTimeEntires.values());
        return returnList;
    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        if(savedTimeEntires.get(eq) != null){
            TimeEntry entry =  savedTimeEntires.get(eq);
            entry.projectId = any.projectId;
            entry.date = any.date;
            entry.userId = any.userId;
            entry.hours = any.hours;
            return savedTimeEntires.get(eq);
        }else{
            /*TimeEntry entry = new TimeEntry();
            entry.id = eq;
            entry.projectId = any.projectId;
            entry.date = any.date;
            entry.userId = any.userId;
            entry.hours = any.hours;
            savedTimeEntires.put(eq,entry);*/
            return null;
        }

    }

    @Override
    public void delete(long id) {
        TimeEntry entryToRemove = null;
        for(TimeEntry entry:savedTimeEntires.values()){
            if(entry.id == id){
                entryToRemove = entry;
                break;
            }
        }
        if(entryToRemove != null){
            savedTimeEntires.remove(id);
        }
    }
}
