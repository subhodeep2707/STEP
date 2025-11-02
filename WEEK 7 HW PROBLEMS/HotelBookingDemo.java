// File: HotelBookingDemo.java
class HotelBooking {
    // Standard booking
    public void calculateCost(String roomType, int nights) {
        int rate = 2000; // example rate
        int cost = rate * nights;
        System.out.println("Standard Booking: Room=" + roomType + ", Nights=" + nights + ", Cost=" + cost);
    }

    // Seasonal booking
    public void calculateCost(String roomType, int nights, double seasonalMultiplier) {
        int rate = 2000;
        double cost = rate * nights * seasonalMultiplier;
        System.out.println("Seasonal Booking: Room=" + roomType + ", Nights=" + nights + ", Cost=" + cost);
    }

    // Corporate booking
    public void calculateCost(String roomType, int nights, double discount, boolean mealPackage) {
        int rate = 2000;
        double cost = (rate * nights) - discount;
        if (mealPackage) cost += 500;
        System.out.println("Corporate Booking: Room=" + roomType + ", Nights=" + nights + ", Final Cost=" + cost);
    }

    // Wedding package
    public void calculateCost(String roomType, int nights, int guests, int decorationFee, int cateringFee) {
        int rate = 2000;
        int cost = (rate * nights) + decorationFee + cateringFee * guests;
        System.out.println("Wedding Booking: Guests=" + guests + ", Nights=" + nights + ", Total Cost=" + cost);
    }
}

public class HotelBookingDemo {
    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();
        booking.calculateCost("Deluxe", 3);
        booking.calculateCost("Suite", 2, 1.5);
        booking.calculateCost("Business", 4, 500, true);
        booking.calculateCost("Banquet", 1, 100, 2000, 300);
    }
}
