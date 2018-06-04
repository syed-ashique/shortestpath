package com.syed.shortestpath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.syed.shortestpath.model.Matrix;
import com.syed.shortestpath.utility.Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_text_input)
    EditText mEditTextInput;

    @BindView(R.id.text_view_path_possible)
    TextView mTextViewPathPossible;

    @BindView(R.id.text_view_total_cost)
    TextView mTextViewTotalCost;

    @BindView(R.id.text_view_path)
    TextView mTextViewPath;

    @BindView(R.id.text_view_error)
    TextView mTextViewError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_find_path)
    public void getResult() {
        resetView();
        try {
            Matrix matrix = Util.parseInput(mEditTextInput.getText().toString());
            Findpath findpath = new Findpath(matrix);
            findpath.calculatePath();

            mTextViewPathPossible.setText(findpath.isPathPossible() ? "Yes" : "No");
            mTextViewTotalCost.setText(String.valueOf(findpath.getTotalCost()));
            mTextViewPath.setText("["+pathValue(findpath.getPath())+"]");
        } catch (Exception ex) {
            mTextViewError.setVisibility(View.VISIBLE);
            mTextViewError.setText("Something Went Wrong");
        }
    }

    private String pathValue(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void resetView() {
        mTextViewError.setVisibility(View.GONE);
        mTextViewPathPossible.setText("");
        mTextViewTotalCost.setText("");
        mTextViewPath.setText("");
    }
}
