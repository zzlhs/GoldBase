package com.zzl.es.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * eleasticSearch的基础使用
 * @author zyf
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientBaseTest {
	HttpHost[] hosts = {new HttpHost("127.0.0.1", 9200)};
	private RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(hosts));
	
	
	@Test
	public void createIndex() throws IOException {
		HttpHost[] hosts = {new HttpHost("127.0.0.1", 9200)};
		RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(hosts));
		
		CreateIndexRequest createIndexRequest = new CreateIndexRequest("zzl_08232");
		
		createIndexRequest.settings(Settings
										.builder());
//										.put("number_of_shards", 5)
//										.put("number_of_replicas", 1));
		
		createIndexRequest.mapping("doc", "{\r\n" + 
				"   \"properties\": {\r\n" + 
				"       \"name\": {\r\n" + 
				"           \"type\": \"text\",\r\n" + 
				"           \"analyzer\": \"ik_max_word\",\r\n" + 
				"           \"search_analyzer\": \"ik_smart\",\r\n" + 
				"           \"index\": true,\r\n" + 
				"           \"store\": false\r\n" + 
				"       },\r\n" + 
				"       \"description\": {\r\n" + 
				"           \"type\": \"text\",\r\n" + 
				"           \"analyzer\": \"ik_max_word\",\r\n" + 
				"           \"search_analyzer\": \"ik_smart\"\r\n" + 
				"       },\r\n" + 
				"       \"pic\": {\r\n" + 
				"           \"type\": \"text\",\r\n" + 
				"           \"index\": false\r\n" + 
				"       },\r\n" + 
				"       \"studymodel\": {\r\n" + 
				"           \"type\": \"keyword\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}",XContentType.JSON);
		
		IndicesClient indicesClient = restHighLevelClient.indices();
		CreateIndexResponse createIndexResponse = indicesClient.create(createIndexRequest);
		boolean ackonwledge = createIndexResponse.isAcknowledged();
		System.out.println("创建成功吗  -> " + ackonwledge);
	}
	
	@Test
	public void deleteIndex() {
		DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("zzl_08232");
		
		try {
			DeleteIndexResponse deleteIndexResponse = restHighLevelClient.indices().delete(deleteIndexRequest);
			boolean acknowledge = deleteIndexResponse.isAcknowledged();
			System.out.println("------------------");
			System.out.println(acknowledge);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void addDoc() {
		try {
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("name", "spring cloud实战2");
			jsonMap.put("description", "本课程12342");
			jsonMap.put("studymodel", "2010012");
			jsonMap.put("pic", "hhhhhhhhhh2");
			
			IndexRequest indexRequest = new IndexRequest("zzl_08232", "doc");
			indexRequest.source(jsonMap);
			IndexResponse indexResponse = restHighLevelClient.index(indexRequest);
			DocWriteResponse.Result result = indexResponse.getResult();
			
			System.out.println("------------------");
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getDoc() {
		try {
			GetRequest getRequest = new GetRequest("zzl_08232", "doc", "KkP7G3QBc8JTtJwfQ0g0");
			GetResponse getResponse = restHighLevelClient.get(getRequest);
			boolean exists = getResponse.isExists();
			
			Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
			
			System.out.println("------------------");
			System.out.println(sourceAsMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateDoc() {
		try {
			UpdateRequest updateRequest = new UpdateRequest("zzl_08232", "doc", "KkP7G3QBc8JTtJwfQ0g0");
			Map<String, String> map = new HashMap<>();
			map.put("name", "spring cloud实战修改");
			updateRequest.doc(map);
		 
			UpdateResponse updateResponse = restHighLevelClient.update(updateRequest);
			System.out.println(updateResponse.status());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
