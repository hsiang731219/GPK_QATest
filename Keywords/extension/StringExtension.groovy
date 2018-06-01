package extension

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
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import  java.lang.NumberFormatException



import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class StringExtension {

	@Keyword
	// 將取到的金額去除'$'& ',' 後轉成字串
	def CurrencyToInt(String point)
	{
		def str = point.replace('$ ', '').replace(',', '')
		def result = Double.valueOf(str)
		return result;
	}

	@Keyword
	//第一個參數為數字，第二個參數為要分割的符號，第三個參數則是傳回的值 (如要傳回第一個，就寫1，第二個就寫2..etc)
	def GetStringSpilt(String text, String symbol, int returnText)
	{
		def sampleText = text
		def getValue = sampleText.split(symbol)
		return getValue[returnText-1];
	}
}
