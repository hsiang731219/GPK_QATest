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

def Info= WebUI.callTestCase(findTestCase('Common/DepositAndWithdrawData'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

CustomKeywords.'common.MasterLogin.getLogin'()

//會員與代理商 -> 會員查詢
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(1, 1)

'輸入搜尋帳號'
WebUI.sendKeys(findTestObject('Member/Index_Page/input_SearchAccount'), Info.account)

WebUI.click(findTestObject('Member/Index_Page/button_Query'))

'取得存款前金額並進行格式轉換'
GetBeforePoint = CustomKeywords.'extension.StringExtension.CurrencyToInt'(WebUI.getText(findTestObject('Member/Index_Page/txt_BalanceText')))

CustomKeywords.'extension.ClickXpath.clickUsingJS'(findTestObject('Member/Index_Page/link_Account'), 1)

WebUI.click(findTestObject('Member/Detail_Page/button_ Withdraw'))

WebUI.setText(findTestObject('Member/Withdraw_Page/input_WithdrawAmount'), Integer.toString(Info.amount))

WebUI.selectOptionByLabel(findTestObject('Member/Withdraw_Page/select_WithdrawOption'), Info.type2, false)

'不勾選實際存提'
WebUI.uncheck(findTestObject('Member/Withdraw_Page/isSelect_RealDepositAndWithdrawal'))

WebUI.setText(findTestObject('Member/Withdraw_Page/textarea_WithdrawMemo'), '')

WebUI.setText(findTestObject('Member/Withdraw_Page/input_WithdrawPassword'), Info.withdrawpassword)

WebUI.click(findTestObject('Member/Withdraw_Page/button_Submit'))

WebUI.acceptAlert()

WebUI.waitForAlert(500, FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

'取得存款後金額並進行格式轉換'
GetAfterPoint = CustomKeywords.'extension.StringExtension.CurrencyToInt'(WebUI.getText(findTestObject('Object Repository/MemberTransaction/Detail_Page/txt_BalanceAfterTheTransaction')))

GetAfterTransactionType = WebUI.getText(findTestObject('Object Repository/MemberTransaction/Detail_Page/txt_DepositAndWithdrawType'))

WebUI.verifyEqual(GetAfterTransactionType, Info.type1)

WebUI.verifyEqual(GetAfterPoint, GetBeforePoint - Info.amount)

WebUI.closeBrowser()

