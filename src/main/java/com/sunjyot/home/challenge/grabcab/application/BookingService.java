package com.sunjyot.home.challenge.grabcab.application;

import com.sunjyot.home.challenge.grabcab.application.dto.PositionDTO;
import com.sunjyot.home.challenge.grabcab.application.repository.BookingJdbcRepository;
import com.sunjyot.home.challenge.grabcab.application.repository.CabJdbcRepository;
import com.sunjyot.home.challenge.grabcab.domain.Booking;
import com.sunjyot.home.challenge.grabcab.domain.Cab;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Log4j
public class BookingService {

    @Autowired
    private BookingJdbcRepository bookingJdbcRepository;

    @Autowired
    private CabJdbcRepository cabJdbcRepository;

    public Booking book(PositionDTO position) {
        Long userId = position.getUserId();

        Long fromXAxis = position.getFromXAxis();
        Long fromYAxis = position.getFromYAxis();
        Long toXAxis = position.getToXAxis();
        Long toYAxis = position.getToYAxis();

        List<Cab> cabs = cabJdbcRepository.getAvailableCabs();

        Cab selectedCab = cabs.get(0);
        selectedCab.setOccupied(true);

        cabJdbcRepository.update(selectedCab);

        Booking booking = new Booking(Math.abs(new Random().nextLong()), userId, selectedCab.getId(), fromXAxis, fromYAxis, toXAxis, toYAxis);

        log.info(booking.getCabId());
        bookingJdbcRepository.insert(booking);

        return booking;
    }
}
