package ram.ramires.messenger.activityEntrance;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ram.ramires.messenger.R;
import ram.ramires.messenger.databinding.FragmentAuthorizationBinding;

public class FragmentAuthorization extends Fragment {
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAuthorizationBinding binding=FragmentAuthorizationBinding.inflate(inflater, container,false);
        binding.setAuthoriz(this);
        View view=binding.getRoot();

        return view;
    }
    public void toRegistr(View view){
        Navigation.findNavController(view).navigate(R.id.action_fragmentAuthorization_to_fragmentRegistration);


    }
    public void toDialogActivity(View view){
        Navigation.findNavController(view).navigate(R.id.activityDialog);
    }
}