import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import common.IndexOfThirdPartyTC

'建立單一實例物件'
IndexOfThirdPartyTC instance = IndexOfThirdPartyTC.getInstance()
'從Excel的編號設定給單一實例'
instance.setIndexTC(17)

def Info= WebUI.callTestCase(findTestCase('Common/CreateThirdPartyData'), [:], FailureHandling.STOP_ON_FAILURE)

'登入'
CustomKeywords.'common.MasterLogin.Login'()

'點擊系統>線上支付商戶管理'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(3, 3)


'點擊新增線上支付商戶'
WebUI.click(findTestObject('ThirdParty/Index_Page/a_Create'))

'輸入名稱'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_name'), Info.name)

'點擊類型'
WebUI.click(findTestObject('ThirdParty/Create_Page/select_Type'))

WebUI.delay(2)

'輸入類型'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_type'), Info.type)

'點擊顯示的類型商戶'
WebUI.click(findTestObject('ThirdParty/Create_Page/span_inner'))

'輸入商戶號'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_PaymentInfo1'), Info.accountNumber)

'輸入密鑰'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_PaymentInfo2'), Info.key)

'輸入跳板網址'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_PaymentInfo3'), Info.gateway)

'輸入下限金額'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_DepositMin'), Info.depositMin)

'輸入上限金額'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_DepositMax'), Info.depositMax)

'輸入總存款'
WebUI.setText(findTestObject('ThirdParty/Create_Page/input_DepositTotal'), Info.depositTotal)

'勾選會員等級'
WebUI.check(findTestObject('ThirdParty/Create_Page/label_MemberLevel'))

'儲存會員等級的文字'
String memberLevel_1 = WebUI.getText(findTestObject('ThirdParty/Create_Page/label_MemberLevel'))

'點擊送出'
WebUI.click(findTestObject('ThirdParty/Create_Page/button_Submit'))

'等待Alert'
WebUI.waitForAlert(5)

'如果Alert是已存在'
String s = WebUI.getAlertText()
boolean isContainExist = s.contains('已存在')

'驗證是否商號名稱是否已存在，已存在則通過'
WebUI.verifyEqual(isContainExist, true)