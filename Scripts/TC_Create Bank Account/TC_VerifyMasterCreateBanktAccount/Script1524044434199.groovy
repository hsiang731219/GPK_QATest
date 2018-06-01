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

//系統管理-> 公司入款帳戶管理
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(3, 2)

WebUI.waitForElementVisible(findTestObject('Group/Index_Page/a_CreateBankAccount'), 10)

WebUI.click(findTestObject('Group/Index_Page/a_CreateBankAccount'))

WebUI.setText(findTestObject('Group/Create_Page/input_BankAccount'), 'QA測試銀行(沒有寫備註)')

WebUI.setText(findTestObject('Group/Create_Page/input_Payer'), '王小Q')

WebUI.setText(findTestObject('Group/Create_Page/input_CreateBankPlace'), '吉林省松原市')

WebUI.setText(findTestObject('Group/Create_Page/input_BankNumberAccount'), '123456789')

WebUI.click(findTestObject('Group/Create_Page/input_SelectAllLevel'))

WebUI.click(findTestObject('Group/Create_Page/button_Send'))

WebUI.waitForAlert(500, FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

'新增完畢後，要驗證新增完資訊是否和剛剛填寫的一樣'

'取得銀行文字'
verify_BankAccount = WebUI.getText(findTestObject('Group/Detail_Page/td_BankAccount'))

WebUI.verifyEqual('QA測試銀行(沒有寫備註)', verify_BankAccount)

'取得收款人文字'
verify_Payer = WebUI.getText(findTestObject('Group/Detail_Page/td_Payer'))

WebUI.verifyEqual('王小Q', verify_Payer)

'取得開戶行網點 文字'
verify_CreateBankPlace = WebUI.getText(findTestObject('Group/Detail_Page/td_CreateBankPlace'))

WebUI.verifyEqual('吉林省松原市', verify_CreateBankPlace)

'取得 銀行帳號 文字'
verify_BankNumberAccount = WebUI.getText(findTestObject('Group/Detail_Page/td_BankNumberAccount'))

WebUI.verifyEqual('123456789', verify_BankNumberAccount)

WebUI.click(findTestObject('Shared/link_SystmeAndManagementMeenu'))

WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_BankDepositAccountManagment'))

WebUI.waitForElementVisible(findTestObject('Group/Index_Page/a_CreateBankAccount'), 10)

'把最後一筆公司入款的名字記錄下來'
verify_FinalBankAccount = WebUI.getText(findTestObject('Group/Index_Page/a_-FinalCreateBankAccount'))

WebUI.verifyEqual('QA測試銀行(沒有寫備註)-王小Q', verify_FinalBankAccount)

WebUI.click(findTestObject('Group/Index_Page/a_-FinalCreateBankAccount'))

WebUI.waitForElementPresent(findTestObject('Group/Detail_Page/td_BankAccount'), 30)

CustomKeywords.'extension.ClickXpath.clickUsingJS'(findTestObject('Group/Detail_Page/btn_Delete'), 0)

WebUI.waitForAlert(500, FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

