package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class ZomatoStock extends Stock {
    private List<Double> allBids = new ArrayList<>();

    public ZomatoStock(StockPriceStrategy priceStrategy) {
        this.setName("Zomato");
        this.setDescription("Food Delivery");
        this.setPrice(48.6);
        this.setPriceStrategy(priceStrategy); // Set the strategy dynamically
    }

    @Override
    public void setBid(String bid) {
        if (bid == null || bid.isEmpty()) {
            System.out.println("Invalid bid, no update made.");
            return;
        }

        try {
            double newBid = Double.parseDouble(bid);
            allBids.add(newBid);
            super.setBid(bid);  // Updates the bid in the parent class

        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format, please provide a numeric value.");
        }
    }

    @Override
    public String getMetric() {
        if (allBids.isEmpty()) {
            return "No valid bids yet.";
        }
        // Calculate the average of all bids
        double averageBid = allBids.stream().mapToDouble(b -> b).average().orElse(0.0);
        double newMetric = ((averageBid - this.getPrice()) / this.getPrice()) * 100;
        return String.valueOf(newMetric);
    }
}
