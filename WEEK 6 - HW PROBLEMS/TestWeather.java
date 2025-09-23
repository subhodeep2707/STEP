class Weather {
    Weather() { System.out.println("Weather created"); }
    void forecast() { System.out.println("General weather forecast"); }
}

class Storm extends Weather {
    Storm() { super(); System.out.println("Storm created"); }
    void forecast() { System.out.println("Storm forecast"); }
}

class Thunderstorm extends Storm {
    Thunderstorm() { super(); System.out.println("Thunderstorm created"); }
    void forecast() { System.out.println("Thunderstorm forecast"); }
}

class Sunshine extends Weather {
    Sunshine() { super(); System.out.println("Sunshine created"); }
    void forecast() { System.out.println("Sunny forecast"); }
}

public class TestWeather {
    public static void main(String[] args) {
        Weather[] weathers = {new Storm(), new Thunderstorm(), new Sunshine()};
        for (Weather w : weathers) {
            w.forecast(); // Polymorphic call
            System.out.println("---");
        }
    }
}
