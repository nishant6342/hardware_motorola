/*
 * Copyright (C) 2015-2016 The CyanogenMod Project
 * Copyright (C) 2017-2022 The LineageOS Project
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

package org.lineageos.settings.device;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceFragment;

public class ActionsPreferenceFragment extends PreferenceFragment {

    private static final String TAG = "ActionsPreferenceFragment";
    private static final String GESTURE_CHOP_CHOP_KEY = "gesture_chop_chop";
    private static final String GESTURE_IR_SILENCER_KEY = "gesture_ir_silencer";
    private static final String GESTURE_FLIP_TO_MUTE_KEY = "gesture_flip_to_mute";
    private static final String GESTURE_LIFT_TO_SILENCE_KEY = "gesture_lift_to_silence";

    private Preference mChopChop;
    private Preference mIrSilencer;
    private Preference mFlipMute;
    private Preference mLiftSilence;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.actions_panel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }
        return false;
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mChopChop = findPreference(GESTURE_CHOP_CHOP_KEY);
        mIrSilencer = findPreference(GESTURE_IR_SILENCER_KEY);
        mFlipMute = findPreference(GESTURE_FLIP_TO_MUTE_KEY);
        mLiftSilence = findPreference(GESTURE_LIFT_TO_SILENCE_KEY);

        if (mChopChop == null || mIrSilencer == null || mFlipMute == null || mLiftSilence == null) {
            Log.e(TAG, "Failed to apply layout pref is null!");
            return;
        }
        mChopChop.setLayoutResource(org.elixir.resources.cardlayout.R.layout.xd_pref_card_top);
        mIrSilencer.setLayoutResource(org.elixir.resources.cardlayout.R.layout.xd_pref_card_mid);
        mFlipMute.setLayoutResource(org.elixir.resources.cardlayout.R.layout.xd_pref_card_mid);
        mLiftSilence.setLayoutResource(org.elixir.resources.cardlayout.R.layout.xd_pref_card_bot);

    }

}
