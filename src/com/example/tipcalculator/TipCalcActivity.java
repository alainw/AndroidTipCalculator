package com.example.tipcalculator;

import java.util.Currency;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalcActivity extends Activity {

	private EditText etAmount;
	private TextView tvTipView;
	private String symbol;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
		etAmount = (EditText)findViewById(R.id.editText);
		tvTipView = (TextView)findViewById(R.id.tipview);
		symbol = Currency.getInstance(Locale.getDefault()).getSymbol();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}

	public void onClick10(View v) {
	    setTip(10);
	}
	
	public void onClick15(View v) {	
		setTip(15);
	}
	
	public void onClick20(View v) {	
		setTip(20);
	}
	
	private void setTip(int percent) {
	    String amount = etAmount.getText().toString();
	    double tip = 0;
	    try {
	      tip = Float.parseFloat(amount) * (percent/100.0);
	    } catch (NumberFormatException nfe) {
	    	// For non numbers return 0
	    }
	    tvTipView.setText(symbol+String.format("%1$,.2f", tip));
	}
	
}
