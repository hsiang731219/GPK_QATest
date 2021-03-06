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

'取得列表首個序號'
expectedResult = WebUI.getText(findTestObject('VerifyDesposit/Index_Page/text_ID'))

'搜尋'
WebUI.click(findTestObject('VerifyDesposit/Index_Page/button_Search'))

WebUI.delay(2)

'輸入訂單號'
WebUI.setText(findTestObject('VerifyDesposit/Search_Page/input_ID'), expectedResult)

'搜尋'
WebUI.click(findTestObject('VerifyDesposit/Search_Page/button_Search'))

WebUI.delay(2)

'點擊搜尋結果ID'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('VerifyDesposit/Index_Page/link_ID'), 2)

'取得搜尋後的序號'
getTextID = WebUI.getText(findTestObject('VerifyDesposit/Detail_Page/text_ID'))

'轉換只取冒號後的文字'
actualResult = CustomKeywords.'extension.DataConversion.GetStringSpilt'(getTextID, '：', 2)

WebUI.delay(2)

'比較訂單號是否相同'
WebUI.verifyEqual(actualResult, expectedResult)

