/*
 * Copyright (C) 2020 Havoc-OS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.support;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;

public class SwitchPreferenceCompat extends androidx.preference.SwitchPreferenceCompat {

    private final Context mContext;
    private final Vibrator mVibrator;

    public SwitchPreferenceCompat(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        mContext = context;
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attrs) {
        this(context, attrs, androidx.preference.R.attr.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(Context context) {
        this(context, null);
    }

    @Override
    protected void performClick(View view) {
        super.performClick(view);
        mVibrator.vibrate(VibrationEffect.get(VibrationEffect.EFFECT_CLICK));
    }
}

