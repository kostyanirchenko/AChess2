package com.chess.android.achess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button gameButton;
    private Button blitzGameButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gameButton = (Button) findViewById(R.id.gameButton);
        blitzGameButton = (Button) findViewById(R.id.blitzGameButton);
        exitButton = (Button) findViewById(R.id.exitButton);

        gameButton.setOnClickListener(this);
        blitzGameButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.action_about));
                builder.setMessage(getResources().getString(R.string.about));
                builder.setPositiveButton("Закрыть", null);
                builder.show();
                break;
            case R.id.action_exit:
                closeAll();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gameButton:
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("BlitzMode", false);
                startActivity(intent);
                break;
            case R.id.blitzGameButton:
                Intent intent2 = new Intent(this, GameActivity.class);
                intent2.putExtra("BlitzMode", true);
                startActivity(intent2);
                break;
            case R.id.exitButton:
                closeAll();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        closeAll();
    }

    private void closeAll() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.exitMessage));
        builder.setPositiveButton("Таки да!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Ой, всьо!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO
            }
        });
        builder.show();
    }
}
