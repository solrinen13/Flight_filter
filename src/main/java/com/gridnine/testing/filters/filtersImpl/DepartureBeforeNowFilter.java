package com.gridnine.testing.filters.filtersImpl;

import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.testClasses.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeNowFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .toList();
    }
}
