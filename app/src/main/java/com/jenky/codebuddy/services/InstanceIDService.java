
package com.jenky.codebuddy.services;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.jenky.codebuddy.api.Callback;
import com.jenky.codebuddy.api.Request;
import com.jenky.codebuddy.util.AppController;
import com.jenky.codebuddy.util.Preferences;

import org.json.JSONException;
import org.json.JSONObject;

public class InstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";



    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        AppController.getInstance().getPreferences().setMessageToken(refreshedToken);
        Request.setMessagingToken(Preferences.messagingCallback);
        // TODO: Implement this method to send any registration to your app's servers.
    }
    // [END refresh_token]
}
