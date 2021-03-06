package org.example.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class Sudoku extends Activity implements OnClickListener {
    
    private static final String TAG = "Sudoku";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Set up click listeners
        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        findViewById(R.id.new_button).setOnClickListener(this);
        findViewById(R.id.about_button).setOnClickListener(this);
        findViewById(R.id.exit_button).setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.about_button:
            Intent i = new Intent(this, About.class);
            startActivity(i);
            break;
        case R.id.new_button:
            openNewGameDialog();
            break;
        case R.id.exit_button:
            finish(); 
        }        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.settings:
            startActivity(new Intent(this, Prefs.class));
            return true;
        }
        return false;
    }
    
    private void openNewGameDialog() {
        new AlertDialog.Builder(this)
            .setTitle(R.string.new_game_title)
            .setItems(R.array.difficulty, new DialogInterface.OnClickListener() {
                
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    startGame(i);
                }
            })
            .show();     
    }
    
    private void startGame(int i) {
        Log.d(TAG, "clicked on " + i);
        // start game here...
    }
    
    
}