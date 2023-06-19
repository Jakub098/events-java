package com.github.jakub098.ticketapp.repository;

import com.github.jakub098.ticketapp.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Integer> {
}
