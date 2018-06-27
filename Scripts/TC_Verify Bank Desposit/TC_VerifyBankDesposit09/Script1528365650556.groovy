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

'取得公司帳戶(銀行 - 收款人)'
before = WebUI.getText(findTestObject('Object Repository/VerifyDesposit/Index_Page/text_BankAccountName'))

'取得「銀行」名稱'
beforetext = CustomKeywords.'extension.DataConversion.GetStringSpilt'(before, ' ', 1)

'搜尋'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Index_Page/button_Search'))

WebUI.delay(2)

'輸入銀行名稱'
WebUI.setText(findTestObject('Object Repository/VerifyDesposit/Search_Page/input_BankName'), beforetext)

'搜尋'
WebUI.click(findTestObject('Object Repository/VerifyDesposit/Search_Page/button_Search'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/VerifyDesposit/Index_Page/link_ID'))

after = WebUI.getText(findTestObject('Object Repository/VerifyDesposit/Detail_Page/text_Bank Account Name'))

aftertext = CustomKeywords.'extension.DataConversion.GetStringSpilt'(after, ' ', 1)

WebUI.verifyEqual(beforetext, aftertext)

