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

'帳務管理 -> 公司入款审核'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 1)

'搜尋'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Index_Page/button_Search'))

WebUI.delay(2)

'搜寻公司入款审核'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Search_Page/text_Title'))

'點擊取消全部狀態'
WebUI.uncheck(findTestObject('Object Repository/VerifyDesposit/Search_Page/checkbox_Satus'))
WebUI.uncheck(findTestObject('Object Repository/VerifyDesposit/Search_Page/checkbox_Applying'))
WebUI.uncheck(findTestObject('Object Repository/VerifyDesposit/Search_Page/checkbox_Deposited'))

WebUI.delay(5)

'點擊點擊「已取消」'
//WebUI.click(findTestObject('Object Repository/VerifyDesposit/Search_Page/checkbox_Cancel'))

beforetext = WebUI.getText(findTestObject('Object Repository/VerifyDesposit/Search_Page/label_Cancel'))

'搜尋'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Search_Page/button_Search'))

WebUI.delay(5)

aftertext = WebUI.getText(findTestObject('Object Repository/VerifyDesposit/Index_Page/text_Status'))

WebUI.verifyEqual(beforetext, aftertext)