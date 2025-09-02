// Assignment 2: Online Shopping Cart System
import java.util.*;
class Product {
    String productId;
    String productName;
    double price;
    String category;
    int stockQuantity;
    static int totalProducts=0;
    static String[] categories = new String[]{"Electronics","Clothing","Home","Books","Grocery"};
    public Product(String id,String name,double price,String category,int stock){
        this.productId=id; this.productName=name; this.price=price; this.category=category; this.stockQuantity=stock; totalProducts++;
    }
    public static Product findProductById(Product[] products,String productId){
        for(Product p:products){ if(p!=null && p.productId.equals(productId)) return p; } return null;
    }
    public static Product[] getProductsByCategory(Product[] products,String category){
        ArrayList<Product> list=new ArrayList<>();
        for(Product p:products){ if(p!=null && p.category.equalsIgnoreCase(category)) list.add(p); }
        return list.toArray(new Product[0]);
    }
}
class ShoppingCart {
    String cartId;
    String customerName;
    Product[] products;
    int[] quantities;
    double cartTotal;
    int size;
    public ShoppingCart(String id,String customer){
        this.cartId=id; this.customerName=customer; this.products=new Product[50]; this.quantities=new int[50]; this.cartTotal=0.0; this.size=0;
    }
    public void addProduct(Product product,int quantity){
        if(product==null||quantity<=0||product.stockQuantity<quantity) return;
        int idx = -1;
        for(int i=0;i<size;i++){ if(products[i].productId.equals(product.productId)) idx=i; }
        if(idx==-1){ products[size]=product; quantities[size]=quantity; size++; }
        else{ quantities[idx]+=quantity; }
        product.stockQuantity-=quantity; calculateTotal();
    }
    public void removeProduct(String productId){
        for(int i=0;i<size;i++){
            if(products[i].productId.equals(productId)){
                products[i].stockQuantity+=quantities[i];
                for(int j=i;j<size-1;j++){ products[j]=products[j+1]; quantities[j]=quantities[j+1]; }
                products[size-1]=null; quantities[size-1]=0; size--; break;
            }
        }
        calculateTotal();
    }
    public void calculateTotal(){
        cartTotal=0.0; for(int i=0;i<size;i++){ cartTotal+=products[i].price*quantities[i]; }
    }
    public void displayCart(){
        System.out.println("Cart: "+cartId+" Customer: "+customerName);
        for(int i=0;i<size;i++){ System.out.println(products[i].productId+" "+products[i].productName+" x"+quantities[i]+" = "+(products[i].price*quantities[i])); }
        System.out.println("Total: "+cartTotal);
    }
    public void checkout(){
        displayCart();
        System.out.println("Checked out. Cart cleared.");
        for(int i=0;i<size;i++){ products[i]=null; quantities[i]=0; }
        size=0; cartTotal=0.0;
    }
}
class Assignment2 {
    public static void main(String[] args){
        Product[] catalog=new Product[20];
        catalog[0]=new Product("P1","Phone",15000,"Electronics",10);
        catalog[1]=new Product("P2","Laptop",60000,"Electronics",5);
        catalog[2]=new Product("P3","T-Shirt",800,"Clothing",50);
        catalog[3]=new Product("P4","Jeans",1500,"Clothing",30);
        catalog[4]=new Product("P5","Mixer",2500,"Home",20);
        catalog[5]=new Product("P6","Novel",400,"Books",40);
        catalog[6]=new Product("P7","Rice 5kg",350,"Grocery",25);
        catalog[7]=new Product("P8","Headphones",1200,"Electronics",15);
        catalog[8]=new Product("P9","Shoes",2200,"Clothing",18);
        catalog[9]=new Product("P10","Lamp",700,"Home",22);
        ShoppingCart cart=new ShoppingCart("C1001","Rahul");
        Scanner sc=new Scanner(System.in);
        boolean run=true;
        while(run){
            System.out.println("1 List Products 2 Add 3 Remove 4 View Cart 5 Browse Category 6 Checkout 7 Exit");
            int ch=sc.nextInt();
            if(ch==1){
                for(Product p:catalog){ if(p!=null) System.out.println(p.productId+" "+p.productName+" "+p.category+" "+p.price+" Stock:"+p.stockQuantity); }
            } else if(ch==2){
                String id=sc.next(); int q=sc.nextInt(); cart.addProduct(Product.findProductById(catalog,id),q);
            } else if(ch==3){
                String id=sc.next(); cart.removeProduct(id);
            } else if(ch==4){
                cart.displayCart();
            } else if(ch==5){
                String cat=sc.next(); Product[] arr=Product.getProductsByCategory(catalog,cat); for(Product p:arr){ System.out.println(p.productId+" "+p.productName+" "+p.price+" Stock:"+p.stockQuantity); }
            } else if(ch==6){
                cart.checkout();
            } else if(ch==7){
                run=false;
            }
        }
    }
}

