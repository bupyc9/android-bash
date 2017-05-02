package ru.bupyc9.bashim.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class Feed {
    @Element(name = "channel")
    private Channel mChannel;

    public Channel getChannel() {
        return mChannel;
    }
}
