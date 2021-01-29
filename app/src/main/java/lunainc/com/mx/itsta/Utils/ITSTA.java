package lunainc.com.mx.itsta.Utils;

import android.app.Application;

import im.crisp.sdk.Crisp;

public class ITSTA extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Crisp.initialize(this);
        // Replace it with your WEBSITE_ID
        // Retrieve it using https://app.crisp.chat/website/[YOUR_WEBSITE_ID]/
        Crisp.getInstance().setWebsiteId("b2b1672d-b490-4d2b-b17c-34421aedd622");

    }
}