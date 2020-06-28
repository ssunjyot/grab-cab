package com.sunjyot.home.challenge.grabcab.infrastructure;

import com.sunjyot.home.challenge.grabcab.application.BookingService;
import com.sunjyot.home.challenge.grabcab.application.dto.PositionDTO;
import com.sunjyot.home.challenge.grabcab.domain.Booking;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(path = "/book", method = RequestMethod.POST)
    public ResponseEntity book(@RequestBody PositionDTO position){
        Booking booking = bookingService.book(position);
        return ResponseEntity.ok(booking.toString());
    }

}
