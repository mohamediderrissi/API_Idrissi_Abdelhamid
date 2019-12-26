package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.dto.LightDto;
import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController  // 1.
@RequestMapping("/api/lights") // 2.
@Transactional // 3.
public class LightController {

    @Autowired
    private LightDao lightDao; // 4.
    @Autowired
    private RoomDao roomDao;


    @GetMapping // 5.
    public List<LightDto> findAll() {
        return lightDao
                .findAll()
                .stream()
                .map(LightDto::new)
                .collect(Collectors.toList());

    }

   @GetMapping(path = "/{id}")
    public LightDto findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDto(light)).orElse(null);
    }

   @PutMapping(path = "/{id}/switchOn")
    public LightDto switchOn(@PathVariable Long id) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setStatus(Status.ON);
        return new LightDto(light);
    }
    @PutMapping(path = "/{id}/switchOff")
    public LightDto switchOff(@PathVariable Long id) {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light.setStatus(Status.OFF);
        return new LightDto(light);
    }

    @PostMapping
    public LightDto create(@RequestBody LightDto dto) {
        Light light = null;
        if (dto.getId() != null) {
            light = lightDao.findById(dto.getId()).orElse(null);
        }

        if (light == null) {
            light = lightDao.save(new Light(dto.getLevel(), dto.getStatus(),roomDao.getOne(dto.getRoomId()),dto.getColor()));
        } else {
            light.setLevel(dto.getLevel());
            light.setStatus(dto.getStatus());
            light.setColor(dto.getColor());
            lightDao.save(light);
        }

        return new LightDto(light);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }


}
