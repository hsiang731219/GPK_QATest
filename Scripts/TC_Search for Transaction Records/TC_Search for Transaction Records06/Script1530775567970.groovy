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

'帳務管理 -> 交易記錄查詢'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 4)

'會員等級選取'
WebUI.click(findTestObject('MemberTransaction/Index_Page/button_Select'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

'选取会员等级-清空'
WebUI.click(findTestObject('MemberTransaction/Index_Page/MemberLevelChoose_Page/button_MemberLevelClearAll'))

'选取[ abby-use]'
WebUI.click(findTestObject('MemberTransaction/Index_Page/MemberLevelChoose_Page/checkbox_MemberLevelOfAbby-use'))

beforetext = WebUI.getText(findTestObject('MemberTransaction/Index_Page/MemberLevelChoose_Page/checkbox_MemberLevelOfAbby-use'))

'關閉選取會員等級'
WebUI.click(findTestObject('MemberTransaction/Index_Page/MemberLevelChoose_Page/button_MemberLevelClose'))

WebUI.delay(2)

'查詢結果'
WebUI.click(findTestObject('MemberTransaction/Index_Page/button_Query'))

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('MemberTransaction/Index_Page/link_Detail'), 0)

aftertext = WebUI.getText(findTestObject('MemberTransaction/Detail_Page/text_MemberLevel'))

WebUI.verifyEqual(beforetext, aftertext)

