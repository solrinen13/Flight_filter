package com.gridnine.testing;

import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.filtersImpl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.filtersImpl.DepartureBeforeNowFilter;
import com.gridnine.testing.filters.filtersImpl.GroundTimeExceedsTwoHoursFilter;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterTests {
    @Test
    void testDepartureBeforeNowFilter() {
        FlightFilter departureFilter = new DepartureBeforeNowFilter();
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> filteredFlights = departureFilter.filter(flights);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    void testArrivalBeforeDepartureFilter() {
        FlightFilter arrivalFilter = new ArrivalBeforeDepartureFilter();
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> filteredFlights = arrivalFilter.filter(flights);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    void testGroundTimeExceedsTwoHoursFilter() {
        FlightFilter groundTimeFilter = new GroundTimeExceedsTwoHoursFilter();
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> filteredFlights = groundTimeFilter.filter(flights);
        assertEquals(4, filteredFlights.size());
    }
}
