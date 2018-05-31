package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

@Keyword
public void getLogin() {

	def urlInfo = WebUI.callTestCase(findTestCase('Common/TestEnvironmenInfoData'), [:], FailureHandling.STOP_ON_FAILURE)
	def loginInfo = WebUI.callTestCase(findTestCase('Common/TestUserLoginData'), [:], FailureHandling.STOP_ON_FAILURE)

	def url = urlInfo.Gpk_master
	def username = loginInfo.username
	def password = loginInfo.password	

	

	WebUI.sendKeys(findTestObject('Account/Login_Page/input_AccountName'), username)

	WebUI.sendKeys(findTestObject('Account/Login_Page/input_Password'), password)

	WebUI.click(findTestObject('Account/Login_Page/button_Submit'))
}
