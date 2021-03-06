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
WebUI.click(findTestObject('VerifyDesposit/Index_Page/button_Search'))

WebUI.delay(2)

'點擊申請日期'
WebUI.click(findTestObject('VerifyDesposit/Search_Page/input_ApplicationDateBegin'))

'選取上個月一號'
setDate = CustomKeywords.'extension.UIMethod.setLastDayMonth'()

'輸入上個月一號'
WebUI.setText(findTestObject('VerifyDesposit/Search_Page/input_ApplicationDateBegin'), setDate)

'轉換上個月1號為數值'
expectedResult = CustomKeywords.'extension.DataConversion.yearmonthdate'(setDate)

'搜尋'
WebUI.click(findTestObject('VerifyDesposit/Search_Page/button_Search'))

WebUI.delay(2)

'點擊搜尋結果ID'
CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('VerifyDesposit/Index_Page/link_ID'), 2)

'取得會員申請時間'
getDetailDate = WebUI.getText(findTestObject('VerifyDesposit/Detail_Page/text_ApplicationTime'))

'取得會員申請時間(只取日期)'
getDate = CustomKeywords.'extension.DataConversion.GetStringSpilt'(getDetailDate, ' ', 1)

'轉換日期為數值'
actualResult = CustomKeywords.'extension.DataConversion.yearmonthdate'(getDate)

WebUI.delay(2)

'比較查詢結果的申請日期是否大於選擇的上個月1號'
WebUI.verifyGreaterThanOrEqual(actualResult, expectedResult)

