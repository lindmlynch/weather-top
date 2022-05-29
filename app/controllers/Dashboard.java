package controllers;

import java.util.List;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }
  public static void addStation (String name, double lat, double lng,String weather, double fahrenheit, int beaufort, double windChill, String direction, String icon)
  {
    Logger.info("Adding a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = new Station (name, lat, lng, weather, fahrenheit, beaufort, windChill, direction, icon);
    member.stations.add(station);
    member.save();
    redirect ("/dashboard");
  }
  public static void deleteStation (Long id)
  {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }
}
