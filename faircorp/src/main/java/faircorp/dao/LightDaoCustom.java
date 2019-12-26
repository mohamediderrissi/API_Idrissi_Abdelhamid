package faircorp.dao;

import com.emse.spring.faircorp.dto.LightDto;
import com.emse.spring.faircorp.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LightDaoCustom  {
    List<Light> findOnLights();

    // method to find the room lights when we send the id of the room
    public List<Light> findLightRoomById(Long id);
}