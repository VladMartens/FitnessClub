package org.it.spu.fitness;

public class TimeTableParse {
    private String nameDay;
    private String startTime;
    private String eventName;
    public String description;

    public TimeTableParse(String nameDay, String startTime, String eventName, String description) {
        this.nameDay = nameDay;
        this.startTime = startTime;
        this.eventName = eventName;
        this.description = description;
    }

    public String getNameDay() {
        return nameDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
