
package com.tienda;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Provincia {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nm")
    @Expose
    private String nm;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Provincia() {
    }

    /**
     * 
     * @param id
     * @param nm
     */
    public Provincia(String id, String nm) {
        super();
        this.id = id;
        this.nm = nm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Provincia.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("nm");
        sb.append('=');
        sb.append(((this.nm == null)?"<null>":this.nm));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
