package com.sunjyot.home.challenge.grabcab.application;

import com.sunjyot.home.challenge.grabcab.application.dto.PositionDTO;
import com.sunjyot.home.challenge.grabcab.domain.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLDataException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @Test
    public void bookTestValidInput() throws SQLDataException, NoSuchFieldException {
        PositionDTO positionCloserToCabTwoDTO = new PositionDTO(1000000000000000001L,9L,7L,5L,5L);

        Booking booking = bookingService.book(positionCloserToCabTwoDTO);

        assertEquals(booking.getCabId(),1000000000000000002L);
    }

    @Test
    public void bookTestInvalidInput() throws SQLDataException, NoSuchFieldException {
        PositionDTO positionDTO = new PositionDTO(121212L,1L,2L,5L,5L);

        assertThrows(NoSuchFieldException.class, () -> bookingService.book(positionDTO));
    }

    @Test
    public void getUserBookingHistoryTestValidInput() throws NoSuchFieldException, SQLDataException {
        PositionDTO positionCloserToCabOneDTO = new PositionDTO(1000000000000000001L,1L,2L,5L,5L);
        Booking booking = bookingService.book(positionCloserToCabOneDTO);

        List<Booking> bookings = bookingService.getUserBookingHistory(1000000000000000001L);
        assertEquals(bookings.size(),1);
        assertEquals(bookings.get(0).getCabId(),1000000000000000001L);
        assertEquals(bookings.get(0).getFromXAxis(), 1L);
        assertEquals(bookings.get(0).getFromYAxis(), 2L);
        assertEquals(bookings.get(0).getToXAxis(), 5L);
        assertEquals(bookings.get(0).getToYAxis(), 5L);
    }

    @Test
    public void getUserBookingHistoryTestInvalidInput(){
        assertThrows(NoSuchFieldException.class,() -> bookingService.getUserBookingHistory(111111L));
    }
}
