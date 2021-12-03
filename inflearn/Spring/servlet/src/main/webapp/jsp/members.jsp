<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository=MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
 <meta charset="UTF-8">
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    <tbody>
    <%
    for (Member member : members) {
                out.write("    <tr>");
                out.write("        <td>"+member.getId()+"</td>");
                out.write("        <td>"+member.getUsername()+"</td>");
                out.write("        <td>"+member.getAge()+"</td>");
                out.write("    </tr>");
            }
    %>
    </tbody>
</body>
</html>