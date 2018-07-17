import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement



import custom.IndexOfThirdPartyTC

'設置在Excel的資料位置'
IndexOfThirdPartyTC.setIndexTC(2)

def Info= WebUI.callTestCase(findTestCase('Common/CreateThirdPartyData'), [:], FailureHandling.STOP_ON_FAILURE)

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

/**
 * 由於欄位會隨選取的類型有所變動，
 * 所以選取類型後，在計算出現的欄位數，
 * 再用for迴圈依序塞值
 */
WebDriver driver = DriverFactory.getWebDriver()

WebElement createList = driver.findElement(By.xpath("/html/body/root-component/div/div/form/fieldset[2]"))

//商戶資料的欄位數(扣除類型)
List<WebElement> createColumns = createList.findElements(By.xpath("//*[@type='text' and @ng-model='col.model']"))

//建立商戶資料欄位，給與createColumns.size()的個數陣列
def createThirdPartyInfo =[createColumns.size()]

for (int i =0;i<createColumns.size();i++) {
	//塞值進去，假如有4個欄位，依序是:
	//1
	//2
	//3
	//4
	createThirdPartyInfo.add(i, i+1+"")
	//如果商戶資料欄位是"跳板網址"(通常在最後一欄)，就固定設"http://"
	if(i==createColumns.size()-1){
		createThirdPartyInfo.set(i, "http://"+i)
	}
	'輸入商戶資料各個欄位'
	WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_PaymentAccountInfo',[('colum_num'):i+2]), createThirdPartyInfo.get(i))
}

'輸入下限金額'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_DepositMin'), Info.depositMin)

'輸入上限金額'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_DepositMax'), Info.depositMax)

'輸入總存款'
WebUI.setText(findTestObject('Group/ThirdParty/Create_Page/input_DepositTotal'), Info.depositTotal)

'勾選會員等級'
WebUI.check(findTestObject('Group/ThirdParty/Create_Page/label_JayTest'))

'儲存會員等級的文字'
String memberLevel_1 = WebUI.getText(findTestObject('Group/ThirdParty/Create_Page/label_JayTest'))

'點擊送出'
WebUI.click(findTestObject('Group/ThirdParty/Create_Page/button_Submit'))

'等待Alert'
WebUI.waitForAlert(5)

'點擊Alert'
WebUI.acceptAlert()

WebUI.delay(1)

/**
 * 驗證是否與輸入資料的相同
 */

WebElement detailList = driver.findElement(By.xpath("//*[@id='table1']"))
//商戶資料的欄位數
List<WebElement> detailColumns = detailList.findElements(By.xpath("//*[@id='table1']/tbody/tr/td//*[@class='ng-binding ng-scope']"))

for(int i =0;i<detailColumns.size()-1;i++){
	String s = WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/div_PaymentAccountInfo',[('colum_num'):i+2]))
	
	'驗證商戶資料欄位'
	WebUI.verifyEqual(s, createThirdPartyInfo.get(i))
}

'單次存款限額進行格式轉換後驗證上限'
String depositMinMax = WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/text_DepositMinMax'))
WebUI.verifyEqual(CustomKeywords.'extension.DataConversion.GetStringSpilt'(depositMinMax,'~',2), ' $ '+Info.depositMax)

'总存款限额進行格式轉換後驗證'
String depositTotal = WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/text_DepositTotal'))
WebUI.verifyEqual(CustomKeywords.'extension.DataConversion.GetStringSpilt'(depositTotal,' ',2), Info.depositTotal)

'會員等級的文字是否與新增的相同'
WebUI.verifyEqual(WebUI.getText(findTestObject('Group/ThirdParty/Detail_Page/label_MemberLevel')), memberLevel_1)

'刪除此商戶號'
WebUI.click(findTestObject('Group/ThirdParty/Detail_Page/button_Remove'))

'等待Alert'
WebUI.waitForAlert(5)

'點擊Alert'
WebUI.acceptAlert()

'驗證有無出現刪除的div提示'
WebUI.verifyElementPresent(findTestObject('Group/ThirdParty/Detail_Page/div_IsDeleted'), 30)