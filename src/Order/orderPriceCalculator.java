package Order;

public class orderPriceCalculator{

    private static float totalPriceBeforeTax;
    private static float totalPriceAfterTax;
    private static float serviceChargeRate;
    private static float governmentTaxRate;

    public void orderController(float totalPriceBeforeTax) {
        this.totalPriceBeforeTax = totalPriceBeforeTax;
    }
    
    public void orderController(int serviceChargeRate, int governmentTaxRate) {
        float calculatedGovernmentTaxRate = governmentTaxRate/100 +1;
        float calculatedServiceChargeRate = governmentTaxRate/100 +1;
        this.governmentTaxRate = calculatedGovernmentTaxRate;
        this.serviceChargeRate = calculatedServiceChargeRate;
    }

    public float getTotalPriceBeforeTax() {
        return totalPriceBeforeTax;
    }

    public static float getTotalPriceAfterTax() {
        return totalPriceAfterTax;
    }

    public static float getServiceChargeRate() {
        return serviceChargeRate;
    }

    public static float getGovernmentTaxRate() {
        return governmentTaxRate;
    }
    
    public float calculateTotalPriceAfterTax(){
        
        float totalPrice = totalPriceBeforeTax*serviceChargeRate *governmentTaxRate;
        this.totalPriceAfterTax = totalPrice;
        return totalPrice;
    }
}