package au.com.tyo.sample;

import au.com.tyo.sample.ui.UI;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 24/11/17.
 */

public interface Controller extends au.com.tyo.app.Controller<UI> {

    boolean hasUserLoggedIn();

}
