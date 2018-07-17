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

WebUI.click(findTestObject('Agent/Index_Page/button_Search'))

'取得欲查詢帳號'
beforetext = WebUI.getText(findTestObject('Agent/Index_Page/text_Account'))

'輸入欲查詢帳號'
WebUI.setText(findTestObject('Agent/Index_Page/input_Account'), beforetext)

'查詢結果'
WebUI.click(findTestObject('Agent/Index_Page/button_Search'))

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('Agent/Index_Page/text_Account'), 0)

'取得查詢的代理商帳號'
aftertext = WebUI.getText(findTestObject('Agent/Detail_Page/text_Account'))

WebUI.verifyEqual(beforetext, aftertext)

