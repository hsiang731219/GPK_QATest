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

def Info = WebUI.callTestCase(findTestCase('Common/TransactionType'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'common.MasterLogin.Login'()

//帳務管理 -> 交易紀錄查詢
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 4)

'公司入款'
verify_BankDeposit = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_BankDeposit'))

WebUI.verifyEqual(verify_BankDeposit, Info.bankDeposit)

'线上支付'
verify_OnlineDeposit = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_OnlineDeposit'))

WebUI.verifyEqual(verify_OnlineDeposit, Info.onlineDeposit)

'线上取款'
verify_OnlineWithdrawal = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_OnlineWithdrawal'))

WebUI.verifyEqual(verify_OnlineWithdrawal, Info.onlineWithdrawal)

'人工存提'
verify_ManuallyDepositAndWithdrawal = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_ManuallyDepositAndWithdrawal'))

WebUI.verifyEqual(verify_ManuallyDepositAndWithdrawal, Info.manuallyDepositAndWithdrawal)

'优惠活动'
verify_PromotionEvent = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_PromotionEvent'))

WebUI.verifyEqual(verify_PromotionEvent, Info.promotionEvent)

'返水'
verify_Rebate = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_Rebate'))

WebUI.verifyEqual(verify_Rebate, Info.rebate)

'派彩'
verify_Payoff = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_Payoff'))

WebUI.verifyEqual(verify_Payoff, Info.payoff)

'时时返水'
verify_AnyTimeDiscount = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_AnyTimeDiscount'))

WebUI.verifyEqual(verify_AnyTimeDiscount, Info.anyTimeDiscount)

'其他'
verify_Others = WebUI.getText(findTestObject('MemberTransaction/Index_Page/label_Others'))

WebUI.verifyEqual(verify_Others, Info.others)

