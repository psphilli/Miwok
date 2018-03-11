package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // English / Miwok family members
        final ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
                new Word("father", "әpә", R.drawable.family_father, R.raw.family_father),
                new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother),
                new Word("son", "angsi", R.drawable.family_son, R.raw.family_son),
                new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter),
                new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother),
                new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother),
                new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister),
                new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister),
                new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother),
                new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather)
        ));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mediaPlayer = MediaPlayer.create(FamilyActivity.this, words.get(position).getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}
