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

CustomKeywords.'common.MasterLogin.Login'()

'帳務管理 -> 線上支付看板'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 2)

'搜尋'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Index_Page/button_Search'))

'线上支付看板--搜寻'
WebUI.waitForElementClickable(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/text_Title'), 2)

WebUI.delay(2)

'選取上個月1號'
LastMonthNumberOne = CustomKeywords.'extension.UIMethod.setLastDayMonth'()

'輸入上個月1號'
WebUI.setText(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/input_ApplicationDateBegin'), LastMonthNumberOne)

'搜尋'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/button_Search'))

'轉換上個月1號為數值'
beforetext = CustomKeywords.'extension.DataConversion.yearmonthdate'(LastMonthNumberOne)

after = WebUI.getText(findTestObject('Object Repository/ThirdPartyPayment/Index_Page/text_StatusUpdateDate'))

afterdate = CustomKeywords.'extension.DataConversion.GetStringSpilt'(after, ' ', 1)

'轉換上個月1號為數值'
aftertext = CustomKeywords.'extension.DataConversion.yearmonthdate'(afterdate)

'比較第一筆資料的申請日期是否大於選擇的上個月1號'
WebUI.verifyGreaterThanOrEqual(aftertext, beforetext)

