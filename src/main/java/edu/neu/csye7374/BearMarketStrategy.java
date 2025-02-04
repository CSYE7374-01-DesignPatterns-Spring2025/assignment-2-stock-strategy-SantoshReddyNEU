package edu.neu.csye7374;

public class BearMarketStrategy implements StockPriceStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double highestBid) {
        return currentPrice - (currentPrice - highestBid) * 0.05; // 5% price decrease factor
    }
}
