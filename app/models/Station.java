package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name;
  public double lat;
  public double lng;

  public String weather;
  public double fahrenheit;
  public int beaufort;
  public double windChill;
  public String direction;
  public String icon;



  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList
          <Reading>();

  public Station(String name, double lat, double lng, String weather, double fahrenheit, int beaufort, double windChill, String direction, String icon) {
    this.name = name;
    this.lat = lat;
    this.lng = lng;
    this.weather = weather;
    this.fahrenheit = fahrenheit;
    this.beaufort = beaufort;
    this.windChill = windChill;
    this.direction = direction;
    this.icon = icon;



  }

}