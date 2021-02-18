package ram.ramires.messenger.activityEntrance;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import static android.content.Context.MODE_PRIVATE;

public class ViewModel1 extends AndroidViewModel {
    public ValidatorR validatorR;
    private RepositoryProvider model;
    private SharedPreferences launchPref;
    private Context context;

    public ViewModel1(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
        launchPref=context.getSharedPreferences("launch",MODE_PRIVATE);
        model=new RepositoryProvider();
        validatorR=new ValidatorR();

    }
    public boolean getLaunch(){
        return model.cheakLaunch(launchPref);
    }
    public void allFalse(){
        validatorR.clear();
    }

    public void init() {
        String token = RepositoryProvider.provideKeyValueStorage().getToken();
        if (!TextUtils.isEmpty(token)) {
            //mAuthView.openRepositoriesScreen();
        }
    }
}
