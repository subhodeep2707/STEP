// Assignment 3: Hotel Reservation System
import java.util.*;
class Room {
    String roomNumber;
    String roomType;
    double pricePerNight;
    boolean isAvailable;
    int maxOccupancy;
    public Room(String num,String type,double price,int max){ this.roomNumber=num; this.roomType=type; this.pricePerNight=price; this.maxOccupancy=max; this.isAvailable=true; }
}
class Guest {
    String guestId;
    String guestName;
    String phoneNumber;
    String email;
    String[] bookingHistory;
    int histSize;
    public Guest(String id,String name,String phone,String email){ this.guestId=id; this.guestName=name; this.phoneNumber=phone; this.email=email; this.bookingHistory=new String[50]; this.histSize=0; }
    public void addHistory(String bid){ bookingHistory[histSize++]=bid; }
}
class Booking {
    String bookingId;
    Guest guest;
    Room room;
    String checkInDate;
    String checkOutDate;
    double totalAmount;
    static int totalBookings=0;
    static double hotelRevenue=0.0;
    static String hotelName="";
    public Booking(String id,Guest g,Room r,String in,String out,double amt){ this.bookingId=id; this.guest=g; this.room=r; this.checkInDate=in; this.checkOutDate=out; this.totalAmount=amt; totalBookings++; hotelRevenue+=amt; }
}
class HotelSystem {
    Room[] rooms;
    Booking[] bookings;
    Guest[] guests;
    int rsize, bsize, gsize;
    public HotelSystem(){ rooms=new Room[100]; bookings=new Booking[100]; guests=new Guest[100]; }
    public void addRoom(Room r){ rooms[rsize++]=r; }
    public void addGuest(Guest g){ guests[gsize++]=g; }
    public Room checkAvailability(String type){ for(int i=0;i<rsize;i++){ if(rooms[i].isAvailable && rooms[i].roomType.equalsIgnoreCase(type)) return rooms[i]; } return null; }
    public double calculateBill(Room r,int nights){ return r.pricePerNight*nights; }
    public Booking makeReservation(String guestId,String roomType,String in,String out,int nights){ Guest g=findGuest(guestId); Room r=checkAvailability(roomType); if(g==null||r==null) return null; r.isAvailable=false; String id="B"+(bsize+1); double amt=calculateBill(r,nights); Booking bk=new Booking(id,g,r,in,out,amt); bookings[bsize++]=bk; g.addHistory(id); return bk; }
    public boolean cancelReservation(String bookingId){ for(int i=0;i<bsize;i++){ if(bookings[i].bookingId.equals(bookingId)){ bookings[i].room.isAvailable=true; Booking.hotelRevenue-=bookings[i].totalAmount; for(int j=i;j<bsize-1;j++){ bookings[j]=bookings[j+1]; } bookings[--bsize]=null; return true; } } return false; }
    public Guest findGuest(String id){ for(int i=0;i<gsize;i++){ if(guests[i].guestId.equals(id)) return guests[i]; } return null; }
    public static double getOccupancyRate(HotelSystem hs){ int occ=0; for(int i=0;i<hs.rsize;i++){ if(!hs.rooms[i].isAvailable) occ++; } if(hs.rsize==0) return 0; return (occ*100.0)/hs.rsize; }
    public static double getTotalRevenue(){ return Booking.hotelRevenue; }
    public static String getMostPopularRoomType(HotelSystem hs){ HashMap<String,Integer> map=new HashMap<>(); for(int i=0;i<hs.bsize;i++){ String t=hs.bookings[i].room.roomType; map.put(t,map.getOrDefault(t,0)+1); } String best=""; int mx=-1; for(String k:map.keySet()){ if(map.get(k)>mx){ mx=map.get(k); best=k; } } return best; }
}
class Assignment3 {
    public static void main(String[] args){
        Booking.hotelName="Sunrise Hotel";
        HotelSystem hs=new HotelSystem();
        hs.addRoom(new Room("101","Deluxe",3000,2));
        hs.addRoom(new Room("102","Standard",2000,2));
        hs.addRoom(new Room("201","Suite",5000,4));
        hs.addGuest(new Guest("G1","Rohan","999","r@x.com"));
        hs.addGuest(new Guest("G2","Siya","888","s@x.com"));
        Booking b1=hs.makeReservation("G1","Deluxe","2025-09-05","2025-09-07",2);
        Booking b2=hs.makeReservation("G2","Standard","2025-09-06","2025-09-07",1);
        System.out.println(b1.bookingId+" "+b1.totalAmount);
        System.out.println(b2.bookingId+" "+b2.totalAmount);
        System.out.println(HotelSystem.getOccupancyRate(hs));
        System.out.println(HotelSystem.getTotalRevenue());
        System.out.println(HotelSystem.getMostPopularRoomType(hs));
        hs.cancelReservation(b2.bookingId);
        System.out.println(HotelSystem.getOccupancyRate(hs));
        System.out.println(HotelSystem.getTotalRevenue());
    }
}

