package com.github.jakub098.ticketapp.repository;

import com.github.jakub098.ticketapp.model.PlaceAddress;
import com.github.jakub098.ticketapp.model.dto.PlaceAddressDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PlaceAddressRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<PlaceAddress> findAll() {
        String jpql = "SELECT p FROM PlaceAddress p";
        TypedQuery<PlaceAddress> query = entityManager.createQuery(jpql, PlaceAddress.class);

        return query.getResultList();
    }

    public PlaceAddress getPlaceAddress(Integer placeAddressId) {
        String jpql = "SELECT p FROM PlaceAddress p WHERE p.id = :placeAddressId";
        TypedQuery<PlaceAddress> query = entityManager.createQuery(jpql, PlaceAddress.class);
        query.setParameter("placeAddressId", placeAddressId);

        return query.getSingleResult();
    }

    @Transactional
    public void addPlaceAddress(PlaceAddressDto placeAddress) {
        entityManager.createNativeQuery("INSERT INTO place_address (street, number, postal_code, city) VALUES (:street, :number, :postalCode, :city)")
                .setParameter("street", placeAddress.getStreet())
                .setParameter("number",placeAddress.getNumber())
                .setParameter("postalCode",placeAddress.getPostalCode())
                .setParameter("city",placeAddress.getCity())
                .executeUpdate();
    }

    @Transactional
    public void updatePlaceAddress(PlaceAddress placeAddress) {
        entityManager.createNativeQuery("UPDATE place_address p SET p.street = :placeAddressStreet, p.number = :placeAddressNumber, p.postal_code = :placeAddressPostalCode, p.city = :placeAddressCity WHERE p.id_place_address = :placeAddressId")
                .setParameter("placeAddressId", placeAddress.getId())
                .setParameter("placeAddressStreet", placeAddress.getStreet())
                .setParameter("placeAddressNumber", placeAddress.getNumber())
                .setParameter("placeAddressPostalCode", placeAddress.getPostalCode())
                .setParameter("placeAddressCity", placeAddress.getCity())
                .executeUpdate();
    }

    @Transactional
    public void deletePlaceAddress(Integer placeAddressId) {
        entityManager.createNativeQuery("DELETE FROM place_address p WHERE p.id_place_address = :placeAddressId")
                .setParameter("placeAddressId", placeAddressId)
                .executeUpdate();
    }
}
