package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class ZooxStock extends Stock {
    private List<Double> allBids = new ArrayList<>();
    private double highestBid = 0.0;

    public ZooxStock(StockPriceStrategy priceStrategy) {
        this.setName("Zoox Inc");
        this.setDescription("Autonomous Public Transportation");
        this.setPrice(12440);
        this.setPriceStrategy(priceStrategy); // Set the strategy dynamically
    }

    @Override
    public void setBid(String bid) {
        if (bid == null || bid.isEmpty()) {
            System.out.println("Invalid bid, no update made.");
            return;
        }

        try {
            double currentBid = Double.parseDouble(bid);
            allBids.add(currentBid);

            super.setBid(bid); // Uses strategy to update price
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format, please provide a numeric value.");
        } catch (Exception e) {
            System.out.println("Something went wrong while setting bid!");
        }
    }

    @Override
    public String getMetric() {
        if (allBids.size() < 2) return "0.00 (Need more bids)";

        double sumGrowth = 0;
        for (int i = 1; i < allBids.size(); i++) {
            sumGrowth += (allBids.get(i) - allBids.get(i - 1));
        }
        double avgGrowth = sumGrowth / (allBids.size() - 1);

        return String.format("%.2f", avgGrowth); // Return average bid growth rate
    }
}
