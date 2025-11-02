// File: SmartHome.java
class SmartDevice {
    String name;
    SmartDevice(String name) { this.name = name; }
}

class SmartLight extends SmartDevice {
    SmartLight(String n) { super(n); }
    public void turnOn() { System.out.println(name + " light is ON."); }
}

class SmartThermostat extends SmartDevice {
    SmartThermostat(String n) { super(n); }
    public void setTemperature(int temp) {
        System.out.println(name + " thermostat set to " + temp + "°C.");
    }
}

class SmartSpeaker extends SmartDevice {
    SmartSpeaker(String n) { super(n); }
    public void playMusic(String song) {
        System.out.println(name + " speaker playing: " + song);
    }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartLight("Living Room"),
            new SmartThermostat("Bedroom"),
            new SmartSpeaker("Kitchen")
        };

        for (SmartDevice d : devices) {
            if (d instanceof SmartLight) {
                ((SmartLight) d).turnOn();
            } else if (d instanceof SmartThermostat) {
                ((SmartThermostat) d).setTemperature(22);
            } else if (d instanceof SmartSpeaker) {
                ((SmartSpeaker) d).playMusic("Lo-fi beats");
            }
        }
    }
}
