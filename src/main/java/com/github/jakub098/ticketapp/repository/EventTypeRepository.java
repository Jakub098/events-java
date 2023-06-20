package com.github.jakub098.ticketapp.repository;

import com.github.jakub098.ticketapp.model.EventType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTypeRepository {
    List<EventType> list();
}
