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
        List<Cab> cabs = cabJdbcRepository.getAvailableCabs();

        Cab selectedCab = findNearestCab(cabs, position.getFromXAxis(), position.getFromYAxis());
        selectedCab.setOccupied(true);

        cabJdbcRepository.update(selectedCab);

        Booking booking = new Booking(
                Math.abs(new Random().nextLong()),
                position.getUserId(),
                selectedCab.getId(),
                position.getFromXAxis(),
                position.getFromYAxis(),
                position.getToXAxis(),
                position.getToYAxis());

        bookingJdbcRepository.insert(booking);

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
}
