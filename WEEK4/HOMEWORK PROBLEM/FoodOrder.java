class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;
    private static final double DEFAULT_RATE = 199.0;

    // 1) Default → "Unknown" order
    public FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // 2) Food item → quantity=1, price=default
    public FoodOrder(String foodItem) {
        this("Guest", foodItem, 1, DEFAULT_RATE);
    }

    // 3) Food item + quantity → price = quantity × fixedRate
    public FoodOrder(String foodItem, int quantity) {
        this("Guest", foodItem, quantity, DEFAULT_RATE);
    }

    // Full constructor (kept package-private for chaining)
    FoodOrder(String customerName, String foodItem, int quantity, double ratePerItem) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = Math.max(0, quantity);
        this.price = Math.max(0.0, ratePerItem);
    }

    public void printBill() {
        double total = quantity * price;
        System.out.printf(" 🧾  %s ordered %d × %s @ ₹%.2f → Total ₹%.2f%n",
                customerName, quantity, foodItem, price, total);
    }

    public static void main(String[] args) {
        System.out.println("--- Food Delivery Order ---");
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Veg Burger");
        FoodOrder o3 = new FoodOrder("Paneer Wrap", 3);
        FoodOrder o4 = new FoodOrder("Kalpana", "Family Pizza", 2, 449.0);
        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}