package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 각 컨트롤러에서 FrontController 로 View 를 리턴해주는 방식
public interface ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
