/*
 * The MIT License
 *
 * Copyright 2015 Pmovil LTDA.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.pmovil.telephony;

import android.telephony.TelephonyManager;
import com.codename1.impl.android.AndroidNativeUtil;
import com.codename1.impl.android.CodenameOneActivity;

public class NativeTelephonyImpl {
    private TelephonyManager tm = null;
    
    public void load() {
        final CodenameOneActivity activity = (CodenameOneActivity) AndroidNativeUtil.getActivity();
        tm = (TelephonyManager) activity.getSystemService(CodenameOneActivity.TELEPHONY_SERVICE);
    }

    public String getMcc() {
        if (tm == null) {
            return null;
        }
        String simOperator = tm.getSimOperator();
        if (simOperator == null || simOperator.length() < 3) {
            return null;
        }
        return simOperator.substring(0,3);
    }

    public String getMnc() {
        if (tm == null) {
            return null;
        }
        String simOperator = tm.getSimOperator();
        if (simOperator == null || simOperator.length() <= 3) {
            return null;
        }
        return simOperator.substring(3);
    }

    public String getIsoCountryCode() {
        if (tm == null) {
            return null;
        }
        String simCountryIso = tm.getSimCountryIso();
        if (simCountryIso == null || simCountryIso.length() < 2) {
            return null;
        }
        return simCountryIso;
    }

    public String getCarrierName() {
        if (tm == null) {
            return null;
        }
        return tm.getSimOperatorName();
    }

    public boolean isSupported() {
        return true;
    }

}
