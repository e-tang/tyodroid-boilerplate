package au.com.tyo.imma;

import android.content.Context;
import android.content.Intent;

import com.facebook.drawee.backends.pipeline.Fresco;

import au.com.tyo.app.CommonApp;
import au.com.tyo.app.PageAgent;
import au.com.tyo.imma.ui.UI;
import au.com.tyo.imma.ui.page.PageCommon;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 24/11/17.
 */

public class App extends CommonApp<UI, Controller> implements Controller {

    static {
        PageAgent.setPagesPackage(PageCommon.class.getPackage().getName());
    }

    public App(Context context) {
        super(context);

        Fresco.initialize(context);
    }

    @Override
    public boolean hasUserLoggedIn() {
        return true;
    }

    @Override
    public void bindDataFromOtherApps(Intent intent) {
        // do nothing until we have such requirement
    }

    @Override
    public void initializeOnce() {
        super.initializeOnce();
    }
}
