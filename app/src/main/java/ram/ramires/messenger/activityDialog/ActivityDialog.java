package ram.ramires.messenger.activityDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import ram.ramires.messenger.Logs;
import ram.ramires.messenger.R;
import ram.ramires.messenger.activityDialog.ViewPagerInstruments.ViewPagerAdapter;

public class ActivityDialog extends AppCompatActivity {
    static final Logs logs = new Logs(true);
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private ViewModel2 viewModel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        viewModel2= new ViewModelProvider(this).get(ViewModel2.class);

        viewPager=findViewById(R.id.pager);
        pagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

    }
}