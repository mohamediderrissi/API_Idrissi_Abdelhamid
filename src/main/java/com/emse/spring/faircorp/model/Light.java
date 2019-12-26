package com.emse.spring.faircorp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "LIGHT")
public class Light {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer level;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Integer color;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "room_Id" , referencedColumnName = "id")
    Room room;

    public Light() {
    }

    public Light(Integer level, Status status, Room room, Integer color) {
        this.level = level;
        this.status = status;
        this.room = room;
        this.color = color;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
