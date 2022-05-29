package controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;


public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        Reading latestReading = StationAnalytics.getLatestReading(station.readings);
        station.fahrenheit = StationAnalytics.convertToFahrenheit(latestReading.temperature);
        station.beaufort = StationAnalytics.convertToBeaufort(latestReading.windSpeed);
        station.weather = StationAnalytics.getWeather(latestReading.code);
        station.windChill = StationAnalytics.getWindChill(latestReading.windSpeed,latestReading.temperature);
        station.direction = StationAnalytics.getWindDirection(latestReading.windDirection);
        station.icon = StationAnalytics.getIcon(latestReading.code);


        render("station.html", station, latestReading);
    }
    public static void addReading(Long id, int code, double temperature, double windSpeed, int windDirection, int pressure)
    {
        Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }
    public static void deleteReading (Long id, long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing " + station.name);
        station.readings.remove(reading);
        station.save();
        reading.delete();

        render("station.html", station);
    }


}