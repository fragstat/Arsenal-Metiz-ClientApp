package arsenal.metiz.catalog;

import androidx.annotation.DrawableRes;

public class RequestsStatus {
    private String createdBy;
    private String requestNumber;
    private String mark;
    private String diameter;
    private String layer;
    private String pack;
    private String status;


    public RequestsStatus(String requestNumber , String mark, String diameter , String layer,String pack, String status ) {
        this.requestNumber = requestNumber;
        this.mark = mark;
        this.diameter = diameter;
        this.layer = layer;
        this.pack = pack;
        this.status = status;

    }


    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
