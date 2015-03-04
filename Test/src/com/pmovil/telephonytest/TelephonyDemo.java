package com.pmovil.telephonytest;


import com.codename1.components.SpanLabel;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.pmovil.telephony.Telephony;
import java.io.IOException;

public class TelephonyDemo {

    private Form current;

    public void init(Object context) {
        try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch(IOException e){
        }
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        Form demo = new Form("Telephony Demo");
        demo.addComponent(new SpanLabel(
                "Country: " + Telephony.getIsoCountryCode() + "\n" +
                "Carrier: " + Telephony.getCarrierName() + "\n" +
                "MCC: " + Telephony.getMcc() + "\n" +
                "MNC: " + Telephony.getMnc() + "\n"));
        demo.show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }

}
