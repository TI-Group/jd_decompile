package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class StreamsH5InfoDataBean implements Serializable {
    private StreamsH5Device device;
    private StreamsH5 h5;
    private String newdesc;
    private StreamsH5Product product;
    private StreamsH5SharedInfo shared_info;
    private List<StreamsH5Streams> streams;

    public StreamsH5Product getProduct() {
        return this.product;
    }

    public void setProduct(StreamsH5Product streamsH5Product) {
        this.product = streamsH5Product;
    }

    public StreamsH5SharedInfo getShared_info() {
        return this.shared_info;
    }

    public void setShared_info(StreamsH5SharedInfo streamsH5SharedInfo) {
        this.shared_info = streamsH5SharedInfo;
    }

    public StreamsH5Device getDevice() {
        return this.device;
    }

    public void setDevice(StreamsH5Device streamsH5Device) {
        this.device = streamsH5Device;
    }

    public List<StreamsH5Streams> getStreams() {
        return this.streams;
    }

    public void setStreams(List<StreamsH5Streams> list) {
        this.streams = list;
    }

    public String getNewdesc() {
        return this.newdesc;
    }

    public void setNewdesc(String str) {
        this.newdesc = str;
    }

    public StreamsH5 getH5() {
        return this.h5;
    }

    public void setH5(StreamsH5 streamsH5) {
        this.h5 = streamsH5;
    }
}
