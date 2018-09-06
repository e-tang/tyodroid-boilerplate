package au.com.tyo.sample.ui.activity;

import au.com.tyo.sample.ui.page.PageMain;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 27/11/17.
 */

public class ActivityMain extends ActivityBase {

    @Override
    protected void loadPageClass() {
        super.loadPageClass();

        getAgent().setPageClass(PageMain.class);
    }
}
