package HttpMessageConverter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import bean.DemoObj;
/**
 * HttpMessageConverter 是用来处理request 和 response 里的数据的
 * */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj>{

	public MyMessageConverter() {
		//定义一个自定义的媒体类型
		super(new MediaType("application","x-wisely",Charset.forName("utf-8")));
	}
	
	// 这个方法表明，此类只处理DemoObj这个类
	@Override
	protected boolean supports(Class<?> clazz) {
		//isAssignableFrom 判断两个类是不是相同类型，或者子类
		return DemoObj.class.isAssignableFrom(clazz);
	}

	/**
	 * 重写readIntenal 方法，处理请求的数据。
	 * */
	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("utf-8"));
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]),tempArr[1]);
	}

	//处理如何输出数据到response
	@Override
	protected void writeInternal(DemoObj t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello:" + t.getId() + "-" + t.getName() ;
		outputMessage.getBody().write(out.getBytes());
	}

}
