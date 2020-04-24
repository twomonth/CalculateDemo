package com.twomonth.calculatedemo.fragment;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.twomonth.calculatedemo.R;
import com.twomonth.calculatedemo.databinding.FragmentQuestionBinding;
import com.twomonth.calculatedemo.viewmodel.MyViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private StringBuilder anwer = new StringBuilder();
    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel viewModel = ViewModelProviders
                .of(requireActivity(),new SavedStateViewModelFactory(requireActivity().getApplication(),this))
                .get(MyViewModel.class);
        viewModel.generator();
        final FragmentQuestionBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
        binding.setData(viewModel);
        binding.setLifecycleOwner(requireActivity());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button0:
                        anwer.append("0");
                        break;
                    case R.id.button1:
                        anwer.append("1");
                        break;
                    case R.id.button2:
                        anwer.append("2");
                        break;
                    case R.id.button3:
                        anwer.append("3");
                        break;
                    case R.id.button4:
                        anwer.append("4");
                        break;
                    case R.id.button5:
                        anwer.append("5");
                        break;
                    case R.id.button6:
                        anwer.append("6");
                        break;
                    case R.id.button7:
                        anwer.append("7");
                        break;
                    case R.id.button8:
                        anwer.append("8");
                        break;
                    case R.id.button9:
                        anwer.append("9");
                        break;
                    case R.id.button_rv:
                        if (anwer.length()!=0){
                            anwer.deleteCharAt(anwer.length()-1);
                        }else {
                            Snackbar.make(view,getResources().getString(R.string.haveno),Snackbar.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.button_ok:
                        if (TextUtils.isEmpty(anwer)){
                            Snackbar.make(view,getResources().getString(R.string.please_entry),Snackbar.LENGTH_SHORT).show();
                        }
                        if (Integer.valueOf(anwer.toString()).intValue() == viewModel.getAnswer().getValue()){
                            viewModel.answerCorrect();
                            anwer.setLength(0);
                        }else {
                            NavController controller = Navigation.findNavController(view);
                            if (viewModel.win_flag){
                                controller.navigate(R.id.action_questionFragment_to_winFragment);
                                viewModel.win_flag = false;
                                viewModel.save();
                            }else {
                                controller.navigate(R.id.action_questionFragment_to_loseFragment);
                            }
                        }
                        break;

                        default:
                            break;
                }
                binding.textViewResult.setText(anwer);
            }
        };

        binding.button0.setOnClickListener(listener);
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.buttonRv.setOnClickListener(listener);
        binding.buttonOk.setOnClickListener(listener);



        return binding.getRoot();
    }

}
