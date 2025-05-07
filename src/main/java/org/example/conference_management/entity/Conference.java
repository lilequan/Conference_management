package org.example.conference_management.entity;

import java.io.Serializable;

public class Conference implements Serializable {
    private int conferenceId;
    private String conferenceName;
    private int convenerId;

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public int getConvenerId() {
        return convenerId;
    }

    public void setConvenerId(int convenerId) {
        this.convenerId = convenerId;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "conferenceId=" + conferenceId +
                ", conferenceName='" + conferenceName + '\'' +
                ", convenerId=" + convenerId +
                '}';
    }
}
