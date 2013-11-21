package org.devgateway.eudevfin.cda.test;

import java.io.File;
import java.io.OutputStream;
import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pt.webdetails.cda.CdaEngine;
import pt.webdetails.cda.dataaccess.DataAccessEnums;
import pt.webdetails.cda.query.QueryOptions;
import pt.webdetails.cda.settings.CdaSettings;
import pt.webdetails.cda.settings.SettingsManager;

/**
 * Provides testing of a simple MDX query through Mondrian JNDI. 
 * This spawns a Mondrian MDX server over a provided JNDI connection.
 * The JNDI connection is exposed in financialContext.xml through Spring and {@link SimpleNamingContextBuilder}  
 * @see {@link DataAccessEnums.ConnectionInstanceType#MONDRIAN_JNDI}
 * @throws Exception
 *
 * @author mihai
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:META-INF/commonAuthContext.xml",
		"classpath:META-INF/financialContext.xml",
		"classpath:META-INF/cdaContext.xml"
		})
public class CDASimpleSQLTest
{
	
	protected static Logger logger = Logger.getLogger(CDASimpleSQLTest.class);


  @Test
  public void testSqlQuery() throws Exception
  {

	    // Define an outputStream
	    OutputStream out = System.out;

	    logger.info("Building CDA settings from sample file");

	    final SettingsManager settingsManager = SettingsManager.getInstance();
	    
	    URL file = this.getClass().getResource("../service/financial.mondrian.cda");
	    File settingsFile = new File(file.toURI());
	    final CdaSettings cdaSettings = settingsManager.parseSettingsFile(settingsFile.getAbsolutePath());
	    logger.debug("Doing query on Cda - Initializing CdaEngine");
	    final CdaEngine engine = CdaEngine.getInstance();

	    QueryOptions queryOptions = new QueryOptions();
	    queryOptions.setDataAccessId("simpleSQLQuery");
	    queryOptions.setOutputType("json");

	    logger.info("Doing query");
	    engine.doQuery(out, cdaSettings, queryOptions);

  
  }
  
}