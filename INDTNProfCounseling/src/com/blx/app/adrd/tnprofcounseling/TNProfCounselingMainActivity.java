package com.blx.app.adrd.tnprofcounseling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.blx.app.adrd.tnprofcounseling.tnea.legacy.ui.activity.TNEALegacySearchCriteria;

public class TNProfCounselingMainActivity extends Activity {
	private Button tneaPresent, tneaLegacy;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tn_profcounseling_activity_main);

		doMapping();
		doOnClickListener();
	}

	private void doMapping() {
		tneaPresent = (Button) findViewById(R.id.tnProfCounsHomeTNEAPresentBtnId);
		tneaLegacy = (Button) findViewById(R.id.tnProfCounsHomeTNEALegacyBtnId);
	}

	private void doOnClickListener() {
		
		// This is TNEA Present application activity
		tneaPresent.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//TODO: TNEA Present activity class needs to be mentioned here. Currently it is pointing to Legacy activity intent
				Intent tneaPresentSearchCriteriaIntent = new Intent(
						TNProfCounselingMainActivity.this,
						TNEALegacySearchCriteria.class);
				startActivity(tneaPresentSearchCriteriaIntent);
			}
		});

		// This is TNEA Legacy Activity
		tneaLegacy.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent tneaLegacySearchCriteriaIntent = new Intent(
						TNProfCounselingMainActivity.this,
						TNEALegacySearchCriteria.class);
				startActivity(tneaLegacySearchCriteriaIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
