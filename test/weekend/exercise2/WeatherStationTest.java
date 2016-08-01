package weekend.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class WeatherStationTest {
@Test
  public void shouldBeAbleToChangeParametersOfWeather(){
  WeatherStation station=new WeatherStation();
  Assert.assertEquals(true,station.changeWeatherParameters(10.0,50.0,60.0));
}
@Test
public void shouldBeAbleToRegisterSubscriber(){
  WeatherStation station=new WeatherStation();
  DummySubscriber subscriber = new DummySubscriber();
  station.subscribe(subscriber);
  station.changeWeatherParameters(20,30,40);
  Assert.assertEquals(true,subscriber.wasNotified);
}
@Test
public void shouldBeAbleToSubscribeMultiplePeople(){
  WeatherStation station=new WeatherStation();
  DummySubscriber firstSubscriber = new DummySubscriber();
  DummySubscriber secondSubscriber = new DummySubscriber();
  DummySubscriber thirdSubscriber = new DummySubscriber();
  station.subscribe(firstSubscriber);
  station.subscribe(secondSubscriber);
  station.subscribe(thirdSubscriber);
  station.changeWeatherParameters(20,30,40);
  Assert.assertEquals(true,firstSubscriber.wasNotified);
  Assert.assertEquals(true,secondSubscriber.wasNotified);
  Assert.assertEquals(true,thirdSubscriber.wasNotified);
}

@Test
public void shouldBeAbleToUnSubscribeUser(){
  WeatherStation station=new WeatherStation();
  DummySubscriber firstSubscriber = new DummySubscriber();
  DummySubscriber secondSubscriber = new DummySubscriber();
  DummySubscriber thirdSubscriber = new DummySubscriber();
  station.subscribe(firstSubscriber);
  station.subscribe(secondSubscriber);
  station.subscribe(thirdSubscriber);
  station.changeWeatherParameters(20,30,40);
  Assert.assertEquals(true,firstSubscriber.wasNotified);
  Assert.assertEquals(true,secondSubscriber.wasNotified);
  Assert.assertEquals(true,thirdSubscriber.wasNotified);
  station.unSubscribe(thirdSubscriber);
  station.changeWeatherParameters(20,30,40);
  Assert.assertEquals(false,thirdSubscriber.wasNotified);

}

  public class DummySubscriber implements WeatherChangeListener{
    boolean wasNotified;
    public void notifyMe(String notification){
      wasNotified=true;
    }
  }

}
