package com.solvd.hotel.invoice;

import java.util.Objects;

public class AdditionalService {
    private boolean TV;
    private boolean taxiOrder;
    private String serviceName;
    private boolean conditioner;
    private String extraMeal;

    public AdditionalService() {
    }

    public AdditionalService(boolean TV, boolean taxiOrder, String serviceName, boolean conditioner, String extraMeal) {
        this.TV = TV;
        this.taxiOrder = taxiOrder;
        this.serviceName = serviceName;
        this.conditioner = conditioner;
        this.extraMeal = extraMeal;
    }

    public boolean getTV() {
        return TV;
    }

    public void setTV(boolean TV) {
        this.TV = TV;
    }

    public boolean getTaxiOrder() {
        return taxiOrder;
    }

    public void setTaxiOrder(boolean taxiOrder) {
        this.taxiOrder = taxiOrder;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean getConditioner() {
        return conditioner;
    }

    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }

    public String getExtraMeal() {
        return extraMeal;
    }

    public void setExtraMeal(String extraMeal) {
        this.extraMeal = extraMeal;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[TV=" + getTV() + ", taxiOrder=" + getTaxiOrder() + ", serviceName="
                + getServiceName() + ", conditioner=" + getConditioner() + ", extraMeal=" + getExtraMeal() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTV(), getTaxiOrder(), getServiceName().hashCode(),
                getConditioner(), getExtraMeal().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalService additionalService = (AdditionalService) o;
        return hashCode() == additionalService.hashCode();
    }
}
