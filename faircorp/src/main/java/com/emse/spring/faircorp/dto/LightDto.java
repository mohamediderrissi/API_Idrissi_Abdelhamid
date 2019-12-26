package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Status;

public class LightDto {

        private  Long id;
        private  Integer level;
        private  Status status;
        private Long roomId;
        private Integer color;

        public LightDto() {
        }

        public LightDto(Light light) {
            this.id = light.getId();
            this.level = light.getLevel();
            this.status = light.getStatus();
            this.roomId = light.getRoom().getId();
            this.color = light.getColor();
        }


    public Long getId() {
            return id;
        }

        public Integer getLevel() {
            return level;
        }

        public Status getStatus() {
            return status;
        }

    public Long getRoomId() {
        return roomId;
    }

    public Integer getColor() {
        return color;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

}

