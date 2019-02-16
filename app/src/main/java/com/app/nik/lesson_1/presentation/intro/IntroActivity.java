package com.app.nik.lesson_1.presentation.intro;

import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.app.nik.lesson_1.R;

import java.util.ArrayList;
import java.util.Arrays;

public class IntroActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setCurrentItem(0);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_IMAGE_RES_ID = "image_res_id";
        private static final String ARG_TEXT_RES_ID = "text_res_id";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(
                int sectionNumber,
                @DrawableRes int imageResId,
                int textResId
        ) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putInt(ARG_IMAGE_RES_ID, imageResId);
            args.putInt(ARG_TEXT_RES_ID, textResId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_intro, container, false);
            TextView textView = rootView.findViewById(R.id.section_label);
            textView.setText(getString(
                    R.string.section_format,
                    getArguments().getInt(ARG_SECTION_NUMBER))
            );

            ImageView imageView = rootView.findViewById(R.id.section_image);
            imageView.setImageResource(getArguments().getInt(ARG_IMAGE_RES_ID));
            textView.setText(getArguments().getInt(ARG_TEXT_RES_ID));

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int index = position;
            Log.d("ololo", "Index is " + index + " , Position is " + position);
            int imageRes;
            int textRes;
            if (index == 0) {
                imageRes = R.drawable.fragment_first;
                textRes = R.string.fragment_first;
            } else if (index==1) {
                imageRes = R.drawable.fragment_second;
                textRes = R.string.fragment_second;
            } else{
                imageRes=R.drawable.fragment_third;
                textRes = R.string.fragment_third;
            }

            return PlaceholderFragment.newInstance(index, imageRes, textRes);
        }

        @Override
        public int getCount() {
            return 3 /*Integer.MAX_VALUE*/;
        }
    }
}

