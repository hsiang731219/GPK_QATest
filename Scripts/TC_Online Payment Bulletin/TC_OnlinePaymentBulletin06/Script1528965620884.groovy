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

'取得欲查詢的「商戶」'
beforeText = WebUI.getText(findTestObject('Object Repository/ThirdPartyPayment/Index_Page/text_ThirdPartyAccount'))

'线上支付看板--搜寻'
WebUI.waitForElementClickable(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/text_Title'), 5)

'輸入商戶'
WebUI.setText(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/input_ThirdPartyAccount'), beforeText)

'搜尋'
WebUI.click(findTestObject('Object Repository/ThirdPartyPayment/Search_Page/button_Search'))

'點擊搜尋結果ID'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('Object Repository/ThirdPartyPayment/Index_Page/link_ID'), 2)

'取得线上支付明细「商戶」'
afterText = WebUI.getText(findTestObject('Object Repository/ThirdPartyPayment/Detail_Page/text_ThirdPartyAccount'))

'比較商戶是否相同'
WebUI.verifyEqual(afterText, beforeText)

