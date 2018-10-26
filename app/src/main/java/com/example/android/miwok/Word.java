package com.example.android.miwok;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link Word} represents a vocabulary word thta the user wants to learn
 * It contains a default translation and a Miwok translation for a certain word
 * and also an image that helps creating a connection to the word
 */
public class Word implements Parcelable {

    private String mMiwokTranslation;
    private String mDefautTranslation;
    private int mAudioResourceID;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new Word object
     * @param miwokTranslation is the Miwok tranlastion of the word
     * @param defautTranslation is the default translations of the word in a language the user is
     *                          familiar with
     * @param mImageResourceID is the id of the resource file with the image related to the word
     * @param mAudioResourceID is the id of the resource file with the audios related to the word
     */
    public Word (String miwokTranslation,String defautTranslation, int mImageResourceID,
                 int mAudioResourceID){
        this.mMiwokTranslation = miwokTranslation;
        this.mDefautTranslation = defautTranslation;
        this.mImageResourceID = mImageResourceID;
        this.mAudioResourceID = mAudioResourceID;
    }

    /**
     * Create a new Word object
     *
     * @param miwokTranslation  is the Miwok tranlastion of the word
     * @param defautTranslation is the default translations of the word in a language the user is
     *                          familiar with
     * @param mAudioResourceID is the id of the resource file with the audios related to the word
     */
    public Word (String miwokTranslation,String defautTranslation, int mAudioResourceID){
        this.mMiwokTranslation = miwokTranslation;
        this.mDefautTranslation = defautTranslation;
        this.mAudioResourceID = mAudioResourceID;
    }

    protected Word(Parcel in) {
        mMiwokTranslation = in.readString();
        mDefautTranslation = in.readString();
        mAudioResourceID = in.readInt();
        mImageResourceID = in.readInt();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefautTranslation(){
        return mDefautTranslation;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    public int getAudioResourceID() { return mAudioResourceID; }

    public boolean hasImage(){ return mImageResourceID != NO_IMAGE_PROVIDED; }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefautTranslation='" + mDefautTranslation + '\'' +
                ", mImageResourceID=" + mImageResourceID +
                ", mAudioResourceID=" + mAudioResourceID +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mMiwokTranslation);
        parcel.writeString(mDefautTranslation);
        parcel.writeInt(mAudioResourceID);
        parcel.writeInt(mImageResourceID);
    }
}


