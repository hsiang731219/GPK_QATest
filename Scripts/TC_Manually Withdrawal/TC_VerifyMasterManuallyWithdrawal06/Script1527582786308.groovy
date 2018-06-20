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
import com.sun.media.sound.SoftReverb.Delay as Delay
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def Info = WebUI.callTestCase(findTestCase('Common/DepositAndWithdrawData'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'common.MasterLogin.Login'()

//會員與代理商 -> 會員查詢
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(1, 1)

'輸入搜尋帳號'
WebUI.sendKeys(findTestObject('Member/Index_Page/input_SearchAccount'), Info.account)

WebUI.click(findTestObject('Member/Index_Page/button_Query'))

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('Member/Index_Page/link_Account'), 1)

'取得實際提款前次數'
GetBeforeCount = CustomKeywords.'extension.DataConversion.CurrencyToInt'(WebUI.getText(findTestObject('Member/Detail_Page/txt_ActualWithdrawCount')))

System.out.println(GetBeforeCount)

WebUI.click(findTestObject('Member/Detail_Page/button_ Withdraw'))

WebUI.setText(findTestObject('Member/Withdraw_Page/input_WithdrawAmount'), Integer.toString(Info.amount))

WebUI.selectOptionByLabel(findTestObject('Member/Withdraw_Page/select_WithdrawOption'), Info.type1, false)

'勾選實際存提'
WebUI.check(findTestObject('Member/Withdraw_Page/isSelect_RealDepositAndWithdrawal'))

WebUI.setText(findTestObject('Member/Withdraw_Page/textarea_WithdrawMemo'), '')

WebUI.setText(findTestObject('Member/Withdraw_Page/input_WithdrawPassword'), Info.withdrawpassword)

WebUI.click(findTestObject('Member/Withdraw_Page/button_Submit'))

WebUI.acceptAlert()

WebUI.waitForAlert(500, FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('MemberTransaction/Detail_Page/link_Account'), 1)

'取得實際提款後次數'
GetAfterCount = CustomKeywords.'extension.DataConversion.CurrencyToInt'(WebUI.getText(findTestObject('Member/Detail_Page/txt_ActualWithdrawCount')))

System.out.println(GetAfterCount)

WebUI.verifyEqual(GetAfterCount, GetBeforeCount + Integer.parseInt('1'))

