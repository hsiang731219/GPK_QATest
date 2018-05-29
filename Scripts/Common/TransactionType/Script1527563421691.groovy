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

def transactionTypeInfo = [ 'bankDeposit' : '' ,
				  			'onlineDeposit' : '' ,
							'onlineWithdrawal' : '' ,
							'manuallyDepositAndWithdrawal' : '' ,
							'promotionEvent' : '' ,
							'rebate' : '' ,
							'payoff' : '' ,
							'anyTimeDiscount' : '' ,
							'others' : '' ]

ExcelData TransactionTypeInfo = ExcelFactory.getExcelDataWithDefaultSheet("D:/TestData.xlsx", "TransactionType", false)

transactionTypeInfo.bankDeposit = TransactionTypeInfo.getValue(1, 2)
transactionTypeInfo.onlineDeposit = TransactionTypeInfo.getValue(1, 3)
transactionTypeInfo.onlineWithdrawal = TransactionTypeInfo.getValue(1, 4)
transactionTypeInfo.manuallyDepositAndWithdrawal = TransactionTypeInfo.getValue(1, 5)
transactionTypeInfo.promotionEvent = TransactionTypeInfo.getValue(1, 6)
transactionTypeInfo.rebate = TransactionTypeInfo.getValue(1, 7)
transactionTypeInfo.payoff = TransactionTypeInfo.getValue(1, 8)
transactionTypeInfo.anyTimeDiscount = TransactionTypeInfo.getValue(1, 9)
transactionTypeInfo.others = TransactionTypeInfo.getValue(1, 10)

System.out.println(transactionTypeInfo)

return transactionTypeInfo