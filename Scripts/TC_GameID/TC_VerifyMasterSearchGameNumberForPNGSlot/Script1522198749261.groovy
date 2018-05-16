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

WebUI.openBrowser('')

CustomKeywords.'common.MasterLogin.getLogin'()

//各式報表 -> 投注紀錄查詢
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(4, 2)

'清空投注時間'
WebUI.clearText(findTestObject('BetRecord/Index_Page/input_WagersTimeBegin'))

'取得上個月1號'
lastMonthNumberOne = CustomKeywords.'extension.SetLastMonthNumberOne.setLastDayMonth'()

WebUI.delay(1)

'把上個月1號的值填入投注時間(起)'
WebUI.setText(findTestObject('BetRecord/Index_Page/input_WagersTimeBegin'), lastMonthNumberOne)

WebUI.click(findTestObject('BetRecord/Index_Page/button_Category'))

WebUI.delay(1)

'先清空後，再選擇要的項目'
WebUI.click(findTestObject('BetRecord/Category_Page/button_Clear'))

'選擇PNG Slot'
WebUI.click(findTestObject('BetRecord/Category_Page/label_PNG_Slot'))

'把遊戲類型的對話視窒關掉'
WebUI.click(findTestObject('BetRecord/Category_Page/button_Close'))

WebUI.delay(1)

'按查詢'
WebUI.click(findTestObject('BetRecord/Index_Page/button_Query'))

'等待查詢的結果出來'
WebUI.waitForElementPresent(findTestObject('BetRecord/Index_Page/button_Detail'), 1)

'等待查詢的結果出來 (用keyword方式)'
CustomKeywords.'extension.ClickXpath.clickUsingJS'(findTestObject('BetRecord/Index_Page/button_Detail'), 10)

'把PNG Slot 局號存下來'
txt_PNG_Slot_GameID = WebUI.getText(findTestObject('BetRecord/Detail_Page/txt_PNGSlotGameID'))

WebUI.back()

'把PNG Slot 局號填入局號的欄位'
WebUI.setText(findTestObject('BetRecord/Index_Page/input_GameID'), txt_PNG_Slot_GameID)

'按下查詢鈕'
WebUI.click(findTestObject('BetRecord/Index_Page/button_Query'))

'等待查詢的結果出來'
WebUI.waitForElementPresent(findTestObject('BetRecord/Index_Page/button_Detail'), 1)

'等待查詢的結果出來 (用keyword方式)'
CustomKeywords.'extension.ClickXpath.clickUsingJS'(findTestObject('BetRecord/Index_Page/button_Detail'), 10)

'取得PNG Slot 的GameID'
txt_PNG_Slot_gameID_Verify = WebUI.getText(findTestObject('BetRecord/Detail_Page/txt_PNGSlotGameID'))

'確定局號是否正確'
WebUI.verifyMatch(txt_PNG_Slot_GameID, txt_PNG_Slot_gameID_Verify, true)

'停個2秒後在關掉Browser'
WebUI.delay(1)

WebUI.closeBrowser()

