package custom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

public class SearchAllThirdPartyList {
	@Keyword
	def printThirdPartyList(){
	}

	//新增線上支付商戶裡選擇要的商戶類型
	@Keyword
	def selectThirdPartyType(String typeName){
		WebDriver driver = DriverFactory.getWebDriver()

		WebElement ul = driver.findElement(By.xpath("//div[@class='form-group']/div/div/ul"))

		List<WebElement> types = ul.findElements(By.xpath("//*[@class='ui-select-choices-row-inner']"))

		lis: for (int i =0;i<types.size();i++) {

			if(types.get(i).getText().equalsIgnoreCase(typeName)){
				types.get(i).findElement(By.tagName("span")).click()
				lis:break
			}

		}
	}
}
