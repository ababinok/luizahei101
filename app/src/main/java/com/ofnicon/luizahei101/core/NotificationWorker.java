package com.ofnicon.luizahei101.core;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Calendar;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotificationWorker extends Worker {

    static String TAG = "LUIZAHEI101_WORKER_TAG";

    public NotificationWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        boolean first = getInputData().getBoolean("first", false);
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if  (first || currentHour < 23 && currentHour >= 7) {
            Core.displayNotification(getApplicationContext());
        }
        return Worker.Result.success();
    }
}
