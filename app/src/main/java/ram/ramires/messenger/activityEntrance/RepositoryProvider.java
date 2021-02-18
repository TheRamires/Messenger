package ram.ramires.messenger.activityEntrance;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.util.Map;

public class RepositoryProvider {
    private static KeyValueStorage sKeyValueStorage;
    @NonNull
    public static KeyValueStorage provideKeyValueStorage() {
        if (sKeyValueStorage == null) {
            sKeyValueStorage = new HawkKeyValueStorage();
        }
        return sKeyValueStorage;
    }

    public static void setKeyValueStorage(@NonNull KeyValueStorage keyValueStorage) {
        sKeyValueStorage = keyValueStorage;
    }

    private boolean firstLaunch(SharedPreferences launchPref){
        SharedPreferences.Editor ed=launchPref.edit();
        ed.putBoolean("launched", true);
        ed.commit();
        return false;
    }
    public boolean cheakLaunch(SharedPreferences launchPref){
        if (!isLaunched(launchPref)){
            return firstLaunch(launchPref); //false
        }else {return isLaunched(launchPref);//true
        }
    }
    private boolean isLaunched(SharedPreferences launchPref){
        boolean launched=launchPref.getBoolean("launched",false);

        return launched; //true
    }
    /*public Map<String, String> getServerData(){
        return null;
    }*/
}
