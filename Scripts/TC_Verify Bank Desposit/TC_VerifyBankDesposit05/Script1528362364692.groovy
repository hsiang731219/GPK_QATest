import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

'帳務管理 -> 公司入款审核'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 1)

'搜尋'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Index_Page/button_Search'))

WebUI.delay(2)

'搜寻公司入款审核'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Search_Page/text_Title'))

'輸入起始金額'
WebUI.setText(findTestObject('Object Repository/VerifyDesposit/Search_Page/input_Amountbegin'),	'1')

'輸入結束金額'
WebUI.setText(findTestObject('Object Repository/VerifyDesposit/Search_Page/input_AmountEnd'), '5')

'搜尋'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Search_Page/button_Search'))

WebUI.delay(2)

money = WebUI.getText(findTestObject('Object Repository/VerifyDesposit/Index_Page/text_Amount'))

'轉換查詢結果第一筆餘額扣除$字元'
aftertext = CustomKeywords.'extension.SampleCustomKeyword.currencyToInt'(money)

System.out.println(aftertext)

WebUI.delay(1)

'比較結果是否大於輸入的1'
WebUI.verifyGreaterThanOrEqual(aftertext, '1')

'比較結果是否小於輸入的5'
WebUI.verifyLessThanOrEqual(aftertext, '5')