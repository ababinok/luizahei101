package com.ofnicon.luizahei101.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ofnicon.luizahei101.R;
import com.ofnicon.luizahei101.core.Core;

public class NotificationActivity extends AppCompatActivity {

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        text = getIntent().getStringExtra("text");
        setTextAndBG(text);

        findViewById(R.id.share_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Core.shareNotice(NotificationActivity.this, text);
            }
        });
        findViewById(R.id.more_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextAndBG(Core.getNotificationText(NotificationActivity.this));
            }
        });
    }

    private void setTextAndBG(String text) {
        ((TextView) findViewById(R.id.notification_tv)).setText(text);
        View layout = findViewById(R.id.notification_activity_layout);
        layout.setBackgroundResource(getResources().getIdentifier(Core.getBackground(this), "drawable", getPackageName()));
    }
}
