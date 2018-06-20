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
import org.junit.After as After
import org.openqa.selenium.Keys as Keys
import java.lang.String as String
import java.lang.StringCoding as StringCoding

def Info = WebUI.callTestCase(findTestCase('Common/DepositAndWithdrawData'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'common.MasterLogin.Login'()

//會員與代理商->會員查詢
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(1, 1)

'輸入搜尋帳號'
WebUI.sendKeys(findTestObject('Member/Index_Page/input_SearchAccount'), Info.account)

WebUI.click(findTestObject('Member/Index_Page/button_Query'))

'取得存款前金額並進行格式轉換'
GetBeforePoint = CustomKeywords.'extension.DataConversion.CurrencyToInt'(WebUI.getText(findTestObject('Member/Index_Page/txt_BalanceText')))

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('Member/Index_Page/link_Account'), 1)

WebUI.click(findTestObject('Member/Detail_Page/button_Deposit'))

'輸入存款帳號'
WebUI.setText(findTestObject('Member/Deposit_Page/input_DepositAccount'), Info.account)

'輸入存款金額'
WebUI.setText(findTestObject('Member/Deposit_Page/input_DepositAmount'), Integer.toString(Info.amount))

'存款稽核'
WebUI.click(findTestObject('Member/Deposit_Page/inputRadio_DepositAudit'))

'稽核金額'
WebUI.setText(findTestObject('Member/Deposit_Page/input_AuditAmount'), Integer.toString(Info.auditAmount))

'返水'
WebUI.selectOptionByLabel(findTestObject('Member/Deposit_Page/select_DepositOption'), Info.type3, false)

'不勾選實際存提'
WebUI.uncheck(findTestObject('Member/Deposit_Page/isSelect_RealDepositAndWithdrawal'))

'填寫前台備註'
WebUI.setText(findTestObject('Object Repository/Member/Deposit_Page/textarea_PortalMemo'), '')

'填寫備註'
WebUI.setText(findTestObject('Member/Deposit_Page/textarea_DepositMemo'), '')

WebUiBuiltInKeywords.click(findTestObject('Member/Deposit_Page/button_Submit'))

'輸入存款密碼'
WebUiBuiltInKeywords.setText(findTestObject('Member/Deposit_Page/input_DepositPassword'), Info.depositpassword)

WebUI.acceptAlert()

WebUI.waitForAlert(500, FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

'點擊會員詳細頁面中的"交易紀錄"'
WebUI.click(findTestObject('Member/Detail_Page/a_MemberTransaction'))

'取得存款後金額並進行格式轉換'
GetAfterPoint = CustomKeywords.'extension.DataConversion.CurrencyToInt'(WebUI.getText(findTestObject('MemberTransaction/Index_Page/txt_BalanceText')))

GetAfterTransactionType = WebUI.getText(findTestObject('Object Repository/MemberTransaction/Index_Page/txt_DepositAndWithdrawType'))

WebUI.verifyEqual(GetAfterTransactionType, Info.type3)

WebUI.verifyEqual(GetAfterPoint, GetBeforePoint + Info.amount)

