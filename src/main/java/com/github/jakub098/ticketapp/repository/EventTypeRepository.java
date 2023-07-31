package com.github.jakub098.ticketapp.repository;

import com.github.jakub098.ticketapp.model.EventType;
import com.github.jakub098.ticketapp.model.dto.EventTypeDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EventTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EventType> findAll() {
        String jpql = "SELECT e FROM EventType e";
        TypedQuery<EventType> query = entityManager.createQuery(jpql, EventType.class);

        return query.getResultList();
    }

    public EventType getEventType(Integer eventTypeId) {
        String jpql = "SELECT e FROM EventType e WHERE e.id = :eventTypeId";
        TypedQuery<EventType> query = entityManager.createQuery(jpql, EventType.class);
        query.setParameter("eventTypeId", eventTypeId);

        return query.getSingleResult();

    }
    @Transactional
    public void addEventType(EventTypeDto eventType) {
        entityManager.createNativeQuery("INSERT INTO event_type (name, description) VALUES (:name, :description)")
                .setParameter("name", eventType.getName())
                .setParameter("description",eventType.getDescription())
                .executeUpdate();

    }

    @Transactional
    public void deleteEventType(Integer eventTypeId) {
        entityManager.createNativeQuery("DELETE FROM event_type e WHERE e.id_event_type = :eventTypeId")
                .setParameter("eventTypeId", eventTypeId)
                .executeUpdate();

    }

    @Transactional
    public void updateEventType(EventType eventType) {
        entityManager.createNativeQuery("UPDATE event_type e SET e.name = :eventTypeName, e.description = :eventTypeDescription WHERE e.id_event_type = :eventTypeId")
                .setParameter("eventTypeId", eventType.getId())
                .setParameter("eventTypeName", eventType.getName())
                .setParameter("eventTypeDescription", eventType.getDescription())
                .executeUpdate();
    }
}
