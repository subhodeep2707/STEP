// File: SmartHomeDemo.java
class SmartDevice {
    public void status() {
        System.out.println("Generic smart device status.");
    }
}

class SmartTV extends SmartDevice {
    public void changeChannel() {
        System.out.println("SmartTV: Changing channel...");
    }
}

class SmartThermostat extends SmartDevice {
    public void adjustTemperature() {
        System.out.println("SmartThermostat: Adjusting temperature...");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDevice[] devices = { new SmartTV(), new SmartThermostat() };

        for (SmartDevice device : devices) {
            device.status();

            if (device instanceof SmartTV) {
                ((SmartTV) device).changeChannel();
            } else if (device instanceof SmartThermostat) {
                ((SmartThermostat) device).adjustTemperature();
            }
        }
    }
}
