package com.jd.fridge.bean;

import com.jd.fridge.util.r;

/* compiled from: TbsSdkJava */
public class SelectedLocation {
    private LocationInfo city;
    private LocationInfo district;
    private boolean isSelectedFinish;
    private LocationInfo province;
    private LocationInfo street;

    public void resetSelectedLocation(int i) {
        this.isSelectedFinish = false;
        switch (i) {
            case 1:
                this.province = null;
                return;
            case 2:
                this.city = null;
                return;
            case 3:
                this.district = null;
                return;
            case 4:
                this.street = null;
                return;
            default:
                this.province = null;
                this.city = null;
                this.district = null;
                this.street = null;
                return;
        }
    }

    public boolean isAllClassifySelected() {
        return (this.province == null || this.city == null || this.district == null || this.street == null) ? false : true;
    }

    public void setSelectedFinish(boolean z) {
        this.isSelectedFinish = z;
    }

    public boolean isSelectedFinish() {
        return this.isSelectedFinish;
    }

    public void setProvince(LocationInfo locationInfo) {
        this.province = locationInfo;
    }

    public LocationInfo getProvince() {
        return this.province;
    }

    public void setCity(LocationInfo locationInfo) {
        this.city = locationInfo;
    }

    public LocationInfo getCity() {
        return this.city;
    }

    public void setDistrict(LocationInfo locationInfo) {
        this.district = locationInfo;
    }

    public LocationInfo getDistrict() {
        return this.district;
    }

    public void setStreet(LocationInfo locationInfo) {
        this.street = locationInfo;
    }

    public LocationInfo getStreet() {
        return this.street;
    }

    public LocationInfo getSelectedLocation() {
        return this.street;
    }

    public String getLocationContent() {
        r.b("infos", "province=" + this.province + "=city==" + this.city + "==district=" + this.district + "=street==" + this.street);
        if (this.province == null || this.city == null || this.district == null || this.street == null) {
            return "";
        }
        return this.province.getRegionName() + this.city.getRegionName() + this.district.getRegionName() + this.street.getRegionName();
    }

    public String getLocationNoDistrict() {
        r.b("infos", "province=" + this.province + "=city==" + this.city + "==district=" + this.district + "=street==" + this.street);
        StringBuilder stringBuilder = new StringBuilder();
        if (this.province != null) {
            stringBuilder.append(this.province.getRegionName());
        }
        if (this.city != null) {
            stringBuilder.append(this.city.getRegionName());
        }
        if (this.district != null) {
            stringBuilder.append(this.district.getRegionName());
        }
        if (this.street != null) {
            stringBuilder.append(this.street.getRegionName());
        }
        return stringBuilder.toString();
    }
}
