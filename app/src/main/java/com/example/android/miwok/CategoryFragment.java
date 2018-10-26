package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private ArrayList<Word> words;
    private int mBackgroundColor;
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.
                            AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ||focusChange == AudioManager.
                            AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Lower the volume, keep playing
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mediaPlayer.start();
                    }
                }
            };

    public static CategoryFragment newInstance(ArrayList<Word> words, int mBackgroundColor){
        CategoryFragment f = new CategoryFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putParcelableArrayList("category",words);
        args.putInt("background",mBackgroundColor);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.words_list, container,
                false);
        // Initialize audio manager
        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        //Create an array of words and background color
        words = getArguments().getParcelableArrayList("category");
        mBackgroundColor = getArguments().getInt("background");

        //Create an array adapter to display items inside the List View
        WordAdapter itemsAdapter = new WordAdapter(getContext(),words,mBackgroundColor);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Set listener to play the corresponding audio file
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = words.get(position);
                //Request Audio Focus
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                //Start mediaplayer if permission is granted
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getContext(),word.getAudioResourceID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
        return view;
    }

    public void releaseMediaPlayer(){
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
