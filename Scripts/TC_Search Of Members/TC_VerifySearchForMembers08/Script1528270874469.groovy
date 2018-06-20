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

'會員與代理商 -> 會員查詢'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(1, 1)

'輸入會員錢包帳號'
WebUI.setText(findTestObject('Object Repository/Member/Index_Page/input_WalletAccount'), 'test81292737')

'查詢結果'
WebUI.click(findTestObject('Object Repository/Member/Index_Page/button_Query'))

WebUI.delay(3)

'點擊查詢的會員'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('Object Repository/Member/Index_Page/link_Account'), 2)

'檢視此會員詳細資料的所有錢包'
WebUI.click(findTestObject('Object Repository/Member/Detail_Page/button_Wallets'))

'取得錢包帳號'
aftertext = WebUI.getText(findTestObject('Object Repository/Member/Detail_Page/text_WalletAccountName'))

WebUI.verifyEqual('test81292737', aftertext)