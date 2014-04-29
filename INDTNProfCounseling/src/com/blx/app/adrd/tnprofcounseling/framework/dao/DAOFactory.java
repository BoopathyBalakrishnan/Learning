/**
 * 
 */
package com.blx.app.adrd.tnprofcounseling.framework.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.blx.app.adrd.tnprofcounseling.tnea.TNEAConunselingConstantants;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * Class that Encapsulates the  parse tnea_dao.xml file and returns DAOConfig mapping using daoKey
 * 
 * @author Nanjundan Chinnasamy
 * @version 1.0
 * 
 */
public class DAOFactory {

	public static final Map<String, DAOConfig> daoConfigCacheMap = new HashMap<String, DAOConfig>(5);

	/**
	 * 
	 * @param context
	 */
	public DAOFactory(Context context) {
		loadDaoConfiguration(context);
	}

	/**
	 *Method that parse tnea_dao.xml file and returns DAOConfig mapping using daoKey
	 * 
	 * @param daoName
	 * @return
	 */
	private static Map<String, DAOConfig> loadDaoConfiguration(Context context) {
		DAOConfig daoConfig = null;
		AssetManager assetManager = context.getAssets();
		try {
			InputStream is = assetManager.open(TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE);
			XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
			xmlPullParserFactory.setNamespaceAware(true);
			XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
			xmlPullParser.setInput(is, TNEAConunselingConstantants.UTF_8_ENCODING);
			int eventType = xmlPullParser.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_DOCUMENT) {
					//Do nothing
				} else if (eventType == XmlPullParser.END_DOCUMENT) {
					// do nothing
				} else if (eventType == XmlPullParser.START_TAG) {
					if (xmlPullParser.getName().equals(TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE_XML_ROOTELEMENT_DAOMAPPING)) {
						// Do nothing
					} else if (xmlPullParser.getName().equals(TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE_XML_ELEMENT_DAOCONFIG)) {
						daoConfig = new DAOConfig();
						daoConfig.setDaoKey(xmlPullParser.getAttributeValue(null, TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE_XML_ATTR_DAOKEY));
						daoConfig.setDbImplClass(xmlPullParser.getAttributeValue(null, TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE_XML_ATTR_IMPL_DB));
						daoConfig.setMkImplClass(xmlPullParser.getAttributeValue(null, TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE_XML_ATTR_IMPL_MK));
						daoConfig.setWsImplClass(xmlPullParser.getAttributeValue(null, TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE_XML_ATTR_IMPL_WS));
						daoConfig.setSelKey(xmlPullParser.getAttributeValue(null, TNEAConunselingConstantants.TNEA_DAOCONFIG_FILE_XML_ATTR_IMPL_SELKEY));

						daoConfigCacheMap.put(daoConfig.getDaoKey(), daoConfig);
					}
				} else if (eventType == XmlPullParser.END_TAG) {
					daoConfig = null;
				}
				eventType = xmlPullParser.next();
			}
		} catch (IOException e) {
			//TODO: Exception Handling is pending
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			//TODO: Exception Handling is pending
			e.printStackTrace();
		}
		return null;
	}
}
