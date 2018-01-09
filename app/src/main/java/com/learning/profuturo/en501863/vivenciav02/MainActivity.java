package com.learning.profuturo.en501863.vivenciav02;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.learning.profuturo.en501863.vivenciav02.fragment.ContentFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SlidingPaneLayout layout;
    private Button menuButton;
    private LinearLayout layoutMenuButton;

    private LinearLayout linearLayout;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpanel_activity);
        context = this;

        menuButton = (Button) findViewById(R.id.menu_button);

        linearLayout = (LinearLayout) findViewById(R.id.lineBar);

        layout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        layout.setSliderFadeColor(Color.TRANSPARENT);

        getSupportFragmentManager().beginTransaction().add(R.id.content_fragment, ContentFragment.newInstance(), "GENERAL").commit();

        menuButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.welcome_button_continue:
                break;

            case R.id.menu_button:
                if (!layout.isOpen()) {
                    layout.openPane();
                    menuButton.setScaleX(0.6f);
                    menuButton.setScaleY(0.6f);
                    menuButton.setBackground(getDrawable(R.drawable.ic_action_close));
                    linearLayout.setBackgroundColor(Color.WHITE);
                } else {
                    layout.closePane();
                    menuButton.setScaleX(1f);
                    menuButton.setScaleY(1f);
                    menuButton.setBackground(getDrawable(R.drawable.ic_action_menu));
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.pre_format_blue));
                }
                break;
        }
    }


}
