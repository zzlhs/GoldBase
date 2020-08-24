package com.zzl.es.client;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.lucene.queryparser.xml.builders.BooleanQueryBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * EleasticSearch查询的测试
 * @author zyf
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchTest {
	
	HttpHost[] hosts = {new HttpHost("127.0.0.1", 9200)};
	private RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(hosts));
	
	/**
	 * DSL 查询
	 */
	@Test
	public void searchAll() {
		try {
			SearchRequest searchRequest = new SearchRequest("zzl_08232");
			searchRequest.types("doc");
			
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			
			// 分页查询开始-------------------------------------
			// 分页查询 设置起始下标 从0开始
			searchSourceBuilder.from(1);
			
			// 每页显示个数 10
			searchSourceBuilder.size(1);
			// 分页查询结束-------------------------------------

			searchSourceBuilder.fetchSource(new String[] {"name", "studymodel"}, new String[] {});
			searchRequest.source(searchSourceBuilder);
		
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			System.out.println("------------- 结果 ------------------------------");
			for(SearchHit hit: searchHits) {
//				String index = hit.getIndex();
//				String type = hit.getType();
//				String id = hit.getId();
//				float score = hit.getScore();
				String sourceAsString = hit.getSourceAsString();
//				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				System.out.println(sourceAsString);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Term Query为精确查询，在搜索时会整体匹配关键字，不再将关键字分词
	 */
	@Test
	public void termQuery() {
		try {
			SearchRequest searchRequest = new SearchRequest("zzl_08232");
			searchRequest.types("doc");
			
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			
			searchSourceBuilder.fetchSource(new String[] {"name", "studymodel"}, new String[] {});
			
			// 第一次测试
//			----------------------------------------------------------------------
//			searchSourceBuilder.query(QueryBuilders.termsQuery("name", "spring"));  // 名字中包含spring的
			
			// id 精确测试
//			----------------------------------------------------------------------
			String[] split = new String[] {"K0P-G3QBc8JTtJwfSkh2", "2"}; // id精确匹配 
			searchSourceBuilder.query(QueryBuilders.termsQuery("_id", split));

			searchRequest.source(searchSourceBuilder);
			
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
			
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			System.out.println(searchHits.length);
			for(SearchHit hit: searchHits) {
//				String index = hit.getIndex();
//				String type = hit.getType();
//				String id = hit.getId();
//				float score = hit.getScore();
				String sourceAsString = hit.getSourceAsString();
//				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				System.out.println(sourceAsString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * match Query即全文检索，它的搜索方式是先将搜索字符串分词，再使用各各词条从索引中搜索。
	 * match query与Term query区别是match query在搜索前先将搜索关键字分词，再拿各各词语去索引中搜索。 
	 */
	@Test
	public void matchQuery() {
		try {
			SearchRequest searchRequest = new SearchRequest("zzl_08232");
			searchRequest.types("doc");
			
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			
			searchSourceBuilder.fetchSource(new String[] {"name", "studymodel"}, new String[] {});
			
			
//			match Query 第一部分 基本使用
//			-----------------------------------------------------------------------------
			// 匹配关键字
//			searchSourceBuilder.query(QueryBuilders.matchQuery("name", "修改")
//												   .operator(Operator.OR));
			
			
//			match Query 第二部分 minimum_should_match的使用 
//			-----------------------------------------------------------------------------
//			searchSourceBuilder.query(QueryBuilders.matchQuery("name", "cloud实战修改")
//					   .minimumShouldMatch("100%"));
			
			
			/**
			 * multi Query 
			 * termQuery和matchQuery一次只能匹配一个Field，学习multiQuery，一次可以匹配多个字段。 
			 */
//			multi Query 第一部分
//			-----------------------------------------------------------------------------

			
			MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("spring", "name","description")
					.minimumShouldMatch("80%"); // 至少匹配一个
			
			multiMatchQueryBuilder.field("name", 10); // name提升10倍
			searchSourceBuilder.query(multiMatchQueryBuilder);
			
			
			// 分页查询开始-------------------------------------
			// 分页查询 设置起始下标 从0开始
//			searchSourceBuilder.from(0);
			
			// 每页显示个数 10
//			searchSourceBuilder.size(10);
			// 分页查询结束-------------------------------------

			
			searchRequest.source(searchSourceBuilder);
		
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			System.out.println(searchHits.length);
			for(SearchHit hit: searchHits) {
				String sourceAsString = hit.getSourceAsString();
				System.out.println(sourceAsString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 布尔查询对应于Lucene的BooleanQuery查询，实现将多个查询组合起来。
	   三个参数：
		must：文档必须匹配must所包括的查询条件，相当于 “AND” 
		should：文档应该匹配should所包括的查询条件其 中的一个或多个，相当于 "OR" 
		must_not：文档不能匹配must_not所包括的该查询条件，相当于“NOT” 
	 */
	@Test
	public void boolQuery() {
		try {
			SearchRequest searchRequest = new SearchRequest("zzl_08232");
			searchRequest.types("doc");
			
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.fetchSource(new String[] {"name", "studymodel"}, new String[] {});
			
			/**
			 * multi Query 
			 * termQuery和matchQuery一次只能匹配一个Field，学习multiQuery，一次可以匹配多个字段。 
			 */
//			multi Query 第一部分
//			-----------------------------------------------------------------------------

			
			MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("spring", "name","description")
					.minimumShouldMatch("80%"); // 至少匹配一个
			
			multiMatchQueryBuilder.field("name", 10); // name提升10倍
			
			
			// term Query
			TermsQueryBuilder termQueryBuilder = QueryBuilders.termsQuery("_id", new String[] {"K0P-G3QBc8JTtJwfSkh2", "2"});
			
			
			//
			BoolQueryBuilder booleanQueryBuilder = QueryBuilders.boolQuery();
			booleanQueryBuilder.must(multiMatchQueryBuilder);
			booleanQueryBuilder.must(termQueryBuilder);
			
			searchSourceBuilder.query(booleanQueryBuilder);
			// 分页查询开始-------------------------------------
			// 分页查询 设置起始下标 从0开始
//			searchSourceBuilder.from(0);
			
			// 每页显示个数 10
//			searchSourceBuilder.size(10);
			// 分页查询结束-------------------------------------

			
			searchRequest.source(searchSourceBuilder);
		
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			System.out.println(searchHits.length);
			for(SearchHit hit: searchHits) {
				String sourceAsString = hit.getSourceAsString();
				System.out.println(sourceAsString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void filterQuery() {
		try {
			SearchRequest searchRequest = new SearchRequest("zzl_08232");
			searchRequest.types("doc");
			
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.fetchSource(new String[] {"name", "studymodel"}, new String[] {});
			

			MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("spring", "name","description")
					.minimumShouldMatch("80%"); // 至少匹配一个
			multiMatchQueryBuilder.field("name", 10); // name提升10倍
			searchSourceBuilder.query(multiMatchQueryBuilder);
			
			BoolQueryBuilder booleanQueryBuilder = QueryBuilders.boolQuery();
			booleanQueryBuilder.must(searchSourceBuilder.query());
			booleanQueryBuilder.filter(QueryBuilders.termQuery("name", "实战2"));
			
			searchRequest.source(searchSourceBuilder);
		
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			System.out.println(searchHits.length);
			for(SearchHit hit: searchHits) {
				String sourceAsString = hit.getSourceAsString();
				System.out.println(sourceAsString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
