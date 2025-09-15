import java.time.LocalDateTime;
import java.util.*;

final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    public Product(String id, String n, String c, String m, double bp, double w, String[] f, Map<String, String> s) {
        productId = id;
        name = n;
        category = c;
        manufacturer = m;
        basePrice = bp;
        weight = w;
        features = Arrays.copyOf(f, f.length);
        specifications = new HashMap<>(s);
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return Arrays.copyOf(features, features.length); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        return basePrice * 0.1;
    }

    public static Product createElectronics() {
        return new Product("E1", "Phone", "Electronics", "ABC", 500, 0.2, new String[]{"4G"}, Map.of("RAM", "8GB"));
    }

    public static Product createClothing() {
        return new Product("C1", "Shirt", "Clothing", "XYZ", 50, 0.3, new String[]{"Cotton"}, Map.of("Size", "M"));
    }

    public static Product createBooks() {
        return new Product("B1", "Java", "Books", "PQR", 20, 0.5, new String[]{"Paperback"}, Map.of("Pages", "500"));
    }
}

class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private final String accountCreationDate;

    public Customer(String id, String em, String date) {
        customerId = id;
        email = em;
        accountCreationDate = date;
    }

    String getCreditRating() { return "Good"; }
    public String getPublicProfile() { return name + "-" + preferredLanguage; }
    public void setName(String n) { this.name = n; }
    public void setPhoneNumber(String p) { this.phoneNumber = p; }
    public void setPreferredLanguage(String l) { this.preferredLanguage = l; }
}

class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private List<Object> items = new ArrayList<>();
    private double totalAmount;
    private int itemCount;

    public ShoppingCart(String cid) {
        cartId = UUID.randomUUID().toString();
        customerId = cid;
    }

    public boolean addItem(Object p, int q) {
        if (p instanceof Product) {
            items.add(p);
            itemCount += q;
            totalAmount += ((Product) p).getBasePrice() * q;
            return true;
        }
        return false;
    }

    private double calculateDiscount() { return itemCount > 5 ? 0.1 : 0; }
    String getCartSummary() { return "Items:" + itemCount + " Total:" + totalAmount; }
}

class Order {
    private final String orderId;
    private final LocalDateTime orderTime;

    public Order() {
        orderId = UUID.randomUUID().toString();
        orderTime = LocalDateTime.now();
    }
}

class PaymentProcessor {
    private final String processorId;
    private final String securityKey;

    public PaymentProcessor(String id, String key) {
        processorId = id;
        securityKey = key;
    }
}

class ShippingCalculator {
    private final Map<String, Double> shippingRates;

    public ShippingCalculator(Map<String, Double> r) {
        shippingRates = new HashMap<>(r);
    }
}

final class ECommerceSystem {
    private static final Map<String, Object> productCatalog = new HashMap<>();

    public static boolean processOrder(Object order, Object customer) {
        return order instanceof Order && customer instanceof Customer;
    }

    public static void main(String[] args) {
        Product p = Product.createElectronics();
        Customer c = new Customer("CU1", "a@b.com", "2020-01-01");
        ShoppingCart sc = new ShoppingCart("CU1");
        sc.addItem(p, 2);
        Order o = new Order();
        System.out.println(processOrder(o, c));
    }
}