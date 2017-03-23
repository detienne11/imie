package fr.imie.emanagerws;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.imie.emanagerws.service.ServiceTest;

@RunWith(Suite.class)
@SuiteClasses ({ServiceTest.class})
public class AppTestSuit {

	@BeforeClass
	public static void beforeSuite(){
		// TODO before the suite is run
	}
	
	@AfterClass
	public static void afterSuite(){
		// TODO after the suite is run
	}
}
