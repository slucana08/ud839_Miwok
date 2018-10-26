package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {super(fm);}

    @Override
    public Fragment getItem(int position) {
        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("lutti","one",R.drawable.number_one,
                R.raw.number_one));
        numbers.add(new Word("otiiko","two",R.drawable.number_two,
                R.raw.number_two));
        numbers.add(new Word("tolookosu","three",
                R.drawable.number_three,R.raw.number_three));
        numbers.add(new Word("oyyisa","four",
                R.drawable.number_four,R.raw.number_four));
        numbers.add(new Word("massokka","five",
                R.drawable.number_five,R.raw.number_five));
        numbers.add(new Word("temmokka","six",
                R.drawable.number_six,R.raw.number_six));
        numbers.add(new Word("kenekaku","seven",
                R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new Word("kawinta","eight",
                R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new Word("wo’e","nine",
                R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Word("na’aacha","ten",
                R.drawable.number_ten,R.raw.number_ten));

        ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("minto wuksus","Where are you going?",
                R.raw.phrase_where_are_you_going));
        phrases.add(new Word("tinnә oyaase'nә","What is your name?",
                R.raw.phrase_what_is_your_name));
        phrases.add(new Word("oyaaset...","My name is...",
                R.raw.phrase_my_name_is));
        phrases.add(new Word("michәksәs?","How are you feeling?",
                R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("kuchi achit","I'm feeling good",
                R.raw.phrase_im_feeling_good));
        phrases.add(new Word("әәnәs'aa?","Are you coming?",
                R.raw.phrase_are_you_coming));
        phrases.add(new Word("hәә’ әәnәm","Yes, I'm coming?",
                R.raw.phrase_yes_im_coming));
        phrases.add(new Word("әәnәm","I'm coming",
                R.raw.phrase_im_coming));
        phrases.add(new Word("yoowutis","Let's go",
                R.raw.phrase_lets_go));
        phrases.add(new Word("әnni'nem","Come here",
                R.raw.phrase_come_here));

        ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("әpә","father",
                R.drawable.family_father,R.raw.family_father));
        family.add(new Word("әṭa","mother",
                R.drawable.family_mother,R.raw.family_mother));
        family.add(new Word("angsi","son",
                R.drawable.family_son,R.raw.family_son));
        family.add(new Word("tune","daughter",
                R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new Word("taachi","older brother",
                R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new Word("chalitti","younger brother",
                R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new Word("teṭe","older sister",
                R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new Word("kolliti","younger sister",
                R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new Word("ama","grandmother",
                R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new Word("paapa","grandfather",
                R.drawable.family_grandfather,R.raw.family_grandfather));

        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("weṭeṭṭi","red",
                R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("chokokki","green",
                R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("ṭakaakki","brown",
                R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("ṭopoppi","gray",
                R.drawable.color_gray,R.raw.color_gray));
        colors.add(new Word("kululli","black",
                R.drawable.color_black,R.raw.color_black));
        colors.add(new Word("kelelli","white",
                R.drawable.color_white,R.raw.color_white));
        colors.add(new Word("ṭopiisә","dusty yellow",
                R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new Word("chiwiiṭә","mustard yellow",
                R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        switch (position){
            case 0: return CategoryFragment.newInstance(numbers,R.color.category_numbers);
            case 1: return CategoryFragment.newInstance(family,R.color.category_family);
            case 2: return CategoryFragment.newInstance(colors,R.color.category_colors);
            default: return CategoryFragment.newInstance(phrases,R.color.category_phrases);
        }
    }

    @Override
    public int getCount() { return 4; }
}
