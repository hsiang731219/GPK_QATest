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

'點選狀態「全部取消」'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/checkbox_Satus'))

'勾選「已拒絕」'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/checkbox_Denied'))

'得到「已拒絕」文字'
beforetext = WebUI.getText(findTestObject('VerifyWithdraw/Search_Page/checkbox_Denied'))

System.out.println(beforetext)

WebUI.delay(2)

'搜尋'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/button_Search'))

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('VerifyWithdraw/Index_Page/text_Status'), 0)

'取得查詢結果的會員狀態'
aftertext = WebUI.getText(findTestObject('VerifyWithdraw/Index_Page/text_Status'))

System.out.println(aftertext)

'驗證「搜尋狀態」與「結果狀態」是否相同'
WebUI.verifyEqual(beforetext, aftertext)

