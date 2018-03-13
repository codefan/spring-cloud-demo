package com.centit.demo.servicehi;

import java.util.Date;

public class SayHello {
    private String userName;
    private String greetingWords;
    private int     fromPort;
    private Date greetingTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGreetingWords() {
        return greetingWords;
    }

    public void setGreetingWords(String greetingWords) {
        this.greetingWords = greetingWords;
    }

    public int getFromPort() {
        return fromPort;
    }

    public void setFromPort(int fromPort) {
        this.fromPort = fromPort;
    }

    public Date getGreetingTime() {
        return greetingTime;
    }

    public void setGreetingTime(Date greetingTime) {
        this.greetingTime = greetingTime;
    }
}
