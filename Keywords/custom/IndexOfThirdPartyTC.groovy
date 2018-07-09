package custom

import com.kms.katalon.core.annotation.Keyword

/**
 * 
 * 目前只用於 TC_CreateThirdParty，方便設定數值及取出數值。
 * 在TC_CreateThirdParty的各個TestCase設定Excel的資料位置 setIndexTC(int i)
 * 在Common>CreateThirdPartyData 取得Excel的資料位置 getIndexTC()
 *
 */
public class IndexOfThirdPartyTC {

	private static int index;

	public static int setIndexTC(int i){
		this.index = i;
	}

	public static int getIndexTC(){
		return this.index;
	}
}
