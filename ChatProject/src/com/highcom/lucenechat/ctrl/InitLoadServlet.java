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

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.highcom.lucenechat.bean.WordBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 初始化分词索引库的servlet,将此servlet作为首页index.jsp,创建好分词索引库然后转发会聊天室页面
 * @author asus-pc
 *
 */
@WebServlet("/index.jsp")
public class InitLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取项目绝对路径
		String jsonPath=this.getServletConfig().getServletContext().getRealPath(File.separator+"LuceneJson"+File.separator+"word.json");
//		System.out.println(filePath);
		//通过文件流工具读取文件内容返回字符串
		String jsonFile = FileUtils.readFileToString(new File(jsonPath), "UTF-8");
		System.out.println(jsonFile);
		//将字符串转化为json对象
		JSONObject jo = JSONObject.fromObject(jsonFile);
		JSONArray ja = JSONArray.fromObject(jo.get("wordbase"));
		ArrayList<WordBean> relist = new ArrayList<WordBean>();
		for (int i = 0; i < ja.size(); i++) {
			WordBean bean = new WordBean();
			JSONObject keyJo = JSONObject.fromObject(ja.get(i));
			bean.setKey(keyJo.getString("key"));
			bean.setText(keyJo.getString("text"));
			relist.add(bean);
		}
		jzsyzyk(relist);
		request.getRequestDispatcher("communication.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 加载索引资源库的方法
	 * 
	 * @param reList
	 *            获得的数据库信息容器
	 * @throws IOException
	 */
	private void jzsyzyk(ArrayList<WordBean> reList) throws IOException
		{
			// 建立索引资源库
			// System.out.println("文件地址");
			String indexFilePath = this.getServletConfig().getServletContext().getRealPath("/"+File.separator+"LuceneIndex");
			System.out.println(indexFilePath);
			File file = new File(indexFilePath);
			// System.out.println("建立地址");
			Directory directory = FSDirectory.open(Paths.get(indexFilePath));
			// System.out.println("分词器");
			Analyzer analyzer = new IKAnalyzer();
			// System.out.println("加入分词器");
			IndexWriterConfig donfig = new IndexWriterConfig(analyzer);
			// System.out.println("封装索引库");
			IndexWriter index = new IndexWriter(directory, donfig);

			File[] f = file.listFiles();
			// System.out.println(f.length);
			// 读入数据进入索引资源库
			if (f.length <= 1)
				{
					// System.out.println("hello!");
					for ( WordBean bean : reList )
						{
							// System.out.println(bean);
							Document document = new Document();
							String bean_key = bean.getKey();
							Field keyField = new TextField("key", bean_key, Store.YES);
							// keywords
							String bean_text = bean.getText();
							Field textField = new StoredField("text", bean_text);
							// System.out.println(keywordsField);
							document.add(keyField);
							document.add(textField);
							index.addDocument(document);
							System.out.println(document);
						}
				}
			index.close();
			System.out.println("============================加载lucene索引库成功==========================");
		}

	public Field addField(String field, String bean)
		{
			if (bean != null)
				{
					return new StoredField(field, bean);
				}
			else
				{
					return new StoredField(field, "");
				}
		}
	
	
}
