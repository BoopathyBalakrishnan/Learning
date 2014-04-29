/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.framework.dao;

import java.util.HashMap;
import java.util.Map;

import com.blx.app.adrd.tnprofcounseling.framework.FrameworkConstants;

import android.content.Context;

/**
 * 
 * @author Nanjundan Chinnasamy
 * @version 1.0
 * 
 */
public final class CounselingDAOFactory extends DAOFactory {
	private static CounselingDAOFactory counselingDAOFactory;
	private static final Map<String, DAO> daoCache = new HashMap<String, DAO>(10);

	/**
	 * One arg constructor method
	 * @param context
	 */
	private CounselingDAOFactory(Context context) {
		super(context);
	}

	/**
	 * Method that returns singleton CounselingDAOFactory instance
	 * 
	 * @param context
	 * @return
	 */
	public static CounselingDAOFactory getTNEADaoFactoryInstance(Context context) {
		if (counselingDAOFactory == null) 
			counselingDAOFactory = new CounselingDAOFactory(context);
			return counselingDAOFactory;
	}
	
	/**
	 * Method that returns singleton generic DAO  instance
	 * 
	 * @param daoName
	 * @return
	 */
	public static DAO getDAO(String daoKey){
		DAO dao = daoCache.get(daoKey);
		if(dao==null){
			DAOConfig daoConfig = daoConfigCacheMap.get(daoKey);
			String daoImplClass = getDAOImplClassNameByKeyFromConfig(daoConfig);
			try {
				dao=(DAO) Thread.currentThread().getContextClassLoader().loadClass(daoImplClass).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			daoCache.put(daoKey, dao);
		}
		return dao;
	} 
	
	/**
	 * Method that returns singleton implementation class names for the given daoconfig
	 * 
	 * @param daoConfig
	 * @return
	 */
	private static String getDAOImplClassNameByKeyFromConfig(DAOConfig daoConfig){
		if(daoConfig.getSelKey().equalsIgnoreCase(FrameworkConstants.IMPL_CLASS_TYPE_DB)){
			return daoConfig.getDbImplClass();
		} else if(daoConfig.getSelKey().equalsIgnoreCase(FrameworkConstants.IMPL_CLASS_TYPE_MK)){
			return daoConfig.getMkImplClass();
		} else if(daoConfig.getSelKey().equalsIgnoreCase(FrameworkConstants.IMPL_CLASS_TYPE_WS)){
			return daoConfig.getWsImplClass();
		}
		return null;
	}
}
