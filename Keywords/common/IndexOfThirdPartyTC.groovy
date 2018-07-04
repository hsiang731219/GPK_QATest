package common

import com.kms.katalon.core.annotation.Keyword

public class IndexOfThirdPartyTC {

	private int index

	private static IndexOfThirdPartyTC instance

	private IndexOfThirdPartyTC(){}

	public static IndexOfThirdPartyTC getInstance(){
		if(instance==null){
			instance = new IndexOfThirdPartyTC()
		}
		return instance;
	}


	public int setIndexTC(int i){
		index = i
	}


	public int getIndexTC(){
		return index
	}
}
