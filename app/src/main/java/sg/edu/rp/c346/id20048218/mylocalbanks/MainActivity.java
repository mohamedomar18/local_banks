package sg.edu.rp.c346.id20048218.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView DBS;
    TextView OCBC;
    TextView UOB;
    String bankSelected;
    String dbsBankNumber;
    String ocbcBankNumber;
    String uobBankNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.tvDBS);
        OCBC = findViewById(R.id.tvOCBC);
        UOB = findViewById(R.id.tvUOB);
        bankSelected = "";
        dbsBankNumber = "18001111111";
        ocbcBankNumber = "1800 363 3333";
        uobBankNumber = "1800 222 2121";


        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v == DBS) {
            bankSelected = "DBS";
            Log.v("Context", "DBS is selected");
        }
        else if (v == OCBC) {
            bankSelected = "OCBC";
            Log.v("Context", "OCBC is selected");
        }
        else {
            bankSelected = "UOB";
            Log.v("Context", "UOB is selected");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (bankSelected.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0 ) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(viewIntent);
            }
            else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+dbsBankNumber));
                startActivity(intentCall);
            }
        } else if (bankSelected.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0 ) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.ocbc.com/personal-banking"));
                startActivity(viewIntent);
            }
            else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ocbcBankNumber));
                startActivity(intentCall);
            }
        } else {
            if (item.getItemId() == 0) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.uobgroup.com/uobgroup/default.page"));
                startActivity(viewIntent);
            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +uobBankNumber));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(item);
    }
}