package com.example.messaging_application;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MessageListModel {
    private String profile;
    private String name ;
    private String message;
    private long time_millis ;

    public MessageListModel(String profile, String name, String message, long time_millis) {
        this.profile = profile;
        this.name = name;
        this.message = message;
        this.time_millis = time_millis;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime_millis() {
        return time_millis;
    }

    public void setTime_millis(long time_millis) {
        this.time_millis = time_millis;
    }
    public String getTimeString(){
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(this.time_millis);//get recieved time
        final String timeString1 =
                new SimpleDateFormat("dd-M-yy HH:mm").format(cal.getTime());
        final String timeString2 =
                new SimpleDateFormat("dd-M-yy HH:mm").format(new Date().getTime());
        int diff = Integer.parseInt(timeString2.substring(0, 2)) - Integer.parseInt(timeString1.substring(0, 2));

        if (diff < 1) {
            System.out.println(timeString1);
            return timeString1.trim().substring(8);
        } else if (diff >= 1) {
            return timeString1.trim().substring(0, 8);
        }
        return "";
    }
}
