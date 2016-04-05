package com.timer.modules.ag.dto;

public class AgInformation {

    private String currentBuyPrice;

    private String currentSellPrice;

    private String currentMidPrice;

    public String getCurrentBuyPrice() {
        return currentBuyPrice;
    }

    public void setCurrentBuyPrice(String currentBuyPrice) {
        this.currentBuyPrice = currentBuyPrice;
    }

    public String getCurrentSellPrice() {
        return currentSellPrice;
    }

    public void setCurrentSellPrice(String currentSellPrice) {
        this.currentSellPrice = currentSellPrice;
    }

    public String getCurrentMidPrice() {
        return currentMidPrice;
    }

    public void setCurrentMidPrice(String currentMidPrice) {
        this.currentMidPrice = currentMidPrice;
    }

}
