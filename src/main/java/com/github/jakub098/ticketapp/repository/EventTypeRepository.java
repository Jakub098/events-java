package com.github.jakub098.ticketapp.repository;

import com.github.jakub098.ticketapp.model.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EventType> findAll() {
        String jpql = "SELECT c FROM EventType c";
        TypedQuery<EventType> query = entityManager.createQuery(jpql, EventType.class);

        return query.getResultList();
    }

    public EventType getEventType(Integer eventTypeId) {
        String jpql = "SELECT c FROM EventType c WHERE c.id = :eventTypeId";
        TypedQuery<EventType> query = entityManager.createQuery(jpql, EventType.class);
        query.setParameter("eventTypeId", eventTypeId);

        return query.getSingleResult();

    }
}
