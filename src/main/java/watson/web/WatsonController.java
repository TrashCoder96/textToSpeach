package watson.web;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by asus-pc on 05.11.2016.
 */

@Controller
public class WatsonController {

    @Autowired
    private TextToSpeech textToSpeech;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/send", method = { RequestMethod.POST, RequestMethod.GET }, produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public HttpEntity<byte[]> send(@RequestParam(value = "text") String text) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = textToSpeech.synthesize(text, "audio/ogg; codecs=opus");
            byte[] bytes = toBytes(in);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("audio", "ogg"));
            headers.setContentLength(bytes.length);
            return new HttpEntity<byte[]>(bytes, headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] toBytes(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        buffer.close();
        return buffer.toByteArray();
    }

}
