package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ToDoListPage extends BasePage {
	WebDriver driver;
	int toDoListSize;

	public ToDoListPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindAll(@FindBy(how = How.CSS, using = "div#todos-content form ul li input"))
	List<WebElement> TO_DO_LISTS;
	@FindBy(how = How.CSS, using = "input[name='allbox']")
	WebElement TOGGLE_ALL_BOX;
	@FindBy(how = How.CSS, using = "div#todos-content form ul li:first-child input")
	WebElement LIST_NUMBER_1;
	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement REMOVE_BUTTON;

	public int listSize() {
		toDoListSize = TO_DO_LISTS.size();
		return toDoListSize;
	}

	public void userCheckToggleAllBox() {
		waitForElement(driver, TOGGLE_ALL_BOX, 10);
		TOGGLE_ALL_BOX.click();
	}

	public void checkAllBoxChecked() {
		for (WebElement w : TO_DO_LISTS) {
			Assert.assertTrue("failed to select all", w.isSelected());
		}
	}

	public void checkABox() {
		waitForElement(driver, LIST_NUMBER_1, 10);
		LIST_NUMBER_1.click();
	}

	public void removeCheckedBox() {
		int listSizeBeforeDelete = TO_DO_LISTS.size();
		REMOVE_BUTTON.click();
		waitForElement(driver, TOGGLE_ALL_BOX, 10);
		int listSizeAfterDelete = TO_DO_LISTS.size();
		Assert.assertEquals("fail to delecte", (listSizeBeforeDelete - 1), listSizeAfterDelete);
	}

	public void removeAllList() {
		REMOVE_BUTTON.click();
		waitForElement(driver, TOGGLE_ALL_BOX, 10);
		Assert.assertEquals("fail to delete All", TO_DO_LISTS.size(), 0);
	}

}
