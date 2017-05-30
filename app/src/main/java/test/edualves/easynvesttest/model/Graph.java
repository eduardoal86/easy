package test.edualves.easynvesttest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edualves on 30/05/17.
 */

public class Graph implements Serializable {

    @SerializedName("CDI")
    List<Float> cdiValues = new ArrayList<>();

    @SerializedName("fund")
    List<Float> fundValues = new ArrayList<>();

    @SerializedName("x")
    List<String> xValues = new ArrayList<>();

    public List<Float> getCdiValues() {
        return cdiValues;
    }

    public void setCdiValues(List<Float> cdiValues) {
        this.cdiValues = cdiValues;
    }

    public List<Float> getFundValues() {
        return fundValues;
    }

    public void setFundValues(List<Float> fundValues) {
        this.fundValues = fundValues;
    }

    public List<String> getxValues() {
        return xValues;
    }

    public void setxValues(List<String> xValues) {
        this.xValues = xValues;
    }
}
