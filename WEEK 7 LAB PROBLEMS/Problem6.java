class SmartDevice {
    String name;
    SmartDevice(String n) { name = n; }
}

class SmartClassroom extends SmartDevice {
    SmartClassroom(String n) { super(n); }
    public void controlClassroom() {
        System.out.println(name + ": Lights, AC, and Projector controlled.");
    }
}

class SmartLab extends SmartDevice {
    SmartLab(String n) { super(n); }
    public void manageLab() {
        System.out.println(name + ": Equipment and Safety Systems managed.");
    }
}

class SmartLibrary extends SmartDevice {
    SmartLibrary(String n) { super(n); }
    public void trackLibrary() {
        System.out.println(name + ": Occupancy & Book Availability tracked.");
    }
}

public class Problem6 {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("Classroom-101"),
            new SmartLab("Lab-202"),
            new SmartLibrary("Library-303")
        };

        for (SmartDevice d : devices) {
            if (d instanceof SmartClassroom) {
                ((SmartClassroom) d).controlClassroom();
            } else if (d instanceof SmartLab) {
                ((SmartLab) d).manageLab();
            } else if (d instanceof SmartLibrary) {
                ((SmartLibrary) d).trackLibrary();
            }
        }
    }
}
