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

'輸入時時返水起始金額'
WebUI.setText(findTestObject('Object Repository/Member/Index_Page/input_AnyTimeDiscountBegin'), '1')

'輸入時時返水結束金額'
WebUI.setText(findTestObject('Object Repository/Member/Index_Page/input_AnyTimeDiscountEnd'), '5')

WebUI.delay(2)

'查詢結果'
WebUI.click(findTestObject('Object Repository/Member/Index_Page/button_Query'))

WebUI.delay(2)

after = WebUI.getText(findTestObject('Object Repository/Member/Index_Page/text_AnyTimeDiscountValue'))

'轉換查詢結果第一筆餘額扣除$字元'
aftertext = CustomKeywords.'extension.SampleCustomKeyword.currencyToInt'(after)

WebUI.delay(1)

'比較結果是否大於輸入的1'
WebUI.verifyGreaterThanOrEqual(aftertext, '1')

'比較結果是否小於輸入的5'
WebUI.verifyLessThanOrEqual(aftertext, '5')