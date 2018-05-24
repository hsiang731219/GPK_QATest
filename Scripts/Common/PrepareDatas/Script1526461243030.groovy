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

def urlInfo = [ 'adminurl'  : '' ,
				'masterurl' : '' ,
				'agenturl'  : '' ,
				'protalrurl': '' ,
				'mobileurl' : ''  ]

def loginInfo = [ 'username' : '' ,
	              'password' : '' ,
				  'depositpassword' : '']

def dAndWInfo = [ 'account' : '' ,
	              'amount' : '' ,
				  'depositpassword' : '',
				  'withdrawpassword' : '',
				  'auditAmount' : '',
				  'noNeedToAudit' : '',
				  'depositAudit' :'',
				  'promotionAudit' :'',
				  'type1' :'',
				  'type2' :'',
				  'type3' :'',
				  'type4' :'',
				  'type5' :'']

ExcelData TestSuiteUrlInfo = ExcelFactory.getExcelDataWithDefaultSheet("D:/TestData.xlsx", "TestSuiteUrlInfo", false)

urlInfo.adminurl = TestSuiteUrlInfo.getValue(1, 2)
urlInfo.masterurl = TestSuiteUrlInfo.getValue(2, 2)
urlInfo.agenturl = TestSuiteUrlInfo.getValue(3, 2)
urlInfo.protalrurl = TestSuiteUrlInfo.getValue(4, 2)
urlInfo.mobileurl = TestSuiteUrlInfo.getValue(5, 2)

ExcelData MasterLoginInfo = ExcelFactory.getExcelDataWithDefaultSheet("D:/TestData.xlsx", "MasterLoginInfo", false)

loginInfo.username = MasterLoginInfo.getValue(1, 2)
loginInfo.password = MasterLoginInfo.getValue(2, 2)
loginInfo.depositpassword = MasterLoginInfo.getValue(3, 2)

ExcelData DepositAndWithdrawInfo = ExcelFactory.getExcelDataWithDefaultSheet("D:/TestData.xlsx", "DepositAndWithdrawInfo", false)

dAndWInfo.account = DepositAndWithdrawInfo.getValue(1, 2)
dAndWInfo.amount = Integer.parseInt(DepositAndWithdrawInfo.getValue(2, 2))
dAndWInfo.depositpassword = DepositAndWithdrawInfo.getValue(3, 2)
dAndWInfo.withdrawpassword = DepositAndWithdrawInfo.getValue(4, 2)
dAndWInfo.auditAmount = Integer.parseInt(DepositAndWithdrawInfo.getValue(5, 2))
dAndWInfo.noNeedToAudit = DepositAndWithdrawInfo.getValue(1, 4)
dAndWInfo.depositAudit = DepositAndWithdrawInfo.getValue(2, 4)
dAndWInfo.promotionAudit = DepositAndWithdrawInfo.getValue(3, 4)
dAndWInfo.type1 = DepositAndWithdrawInfo.getValue(1, 5)
dAndWInfo.type2 = DepositAndWithdrawInfo.getValue(2, 5)
dAndWInfo.type3 = DepositAndWithdrawInfo.getValue(3, 5)
dAndWInfo.type4 = DepositAndWithdrawInfo.getValue(4, 5)
dAndWInfo.type5 = DepositAndWithdrawInfo.getValue(5, 5)


return [urlInfo,loginInfo,dAndWInfo]
