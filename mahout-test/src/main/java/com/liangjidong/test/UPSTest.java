package com.liangjidong.test;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.liangjidong.similarity.UPSSimiliarity;

/**
 * 测试UPS相似度计算方法的正确性------结论：样例测试数据结果正确
 * 
 * @author ljd
 *
 */
public class UPSTest {
	public static void main(String[] args) throws IOException, TasteException {
		String projectDir = System.getProperty("user.dir");
		DataModel model = new FileDataModel(new File(projectDir + "/src/main/ups.csv"));
		UserSimilarity similarity = new UPSSimiliarity(model);
		DecimalFormat df = new DecimalFormat("#,##0.0000");// 保留4位小数
		System.out.println(df.format(similarity.userSimilarity(1, 2)));
		System.out.println(df.format(similarity.userSimilarity(1, 3)));
		System.out.println(df.format(similarity.userSimilarity(1, 4)));
		System.out.println(df.format(similarity.userSimilarity(1, 5)));
		System.out.println(df.format(similarity.userSimilarity(2, 3)));
		System.out.println(df.format(similarity.userSimilarity(2, 4)));
		System.out.println(df.format(similarity.userSimilarity(2, 5)));
		System.out.println(df.format(similarity.userSimilarity(3, 4)));
		System.out.println(df.format(similarity.userSimilarity(3, 5)));
		System.out.println(df.format(similarity.userSimilarity(4, 5)));
	}
}
