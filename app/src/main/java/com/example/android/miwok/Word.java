package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word thta the user wants to learn
 * It contains a default translation and a Miwok translation for a certain word
 */
public class Word {

    private String mMiwokTranslation;
    private String mDefautTranslation;

    /**
     * Create a new Word object
     * @param miwokTranslation is the Miwok tranlastion of the word
     * @param defautTranslation is the default translations of the word in a language the user is
     *                          familiar with
     */
    public Word (String miwokTranslation,String defautTranslation){
        this.mMiwokTranslation = miwokTranslation;
        this.mDefautTranslation = defautTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefautTranslation(){
        return mDefautTranslation;
    }
}
