import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.reader.ExcelFactory

import common.IndexOfThirdPartyTC

'建立單一實例物件'
IndexOfThirdPartyTC instance = IndexOfThirdPartyTC.getInstance()
'取得Test Case設定的編號'
int i = instance.getIndexTC()

def createThirdPartyInfo = [ 'name' : '',
	'type' : '' ,
	'accountNumber' : '',
	'key' : '',
	'gateway' : '',
	'depositMin' : '',
	'depositMax' :'',
	'depositTotal' :'',
	'merchantCertificate' :'',
	'Email' :'',
	'APPID' :'',
	'OrderKey' :'',
	'CallbackKey' :'']

ExcelData data = ExcelFactory.getExcelDataWithDefaultSheet("C:/Users/admin/GM Automation Test Data/MasterTestData.xlsx", "CreateThirdPartyInfo", false)

createThirdPartyInfo.name = data.getValue(1, i)
createThirdPartyInfo.type = data.getValue(2, i)
createThirdPartyInfo.accountNumber = data.getValue(3, i)
createThirdPartyInfo.key = data.getValue(4, i)
createThirdPartyInfo.gateway = data.getValue(5, i)
createThirdPartyInfo.depositMin = data.getValue(6, i)
createThirdPartyInfo.depositMax = data.getValue(7, i)
createThirdPartyInfo.depositTotal = data.getValue(8, i)
createThirdPartyInfo.merchantCertificate = data.getValue(9, i)
createThirdPartyInfo.Email = data.getValue(10, i)
createThirdPartyInfo.APPID = data.getValue(11, i)
createThirdPartyInfo.OrderKey = data.getValue(12, i)
createThirdPartyInfo.CallbackKey = data.getValue(13, i)


return createThirdPartyInfo