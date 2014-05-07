package org.devgateway.eudevfin.reports.core.liquibase;

import java.util.HashSet;
import java.util.Set;

import liquibase.database.Database;
import liquibase.exception.CustomChangeException;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;

import org.devgateway.eudevfin.common.liquibase.AbstractSpringCustomTaskChange;
import org.devgateway.eudevfin.reports.core.dao.RowReportDao;
import org.devgateway.eudevfin.reports.core.domain.ColumnReport;
import org.devgateway.eudevfin.reports.core.domain.RowReport;
import org.devgateway.eudevfin.reports.core.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

public class PopulateDAC1Rows extends AbstractSpringCustomTaskChange {
	@Autowired
	private RowReportDao rowReportDao;

	@Override
	public void execute(Database database) throws CustomChangeException {
		insertKeyIndicators();
		insertSectionI();
		insertSectionII();
		insertSectionIII();
		insertSectionIV();
		insertSectionV();

		HashSet<String> sumRow1010 = new HashSet<String>();
		sumRow1010.add("1015");
		sumRow1010.add("2000");
		RowReport row1010 = createDAC1SumRow("1010", Constants.SUM, sumRow1010);
		rowReportDao.save(row1010);

		HashSet<String> sumRow005 = new HashSet<String>();
		sumRow005.add("1010");
		sumRow005.add("230");
		sumRow005.add("330");
		sumRow005.add("415");
		RowReport row005 = createDAC1SumRow("005", Constants.SUM, sumRow005);
		rowReportDao.save(row005);

	}

	private void insertKeyIndicators() {
		RowReport row001 = createDAC1KIRow("001", Constants.CALCULATED,
				"[Type of Finance].[TYPE_OF_FINANCE##1]");
		rowReportDao.save(row001);
		RowReport row002 = createDAC1KIRow("002", Constants.CALCULATED,
				"[Type of Finance].[TYPE_OF_FINANCE##2]");
		rowReportDao.save(row002);
		RowReport row003 = createDAC1KIRow("003", Constants.CALCULATED,
				"[Type of Finance].[TYPE_OF_FINANCE##3]");
		rowReportDao.save(row003);
		RowReport row004 = createDAC1KIRow("004", Constants.CALCULATED,
				"[Type of Finance].[TYPE_OF_FINANCE##4]");
		rowReportDao.save(row004);
	}

	private RowReport createDAC1KIRow(String name, int type,
			String typeOfFinance) {
		RowReport row = new RowReport("DAC1", name, type);

		Set<String> categories = new HashSet<String>();
		categories.add("[Type of Aid].Members");
		row.setCategories(categories);

		Set<ColumnReport> columns = new HashSet<ColumnReport>();

		ColumnReport col1 = new ColumnReport("1140", Constants.CALCULATED,
				"[Measures].[A]", typeOfFinance);
		col1.setPattern("#,##0");
		columns.add(col1);
		row.setColumns(columns);
		return row;
	}

