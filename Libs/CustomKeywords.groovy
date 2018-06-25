
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String


def static "extension.UIMethod.clickUsingJS"(
    	TestObject to	
     , 	int timeout	) {
    (new extension.UIMethod()).clickUsingJS(
        	to
         , 	timeout)
}

def static "extension.UIMethod.tryFindElement"(
    	TestObject to	) {
    (new extension.UIMethod()).tryFindElement(
        	to)
}

def static "extension.UIMethod.setLastDayMonth"() {
    (new extension.UIMethod()).setLastDayMonth()
}

def static "common.MasterLogin.Login"() {
    (new common.MasterLogin()).Login()
}

def static "common.MenuIntoPage.getDropdownMenu"(
    	int x	
     , 	int y	) {
    (new common.MenuIntoPage()).getDropdownMenu(
        	x
         , 	y)
}

def static "extension.DataConversion.CurrencyToInt"(
    	String point	) {
    (new extension.DataConversion()).CurrencyToInt(
        	point)
}

def static "extension.DataConversion.GetStringSpilt"(
    	String text	
     , 	String symbol	
     , 	int returnText	) {
    (new extension.DataConversion()).GetStringSpilt(
        	text
         , 	symbol
         , 	returnText)
}

def static "extension.DataConversion.yearmonthdate"(
    	String point	) {
    (new extension.DataConversion()).yearmonthdate(
        	point)
}
