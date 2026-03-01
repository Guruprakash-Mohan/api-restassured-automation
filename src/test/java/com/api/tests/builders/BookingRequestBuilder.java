package com.api.tests.builders;

import com.api.framework.utils.DateUtils;
import com.api.tests.models.request.BookingDates;
import com.api.tests.models.request.BookingRequest;
import java.util.Random;

/**
 * Factory class for building BookingRequest test data.
 * Follows the Test Data Builder pattern.
 */
public class BookingRequestBuilder {

    private BookingRequestBuilder() {}

    /**
     * Returns a valid booking with sensible defaults.
     */
    public static BookingRequest validBooking() {
        int[] availableRooms = {1, 2, 3, 4, 5};
        int randomRoom = availableRooms[new Random()
                .nextInt(availableRooms.length)];

        return BookingRequest.builder()
                .roomid(randomRoom)
                .firstname("John")
                .lastname("Doe")
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin(DateUtils.futureDate(60))
                        .checkout(DateUtils.futureDate(63))
                        .build())
                .email("john.doe+" + System.currentTimeMillis() + "@example.com")
                .phone("12345617890")
                .build();
    }
}