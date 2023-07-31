package com.github.jakub098.ticketapp.controller;

import com.github.jakub098.ticketapp.model.EventType;
import com.github.jakub098.ticketapp.model.dto.EventTypeDto;
import com.github.jakub098.ticketapp.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    @RequestMapping(value = "/event-types", method = RequestMethod.GET)
    public List<EventType> list() {
        return  eventTypeService.list();
    }

    @RequestMapping(value = "/event-type", method = RequestMethod.GET)
    public EventType getById(@RequestParam Integer eventTypeId) {
        return eventTypeService.getById(eventTypeId);
    }

    @RequestMapping(value = "/event-type", method = RequestMethod.POST)
    public void addEventType(@RequestBody EventTypeDto eventType) {
        eventTypeService.createEventType(eventType);
    }

    @RequestMapping(value = "/event-type", method = RequestMethod.DELETE)
    public void deleteEventType(@RequestParam Integer eventTypeId) {
        eventTypeService.deleteEventType(eventTypeId);
    }

    @RequestMapping(value = "/event-type", method = RequestMethod.PUT)
    public void updateEventType(@RequestBody EventType eventType) {
        eventTypeService.updateEventType(eventType);
    }

}
