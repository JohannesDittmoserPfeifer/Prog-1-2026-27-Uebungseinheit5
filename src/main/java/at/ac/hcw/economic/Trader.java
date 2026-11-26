package at.ac.hcw.economic;

public class Trader {

    private double totalProfit = 0.0;
    private boolean isBuyer;
    private double priceLimit;
    private int tradesDone = 0;
    private String name;

    public Trader(String name, boolean isBuyer, double priceLimit){
        this.name = name;
        this.isBuyer = isBuyer;
        this.priceLimit = priceLimit;
    }

    public String getName(){
        return name;
    }

    public double getPriceLimit(){
        return priceLimit;
    }

    public int getTradesDone(){
        return tradesDone;
    }

    public boolean isBuyer(){
        return isBuyer;
    }

    public double getTotalProfit(){
        return totalProfit;
    }

    @Override
    public String toString(){
        String type = isBuyer ? "Käufer*in" : "Verkäufer*in";
        String result = String.format("#%s (%s): Preislimit=%.2f | Trades=%d | Gewinn=%.2f", name, type, priceLimit, tradesDone, totalProfit);
        return result;
    }

    public void adjustPriceLimit(double limitChange){
        priceLimit += limitChange;
        if(priceLimit < 0){
            priceLimit = 0.0;
        }
    } 

    public void recordTrade(double achievedPrice){
        double profit = isBuyer ? (priceLimit - achievedPrice) : (achievedPrice - priceLimit);
        totalProfit += profit;
        tradesDone++;
    }
}
