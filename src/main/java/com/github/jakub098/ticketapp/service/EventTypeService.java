package com.github.jakub098.ticketapp.service;

import com.github.jakub098.ticketapp.model.EventType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventTypeService {

    List<EventType> list();
}
