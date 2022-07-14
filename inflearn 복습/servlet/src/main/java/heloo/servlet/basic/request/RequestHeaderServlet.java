package heloo.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtil(req);
        printEtc(req);
    }

    private void printStartLine(HttpServletRequest req) {
        String method = req.getMethod();
        System.out.println("method = " + method);   //GET
        String protocol = req.getProtocol();
        System.out.println("protocol = " + protocol);   //HTTP/1.1
        String scheme = req.getScheme();
        System.out.println("scheme = " + scheme);   //http

        // http://localhost:8080/request-header
        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        // /request-header
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        // username=hi
        System.out.println("req = " + req.getQueryString());

        System.out.println("req.isSecure() = " + req.isSecure());   //https 사용유무
        System.out.println("=== REQUEST-LINE - end ===");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest req){
        System.out.println("===== Headers - start =====");

        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println("headerName = " + headerName);
        }

        System.out.println("===== Headers - end =====\n");

    }

    private void printHeaderUtil(HttpServletRequest request){
        System.out.println("===== Headers 편의 조회 - start =====");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accpet-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if(request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println("cookie.getValue() = " + cookie.getValue());
            }
        }

        System.out.println("===== Headers 편의 조회 - end=====\n");
    }

    private void printEtc(HttpServletRequest req){
        System.out.println("===== 기타 조회 - start=====\n");

        System.out.println("[Remote 정보]");
        System.out.println("req.getRemoteHost() = " + req.getRemoteHost());
        System.out.println("req.getRemoteHost() = " + req.getRemoteAddr());
        System.out.println("req.getRemoteHost() = " + req.getRemotePort());


        System.out.println("[Local 정보]");
        System.out.println("req.getRemoteHost() = " + req.getLocalName());
        System.out.println("req.getRemoteHost() = " + req.getLocalAddr());
        System.out.println("req.getRemoteHost() = " + req.getLocalPort());

        System.out.println("===== 기타 조회 - end=====\n");
    }
}
