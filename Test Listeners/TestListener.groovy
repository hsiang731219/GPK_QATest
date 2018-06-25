import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable
import sun.swing.plaf.synth.SynthFileChooserUI.GlobFilter

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class TestListener {
	
	
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def BeforeTestCase(TestCaseContext testCaseContext) {
		def Tag = testCaseContext.getTestCaseVariables().values()
		def urlInfo = WebUI.callTestCase(findTestCase('Common/TestEnvironmenInfoData'), [:], FailureHandling.STOP_ON_FAILURE)
		def url = urlInfo.Gpk_master
		
		if(Tag[0] != "Data"){
			
			 WebUI.openBrowser('')
			 WebUI.maximizeWindow()
			 WebUI.navigateToUrl(url)
			 
		}
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	
	@AfterTestCase
	def AfterTestCase(TestCaseContext testCaseContext) {
		def Tag = testCaseContext.getTestCaseVariables().values()
		
		if(Tag[0] != "Data"){
			
			WebUI.closeBrowser()
		}
		
	}
	
}