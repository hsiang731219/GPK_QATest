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

'會員與代理商 -> 代理商查詢'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(1, 2)

'選取上個月1號'
LastMonthNumberOne = CustomKeywords.'extension.UIMethod.setLastDayMonth'()

'輸入上個月1號'
WebUI.setText(findTestObject('Agent/Index_Page/input_Join Date Begin'), LastMonthNumberOne)

System.out.println(LastMonthNumberOne)

'轉換上個月1號為數值'
beforetext = CustomKeywords.'extension.DataConversion.yearmonthdate'(LastMonthNumberOne)

WebUI.delay(1)

'查詢結果'
WebUI.click(findTestObject('Agent/Index_Page/button_Search'))

System.out.println(beforetext)

WebUI.delay(1)

'選擇查詢結果第一筆資料的入會日期'
after = WebUI.getText(findTestObject('Agent/Index_Page/text_Join Date'))

System.out.println(after)

'轉換查詢結果第一筆資料的入會日期為數值'
aftertext = CustomKeywords.'extension.DataConversion.yearmonthdate'(after)

System.out.println(aftertext)

'比較第一筆資料的入會日期是否大於選擇的上個月1號'
WebUI.verifyGreaterThanOrEqual(aftertext, beforetext)

