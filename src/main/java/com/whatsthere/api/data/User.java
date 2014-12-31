package com.whatsthere.api.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by guyk on 11/9/14.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;
    private String faceBookId;

    @Column
    public String getUserId() {
        return userId;
    }

    @Column
    public String getFaceBookId() {
        return faceBookId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFaceBookId(String faceBookId) {
        this.faceBookId = faceBookId;
    }
}
