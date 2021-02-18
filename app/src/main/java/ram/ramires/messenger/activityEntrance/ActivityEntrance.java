package ram.ramires.messenger.activityEntrance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import ram.ramires.messenger.Logs;
import ram.ramires.messenger.R;

public class ActivityEntrance extends AppCompatActivity {
    static final Logs logs = new Logs(true);
    private SharedPreferences launchPref;
    private NavController navController;
    private ViewModel1 viewModel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        viewModel1=new ViewModelProvider(this).get(ViewModel1.class);
        boolean isLaunched=viewModel1.getLaunch();
            logs.showLog(isLaunched);

        NavHostFragment navHostFragment=(NavHostFragment)getSupportFragmentManager().
                findFragmentById(R.id.nav_host_fragment_container);
        navController=navHostFragment.getNavController();

        if (isLaunched){
            navController.navigate(R.id.fragmentRegistration);
        }else {
            navController.navigate(R.id.fragmentRegistration);
        }

    }

}