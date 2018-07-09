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


suiteProperties.put('id', 'Test Suites/TS_Online Issue')

suiteProperties.put('name', 'TS_Online Issue')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())



RunConfiguration.setExecutionSettingFile("D:\\GM Automation\\GPK_QA\\Reports\\TS_Online Issue\\20180709_115849\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/TS_Online Issue', suiteProperties, [new TestCaseBinding('Test Cases/TC_Online Issue/TC_VeriftyMasterTransactionEveryPageDataNotRepeating', 'Test Cases/TC_Online Issue/TC_VeriftyMasterTransactionEveryPageDataNotRepeating',  null), new TestCaseBinding('Test Cases/TC_Online Issue/TC_VerifyMasterMemberTransactionType', 'Test Cases/TC_Online Issue/TC_VerifyMasterMemberTransactionType',  null), new TestCaseBinding('Test Cases/TC_Online Issue/TC_VerifyOnlinePaymentBulletinWithStatus(Cancel)', 'Test Cases/TC_Online Issue/TC_VerifyOnlinePaymentBulletinWithStatus(Cancel)',  null), new TestCaseBinding('Test Cases/TC_Online Issue/TC_VerifyOnlinePaymentBulletinWithStatus(Sucess)', 'Test Cases/TC_Online Issue/TC_VerifyOnlinePaymentBulletinWithStatus(Sucess)',  null), new TestCaseBinding('Test Cases/TC_Online Issue/TC_VerifyTodayValidBetEqualStatisticsReportValidBet', 'Test Cases/TC_Online Issue/TC_VerifyTodayValidBetEqualStatisticsReportValidBet',  null)])
