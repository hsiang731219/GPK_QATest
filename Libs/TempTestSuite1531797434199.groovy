import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/TS_Manually Deposit')

suiteProperties.put('name', 'TS_Manually Deposit')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("D:\\GM Automation\\GPK_QATest\\Reports\\TS_Manually Deposit\\20180717_111714\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/TS_Manually Deposit', suiteProperties, [new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit01', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit01',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit02', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit02',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit03', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit03',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit04', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit04',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit05', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit05',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit06', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit06',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit07', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit07',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit08', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit08',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit09', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit09',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit10', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit10',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit11', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit11',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit12', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit12',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit13', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit13',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit14', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit14',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit15', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit15',  null), new TestCaseBinding('Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit16', 'Test Cases/TC_Manually Deposit/TC_VerifyMasterManuallyDeposit16',  null)])
