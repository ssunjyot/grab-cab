package com.sunjyot.home.challenge.grabcab.infrastructure;

import com.sunjyot.home.challenge.grabcab.application.BookingService;
import com.sunjyot.home.challenge.grabcab.application.dto.PositionDTO;
import com.sunjyot.home.challenge.grabcab.domain.Booking;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@Log4j
@Api(description = "API endpoints to make bookings and check booking history")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @ApiOperation(value = "Book the nearest unoccupied cab given a User ID, source and destination(Represented as X and Y co-ordinates)")
    @RequestMapping(path = "/book", method = RequestMethod.POST)
    public ResponseEntity book(@Validated @RequestBody PositionDTO position){
        try {
            Booking booking = bookingService.book(position);
            return ResponseEntity.ok("You have successfully booked cab number : " + booking.getCabId());
        } catch (Exception e) {
            if (e.getClass() == SQLDataException.class)
                return ResponseEntity.ok("There are no cabs available at this time! Please retry later...");
            else
                return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Fetch booking history for a given User ID")
    @RequestMapping(path = "/user/history", method = RequestMethod.GET)
    public ResponseEntity bookingHistory(Long userId){
        try {
            List<Booking> bookings = bookingService.getUserBookingHistory(userId);

            if(bookings.isEmpty())
                return  ResponseEntity.ok("User has not made any bookings yet!");

            return ResponseEntity.ok(bookings);
        } catch (NoSuchFieldException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
