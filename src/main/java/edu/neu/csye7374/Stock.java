package edu.neu.csye7374;

public abstract class Stock implements Tradable {
    private String name;
    private double price;
    private String description;
    private String bid;
    private StockPriceStrategy priceStrategy; // New strategy field

    public void setPriceStrategy(StockPriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public void updatePrice(double highestBid) {
        if (priceStrategy != null) {
            this.price = priceStrategy.calculateNewPrice(this.price, highestBid);
        }
    }

    @Override
    public void setBid(String bid) {
        double newBid = Double.parseDouble(bid);
        if (this.bid == null || Double.parseDouble(this.bid) < newBid) {
            this.bid = bid;
            updatePrice(newBid); // Update price using strategy
        }
    }

    public String getBid() {
        return bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n" + name + " Stock\n" +
                "Current price: $" + price + "\n" +
                "Current bid: $" + bid + "\n" +
                "Metric: " + getMetric() + "\n" +
                "Description: " + description + "\n\n";
    }
}
