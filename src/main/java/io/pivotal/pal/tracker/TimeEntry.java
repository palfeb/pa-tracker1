package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TimeEntry implements Serializable {

    public Long id;
    public long projectId;
    public long userId;
    public LocalDate date;
    public int hours;



    public TimeEntry(long projectId, long userId, LocalDate parse, int hour) {

        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.hours = hour;

    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int hour) {

        this.projectId = projectId;
        this.userId = userId;
        this.date = parse;
        this.id = timeEntryId;
        this.hours = hour;



    }

    public TimeEntry() {

    }


    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return Objects.equals(id, timeEntry.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
