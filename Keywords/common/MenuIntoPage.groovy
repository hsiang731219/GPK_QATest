package common

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
import com.sun.java.util.jar.pack.Instruction.Switch

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class MenuIntoPage {

	@Keyword
	def getDropdownMenu(int x , int y) {

		WebUI.click(findTestObject('Shared/menu_Top',[('i'):x]))

		if (x == 1) {
			// 會員與代理商
			WebUI.click(findTestObject('Shared/menu_MemberAndAgentList',[('list_num'):y+2]))

		} else if(x == 2) {
			// 帳務管理
			WebUI.click(findTestObject('Shared/menu_AccountManagementList',[('list_num'):y+2]))

		} else if(x == 3) {
			// 系統管理
			WebUI.click(findTestObject('Shared/menu_SystemAndManagementList',[('list_num'):y+2]))

		} else {
			//各式報表
			WebUI.click(findTestObject('Shared/menu_RepotrsList',[('list_num'):y+2]))
		}
	}

	/***
	 * *會員與代理商*
	 *1.會員查詢
	 *2.代理商查詢
	 *3.新增會員
	 *4.會員匯入
	 *5.新增代理商
	 *6.代理申請審核
	 *7.試玩審核
	 * 因元素定位問題因此會有 "+2" 這東西出現
	 */

	/***
	 * *帳務管理*
	 *1.公司入款審核
	 *2.線上支付看板
	 *3.取款申請查詢
	 *4.交易紀錄查詢
	 *5.返水計算
	 *6.傭金計算
	 *7.轉帳額度確認
	 *8.優惠匯入
	 *9.總存取款匯出 
	 */

	/***
	 * *系統管理*
	 *1.會員等級管理
	 *2.公司入款帳戶管理
	 *3.線上支付商戶管理
	 *4.會員端設定
	 *5.返水設定
	 *6.傭金設定
	 *7.娛樂城管理
	 *8.站內信
	 *9.優惠管理
	 *10.子帳號管理
	 *11.站台系統值設置
	 *12.網站設定管理
	 *13.活動管理
	 *14.國別阻擋管理
	 */

	/***
	 * *各式報表*
	 *1.統計報表
	 *2.投注紀錄查詢
	 *3.歷史投注紀錄查詢
	 *4.登入記錄查詢
	 *5.娛樂城轉帳紀錄查詢
	 *6.AG交易紀錄匯出
	 *7.報表連結
	 *8.貢獻金
	 */
}

