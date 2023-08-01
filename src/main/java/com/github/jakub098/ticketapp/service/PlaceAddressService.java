package com.github.jakub098.ticketapp.service;

import com.github.jakub098.ticketapp.model.PlaceAddress;
import com.github.jakub098.ticketapp.model.dto.PlaceAddressDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaceAddressService {

    List<PlaceAddress> list();
    PlaceAddress getById(Integer placeAddressId);
    void createPlaceAddress(PlaceAddressDto placeAddress);
    void updatePlaceAddress(PlaceAddress placeAddress);
    void deletePlaceAddress(Integer placeAddressId);
}
