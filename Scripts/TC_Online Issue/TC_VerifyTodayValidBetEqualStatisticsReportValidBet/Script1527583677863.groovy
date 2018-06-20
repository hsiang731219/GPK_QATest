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

def expect_element = 'title'

element = WebUI.getAttribute(findTestObject('Home/Index_Page/txt_TodayValidBet'), expect_element)

attribute = CustomKeywords.'extension.UIMethod.tryFindElement'(findTestObject('Home/Index_Page/txt_TodayValidBet'))

//System.out.println(attribute)
if (attribute == true) {
    GetTodayValidBet = CustomKeywords.'extension.DataConversion.CurrencyToInt'(element)
} else {
    GetTodayValidBet = '0'
}

//System.out.println(GetTodayValidBet)
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(4, 1)

WebUI.click(findTestObject('Statistics/Index_Page/button_Query'))

StatisticsAttribute = WebUI.getAttribute(findTestObject('Statistics/Index_Page/txt_StatisticsValidBet'), expect_element)

GetStatisticsValidBet = CustomKeywords.'extension.DataConversion.CurrencyToInt'(StatisticsAttribute)

WebUI.verifyEqual(GetTodayValidBet, GetStatisticsValidBet)

