package com.blx.app.adrd.tnprofcounseling.tnea.legacy.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.blx.app.adrd.tnprofcounseling.R;
import com.blx.app.adrd.tnprofcounseling.framework.Validator.TNEAValidator;
import com.blx.app.adrd.tnprofcounseling.tnea.legacy.service.facade.TNEALegacyFacade;

public class TNEALegacySearchCriteria extends Activity {
	Button clr, search;
	EditText cutoff, clgcode;
	Spinner dept, category;
	CheckBox ch1, ch2, ch3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tnea_legacy_search_criteria);
		search = (Button) findViewById(R.id.tneaLegacySCSearchBtnId);
		clr = (Button) findViewById(R.id.tneaLegacySCClearBtnId);
		cutoff = (EditText) findViewById(R.id.tneaLegacySCCutOffETId);
		clgcode = (EditText) findViewById(R.id.tneaLegacySCClgCodeETId);
		dept = (Spinner) findViewById(R.id.tneaLegacySCDprtSpnrId);
		category = (Spinner) findViewById(R.id.tneaLegacySCCtgrySpnrId);
		ch1 = (CheckBox) findViewById(R.id.tneaLegacySCYear1ChkBoxId);
		ch2 = (CheckBox) findViewById(R.id.tneaLegacySCYear2ChkBoxId);
		ch3 = (CheckBox) findViewById(R.id.tneaLegacySCYear3ChkBoxId);
		
		try {
			System.out.println("Data>>"+TNEALegacyFacade.getInstance().findAllDepartments(getApplicationContext()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		search.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				validateTNEALegacyInputs();
				Intent selectactivity = new Intent();
				selectactivity.setClass(getApplicationContext(),
						TNEALegacySearchResult.class);
				startActivity(selectactivity);

				/*
				 * String getcutoff = cutoff.getText().toString(); String
				 * getclgcode = clgcode.getText().toString(); String getsp1 =
				 * dept.getSelectedItem().toString(); String getsp2 =
				 * category.getSelectedItem().toString();
				 * 
				 * String text = "cut off is" + getcutoff + "\n" +
				 * "college code is " + getclgcode + "\n" + "Dept is " + getsp1
				 * + "\n" + "category is " + getsp2;
				 * Toast.makeText(getApplicationContext(), text,
				 * Toast.LENGTH_SHORT).show();
				 */}
		});

		clr.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				cutoff.setText("");
				clgcode.setText("");
				// dept.setPrompt(prompt)
				dept.setSelection(0);
				category.setSelection(0);
				ch1.setChecked(false);
				ch2.setChecked(false);
				ch3.setChecked(false);
			}
		});

	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) {
	 * getMenuInflater().inflate(R.menu.activity_select, menu); return true; }
	 */
	
	/**
	 * Method to validate the TNsEA Legacy search screen input
	 * @return
	 */
	private boolean validateTNEALegacyInputs(){
		System.out.println(TNEAValidator.validateTNEACutOffMark(cutoff));
		System.out.println(TNEAValidator.validateTNEACollegeCode(clgcode));
		System.out.println(TNEAValidator.validateTNEASpinnerSelection(dept));
		System.out.println(TNEAValidator.validateTNEASpinnerSelection(category));
		System.out.println(TNEAValidator.isCheckBoxsGroupEmpty(ch1, ch2, ch3));
		return false;
	}
}
