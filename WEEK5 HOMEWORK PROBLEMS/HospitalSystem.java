import java.time.LocalDate;
import java.util.*;

final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String id, String dna, String[] allg, String[] hist, LocalDate bd, String bt) {
        if (id == null || dna == null || bd == null || bt == null) {
            throw new IllegalArgumentException();
        }
        this.recordId = id;
        this.patientDNA = dna;
        this.allergies = Arrays.copyOf(allg, allg.length);
        this.medicalHistory = Arrays.copyOf(hist, hist.length);
        this.birthDate = bd;
        this.bloodType = bt;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return Arrays.copyOf(allergies, allergies.length); }
    public String[] getMedicalHistory() { return Arrays.copyOf(medicalHistory, medicalHistory.length); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }
    
    public final boolean isAllergicTo(String sub) {
        return Arrays.asList(allergies).contains(sub);
    }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    public Patient(String id, MedicalRecord mr) {
        this.patientId = id;
        this.medicalRecord = mr;
    }

    String getBasicInfo() { return currentName + "-" + roomNumber; }
    public String getPublicInfo() { return currentName + " Room:" + roomNumber; }
    
    public void setCurrentName(String n) { this.currentName = n; }
    public void setEmergencyContact(String e) { this.emergencyContact = e; }
    public void setInsuranceInfo(String i) { this.insuranceInfo = i; }
    public void setRoomNumber(int r) { this.roomNumber = r; }
    public void setAttendingPhysician(String a) { this.attendingPhysician = a; }
}

class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String l, String s, Set<String> c) {
        licenseNumber = l;
        specialty = s;
        certifications = c;
    }
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String id, String sh, List<String> q) {
        nurseId = id;
        shift = sh;
        qualifications = q;
    }
}

class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String id, List<String> ap) {
        adminId = id;
        accessPermissions = ap;
    }
}

class HospitalSystem {
    private final Map<String, Object> patientRegistry = new HashMap<>();
    static final String POLICY = "HIPAA";

    public boolean admitPatient(Object patient, Object staff) {
        if (validateStaffAccess(staff, patient)) {
            patientRegistry.put(UUID.randomUUID().toString(), patient);
            return true;
        }
        return false;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        return staff instanceof Doctor || staff instanceof Nurse;
    }

    public static void main(String[] args) {
        MedicalRecord mr = new MedicalRecord("R1", "DNA", new String[]{"Peanut"}, new String[]{"Asthma"}, LocalDate.of(1990, 1, 1), "O+");
        Patient p = new Patient("P1", mr);
        p.setCurrentName("John");
        Doctor d = new Doctor("L1", "Cardio", Set.of("MBBS"));
        HospitalSystem hs = new HospitalSystem();
        System.out.println(hs.admitPatient(p, d));
    }
}