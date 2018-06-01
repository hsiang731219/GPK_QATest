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

//各式報表 -> 投注紀錄查詢
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 4)

WebUI.click(findTestObject('MemberTransaction/Index_Page/button_Query'))

WebUI.waitForElementVisible(findTestObject('MemberTransaction/Index_Page/txt_FirstTransactionTimeText'), 500)

GetFirstPageTransactionTime = WebUI.getText(findTestObject('MemberTransaction/Index_Page/txt_FirstTransactionTimeText'))

//System.out.println(GetFirstPageTransactionTime)
GetFirstTransactionRecord = WebUI.getText(findTestObject('MemberTransaction/Index_Page/txt_BalanceText'))

//System.out.println(GetFirstTransactionRecord)
WebUI.click(findTestObject('MemberTransaction/Index_Page/a_TwoPagination'))

WebUI.waitForElementVisible(findTestObject('MemberTransaction/Index_Page/txt_FirstTransactionTimeText'), 500)

GetSecondPageTransactionTime = WebUI.getText(findTestObject('MemberTransaction/Index_Page/txt_FirstTransactionTimeText'))

//System.out.println(GetSecondPageTransactionTime)
GetSecondTransactionRecord = WebUI.getText(findTestObject('MemberTransaction/Index_Page/txt_BalanceText'))

//System.out.println(GetSecondTransactionRecord)
WebUI.verifyNotMatch(GetFirstPageTransactionTime, GetSecondPageTransactionTime, false)

WebUI.verifyNotMatch(GetFirstTransactionRecord, GetSecondTransactionRecord, false)

