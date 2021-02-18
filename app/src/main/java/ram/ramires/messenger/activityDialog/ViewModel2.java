package ram.ramires.messenger.activityDialog;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ViewModel2 extends AndroidViewModel {
    Model2 model2;

    public ViewModel2(@NonNull Application application) {
        super(application);
        model2=new Model2();
    }
}
