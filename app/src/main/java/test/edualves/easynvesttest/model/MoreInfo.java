package test.edualves.easynvesttest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by edualves on 30/05/17.
 */

public class MoreInfo implements Serializable {

    @SerializedName("month")
    Month month;

    @SerializedName("year")
    Year year;

    @SerializedName("12months")
    TwelveMonths twelveMonths;

    public TwelveMonths getTwelveMonths() {
        return twelveMonths;
    }

    public void setTwelveMonths(TwelveMonths twelveMonths) {
        this.twelveMonths = twelveMonths;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