	private void insertSectionI() {
		insertSectionIA();
		insertSectionIB();
	}
	private void insertSectionIB() {
		RowReport row2101 = createDAC1Row("2101", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"[Channel].[UNGroup]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2101);
		RowReport row2102 = createDAC1Row("2102", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"{[Channel].[EUGroup]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2102);
		RowReport row2103 = createDAC1Row("2103", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"{[Channel].[44002],[Channel].[44003],[Channel].[44007]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2103);
		RowReport row2104 = createDAC1Row("2104", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"{[Channel].[44001],[Channel].[44004],[Channel].[44005],[Channel].[44006]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2104);
		RowReport row2105 = createDAC1Row("2105", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"[Channel].[RBGroup]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2105);
		RowReport row2106 = createDAC1Row("2106", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"{[Channel].[47044],[Channel].[47129],[Channel].[47130]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2106);
		RowReport row2107 = createDAC1Row("2107", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"[Channel].[47078]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2107);
		RowReport row2108 = createDAC1Row("2108", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"[Channel].[OtherGroup]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2108);
		RowReport row2110 = createDAC1Row("2110", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B02]",
				"",
				"[Channel].[40000]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row2110);

		HashSet<String> sumRow2100 = new HashSet<String>();
		sumRow2100.add("2101");
		sumRow2100.add("2102");
		sumRow2100.add("2103");
		sumRow2100.add("2104");
		sumRow2100.add("2105");
		sumRow2100.add("2106");
		sumRow2100.add("2107");
		sumRow2100.add("2108");
		RowReport row2100 = createDAC1SumRow("2100", Constants.SUM, sumRow2100);
		rowReportDao.save(row2100);

		HashSet<String> sumRow2000 = new HashSet<String>();
		sumRow2000.add("2101");
		sumRow2000.add("2102");
		sumRow2000.add("2103");
		sumRow2000.add("2104");
		sumRow2000.add("2105");
		sumRow2000.add("2106");
		sumRow2000.add("2107");
		sumRow2000.add("2108");
		RowReport row2000 = createDAC1SumRow("2000", Constants.SUM, sumRow2000);
		rowReportDao.save(row2000);



		//TODO: Rows 2901 and 2902 seems to be determined arbitrarily. Find a formula that can match it. 
		RowReport row2901 = createDAC1Row("2901", Constants.CALCULATED,
				"{[BiMultilateral].[BI_MULTILATERAL##1],[BiMultilateral].[BI_MULTILATERAL##2]}",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"{[Type of Aid].[B02],[Type of Aid].[F01]}",
				"{[Sector].[60010],[Sector].[60020],[Sector].[60030]}",
				"{[Channel].[43002],[Channel].[43004],[Channel].[44003],[Channel].[44007],[Channel].[46003],[Channel].[46012],[Channel].[42004]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##310],[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"");
		rowReportDao.save(row2901);
		/*RowReport row2902 = createDAC1Row("2902", Constants.CALCULATED,
				"{[BiMultilateral].[BI_MULTILATERAL##1],[BiMultilateral].[BI_MULTILATERAL##2]}",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"",
				"",
				"{[Channel].[44001],[Channel].[44002]}",
				"[Type of Finance].Members",
				"",
				"",
				"[Type of Finance].Members",
				"");
		rowReportDao.save(row2902);*/
		
	}

	private void insertSectionIA() {
		RowReport row1110 = createDAC1Row("1110", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[A01]",
				"[Sector].[51010]",
				"[Channel].[12000]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row1110);
		RowReport row1120 = createDAC1Row("1120", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[A02]",
				"",
				"[Channel].[12000]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row1120);

		HashSet<String> sumRow1100 = new HashSet<String>();
		sumRow1100.add("1110");
		sumRow1100.add("1120");
		RowReport row1100 = createDAC1SumRow("1100", Constants.SUM, sumRow1100);
		rowReportDao.save(row1100);

		RowReport row1211 = createDAC1Row("1211", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##3]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B01]", 
				"",
				"[Channel].[22000]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"");
		rowReportDao.save(row1211);
		RowReport row1212 = createDAC1Row("1212", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##3]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B01]",
				"",
				"{[Channel].[21000], [Channel].[23000]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"");
		rowReportDao.save(row1212);
		RowReport row1213 = createDAC1Row("1213", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##3]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B01]",
				"",
				"{[Channel].[30000], [Channel].[31000], [Channel].[32000]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1213);
		RowReport row1214 = createDAC1Row("1214", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##3]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B01]",
				"",
				"[Channel].[51000]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1214);
		RowReport row1220 = createDAC1Row("1220", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B03]",
				"",
				"{[Channel].[21000], [Channel].[40000]}",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1220);
		RowReport row1230 = createDAC1Row("1230", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[B04]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]");
		rowReportDao.save(row1230);

		HashSet<String> sumRow1210 = new HashSet<String>();
		sumRow1210.add("1211");
		sumRow1210.add("1212");
		sumRow1210.add("1213");
		sumRow1210.add("1214");
		RowReport row1210 = createDAC1SumRow("1210", Constants.SUM, sumRow1210);
		rowReportDao.save(row1210);

		HashSet<String> sumRow1200 = new HashSet<String>();
		sumRow1200.add("1210");
		sumRow1200.add("1220");
		sumRow1200.add("1230");
		RowReport row1200 = createDAC1SumRow("1200", Constants.SUM, sumRow1200);
		rowReportDao.save(row1200);

		RowReport row1310 = createDAC1Row("1310", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[C01]",
				"[Investment].[Yes]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##210]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##210]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1310);
		RowReport row1311 = createDAC1Row("1311", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[C01]",
				"[Investment].[Yes]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1311);		
		RowReport row1320 = createDAC1Row("1320", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[C01]",
				"[Investment].[No]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]"
				);
		rowReportDao.save(row1320);

		RowReport row1330 = createDAC1Row("1330", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[C01]",
				"[PBA].[Yes]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1330);
		//TODO: Check 1301 amount: items 40 & 41
		RowReport row1301 = createDAC1RowExpert("1301", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[C01]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1301);		
		HashSet<String> sumRow1300 = new HashSet<String>();
		sumRow1300.add("1310");
		sumRow1300.add("1320");
		RowReport row1300 = createDAC1SumRow("1300", Constants.SUM, sumRow1300);
		rowReportDao.save(row1300);

		RowReport row1410 = createDAC1Row("1410", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[D01]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1410);		
		RowReport row1420 = createDAC1Row("1420", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[D02]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1420);		

		HashSet<String> sumRow1400 = new HashSet<String>();
		sumRow1400.add("1410");
		sumRow1400.add("1420");
		RowReport row1400 = createDAC1SumRow("1400", Constants.SUM, sumRow1400);
		rowReportDao.save(row1400);

		RowReport row1510 = createDAC1Row("1510", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[E01]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				""
				);
		rowReportDao.save(row1510);		
		RowReport row1520 = createDAC1Row("1520", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[E01]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				""
				);
		rowReportDao.save(row1520);
		
		HashSet<String> sumRow1500 = new HashSet<String>();
		sumRow1500.add("1510");
		sumRow1500.add("1520");
		RowReport row1500 = createDAC1SumRow("1500", Constants.SUM, sumRow1500);
		rowReportDao.save(row1500);

		//TODO: Check (not for	commit.),
		RowReport row1611 = createDAC1Row("1611", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"{[Sector].[60020], [Sector].[60040]}",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611]",
				"[Type of Finance].[TYPE_OF_FINANCE##621]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611]",
				"[Type of Finance].[TYPE_OF_FINANCE##621]"
				);
		rowReportDao.save(row1611);
		RowReport row1612 = createDAC1Row("1612", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"{[Sector].[60020], [Sector].[60040]}",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##616]",
				"[Type of Finance].[TYPE_OF_FINANCE##622],[Type of Finance].[TYPE_OF_FINANCE##623]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##616]",
				"[Type of Finance].[TYPE_OF_FINANCE##622],[Type of Finance].[TYPE_OF_FINANCE##623]"
				);
		rowReportDao.save(row1612);		
		RowReport row1613 = createDAC1Row("1613", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"{[Sector].[60020], [Sector].[60040]}",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##617]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##617]",
				""
				);
		rowReportDao.save(row1613);		
		RowReport row1614 = createDAC1Row("1614", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"[Sector].[60020]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617]",
				""
				);
		rowReportDao.save(row1614);		
		RowReport row1621 = createDAC1Row("1621", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"[Sector].[60030]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##618]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##618]",
				""
				);
		rowReportDao.save(row1621);		
		RowReport row1622 = createDAC1Row("1622", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"{[Sector].[60061], [Sector].[60062]}",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617],[Type of Finance].[TYPE_OF_FINANCE##618]",
				""
				);
		rowReportDao.save(row1622);		
		RowReport row1623 = createDAC1Row("1623", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"[Sector].[60063]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617],[Type of Finance].[TYPE_OF_FINANCE##618]",
				""
				);
		rowReportDao.save(row1623);		
		RowReport row1624 = createDAC1Row("1624", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"[Sector].[60010]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617],[Type of Finance].[TYPE_OF_FINANCE##618]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610],[Type of Finance].[TYPE_OF_FINANCE##611],[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##615],[Type of Finance].[TYPE_OF_FINANCE##616],[Type of Finance].[TYPE_OF_FINANCE##617],[Type of Finance].[TYPE_OF_FINANCE##618]",
				""
				);
		rowReportDao.save(row1624);		
		RowReport row1630 = createDAC1Row("1630", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"[Sector].[60020]",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##610]",
				"",
				""
				);
		rowReportDao.save(row1630);		
		RowReport row1640 = createDAC1Row("1640", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[F01]",
				"[Sector].[60020]",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##611]",
				"",
				""
				);
		rowReportDao.save(row1640);		

		HashSet<String> sumRow1610 = new HashSet<String>();
		sumRow1610.add("1611");
		sumRow1610.add("1612");
		sumRow1610.add("1613");
		RowReport row1610 = createDAC1SumRow("1610", Constants.SUM, sumRow1610);
		rowReportDao.save(row1610);

		HashSet<String> sumRow1620 = new HashSet<String>();
		sumRow1620.add("1621");
		sumRow1620.add("1622");
		sumRow1620.add("1623");
		sumRow1620.add("1624");
		RowReport row1620 = createDAC1SumRow("1620", Constants.SUM, sumRow1620);
		rowReportDao.save(row1620);
		
		HashSet<String> sumRow1600 = new HashSet<String>();
		sumRow1600.add("1610");
		sumRow1600.add("1620");
		RowReport row1600 = createDAC1SumRow("1600", Constants.SUM, sumRow1600);
		rowReportDao.save(row1600);
		
		RowReport row1700 = createDAC1Row("1700", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[G01]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				""
				);
		rowReportDao.save(row1700);		
		RowReport row1810 = createDAC1Row("1810", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[H01]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				""
				);
		rowReportDao.save(row1810);		
		RowReport row1820 = createDAC1Row("1820", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[H01]",
				"[Sector].[93010]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				""
				);
		rowReportDao.save(row1820);

		HashSet<String> sumRow1800 = new HashSet<String>();
		sumRow1800.add("1810");
		sumRow1800.add("1820");
		RowReport row1800 = createDAC1SumRow("1800", Constants.SUM, sumRow1800);
		rowReportDao.save(row1800);
		
		RowReport row1900 = createDAC1Row("1900", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##210]",
				"[Type of Finance].[TYPE_OF_FINANCE##110],[Type of Finance].[TYPE_OF_FINANCE##210]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]"
				);
		rowReportDao.save(row1900);		
		RowReport row1999 = createDAC1Row("1999", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"",
				""
				);
		rowReportDao.save(row1999);		
		RowReport row1901 = createDAC1Row("1901", Constants.CALCULATED,
				"{[BiMultilateral].[BI_MULTILATERAL##1], [BiMultilateral].[BI_MULTILATERAL##3]}",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[PBA].[Yes]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1901);		
		RowReport row1902 = createDAC1Row("1902", Constants.CALCULATED,
				"{[BiMultilateral].[BI_MULTILATERAL##1], [BiMultilateral].[BI_MULTILATERAL##3]}",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"Except([Type of Aid].[Code].Members, [Type of Aid].[G01])",
				"[FTC].[Yes]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1902);		
		RowReport row1903 = createDAC1Row("1903", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"Except([Type of Aid].[Code].Members, [Type of Aid].[B01])",
				"",
				"[Channel].[20000]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]"
				);
		rowReportDao.save(row1903);		
		RowReport row1904 = createDAC1Row("1904", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"Except([Type of Aid].[Code].Members, [Type of Aid].[B02])",
				"",
				"[Channel].[40000]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##410]"
				);
		rowReportDao.save(row1904);		
		RowReport row1905 = createDAC1Row("1905", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"[Type of Aid].[C01]",
				"[Sector].[15230]",
				"[Channel].[40000]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1905);		
		RowReport row1906 = createDAC1Row("1906", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"",
				"[Sector].[72040]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511],[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row1906);

		HashSet<String> sumRow1015 = new HashSet<String>();
		sumRow1015.add("1100");
		sumRow1015.add("1200");
		sumRow1015.add("1300");
		sumRow1015.add("1400");
		sumRow1015.add("1500");
		sumRow1015.add("1600");
		sumRow1015.add("1700");
		sumRow1015.add("1800");
		RowReport row1015 = createDAC1SumRow("1015", Constants.SUM, sumRow1015);
		rowReportDao.save(row1015);
	}


	private void insertSectionII() {
		insertSectionIIA();
		insertSectionIIB();
		
		HashSet<String> sumRow230 = new HashSet<String>();
		sumRow230.add("240");
		sumRow230.add("325");
		RowReport row230 = createDAC1SumRow("230", Constants.SUM, sumRow230);
		rowReportDao.save(row230);

	}
	private void insertSectionIIB() {
		RowReport row326 = createDAC1Row("326", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##912]",
				"[Type of Finance].[TYPE_OF_FINANCE##912]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##912]"
				);
		rowReportDao.save(row326);	
		RowReport row327 = createDAC1Row("327", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##412]",
				"[Type of Finance].[TYPE_OF_FINANCE##412]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##412]"
				);
		rowReportDao.save(row327);	
/*		RowReport row800 = createDAC1Row("800", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"",
				"[Type of Finance].Members",
				"",
				""
				);
		rowReportDao.save(row800);	*/
/*		RowReport row805 = createDAC1Row("805", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"",
				"[Type of Finance].Members",
				"",
				""
				);
		rowReportDao.save(row805);	*/
		RowReport row786 = createDAC1Row("786", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##613],[Type of Finance].[TYPE_OF_FINANCE##631]",
				"",
				""
				);
		rowReportDao.save(row786);
		
		HashSet<String> sumRow325 = new HashSet<String>();
		sumRow325.add("326");
		sumRow325.add("327");
		RowReport row325 = createDAC1SumRow("325", Constants.SUM, sumRow325);
		rowReportDao.save(row325);		
	}

	private void insertSectionIIA() {
		RowReport row265 = createDAC1Row("265", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##451],[Type of Finance].[TYPE_OF_FINANCE##452],[Type of Finance].[TYPE_OF_FINANCE##453]",
				"[Type of Finance].[TYPE_OF_FINANCE##451],[Type of Finance].[TYPE_OF_FINANCE##452],[Type of Finance].[TYPE_OF_FINANCE##453]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##451],[Type of Finance].[TYPE_OF_FINANCE##452],[Type of Finance].[TYPE_OF_FINANCE##453]"
				);
		rowReportDao.save(row265);	
		RowReport row266 = createDAC1Row("266", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##211]",
				"[Type of Finance].[TYPE_OF_FINANCE##414]",
				"[Type of Finance].[TYPE_OF_FINANCE##414]",
				"[Type of Finance].[TYPE_OF_FINANCE##211]",
				"[Type of Finance].[TYPE_OF_FINANCE##414]"
				);
		rowReportDao.save(row266);	
		HashSet<String> sumRow240 = new HashSet<String>();
		sumRow240.add("265");
		sumRow240.add("266");
		RowReport row240 = createDAC1SumRow("240", Constants.SUM, sumRow240);
		rowReportDao.save(row240);
		
		
		RowReport row291 = createDAC1Row("291", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##411],[Type of Finance].[TYPE_OF_FINANCE##412],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511]",
				"[Type of Finance].[TYPE_OF_FINANCE##411],[Type of Finance].[TYPE_OF_FINANCE##412],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##411],[Type of Finance].[TYPE_OF_FINANCE##412],[Type of Finance].[TYPE_OF_FINANCE##510],[Type of Finance].[TYPE_OF_FINANCE##511]"
				);
		rowReportDao.save(row291);		
		RowReport row292 = createDAC1Row("292", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##412],[Type of Finance].[TYPE_OF_FINANCE##510]",
				"[Type of Finance].[TYPE_OF_FINANCE##412],[Type of Finance].[TYPE_OF_FINANCE##510]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##412],[Type of Finance].[TYPE_OF_FINANCE##510]"
				);
		rowReportDao.save(row292);		
		RowReport row293 = createDAC1Row("293", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##412]",
				"[Type of Finance].[TYPE_OF_FINANCE##412]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##412]"
				);
		rowReportDao.save(row293);		
		RowReport row280 = createDAC1Row("280", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510]",
				"[Type of Finance].[TYPE_OF_FINANCE##510]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##510]"
				);
		rowReportDao.save(row280);		
		RowReport row287 = createDAC1Row("287", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##111]",
				"[Type of Finance].[TYPE_OF_FINANCE##413]",
				"[Type of Finance].[TYPE_OF_FINANCE##413]",
				"[Type of Finance].[TYPE_OF_FINANCE##111]",
				"[Type of Finance].[TYPE_OF_FINANCE##413]"
				);
		rowReportDao.save(row287);	

		HashSet<String> sumRow294 = new HashSet<String>();
		sumRow294.add("291");
		sumRow294.add("287");
		RowReport row294 = createDAC1SumRow("294", Constants.SUM, sumRow294);
		rowReportDao.save(row294);
		
		RowReport row302 = createDAC1Row("302", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"[Channel].[60040]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##623]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##623]"
				);
		rowReportDao.save(row302);	
		RowReport row310 = createDAC1Row("310", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"[Channel].[60040]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##624],[Type of Finance].[TYPE_OF_FINANCE##625]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##624],[Type of Finance].[TYPE_OF_FINANCE##625]"
				);
		rowReportDao.save(row310);	
		RowReport row303 = createDAC1Row("303", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"[Channel].[60040]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##626],[Type of Finance].[TYPE_OF_FINANCE##627]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##626],[Type of Finance].[TYPE_OF_FINANCE##627]"
				);
		rowReportDao.save(row303);	

		HashSet<String> sumRow300 = new HashSet<String>();
		sumRow300.add("301");
		sumRow300.add("303");
		RowReport row300 = createDAC1SumRow("300", Constants.SUM, sumRow300);
		rowReportDao.save(row300);
		
		RowReport row299 = createDAC1Row("299", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"[Channel].[60040]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##512]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##512]"
				);
		rowReportDao.save(row299);	
		RowReport row298 = createDAC1Row("298", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##20]",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##910],[Type of Finance].[TYPE_OF_FINANCE##911]",
				"[Type of Finance].[TYPE_OF_FINANCE##910],[Type of Finance].[TYPE_OF_FINANCE##911]",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"[Type of Finance].[TYPE_OF_FINANCE##910],[Type of Finance].[TYPE_OF_FINANCE##911]"
				);
		rowReportDao.save(row298);	
		//TODO: Empty?
/*		RowReport row102 = createDAC1Row("102", Constants.CALCULATED,
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##612],[Type of Finance].[TYPE_OF_FINANCE##622],[Type of Finance].[TYPE_OF_FINANCE##630]",
				"",
				""
				);
		rowReportDao.save(row102);	*/
		HashSet<String> sumRow295 = new HashSet<String>();
		sumRow295.add("299");
		sumRow295.add("298");
		RowReport row295 = createDAC1SumRow("295", Constants.SUM, sumRow295);
		rowReportDao.save(row295);

		HashSet<String> sumRow235 = new HashSet<String>();
		sumRow235.add("240");
		sumRow235.add("294");
		sumRow235.add("300");
		sumRow235.add("295");
		RowReport row235 = createDAC1SumRow("235", Constants.SUM, sumRow235);
		rowReportDao.save(row235);
		
		}

	private void insertSectionIII() {
		RowReport row340 = createDAC1Row("340", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##710],[Type of Finance].[TYPE_OF_FINANCE##711]",
				"[Type of Finance].[TYPE_OF_FINANCE##710],[Type of Finance].[TYPE_OF_FINANCE##711]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##710],[Type of Finance].[TYPE_OF_FINANCE##711]"
				);
		rowReportDao.save(row340);	
		RowReport row345 = createDAC1Row("345", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##710]",
				"[Type of Finance].[TYPE_OF_FINANCE##710]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##710]"
				);
		rowReportDao.save(row345);	
		RowReport row751 = createDAC1Row("751", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##810]",
				"[Type of Finance].[TYPE_OF_FINANCE##810]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##810]"
				);
		rowReportDao.save(row751);	
		RowReport row752 = createDAC1Row("752", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##453]",
				"[Type of Finance].[TYPE_OF_FINANCE##453]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##453]"
				);
		rowReportDao.save(row752);	
		RowReport row753 = createDAC1Row("753", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##910]",
				"[Type of Finance].[TYPE_OF_FINANCE##910]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##910]"
				);
		rowReportDao.save(row753);	

		HashSet<String> sumRow384 = new HashSet<String>();
		sumRow384.add("751");
		sumRow384.add("752");
		sumRow384.add("753");
		RowReport row384 = createDAC1SumRow("384", Constants.SUM, sumRow384);
		rowReportDao.save(row384);

		RowReport row756 = createDAC1Row("756", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##451]",
				"[Type of Finance].[TYPE_OF_FINANCE##451]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##451]"
				);
		rowReportDao.save(row756);	
		RowReport row761 = createDAC1Row("761", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##452]",
				"[Type of Finance].[TYPE_OF_FINANCE##452]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##452]"
				);
		rowReportDao.save(row761);	
		RowReport row388 = createDAC1Row("388", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##811]",
				"[Type of Finance].[TYPE_OF_FINANCE##811]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##811]"
				);
		rowReportDao.save(row388);	
		RowReport row389 = createDAC1Row("389", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##911]",
				"[Type of Finance].[TYPE_OF_FINANCE##911]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##911]"
				);
		rowReportDao.save(row389);	

		HashSet<String> sumRow386 = new HashSet<String>();
		sumRow386.add("756");
		sumRow386.add("761");
		sumRow386.add("388");
		sumRow386.add("389");
		RowReport row386 = createDAC1SumRow("386", Constants.SUM, sumRow386);
		rowReportDao.save(row386);
		
		HashSet<String> sumRow353 = new HashSet<String>();
		sumRow353.add("384");
		sumRow353.add("386");
		RowReport row353 = createDAC1SumRow("353", Constants.SUM, sumRow353);
		rowReportDao.save(row353);
		
		RowReport row103 = createDAC1Row("103", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"{[Type of Flow].[TYPE_OF_FLOW##10],[Type of Flow].[TYPE_OF_FLOW##20],[Type of Flow].[TYPE_OF_FLOW##35]}",
				"",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##614],[Type of Finance].[TYPE_OF_FINANCE##624],[Type of Finance].[TYPE_OF_FINANCE##632]",
				"",
				""
				);
		rowReportDao.save(row103);
		
		HashSet<String> sumRow332 = new HashSet<String>();
		sumRow332.add("340");
		sumRow332.add("353");
		sumRow332.add("103");
		RowReport row332 = createDAC1SumRow("332", Constants.SUM, sumRow332);
		rowReportDao.save(row332);
		
		RowReport row359 = createDAC1Row("359", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##2]",
				"[Type of Flow].[TYPE_OF_FLOW##35]",
				"",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##912]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##912]"
				);
		rowReportDao.save(row359);	
		
		HashSet<String> sumRow330 = new HashSet<String>();
		sumRow330.add("332");
		sumRow330.add("359");
		RowReport row330 = createDAC1SumRow("330", Constants.SUM, sumRow330);
		rowReportDao.save(row330);
	}

	private void insertSectionIV() {
		RowReport row425 = createDAC1Row("425", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##1]",
				"[Type of Flow].[TYPE_OF_FLOW##30]",
				"",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				""
				);
		rowReportDao.save(row425);
		//TODO: excluding foreign NGOs
		RowReport row420 = createDAC1Row("420", Constants.CALCULATED,
				"[BiMultilateral].[BI_MULTILATERAL##3]",
				"[Type of Flow].[TYPE_OF_FLOW##10]",
				"",
				"",
				"[Channel].[22000]",
				"",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##110]",
				"",
				""
				);
		rowReportDao.save(row420);
		
		HashSet<String> sumRow415 = new HashSet<String>();
		sumRow415.add("425");
		sumRow415.add("420");
		RowReport row415 = createDAC1SumRow("415", Constants.SUM, sumRow415);
		rowReportDao.save(row415);
	}
	private void insertSectionV() {
		RowReport row207 = createDAC1Row("207", Constants.CALCULATED,
				"{[BiMultilateral].[BI_MULTILATERAL##1],[BiMultilateral].[BI_MULTILATERAL##2]}",
				"{[Type of Flow].[TYPE_OF_FLOW##10],[Type of Flow].[TYPE_OF_FLOW##50]}",
				"",
				"[Sector].[15230]",
				"",
				"[Type of Finance].[TYPE_OF_FINANCE##100]",
				"[Type of Finance].[TYPE_OF_FINANCE##400]",
				"[Type of Finance].[TYPE_OF_FINANCE##400]",
				"[Type of Finance].[TYPE_OF_FINANCE##100]",
				"[Type of Finance].[TYPE_OF_FINANCE##400]"
				);
		rowReportDao.save(row207);
	}

	@Override
	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFileOpener(ResourceAccessor resourceAccessor) {
		// TODO Auto-generated method stub

	}

	@Override
	public ValidationErrors validate(Database database) {
		// TODO Auto-generated method stub
		return null;
	}

	public RowReport createDAC1Row(String name, int type, String biMulti,
			String typeOfFlow, String typeOfAid, String purposeCode,
			String channel, String col1121tof, String col1122tof,
			String col1130tof, String col1151tof, String col1152tof) {
		RowReport row = new RowReport("DAC1", name, type);

		Set<String> categories = new HashSet<String>();
		if (biMulti != null)
			categories.add(biMulti);
		if (typeOfFlow != null)
			categories.add(typeOfFlow);
		if (typeOfAid != null)
			categories.add(typeOfAid);
		if (purposeCode != null)
			categories.add(purposeCode);
		if (channel != null)
			categories.add(channel);
		row.setCategories(categories);

		Set<ColumnReport> columns = new HashSet<ColumnReport>();
		
		HashSet<String> sumCols1120 = new HashSet<String>();
		if(col1121tof != null && !col1121tof.equals("")) {
			ColumnReport col1 = new ColumnReport("1121", Constants.CALCULATED,
					"[Measures].[E]", col1121tof);
			columns.add(col1);
			sumCols1120.add(col1.getColumnCode());
		} else {
			ColumnReport col1 = new ColumnReport("1121", Constants.EMPTY, null);
			columns.add(col1);
		}

		if(col1122tof != null && !col1122tof.equals("")) {
			ColumnReport col2 = new ColumnReport("1122", Constants.CALCULATED,
					"[Measures].[E]", col1122tof);
			columns.add(col2);
			sumCols1120.add(col2.getColumnCode());
		} else {
			ColumnReport col2 = new ColumnReport("1122", Constants.EMPTY, null);
			columns.add(col2);
		}
		

		ColumnReport col3 = new ColumnReport("1120", Constants.SUM, sumCols1120);
		columns.add(col3);
		
		HashSet<String> sumCols1140 = new HashSet<String>();
		sumCols1140.addAll(sumCols1120);

		if(col1130tof != null && !col1130tof.equals("")) {
			ColumnReport col4 = new ColumnReport("1130", Constants.CALCULATED,
					"[Measures].[R]", col1130tof);
			col4.setMultiplier(-1);
			columns.add(col4);
			sumCols1140.add(col4.getColumnCode());
		} else {
			ColumnReport col4 = new ColumnReport("1130", Constants.EMPTY, null);
			columns.add(col4);
		}

		ColumnReport col5 = new ColumnReport("1140", Constants.SUM, sumCols1140);
		columns.add(col5);

		HashSet<String> sumCols1150 = new HashSet<String>();
		if(col1151tof != null && !col1151tof.equals("")) {
			ColumnReport col6 = new ColumnReport("1151", Constants.CALCULATED,
					"[Measures].[C]", col1151tof);
			columns.add(col6);
			sumCols1150.add(col6.getColumnCode());
		} else {
			ColumnReport col6 = new ColumnReport("1151", Constants.EMPTY, null);
			columns.add(col6);
		}

		if(col1152tof != null && !col1152tof.equals("")) {
			ColumnReport col7 = new ColumnReport("1152", Constants.CALCULATED,
					"[Measures].[C]", col1152tof);
			columns.add(col7);
			sumCols1150.add(col7.getColumnCode());
		} else {
			ColumnReport col7 = new ColumnReport("1152", Constants.EMPTY, null);
			columns.add(col7);
		}

		ColumnReport col8 = new ColumnReport("1150", Constants.SUM, sumCols1150);
		columns.add(col8);

		row.setColumns(columns);
		return row;

	}
	public RowReport createDAC1RowExpert(String name, int type, String biMulti,
			String typeOfFlow, String typeOfAid, String purposeCode,
			String channel, String col1121tof, String col1122tof,
			String col1130tof, String col1151tof, String col1152tof) {
		RowReport row = new RowReport("DAC1", name, type);

		Set<String> categories = new HashSet<String>();
		if (biMulti != null)
			categories.add(biMulti);
		if (typeOfFlow != null)
			categories.add(typeOfFlow);
		if (typeOfAid != null)
			categories.add(typeOfAid);
		if (purposeCode != null)
			categories.add(purposeCode);
		if (channel != null)
			categories.add(channel);
		row.setCategories(categories);

		Set<ColumnReport> columns = new HashSet<ColumnReport>();
		
		HashSet<String> sumCols1120 = new HashSet<String>();
		if(col1121tof != null && !col1121tof.equals("")) {
			ColumnReport col1 = new ColumnReport("1121", Constants.CALCULATED,
					"[Measures].[EE]", col1121tof);
			columns.add(col1);
			sumCols1120.add(col1.getColumnCode());
		}

		if(col1122tof != null && !col1122tof.equals("")) {
			ColumnReport col2 = new ColumnReport("1122", Constants.CALCULATED,
					"[Measures].[EE]", col1122tof);
			columns.add(col2);
			sumCols1120.add(col2.getColumnCode());
		}

		ColumnReport col3 = new ColumnReport("1120", Constants.SUM, sumCols1120);
		columns.add(col3);
		
		HashSet<String> sumCols1140 = new HashSet<String>();
		sumCols1140.addAll(sumCols1120);

		if(col1130tof != null && !col1130tof.equals("")) {
			ColumnReport col4 = new ColumnReport("1130", Constants.CALCULATED,
					"[Measures].[R]", col1130tof);
			col4.setMultiplier(-1);
			columns.add(col4);
			sumCols1140.add(col4.getColumnCode());
		}

		ColumnReport col5 = new ColumnReport("1140", Constants.SUM, sumCols1140);
		columns.add(col5);

		HashSet<String> sumCols1150 = new HashSet<String>();
		if(col1151tof != null && !col1151tof.equals("")) {
			ColumnReport col6 = new ColumnReport("1151", Constants.CALCULATED,
					"[Measures].[EC]", col1151tof);
			columns.add(col6);
			sumCols1150.add(col6.getColumnCode());
		}

		if(col1152tof != null && !col1152tof.equals("")) {
			ColumnReport col7 = new ColumnReport("1152", Constants.CALCULATED,
					"[Measures].[EC]", col1152tof);
			columns.add(col7);
			sumCols1150.add(col7.getColumnCode());
		}

		ColumnReport col8 = new ColumnReport("1150", Constants.SUM, sumCols1150);
		columns.add(col8);

		row.setColumns(columns);
		return row;

	}

	public RowReport createDAC1SumRow(String name, int type,
			HashSet<String> rowCodes) {
		RowReport row = new RowReport("DAC1", name, type, rowCodes);
		return row;
	}
}