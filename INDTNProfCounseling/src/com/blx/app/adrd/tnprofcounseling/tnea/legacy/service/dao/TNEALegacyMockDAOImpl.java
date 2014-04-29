/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.tnea.legacy.service.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blx.app.adrd.tnprofcounseling.tnea.legacy.domain.TNEALegacyCounseling;

/**
 * @author Nanjundan Chinnasamy
 * @version 1.0
 *
 */
public class TNEALegacyMockDAOImpl implements TNEALegacyDAO {

	/**
	 * 
	 * @see com.blx.android.app.tnea.service.dao.TNEALegacyDAO#findAllDepartments()
	 */
	public Map<String, String> findAllDepartments() throws Exception {
		Map<String, String> deptsMap= new HashMap<String, String>(5);
		deptsMap.put("ECE","Electronics & Comm Eng");
		deptsMap.put("CSE","Comuter Sc Engg..");
		deptsMap.put("EEE","Electrical & Electronics Engg..");
		deptsMap.put("IT","Information Tech Engg..");
		return deptsMap;
	}

	/**
	 * 
	 * @see com.blx.android.app.tnea.service.dao.TNEALegacyDAO#findAllCategories()
	 */
	public Map<String, String> findAllCategories() throws Exception {
		Map<String, String> catgrysMap= new HashMap<String, String>(5);
		catgrysMap.put("OC","OC");
		catgrysMap.put("BC","BC");
		catgrysMap.put("BCA","BCA");
		catgrysMap.put("MBC","MBC");
		catgrysMap.put("SC","SC");
		catgrysMap.put("SCA","SCA");
		catgrysMap.put("ST","ST");
		return catgrysMap;
	}

	/**
	 * 
	 * @see com.blx.android.app.tnea.service.dao.TNEALegacyDAO#findTNEALegacyCounselingResultsByCrit()
	 */
	public List<TNEALegacyCounseling> findTNEALegacyCounselingResultsByCrit() throws Exception {

		List<TNEALegacyCounseling> result = new ArrayList<TNEALegacyCounseling>(5);
		TNEALegacyCounseling counselling1 = new TNEALegacyCounseling();
		counselling1.setCollegeRank(1);
		counselling1.setCollegeCode(2001);
		counselling1.setCollegeName("ABBCBC");
		counselling1.setDepartment("ECE");
		counselling1.setCutOffMark(123);
		counselling1.setYearRank(234);

		result.add(counselling1);
		counselling1 = null;

		TNEALegacyCounseling counselling2 = new TNEALegacyCounseling();
		counselling2.setCollegeRank(2);
		counselling2.setCollegeCode(2002);
		counselling2.setCollegeName("ACBC");
		counselling2.setDepartment("CSE");
		counselling2.setCutOffMark(199);
		counselling2.setYearRank(234);

		result.add(counselling2);
		counselling2 = null;

		TNEALegacyCounseling counselling3 = new TNEALegacyCounseling();
		counselling3.setCollegeRank(3);
		counselling3.setCollegeCode(2010);
		counselling3.setCollegeName("SCDE");
		counselling3.setDepartment("EEE");
		counselling3.setCutOffMark(188);
		counselling3.setYearRank(100);

		result.add(counselling3);
		counselling3 = null;

		TNEALegacyCounseling counselling4 = new TNEALegacyCounseling();
		counselling4.setCollegeRank(4);
		counselling4.setCollegeCode(2011);
		counselling4.setCollegeName("BCBC");
		counselling4.setDepartment("IT");
		counselling4.setCutOffMark(183);
		counselling4.setYearRank(200);

		result.add(counselling4);
		counselling4 = null;
		return result;
	}
}