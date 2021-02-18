package ram.ramires.messenger;

import android.util.Log;

public class Logs {
    private boolean turnOn;
    public Logs(boolean b){
        this.turnOn=b;
    }
    public void showLog(Object object){
        if (turnOn) {
            Log.d("myLog", ""+object);
        }
    }
}
