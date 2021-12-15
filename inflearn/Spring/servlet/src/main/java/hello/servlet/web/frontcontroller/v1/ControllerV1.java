package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 매핑된 컨트롤러에서 바로 뷰를 호출하는 방식
public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
