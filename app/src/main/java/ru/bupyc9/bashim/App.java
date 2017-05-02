package ru.bupyc9.bashim;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.bupyc9.bashim.network.RssService;
import ru.bupyc9.bashim.network.UmoriliService;

public class App extends android.app.Application {
    private static UmoriliService sUmoriliService;
    private static RssService sRssService;

    public static UmoriliService getUmoriliApi() {
        if (sUmoriliService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.umori.li/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


            sUmoriliService = retrofit.create(UmoriliService.class);
        }

        return sUmoriliService;
    }

    public static RssService getRssApi() {
        if (sRssService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://alogvinov.com")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();


            sRssService = retrofit.create(RssService.class);
        }

        return sRssService;
    }
}
