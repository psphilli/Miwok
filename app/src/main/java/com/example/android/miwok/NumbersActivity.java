package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    private final String LOG_TAG = NumbersActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // English numbers
        ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
                new Word("one", "lutti"),
                new Word("two", "otiiko"),
                new Word("three", "tolookosu"),
                new Word("four", "oyyisa"),
                new Word("five", "massokka"),
                new Word("six", "temmokka"),
                new Word("seven", "kenekaku"),
                new Word("eight", "kawinta"),
                new Word("nine", "wo'e"),
                new Word("ten", "na'aacha")
        ));



        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ArrayAdapter<Word> itemsAdapter =
                new ArrayAdapter<Word>(this, R.layout.list_item, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);
//        GridView listView = (GridView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);


/* old school
        LinearLayout rootView = findViewById(R.id.rootView);
        for (int i = 0; i < words.size(); i++)
        {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(i));
            rootView.addView(wordView);
            //Log.i(LOG_TAG, "Word at index " + i + ": " + words.get(i));
        }
*/
    }
}
