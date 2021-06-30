package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.ToDoListPage;
import util.BrowserFactory;

public class ToggleAllTest {

	WebDriver driver;

	@Test
	public void toggleAllShouldCheckAllBox() {
		driver = BrowserFactory.init();
		ToDoListPage tat = PageFactory.initElements(driver, ToDoListPage.class);
		int toDoListSize = tat.listSize();
		System.out.println(toDoListSize);

		if (toDoListSize == 0) {
			System.out.println("no to do list found");
			BrowserFactory.tearDown();
		} else {

			tat.userCheckToggleAllBox();
			tat.checkAllBoxChecked();
		}
	}
}
