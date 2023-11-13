package com.gridnine.testing;

import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.filtersImpl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.filtersImpl.DepartureBeforeNowFilter;
import com.gridnine.testing.filters.filtersImpl.GroundTimeExceedsTwoHoursFilter;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Flights before filtering:");
        flights.forEach(System.out::println);

        FlightFilter departureFilter = new DepartureBeforeNowFilter();
        FlightFilter arrivalFilter = new ArrivalBeforeDepartureFilter();
        FlightFilter groundTimeFilter = new GroundTimeExceedsTwoHoursFilter();

        List<Flight> filteredFlights;

        filteredFlights = departureFilter.filter(flights);
        printFilteredFlights("Flights after departure filter:", filteredFlights);

        filteredFlights = arrivalFilter.filter(flights);
        printFilteredFlights("Flights after arrival filter:", filteredFlights);

        filteredFlights = groundTimeFilter.filter(flights);
        printFilteredFlights("Flights after ground time filter:", filteredFlights);

    }

    private static void printFilteredFlights(String message, List<Flight> flights) {
        System.out.println(message);
        flights.forEach(System.out::println);
        System.out.println();

    }
}