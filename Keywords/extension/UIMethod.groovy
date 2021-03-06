package extension

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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor


import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import java.text.SimpleDateFormat
//import org.openqa.selenium.WebDriver
import org.openqa.selenium.By as By
//import org.openqa.selenium.WebElement as WebElement
//import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

public class UIMethod {

	@Keyword
	/***
	 * 使用 java script 處理無法正常點擊的元素
	 */
	def clickUsingJS(TestObject to, int timeout) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}

	@Keyword
	/***
	 * 判斷元素是否存在
	 */
	def tryFindElement(TestObject to){
		try{

			WebUI.verifyElementHasAttribute(to, 'title', 10)
		} catch(Exception e) {
			return false;
		}

		return true;
	}

	@Keyword
	/***
	 * 將日期訂於上個月一號
	 */
	def setLastDayMonth() {
		'查詢時間(起)，即為上個月的1號'
		Calendar ca = Calendar.getInstance()

		Date now = ca.getTime()

		'月份減1'
		ca.add(Calendar.MONTH, -1)

		'取得結果'
		Date lastMonth = ca.getTime()

		SimpleDateFormat sf = new SimpleDateFormat('yyyy/MM/01')

		return sf.format(lastMonth)
	}
	
	 @Keyword
	 def setMemberLevelCheckBoxElement(String memberlevel)
	 {
		 WebDriver driver = DriverFactory.getWebDriver()
		 List<WebElement> someElements = driver.findElements(By.tagName("label"))
		 for (WebElement anElement : someElements) 
		 {
			if (anElement.getAttribute("title").equals(memberlevel)) 
			{		
				def Agent = memberlevel

				WebUI.check(findTestObject('Common/SelectMemberLevel/label_SelectMemberLevel',[('Member_Level'):Agent]))
			}
		 }
		 return
	 }
	 
	 @Keyword
	 def getMemberLevelText(String memberlevel)
	 {
		 def getText = WebUI.getText(findTestObject('Common/SelectMemberLevel/label_SelectMemberLevel',[('Member_Level'):memberlevel]))

		 return getText;
	 }
	 
}
