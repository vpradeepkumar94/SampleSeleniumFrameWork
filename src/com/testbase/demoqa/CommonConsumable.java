package com.testbase.demoqa;

import java.util.List;

import org.openqa.selenium.WebElement;

interface CommonConsumable {

	void selectFromRadioButton(List<WebElement> elements, String toSelect);

	void selectFromDropDown(WebElement elem, String toSelect, DropDown drp);

	void selectCheckBox(List<WebElement> elements, String... toSelect);
}
 