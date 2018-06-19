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
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import sun.awt.datatransfer.ClipboardTransferable.DataFactory as DataFactory

def Gpk_Info = [('Gpk_admin') : '', 
				('Gpk_master') : '',
				('Gpk_agent') : '', 
				('Gpk_protal') : '', 
				('Gpk_mobile') : '', 
				('Release_admin') : '', 
				('Release_master') : '', 
				('Release_agent') : '', 
				('Release_protal') : '', 
				('Release_mobile') : '']

ExcelData Url_Info = ExcelFactory.getExcelDataWithDefaultSheet("D:/GM Automation Test Data/MasterTestData.xlsx", 'TestEnvironmenInfo', false)

Gpk_Info.Gpk_admin = Url_Info.getValue(2, 2)

Gpk_Info.Gpk_master = Url_Info.getValue(3, 2)

Gpk_Info.Gpk_agent = Url_Info.getValue(4, 2)

Gpk_Info.Gpk_protal = Url_Info.getValue(5, 2)

Gpk_Info.Gpk_mobile = Url_Info.getValue(6, 2)

Gpk_Info.Release_admin = Url_Info.getValue(2, 3)

Gpk_Info.Release_master = Url_Info.getValue(3, 3)

Gpk_Info.Release_agent = Url_Info.getValue(4, 3)

Gpk_Info.Release_protal = Url_Info.getValue(5, 3)

Gpk_Info.Release_mobile = Url_Info.getValue(6, 3)

return Gpk_Info

