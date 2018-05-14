package com.google.zxing.client.result;

/* compiled from: TbsSdkJava */
public final class VINParsedResult extends ParsedResult {
    private final String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final String sequentialNumber;
    private final String vehicleAttributes;
    private final String vehicleDescriptorSection;
    private final String vehicleIdentifierSection;
    private final String vin;
    private final String worldManufacturerID;

    public VINParsedResult(String str, String str2, String str3, String str4, String str5, String str6, int i, char c, String str7) {
        super(ParsedResultType.VIN);
        this.vin = str;
        this.worldManufacturerID = str2;
        this.vehicleDescriptorSection = str3;
        this.vehicleIdentifierSection = str4;
        this.countryCode = str5;
        this.vehicleAttributes = str6;
        this.modelYear = i;
        this.plantCode = c;
        this.sequentialNumber = str7;
    }

    public String getVIN() {
        return this.vin;
    }

    public String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }

    public String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }

    public String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getVehicleAttributes() {
        return this.vehicleAttributes;
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public char getPlantCode() {
        return this.plantCode;
    }

    public String getSequentialNumber() {
        return this.sequentialNumber;
    }

    public String getDisplayResult() {
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append(this.worldManufacturerID).append(' ');
        stringBuilder.append(this.vehicleDescriptorSection).append(' ');
        stringBuilder.append(this.vehicleIdentifierSection).append('\n');
        if (this.countryCode != null) {
            stringBuilder.append(this.countryCode).append(' ');
        }
        stringBuilder.append(this.modelYear).append(' ');
        stringBuilder.append(this.plantCode).append(' ');
        stringBuilder.append(this.sequentialNumber).append('\n');
        return stringBuilder.toString();
    }
}
