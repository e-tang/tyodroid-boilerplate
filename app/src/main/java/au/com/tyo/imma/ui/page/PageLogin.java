package au.com.tyo.sample.ui.page;

import android.app.Activity;

import au.com.tyo.sample.Controller;
import au.com.tyo.sample.R;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 27/11/17.
 */

public class PageLogin extends PageEmailPassword {

    /**
     * @param controller
     * @param activity
     */
    public PageLogin(Controller controller, Activity activity) {
        super(controller, activity);

        setContentViewResId(R.layout.login);
    }
}
