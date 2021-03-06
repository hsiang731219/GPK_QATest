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

'帳務管理 -> 交易記錄查詢'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 4)

'選擇實際存提狀態'
WebUI.click(findTestObject('MemberTransaction/Index_Page/select_RealDeposit_Withdrawal'))

WebUI.delay(1)

'實際存提選擇「是」'
WebUI.selectOptionByLabel(findTestObject('MemberTransaction/Index_Page/select_RealDeposit_Withdrawal'), '是', false)

'取消全部類型'
WebUI.click(findTestObject('MemberTransaction/Index_Page/label_Type'))

'選取公司入款'
WebUI.click(findTestObject('MemberTransaction/Index_Page/label_BankDeposit'))

'選取線上支付'
WebUI.click(findTestObject('MemberTransaction/Index_Page/label_OnlineDeposit'))

'選取線上取款'
WebUI.click(findTestObject('MemberTransaction/Index_Page/label_OnlineWithdrawal'))

'選取人工存提'
WebUI.click(findTestObject('MemberTransaction/Index_Page/label_ManuallyDepositAndWithdrawal'))

'查詢結果'
WebUI.click(findTestObject('MemberTransaction/Index_Page/button_Query'))

WebUI.delay(2)

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('MemberTransaction/Index_Page/link_Detail'), 0)

WebUI.waitForElementPresent(findTestObject('MemberTransaction/Detail_Page/CheckBox_ManuallyDepositAndWithdrawal'), 30)

WebUI.verifyElementChecked(findTestObject('MemberTransaction/Detail_Page/CheckBox_ManuallyDepositAndWithdrawal'), 1)

