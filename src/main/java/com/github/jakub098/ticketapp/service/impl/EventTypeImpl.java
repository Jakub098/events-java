package com.github.jakub098.ticketapp.service.impl;

import com.github.jakub098.ticketapp.model.EventType;
import com.github.jakub098.ticketapp.repository.EventTypeRepository;
import com.github.jakub098.ticketapp.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeImpl implements EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public List<EventType> getEventTypes() {
        return eventTypeRepository.list();
    }
}
