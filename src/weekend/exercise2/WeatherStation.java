package weekend.exercise2;


import java.util.ArrayList;

public class WeatherStation {
  private double temperature;
  private double humidity;
  private double barometricPressure;
  ArrayList<WeatherChangeListener> subscribersList = new ArrayList<>();

  private WeatherStation() {
    temperature = 0;
    humidity = 0;
    barometricPressure = 0;
  }


  public boolean changeWeatherParameters(double temperature, double humidity, double barometricPressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.barometricPressure = barometricPressure;
    notifyAllSubscribers();
    return true;
  }


  public void subscribe(WeatherChangeListener subscriber) {
    subscribersList.add(subscriber);
  }

  public void unSubscribe(WeatherChangeListener subscriber) {
    subscribersList.remove(subscriber);

  }

  private void notifyAllSubscribers() {
    for (WeatherChangeListener listener : subscribersList) {
      listener.notifyMe("Weather parameters changed");
    }
  }

}
