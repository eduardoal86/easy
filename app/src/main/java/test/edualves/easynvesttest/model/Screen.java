package test.edualves.easynvesttest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by edualves on 30/05/17.
 */

public class Screen implements Serializable {

    @SerializedName("title")
    String title;

    @SerializedName("fundName")
    String fundName;

    @SerializedName("whatIs")
    String whatIs;

    @SerializedName("definition")
    String definition;

    @SerializedName("graph")
    Graph graph;

    @SerializedName("riskTitle")
    String riskTitle;

    @SerializedName("risk")
    Integer risk;

    @SerializedName("infoTitle")
    String infoTitle;

    @SerializedName("moreInfo")
    MoreInfo moreInfo;

    @SerializedName("info")
    List<Info> infos;

    @SerializedName("downInfo")
    List<DownInfo> downInfos;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }

    public Integer getRisk() {
        return risk;
    }

    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public MoreInfo getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(MoreInfo moreInfo) {
        this.moreInfo = moreInfo;
    }

    public List<Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }

    public List<DownInfo> getDownInfos() {
        return downInfos;
    }

    public void setDownInfos(List<DownInfo> downInfos) {
        this.downInfos = downInfos;
    }
}
