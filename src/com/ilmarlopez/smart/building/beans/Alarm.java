package com.ilmarlopez.smart.building.beans;

public class Alarm {
    
	private int id;
    private String createdAt;
    private int teachingId;
    
    public Alarm() {}
    
    public Alarm(String createdAt, int teachingId) {
        this.createdAt = createdAt;
        this.teachingId = teachingId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the teachingId
     */
    public int getTeachingId() {
        return teachingId;
    }

    /**
     * @param teachingId the teachingId to set
     */
    public void setTeachingId(int teachingId) {
        this.teachingId = teachingId;
    }

}