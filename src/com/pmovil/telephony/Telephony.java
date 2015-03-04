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

import com.codename1.system.NativeLookup;

/**
 *
 * Simple class to access simcard information
 * 
 * @author fabricio
 */
public class Telephony {
    public static String MCC_UNKNOWN = "Unknown MCC";
    public static String MNC_UNKNOWN = "Unknown MNC";
    public static String ISO_COUNTRY_CODE_UNKNOWN = "Unknown ISO country code";
    public static String CARRIER_NAME_UNKNOWN = "Unknown carrier name";
    private static NativeTelephony peer;
    
    /**
     * 
     * @return true if there is a native implementation to access simcard information
     */
    public static boolean isSupported() {
        if (peer == null) {
            peer = (NativeTelephony)NativeLookup.create(NativeTelephony.class);
            if (peer != null && peer.isSupported()) {
                peer.load();
                return true;
            } else {
                return false;
            }
        } else {
            return peer.isSupported();
        }
    }
    
    /**
     * 
     * @return a 3 digit string containing the mobile country code or MCC_UNKNOWN
     */
    public static String getMcc() {
        if (isSupported()) {
            String mcc = peer.getMcc();
            return mcc != null ? mcc : MCC_UNKNOWN;
        } else {
            return MCC_UNKNOWN;
        }
    }

    /**
     * 
     * @return a 2-3 digit string containing the mobile network code or MNC_UNKNOWN
     */
    public static String getMnc() {
        if (isSupported()) {
            String mnc = peer.getMnc();
            return mnc != null ? mnc : MNC_UNKNOWN;
        } else {
            return MNC_UNKNOWN;
        }
    }

    /**
     * 
     * @return a 2 character string containing the ISO 3166-1 country code representation
     */
    public static String getIsoCountryCode() {
        if (isSupported()) {
            String isoCountryCode = peer.getIsoCountryCode();
            return isoCountryCode != null ? isoCountryCode.toUpperCase() : ISO_COUNTRY_CODE_UNKNOWN;
        } else {
            return ISO_COUNTRY_CODE_UNKNOWN;
        }
    }

    /**
     * 
     * @return a string provided by the carrier and formatted for presentation to the user.
     */
    public static String getCarrierName() {
        if (isSupported()) {
            String carrierName = peer.getCarrierName();
            return carrierName != null ? carrierName : CARRIER_NAME_UNKNOWN;
        } else {
            return CARRIER_NAME_UNKNOWN;
        }
    }
}
