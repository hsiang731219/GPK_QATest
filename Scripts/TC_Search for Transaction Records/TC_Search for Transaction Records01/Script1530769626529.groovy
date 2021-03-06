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

WebUI.click(findTestObject('MemberTransaction/Index_Page/button_Query'))

WebUI.delay(2)

'點擊詳細'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('MemberTransaction/Index_Page/link_Detail'), 0)

'取得欲查詢的「單號」'
before = WebUI.getText(findTestObject('MemberTransaction/Detail_Page/text_TicketNumber'))

'只取空白後數字'
beforetext = CustomKeywords.'extension.DataConversion.GetStringSpilt'(before, ' ', 0)

WebUI.delay(2)

'回上一頁'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('MemberTransaction/Detail_Page/link_BackToPreviousPage'), 
    0)

WebUI.delay(2)

'輸入單號'
WebUI.setText(findTestObject('MemberTransaction/Index_Page/input_IdsNumber'), beforetext)

'搜尋'
WebUI.click(findTestObject('MemberTransaction/Index_Page/button_Query'))

WebUI.delay(2)

'點擊詳細'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('MemberTransaction/Index_Page/link_Detail'), 0)

'取得欲查詢的「單號」'
after = WebUI.getText(findTestObject('MemberTransaction/Detail_Page/text_TicketNumber'))

'只取空白後數字'
aftertext = CustomKeywords.'extension.DataConversion.GetStringSpilt'(after, ' ', 0)

'比較單號是否相同'
WebUI.verifyEqual(beforetext, aftertext)

