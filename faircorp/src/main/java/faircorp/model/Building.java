package faircorp.model;

import com.emse.spring.faircorp.model.Room;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Building {

        @Id
        @GeneratedValue
        private Long id;

        @Column
        private String name;

        @JsonManagedReference
        @OneToMany(mappedBy = "building", cascade = CascadeType.REMOVE)
        List<com.emse.spring.faircorp.model.Room> rooms;

    public Building(){

    }
    public Building(String name, List<com.emse.spring.faircorp.model.Room> rooms){
        this.name = name;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.emse.spring.faircorp.model.Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
