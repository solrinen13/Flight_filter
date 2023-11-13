package com.gridnine.testing.filters.filtersImpl;

import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.testClasses.Flight;

import java.util.List;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .toList();
    }
}
