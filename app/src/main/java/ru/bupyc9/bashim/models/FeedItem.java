package ru.bupyc9.bashim.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class FeedItem {
    @Element(name = "title")
    private String mTitle;
    @Element(name = "link")
    private String mLink;
    @Element(name = "description")
    private String mDescription;
    @Element(name = "pubDate")
    private String mPubDate;

    public String getTitle() {
        return mTitle;
    }

    public String getLink() {
        return mLink;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPubDate() {
        return mPubDate;
    }
}
