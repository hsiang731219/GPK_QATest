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

'帳務管理  -> 线上支付看板'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 2)

'搜尋'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Index_Page/button_Search'))

WebUI.delay(2)

'搜寻线上支付看板'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/text_Title'))

'點選狀態(取消)'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/checkbox_StatusAll'))

'勾選「成功」'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/checkbox_StatusSucess'))

'得到「成功」文字'
beforetext = WebUI.getText(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/text_StatusOfSucess'))

'搜尋'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/button_Search'))

WebUI.delay(2)

'取得查詢結果的會員狀態'
aftertext = WebUI.getText(findTestObject('Object Repository/ThirdPartyPayment/Index_Page/text_Status'))

'驗證「搜尋狀態」與「結果狀態」是否相同'
WebUI.verifyEqual(beforetext, aftertext)
