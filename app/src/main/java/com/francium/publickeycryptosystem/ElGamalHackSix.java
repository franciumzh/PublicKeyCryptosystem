package com.francium.publickeycryptosystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.francium.ElGamal.ElGamalMethod;
import com.francium.cipher.ElGamal;
import com.francium.cipher.Util;

public class ElGamalHackSix extends Activity {


private String exam;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elgamal_hack_six);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		ElGamalMethod.LENGTH = 101;
		ElGamal elgamal = new ElGamal(Util.NumGen(101).toString());
		TextView elgamal_hack_six_p = (TextView) findViewById(R.id.elgamal_hack_six_p);
		TextView elgamal_hack_six_a = (TextView) findViewById(R.id.elgamal_hack_six_a);
		TextView elgamal_hack_six_u = (TextView) findViewById(R.id.elgamal_hack_six_u);
		TextView elgamal_hack_six_v = (TextView) findViewById(R.id.elgamal_hack_six_v);
		elgamal_hack_six_p.setText("p = " + elgamal.getEgkm().getP().toString());
		elgamal_hack_six_a.setText("a = " + elgamal.getEgkm().getA().toString());
		elgamal_hack_six_u.setText("u = " + elgamal.getEgerm().getU().toString());
		elgamal_hack_six_v.setText("v = " + elgamal.getEgerm().getV().toString());
		exam = elgamal.getDecResult();
//		TextView a = (TextView) findViewById(R.id.elgamal_hack_six);
//		a.setText("message = "+ exam);
	}
	
	public void elgamalTest(View view) {
		EditText elgamal_hack_six_edit_text = (EditText) findViewById(R.id.elgamal_hack_six_edit_text);
		if(exam.equals(elgamal_hack_six_edit_text.getText().toString())){
            openOptionsDialog1();
        } else {
        	openOptionsDialog2();
        }
	}

	public void openOptionsDialog1() {
		new AlertDialog.Builder(this).
				setTitle("WIN").
				setMessage("恭喜你通过的第六关，点击进入下一关").
				setPositiveButton("NEXT LEVEL", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(ElGamalHackSix.this, ElGamalHackSeven.class);
						startActivity(intent);
					}
				}).show();
	}

	public void openOptionsDialog2() {
		new AlertDialog.Builder(this).
				setTitle("LOST").
				setMessage("失败了，点击重试").
				setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.hack, menu);
		getActionBar().setHomeButtonEnabled(true);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, MainActivity.class);
		    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		    startActivity(intent);
			break;
		case R.id.action_hack_next:
			Intent nextIntent = new Intent(this, ElGamalHackSeven.class);  
            startActivity(nextIntent); 
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
