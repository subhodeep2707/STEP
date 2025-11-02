// File: HospitalDemo.java
class MedicalStaff {
    public void basicInfo() {
        System.out.println("Medical staff basic details recorded.");
    }
}

class Doctor extends MedicalStaff {
    public void diagnose() {
        System.out.println("Doctor diagnosing patient...");
    }
}

class Nurse extends MedicalStaff {
    public void assist() {
        System.out.println("Nurse assisting in treatment...");
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        MedicalStaff staff1 = new Doctor(); // upcasting
        MedicalStaff staff2 = new Nurse();

        staff1.basicInfo();
        staff2.basicInfo();

        // staff1.diagnose(); ❌ not allowed directly due to upcasting
    }
}
