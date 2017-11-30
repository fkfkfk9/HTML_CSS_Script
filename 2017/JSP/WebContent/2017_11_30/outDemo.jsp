<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
	int bufferSize = out.getBufferSize(); //현재 버퍼크기
	int remainSize = out.getRemaining(); //남은 버퍼크기
	int usedBuffer = bufferSize - remainSize; //사용 가능한 버퍼크기
%>
<h2>out 예제</h2>
<p><b>버퍼 사용현황</b></p><br>
<%--<% out.clearBuffer(); %> 버퍼가 비워져서 위의 출력문들이 날라감 --%>
<p>현재 버퍼 크기 : <% out.println(bufferSize);%>byte</p><br>
<p>남은 버퍼 크기 : <% out.println(remainSize);%></p><br>
<p>사용 가능한 버퍼의 크기 : <% out.println(usedBuffer);%>byte</p>