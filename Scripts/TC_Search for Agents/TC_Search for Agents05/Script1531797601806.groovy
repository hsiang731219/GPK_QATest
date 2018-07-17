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

'會員與代理商 -> 代理商查詢'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(1, 2)

'選擇佣金設定'
WebUI.click(findTestObject('Agent/Index_Page/select_Commission Setting'))

WebUI.delay(1)

'狀態選擇「abby-佣金」'
WebUI.selectOptionByLabel(findTestObject('Agent/Index_Page/select_Commission Setting'), 'abby-佣金', false)

'查詢結果'
WebUI.click(findTestObject('Agent/Index_Page/button_Search'))

WebUI.delay(2)

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('Agent/Index_Page/text_Account'), 0)

'取得查詢結果的會員狀態'
aftertext = WebUI.getText(findTestObject('Agent/Detail_Page/text_Commission Setting'))

WebUI.verifyEqual('abby-佣金', aftertext)
