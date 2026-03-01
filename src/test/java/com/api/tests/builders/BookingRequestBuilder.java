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
    private static int getUniqueOffset() {
        return (int)(System.currentTimeMillis() % 200) + 100;
    }

   /*     // Use timestamp to make dates unique every run!
        long uniqueOffset = (System.currentTimeMillis() % 100) + 90;

    public static BookingRequest validBooking() {
        int offset = getUniqueOffset();
        return BookingRequest.builder()
                .roomid(1)
                .firstname("John")
                .lastname("Doe")
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin(DateUtils.futureDate(offset))
                        .checkout(DateUtils.futureDate(offset + 3))
                        .build())
                .email("john.doe+" + System.currentTimeMillis() + "@example.com")
                .phone("12345617890")
                .build();
    }*/

    public static BookingRequest validBooking() {
        // Use wider room range - API supports up to 100+
        int randomRoom = new Random().nextInt(100) + 1;

        // Larger range = less chance of conflict!
        long uniqueOffset = (System.currentTimeMillis() % 200) + 200;

        return BookingRequest.builder()
                .roomid(randomRoom)
                .firstname("John")
                .lastname("Doe")
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin(DateUtils.futureDate((int) uniqueOffset))
                        .checkout(DateUtils.futureDate((int) uniqueOffset + 3))
                        .build())
                .email("john.doe+" + System.currentTimeMillis() + "@example.com")
                .phone("12345617890")
                .build();
    }

    public static BookingRequest updatedBooking(String checkin, String checkout) {
        return BookingRequest.builder()
                .roomid(1)
                .firstname("UpdatedName")
                .lastname("UpdatedLastname")
                .depositpaid(false)
                .bookingdates(BookingDates.builder()
                        .checkin(checkin)
                        .checkout(checkout)
                        .build())
                .email("updated+" + System.currentTimeMillis() + "@example.com")
                .phone("12345617890")
                .build();
    }
}