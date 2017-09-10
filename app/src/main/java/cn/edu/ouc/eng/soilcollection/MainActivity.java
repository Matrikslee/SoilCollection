package cn.edu.ouc.eng.soilcollection;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static cn.edu.ouc.eng.soilcollection.R.id.txtDeviceNumber;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean deviceConnection = false;
    private int mDeviceNumber = 1;

    public void btnDeviceNumberInc(View v) {
        TextView txtDeviceNumber = (TextView) findViewById(R.id.txtDeviceNumber);
        if(mDeviceNumber < 8) {
            mDeviceNumber++;
        }
        txtDeviceNumber.setText(""+mDeviceNumber);
    }

    public void btnDeviceNumberDec(View v) {
        TextView txtDeviceNumber = (TextView) findViewById(R.id.txtDeviceNumber);
        if(mDeviceNumber > 1) {
            mDeviceNumber--;
        }
        txtDeviceNumber.setText(""+mDeviceNumber);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button btnsendCommand = (Button) findViewById(R.id.btnSendCommand);
        btnsendCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deviceConnection) {
                    //send data via bluetooth adapter
                } else {
                    Toast.makeText(MainActivity.this, "未成功连接设备，请先连接。",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView txtDeviceNumber = (TextView) findViewById(R.id.txtDeviceNumber);
        txtDeviceNumber.setText(""+mDeviceNumber);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_samplingSettings) {
            Intent samplingSettings = new Intent(this, samplingSettingsActivity.class);
            startActivity(samplingSettings);
        } else if (id == R.id.nav_dataQuery) {
            Intent dataQuery = new Intent(this, dataQueryActivity.class);
            startActivity(dataQuery);
        } else if (id == R.id.nav_about) {
            final Dialog aboutDialog = new Dialog(this);
            aboutDialog.setContentView(R.layout.about_dialog);
            aboutDialog.setTitle(R.string.about_title);
            aboutDialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
