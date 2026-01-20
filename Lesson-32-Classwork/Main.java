class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }
  
  void print(Object o){System.out.println(o);}
  void printt(Object o){System.out.print(o);}

  void init() {
    CarItem item1 = new CarItem("Laptop", 1000, true); // On sale
    CarItem item2 = new CarItem("Headphones", 200, false); // Not on sale
    CarItem item3 = new CarItem("Smartphone", 800, true); // On sale
    
    CarItem[] cartItems = {item1, item2, item3};
    
    for (CarItem item : cartItems) {
      if (item.isOnSale()) {
        print("Item on sale: " + item.getName() + " - Price: " + item.getItemPrice());
      }
    }

    double subtotal = 0;
    for (CarItem item : cartItems) {
      subtotal += item.getItemPrice();
    }
    
    double taxRate = 8.675 / 100; // Tax rate of 8.675%
    double tax = subtotal * taxRate;
    double totalAmount = subtotal + tax;
    
    print("Subtotal: " + subtotal);
    print("Tax: " + tax);
    print("Total amount: " + totalAmount);
  }

  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range + lower);
  }
}

class CarItem {
  private String name;
  private double itemPrice;
  private boolean onSale;

  public CarItem(String name, double itemPrice, boolean onSale) {
    this.name = name;
    this.itemPrice = itemPrice;
    this.onSale = onSale;
  }

  public String getName() {
    return name;
  }

  public double getItemPrice() {
    if (onSale) {
      return itemPrice * 0.9; 
    } else {
      return itemPrice;
    }
  }

  public boolean isOnSale() {
    return onSale;
  }
}
