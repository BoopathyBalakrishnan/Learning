/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.tnea.legacy.service.dao;

import java.util.List;
import java.util.Map;

import com.blx.app.adrd.tnprofcounseling.framework.dao.DAO;
import com.blx.app.adrd.tnprofcounseling.tnea.legacy.domain.TNEALegacyCounseling;

/**
 * @author Nanjundan Chinnasamy
 * @version 1.0
 * 
 */
public interface TNEALegacyDAO extends DAO {

	public static final String DAO_KEY = "TNEA_LEGACY_DAO";

	/**
	 * Method that fetched the list of available departments
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> findAllDepartments() throws Exception;

	/**
	 * Method that find the all available categories
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> findAllCategories() throws Exception;

	/**
	 * Method that find the all getTNEALegacyCouncelling results
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TNEALegacyCounseling> findTNEALegacyCounselingResultsByCrit() throws Exception;
}
