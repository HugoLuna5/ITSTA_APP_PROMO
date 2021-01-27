package lunainc.com.mx.itsta.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Career implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("imageBanner")
    @Expose
    private Integer imageBanner;

    @SerializedName("about")
    @Expose
    private String about;

    @SerializedName("activity")
    @Expose
    private String activity;

    @SerializedName("field")
    @Expose
    private String field;

    @SerializedName("why")
    @Expose
    private String why;




    public Career() {
    }

    public Career(String name, Integer imageBanner, String about, String activity, String field, String why) {
        this.name = name;
        this.imageBanner = imageBanner;
        this.about = about;
        this.activity = activity;
        this.field = field;
        this.why = why;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageBanner() {
        return imageBanner;
    }

    public void setImageBanner(Integer imageBanner) {
        this.imageBanner = imageBanner;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }


}
