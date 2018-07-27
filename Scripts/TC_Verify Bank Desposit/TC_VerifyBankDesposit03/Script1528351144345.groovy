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

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

CustomKeywords.'common.MasterLogin.Login'()

'帳務管理 -> 公司入款审核'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(2, 1)

'搜尋'
WebUI.click(findTestObject('VerifyDesposit/Index_Page/button_Search'))

WebUI.delay(2)

'點選會員等級'
WebUI.click(findTestObject('VerifyDesposit/Search_Page/Choose_MembersLevel/button_MembersLevelSelect'))

WebUI.delay(2)

'「清空」所有會員等級'
WebUI.click(findTestObject('VerifyDesposit/Search_Page/Choose_MembersLevel/button_MembersLevelCearAll'))

'勾選「abby-use」'
//WebUI.check(findTestObject('VerifyDesposit/Search_Page/Choose_MembersLevel/label_MembersLevel(abby-use)'))

CustomKeywords.'extension.UIMethod.setMemberLevelCheckBoxElement'("abby-use")

'得到「abby-use」文字'
//expectedResult = WebUI.getText(findTestObject('VerifyDesposit/Search_Page/Choose_MembersLevel/label_MembersLevel(abby-use)'))
expectedResult = CustomKeywords.'extension.UIMethod.setMemberLevelText'("abby-use")

'關閉选取会员等级頁面'
WebUI.click(findTestObject('VerifyDesposit/Search_Page/Choose_MembersLevel/button_MembersLevelClose'))

WebUI.delay(2)

'搜尋'
WebUI.click(findTestObject('VerifyDesposit/Search_Page/button_Search'))

WebUI.delay(2)

actualResult = WebUI.getText(findTestObject('VerifyDesposit/Index_Page/text_MembersLevel'))

'驗證「選取的會員等級」與「結果的會員等級」是否相同'
WebUI.verifyEqual(actualResult, expectedResult)

