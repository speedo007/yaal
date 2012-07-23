package on2011_11_18.p8xcoinchange;

import net.egork.chelper.tester.TopCoderTester;
import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!TopCoderTester.test("int solve(long coins_sum, long[] values)",
			"on2011_11_18.p8xcoinchange.P8XCoinChange",
			"4;;1,3;;2;;true::4;;1,2,4;;4;;true::3;;1,5;;1;;true::11;;1,2,6;;9;;true::1000000000000000000;;1,1000000000,1000000000000000000;;997005;;true::961320341778342848;;1,2,10,30,150,300,1200,2400,4800,14400,28800,57600,288000,576000,2304000,9216000,18432000,73728000,221184000,663552000,1327104000,5308416000,31850496000,95551488000,191102976000,764411904000,1528823808000,6115295232000,18345885696000,36691771392000,73383542784000,220150628352000,440301256704000,1320903770112000,3962711310336000,15850845241344000,31701690482688000,95105071448064000,475525357240320000,951050714480640000;;245264;;true::1000000000000000000;;1,2;;499989;;true"))
		{
			Assert.fail();
		}
	}
}
