package com.testbase.demoqa;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Base implements CommonConsumable {

	public void selectFromRadioButton(List<WebElement> elements,
			String toSelect) {

		int size = elements.size();

		for (int i = 0; i < size; i++) {
			String value = elements.get(i).getAttribute("value");
			if (value.equalsIgnoreCase(toSelect)) {
				elements.get(i).click();
				break;
			}
		}
	}

	public void selectFromDropDown(WebElement elem, String toSelect,
			DropDown drp) {

		Select select = new Select(elem);

		switch (drp) {
		case BY_INDEX:
			select.selectByIndex(Integer.parseInt((toSelect)));
			break;
		case VALUE:
			select.selectByValue(toSelect);
			break;
		case VISBILE_TEXT:
			select.selectByVisibleText(toSelect);
			break;
		default:
			select.selectByIndex(0);
		}
	}

	public void selectCheckBox(List<WebElement> elements, String... toSelect) {
		
		int size = elements.size();

		for(int j =0 ; j < toSelect.length; j ++) {
			String data = toSelect[j];
			for (int i = 0; i < size; i++) {
				String value = elements.get(i).getAttribute("value");
				if (value.equalsIgnoreCase(data)) {
					boolean result = elements.get(i).isSelected();
					if(!result) {
						elements.get(i).click();
						break;
					}
				}
			}
		}

	}
}
