package com.highcom.lucenechat.ctrl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.highcom.lucenechat.bean.WordBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@WebServlet("/talk.do")
public class TalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String keywords = null;
		JSONObject keyObject = null;
		try
			{
				keywords = request.getParameter("info");
				//调用查询分词方法返回结果集
				ArrayList<WordBean> result = getResult(keywords);
				System.out.println(keywords);
				//查看结果集是否有结果
				if (result.size()>0) {
					//随机获取多个结果集中的一个结果(bean对象)
					keyObject = JSONObject.fromObject(result.get((int)(Math.random()*(result.size()))));
					//System.out.println("测试json:" + keyObject);
					
					//将结果集中的多个回复文本(text)进行拆分(" "),
					String[] strArr = keyObject.getString("text").split(" ");
					JSONObject jo = new JSONObject();
					
					//获取拆分回复文本中的一个兵制作成JSONObject对象传回ajax
					jo.put("text", strArr[(int)(Math.random()*(strArr.length))]);
					response.setContentType("text/html;charset=UTF-8");
					System.out.println(jo);
					response.getWriter().write(jo.toString());
				}
			}
		catch (Exception e)
			{

				// TODO Auto-generated catch block
				e.printStackTrace();

			}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**查询分词方法:
	 * 将用户传来的消息进行分词并到分词库中搜索对应的结果,将结果封装入bean对象,将一个或多个结果bean对象装入ArrayList集合中并返回ArrayList<wordBean>的方法
	 * @param keywords 用户传来的消息字符串
	 * @return 返回结果集ArrayList<WordBean>对象
	 * @throws Exception
	 */
	private ArrayList<WordBean> getResult(String keywords) throws Exception
	{
		String indexFilePath = this.getServletConfig().getServletContext().getRealPath("/"+File.separator+"LuceneIndex");
		Directory directory = FSDirectory.open(Paths.get(indexFilePath));
		IndexReader indexReader = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		QueryParser queryParser = new QueryParser("key", new IKAnalyzer());
		Query query = queryParser.parse(keywords);
		System.out.println(query+"/////"+query.toString());
		TopDocs topDocs = indexSearcher.search(query, 10);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		ArrayList<WordBean> resultList = new ArrayList<WordBean>();
		for ( ScoreDoc scoreDoc : scoreDocs )
			{
				WordBean search = new WordBean();
				int doc = scoreDoc.doc;
				Document document = indexSearcher.doc(doc);
				search.setKey(document.get("key"));
				search.setText(document.get("text"));
				resultList.add(search);
			}
		indexSearcher.getIndexReader().close();
		return resultList;
	}
	
	

}
