package com.github.jakub098.ticketapp.service;

import com.github.jakub098.ticketapp.model.EventType;
import com.github.jakub098.ticketapp.model.dto.EventTypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventTypeService {

    List<EventType> list();
    EventType getById(Integer eventTypeId);
    void createEventType(EventTypeDto eventType);
    void deleteEventType(Integer eventTypeId);
    void updateEventType(EventType eventType);
}
