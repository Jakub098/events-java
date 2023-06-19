package com.github.jakub098.ticketapp.controller;

import com.github.jakub098.ticketapp.model.EventType;
import com.github.jakub098.ticketapp.repository.EventTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EventTypeController {

    private static final Logger logger = LoggerFactory.getLogger(EventTypeController.class);
    private final EventTypeRepository repository;


    public EventTypeController(EventTypeRepository repository) {
        this.repository = repository;
    }

//        @GetMapping("/event-types")
//        List<EventType> getAllTasks() {
//            logger.warn("Reading all tasks");
//            return repository.findAll();
//        }
}
