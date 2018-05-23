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
		if (x == 1) {
			WebUI.click(findTestObject('Shared/link_MemberAndAgentMenu'))
			getdropdownA(y)
		} else if(x == 2) {
			WebUI.click(findTestObject('Shared/link_AccountManagementMenu'))
			getdropdownB(y)
		} else if(x == 3) {
			WebUI.click(findTestObject('Shared/link_SystmeAndManagementMeenu'))
			getdropdownC(y)
		} else {
			WebUI.click(findTestObject('Shared/link_ReportsMeenu'))
			getdropdownD(y)
		}
	}


	// 會員與代理商
	def getdropdownA(int z)
	{
		if (z == 1)
		{ //會員查詢
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/link_SearchForMember'))

		} else if (z == 2)
		{ //代理商查詢
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/link_SearchForAgent'))

		} else if (z == 3)
		{ //新增會員
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/link_CreateNewMember'))

		} else if (z == 4)
		{ //會員匯入
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/link_MemberImport'))

		} else if (z == 5)
		{ //新增代理商
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/link_CreateNewAgent'))

		} else if (z == 6)
		{ //代理申請審核
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/link_VerifyAgentApplication'))

		} else if (z == 7)
		{ //試玩審核
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/link_VerifyTrialAccount'))
		}
	}

	// 帳務管理
	def getdropdownB(int z)
	{
		if (z == 1)
		{ //公司入款審核
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_VerifyBankDesposit'))

		} else if (z == 2)
		{ //線上支付看板
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_OnlinePaymentList'))

		} else if (z == 3)
		{ //取款申請查詢
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_VerifyWithdrawalApplication'))

		} else if (z == 4)
		{ //交易紀錄查詢
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_SearchForTransactionRecords'))

		} else if (z == 5)
		{ //返水計算
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_RebateCalculation'))

		} else if (z == 6)
		{ //傭金計算
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_CommissionCalculation'))

		} else if (z == 7)
		{ //轉帳額度確認
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_TransferAmountConfirmatiom'))
		} else if (z == 8)
		{ //優惠匯入
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_PromotionImport'))

		} else
		{ //總存取款匯出
			WebUI.click(findTestObject('Shared/list_AccountManagement/link_TotalWithdrawalAndDeposit'))
		}
	}

	// 系統管理
	def getdropdownC(int z)
	{
		if (z == 1)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_MemberLevelManagement'))

		} else if (z == 2)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_BankDepositAccountManagment'))

		} else if (z == 3)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_OnlinePaymentAccountManagment'))

		} else if (z == 4)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_ProtalSetting'))

		} else if (z == 5)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_RebateSetting'))

		} else if (z == 6)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_CommissionSetting'))

		} else if (z == 7)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_GameProviderMangement'))
		} else if (z == 8)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_InternalMail'))
		} else if (z == 9)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_PromotionManagment'))
		} else if (z == 10)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_SubAccountManagement'))
		} else if (z == 11)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_WebsiteSystemConfigure'))
		} else if (z == 12)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_WebsiteSettingConfigure'))
		} else if (z == 13)
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_EventSetting'))
		} else
		{
			WebUI.click(findTestObject('Shared/list_SystmeAndManagement/link_CountryBlockManagementt'))
		}
	}


	// 各式報表
	def getdropdownD(int z)
	{
		if (z == 1)
		{ //統計報表
			WebUI.click(findTestObject('Shared/list_Reports/link_StatisticsReport'))

		} else if (z == 2)
		{ //投注紀錄查詢
			WebUI.click(findTestObject('Shared/list_Reports/link_SearchForBettingRecords'))

		} else if (z == 3)
		{ //歷史投注紀錄查詢
			WebUI.click(findTestObject('Shared/list_Reports/link_SearchForHistoricalBettingRecords'))

		} else if (z == 4)
		{ //登入記錄查詢
			WebUI.click(findTestObject('Shared/list_Reports/link_SearchForLoginRecords'))

		} else if (z == 5)
		{ //娛樂城轉帳紀錄查詢
			WebUI.click(findTestObject('Shared/list_Reports/link_SearchForGameProviderTransferRecords'))

		} else if (z == 6)
		{ //AG交易紀錄匯出
			WebUI.click(findTestObject('Shared/list_Reports/link_AGTransactionRecord'))

		} else if (z == 7)
		{ //報表連結
			WebUI.click(findTestObject('Shared/list_Reports/link_ReportLink'))

		} else
		{ //貢獻金
			WebUI.click(findTestObject('Shared/list_MemberAndAgent/list_Reports/'))
		}
	}
}

