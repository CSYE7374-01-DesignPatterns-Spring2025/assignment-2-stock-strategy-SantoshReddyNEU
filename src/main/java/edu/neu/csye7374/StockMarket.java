package edu.neu.csye7374;

public class StockMarket {
    public void executeMarketOperations() {
        System.out.println("============Stock Market Simulation===================");

        System.out.println("\n=== Zoox Inc Trading Start ===");

        // Bull Market Trading
        System.out.println("\n=== Bull Market Trading ===");
        Stock zooxBull = new ZooxStock(new BullMarketStrategy());
        tradeStockWithBids(zooxBull, new String[]{"12480", "12560", "12590", "12630", "12650", "12690"});

        // Bear Market Trading
        System.out.println("\n=== Bear Market Trading ===");
        Stock zooxBear = new ZooxStock(new BearMarketStrategy());
        tradeStockWithBids(zooxBear, new String[]{"12480", "12300", "12250", "12190", "12150", "12090"});

        System.out.println("\n=== Zoox Inc Trading end ===");

        System.out.println("\n=== Zomato Trading Start ===");

        // Bull Market Trading
        System.out.println("\n=== Bull Market Trading ===");
        Stock zomatoBull = new ZomatoStock(new BullMarketStrategy());
        tradeStockWithBids(zomatoBull, new String[]{"50", "47", "62", "67", "71", "77"});

        // Bear Market Trading
        System.out.println("\n=== Bear Market Trading ===");
        Stock zomatoBear = new ZomatoStock(new BearMarketStrategy());
        tradeStockWithBids(zomatoBear, new String[]{"50", "47", "62", "67", "71", "77"});

        System.out.println("\n=== Zomato Trading end ===");


        System.out.println("============Simulation End===================");
    }

    private void tradeStockWithBids(Stock stock, String[] bids) {
        System.out.println("\nTrading " + stock.getName() + " Stock\n");
        for (String bid : bids) {
            stock.setBid(bid);
            System.out.println(stock);
        }
    }
}
