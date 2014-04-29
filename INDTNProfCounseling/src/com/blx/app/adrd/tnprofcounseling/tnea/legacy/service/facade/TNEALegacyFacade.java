/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.tnea.legacy.service.facade;

import java.util.List;
import java.util.Map;

import android.content.Context;

import com.blx.app.adrd.tnprofcounseling.framework.dao.CounselingDAOFactory;
import com.blx.app.adrd.tnprofcounseling.tnea.legacy.domain.TNEALegacyCounseling;
import com.blx.app.adrd.tnprofcounseling.tnea.legacy.service.dao.TNEALegacyDAO;

/**
 * TNEALegacyFacade class that encapsulates all the related business methods related to TNEA Legacy implementation
 * 
 * @author Nanjundan Chinnasamy
 * @version 1.0
 * 
 */
public class TNEALegacyFacade {
	private static final String DAO_KEY = "tneaLegacy";
	private static final TNEALegacyFacade INSTANCE = new TNEALegacyFacade();

	private TNEALegacyFacade() {
	}

	/**
	 * Singleton method which returns TNEALegacyFacade instance
	 * 
	 * @return
	 */
	public static TNEALegacyFacade getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Method that returns singleton CounselingDAOFactory instance method 
	 *  
	 * @param context
	 * @return
	 * @throws Exception
	 */
	private static CounselingDAOFactory getTNEALegacyDAOInstance(Context context) throws Exception{
		return(CounselingDAOFactory) CounselingDAOFactory.getTNEADaoFactoryInstance(context);
	}
	
	/**
	 * Method that returns all departments reference data 
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public Map<String, String> findAllDepartments(Context context) throws Exception {
		Map<String, String> allDeptList = null;
		TNEALegacyDAO tneaDAO =(TNEALegacyDAO) getTNEALegacyDAOInstance(context).getDAO(DAO_KEY);
		 allDeptList = tneaDAO.findAllDepartments();
		return allDeptList;
	}
	
	/**
	 * Method that returns all categories reference data 
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public Map<String, String> findAllCategories(Context context) throws Exception {
		Map<String, String> allCategoryList = null;
		TNEALegacyDAO tneaDAO =(TNEALegacyDAO) getTNEALegacyDAOInstance(context).getDAO(DAO_KEY);
		allCategoryList = tneaDAO.findAllCategories();
		return allCategoryList;
	}
	
	
	/**
	 * Method that returns all TNEA Legacy counseling results 
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public List<TNEALegacyCounseling> findTNEALegacyCouncellingResultsByCriteria(Context context) throws Exception {
		List<TNEALegacyCounseling>  tneaCounselingResults= null;
		TNEALegacyDAO tneaDAO =(TNEALegacyDAO) getTNEALegacyDAOInstance(context).getDAO(DAO_KEY);
		tneaCounselingResults = tneaDAO.findTNEALegacyCounselingResultsByCrit();
		return tneaCounselingResults;
	}
}