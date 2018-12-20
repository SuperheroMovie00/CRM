package com.ysd.util;

import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 导出Excel工具类
 * 
 * @author MS 依赖两个jar包 commons-lang3-3.5.jar jxl-2.6.12.jar
 * 
 */
public class ExportExcel {
	/***************************************************************************
	 * @param fileName
	 *            EXCEL文件名称
	 * @param listTitle
	 *            EXCEL文件第一行列标题集合
	 * @param menus
	 *            EXCEL文件正文数据集合
	 * @return
	 */
	public final static String exportExcel(HttpServletResponse response,
			String fileName, String[] Title, List<?> cusList) {
		String result = "系统提 示：Excel文件导出成功！";
		fileName = fileName + ".xls";

		// 以下开始输出到EXCEL
		try {
			// 定义输出流，以便打开保存对话框______________________begin
			OutputStream os = response.getOutputStream();// 取得输出流
			response.reset();// 清空输出流
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(fileName.getBytes("GB2312"), "ISO8859-1"));
			// 设定输出文件头
			response.setContentType("application/msexcel");// 定义输出类型
			// 定义输出流，以便打开保存对话框_______________________end

			/** **********创建工作簿************ */
			WritableWorkbook workbook = Workbook.createWorkbook(os);

			/** **********创建工作表************ */

			WritableSheet sheet = workbook.createSheet("Sheet1", 0);

			/** **********设置纵横打印（默认为纵打）、打印纸***************** */
			jxl.SheetSettings sheetset = sheet.getSettings();
			sheetset.setProtected(false);

			/** ************设置单元格字体************** */
			WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
			WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.BOLD);

			/** ************以下设置三种单元格样式，灵活备用************ */
			// 用于标题居中
			WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
			wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
			wcf_center.setWrap(false); // 文字是否换行

			// 用于正文居左
			WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
			wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
			wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_left.setAlignment(Alignment.CENTRE); // 文字水平对齐
			wcf_left.setWrap(false); // 文字是否换行

			CellView navCellView = new CellView();
			navCellView.setAutosize(true); // 设置自动大小
			navCellView.setSize(30);

			int i = 1, g = 0;
			if (StringUtils.isNotEmpty(fileName)) {
				/** ***************以下是EXCEL开头大标题，暂时省略********************* */
				sheet.mergeCells(0, 0, Title.length - 1, 0);
				sheet.addCell(new Label(0, 0, fileName, wcf_center));
				i = 2;
				g = 1;
			}

			/** ***************以下是EXCEL第一行列标题********************* */
			for (int d = 0; d < Title.length; d++) {
				sheet.setColumnView(d, 15);
				sheet.setRowView(g, 400, false); // 设置行高
				sheet.addCell(new Label(d, g, Title[d], wcf_center));
			}
			/** ***************以下是EXCEL正文数据********************* */
			Field[] fields = null;
			if (cusList != null && cusList.size() > 0) {
				for (Object obj : cusList) {
					fields = obj.getClass().getDeclaredFields();
					int j = 0;
					for (Field v : fields) {
						v.setAccessible(true);
						Object va = v.get(obj);
						if (va == null) {
							va = "";
						}
						sheet.setColumnView(i, 15);
						sheet.setRowView(i, 400, false); // 设置行高
						sheet.addCell(new Label(j, i, va.toString(), wcf_left));
						j++;
					}
					i++;
				}
			}

			/** **********将以上缓存中的内容写到EXCEL文件中******** */
			workbook.write();
			/** *********关闭文件************* */
			workbook.close();

		} catch (Exception e) {
			result = "系统提示：Excel文件导出失败，原因：" + e.toString();
			System.out.println(result);
			e.printStackTrace();
		}
		return result;
	}

}
