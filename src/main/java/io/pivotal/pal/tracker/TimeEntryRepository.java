package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry) ;
    public TimeEntry find(Long id) ;

    public List<TimeEntry> list();

    public TimeEntry update(Long id, TimeEntry timeEntry) ;

    public void delete(Long id) ;
}
