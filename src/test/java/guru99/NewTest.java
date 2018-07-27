package guru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("After Test");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

}
