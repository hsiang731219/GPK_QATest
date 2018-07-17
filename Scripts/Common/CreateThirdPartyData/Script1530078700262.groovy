import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.reader.ExcelFactory

import custom.IndexOfThirdPartyTC

'建立單一實例物件'
int i = IndexOfThirdPartyTC.getIndexTC()

def createThirdPartyInfo = [ 'name' : '',
	'type' : '' ,
	'depositMin' : '',
	'depositMax' :'',
	'depositTotal' :'']

ExcelData data = ExcelFactory.getExcelDataWithDefaultSheet("D:/GM Automation Test Data/MasterTestData.xlsx", "CreateThirdPartyInfo", false)

createThirdPartyInfo.name = data.getValue(1, i)
createThirdPartyInfo.type = data.getValue(2, i)
createThirdPartyInfo.depositMin = data.getValue(3, i)
createThirdPartyInfo.depositMax = data.getValue(4, i)
createThirdPartyInfo.depositTotal = data.getValue(5, i)

return createThirdPartyInfo