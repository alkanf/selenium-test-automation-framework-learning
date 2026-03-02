package day4;

	import org.testng.annotations.*;


	public class AllAnnotations {

	    @BeforeSuite
	    void beforeSuite() {
	        System.out.println("This is BeforeSuite method");
	    }

	    @BeforeTest
	    void beforeTest() {
	        System.out.println("This is BeforeTest method");
	    }

	    @BeforeClass
	    void beforeClass() {
	        System.out.println("This is BeforeClass method");
	    }

	    @BeforeMethod
	    void beforeMethod() {
	        System.out.println("This is BeforeMethod method");
	    }

	    @Test
	    void test1() {
	        System.out.println("This is Test1 method");
	    }

	    @Test
	    void test2() {
	        System.out.println("This is Test2 method");
	    }

	    @AfterMethod
	    void afterMethod() {
	        System.out.println("This is AfterMethod method");
	    }

	    @AfterClass
	    void afterClass() {
	        System.out.println("This is AfterClass method");
	    }

	    @AfterTest
	    void afterTest() {
	        System.out.println("This is AfterTest method");
	    }

	    @AfterSuite
	    void afterSuite() {
	        System.out.println("This is AfterSuite method");
	    }
	}
	


