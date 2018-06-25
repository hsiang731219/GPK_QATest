import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'common.MasterLogin.Login'()

'帳務管理 -> 取款申請審核'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 3)

'搜尋'
WebUI.click(findTestObject('VerifyWithdraw/Index_Page/button_Search'))

WebUI.delay(2)

'選取上個月1號'
LastMonthNumberOne = CustomKeywords.'extension.UIMethod.setLastDayMonth'()

'輸入上個月1號'
WebUI.setText(findTestObject('VerifyWithdraw/Search_Page/input_ApplicationDateBegin'), LastMonthNumberOne)

System.out.println(LastMonthNumberOne)

WebUI.delay(1)

'搜尋'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/button_Search'))

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('VerifyWithdraw/Search_Page/input_ApplicationDateBegin'), 2)

'轉換上個月1號為數值'
beforetext = CustomKeywords.'extension.DataConversion.yearmonthdate'(LastMonthNumberOne)

System.out.println(beforetext)

WebUI.delay(2)

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('VerifyWithdraw/Index_Page/link_ID'), 0)

after = WebUI.getText(findTestObject('VerifyWithdraw/Detail_Page/text_ApplicationTime'))

System.out.println(after)

afterdate = CustomKeywords.'extension.DataConversion.GetStringSpilt'(after, ' ', 1)

System.out.println(afterdate)

'轉換上個月1號為數值'
aftertext = CustomKeywords.'extension.DataConversion.yearmonthdate'(afterdate)

System.out.println(aftertext)

WebUI.delay(2)

'比較第一筆資料的申請日期是否大於選擇的上個月1號'
WebUI.verifyGreaterThanOrEqual(aftertext, beforetext)

WebUI.closeBrowser()

