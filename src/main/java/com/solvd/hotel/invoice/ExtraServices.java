package com.solvd.hotel.invoice;

public class ExtraServices {
    private ExtraServices serviceName;
    private int price;


    public ExtraServices() {
    }

    public ExtraServices(ExtraServices serviceName, int price) {

        this.serviceName = serviceName;
        this.price = price;

    }

    public ExtraServices getServiceName() {
        return serviceName;
    }

    public void setServiceName(ExtraServices serviceName) {
        this.serviceName = serviceName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /*@Override
    public String toString() {
        return getClass().getName() + "[TV=" + getTV() + ", taxiOrder=" + getTaxiOrder() + ", serviceName="
                + getServiceName() + ", conditioner=" + getConditioner() + ", extraMeal=" + getExtraMeal() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTV(), getTaxiOrder(), getServiceName().hashCode(),
                getConditioner(), getExtraMeal().hashCode());
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraServices extraServices = (ExtraServices) o;
        return hashCode() == extraServices.hashCode();
    }
}
