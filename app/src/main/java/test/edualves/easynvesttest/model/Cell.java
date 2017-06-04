package test.edualves.easynvesttest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by edualves on 26/05/17.
 */

public class Cell implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("type")
    private Integer type;

    @SerializedName("message")
    private String message;

    @SerializedName("typefield")
    private Integer typeField;

    @SerializedName("hidden")
    private Boolean isHidden;

    @SerializedName("topSpacing")
    private Integer topSpacing;

    @SerializedName("show")
    private Integer show;

    @SerializedName("required")
    private Boolean isRequired;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypeField() {
        return typeField;
    }

    public void setTypeField(Integer typeField) {
        this.typeField = typeField;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Integer getTopSpacing() {
        return topSpacing;
    }

    public void setTopSpacing(Integer topSpacing) {
        this.topSpacing = topSpacing;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public enum Type {
        FIELD(1), TEXT(2), IMAGE(3), CHECKBOX(4), SEND(5);

        public int type;

        Type(int typeValue) {
            this.type = typeValue;
        }
    }

    public enum TypeField {
        TEXT(1), TELNUMBER(2), EMAIL(3);

        public int typeField;

        TypeField(int fieldValue) {
            this.typeField = fieldValue;
        }
    }
}
