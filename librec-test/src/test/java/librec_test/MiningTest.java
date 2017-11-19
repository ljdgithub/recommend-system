package librec_test;

import java.io.FileOutputStream;
import java.io.PrintStream;

import common.PropertiesUtils;
import net.librec.conf.Configuration;
import net.librec.data.model.TextDataModel;
import net.librec.math.algorithm.Randoms;
import patternMining.NeighborMining;

public class MiningTest {
	public static final String PATHDIR = "C:\\Users\\ljd\\Desktop\\论文相关--开题报告--梁继东\\testout\\";

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("dfs.data.dir", PropertiesUtils.mainDir);
		conf.set("data.input.path", "trainData");
		conf.set("data.model.splitter", "testset");
		// 预留的测试数据集应该在训练数据集的路径之下
		conf.set("data.testset.path", "trainData/testData");
		conf.set("data.model.format", "text");
		conf.set("data.column.format", "UIRT");
		conf.set("data.convert.binarize.threshold", "-1.0");
		Randoms.seed(1);
		TextDataModel dataModel = new TextDataModel(conf);
		dataModel.buildDataModel();
		NeighborMining nm = new NeighborMining(dataModel);
		System.setOut(
				new PrintStream(new FileOutputStream("C:\\Users\\ljd\\Desktop\\论文相关--开题报告--梁继东\\testout\\out1.txt")));
		nm.command();

	}
}
