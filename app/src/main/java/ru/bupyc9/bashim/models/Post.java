package ru.bupyc9.bashim.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("site")
    private String site;
    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String desc;
    @SerializedName("link")
    private String link;
    @SerializedName("elementPureHtml")
    private String elementPureHtml;

    /**
     * @return The site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site The site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return Site name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Site name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Site description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc Site description
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return The elementPureHtml
     */
    public String getElementPureHtml() {
        return elementPureHtml;
    }

    /**
     * @param elementPureHtml The elementPureHtml
     */
    public void setElementPureHtml(String elementPureHtml) {
        this.elementPureHtml = elementPureHtml;
    }

}
