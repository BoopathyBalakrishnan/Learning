/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.framework.dao;

/**
 * Class that Encapsulate the DAO configuration details
 * 
 * @author Nanjundan Chinnasamyw
 * @version 1.0
 * 
 */
public class DAOConfig {
	/* holds daokey specific to the service we are offering */
	private String daoKey;
	/* Values can be DB-dbImpl, WS-Webservice Impl, MK-Mock Data Impl */
	private String dbImplClass;
	private String wsImplClass;
	private String mkImplClass;
	private String selKey;

	/**
	 * @return the daoKey
	 */
	public String getDaoKey() {
		return daoKey;
	}

	/**
	 * @param daoKey
	 *            the daoKey to set
	 */
	public void setDaoKey(String daoKey) {
		this.daoKey = daoKey;
	}

	/**
	 * @return the dbImplClass
	 */
	public String getDbImplClass() {
		return dbImplClass;
	}

	/**
	 * @param dbImplClass
	 *            the dbImplClass to set
	 */
	public void setDbImplClass(String dbImplClass) {
		this.dbImplClass = dbImplClass;
	}

	/**
	 * @return the wsImplClass
	 */
	public String getWsImplClass() {
		return wsImplClass;
	}

	/**
	 * @param wsImplClass
	 *            the wsImplClass to set
	 */
	public void setWsImplClass(String wsImplClass) {
		this.wsImplClass = wsImplClass;
	}

	/**
	 * @return the mkImplClass
	 */
	public String getMkImplClass() {
		return mkImplClass;
	}

	/**
	 * @param mkImplClass
	 *            the mkImplClass to set
	 */
	public void setMkImplClass(String mkImplClass) {
		this.mkImplClass = mkImplClass;
	}

	/**
	 * @return the selKey
	 */
	public String getSelKey() {
		return selKey;
	}

	/**
	 * @param selKey the selKey to set
	 */
	public void setSelKey(String selKey) {
		this.selKey = selKey;
	}
	
	public String toString(){
		return "DAOConfig>>>  daoKey>>"+daoKey  +""+dbImplClass+ "   "+mkImplClass+"     "+wsImplClass+ "   "+selKey;
	}
}
