package org.fossasia.susi.ai.rest.assitsessions;

import android.annotation.TargetApi;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.widget.Toast;

import org.fossasia.susi.ai.login.WelcomeActivity;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(21)
public class SusiAssistantSession extends VoiceInteractionSession {

        public SusiAssistantSession(Context context) {

            super(context);
            mContext = context;
        }

        private Context mContext;
    @Override
    public void onHandleAssist(Bundle data,
                               AssistStructure structure, AssistContent content) {
        super.onHandleAssist(data, structure, content);

        if (Build.VERSION.SDK_INT>=23) {
            // Display description as Toast
            Toast.makeText(
                    getContext(),
                    "My Name is Susi",
                    Toast.LENGTH_LONG
            ).show();
            Intent intent = new Intent(mContext,WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }

    }

}
