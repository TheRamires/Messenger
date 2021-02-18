package ram.ramires.messenger.activityEntrance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ram.ramires.messenger.R;
import ram.ramires.messenger.databinding.FragmentRegistrationBinding;

public class FragmentRegistration extends Fragment{
    private Button btnRegistr;
    private View view;
    private ViewModel1 viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel=new ViewModelProvider(requireActivity()).get(ViewModel1.class);
        FragmentRegistrationBinding binding=FragmentRegistrationBinding.inflate(inflater,container,false);
        binding.setRegistr(this);
        binding.setViewModel(viewModel);
        binding.setValidator(viewModel.validatorR);
        view=binding.getRoot();
        btnRegistr=view.findViewById(R.id.btn_registr);

        return view;
    }
    public void toAuthoriz(View view){
        Navigation.findNavController(view).navigate(R.id.action_fragmentRegistration_to_fragmentAuthorization);
        viewModel.allFalse();
    }
    public void toDialogActivity(View view){
        Navigation.findNavController(view).navigate(R.id.activityDialog);
    }
}