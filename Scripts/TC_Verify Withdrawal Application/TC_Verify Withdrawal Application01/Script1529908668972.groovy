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

'帳務管理 -> 公司入款审核'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 3)

'取得欲查詢的「訂單號」'
beforetext = WebUI.getText(findTestObject('VerifyWithdraw/Index_Page/text_ID'))

System.out.println(beforetext)

WebUI.delay(2)

'搜尋'
WebUI.click(findTestObject('VerifyWithdraw/Index_Page/button_Search'))

WebUI.delay(2)

'點擊訂單號'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/input_ID'))

'輸入訂單號'
WebUI.setText(findTestObject('VerifyWithdraw/Search_Page/input_ID'), beforetext)

'搜尋'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/button_Search'))

WebUI.delay(3)

'點擊搜尋結果ID'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('VerifyWithdraw/Index_Page/link_ID'), 0)

'取得取款申請審核「訂單號」'
after = WebUI.getText(findTestObject('VerifyWithdraw/Detail_Page/text_ID'))

System.out.println(after)

'轉換只取冒號後的文字'
aftertext = CustomKeywords.'extension.DataConversion.GetStringSpilt'(after, '：', 2)

System.out.println(aftertext)

WebUI.delay(2)

'比較訂單號是否相同'
WebUI.verifyEqual(beforetext, aftertext)

WebUI.closeBrowser()

