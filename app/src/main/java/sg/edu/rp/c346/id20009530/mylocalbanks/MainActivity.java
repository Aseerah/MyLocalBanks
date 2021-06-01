package sg.edu.rp.c346.id20009530.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonDBS;
    Button buttonOCBC;
    Button buttonUOB;
    TextView tvLocalBanks;
    String clicked = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDBS = findViewById(R.id.btnDBS);
        buttonOCBC = findViewById(R.id.btnOCBC);
        buttonUOB = findViewById(R.id.btnUOB);
        tvLocalBanks = findViewById(R.id.title);

        registerForContextMenu(buttonDBS);
        registerForContextMenu(buttonOCBC);
        registerForContextMenu(buttonUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == buttonDBS) {
            clicked = "DBS";

        } else if (v == buttonOCBC) {
            clicked = "OCBC";

        } else if (v == buttonUOB) {
            clicked = "UOB";

        } else {
            clicked = " ";
        }

        getMenuInflater().inflate(R.menu.menu_banks, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (clicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.web) {
                Log.d("onContextItemSelected", "web dbs 100 id working");

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                return true;
            } else if (id == R.id.call) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18001111111"));
                startActivity(intentCall);

                return true;
            }

        } else if (clicked.equalsIgnoreCase("OCBC")) {

            if (id == R.id.web) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true;
            } else if (id == R.id.call) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18003633333"));
                startActivity(intentCall);

                return true;
            }

        } else if (clicked.equalsIgnoreCase("UOB")) {
            if (id == R.id.web) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

                return true;
            } else if (id == R.id.call) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18002222121"));
                startActivity(intentCall);

                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.selectEnglish) {
            buttonDBS.setText("DBS");
            buttonOCBC.setText("OCBC");
            buttonUOB.setText("UOB");
            tvLocalBanks.setText("My Local Banks");
            return true;

        } else if (id == R.id.selectChinese) {
            buttonDBS.setText("星展银行");
            buttonOCBC.setText("华侨银行");
            buttonUOB.setText("大华银行");
            tvLocalBanks.setText("我的本地银行");
            return true;

        } else {
            buttonDBS.setText("Error translation");
            buttonOCBC.setText("Error translation");
            buttonUOB.setText("Error translation");
            tvLocalBanks.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);

    }

}