package at.ac.hcw.economic;

public class Market {
    private Trader[] sellers;
    private int rounds = 0;
    private Trader[] buyers;
    
    private final static double BUYER_LIMIT_LOW = 10.0;
    private final static double BUYER_LIMIT_HIGH = 15.0;
    private final static double SELLER_LIMIT_LOW = 8.0;
    private final static double SELLER_LIMIT_HIGH = 13.0;

    public Market(int arraySize) {
        this.sellers = new Trader[arraySize];
        this.buyers = new Trader[arraySize];
        for(int i = 0; i < arraySize; i++){

            double valueBuyer = Math.random() * (BUYER_LIMIT_HIGH - BUYER_LIMIT_LOW) + BUYER_LIMIT_LOW;
            buyers[i] = new Trader("Buyer " + i,true,valueBuyer);

            double valueSeller = Math.random() * (SELLER_LIMIT_HIGH - SELLER_LIMIT_LOW) + SELLER_LIMIT_LOW;
            sellers[i] = new Trader("Seller " + i,false,valueSeller);
        }
    }

    public void runRound(){
        rounds++;
        System.out.println("-- Handelsrunde --" + rounds);
        for(int i = 0; i < buyers.length; i++){
            if(buyers[i].getPriceLimit() >= sellers[i].getPriceLimit()){
               double price = (buyers[i].getPriceLimit() + sellers[i].getPriceLimit()) / 2;
               buyers[i].recordTrade(price);
               sellers[i].recordTrade(price);

               buyers[i].adjustPriceLimit(-0.2);
               sellers[i].adjustPriceLimit(0.2);
               System.out.printf("%s erwirbt von %s zum Preis von %.2f", buyers[i].getName(), sellers[i].getName(), price);
               System.out.println();
            }
            else{
               buyers[i].adjustPriceLimit(0.1);
               sellers[i].adjustPriceLimit(-0.1);
               System.out.printf("Zwischen %s (%.2f) und %s (%.2f) ist kein Handel zustande gekommen!", buyers[i].getName(),buyers[i].getPriceLimit() , sellers[i].getName(), sellers[i].getPriceLimit());    
               System.out.println();
            }
        }
    }

    public void showStatistics(){

        System.out.println("--- Handelsrunden ---");
        System.out.println(rounds);
        System.out.println("--- Käufer*innen ---");
        for (Trader trader : buyers) {
            System.out.println(trader);
        }
        System.out.println("--- Verkäufer*innen ---");
        for (Trader trader : sellers) {
            System.out.println(trader);
        }
    }
}
