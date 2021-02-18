package ram.ramires.messenger.activityDialog.ViewPagerInstruments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import ram.ramires.messenger.activityDialog.FragmentConfig;
import ram.ramires.messenger.activityDialog.FragmentDialogs;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentDialogs();
            case 1:
                return new FragmentConfig();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}