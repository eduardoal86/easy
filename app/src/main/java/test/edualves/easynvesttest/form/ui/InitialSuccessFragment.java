package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import test.edualves.easynvesttest.R;

/**
 * Created by edualves on 29/05/17.
 */

public class InitialSuccessFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_initial_success, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.next_investments)
    void goToInvestments() {
        ((MainFormActivity) getActivity()).showInvestmentScreen();
    }
}
