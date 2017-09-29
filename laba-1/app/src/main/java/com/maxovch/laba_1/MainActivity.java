package com.maxovch.laba_1;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    @BindView(R.id.container)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView;

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1: {
                    rootView = inflater.inflate(R.layout.two_value_computation_fragment, container, false);

                    TextView valueName1 = rootView.findViewById(R.id.valueName1);
                    valueName1.setText("x");
                    TextView valueName2 = rootView.findViewById(R.id.valueName2);
                    valueName2.setText("y");

                    Button button = rootView.findViewById(R.id.button);

                    final EditText editText1 = rootView.findViewById(R.id.editText1);
                    final EditText editText2 = rootView.findViewById(R.id.editText2);

                    final TextView finalValue = rootView.findViewById(R.id.finalValue);
                    TextView formuleTextView = rootView.findViewById(R.id.formuleTextView);
                    formuleTextView.setText("cos(2y) + 3,6e^x");

                    button.setOnClickListener(new View.OnClickListener() {

                        Double x;
                        Double y;

                        @Override
                        public void onClick(View view) {
                            x = Double.valueOf(editText1.getText().toString());
                            y = Double.valueOf(editText2.getText().toString());

                            if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                                finalValue.setText("Вы не забыли вписать число?");
                            } else {
                                finalValue.setText(getResources().getString(R.string.first_task_format,
                                        (Math.cos(2 * y) + 3.6 * Math.exp(x))));
                            }
                        }
                    });
                    break;
                }
                case 2: {
                    rootView = inflater.inflate(R.layout.two_value_computation_fragment, container, false);

                    TextView valueName1 = rootView.findViewById(R.id.valueName1);
                    valueName1.setText("i");
                    TextView valueName2 = rootView.findViewById(R.id.valueName2);
                    valueName2.setText("y");

                    Button button = rootView.findViewById(R.id.button);

                    final EditText editText1 = rootView.findViewById(R.id.editText1);
                    final EditText editText2 = rootView.findViewById(R.id.editText2);

                    final TextView finalValue = rootView.findViewById(R.id.finalValue);
                    TextView formuleTextView = rootView.findViewById(R.id.formuleTextView);
                    formuleTextView.setText("0,81cos(i) / (ln(y) + 2i^3)");

                    button.setOnClickListener(new View.OnClickListener() {

                        Double i;
                        Double y;

                        @Override
                        public void onClick(View view) {

                            i = Double.valueOf(editText1.getText().toString());
                            y = Double.valueOf(editText2.getText().toString());

                            if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                                finalValue.setText("Вы не забыли вписать число?");
                            } else {
                                finalValue.setText(getResources().getString(R.string.second_task_format,
                                        ((0.81 * Math.cos(i)) / (Math.log(y) + 2 * i))));
                            }
                        }
                    });
                    break;
                }
                case 3: {
                    rootView = inflater.inflate(R.layout.four_value_computation_fragment, container, false);

                    TextView valueName1 = rootView.findViewById(R.id.valueName1);
                    valueName1.setText("x");
                    TextView valueName2 = rootView.findViewById(R.id.valueName2);
                    valueName2.setText("y");
                    TextView valueName3 = rootView.findViewById(R.id.valueName3);
                    valueName3.setText("a");
                    TextView valueName4 = rootView.findViewById(R.id.valueName4);
                    valueName4.setText("b");

                    Button button = rootView.findViewById(R.id.button);

                    final EditText editText1 = rootView.findViewById(R.id.editText1);
                    final EditText editText2 = rootView.findViewById(R.id.editText2);
                    final EditText editText3 = rootView.findViewById(R.id.editText3);
                    final EditText editText4 = rootView.findViewById(R.id.editText4);

                    final TextView finalValue = rootView.findViewById(R.id.finalValue);
                    TextView formuleTextView = rootView.findViewById(R.id.formuleTextView);
                    formuleTextView.setText("(sqrt(x + b - a) + ln(y)) / arctg(b + a)");

                    button.setOnClickListener(new View.OnClickListener() {

                        Double x;
                        Double y;
                        Double a;
                        Double b;

                        @Override
                        public void onClick(View view) {

                            x = Double.valueOf(editText1.getText().toString());
                            y = Double.valueOf(editText2.getText().toString());
                            a = Double.valueOf(editText3.getText().toString());
                            b = Double.valueOf(editText4.getText().toString());

                            if (editText1.getText().toString().equals("") ||
                                    editText2.getText().toString().equals("") ||
                                    editText3.getText().toString().equals("") ||
                                    editText4.getText().toString().equals("")) {
                                finalValue.setText("Вы не забыли вписать число?");
                            } else {
                                finalValue.setText(getResources().getString(R.string.third_task_format,
                                        ((Math.sqrt(x + b - a) + Math.log(y)) / Math.atan(b + a))));
                            }
                        }
                    });
                    break;
                }
                case 4: {
                    rootView = inflater.inflate(R.layout.task_four_fragment, container, false);

                    boolean x = false;
                    boolean y = false;
                    boolean z = true;

                    TextView firstAnswer = rootView.findViewById(R.id.first_answer);
                    firstAnswer.setText(String.valueOf(x || y && !z));
                    TextView secondAnswer = rootView.findViewById(R.id.second_answer);
                    secondAnswer.setText(String.valueOf(!x && !z));
                    TextView thirdAnswer = rootView.findViewById(R.id.third_answer);
                    thirdAnswer.setText(String.valueOf(!(x && z) || y));
                    break;
                }
                case 5: {
                    rootView = inflater.inflate(R.layout.task_five_fragment, container, false);

                    final EditText editText = rootView.findViewById(R.id.editText);

                    final TextView result = rootView.findViewById(R.id.resultTextView);

                    Button button = rootView.findViewById(R.id.button);

                    button.setOnClickListener(new View.OnClickListener() {
                        Double value;

                        @Override
                        public void onClick(View view) {

                            value = Double.valueOf(editText.getText().toString());

                            if (editText.getText().toString().equals("")) {
                                result.setText("Введите число.");
                            } else if (value >= 0 && value <= 5000) {
                                result.setText(getResources().getString(R.string.fifth_task_format,
                                        value * 0.20));
                            } else if (value > 5000 && value <= 10000) {
                                result.setText(getResources().getString(R.string.fifth_task_format,
                                        value * 0.22));
                            } else {
                                result.setText("Введено неправильное значение.");
                            }
                        }
                    });
                    break;
                }
                case 6: {
                    rootView = inflater.inflate(R.layout.two_value_computation_fragment, container, false);

                    TextView valueName1 = rootView.findViewById(R.id.valueName1);
                    valueName1.setText("x");
                    TextView valueName2 = rootView.findViewById(R.id.valueName2);
                    valueName2.setText("y");

                    Button button = rootView.findViewById(R.id.button);

                    final EditText editText1 = rootView.findViewById(R.id.editText1);
                    final EditText editText2 = rootView.findViewById(R.id.editText2);

                    final TextView finalValue = rootView.findViewById(R.id.finalValue);
                    TextView formuleTextView = rootView.findViewById(R.id.formuleTextView);
                    formuleTextView.setText("Введите координаты точки");

                    button.setOnClickListener(new View.OnClickListener() {

                        Double x;
                        Double y;

                        @Override
                        public void onClick(View view) {
                            x = Double.valueOf(editText1.getText().toString());
                            y = Double.valueOf(editText2.getText().toString());

                            if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                                finalValue.setText("Вы не забыли вписать число?");
                            } else if (x > 0) {
                                if (y > 0) {
                                    finalValue.setText(getResources().getString(R.string.sixth_task_format,
                                            1));
                                } else {
                                    finalValue.setText(getResources().getString(R.string.sixth_task_format,
                                            4));
                                }
                            } else if (x < 0) {
                                if (y > 0) {
                                    finalValue.setText(getResources().getString(R.string.sixth_task_format,
                                            2));
                                } else {
                                    finalValue.setText(getResources().getString(R.string.sixth_task_format,
                                            3));
                                }
                            } else {
                                finalValue.setText("Вы ввели 0 , 0");
                            }
                        }
                    });
                    break;
                }
                default:
                    rootView = inflater.inflate(R.layout.two_value_computation_fragment, container, false);
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "1";
                case 1:
                    return "2";
                case 2:
                    return "3";
                case 3:
                    return "4";
                case 4:
                    return "5";
                case 5:
                    return "6";
            }
            return null;
        }
    }
}
