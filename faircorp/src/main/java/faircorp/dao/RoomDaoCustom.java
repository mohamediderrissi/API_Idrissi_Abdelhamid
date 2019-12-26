package faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDaoCustom extends JpaRepository<Room, Long> {
    public Room findRoomByName(String name);
}
