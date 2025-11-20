package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private EventRepository repository;

    @Transactional(readOnly = true)
    public Page<EventDTO> findAll(Pageable pageable) {
        Page<Event> result = repository.findAll(pageable);
        return result.map(EventDTO::new);
    }

    @Transactional
    public EventDTO insert(EventDTO dto) {
        Event entity = copyDtoToEntity(dto);
        entity = repository.save(entity);
        return new EventDTO(entity);
    }

    private Event copyDtoToEntity(EventDTO dto) {
        City city = cityRepository.getReferenceById(dto.getCityId());
        return new Event(null, dto.getName(), dto.getDate(), dto.getUrl(), city);
    }
}
