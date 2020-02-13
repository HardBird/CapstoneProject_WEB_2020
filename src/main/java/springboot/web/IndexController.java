package springboot.web;

        import lombok.RequiredArgsConstructor;
        import org.springframework.http.MediaType;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;
        import springboot.service.CounselorService;
        import springboot.service.PostsService;
        import springboot.service.Service_Result;
        import springboot.web.dto.Counselor.CounselorResponseDto;
        import springboot.web.dto.Posts.PostsResponseDto;

        import javax.servlet.http.HttpSession;
        import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final Service_Result service_result = new Service_Result();

    private final PostsService postsService;
    private final CounselorService counselorService;
    private final HttpSession httpSession;
    @GetMapping("/posts/index")
    public String posts_index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts-index";
    }

    @GetMapping("/")
    public String root(Model model) {
        return "main";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    @GetMapping(value = "/result",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
   public String predict(@RequestParam("image") MultipartFile image, Model model,
    @RequestParam("result") MultipartFile result) throws IOException {
        //System.out.println(image.getSize());
        //byte[] data = image.getBytes();
        service_result.save_img(image);
        service_result.save_txt(result);
        //model.addAttribute("image_PATH","/Users/jungwook/IdeaProjects/capstone_project/src/main/resources/images");
        return "result_img";
    }
    @GetMapping("/counselor/index")
    public String counselor_index(Model model) {
        model.addAttribute("counselor", counselorService.findAllDesc());
        return "counselor-index";
    }
    @GetMapping("/counselor/save")
    public String counselorSave() {
        return "counselor-save";
    }

    @GetMapping("/counselor/update/{id}")
    public String counselorUpdate(@PathVariable Long id, Model model) {
        CounselorResponseDto dto = counselorService.findById(id);
        model.addAttribute("counselor", dto);

        return "counselor-update";
    }
}