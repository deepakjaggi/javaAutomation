package uiAuto.workFlows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkFlows {
	// Verifications
	public boolean verifySortingDisplay(WebDriverWait wait, List<WebElement> nameOfProducts) {
		// Get all the elements in list
		boolean flag = false;

		List<String> namesPhones1 = new ArrayList<String>();
		for (WebElement ele : nameOfProducts) {
			namesPhones1.add(ele.getText().toString());
		}

		List<String> namesPhones2 = new ArrayList<String>();
		for (WebElement ele : nameOfProducts) {
			namesPhones2.add(ele.getText().toString());
		}
		Collections.sort(namesPhones2);

		if (namesPhones1.toString().equals(namesPhones2.toString())) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

}
