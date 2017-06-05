package test.edualves.easynvesttest.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CustomTextInputLayout extends TextInputLayout {

    public CustomTextInputLayout(Context context) {
        this(context, null, 0);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override
    public void addView(View child, int index, final ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (super.getEditText() != null) {
            super.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() > 0) {
                        CustomTextInputLayout.this.setErrorEnabled(false);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setError(@Nullable CharSequence error) {
        super.setError(error);
        if (getEditText().getText().toString().isEmpty()) {
            this.setHintEnabled(false);
        }
    }

    @Override
    public void setErrorEnabled(boolean enabled) {
        super.setErrorEnabled(enabled);
        if (!enabled) {
            this.setHintEnabled(true);
        }
    }
}
