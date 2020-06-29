package com.sunjyot.home.challenge.grabcab.application;

import com.sunjyot.home.challenge.grabcab.application.dto.PositionDTO;
import com.sunjyot.home.challenge.grabcab.application.repository.BookingRepository;
import com.sunjyot.home.challenge.grabcab.application.repository.CabRepository;
import com.sunjyot.home.challenge.grabcab.domain.Booking;
import com.sunjyot.home.challenge.grabcab.domain.Cab;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
@Log4j
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CabRepository cabRepository;

    public Booking book(PositionDTO position) {
        List<Cab> cabs = cabRepository.getAvailableCabs();

        Cab selectedCab = findNearestCab(cabs, position.getFromXAxis(), position.getFromYAxis());
        selectedCab.setOccupied(true);

        cabRepository.update(selectedCab);

        Booking booking = new Booking(
                Math.abs(new Random().nextLong()),
                position.getUserId(),
                selectedCab.getId(),
                position.getFromXAxis(),
                position.getFromYAxis(),
                position.getToXAxis(),
                position.getToYAxis(),
                new Timestamp(System.currentTimeMillis()));

        bookingRepository.insert(booking);

        return booking;
    }

    public Cab findNearestCab(List<Cab> cabs, Long fromXAxis, Long fromYAxis){
        Long minDistance = Long.MAX_VALUE;
        Cab nearestCab = null;

        for (Cab currentCab : cabs){
            Long distance = ((Double) Math.sqrt(
                    Math.pow(((Long) Math.abs(fromXAxis - currentCab.getXAxis())).doubleValue(), 2D)
                            + Math.pow(((Long) Math.abs(fromYAxis - currentCab.getYAxis())).doubleValue(), 2D)
            )).longValue();

            if(distance<minDistance){
                minDistance = distance;
                nearestCab = currentCab;
            }
        }

        return nearestCab;
    }

    public List<Booking> getUserBookingHistory(Long userId) {
        return bookingRepository.getUserBookingHistory(userId);
    }
}
