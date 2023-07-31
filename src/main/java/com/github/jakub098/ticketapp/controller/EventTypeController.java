package com.github.jakub098.ticketapp.controller;

import com.github.jakub098.ticketapp.model.EventType;
import com.github.jakub098.ticketapp.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public EventType getById(@RequestParam(value = "eventTypeId") Integer eventTypeId) {
        return eventTypeService.getById(eventTypeId);
    }
}
