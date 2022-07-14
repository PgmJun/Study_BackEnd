package heloo.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(param -> System.out.println(param + "=" + request.getParameter(param)));

        System.out.println("[전체 파라미터 조회] - end\n");

        System.out.println("[단일 파라미터 조회] - start");

        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String age = request.getParameter("age");
        System.out.println("age = " + age);

        System.out.println("[단일 파라미터 조회] - end\n");

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");

        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        System.out.println("[이름이 같은 복수 파라미터 조회] - end\n");

        response.getWriter().write("ok");
    }
}
