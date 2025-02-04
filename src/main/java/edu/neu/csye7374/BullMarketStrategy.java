package edu.neu.csye7374;

public class BullMarketStrategy implements StockPriceStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double highestBid) {
        return currentPrice + (highestBid - currentPrice) * 0.10; // 10% price increase factor
    }
}
