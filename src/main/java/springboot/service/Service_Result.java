package springboot.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class Service_Result {

    public void save_img(MultipartFile image) throws IOException {
        String imgName = "test.jpg";
        File upl = new File("/Users/jungwook/IdeaProjects/capstone_project/src/main/resources/images", imgName);
        upl.createNewFile();
        FileOutputStream fout = new FileOutputStream(upl);
        fout.write(image.getBytes());
        fout.close();
    }
    public void save_txt(MultipartFile image) throws IOException {
        String imgName = "test.txt";
        File upl = new File("/Users/jungwook/IdeaProjects/capstone_project/src/main/resources/text", imgName);
        upl.createNewFile();
        FileOutputStream fout = new FileOutputStream(upl);
        fout.write(image.getBytes());
        fout.close();
    }
    public void Service_Result(){}
}
