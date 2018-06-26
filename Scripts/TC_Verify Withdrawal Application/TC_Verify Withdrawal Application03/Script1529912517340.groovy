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

'帳務管理 -> 取款申請審核'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 3)

'搜尋'
WebUI.click(findTestObject('VerifyWithdraw/Index_Page/button_Search'))

WebUI.delay(2)

'點擊會員等級'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/Choose_MembersLevel/button_MembersLevelSelect'))

WebUI.delay(2)

'點擊清除所有會員等級'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/Choose_MembersLevel/button_MembersLevelCearAll'))

'點擊選擇abby-use會員等級'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/Choose_MembersLevel/label_MembersLevel(abby-use)'))

'取得所選的會員等級文字'
beforetext = WebUI.getText(findTestObject('VerifyWithdraw/Search_Page/Choose_MembersLevel/label_MembersLevel(abby-use)'))

System.out.println(beforetext)

'關閉選取會員等級'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/Choose_MembersLevel/button_MembersLevelClose'))

WebUI.delay(2)

'搜尋'
WebUI.click(findTestObject('VerifyWithdraw/Search_Page/button_Search'))

WebUI.delay(2)

CustomKeywords.'extension.UIMethod.clickUsingJS'(findTestObject('VerifyWithdraw/Index_Page/link_ID'), 0)

'取得取款申請審核「會員等級」'
aftertext = WebUI.getText(findTestObject('VerifyWithdraw/Detail_Page/text_Members Level'))

System.out.println(aftertext)

WebUI.delay(2)

'比較會員等級是否相同'
WebUI.verifyEqual(beforetext, aftertext)

