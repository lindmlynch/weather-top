package utils;

import models.Reading;

import java.util.*;


public class StationAnalytics {
    public static Reading getLatestReading(List<Reading> readings) {
        Reading latestReading = null;
        if (readings.size() > 0) {
            latestReading = readings.get(readings.size() - 1);
        }
        return latestReading;
    }

    public static double convertToFahrenheit(double temperature) {
        double fahrenheit = 0;
        fahrenheit = ((temperature * 9) / 5) + 32;
        return fahrenheit;
    }


    public static String getWeather(int code) {
        HashMap<Integer, String> weatherConditions = new HashMap<Integer, String>();
        weatherConditions.put(100, "Clear");
        weatherConditions.put(200, "Partial Clouds");
        weatherConditions.put(300, "Cloudy");
        weatherConditions.put(400, "Light Showers");
        weatherConditions.put(500, "Heavy Showers");
        weatherConditions.put(600, "Rain");
        weatherConditions.put(700, "Snow");
        weatherConditions.put(800, "Thunder");

        String weather = weatherConditions.get(code);
        return weather;

    }

    public static int convertToBeaufort(double windSpeed) {
        int beaufort = 0;
        if (windSpeed == 1) {
            return 0;
        }
        if (windSpeed > 1 && windSpeed <=5) {
            return 1;
        }
        if (windSpeed >= 6 && windSpeed <=11) {
            return 2;
        }
        if (windSpeed >= 12 && windSpeed <=19) {
            return 3;
        }
        if (windSpeed >= 20 && windSpeed <=28) {
            return 4;
        }
        if (windSpeed >= 29 && windSpeed <=38) {
            return 5;
        }
        if (windSpeed >= 39 && windSpeed <=49) {
            return 6;
        }
        if (windSpeed >= 50 && windSpeed <=61) {
            return 7;
        }
        if (windSpeed >= 62 && windSpeed <=74) {
            return 8;
        }
        if (windSpeed >= 75 && windSpeed <=88) {
            return 9;
        }
        if (windSpeed >= 89 && windSpeed <=102) {
            return 10;
        }
        if (windSpeed >= 103 && windSpeed <=117) {
            return 11;
        }
        return beaufort;


    }
    public static double getWindChill(double temperature, double windSpeed) {
        double windChill = 0;

        windChill = 13.12 + 0.6215*temperature - 11.37*Math.pow(windSpeed, 0.16)+0.3965*temperature*Math.pow(windSpeed, 0.16);
        return windChill;
    }

    public static String getWindDirection (double windDirection) {
        String direction = null;
        if ((windDirection >= 348.75 && windDirection <= 360) || ( windDirection >= 0 && windDirection <= 11.25) ) {
            direction = "N";
        }
        else if (windDirection >= 11.25 && windDirection <= 33.75) {
            direction = "NNE";
        }
        else if (windDirection >= 33.75 && windDirection <= 56.25) {
            direction = "NE";
        }
        else if (windDirection >= 56.25 && windDirection <= 78.75) {
            direction = "ENE";
        }
        else if (windDirection >= 78.75 && windDirection <= 101.25) {
            direction = "E";
        }
        else if (windDirection >= 101.25 && windDirection <= 123.75) {
            direction = "ESE";
        }
        else if (windDirection >= 123.75 && windDirection <= 146.25) {
            direction = "SE";
        }
        else if (windDirection >= 146.25 && windDirection <= 168.75) {
            direction = "SSE";
        }
        else if (windDirection >= 168.75 && windDirection <= 191.25) {
            direction = "S";
        }
        else if (windDirection >= 191.25 && windDirection <= 213.75) {
            direction = "SSW";
        }
        else if (windDirection >= 213.75 && windDirection <= 236.25) {
            direction = "SW";
        }
        else if (windDirection >= 236.25 && windDirection <= 258.75) {
            direction = "WSW";
        }
        else if (windDirection >= 258.75 && windDirection <= 281.25) {
            direction = "W";
        }
        else if (windDirection >= 281.25 && windDirection <= 303.75) {
            direction = "WNW";
        }
        else if (windDirection >= 303.75 && windDirection <= 326.25) {
            direction = "NW";
        }
        else if (windDirection >= 326.25 && windDirection <= 348.75) {
            direction = "NNW";
        }
        else {
            return "error";
        }
        return direction;

    }

    public static String getIcon(int code) {
        HashMap<Integer, String> icons = new HashMap<Integer, String>();
        icons.put(100, "<i class=\"sun icon\"></i>");
        icons.put(200, "<i class=\"cloud sun icon\"></i>");
        icons.put(300, "<i class=\"cloud icon\"></i>");
        icons.put(400, "<i class=\"cloud sun rain icon\"></i>");
        icons.put(500, "<i class=\"cloud showers heavy icon\"></i>");
        icons.put(600, "<i class=\"cloud rain icon\"></i>");
        icons.put(700, "<i class=\"snowflake icon\"></i>");
        icons.put(800, "<i class=\"bolt icon\"></i>");

        String icon = icons.get(code);
        return icon;

    }
}