package au.com.tyo.sample;

import android.content.Context;
import android.content.Intent;

import au.com.tyo.app.CommonApp;
import au.com.tyo.app.PageAgent;
import au.com.tyo.sample.ui.UI;
import au.com.tyo.sample.ui.page.PageCommon;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 24/11/17.
 */

public class App extends CommonApp<UI, Controller> implements Controller {

    static {
        PageAgent.setPagesPackage(PageCommon.class.getPackage().getName());
    }

    public App(Context context) {
        super(context);
    }

    @Override
    public boolean hasUserLoggedIn() {
        return false;
    }

    @Override
    public void bindDataFromOtherApps(Intent intent) {
        // do nothing until we have such requirement
    }
}
