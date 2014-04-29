package com.blx.app.adrd.tnprofcounseling.tnea.legacy.ui.activity;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.blx.app.adrd.tnprofcounseling.R;
import com.blx.app.adrd.tnprofcounseling.tnea.legacy.domain.TNEALegacyCounseling;
import com.blx.app.adrd.tnprofcounseling.tnea.legacy.service.facade.TNEALegacyFacade;

public class TNEALegacySearchResult extends Activity {
	Button backBtn, closeBtn;

	private int tableRowIdStartValue = 100;
	private TableLayout tableLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tnea_legacy_search_result);
		backBtn = (Button) findViewById(R.id.tneaLegacySRBackBtnId);
		backBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				finish();
			}
		});

		closeBtn = (Button) findViewById(R.id.tneaLegacySRCloseBtnId);
		closeBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				moveTaskToBack(true);

			}
		});

		tableLayout = (TableLayout) findViewById(R.id.main_table);

		// tablerow 1
		TableRow tr_head = new TableRow(this);
		tr_head.setId(tableRowIdStartValue);
		tr_head.setBackgroundColor(Color.GRAY);
		tr_head.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		// College Rank ColumnHeader
		TextView label_cRank = new TextView(this);
		label_cRank.setId(11);
		label_cRank.setText("C Rank");
		label_cRank.setTextColor(Color.BLACK);
		label_cRank.setPadding(0, 5, 5, 5);
		tr_head.addView(label_cRank);

		// College Code ColumnHeader
		TextView label_cCode = new TextView(this);
		label_cCode.setId(12);
		label_cCode.setText("C CODE");
		label_cCode.setTextColor(Color.BLACK);
		label_cCode.setPadding(0, 5, 5, 5);
		tr_head.addView(label_cCode);

		// Dept ColumnHeader
		TextView label_dept = new TextView(this);
		label_dept.setId(13);
		label_dept.setText("Department");
		label_dept.setTextColor(Color.BLACK);
		label_dept.setPadding(0, 5, 5, 5);
		tr_head.addView(label_dept);

		// CutOffMark ColumnHeader
		TextView label_cutOffMark = new TextView(this);
		label_cutOffMark.setId(14);
		label_cutOffMark.setText("CutOffMark");
		label_cutOffMark.setTextColor(Color.BLACK);
		label_cutOffMark.setPadding(0, 5, 5, 5);
		tr_head.addView(label_cutOffMark);

		// Year Rank ColumnHeader
		TextView label_yearRank = new TextView(this);
		label_yearRank.setId(15);
		label_yearRank.setText("yearRank");
		label_yearRank.setTextColor(Color.BLACK);
		label_cutOffMark.setPadding(0, 5, 5, 5);
		tr_head.addView(label_yearRank);

		tableLayout.addView(tr_head, new TableLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

		// Adding result to the table Layout
		List<TNEALegacyCounseling> councellingResult;
		try {
			councellingResult = TNEALegacyFacade.getInstance().findTNEALegacyCouncellingResultsByCriteria(getApplicationContext());
			int resultContentTextViewIdStartValue = 1000;

			for (TNEALegacyCounseling counsellingObj : councellingResult) {
				tableRowIdStartValue++;
				TableRow tr_content = new TableRow(this);
				tr_content.setId(tableRowIdStartValue);
				tr_content.setLayoutParams(new LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

				// College Rank Column value
				TextView data_cRank = new TextView(this);
				data_cRank.setId(++resultContentTextViewIdStartValue);
				data_cRank.setText(String.valueOf(counsellingObj.getCollegeRank()));
				data_cRank.setTextColor(Color.BLACK);
				data_cRank.setPadding(0, 5, 5, 5);
				tr_content.addView(data_cRank);

				// College Code Column value
				TextView data_cCode = new TextView(this);
				data_cCode.setId(++resultContentTextViewIdStartValue);
				data_cCode.setText(String.valueOf(counsellingObj.getCollegeCode()));
				data_cCode.setTextColor(Color.BLACK);
				data_cCode.setPadding(0, 5, 5, 5);
				tr_content.addView(data_cCode);

				// Dept Column value
				TextView data_dept = new TextView(this);
				data_dept.setId(++resultContentTextViewIdStartValue);
				data_dept.setText(counsellingObj.getDepartment());
				data_dept.setTextColor(Color.BLACK);
				data_dept.setPadding(0, 5, 5, 5);
				tr_content.addView(data_dept);

				// CutOffMark Column value
				TextView data_cutOffMark = new TextView(this);
				data_cutOffMark.setId(++resultContentTextViewIdStartValue);
				data_cutOffMark.setText(String.valueOf(counsellingObj
						.getCutOffMark()));
				data_cutOffMark.setTextColor(Color.BLACK);
				data_cutOffMark.setPadding(0, 5, 5, 5);
				tr_content.addView(data_cutOffMark);

				// Year Rank Column value
				TextView data_yearRank = new TextView(this);
				data_yearRank.setId(++resultContentTextViewIdStartValue);
				data_yearRank.setText(String.valueOf(counsellingObj.getYearRank()));
				data_yearRank.setTextColor(Color.BLACK);
				data_yearRank.setPadding(0, 5, 5, 5);
				tr_content.addView(data_yearRank);

				tableLayout.addView(tr_content, new TableLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
