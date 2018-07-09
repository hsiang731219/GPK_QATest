import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
<<<<<<< HEAD
import org.openqa.selenium.By as By
import org.openqa.selenium.By.ByTagName as ByTagName
import org.openqa.selenium.By.ByXPath as ByXPath
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import common.IndexOfThirdPartyTC as IndexOfThirdPartyTC

'建立單一實例物件'
IndexOfThirdPartyTC instance = IndexOfThirdPartyTC.getInstance()

'從Excel的編號設定給單一實例'
instance.setIndexTC(2)
=======

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import custom.IndexOfThirdPartyTC

'設置在Excel的資料位置'
IndexOfThirdPartyTC.setIndexTC(2)
>>>>>>> Jay

def Info = WebUI.callTestCase(findTestCase('Common/CreateThirdPartyData'), [:], FailureHandling.STOP_ON_FAILURE)

'登入'
CustomKeywords.'common.MasterLogin.Login'()

'點擊系統>線上支付商戶管理'
CustomKeywords.'common.MenuIntoPage.getDropdownMenu'(3, 3)

'點擊新增線上支付商戶'
WebUI.click(findTestObject('Group/ThirdParty/Index_Page/a_Create'))

'輸入名稱'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_name'), Info.name)

'點擊類型'
WebUI.click(findTestObject('Group/ThirdParty/Create_Page/select_Type'))

WebUI.delay(2)

'輸入類型'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_type'), Info.type)

'點擊顯示的類型商戶'
WebUI.click(findTestObject('Group/ThirdParty/Create_Page/span_inner'))

'輸入商戶號'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_accountNumber_eBank'), Info.accountNumber)

'輸入商戶證書'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_merchantCertificate_eBank'), Info.merchantCertificate)

'輸入跳板網址'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_gateway_eBank'), Info.gateway)

'輸入下限金額'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_DepositMin'), Info.depositMin)

'輸入上限金額'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_DepositMax'), Info.depositMax)

'輸入總存款'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_DepositTotal'), Info.depositTotal)

'勾選會員等級'
<<<<<<< HEAD
WebUI.check(findTestObject('ThirdParty/Create_Page/label_MemberLevel'))
=======
WebUI.check(findTestObject('Group/ThirdParty/Create_Page/label_JayTest'))
>>>>>>> Jay

'儲存會員等級的文字'
String memberLevel_1 = WebUI.getText(findTestObject('Group/ThirdParty/Create_Page/label_JayTest'))

'點擊送出'
WebUI.click(findTestObject('Group/ThirdParty/Create_Page/button_Submit'))

'等待Alert'
WebUI.waitForAlert(5)

'點擊Alert'
WebUI.acceptAlert()

/**
 * 驗證是否與輸入資料的相同
 */
'類型'
WebUI.verifyEqual(WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/table_Type_eBank')), Info.type)

'商戶號'
WebUI.verifyEqual(WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/table_accountNumber_eBank')), Info.accountNumber)

'商戶證書'
WebUI.verifyEqual(WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/table_merchantCertificate_eBank')), Info.merchantCertificate)

'跳板網址'
WebUI.verifyEqual(WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/table_Gateway')), Info.gateway)

<<<<<<< HEAD
'單次存款限額有包含上限'
String depositMinMax = WebUI.getText(findTestObject('ThirdParty/ThirdParty_Exist/text_DepositMinMax'))

boolean isContainsMax = depositMinMax.contains(Info.depositMax)

WebUI.verifyEqual(isContainsMax, true)

'总存款限额'
String depositTotal = WebUI.getText(findTestObject('ThirdParty/ThirdParty_Exist/text_DepositTotal'))

boolean isContainsTotal = depositTotal.contains(Info.depositTotal)

WebUI.verifyEqual(isContainsTotal, true)

'會員等級的文字是否與新增的相同'
String memberLevel_2 = WebUI.getText(findTestObject('ThirdParty/ThirdParty_Exist/label_MemberLevel'))

WebUI.verifyEqual(memberLevel_2, memberLevel_1)
=======
'單次存款限額進行格式轉換後驗證上限'
String depositMinMax = WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/text_DepositMinMax'))
WebUI.verifyEqual(CustomKeywords.'extension.DataConversion.GetStringSpilt'(depositMinMax,'~',2), ' $ '+Info.depositMax)

'总存款限额進行格式轉換後驗證'
String depositTotal = WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/text_DepositTotal'))
WebUI.verifyEqual(CustomKeywords.'extension.DataConversion.GetStringSpilt'(depositTotal,' ',2), Info.depositTotal)

'會員等級的文字是否與新增的相同'
WebUI.verifyEqual(WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/label_MemberLevel')), memberLevel_1)
>>>>>>> Jay

'刪除此商戶號'
WebUI.click(findTestObject('Group/ThirdParty/Detail_Page/button_Remove'))

'等待Alert'
WebUI.waitForAlert(5)

'點擊Alert'
WebUI.acceptAlert()

'驗證有無出現刪除的div提示'
<<<<<<< HEAD
WebUI.verifyElementPresent(findTestObject('ThirdParty/ThirdParty_Exist/div_IsDeleted'), 30)

=======
WebUI.verifyElementPresent(findTestObject('Group/ThirdParty/Detail_Page/div_IsDeleted'), 30)
>>>>>>> Jay
