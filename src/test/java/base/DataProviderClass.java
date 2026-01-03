package base;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.PS.Utilities.Excelutils;

public class DataProviderClass {

	static String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "TestData" + File.separator + "BrandData" + File.separator
			+ "PallaviSwadi_TestData.xlsx";

	@DataProvider(name = "BrandData")
	public static Object[][] getLoginData() {

		String sheetName = "BrandData";

		int rowCount = Excelutils.getRowCount(filePath, sheetName);
		int colCount = Excelutils.getCellCount(filePath, sheetName);

		Object[][] data = new Object[rowCount][colCount];

		// start from row 1 (skip header)
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i - 1][j] = Excelutils.getCellValue(filePath, sheetName, i, j);
			}
		}
		return data;
	}

}
