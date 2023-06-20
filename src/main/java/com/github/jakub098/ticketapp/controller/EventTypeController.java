package com.github.jakub098.ticketapp.controller;

import com.github.jakub098.ticketapp.model.EventType;
import com.github.jakub098.ticketapp.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    public EventTypeController() {}

    @RequestMapping(value = "/event-types", method = RequestMethod.GET)
    public List<EventType> list() {
        return  eventTypeService.getEventTypes();
    }
}
