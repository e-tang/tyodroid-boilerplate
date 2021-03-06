package au.com.tyo.imma;

import au.com.tyo.app.ui.UIBase;
import au.com.tyo.imma.ui.UI;
import au.com.tyo.imma.ui.activity.ActivityLogin;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 27/11/17.
 */

public class AppUI extends UIBase implements UI {

    public AppUI(Controller controller) {
        super(controller);
    }

    @Override
    public void gotoLoginPage() {
        gotoPage(ActivityLogin.class);
    }
}
