package basic;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTest {
	
	
  @Test(dataProvider = "SearchProvider")
  public void f(String n, String s) {
	  
	  System.out.println("n value: "+n+" & s value: "+s);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }
  @DataProvider(name="SearchProvider")
  public Object[][] Testing(){
  return new Object[][] 
  	{
          { "Guru99", "India" },
          { "Krishna", "UK" },
          { "3", "test" }
     };
  }
//  @DataProvider(name="SearchProvider")
//  public  static Object[][] testing() {
//    return new Object[][] {
//      new Object[] { "test1", "a" },
//      new Object[] { "test2", "b" },
//    };
//  }

}
