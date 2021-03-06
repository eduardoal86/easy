package test.edualves.easynvesttest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by edualves on 30/05/17.
 */

public class Month implements Serializable {

    @SerializedName("fund")
    Float fund;

    @SerializedName("CDI")
    Float cdi;

    public Float getFund() {
        return fund;
    }

    public void setFund(Float fund) {
        this.fund = fund;
    }

    public Float getCdi() {
        return cdi;
    }

    public void setCdi(Float cdi) {
        this.cdi = cdi;
    }
}
