package com.example.jsea;

import java.time.LocalDate;
import java.util.Date;

public class Trip{
    private String Route;
    private String boat;
    private LocalDate date = LocalDate.now();

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if(date.isAfter(this.date))
            this.date = date;
    }

    public Trip(String route, LocalDate date, String boat) {
        Route = route;
        this.boat = boat;
        setDate(date);
    }

    @Override
    public String toString() {
        return boat+", "+getRoute()+", "+getDate();
    }
}
