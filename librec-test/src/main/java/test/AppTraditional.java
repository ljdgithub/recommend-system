package test;

import common.PropertiesUtils;
import common.RecommendTestUtils;
import net.librec.conf.Configuration;
import net.librec.data.model.TextDataModel;
import net.librec.math.algorithm.Randoms;
import net.librec.recommender.RecommenderContext;
import net.librec.similarity.PCCSimilarity;
import net.librec.similarity.RecommenderSimilarity;

public class AppTraditional {
    public static void main(String[] args) throws Exception {
        String dirName = "Data_EXTRACT";
        Configuration conf = new Configuration();
        //对于classpath，需要先截取，然后才能使用
        conf.set("dfs.data.dir", PropertiesUtils.resourcesDir);
        conf.set("data.input.path", dirName);
        conf.set("data.model.splitter", "testset");
        // 预留的测试数据集应该在训练数据集的路径之下
        conf.set("data.testset.path", dirName + "/testData");
        conf.set("data.model.format", "text");
        conf.set("data.column.format", "UIRT");
        conf.set("data.convert.binarize.threshold", "-1.0");
        Randoms.seed(1);
        TextDataModel dataModel = new TextDataModel(conf);
        dataModel.buildDataModel();

        RecommenderContext context = new RecommenderContext(conf, dataModel);

        conf.set("rec.recommender.similarity.key", "user");
        RecommenderSimilarity similarity = new PCCSimilarity();
//		RecommenderSimilarity similarity = new CosineSimilarity();
        // RecommenderSimilarity similarity = new JaccardSimilarity();
        // RecommenderSimilarity similarity = new UPSSimilarity();
        similarity.buildSimilarityMatrix(dataModel);
        context.setSimilarity(similarity);

        RecommendTestUtils.testMAE(conf, context, "5");
        RecommendTestUtils.testMAE(conf, context, "10");
        RecommendTestUtils.testMAE(conf, context, "15");
        RecommendTestUtils.testMAE(conf, context, "20");
        RecommendTestUtils.testMAE(conf, context, "25");
        RecommendTestUtils.testMAE(conf, context, "30");
        RecommendTestUtils.testMAE(conf, context, "35");
        RecommendTestUtils.testMAE(conf, context, "40");
        RecommendTestUtils.testMAE(conf, context, "45");
        RecommendTestUtils.testMAE(conf, context, "50");
    }
}
