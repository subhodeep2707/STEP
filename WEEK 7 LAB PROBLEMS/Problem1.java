class DeliveryCharges {
    // Basic delivery
    public void calculateCost(double distance) {
        double cost = distance * 5;
        System.out.println("Basic Delivery: Distance = " + distance + "km | Cost = ₹" + cost);
    }

    // Premium delivery
    public void calculateCost(double distance, double priorityFee) {
        double cost = (distance * 5) + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + "km + Priority Fee = ₹" + priorityFee + " | Total = ₹" + cost);
    }

    // Group delivery
    public void calculateCost(double distance, int numOrders) {
        double discount = numOrders * 2;
        double cost = (distance * 5) - discount;
        System.out.println("Group Delivery: Distance = " + distance + "km | Orders = " + numOrders + " | Discount = ₹" + discount + " | Total = ₹" + cost);
    }

    // Festival special
    public void calculateCost(double distance, double discountPercent, double orderAmount) {
        double baseCost = distance * 5;
        double discount = (baseCost * discountPercent) / 100;
        double total = baseCost - discount;

        if (orderAmount > 500) {
            total = 0; // free delivery
            System.out.println("Festival Special: Free delivery (Order > ₹500)!");
        } else {
            System.out.println("Festival Special: Distance = " + distance + "km | Discount = " + discountPercent + "% | Total = ₹" + total);
        }
    }
}

public class Problem1 {
    public static void main(String[] args) {
        DeliveryCharges d = new DeliveryCharges();
        d.calculateCost(10);
        d.calculateCost(10, 50);
        d.calculateCost(10, 3);
        d.calculateCost(10, 20, 300);
        d.calculateCost(10, 20, 600);
    }
}
