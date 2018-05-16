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
import java.text.SimpleDateFormat as SimpleDateFormat
// 將日期定於上個月一號
public class SetLastMonthNumberOne 
{
	@Keyword
	def setLastDayMonth()
	{
		'查詢時間(起)，即為上個月的1號'
		Calendar ca = Calendar.getInstance()
		
		Date now = ca.getTime()
		
		'月份減1'
		ca.add(Calendar.MONTH, -1)
		
		'取得結果'
		Date lastMonth = ca.getTime()
		
		SimpleDateFormat sf = new SimpleDateFormat('yyyy/MM/01')
		
		return sf.format(lastMonth)
			
	}

}
