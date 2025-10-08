class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  void init(){
    System.out.println("Problem 1: Group Savings");
    System.out.print("Enter number of tickets to purchase: ");
  int numTickets = Input.readInt();
  double totalCost = groupSavings(numTickets);
  System.out.printf("Total cost for %d tickets is $%.2f\n", numTickets, totalCost);

    System.out.println("\nProblem 2: Grocery Discount");
    System.out.print("Enter total amount spent at grocery store: ");
    double totalSpent = Input.readDouble();
    System.out.print("Enter number of cans of beans purchased: ");
    double numCans = Input.readDouble();
    double savings = groceryDiscount(totalSpent, numCans);
    System.out.printf("Total savings on your bill is $%.2f\n", savings);
        
  }

    /*
      Problem 1:      
      Write a function groupSavings that takes number of tickets wanting 
      to purchase. Return the total cost by apply the following discount:
      1 to 8 tickets  : $11 per ticket,
      9 to 16 tickets : $10.50 per ticket
      over 16 tickets : $8.50 per ticket
    */
    double groupSavings(int numTickets){
      double totalCost = 0;
      if(numTickets >= 1 && numTickets <= 8){
        totalCost = numTickets * 11;
      } else if(numTickets >= 9 && numTickets <= 16){
        totalCost = numTickets * 10.5;
      } else if(numTickets > 16){
        totalCost = numTickets * 8.5;
      }
      return totalCost;
    }
  /*
      Write a function groceryDiscount that takes the total amount spent at 
      a grocery store and the number of cans of beans purchased.
      Depending on the total amount and number of can of
      beans purchase, you get a savings on their total bill.
      Return the savings amount:
        Spent $100 to $200 and purchase at least 3 cans of 
        beans: $10 savings
        Spent over $200 and purchase more than 4 cans 
        of beans: $25 savings
        Otherwise: $0 savings.
    */
    double groceryDiscount(double totalSpent, double numCans){
      double savings = 0;
      if(totalSpent >= 100 && totalSpent <= 200 && numCans >= 3){
        savings = 10;
      } else if(totalSpent > 200 && numCans > 4){
        savings = 25;
      } else {
        savings = 0;
      }
      return savings;
    }

}