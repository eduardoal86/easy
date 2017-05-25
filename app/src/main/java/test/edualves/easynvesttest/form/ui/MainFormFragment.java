package test.edualves.easynvesttest.form.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import test.edualves.easynvesttest.R;

/**
 * Created by edualves on 25/05/17.
 */

public class MainFormFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_main_form, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
