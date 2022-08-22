package com.solvd.hotel.mainHotel;


import java.util.Objects;

import com.solvd.hotel.enums.City;
import com.solvd.hotel.mainHotel.Address;

public class Branch extends Address {
    private int branchId;
    private int qtyOfRooms;
    private String adminName;

    public Branch() {
    }

    public Branch(String nameCountry, City city, String address, int branchId, int qtyOfRooms,
                  String adminName) {
        super(nameCountry, city, address);
        this.branchId = branchId;
        this.qtyOfRooms = qtyOfRooms;
        this.adminName = adminName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getQtyOfRooms() {
        return qtyOfRooms;
    }

    public void setQtyOfRooms(int qtyOfRooms) {
        this.qtyOfRooms = qtyOfRooms;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[nameCountry=" + getNameCountry() + ", city=" + getCity() + ", address=" + getAddress()
                + ", branchId" + getBranchId() + ", qtyOfRooms" + getQtyOfRooms() + ", adminName" + getAdminName() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameCountry().hashCode(), getCity().hashCode(), getAddress().hashCode(), getBranchId(),
                getQtyOfRooms(), getAdminName().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        return hashCode() == branch.hashCode();
    }
}
