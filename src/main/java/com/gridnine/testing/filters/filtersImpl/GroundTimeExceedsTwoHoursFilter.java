package com.gridnine.testing.filters.filtersImpl;

import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.testClasses.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    int segmentsCount = flight.getSegments().size();
                    for (int i = 1; i < segmentsCount; i++) {
                        LocalDateTime arrival = flight.getSegments().get(i - 1).getArrivalDate();
                        LocalDateTime departure = flight.getSegments().get(i).getDepartureDate();
                        if (arrival.plusHours(2).isAfter(departure)) {
                            return false;
                        }
                    }
                    return true;
                })
                .toList();
    }
}
