/*
 * Copyright (C) 2020 Wave-OS
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
package com.android.systemui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.ImageView;

public class BatteryBoltChargeView extends ImageView {

    private int mLevel;

    public BatteryBoltChargeView(Context context) {
        this(context, null /* attrs */);
    }

    public BatteryBoltChargeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0 /* defStyleAttr */);
    }

    public BatteryBoltChargeView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0 /* defStyleRes */);
    }

    public BatteryBoltChargeView(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mLevel = -1;
    }

    public void setIconTint(int intensity) {
        setImageTintList(ColorStateList.valueOf(intensity));
    }

    public void updateViews() {
        setImageResource(getImageResId(mLevel));
    }

    public void setLevel(int level) {
        mLevel = level;
        setImageResource(getImageResId(level));
    }

    private int getImageResId(int level) {
        if (level == 0) {
           return R.drawable.bolt_charging_state_0;
        } else if (level > 0 && level <= 10) {
            return R.drawable.bolt_charging_state_10;
        } else if (level > 10 && level <= 20) {
            return R.drawable.bolt_charging_state_20;
        } else if (level > 20 && level <= 30) {
            return R.drawable.bolt_charging_state_30;
        } else if (level > 30 && level <= 40) {
            return R.drawable.bolt_charging_state_40;
        } else if (level > 40 && level <= 50) {
            return R.drawable.bolt_charging_state_50;
        } else if (level > 50 && level <= 60) {
            return R.drawable.bolt_charging_state_60;
        } else if (level > 60 && level <= 70) {
            return R.drawable.bolt_charging_state_70;
        } else if (level > 70 && level <= 80) {
            return R.drawable.bolt_charging_state_80;
        } else if (level > 80 && level <= 90) {
            return R.drawable.bolt_charging_state_90;
        } else if (level <= 90 || level > 100) {
            return 0;
        }
        return R.drawable.bolt_charging_state_100;
    }
}
