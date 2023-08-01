package com.github.jakub098.ticketapp.repository;

import com.github.jakub098.ticketapp.model.Place;
import com.github.jakub098.ticketapp.model.PlaceAddress;
import com.github.jakub098.ticketapp.model.dto.PlaceDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PlaceRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public List<Place> findAll() {
        String jpql = "SELECT p FROM Place p";
        TypedQuery<Place> query = entityManager.createQuery(jpql, Place.class);

        return query.getResultList();
    }

    public Place getPlace(Integer placeId) {
        String jpql = "SELECT p FROM Place p WHERE p.id = :placeId";
        TypedQuery<Place> query = entityManager.createQuery(jpql, Place.class);
        query.setParameter("placeId", placeId);

        return query.getSingleResult();
    }

    @Transactional
    public void addPlace(PlaceDto place) {
        entityManager.createNativeQuery("INSERT INTO place (name, capacity, id_place_address) VALUES (:name, :capacity, :idPlaceAddress);")
                .setParameter("name", place.getName())
                .setParameter("capacity",place.getCapacity())
                .setParameter("idPlaceAddress",place.getPlaceAddressId())
                .executeUpdate();
    }

    @Transactional
    public void updatePlace(Place place) {
        entityManager.createNativeQuery("UPDATE place p SET p.name = :name, p.capacity = :capacity, p.id_place_address = :idPlaceAddress;")
                .setParameter("name", place.getName())
                .setParameter("capacity",place.getCapacity())
                .setParameter("idPlaceAddress",place.getPlaceAddress())
                .executeUpdate();
    }

    @Transactional
    public void deletePlace(Integer placeId) {
        entityManager.createNativeQuery("DELETE FROM place p WHERE p.id_place = :placeId;")
                .setParameter("placeId", placeId)
                .executeUpdate();
    }
}
