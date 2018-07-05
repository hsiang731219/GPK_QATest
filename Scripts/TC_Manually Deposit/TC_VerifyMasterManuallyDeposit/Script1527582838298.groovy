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
import com.sun.media.sound.SoftReverb.Delay
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import org.openqa.selenium.Keys as Keys
import java.lang.String as String
import java.lang.StringCoding as StringCoding

def Info = WebUI.callTestCase(findTestCase('Common/DepositAndWithdrawData'), [:], FailureHandling.STOP_ON_FAILURE)

for( x = 1; x <= 1 ; x++){
	
	def choose_audit = Integer.toString(x)
	
for (i = 1; i <= 2; i++) {
	
    def choose_type = Info[('type' + Integer.toString(i))]
	def choose_type1 = Integer.toString(i)

    WebUI.openBrowser('')

    CustomKeywords.'common.MasterLogin.Login'()

    //會員與代理商 -> 會員查詢
    CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(1, 1)

    '輸入搜尋帳號'
    WebUI.sendKeys(findTestObject('Member/Index_Page/input_SearchAccount'), Info.account)

    WebUI.click(findTestObject('Member/Index_Page/button_Query'))

    '取得存款前金額並進行格式轉換'
    GetBeforePoint = CustomKeywords.'extension.StringExtension.CurrencyToInt'(WebUI.getText(findTestObject('Member/Index_Page/txt_BalanceText')))

    CustomKeywords.'extension.ClickXpath.clickUsingJS'(findTestObject('Member/Index_Page/link_Account'), 1)
	
	'取得實際存款前次數'
	GetBeforeCount = CustomKeywords.'extension.StringExtension.CurrencyToInt'(WebUI.getText(findTestObject('Member/Detail_Page/txt_ActualDepositCount')))

    WebUI.click(findTestObject('Member/Detail_Page/button_Deposit'))

    '輸入存款帳號'
    WebUI.setText(findTestObject('Member/Deposit_Page/input_DepositAccount'), Info.account)

    '輸入存款金額'
    WebUI.setText(findTestObject('Member/Deposit_Page/input_DepositAmount'), Integer.toString(Info.amount))

    '稽核方式'
	
	if (choose_audit == '1'){
		
		WebUI.check(findTestObject('Member/Deposit_Page/inputRadio_NoNeedToAudit'))
		
	} else if (choose_audit == '2')
	{
		WebUI.check(findTestObject('Object Repository/Member/Deposit_Page/inputRadio_DepositAudit'))
		
	} else 
    {
		WebUI.check(findTestObject('Object Repository/Member/Deposit_Page/inputRadio_PromotionAudit'))
	}
	
	if (choose_audit != '1')
	{
		WebUI.setText(findTestObject('Member/Deposit_Page/input_AuditAmount'), Integer.toString(Info.auditAmount))	
	}
	
	
    '人工存提'
    WebUI.selectOptionByLabel(findTestObject('Member/Deposit_Page/select_DepositOption'), choose_type, false)

	if (choose_audit == '1' && choose_type1 == '1')
	{
		'勾選實際存提'
		WebUI.check(findTestObject('Member/Deposit_Page/isSelect_RealDepositAndWithdrawal'))
	} else 
	{
		'不勾選實際存提'
		WebUI.uncheck(findTestObject('Member/Deposit_Page/isSelect_RealDepositAndWithdrawal'))
	}
	

    '輸入存款密碼'
    WebUiBuiltInKeywords.setText(findTestObject('Member/Deposit_Page/input_DepositPassword'), Info.depositpassword)

    '填寫備註'
    WebUI.setText(findTestObject('Member/Deposit_Page/textarea_DepositMemo'), '')

    WebUiBuiltInKeywords.click(findTestObject('Member/Deposit_Page/button_Submit'))

    WebUI.acceptAlert()

    WebUI.waitForAlert(500, FailureHandling.STOP_ON_FAILURE)

    WebUI.acceptAlert()

	'取得實際存款後次數'
	GetAfterCount = CustomKeywords.'extension.StringExtension.CurrencyToInt'(WebUI.getText(findTestObject('Member/Detail_Page/txt_ActualDepositCount')))
	
    '點擊會員詳細頁面中的"交易紀錄"'
    WebUI.click(findTestObject('Member/Detail_Page/a_MemberTransaction'))

    '取得存款後金額並進行格式轉換'
    GetAfterPoint = CustomKeywords.'extension.StringExtension.CurrencyToInt'(WebUI.getText(findTestObject('MemberTransaction/Index_Page/text_BalanceText')))

    GetAfterTransactionType = WebUI.getText(findTestObject('MemberTransaction/Index_Page/text_DepositAndWithdrawType'))

	if (choose_audit == '1' && choose_type1 == '1')
	{
		WebUI.verifyEqual(GetAfterCount, GetBeforeCount + Integer.parseInt('1'))
	}
	
    WebUI.verifyEqual(GetAfterTransactionType, choose_type)

    WebUI.verifyEqual(GetAfterPoint, GetBeforePoint + Info.amount)

    WebUI.closeBrowser()

    i = i++
}
  x = x++
}

