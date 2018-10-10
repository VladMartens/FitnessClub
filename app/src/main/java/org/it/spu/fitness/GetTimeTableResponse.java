package org.it.spu.fitness;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTimeTableResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class ScheduleEvent {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public class Day {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("attribute")
        @Expose
        private Integer attribute;
        @SerializedName("nameDay")
        @Expose
        private String nameDay;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAttribute() {
            return attribute;
        }

        public void setAttribute(Integer attribute) {
            this.attribute = attribute;
        }

        public String getNameDay() {
            return nameDay;
        }

        public void setNameDay(String nameDay) {
            this.nameDay = nameDay;
        }

    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("day")
        @Expose
        private Day day;
        @SerializedName("starttime")
        @Expose
        private String starttime;
        @SerializedName("scheduleEvent")
        @Expose
        private ScheduleEvent scheduleEvent;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public ScheduleEvent getScheduleEvent() {
            return scheduleEvent;
        }

        public void setScheduleEvent(ScheduleEvent scheduleEvent) {
            this.scheduleEvent = scheduleEvent;
        }

    }
}
